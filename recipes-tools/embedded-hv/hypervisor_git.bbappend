FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 2}"

SRC_URI = "${URL-HYPERVISOR};name=hypervisor \
        ${URL-KCONFIG};name=kconfig;destsuffix=git/kconfig \
        ${URL-LIBOS};name=libos;destsuffix=git/libos \
        ${URL-DTC};name=dtc;destsuffix=dtc \
        file://81-fsl-embedded-hv.rules \
         "

SRC_URI_append = " \
	${URL-HYPERTRK};name=hypertrk;destsuffix=git/hypertrk \
"

SRCREV_hypervisor = "${SHA-HYPERVISOR}"
SRCREV_kconfig = "${SHA-KCONFIG}"
SRCREV_libos = "${SHA-LIBOS}"
SRCREV_hypertrk = "${SHA-HYPERTRK}"

PKG_HV_HYPERTRK_SUPPORT = "n"

do_compile_prepend () {
    if [ "${PKG_HV_HYPERTRK_SUPPORT}" == "y" ]
    then
        oe_runmake silentoldconfig
        export HV_DIR=$PWD
        cd hypertrk
        oe_runmake deploy
        cd ..
    fi
}
