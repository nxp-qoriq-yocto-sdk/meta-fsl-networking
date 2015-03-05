# Freescale networking BSP default versions
GCCVERSION_ls102xa = "linaro-4.8"
BINUVERSION_ls102xa = "linaro-2.24"
PREFERRED_VERSION_make = "3.81"
PREFERRED_VERSION_eglibc_ls102xa = "linaro-2.19"
PREFERRED_VERSION_nativesdk-eglibc_ls102xa = "linaro-2.19"
PREFERRED_VERSION_libvirt = "1.2.13"

PREFERRED_VERSION_virtual/kernel_ls102xa = "3.12"

EXTRA_IMAGEDEPENDS += "cst-native"

# use xz to compress sstate
SSTATE_PKG_SUFFIX = "txz"
SSTATE_PKG_TARZIPPROG = "xz"

# whiteliste restricted license
LICENSE_FLAGS_WHITELIST = "non-commercial_netperf \
    commercial_libav commercial_x264 \
"

# copy the license.manifest to the image
COPY_LIC_MANIFEST = "1"

