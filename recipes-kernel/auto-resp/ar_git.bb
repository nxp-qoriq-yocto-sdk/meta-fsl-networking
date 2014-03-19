DESCRIPTION = "Auto Response Control Module"
SECTION = "auto-resp"
LICENSE = "GPLv2 & BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=b5881ecf398da8a03a3f4c501e29d287"

DEPENDS="virtual/kernel"

inherit module

SRC_URI = "${URL-AUTO-RESP}"
SRCREV =  "${SHA-AUTO-RESP}"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
export KERNEL_PATH = "${STAGING_KERNEL_DIR}"

do_install(){
	mkdir -p ${D}/usr/driver/auto-resp
	cp -rf ${S}/bin ${D}/usr/driver/auto-resp
}

FILES_${PN} += "/usr/driver/auto-resp"
INHIBIT_PACKAGE_STRIP = "1"
