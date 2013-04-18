DESCRIPTION = "Kernel Module using the layer7 filter for the Pattern Matcher"
LICENSE = "GPL"
PR = "r0"
LIC_FILES_CHKSUM = "file://COPYING;md5=8a71d0475d08eee76d8b6d0c6dbec543"

DEPENDS="virtual/kernel"

SRC_URI = " file://fsl_ipt_l7pme-1.0.2.tar.gz \
            file://fsl_ipt_l7pme-1.0.2-update-for-2.6.31.patch \
            file://fsl_ipt_l7pme-1.0.2-fsl_ipt_l7pm-Changes-for-kernel-2.6.35.patch \
          "
S= "${WORKDIR}/fsl_ipt_l7pme-1.0.2"

inherit module

do_install() {
    install -d ${D}/etc/l7-protocols
    install -m 644 layer7.ini ${D}/etc/l7-protocols
    install -m 644 layer7.regex ${D}/etc/l7-protocols
    oe_runmake ARCH=powerpc INSTALL_MOD_PATH=${D} DEPMOD=/bin/true KERNEL_SRC="${STAGING_KERNEL_DIR}" install_modules
}

SRC_URI[md5sum] = "7c8a0eac959f8f373312599257464239"
SRC_URI[sha256sum] = "0fd9360e4887e98af2312a3de234a9bb6aec833c009c83f475cf942f795147b2"

