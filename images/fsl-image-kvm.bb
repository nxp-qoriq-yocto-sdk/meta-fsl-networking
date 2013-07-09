#
# Copyright (C) 2007 OpenedHand Ltd.
#
IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} u-boot"
IMAGE_LINGUAS = " "

PR = "r1"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += " mkdir ${IMAGE_ROOTFS}/images; cp ${DEPLOY_DIR_IMAGE}/fsl-image-minimal-${MACHINE}.ext2.gz.u-boot ${IMAGE_ROOTFS}/images"

IMAGE_FSTYPES = "tar.gz ext2.gz.u-boot"

# pkgconfig is here for qemu, and it's not in DEPENDS because of multilib 
# build issues. to fix later
IMAGE_INSTALL += "pkgconfig qemu kernel-image"

do_rootfs[depends] += "fsl-image-minimal:do_rootfs"
