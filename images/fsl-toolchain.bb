require recipes-core/meta/meta-toolchain.bb

PRINC := "${@int(PRINC) + 4}"

MULTILIB_VARIANTS_pn-${PN} = ""
TOOLCHAIN_HOST_TASK = "nativesdk-packagegroup-sdk-host packagegroup-cross-canadian-${TRANSLATED_TARGET_ARCH}"
TOOLCHAIN_NEED_CONFIGSITE_CACHE += "zlib"
TOOLCHAIN_TARGET_TASK += " \
	glib-2.0 \
	glib-2.0-dev \
	dtc \
	libgomp \
	libgomp-dev \
	libgomp-staticdev \
	libstdc++-staticdev \
	${TCLIBC}-staticdev \
	"

TOOLCHAIN_HOST_TASK += " \
	nativesdk-dtc \
	"

TOOLCHAIN_HOST_TASK_append_e500v2 = " \
    nativesdk-boot-format \
    nativesdk-boot-format-config \
    "

TOOLCHAIN_HOST_TASK_append = " \
    nativesdk-mux-server \
    nativesdk-cst \
    nativesdk-pme-regex-analyzer \
    "

