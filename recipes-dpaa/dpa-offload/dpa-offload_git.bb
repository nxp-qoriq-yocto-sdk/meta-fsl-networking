DESCRIPTION = "Data-Path Acceleration Architecture Offloading User-Space Drivers"
LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c03ebb7a330b209986517466c74da72c"

inherit pkgconfig

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "usdpaa"
DEPENDS_append_b4860qds = " ipc-ust"
DEPENDS_append_b4420qds = " ipc-ust"

RDEPENDS_${PN} = "libgcc bash"

SRC_URI = "${URL-DPA-OFFLOAD}"
SRCREV = "${SHA-DPA-OFFLOAD}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" LD="${LD}"'
export ARCH="${TARGET_ARCH}"

PARALLEL_MAKE_pn-${PN} = ""

do_compile_prepend () {
    export USDPAA_CFLAGS="-I ${STAGING_INCDIR}/usdpaa"
}

do_install () {
    oe_runmake install DESTDIR=${D}
}

ALLOW_EMPTY_${PN} = "1"

COMPATIBLE_HOST_qoriq-ppc = ".*"
COMPATIBLE_HOST ?= "(none)"
