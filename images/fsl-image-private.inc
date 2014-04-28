IMAGE_INSTALL_append_e500mc = " \
        fmc \
        fsl-tlu \
        libppc \
        pme-tools \
        qoriq-debug \
        usdpaa \
"

IMAGE_INSTALL_append_e500v2 = " \
        cantest \
        fsl-pme \
        libppc \
        testfloat \
"

IMAGE_INSTALL_append_e5500 = " \
        fmc \
        libppc \
        pme-tools \
        qoriq-debug \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_e5500-64b = " \
        fmc \
        pme-tools \
        qoriq-debug \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_e6500 = " \
        fmc \
        pme-tools \
        qoriq-debug \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_e6500-64b = " \
        ceetm \
        fmc \
        pme-tools \
        qoriq-debug \
        tcf-qoriqdbg \
        usdpaa \
"

IMAGE_INSTALL_append_b4420qds = " \
        ipc-modules-multi \
        ipc-modules-single \
        ipc-ust \
"

IMAGE_INSTALL_append_b4860qds = " \
        ipc-modules-multi \
        ipc-modules-single \
        ipc-ust \
"

IMAGE_INSTALL_append_c293pcie = " \
        pkc-firmware \
        skmm-ep \
"

IMAGE_INSTALL_append_p1023rdb = " \
        fmc \
"

IMAGE_INSTALL_append_p1025twr = " \
        ixxat-stack-ptp \
"

IMAGE_INSTALL_append_p4080ds = " \
        pkc-host \
        skmm-ep \
        skmm-host \
        tcf-qoriqdbg \
"

IMAGE_INSTALL_append_t1040rdb = " \
        ceetm \
        l2switch \
        uio-seville \
"

IMAGE_INSTALL_append_t1040rdb-64b = " \
        ceetm \
        l2switch \
        uio-seville \
"

IMAGE_INSTALL_append_t4240qds = " \
        pkc-host \
        skmm-ep \
        skmm-host \
"
# fsl specific packages
IMAGE_INSTALL += " \
        asf \
        eth-config \
        merge-files \
        mux-server \
"

IMAGE_INSTALL += '${@base_conditional("PRIVATE_FULL", "yes", "apptrk", "", d)}'
IMAGE_INSTALL += '${@base_conditional("PRIVATE_FULL", "yes", "hyperrelay", "", d)}'

