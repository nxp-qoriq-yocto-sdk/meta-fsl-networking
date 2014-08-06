DESCRIPTION = "Support for writing file to devices connected on I2C bus"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/i2c-flash-util.git"
SRCREV = "baa50fecb0ef46cdb073c26bbd0df30066fb2520"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" LD="${CC}"'

do_install(){
    oe_runmake PREFIX=${D}/usr/sbin install
}

FILES_${PN} += "/usr/sbin/i2c_flash_util/*"
