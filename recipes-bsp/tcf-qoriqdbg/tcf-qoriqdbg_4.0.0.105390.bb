DESCRIPTION = "SPID based TCF agent"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://Makefile;beginline=6;endline=17;md5=75c98af1c2fa46281fbdac337244d196"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/tcf-qoriqdbg.git"
SRCREV = "c5ac8d08d648f0963968b9d8f16fa8549f4bf9fa"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CXX='${CXX}'"

do_compile() {
    oe_runmake all
}

do_install() {
    oe_runmake DESTDIR=${D} install
}

