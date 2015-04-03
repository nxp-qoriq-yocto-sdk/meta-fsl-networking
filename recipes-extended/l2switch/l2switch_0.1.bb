SUMMARY = "T1040 L2 Switch"
DESCRIPTION = "Control application sample, headers and library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://Freescale_Software_License.txt;md5=704b1b597270faff2faf4fafb308c947 \
		file://include/COPYING;md5=7018bb7bacb48a72a2acbf999cf7d25a"

RCONFLICTS_${PN} = "smbstax"

inherit cmake update-rc.d

SRC_URI = "${URL-L2SWITCH-UTIL}"
SRCREV = "${SHA-L2SWITCH-UTIL}"

S = "${WORKDIR}/git"

export SYSROOT = "${STAGING_DIR_TARGET}"

PACKAGES =+ "libvtss_api libvtss_api-dev"
FILES_${PN} += "${bindir}/l2sw_bin \
        ${bindir}/l2switch-cfg \
        /etc/init.d/l2switch \
        /etc/sysconfig/l2switch \
"
FILES_libvtss_api= "${libdir}/*.so.*"
FILES_libvtss_api-dev = "${libdir}/*.so \
        ${includedir}/*"

INITSCRIPT_NAME = "l2switch"
INITSCRIPT_PARAMS = "defaults 10 85"

INSANE_SKIP_${PN} = 'already-stripped'
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
COMPATIBLE_MACHINE = "(t1040d4rdb|t1040d4rdb-64b|t1040qds|t1040qds-64b|t1040rdb|t1040rdb-64b|t1042rdb|t1042rdb-64b)"
