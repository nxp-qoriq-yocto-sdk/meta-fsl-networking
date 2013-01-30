PR_append = "+fsl_networking"

FILESEXTRAPATHS_prepend := "${THISDIR}/busybox-1.20.2:"

SRC_URI_append = " file://defconfig-fsl \
            file://busybox-1.19.4-ubi-user-h.patch \
            file://inetd \
            file://inetd.conf \
"

do_configure_prepend () {
        cp ${WORKDIR}/defconfig-fsl ${WORKDIR}/defconfig
}


