FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
    file://qemu.conf \
"

PACKAGECONFIG = "qemu yajl lxc test remote macvtap libvirtd netcf udev python"

do_install_append() {
	install -m 0644 ${WORKDIR}/qemu.conf ${D}/etc/libvirt/qemu.conf
}
