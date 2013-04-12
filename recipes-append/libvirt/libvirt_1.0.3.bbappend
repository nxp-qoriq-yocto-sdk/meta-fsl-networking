FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI_append = " file://fix-qemu-cmd-${PV}.patch"

PACKAGECONFIG ??= "qemu yajl polkit lxc test remote macvtap libvirtd netcf"
