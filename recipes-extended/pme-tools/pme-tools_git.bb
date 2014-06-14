DESCRIPTION = "Pattern matcher tools"
SECTION = "pme-tools"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=f6bc49903590148d5df43337785b67cd"

EXCLUDE_FROM_WORLD_pn-pme-tools = "1"

SRCREV = "git://git.am.freescale.net/gitolite/pme_tools.git"
SRC_URI = "549a22328672ad0ae76835105ad5e95ece2f7b21"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "ARCH=${TARGET_ARCH} USE_LTIB=1 LTIB_LIB_PATH=${STAGING_LIBDIR} SYSROOT=${STAGING_DIR_TARGET} CROSS_COMPILE=\"${HOST_PREFIX}\""
EXTRA_CFLAGS = "-Wno-unused-but-set-parameter -Wno-enum-compare -Wno-unused-but-set-variable"
do_compile_prepend () {
    sed -i '/rec_yyget_leng/d' compilers/regularExpression/engine/pmrec.lex
    sed -i '/src_yyget_leng/d' compilers/statefulRule/engine/pmsrc.lex
    sed -i '/srcPreproc_yyget_leng/d' compilers/statefulRule/engine/pmsrc_preproc.lex
	oe_runmake clean
}

do_install () {
 	install -m 755 -d ${D}${bindir} -d ${D}${sbindir}
 	oe_runmake INSTALL_DIR=${D}/usr install

	# add runtime support files
	install -m 755 -d ${D}/${datadir}/pme-tools/sample_rules
 	install -m 644 ltib_supp/sample* ${D}/${datadir}/pme-tools/sample_rules
 	install -m 755 -d ${D}/etc/udev/rules.d
 	install -m 644 ltib_supp/06-fsl-pme-device.rules ${D}/etc/udev/rules.d
}
