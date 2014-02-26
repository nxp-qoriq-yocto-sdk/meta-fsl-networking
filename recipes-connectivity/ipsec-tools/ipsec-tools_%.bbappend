FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://test_setkey"

EXTRA_OECONF_append = "\
    --enable-dpd \
    --enable-ipv6 \
    --enable-natt \
"

PR_append = "+fsl.3"

do_install_append(){
    install -d  ${D}/opt/test_setkey
    cp ${WORKDIR}/test_setkey/* ${D}/opt/test_setkey
}

FILES_${PN}_append = " /opt/test_setkey/*"
