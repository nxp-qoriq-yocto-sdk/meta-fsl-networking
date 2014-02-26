#
# Copyright (C) 2007 OpenedHand Ltd.
#
IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} u-boot udev-extraconf"
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image fsl-utils

require images/fsl-image-deploy.inc

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FSTYPES = "tar.gz ext2.gz ext2.gz.u-boot jffs2 ubi"

ROOTFS_POSTPROCESS_COMMAND += "rootfs_add_sdk_version;"

