DESCRIPTION = "qe microcode binary"
SECTION = "qe-ucode"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://${COREBASE}/../meta-fsl-ppc/custom-licenses/Freescale-EULA;md5=bf20d39b348e1b0ed964c91a97638bbb"

inherit deploy

SRC_URI = "git://git.am.freescale.net/gitolite/users/r63061/qe-ucode.git"
SRCREV= "35aeff0daa55988dd98e32913c28f61923d0b100"

PVBASE := "0.0"
PV := "${PVBASE}+git${SRCPV}"
S = "${WORKDIR}/git"

do_install () {
	case ${MACHINE} in
	    p1025rdb|p1021rdb|p1025twr) QE_UCODE="fsl_qe_ucode_1021_10_A.bin";;
	    t1040rdb|t1040rdb-64b) QE_UCODE="iram_Type_A_T1040_r1.0.bin";;
	    *) QE_UCODE="";;
	esac
	install -d ${D}/
	install -m 644 ${QE_UCODE} ${D}/
}

do_deploy () {
	case ${MACHINE} in
	    p1025rdb|p1021rdb|p1025twr) QE_UCODE="fsl_qe_ucode_1021_10_A.bin";;
	    t1040rdb|t1040rdb-64b) QE_UCODE="iram_Type_A_T1040_r1.0.bin";;
	    *) QE_UCODE="";;
	esac
	install -d ${DEPLOYDIR}/
	install -m 644 ${QE_UCODE} ${DEPLOYDIR}/
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/*"
ALLOW_EMPTY_${PN} = "1"
COMPATIBLE_MACHINE = "(p1025rdb|p1021rdb|p1025twr|t1040rdb|t1040rdb-64b)"

