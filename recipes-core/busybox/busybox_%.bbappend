FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

BUSYBOX_SPLIT_SUID = "0"

SRC_URI_append = " file://getty-remove-the-statement-of-pid-and-sid-comparison.patch \
    file://defconfig-fsl"

do_configure_prepend () {
        cp ${WORKDIR}/defconfig-fsl ${WORKDIR}/defconfig
}

