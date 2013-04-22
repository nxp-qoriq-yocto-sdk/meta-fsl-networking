PRINC := "${@int(PRINC) + 6}"

IMAGE_INSTALL_append_e500v2 = " \
        cantest \
        fsl-pme \
        libppc \
        testfloat \
"

# FIXME: add qoriq-debug back for e5500-64b
IMAGE_INSTALL_append_e500mc += " \
        fmc \
        fsl-tlu \
        libppc \
	pme-tools \
        qoriq-debug \
        usdpaa \
"

IMAGE_INSTALL_append_e5500 += " \
        fmc \
        libppc \
	pme-tools \
        qoriq-debug \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_e5500-64b += " \
        fmc \
	pme-tools \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_e6500 += " \
        fmc \
	pme-tools \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_e6500-64b += " \
        fmc \
	pme-tools \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_p1023rds += " \
        fmc \
"

IMAGE_INSTALL_append_p2020rdb += " \
        ixxat-stack-ptp \
"

IMAGE_INSTALL_append_p4080ds += " \
        tcf-qoriqdbg \
"

# fsl specific packages
IMAGE_INSTALL += " \
        mux-server \
        merge-files \
        eth-config \
"
IMAGE_INSTALL += '${@base_conditional("PRIVATE_FULL", "yes", "apptrk", "", d)}'
IMAGE_INSTALL += '${@base_conditional("PRIVATE_FULL", "yes", "hyperrelay", "", d)}'

# TODO: need to enable this in kernel
# IMAGE_INSTALL_append_asfoverride += " \
#         asf \
#"

