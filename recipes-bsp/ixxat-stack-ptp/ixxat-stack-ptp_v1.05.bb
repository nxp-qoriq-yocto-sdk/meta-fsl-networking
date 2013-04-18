DESCRIPTION = "The stack images of ptp"
SECTION = "1588"
LICENSE = "IXXAT EULA"
LIC_FILES_CHKSUM = "file://ptp_p2020rdb;md5=10b6559698b2a212519975054b1766d9"

PR = "r1"

SRC_URI = "file://ixxat-demopackage-P2020RDB-PCA-v1.05.tar.gz \
"
SRC_URI[md5sum] = "5cc9fccc3fb9dfdb2b2d9918f7e82eaa"
SRC_URI[sha256sum] = "30cd9ff0b9ebd08d8cf44d0f16cd8f98f40d52151cedf271b31dbddb929d00cd"

S = "${WORKDIR}/ixxat-demopackage-P2020RDB-PCA-v1.05/"

COMPATIBLE_MACHINE = "p2020rdb"

do_install () {
	install -d ${D}/${bindir}
	install -m 755 ptp_p2020rdb ${D}/${bindir}
}

INSANE_SKIP_${PN} += "ldflags"

