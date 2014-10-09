PRIVATE_PKGS = " \
        fmc \
        pme-tools \
        qoriq-debug \
        usdpaa \
"
PRIVATE_PKGS_e500v2 = ""
PRIVATE_PKGS_ls102xa = ""

# common packages
IMAGE_INSTALL += " \
        ${PRIVATE_PKGS} \
        asf \
        eth-config \
        merge-files \
        mux-server \
        ${@base_conditional("PRIVATE_FULL", "yes", "apptrk", "", d)} \
        ${@base_conditional("PRIVATE_FULL", "yes", "hyperrelay", "", d)} \
"

IMAGE_INSTALL_remove_ls102xa = " \
        asf \
        eth-config \
        mux-server \
        ${@base_conditional("PRIVATE_FULL", "yes", "hyperrelay", "", d)} \
"

# pkgs to be installed for each core
IMAGE_INSTALL_append_e500v2 = " \
        cantest \
        fsl-pme \
        libppc \
        testfloat \
"

IMAGE_INSTALL_append_e500mc = " \
        fsl-tlu \
        libppc \
"

IMAGE_INSTALL_append_e5500 = " \
        libppc \
        tcf-qoriqdbg \
"

IMAGE_INSTALL_append_e5500-64b = " \
        tcf-qoriqdbg \
"

IMAGE_INSTALL_append_e6500 = " \
        tcf-qoriqdbg \
"

IMAGE_INSTALL_append_e6500-64b = " \
        ceetm \
        tcf-qoriqdbg \
"

# pkgs to be installed for each board
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
        ar \
        ceetm \
        l2switch \
        uio-seville \
"

IMAGE_INSTALL_append_t1040rdb-64b = " \
        ar \
        ceetm \
        l2switch \
        uio-seville \
"

IMAGE_INSTALL_append_t1042rdb = " \
        ar \
        ceetm \
        l2switch \
        uio-seville \
"

IMAGE_INSTALL_append_t1042rdb-64b = " \
        ar \
        ceetm \
        l2switch \
        uio-seville \
"

IMAGE_INSTALL_append_t1042rdb-pi = " \
        ar \
"
IMAGE_INSTALL_append_t1042rdb-pi-64b = " \
        ar \
"

IMAGE_INSTALL_append_t4240qds = " \
        pkc-host \
        skmm-ep \
        skmm-host \
"

