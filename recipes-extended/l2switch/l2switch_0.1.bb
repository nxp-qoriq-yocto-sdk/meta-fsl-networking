SUMMARY = "T1040 L2 Switch"
DESCRIPTION = "Control application sample, headers and library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://src/Freescale_Software_License.txt;md5=abef45971875a174b40d565215cdf4d9 \
		file://include/COPYING;md5=7018bb7bacb48a72a2acbf999cf7d25a"

RCONFLICTS_${PN} = "smbstax"

inherit cmake update-rc.d

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/l2switch-util.git;branch=master"
SRCREV = "a88e6da575df8172a6577450a058c64ab92835c5"

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
COMPATIBLE_MACHINE = "(t1040qds|t1040qds-64b|t1040rdb|t1040rdb-64b)"
