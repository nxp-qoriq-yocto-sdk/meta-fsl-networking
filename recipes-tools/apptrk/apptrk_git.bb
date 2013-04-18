DESCRIPTION = "Userspace debug agent for PA CodeWarrior"
SECTION = "apptrk"
LICENSE = "Freescale EULA"
PR = "r2"
LIC_FILES_CHKSUM = "file://COPYING;md5=95560debfde180684364319811cc1421"

DEPENDS = "elfutils"

SRCREV = "74ce84330b6ab1f7a44fe9165d9546a4e2ace3aa"
SRC_URI = "git://git.am.freescale.net/gitolite/sdk/apptrk.git \
"

S = "${WORKDIR}/git"
CFLAGS += " -I${STAGING_INCDIR} -ISource/Linux -ISource/Portable \
                 -ISource/Linux_PA -ISource/PA -DPPC \
"
CFLAGS_append_powerpc64 = " -DENABLE_64BIT_SUPPORT"

do_install() {
        install -d ${D}/usr/bin
        oe_runmake install DESTDIR=${D}
}
