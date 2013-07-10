DESCRIPTION = "Firmware image for the VSC7385"
LICENSE = "Vitesse"
PR = "r3"
LIC_FILES_CHKSUM = "file://Readme_EULA.txt;md5=53894647eb55a1aa9e91fd6d93236b53"

inherit deploy

SRC_URI = "file://vsc7385-firmware-mpc8313erdb-2.tgz \
          "

do_deploy() {
    install -d ${DEPLOYDIR}/boot
    install ${S}/vsc2bin ${DEPLOYDIR}/boot/vsc-switch-firmware.bin
}
addtask deploy before do_build after do_install

SRC_URI[md5sum] = "da70490eefc814c7ea5031b6978ab336"
SRC_URI[sha256sum] = "ced64a9ee415a14d804fa24f9e5f3df72124debaf51ed6e7a811956b41926437"

ALLOW_EMPTY_${PN} = "1"
