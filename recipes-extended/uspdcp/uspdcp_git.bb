DESCRIPTION = "SEC user space driver package"
SECTION = "uspdcp"
LICENSE = "BSD GPLv2"

# no COPYING file in current git tree, need to be fixed
LIC_FILES_CHKSUM = "file://Makefile;endline=30;md5=83b6209ab517640a7390536a08d33609"

DEPENDS += "virtual/kernel ipc"

SRCREV = "deb42f075478a7eee0353552a7c6cd809c3955cc"
SRC_URI = "git://git.am.freescale.net/gitolite/psc913x/uspdcp.git"

PVBASE := "0.0"
PV = "${PVBASE}+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE="CROSS_COMPILE=${TARGET_PREFIX} IPC_DIR=${STAGING_INCDIR}/ipc KERNEL_DIR=${STAGING_KERNEL_DIR}"

install(){
    oe_runmake install DESTDIR=${D}
}
