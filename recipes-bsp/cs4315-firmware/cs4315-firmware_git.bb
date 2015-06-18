DESCRIPTION = "Firmware image for the Cortina CS4315 PHY"
LICENSE = "Cortina"
LIC_FILES_CHKSUM = "file://Cortina-EULA;md5=ef3a0b9eaf40547d263a4f67040dc56e"

inherit deploy

SRC_URI = "git://git.am.freescale.net/gitolite/users/r63061/firmware.git"
SRCREV = "ad5a3108f9ede39ea41fde18d4ac0cc7680cf650"

S = "${WORKDIR}/git"

UCODE_t1023 = "AQ28nm-FW_2.0.B3_Freescale_T1024RDB_120514.cld"
UCODE_t1024 = "AQ28nm-FW_2.0.B3_Freescale_T1024RDB_120514.cld AQ28nm-FW_2.0.B9_Freescale_T1024RDB_012115.cld"
UCODE_t2080 = "cs4315-cs4340-PHY-ucode.txt Firmware_1.37.10_011014_Freescale_T2080PCIe.cld"
UCODE_t4240 = "cs4315-cs4340-PHY-ucode.txt"
do_install () {
    install -d ${D}/boot
    for name in ${UCODE};do
        install -m 644 ${S}/$name ${D}/boot/
    done
}

do_deploy () {
    install -d ${DEPLOYDIR}/
    for name in ${UCODE};do
        install -m 644 ${S}/$name ${DEPLOYDIR}/
    done
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/boot"
COMPATIBLE_MACHINE = "(t1023rdb|t1024rdb|t2080rdb|t4240rdb)"
