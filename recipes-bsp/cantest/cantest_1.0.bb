DESCRIPTION = "cantest"
HOMEPAGE = "http://svn.berlios.de/svnroot/repos/socketcan/trunk/can-utils/"
LICENSE = "GPLv2"
PR = "r1"
LIC_FILES_CHKSUM = "file://COPYING;md5=d85064f0fa931974668d281ab83cc97e"

SRC_URI[md5sum] = "7f51f8ff5df5b28b7df7fb359a13e12e"
SRC_URI[sha256sum] = "1adca4cbb76c170fac2975c0356a4499f35b74434426cc95c1f4ccd08c668bbb"

SRC_URI = "file://cantest-${PV}.tar.gz \
           file://cantest-1.0.patch \
           file://cantest-1.0-cansend-1.patch \
           file://cantest-1.0-cansend-debug.patch \
           file://0001-Cantest-fix-for-Flexcan.patch"

do_install(){
    mkdir -p ${D}/$bindir
    cp cantest ${D}/$bindir
}

