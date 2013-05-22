DESCRIPTION = "Userspace debug agent for PA CodeWarrior"
SECTION = "apptrk"
LICENSE = "Freescale-EULA"
PR = "r3"
LIC_FILES_CHKSUM = "file://COPYING;md5=95560debfde180684364319811cc1421"

DEPENDS = "elfutils"

SRCREV = "02ff1af9f5df8364599e10a299e50afe2c8eda1a"
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
