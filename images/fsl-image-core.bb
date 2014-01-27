#PRIVATE_FULL = "yes"

require images/fsl-image-flash.bb
require images/fsl-image-private.inc

PRINC := "${@int(PRINC) + 4}"

# common opensource packages
# FIXME: add bridge-utils back
IMAGE_INSTALL += " \
    packagegroup-fsl-core \
"

ROOTFS_POSTPROCESS_COMMAND += "find ${IMAGE_ROOTFS} -name uImage* | xargs rm -rf; "
