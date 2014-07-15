DESCRIPTION = "SPID based TCF agent"
SECTION = "tcf-qoriqdbg"
LICENSE = "Freescale-EULA"
PR = "r4"
LIC_FILES_CHKSUM = "file://Makefile;beginline=6;endline=17;md5=75c98af1c2fa46281fbdac337244d196"

SRC_URI = "file://${BPN}-${PV}.tar.bz2 \
           file://add-include-in-tcpTransport.patch \
           file://add-include-in-socketSupport.patch  \
"
SRC_URI[md5sum] = "f11b99b489030d9f35573e91c4404e03"
SRC_URI[sha256sum] = "3250e2951c3b57bfc3dc9e1174e38555e75682ad90831720a7c882093c119f2b"


EXTRA_OEMAKE = "CXX='${CXX}'"

do_compile() {
    oe_runmake all
}

do_install() {
    oe_runmake DESTDIR=${D} install
}

