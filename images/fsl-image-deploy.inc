#
# Copyright (C) 2012-2014 Freescale Semiconductor Inc.
#
# deploy pkgs for all fsl images

IMAGE_INSTALL_append_e500mc = " \
    fm-ucode \
    hv-cfg \
    rcw \
    hypervisor \
    hypervisor-partman \
"

IMAGE_INSTALL_append_e5500 = " \
    fm-ucode \
    hv-cfg \
    rcw \
    hypervisor \
    hypervisor-partman \
"

IMAGE_INSTALL_append_e5500-64b = " \
    fm-ucode \
    hv-cfg \
    rcw \
    hypervisor \
    hypervisor-partman \
"

IMAGE_INSTALL_append_e6500 = " \
    fm-ucode \
    hv-cfg \
    rcw \
    ${@base_conditional("TCMODE", "external-fsl", "hypervisor", "lib64-hypervisor", d)} \
    ${@base_conditional("TCMODE", "external-fsl", "hypervisor-partman", "lib64-hypervisor-partman", d)} \
"

IMAGE_INSTALL_append_e6500-64b = " \
    fm-ucode \
    hv-cfg \
    rcw \
    hypervisor \
    hypervisor-partman \
"

IMAGE_INSTALL_append_p1020rdb = " vsc7385-firmware"
IMAGE_INSTALL_append_p1021rdb = " \
    vsc7385-firmware \
    qe-ucode \
"
IMAGE_INSTALL_append_p1022ds = " edink"
IMAGE_INSTALL_append_p1023rdb = " fm-ucode"
IMAGE_INSTALL_append_p1025twr = " qe-ucode"
IMAGE_INSTALL_append_p2020rdb = " vsc7385-firmware"

IMAGE_INSTALL_remove_t1042rdb = "hv-cfg"
IMAGE_INSTALL_remove_t1042rdb-64b = "hv-cfg"
IMAGE_INSTALL_remove_t4160qds = "hv-cfg rcw"
IMAGE_INSTALL_remove_t4160qds-64b = "hv-cfg rcw"
IMAGE_INSTALL_remove_t2080rdb = "hv-cfg"
IMAGE_INSTALL_remove_t2080rdb-64b = "hv-cfg"
IMAGE_INSTALL_remove_b4420qds = "hv-cfg"
IMAGE_INSTALL_remove_b4420qds-64b = "hv-cfg"

IMAGE_INSTALL_append_t1040rdb = " \
    qe-ucode \
"
IMAGE_INSTALL_append_t1040rdb-64b = " \
    qe-ucode \
"

IMAGE_INSTALL_append_t2080rdb = " \
    cs4315-firmware-image \
"
IMAGE_INSTALL_append_t2080rdb-64b = " \
    cs4315-firmware-image \
"
IMAGE_INSTALL_append_t4240rdb = " \
    cs4315-firmware-image \
"
IMAGE_INSTALL_append_t4240rdb-64b = " \
    cs4315-firmware-image \
"
