DESCRIPTION = "Freescale TLU test package"
LICENSE = "GPL"
PR = "r0"
LIC_FILES_CHKSUM = "file://COPYING;md5=8a71d0475d08eee76d8b6d0c6dbec543"

SRC_URI = " file://fsl_tlu-1.0.0-alpha5-2.tar.gz \
          "
S= "${WORKDIR}/fsl_tlu-1.0.0"

do_install() {
    mkdir -p ${D}${sbindir}/fsl_tlu
    cp * ${D}${sbindir}/fsl_tlu
}

SRC_URI[md5sum] = "215a8a7f27af6f87afa428472fddbb99"
SRC_URI[sha256sum] = "b774115d9ebdaa954c51b55e249b6a59f5c0fc8fc4bbc8a1393ca9fe140e2c22"
