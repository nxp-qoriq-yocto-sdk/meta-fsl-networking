require recipes-core/meta/meta-toolchain.bb

MULTILIBS_pn-${PN} = ""
TOOLCHAIN_NEED_CONFIGSITE_CACHE += "zlib"
TOOLCHAIN_TARGET_TASK += " \
    glib-2.0 \
    glib-2.0-dev \
    dtc-staticdev \
    libgomp \
    libgomp-dev \
    libgomp-staticdev \
    libstdc++-staticdev \
    ${TCLIBC}-staticdev \
"

CORE_SPECIFIC = " \
    nativesdk-mux-server \
    nativesdk-pme-regex-analyzer \
"

CORE_SPECIFIC_ls102xa = ""

TOOLCHAIN_HOST_TASK += " \
    nativesdk-dtc \
    nativesdk-u-boot-mkimage \
    ${CORE_SPECIFIC} \
"

TOOLCHAIN_HOST_TASK_append_e500v2 = " \
    nativesdk-boot-format \
    nativesdk-boot-format-config \
"

