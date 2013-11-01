DESCRIPTION = "Support for writing file to devices connected on I2C bus"
SECTION = "i2c-flash-util"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "file://i2c_flash_util-1.0.0.tar.bz2 \
"
SRC_URI[md5sum] = "f5ebb922bbcf118184fb5c6a443463db"
SRC_URI[sha256sum] = "c9edb7da9d3cbd985dafe411c3ad0674db1c489dd625fe00b48248f43f042f51"

S= "${WORKDIR}/i2c_flash_util-1.0.0"

EXTRA_OEMAKE = 'CC="${CC}" LD="${CC}"'

do_install(){
    oe_runmake PREFIX=${D}/usr/sbin install
}

FILES_${PN} += "/usr/sbin/i2c_flash_util/*"
