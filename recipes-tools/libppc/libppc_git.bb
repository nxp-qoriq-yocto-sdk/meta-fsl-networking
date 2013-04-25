DESCRIPTION = "optimized memcpy implementation"
SECTION = "libppc"
LICENSE = "Freescale-EULA"
PR = "r11"
LIC_FILES_CHKSUM = "file://Makefile;endline=21;md5=45d81c6e015ed7c8917e766ff1fd4499"

SRCREV = "${SHA-LIBPPC}"
SRC_URI = "${URL-LIBPPC}"
S = "${WORKDIR}/git/fsl_opt_lib"

do_configure_prepend () {
	# fix up Makefile
	sed -i 's/CC_M_FLAG += -te500mc/CC_M_FLAG +=/' ${S}/Makefile
	sed -i 's/LD_FLAGS += -te500mc/LD_FLAGS +=/' ${S}/Makefile
	sed -i 's/CC_M_FLAG += -te500v2/CC_M_FLAG +=/' ${S}/Makefile
	sed -i 's/LD_FLAGS += -te500v2/LD_FLAGS +=/' ${S}/Makefile
}

EXTRA_OEMAKE = 'COMPILE="${CC}" CC_M_FLAG=""'

ARCH_LIBPPC = ""
ARCH_LIBPPC_e5500-64b = "e500mc64"
ARCH_LIBPPC_e5500 = "e5500"
ARCH_LIBPPC_e500mc = "e500mc"
ARCH_LIBPPC_e500v2 = "e500v2"

do_compile () {
	oe_runmake ARCH=${ARCH_LIBPPC} ARCHS=${ARCH_LIBPPC}
}

do_install () {
	oe_runmake install DESTDIR=${D} LIBDIR=${libdir} ARCH=${ARCH_LIBPPC}
}

ALLOW_EMPTY_${PN} = "1"
RDEPEND_${PN} = "${PN}-dev"
