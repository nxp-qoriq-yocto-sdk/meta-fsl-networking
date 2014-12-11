LICENSE = "BSD & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ed5eddbfbb84af5089ea94c382d423c"

SRC_URI = "git://git.am.freescale.net/gitolite/dpaa-modules/eth-config.git"
SRCREV = "8040e0b1a7cb18cecfe0c7657d42f59f222b7930"

EXTRA_OEMAKE = "D=${D}"

do_install() {
    oe_runmake install
}
