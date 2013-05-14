require fsl-toolchain-bare.bb

PRINC := "${@int(PRINC) + 1}"

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
	${@multilib_pkg_extend(d, "gcc")} \
	${@multilib_pkg_extend(d, "binutils")} \
	${@multilib_pkg_extend(d, "libgcc-dev")} \
	${@multilib_pkg_extend(d, "eglibc-dev")} \
	${@multilib_pkg_extend(d, "eglibc-staticdev")} \
	${@multilib_pkg_extend(d, "eglibc-utils")} \
	${@multilib_pkg_extend(d, "eglibc-thread-db")} \
	${@multilib_pkg_extend(d, "eglibc-extra-nss")} \
	${@multilib_pkg_extend(d, "libcidn")} \
	${@multilib_pkg_extend(d, "libstdc++")} \
	${@multilib_pkg_extend(d, "libstdc++-dev")} \
	${@multilib_pkg_extend(d, "libstdc++-staticdev")} \
	${@multilib_pkg_extend(d, "glib-2.0")} \
	${@multilib_pkg_extend(d, "glib-2.0-dev")} \
	${@multilib_pkg_extend(d, "libgomp")} \
	${@multilib_pkg_extend(d, "libgomp-dev")} \
	${@multilib_pkg_extend(d, "libgomp-staticdev")} \
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

