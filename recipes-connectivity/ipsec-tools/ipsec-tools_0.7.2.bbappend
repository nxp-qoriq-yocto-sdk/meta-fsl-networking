FILESEXTRAPATHS_prepend_fsl-networking := "${THISDIR}/files:"

SRC_URI_append_fsl-networking = " file://test_setkey"

EXTRA_OECONF_append_fsl-networking = "\
    --enable-dpd \
    --enable-ipv6 \
    --enable-natt \
"

PR_append_fsl-networking = "+fsl_ppc_private.2"

do_install_append_fsl-networking(){
    install -d  ${D}/test_setkey
    cp ${WORKDIR}/test_setkey/* ${D}/test_setkey
}

FILES_${PN}_append_fsl-networking = " /test_setkey/*"

