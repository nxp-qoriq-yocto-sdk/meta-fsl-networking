#
# Copyright (C) 2012 Freescale Semiconductor Inc.
#
# This image is designed to run from flash. It only includes essetional
# packages to deploy other big images to large physical media, such as 
# usb stick, hard drive.
require images/fsl-image-minimal.bb

PRINC := "${@int(PRINC) + 2}"

IMAGE_INSTALL += " \
        packagegroup-core-ssh-dropbear \
        bash \
        util-linux \
        e2fsprogs \
        e2fsprogs-mke2fs \
        e2fsprogs-e2fsck \
        e2fsprogs-tune2fs \
        mtd-utils \
        mtd-utils-jffs2 \
        mtd-utils-ubifs \
        dosfstools \
        net-tools \
        kmod \
        sysfsutils \
        sysklogd \
        sysstat \
"

IMAGE_INSTALL_append_e500v2 = " \
        boot-format \
        boot-format-config \
"

