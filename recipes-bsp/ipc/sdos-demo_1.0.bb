DESCRIPTION = "sdos-demo"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=a77c327d4d1da3707d42dde9725d4769"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/sdos-demo.git"
SRCREV = "840d81c23211d4e248174b4b0baf25e6ea837740"

S = "${WORKDIR}/git"

do_install(){
    mkdir -p ${D}/ipc
    cp *.bin ${D}/ipc
}

FILES_${PN} += "/ipc/*"
COMPATIBLE_MACHINE = "(b4860qds)"

