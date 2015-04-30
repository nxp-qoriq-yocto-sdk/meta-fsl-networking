SRC_URI = "${URL-PKC-HOST}"
SRCREV = "${SHA-PKC-HOST}"

inherit module qoriq_build_64bit_kernel

LICENSE = "BSD & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=99803d8e9a595c0bdb45ca710f353813"

RDEPENDS_${PN} += "bc"

do_install() {
	oe_runmake INSTALL_MOD_PATH="${D}" modules_install
	install -d ${D}/etc/crypto
	install -d ${D}/${bindir}
	cp ${S}/crypto.cfg ${D}/etc/crypto
	cp ${S}/images/pkc-firmware.bin ${D}/etc/crypto
	cp ${S}/apps/cli/cli ${D}/${bindir}
	cp ${S}/perf/c29x_driver_perf_profile.sh ${D}/${bindir}
}

FILES_${PN} = "${bindir}/cli \
	${bindir}/c29x_driver_perf_profile.sh \
	/etc/crypto/crypto.cfg \
	/etc/crypto/pkc-firmware.bin \
"
