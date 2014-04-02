require images/fsl-image-minimal.bb

# copy minimal rootfs image into kvm rootfs
ROOTFS_POSTPROCESS_COMMAND += "rootfs_copy_minimal_image;"

IMAGE_FSTYPES = "tar.gz ext2.gz ext2.gz.u-boot"

# pkgconfig is here for qemu, and it's not in DEPENDS because of multilib 
# build issues. to fix later
IMAGE_INSTALL += " \
    packagegroup-fsl-core \
    lxc hv-test libvirt libvirt-libvirtd libvirt-virsh \
    libhugetlbfs \
    pkgconfig qemu kernel-image"

do_rootfs[depends] += "fsl-image-minimal:do_rootfs"
