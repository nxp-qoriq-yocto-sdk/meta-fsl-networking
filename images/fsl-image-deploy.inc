#
# Copyright (C) 2012-2014 Freescale Semiconductor Inc.
#
# deploy pkgs for all fsl images

DEPLOY_PKGS = " \
    fm-ucode \
    hv-cfg \
    rcw \
    hypervisor \
    hypervisor-partman \
"
DEPLOY_PKGS_e500v2 = ""

DEPLOY_PKGS_ls102xa = " \
    rcw \
"

IMAGE_INSTALL_append = " ${DEPLOY_PKGS}"

# pkgs to be installed for specific board
IMAGE_INSTALL_append_ls1021aqds = " qe-ucode"
IMAGE_INSTALL_append_ls1021atwr = " qe-ucode"
IMAGE_INSTALL_append_p1020rdb = " vsc7385-firmware"
IMAGE_INSTALL_append_p1021rdb = " vsc7385-firmware qe-ucode"
IMAGE_INSTALL_append_p1022ds = " edink"
IMAGE_INSTALL_append_p1023rdb = " fm-ucode"
IMAGE_INSTALL_append_p1025twr = " qe-ucode"
IMAGE_INSTALL_append_p2020rdb = " vsc7385-firmware"
IMAGE_INSTALL_append_t1040rdb = " qe-ucode"
IMAGE_INSTALL_append_t1040rdb-64b = " qe-ucode"
IMAGE_INSTALL_append_t1024rdb = " qe-ucode"
IMAGE_INSTALL_append_t1024rdb-64b = " qe-ucode"
IMAGE_INSTALL_append_t1024qds = " qe-ucode"
IMAGE_INSTALL_append_t1024qds-64b = " qe-ucode"
IMAGE_INSTALL_append_t1042rdb = " qe-ucode"
IMAGE_INSTALL_append_t1042rdb-64b = " qe-ucode"
IMAGE_INSTALL_append_t2080rdb = " cs4315-firmware-image"
IMAGE_INSTALL_append_t2080rdb-64b = " cs4315-firmware-image"
IMAGE_INSTALL_append_t4240rdb = " cs4315-firmware-image"
IMAGE_INSTALL_append_t4240rdb-64b = " cs4315-firmware-image"

# pkgs to be excluded for specific board
IMAGE_INSTALL_remove_b4420qds = "hv-cfg"
IMAGE_INSTALL_remove_b4420qds-64b = "hv-cfg"
IMAGE_INSTALL_remove_t1042rdb-pi = "hv-cfg"
IMAGE_INSTALL_remove_t1042rdb-pi-64b = "hv-cfg"
IMAGE_INSTALL_remove_t1024rdb = "hv-cfg"
IMAGE_INSTALL_remove_t1024rdb-64b = "hv-cfg"
IMAGE_INSTALL_remove_t1024qds = "hv-cfg"
IMAGE_INSTALL_remove_t1024qds-64b = "hv-cfg"
IMAGE_INSTALL_remove_t4160qds = "hv-cfg rcw"
IMAGE_INSTALL_remove_t4160qds-64b = "hv-cfg rcw"

# special trick for e6500 to include 64bit hypervisor
IMAGE_INSTALL_remove_e6500 = " \
    hypervisor \
    hypervisor-partman \
"
IMAGE_INSTALL_append_e6500 = " \
    ${@base_conditional("TCMODE", "external-fsl", "hypervisor", "lib64-hypervisor", d)} \
    ${@base_conditional("TCMODE", "external-fsl", "hypervisor-partman", "lib64-hypervisor-partman", d)} \
"

