FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

SRC_URI_append = " file://defconfig-fsl"

do_configure_prepend () {
        cp ${WORKDIR}/defconfig-fsl ${WORKDIR}/defconfig
}

