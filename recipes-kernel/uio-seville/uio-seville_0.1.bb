DESCRIPTION = "UIO driver for T1040 L2 Switch"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

SRC_URI = "${URL-L2SWITCH}"
SRCREV = "${SHA-L2SWITCH}"

COMPATIBLE_MACHINE = "(t1040qds|t1040rdb)"

inherit module

S = "${WORKDIR}/git/uio-driver"