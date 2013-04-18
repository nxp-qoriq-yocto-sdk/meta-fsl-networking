DESCRIPTION = "RF support libraries and applications"
SECTION = "rf-util"
LICENSE = "GPL"
PR = "r0"

LIC_FILES_CHKSUM = "file://license.txt;md5=fa38cd73d71527dc6efb546474f64d10"

SRC_URI = "file://${PN}-${PV}.tar.gz \
"
SRC_URI[md5sum] = "e0b3a74c20bf65a075a5199dbaa4144"
SRC_URI[sha256sum] = "6c027f608645f45b6297f50fedced6fdd2f2c9f74668f539020a87b6a479f67a"

inherit autotools

EXTRA_OEMAKE=" 'CC=${CC}' 'AR=${AR}' KERNEL_DIR=${STAGING_KERNEL_DIR} \
               INSTALL_DIR=${D}/${PN} CONFIG_DIR=${D}/${PN}/config"

FILES_${PN} += "/${PN}/*"
