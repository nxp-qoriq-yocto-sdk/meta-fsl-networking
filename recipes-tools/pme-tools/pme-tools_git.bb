DESCRIPTION = "Pattern matcher tools"
SECTION = "pme-tools"
LICENSE = "Freescale EULA"
PR = "r11"
LIC_FILES_CHKSUM = "file://COPYING;md5=f6bc49903590148d5df43337785b67cd"

EXCLUDE_FROM_WORLD_pn-pme-tools = "1"

SRCREV = "${SHA-PMETOOLS}"
SRC_URI = "${URL-PMETOOLS}"

S= "${WORKDIR}/git"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "ARCH=${TARGET_ARCH} USE_LTIB=1 LTIB_LIB_PATH=${STAGING_LIBDIR} SYSROOT=${STAGING_DIR_TARGET} CROSS_COMPILE=\"${HOST_PREFIX}\""
EXTRA_CFLAGS = "-Wno-unused-but-set-parameter -Wno-enum-compare -Wno-unused-but-set-variable"
do_compile_prepend () {
	oe_runmake clean
}

do_install () {
 	install -m 755 -d ${D}${bindir} -d ${D}${libdir} -d ${D}${sbindir}
 	oe_runmake INSTALL_DIR=${D}/usr install

	# add runtime support files
	install -m 755 -d ${D}/${datadir}/pme-tools/sample_rules
 	install -m 644 ltib_supp/sample* ${D}/${datadir}/pme-tools/sample_rules
 	install -m 755 -d ${D}/etc/udev/rules.d
 	install -m 644 ltib_supp/06-fsl-pme-device.rules ${D}/etc/udev/rules.d
}
