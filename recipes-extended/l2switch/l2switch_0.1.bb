SUMMARY = "T1040 L2 Switch"
DESCRIPTION = "Control application sample, headers and library"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://src/Freescale_Software_License.txt;md5=abef45971875a174b40d565215cdf4d9 \
		file://include/COPYING;md5=d116128d49d9015ae61a9a5263dc475d"

inherit cmake

SRC_URI = "${URL-L2SWITCH-UTIL}"
SRCREV = "${SHA-L2SWITCH-UTIL}"

COMPATIBLE_MACHINE = "(t1040qds|t1040rdb|t1040rdb-64b)"

S = "${WORKDIR}/git"

export SYSROOT     = "${STAGING_DIR_TARGET}"

PACKAGES = "${PN} ${PN}-lib vtss-api"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

FILES_${PN} = "${bindir}/l2sw_bin \
        ${bindir}/l2switch-cfg \
        /etc/init.d/l2switch \
        /etc/sysconfig/l2switch \
        "

FILES_${PN}-lib = "${libdir}/*"

FILES_vtss-api = "${includedir}/*"
