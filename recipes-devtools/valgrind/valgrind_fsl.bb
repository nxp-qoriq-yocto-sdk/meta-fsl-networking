DESCRIPTION = "Valgrind memory debugger"
HOMEPAGE = "http://valgrind.org/"
LICENSE = "GPLv2 & GPLv2+ & BSD"
LIC_FILES_CHKSUM = "file://../valgrind-3.8.1/COPYING;md5=c46082167a314d785d012a244748d803"

PV = "3.8.1+${DISTRO}"
PR = "r1"

SRC_URI = "file://${BPN}-3.8.1.tar.gz \
    file://valgrind-3.8.1-sepbuildfix.patch \
    file://configure-with-newer-glibc.patch \
    file://fix-out-of-tree-builds-with-newer-glibc.patch \
"
SRC_URI[md5sum] = "2501cb21f4fc1dda2f22597e5ab71640"
SRC_URI[sha256sum] = "98277024e910ad4528235aad8818668ef8adebc340c7a67a70e3fd523aaf416f"

inherit autotools

S = "${WORKDIR}/${BPN}-3.8.1"

EXTRA_OEMAKE = "-w"
PARALLEL_MAKE = ""

do_install_append () {
    install -m 644 ${B}/default.supp ${D}/${libdir}/valgrind/
    find ${D} -type f | xargs sed -i '1s,#!.*perl,#!${USRBINPATH}/env perl,'
}

FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug/*"
RRECOMMENDS_${PN}_powerpc += "${TCLIBC}-dbg"
RRECOMMENDS_${PN}_powerpc64 += "${TCLIBC}-dbg"
RDEPENDS_${PN} += "perl"
