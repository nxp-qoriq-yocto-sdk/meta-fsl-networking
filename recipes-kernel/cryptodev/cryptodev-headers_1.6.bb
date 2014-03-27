SECTION = "devel"
SUMMARY = "Linux Cryptodev Header"
DESCRIPTION = "/dev/crypto ioctl interface to Linux kernel crypto operations"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
RCONFLICTS_${PN} = "ocf-linux"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/cryptodev-linux.git;branch=sdk-v1.6"
SRCREV = "330a7faac655d1d0a94f3b95be8939f8b68d0a66"

S = "${WORKDIR}/git"
do_install () {
    install -D crypto/cryptodev.h ${D}/usr/include/crypto/cryptodev.h
}

do_compile[noexec] = "1"
ALLOW_EMPTY_${PN} ="1"
BBCLASSEXTEND = "native nativesdk"

