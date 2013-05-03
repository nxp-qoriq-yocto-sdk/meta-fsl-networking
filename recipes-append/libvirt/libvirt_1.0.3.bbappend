FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 3}"

SRC_URI_append = " file://fix-qemu-cmd-${PV}.patch"

DEPENDS_append = " libpciaccess augeas"

PACKAGECONFIG ??= "qemu yajl polkit lxc test remote macvtap libvirtd netcf"
