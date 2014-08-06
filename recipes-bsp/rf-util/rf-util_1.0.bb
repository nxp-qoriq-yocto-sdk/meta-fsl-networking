DESCRIPTION = "RF support libraries and applications"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://license.txt;md5=fa38cd73d71527dc6efb546474f64d10"

inherit autotools

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/rf-util.git;branch=wusdk_rel0"
SRCREV = "100cd910d2bbf5175fc0f37a40a431af27a1099d"

S = "${WORKDIR}/git"

EXTRA_OEMAKE=" 'CC=${CC}' 'AR=${AR}' KERNEL_DIR=${STAGING_KERNEL_DIR} \
               INSTALL_DIR=${D}/${PN} CONFIG_DIR=${D}/${PN}/config"

FILES_${PN} += "/${PN}/*"
