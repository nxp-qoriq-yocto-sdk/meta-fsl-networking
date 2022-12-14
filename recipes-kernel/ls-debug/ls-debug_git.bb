DESCRIPTION = "Layerscape Debug File System Module"
SECTION = "ls-debug"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94263f12f9416f9fd0493c8f9e8085a3"

inherit module autotools

SRCBRANCH = "master"
SRC_URI = "git://git.freescale.com/ppc/sdk/ls-dbg.git;branch=${SRCBRANCH}"
SRCREV = "40501f6659e880d38508cdd34a4df2d348d1c68e"

COMPATIBLE_MACHINE = "(ls1021aqds|ls1021atwr)"

S = "${WORKDIR}/git"

EXTRA_OECONF += "--with-linux=${STAGING_KERNEL_DIR}"
EXTRA_OEMAKE += 'SYSROOT="${D}"'
