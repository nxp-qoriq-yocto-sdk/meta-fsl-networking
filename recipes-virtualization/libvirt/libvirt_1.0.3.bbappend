FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 5}"

SRC_URI_append = " file://fix-qemu-cmd-${PV}.patch \
                   file://add-PVR-values-for-Freescale-64-bit-cores-${PV}.patch "

PACKAGECONFIG = "qemu yajl lxc test remote macvtap libvirtd netcf udev python"
