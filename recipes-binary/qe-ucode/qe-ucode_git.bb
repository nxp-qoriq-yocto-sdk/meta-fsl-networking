DESCRIPTION = "qe microcode binary"
SECTION = "qe-ucode"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://README;md5=2bd6b1f0a347695faf3f841714698b7d"

PR = "r3"

COMPATIBLE_MACHINE = "(p1025rdb|p1021rdb|p1025twr)"

inherit deploy

SRC_URI = "git://git.am.freescale.net/gitolite/users/b28495/qe-ucode.git"
SRCREV= "a19b51c939179be0975a564c2b3c9130351b65d4"

QE_BINARY_NAME = "fsl_qe_ucode_1021_10_A.bin"
S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"
do_install () {
	install -d ${D}/
	install -m 644 ${QE_BINARY_NAME} ${D}/
}

do_deploy () {
	install -d ${DEPLOYDIR}/
	install -m 644 ${QE_BINARY_NAME} ${DEPLOYDIR}/
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/*"

