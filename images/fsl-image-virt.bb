require images/fsl-image-core.bb

# copy core rootfs image
ROOTFS_POSTPROCESS_COMMAND += "rootfs_copy_core_image;"
ROOTFS_POSTPROCESS_COMMAND_remove = "rootfs_delete_uImage;"

IMAGE_FSTYPES = "ext2.gz ext2.gz.u-boot"

# pkgconfig is here for qemu, and it's not in DEPENDS because of multilib 
# build issues. to fix later
IMAGE_INSTALL += " \
    lxc libvirt libvirt-libvirtd libvirt-virsh \
    libhugetlbfs \
    pkgconfig qemu kernel-image"

do_rootfs[depends] += "fsl-image-core:do_rootfs"
