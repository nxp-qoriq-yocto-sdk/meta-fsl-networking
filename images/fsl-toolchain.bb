PR = "r3"

require fsl-toolchain-bare.bb

TOOLCHAIN_OUTPUTNAME = "${SDK_NAME}-toolchain-${DISTRO_VERSION}"
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

