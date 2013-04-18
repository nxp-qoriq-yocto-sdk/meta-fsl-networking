DESCRIPTION = "Diagnostic binary"
SECTION = "Diagnostic"
LICENSE = "Freescale EULA"
LIC_FILES_CHKSUM = "file://README;md5=2732f100f6a00868f0cdb02065bc8f00"

PR = "r1"

DIAGNOSTIC_INSTALL_FILE = "diagnostic"
DIAGNOSTIC_INSTALL_FILE_append_mpc8536ds = "-mpc8536ds"
DIAGNOSTIC_INSTALL_FILE_append_mpc8544ds = "-mpc8544ds"
DIAGNOSTIC_INSTALL_FILE_append_mpc8572ds = "-mpc8572ds"

COMPATIBLE_MACHINE = "(mpc8572ds|mpc8544ds|mpc8536ds)"

inherit deploy

SRC_URI = "git://git.am.freescale.net/gitolite/users/b28495/diagnostic.git"
SRCREV= "34182d0e8472fc649efd308b4f9b41e587bed333"

S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"
do_install () {
	install -d ${D}/boot
	install -m 644 ${DIAGNOSTIC_INSTALL_FILE}.bin ${D}/boot/diagnostic.bin
}

do_deploy () {
	install -d ${DEPLOYDIR}/boot
	install -m 644 ${DIAGNOSTIC_INSTALL_FILE}.bin ${DEPLOYDIR}/boot/diagnostic.bin
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/boot"

