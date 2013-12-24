DESCRIPTION = "Valgrind memory debugger"
HOMEPAGE = "http://valgrind.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../${BPN}-${PV}/COPYING;md5=c46082167a314d785d012a244748d803"

SRC_URI = "file://${BPN}-${PV}.tar.bz2		\
           file://${BPN}-${PV}.PRE1-svn13689-sepbuildfix.patch	\
"
SRC_URI[md5sum] = "0947de8112f946b9ce64764af7be6df2"
SRC_URI[sha256sum] = "e6af71a06bc2534541b07743e1d58dc3caf744f38205ca3e5b5a0bdf372ed6f0"

inherit autotools

EXTRA_OECONF += "--program-suffix=-${TARGET_ARCH} --without-mpicc"

do_install_append () {
    install -m 644 ${B}/default.supp ${D}/${libdir}/${BPN}/
    find ${D} -type f | xargs sed -i '1s,#!.*perl,#!${USRBINPATH}/env perl,'
}

FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug/*"
RRECOMMENDS_${PN}_powerpc += "${TCLIBC}-dbg"
RRECOMMENDS_${PN}_powerpc64 += "${TCLIBC}-dbg"
RDEPENDS_${PN} += "perl"
