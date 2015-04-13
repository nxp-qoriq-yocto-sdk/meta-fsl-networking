SRC_URI = "${URL-LINUX}"
SRCREV = "${SHA-LINUX}"

KERNEL_DEFCONFIG = "${S}/arch/arm/configs/ls1021a_defconfig"

do_pre_configure() {
    cp ${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig
    for deltacfg in ${DELTA_KERNEL_DEFCONFIG}; do
        if [ -f "${deltacfg}" ]; then
            ${S}/scripts/kconfig/merge_config.sh -m \
                ${WORKDIR}/defconfig ${deltacfg}
            mv .config ${WORKDIR}/defconfig
        elif [ -f "${S}/arch/arm/configs/${deltacfg}" ]; then
            ${S}/scripts/kconfig/merge_config.sh -m \
                ${WORKDIR}/defconfig ${S}/arch/arm/configs/${deltacfg}
            mv .config ${WORKDIR}/defconfig
        fi
    done
}
addtask pre_configure before do_configure after do_patch

