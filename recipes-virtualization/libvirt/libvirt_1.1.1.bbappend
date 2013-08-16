FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
    file://add-PVR-values-for-Freescale-64-bit-cores-1.1.1.patch \
" 

PACKAGECONFIG = "qemu yajl lxc test remote macvtap libvirtd netcf udev python"
