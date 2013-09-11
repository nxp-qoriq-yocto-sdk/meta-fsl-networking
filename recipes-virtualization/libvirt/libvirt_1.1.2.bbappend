FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
    file://fix-qemu-cmd-1.1.2.patch \
" 

PACKAGECONFIG = "qemu yajl lxc test remote macvtap libvirtd netcf udev python"
