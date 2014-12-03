DESCRIPTION = "Layerscape Debug File System Module"
SECTION = "ls-debug"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94263f12f9416f9fd0493c8f9e8085a3"

inherit module autotools

SRCBRANCH = "master"
SRC_URI = "git://git.am.freescale.net:8181/users/rat063/ls-dbg;protocol=http;branch=${SRCBRANCH}"
SRCREV = "777a7daad5e804a0b9046068967b76ece07a6af0"

COMPATIBLE_MACHINE = "(ls1021aqds|ls1021atwr)"

S = "${WORKDIR}/git"

EXTRA_OECONF += "--with-linux=${STAGING_KERNEL_DIR}"
EXTRA_OEMAKE += 'SYSROOT="${D}"'
