DESCRIPTION = "The stack images of ptp"
SECTION = "1588"
LICENSE = "IXXAT-EULA"
LIC_FILES_CHKSUM = "file://ptp_P1025_TWR;md5=f26e7ca35bf47262ea6de523fee894f1"

SRC_URI = "file://ixxat-demopackage-P1025-TWR-v1.06.tar.gz"
SRC_URI[md5sum] = "8586d47d80b91c96cbca23b773732bc7"
SRC_URI[sha256sum] = "4e964e9560028868f958e9ea2fa6298afeca1ad8a426e7991733f6c07eee1ab8"

S = "${WORKDIR}/ixxat-demopackage-P1025-TWR-v1.06/"

COMPATIBLE_MACHINE = "p1025twr"

do_install () {
	install -d ${D}/${bindir}
	install -m 755 ptp_P1025_TWR ${D}/${bindir}
}

INSANE_SKIP_${PN} += "ldflags"
