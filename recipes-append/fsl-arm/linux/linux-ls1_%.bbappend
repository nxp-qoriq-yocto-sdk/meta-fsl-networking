KERNEL_DEFCONFIG = "${S}/arch/arm/configs/ls1021a_defconfig"

do_configure_prepend () {
    cp ${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig
}

SRC_URI = "${URL-LINUX}"
SRCREV = "${SHA-LINUX}"

