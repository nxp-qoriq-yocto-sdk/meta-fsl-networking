DESCRIPTION = "Non-DPAA software Application Specific Fast-path"
SECTION = "libppc"
LICENSE = "GPLv2"
PR = "r6"
LIC_FILES_CHKSUM = "file://COPYING;md5=9960b017720861b8c50c8c08723e57aa"

SRCREV = "8d306705c0c2917cc39642b325ef53234f0e0dbf"
SRC_URI = "git://git.am.freescale.net/gitolite/asf.git"

DEPENDS="virtual/kernel"

inherit module

S = "${WORKDIR}/git/asfmodule"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} KERNEL_PATH=${STAGING_KERNEL_DIR}"

do_install(){
	mkdir -p ${D}/usr/driver/asf
	cp ${S}/asfffp/driver/asf.ko ${D}/usr/driver/asf
	cp ${S}/asfipsec/driver/asfipsec.ko ${D}/usr/driver/asf
	cp ${S}/asffwd/driver/asffwd.ko ${D}/usr/driver/asf
	cp ${S}/asfctrl/linux/ffp/asfctrl.ko ${D}/usr/driver/asf
	cp ${S}/asfctrl/linux/fwd/asfctrl_fwd.ko ${D}/usr/driver/asf
	cp ${S}/asfctrl/linux/ipsec/asfctrl_ipsec.ko ${D}/usr/driver/asf
	cp -rf ${S}/../scripts ${D}/usr/driver/asf/.
}

FILES_${PN} += "/usr/driver/asf"
INHIBIT_PACKAGE_STRIP = "1"
