DESCRIPTION = "sdos-demo"
LICENSE = "BSD"

COMPATIBLE_MACHINE = "(b4860qds)"

LIC_FILES_CHKSUM = "file://COPYING;md5=fa38cd73d71527dc6efb546474f64d10"

SRC_URI[md5sum] = "b03a5c752621afcbd631ba39f7d9517c"
SRC_URI[sha256sum] = "9ab36238a736dab3d8bd7279667da8ca22418362af14cc2bb4cccb388bc73eb2"

SRC_URI = "file://sdos-demo_${PV}.tar.gz "

do_install(){
    mkdir -p ${D}/ipc
    cp *.bin ${D}/ipc
}

FILES_${PN} += "/ipc/*"
