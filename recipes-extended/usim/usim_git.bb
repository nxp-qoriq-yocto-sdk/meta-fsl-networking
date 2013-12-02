DESCRIPTION = "Library and test program for Freescale IMX SIM Linux driver"
SECTION = "usim"
LICENSE = "GPLv2"

# no COPYING file in current git tree, need to be fixed
LIC_FILES_CHKSUM = "file://linux-lib/fsl_sim_interface.h;endline=12;md5=ab296f5b7e2c91638be4c7ce42af1518"

SRCREV = "004d899d08ffbad690de16f25b2635889a393c05"
SRC_URI = "git://git.am.freescale.net/gitolite/psc913x/usim.git \
"

PVBASE := "0.0"
PV = "${PVBASE}+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE="CROSS_COMPILE=${TARGET_PREFIX}"

do_compile(){
    oe_runmake -C linux-lib
    cp ${S}/linux-lib/libsim.so ${S}/usim_app
    oe_runmake -C usim_app OBJDIR=${S}/usim_app
}

do_install(){
    install -d ${D}${bindir}
    install -d ${D}${libdir}
    install -m 755 ${S}/linux-lib/libsim.so ${D}${libdir}
    install -m 755 ${S}/usim_app/fsl_sim_test.out ${D}${bindir}
}

FILES_${PN} += "/usr/lib/*"

