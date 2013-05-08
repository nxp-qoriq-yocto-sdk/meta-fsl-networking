FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 4}"

SRC_URI_append = " file://fix-qemu-cmd-${PV}.patch"

PACKAGECONFIG = "qemu yajl lxc test remote macvtap libvirtd netcf udev python"
