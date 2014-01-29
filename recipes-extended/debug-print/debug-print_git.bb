DESCRIPTION = "PSC913x debug print engine and user-space libraries"
SECTION = "debug_print"
LICENSE = "BSD"
PR = "r2"

# no COPYING file in current git tree, need to be fixed
LIC_FILES_CHKSUM = "file://memory_sharing/include/913x_pa_configuration_table.h;endline=32;md5=e7f330c6aa68fd4edde48d693e6709bb"

SRCREV = "106dac87c20849e7e0996a3dabbf5be12d00dd02"
SRC_URI = "git://git.am.freescale.net/gitolite/psc913x/debug_print.git"
S = "${WORKDIR}/git"

DEPENDS="virtual/kernel ipc"
PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_OEMAKE="CROSS_COMPILE=${TARGET_PREFIX} CC='${CC} ${LDFLAGS}' \
              KERNEL_DIR=${STAGING_KERNEL_DIR} IPC_DIR=${STAGING_INCDIR}/ipc"

do_install(){
    install -d ${D}${bindir}
    install -m 755 ${S}/engine/engine_rel ${D}${bindir}
    install -m 755 ${S}/pa_app/pa_app_rel ${D}${bindir}
    install -m 755 ${S}/test/host ${D}${bindir}
    install -d ${D}${libdir}
    install -m 755 ${S}/client_lib/libclient.so ${D}${libdir}
    install -m 755 ${S}/memory_sharing/libmemory_sharing.so ${D}${libdir}
}

FILES_${PN} += "/usr/lib/*"

