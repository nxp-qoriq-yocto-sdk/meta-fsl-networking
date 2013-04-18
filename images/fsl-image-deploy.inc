#
# Copyright (C) 2012 Freescale Semiconductor Inc.
#
# deploy pkgs for all fsl images

PRINC := "${@int(PRINC) + 2}"

IMAGE_INSTALL_append_p1020mbg = " vsc7385-firmware"
IMAGE_INSTALL_append_p1020rdb = " vsc7385-firmware"
IMAGE_INSTALL_append_p1021rdb = " vsc7385-firmware qe-ucode"
IMAGE_INSTALL_append_p1024rdb = " vsc7385-firmware"
IMAGE_INSTALL_append_p1025rdb = " vsc7385-firmware qe-ucode"
IMAGE_INSTALL_append_p2020rdb = " vsc7385-firmware"

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
        "

IMAGE_INSTALL_append_e6500-64b = " \
        fm-ucode \
        "

IMAGE_INSTALL_append_b4420qds = " rcw"
IMAGE_INSTALL_append_b4420qds-64b = " rcw"
IMAGE_INSTALL_append_b4860qds = " rcw"
IMAGE_INSTALL_append_b4860qds-64b = " rcw"
IMAGE_INSTALL_append_t4240qds = " rcw"
IMAGE_INSTALL_append_t4240qds-64b = " rcw"

IMAGE_INSTALL_append_p1023rds = " \
        fm-ucode \
"

IMAGE_INSTALL_append_mpc8536ds = " diagnostic"
IMAGE_INSTALL_append_mpc8544ds = " diagnostic"
IMAGE_INSTALL_append_mpc8572ds = " diagnostic"

IMAGE_INSTALL_append_mpc8536ds = " edink"
IMAGE_INSTALL_append_mpc8544ds = " edink"
IMAGE_INSTALL_append_mpc8572ds = " edink"
IMAGE_INSTALL_append_p1022ds = " edink"
