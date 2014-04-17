SECTION = "devel"
SUMMARY = "Linux Cryptodev Header"
DESCRIPTION = "/dev/crypto ioctl interface to Linux kernel crypto operations"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
RCONFLICTS_${PN} = "ocf-linux"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/cryptodev-linux.git;nobranch=1"
SRCREV = "c9baf0623bdc55e8adfc91bf675e8148826d57d1"

S = "${WORKDIR}/git"
do_install () {
    install -D crypto/cryptodev.h ${D}/usr/include/crypto/cryptodev.h
}

do_compile[noexec] = "1"
ALLOW_EMPTY_${PN} ="1"
BBCLASSEXTEND = "native nativesdk"

