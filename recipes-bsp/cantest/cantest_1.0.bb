DESCRIPTION = "cantest"
HOMEPAGE = "http://svn.berlios.de/svnroot/repos/socketcan/trunk/can-utils/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d85064f0fa931974668d281ab83cc97e"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/cantest.git"
SRCREV = "0ad5fa86b1007aefef60a10ccb3a946497477995"

S = "${WORKDIR}/git"

do_install(){
    mkdir -p ${D}/$bindir
    cp cantest ${D}/$bindir
}

