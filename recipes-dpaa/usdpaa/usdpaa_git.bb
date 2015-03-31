DESCRIPTION = "User-Space Data-Path Acceleration Architecture Drivers"
LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;endline=30;md5=39e58bedc879163c9338596e52df5b1f"
PR = "r4"

inherit pkgconfig

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "flib"
DEPENDS_append_b4860qds = " ipc-ust"
DEPENDS_append_b4420qds = " ipc-ust"

RDEPENDS_${PN} = "libgcc bash"

SRC_URI = "${URL-DRIVERS}"
SRCREV = "${SHA-DRIVERS}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" LD="${LD}" AR="${AR}"'
export ARCH="${TARGET_ARCH}"

do_install () {
    oe_runmake install DESTDIR=${D}
}

PARALLEL_MAKE_pn-${PN} = ""

COMPATIBLE_HOST_qoriq-ppc = ".*"
COMPATIBLE_HOST ?= "(none)"
