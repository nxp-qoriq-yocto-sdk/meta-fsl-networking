DESCRIPTION = "Userspace debug agent for PA CodeWarrior"
SECTION = "apptrk"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=95560debfde180684364319811cc1421"

DEPENDS = "elfutils"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/apptrk.git"
SRCREV = "cbed10997c5e2a4aaa004fb0e1efec858bf1bbe1"

PVBASE := "0.0"
PV := "${PVBASE}+git${SRCPV}"
S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR} -ISource/Linux -ISource/Portable \
                 -ISource/Linux_PA -ISource/PA -DPPC \
"
CFLAGS_append_powerpc64 = " -DENABLE_64BIT_SUPPORT"

do_install() {
        install -d ${D}/usr/bin
        oe_runmake install DESTDIR=${D}
}
