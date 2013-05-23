require recipes-core/meta/meta-toolchain.bb

PRINC := "${@int(PRINC) + 2}"

TOOLCHAIN_OUTPUTNAME = "${SDK_NAME}-toolchain-bare-${DISTRO_VERSION}"
TOOLCHAIN_TARGET_TASK = "packagegroup-core-standalone-sdk-target"
TOOLCHAIN_HOST_TASK = "packagegroup-cross-canadian-${@' packagegroup-cross-canadian-'.join(all_multilib_tune_values(d, 'TRANSLATED_TARGET_ARCH').split())}"
TOOLCHAIN_NEED_CONFIGSITE_CACHE += "zlib"
