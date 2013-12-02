DESCRIPTION = "Edink binary"
SECTION = "Edink"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://README;md5=ce68f8c5240ace21f5880b4c29662394"

inherit deploy

SRC_URI = "git://git.am.freescale.net/gitolite/users/b28495/edink.git"
SRCREV= "f51b9cefb13e21baddf4209316e11b178e76db4c"

PVBASE := "0.0"
PV := "${PVBASE}+git${SRCPV}"
S = "${WORKDIR}/git"

EDINK_INSTALL_FILE = "edink"
EDINK_INSTALL_FILE_append_mpc8536ds = "-mpc8536ds"
EDINK_INSTALL_FILE_append_mpc8544ds = "-mpc8544ds"
EDINK_INSTALL_FILE_append_mpc8572ds = "-mpc8572ds"
EDINK_INSTALL_FILE_append_p1022ds = "-p1022ds"

do_install () {
	install -d ${D}/boot
	install -m 644 ${EDINK_INSTALL_FILE}.bin ${D}/boot/edink.bin
}

do_deploy () {
	install -d ${DEPLOYDIR}/boot
	install -m 644 ${EDINK_INSTALL_FILE}.bin ${DEPLOYDIR}/boot/edink.bin
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/boot"
ALLOW_EMPTY_${PN} = "1"
COMPATIBLE_MACHINE = "(p1022ds|mpc8572ds|mpc8544ds|mpc8536ds)"

