#
# Copyright (C) 2007 OpenedHand Ltd.
#
IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} u-boot udev-extraconf"
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FSTYPES = "tar.gz ext2.gz.u-boot jffs2 ubi"
