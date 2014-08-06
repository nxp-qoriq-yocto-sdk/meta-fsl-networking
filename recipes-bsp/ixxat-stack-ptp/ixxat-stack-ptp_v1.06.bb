DESCRIPTION = "The stack images of ptp"
LICENSE = "IXXAT-EULA"
LIC_FILES_CHKSUM = "file://ptp_P1025_TWR;md5=f26e7ca35bf47262ea6de523fee894f1"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/ixxat-demopackage.git"
SRCREV = "4660bfb6d652c97df29e7515d354952bed875baa"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "p1025twr"

do_install () {
	install -d ${D}/${bindir}
	install -m 755 ptp_P1025_TWR ${D}/${bindir}
}

INSANE_SKIP_${PN} += "ldflags"
