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

TOOLCHAIN_HOST_TASK += " \
	nativesdk-dtc \
	nativesdk-u-boot-mkimage \
	nativesdk-mux-server \
	nativesdk-cst \
	nativesdk-pme-regex-analyzer \
"

TOOLCHAIN_HOST_TASK_remove_ls102xa = " \
    nativesdk-mux-server \
    nativesdk-pme-regex-analyzer \
"

TOOLCHAIN_HOST_TASK_append_e500v2 = " \
    nativesdk-boot-format \
    nativesdk-boot-format-config \
"

