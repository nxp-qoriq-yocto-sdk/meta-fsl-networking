PR_append = "+fsl_networking"

FILESEXTRAPATHS_prepend := "${THISDIR}/busybox-1.20.2:"

SRC_URI_append = " file://defconfig-fsl"

do_configure_prepend () {
        cp ${WORKDIR}/defconfig-fsl ${WORKDIR}/defconfig
}

do_install_append() {
        sed -i "s:${bindir}/add-shell:${sbindir}/add-shell:" ${D}${sysconfdir}/busybox.links
        sed -i "s:${bindir}/remove-shell:${sbindir}/remove-shell:" ${D}${sysconfdir}/busybox.links
        sed -i "s:${bindir}/run-parts:${base_bindir}/run-parts:" ${D}${sysconfdir}/busybox.links
}
