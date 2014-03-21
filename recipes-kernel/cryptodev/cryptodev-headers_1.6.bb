SECTION = "devel"
SUMMARY = "Linux Cryptodev Header"
DESCRIPTION = "/dev/crypto ioctl interface to Linux kernel crypto operations"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
RCONFLICTS_${PN} = "ocf-linux"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/cryptodev-linux.git;branch=sdk-v1.6"
SRCREV = "c97dcc67379ecb6c41f649eb2d88c0c7b30d75f7"

S = "${WORKDIR}/git"
do_install () {
    install -D crypto/cryptodev.h ${D}/usr/include/crypto/cryptodev.h
}

do_compile[noexec] = "1"
ALLOW_EMPTY_${PN} ="1"
BBCLASSEXTEND = "native nativesdk"

