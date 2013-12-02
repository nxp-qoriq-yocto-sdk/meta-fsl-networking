SUMMARY = "Linux IPC Userspace Tool"
DESCRIPTION = "DSP boot application and ipc test application"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://COPYING;md5=fa38cd73d71527dc6efb546474f64d10"

DEPENDS = "virtual/kernel"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/ipc.git;branch=sdk_devel"
SRCREV = "cee9afc838693862f1fe8ae413b87bec12bc0423"

PVBASE := "0.0"
PV := "${PVBASE}+git${SRCPV}"
S = "${WORKDIR}/git"

# workaround for issue of parallel build, required a actual fix in ipc source
PARALLEL_MAKE = ""

EXTRA_OEMAKE = 'CROSS_COMPILE="${TARGET_PREFIX}" CC="${CC}" AR="${AR}"'

do_compile () {
    case ${MACHINE} in
        bsc9132qds|bsc9131rdb) SOC=B913x;;
        b4860qds) SOC=B4860;;
    esac
    oe_runmake ${SOC}=1
}

do_install () {
    install -d ${D}${bindir}
    install -d ${D}/ipc
    install -m 755 ${S}/dsp_boot/dsp_bt ${D}/ipc
    install -m 755 ${S}/ipc/ipc_test ${D}/ipc
    install -m 755 ${S}/ipc/ipc_test67 ${D}/ipc
    install -m 755 ${S}/ipc/l1d_app ${D}/ipc
    install -m 755 ${S}/fsl_shm/app ${D}${bindir}/lg_shm_test
    install -d ${D}/lib
    install -m 755 ${S}/ipc/libipc.so ${D}/lib
    install -m 755 ${S}/ipc/libmem.so ${D}/lib
    install -m 755 ${S}/ipc/libdspboot.so  ${D}/lib
    install -d ${STAGING_INCDIR}/ipc
    install -d ${STAGING_INCDIR}/ipc/ipc/include
    install -d ${STAGING_INCDIR}/ipc/fsl_shm/lib
    install ${S}/ipc/include/*.h ${STAGING_INCDIR}/ipc/ipc/include
    install ${S}/fsl_shm/include/*.h ${STAGING_INCDIR}/ipc/ipc/include
    install ${S}/fsl_shm/lib/*.h ${STAGING_INCDIR}/ipc/fsl_shm/lib
}

FILES_${PN} += "/ipc/*"
FILES_${PN}-dbg += "/ipc/.debug"

COMPATIBLE_MACHINE = "(bsc9132qds|bsc9131rdb|b4860qds)"
