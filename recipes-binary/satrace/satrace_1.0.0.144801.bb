SUMMARY = "Linux SA trace component"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=bf20d39b348e1b0ed964c91a97638bbb"

SRCBRANCH = "satrace-dev"
SRC_URI = "git://git.am.freescale.net/gitolite/users/b46903/satrace.git;branch=${SRCBRANCH}"
SRCREV="562fc709f664abfebebb6b04bbb3312068098497"

S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"
do_install() {
        oe_runmake install DESTDIR=${D}
}

COMPATIBLE_MACHINE = "(ls1021aqds|ls1021atwr)"

