#PRIVATE_FULL = "yes"

require images/fsl-image-flash.bb
require images/fsl-image-private.inc

# common opensource packages
IMAGE_INSTALL += " \
    packagegroup-fsl-core \
"

ROOTFS_POSTPROCESS_COMMAND += "rootfs_delete_uImage; "
