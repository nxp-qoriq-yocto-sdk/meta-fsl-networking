#
# Copyright (C) 2012-2014 Freescale Semiconductor Inc.
#
# deploy pkgs for all fsl images

DEPLOY_PKGS = " \
    fm-ucode \
    hv-cfg \
    rcw \
    hypervisor \
"
DEPLOY_PKGS_e500v2 = ""

DEPLOY_PKGS_ls102xa = " \
    rcw \
    qe-ucode \
"

EXTRA_IMAGEDEPENDS_append = " ${DEPLOY_PKGS}"

# pkgs to be installed for specific board
EXTRA_IMAGEDEPENDS_append_p1020rdb = " vsc7385-firmware"
EXTRA_IMAGEDEPENDS_append_p1021rdb = " vsc7385-firmware qe-ucode"
EXTRA_IMAGEDEPENDS_append_p1022ds = " edink"
EXTRA_IMAGEDEPENDS_append_p1023rdb = " fm-ucode"
EXTRA_IMAGEDEPENDS_append_p1025twr = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_p2020rdb = " vsc7385-firmware"
EXTRA_IMAGEDEPENDS_append_t1 = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t2080rdb = " cs4315-firmware"
EXTRA_IMAGEDEPENDS_append_t2080rdb-64b = " cs4315-firmware"
EXTRA_IMAGEDEPENDS_append_t4240rdb = " cs4315-firmware"
EXTRA_IMAGEDEPENDS_append_t4240rdb-64b = " cs4315-firmware"

# pkgs to be excluded for specific board
EXTRA_IMAGEDEPENDS_remove_b4420 = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t1042rdb-pi = "hv-cfg qe-ucode"
EXTRA_IMAGEDEPENDS_remove_t1042rdb-pi-64b = "hv-cfg qe-ucode"
EXTRA_IMAGEDEPENDS_remove_t1023 = "hv-cfg qe-ucode"
EXTRA_IMAGEDEPENDS_remove_t1024 = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t4160 = "hv-cfg rcw"

# special trick for e6500 to include 64bit hypervisor
EXTRA_IMAGEDEPENDS_remove_e6500 = " \
    hypervisor \
"
EXTRA_IMAGEDEPENDS_append_e6500 = " \
    lib64-hypervisor \
"

