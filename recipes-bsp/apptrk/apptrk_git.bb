DESCRIPTION = "Userspace debug agent for PA CodeWarrior"
SECTION = "apptrk"
LICENSE = "Freescale-EULA"
PR = "r4"
LIC_FILES_CHKSUM = "file://COPYING;md5=95560debfde180684364319811cc1421"

DEPENDS = "elfutils"

SRCREV = "9b96f4aa0a7a9d1ab2f979dda7c932b1314fbf42"
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
