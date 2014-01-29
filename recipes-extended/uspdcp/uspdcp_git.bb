DESCRIPTION = "SEC user space driver package"
SECTION = "uspdcp"
LICENSE = "BSD GPLv2"
PR = "r2"

DEPENDS += "flib usdpaa"

# no COPYING file in current git tree, need to be fixed
LIC_FILES_CHKSUM = "file://Makefile;endline=30;md5=83b6209ab517640a7390536a08d33609"

SRCREV = "5712af5e6ae024136fc542aa185e056b2c84892a"
SRC_URI = "git://git.am.freescale.net/gitolite/sdk/uspdcp.git;nobranch=1 \
"
S = "${WORKDIR}/git"

EXTRA_OEMAKE="EXTRA_DEFINE=USDPAA CROSS_COMPILE=${TARGET_PREFIX} SDK_DIR=${STAGING_DIR}/${MACHINE}"

do_install(){
    oe_runmake install DESTDIR=${D}
}
