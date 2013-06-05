DESCRIPTION = "User space application for Pattern Matcher"
LICENSE = "Freescale-EULA"
PR = "r2"
DEPENDS="libedit"
LIC_FILES_CHKSUM = "file://Freescale_Software_License.txt;md5=01425ba2740a00e5f5402177fa741238"

SRC_URI = " file://fsl_pme-${PV}.tar.gz \
            file://fsl_pme-${PV}-updates-to-build-and-modprobe.conf.patch;striplevel=2 \
            file://fsl_pme-${PV}-Code-Cleanup-fix-new-toolchain-warnings-etc.patch;striplevel=2 \
          "
S= "${WORKDIR}/fsl_pme-${PV}"


do_compile(){
    oe_runmake SYS_PATH=${STAGING_LIBDIR}/../
}

do_install() {
    install -d ${D}/fsl_pme ${D}/etc
    install -d ${D}/usr/sbin
    install bin/* ${D}/usr/sbin/
    install -m 644 sample* ${D}/fsl_pme/
    install -m 644 modprobe.conf ${D}/etc
    install -d ${D}/etc/hotplug
    install -m 755 misc.agent ${D}/etc/hotplug
}

FILES_${PN} += "/fsl_pme/*"

SRC_URI[md5sum] = "77dfb738d4a0b38b374fb2c008ee702b"
SRC_URI[sha256sum] = "50c11ab5729bcb98cf6757bfa4cca264429cdfd67c11ea952dbf214494d708b9"

INSANE_SKIP_${PN} += "ldflags"

