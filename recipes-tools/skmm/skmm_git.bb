DESCRIPTION = "SKMM application for PCIe endpoint"
SECTION = "skmm"
LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;endline=30;md5=39e58bedc879163c9338596e52df5b1f"

PR = "r2"

DEPENDS = "libedit"

SRC_URI = "${URL-SKMM}"
SRCREV = "${SHA-SKMM}"

COMPATIBLE_MACHINE = "(p4080ds)"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'V=1 MACHINE=${MACHINE}'

do_compile_prepend () {
	export ARCH=${TARGET_ARCH}
	export LIBEDIT_CFLAGS="$(pkg-config --cflags libedit)"
	export LIBEDIT_LDFLAGS="$(pkg-config --libs --static libedit)"
}

do_install () {
	oe_runmake ARCH=${TARGET_ARCH} install DESTDIR=${D}
}

FILES_${PN} += "/home/root/.skmm/*"
