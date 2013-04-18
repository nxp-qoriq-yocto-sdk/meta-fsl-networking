DESCRIPTION = "Userspace proxy agent for Code Warrrior HyperTrk"
SECTION = "hyperrelay"
LICENSE = "Freescale EULA"
PR = "r2"
LIC_FILES_CHKSUM = "file://COPYING;md5=95560debfde180684364319811cc1421"

SRCREV = "040ec85e16e5a127bed83f070373890d238173f5"
SRC_URI = "git://git.am.freescale.net/gitolite/sdk/hyperrelay.git \
"

S = "${WORKDIR}/git"

CFLAGS += "\
    -Wall \
    -Wundef \
    -Wstrict-prototypes \
    -Wno-trigraphs \
    -fno-strict-aliasing \
    -fno-common \
    -O2 \
    -g \
    -fmessage-length=0 \
    -MMD \
    -MP \
    -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" \
	"

LDFLAGS_prepend = " -lpthread "

do_install() {
        install -d ${D}/${bindir}
        oe_runmake install DESTDIR=${D}
}
