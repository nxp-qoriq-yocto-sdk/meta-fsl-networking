DESCRIPTION = "Firmware image for the Cortina CS4315 PHY"
## no license file, need to be fixed
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://${COREBASE}/../meta-fsl-ppc/custom-licenses/Freescale-EULA;md5=bf20d39b348e1b0ed964c91a97638bbb"

inherit deploy

SRC_URI = "git://git.am.freescale.net/gitolite/users/r63061/firmware.git"
SRCREV = "fd8b71334c14f3246654dd004f06116560f3e358"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}/boot
    install -m 644 ${S}/cs4315-cs4340-PHY-ucode.txt ${D}/boot/
}

do_deploy () {
    install -d ${DEPLOYDIR}/
    install -m 644 ${S}/cs4315-cs4340-PHY-ucode.txt ${DEPLOYDIR}/
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/boot"
COMPATIBLE_MACHINE = "(t2080rdb|t2080rdb-64b|t4240rdb|t4240rdb-64b)"
ALLOW_EMPTY_${PN} = "1"
