DESCRIPTION = "DSP boot application and ipc test application"
SECTION = "ipc"
LICENSE = "BSD"
PR = "r3"

# no COPYING file in current git tree, need to be fixed
LIC_FILES_CHKSUM = "file://ipc/include/fsl_psc913x_ipc.h;endline=32;md5=d0a14504b423614b4bf9c658962de585"

DEPENDS = "virtual/kernel"

SRCREV = "0458764d0df732b56ed0f59ae44f42686d31f7ed"
SRC_URI = " git://git.am.freescale.net/gitolite/psc913x/ipc.git;protocol=git \
"

S = "${WORKDIR}/git"
EXTRA_OEMAKE="CROSS_COMPILE=${TARGET_PREFIX} KERNEL_DIR=${STAGING_KERNEL_DIR}"

# workaround for issue of parallel build, required a actual fix in ipc source
PARALLEL_MAKE = ""

do_compile(){
    oe_runmake -C dsp_boot
    oe_runmake -C fsl_shm
    oe_runmake -C ipc
}

do_install(){
    install -d ${D}${bindir}
    install -m 755 ${S}/dsp_boot/dsp_bt ${D}${bindir}
    install -m 755 ${S}/ipc/ipc_test ${D}${bindir}
    install -m 755 ${S}/ipc/ipc_test67 ${D}${bindir}
    install -m 755 ${S}/fsl_shm/app ${D}${bindir}/lg_shm_test
    install -d ${D}${libdir}
    install -m 755 ${S}/ipc/libipc.so ${D}${libdir}
    install -m 755 ${S}/ipc/libmem.so ${D}${libdir}
    install -d ${STAGING_INCDIR}/ipc
    install -d ${STAGING_INCDIR}/ipc/ipc/include
    install -d ${STAGING_INCDIR}/ipc/fsl_shm/lib
    install ${S}/ipc/include/*.h ${STAGING_INCDIR}/ipc/ipc/include
    install ${S}/fsl_shm/include/*.h ${STAGING_INCDIR}/ipc/ipc/include
    install ${S}/fsl_shm/lib/*.h ${STAGING_INCDIR}/ipc/fsl_shm/lib
}

