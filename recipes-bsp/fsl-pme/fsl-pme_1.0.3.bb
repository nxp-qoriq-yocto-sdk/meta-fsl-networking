DESCRIPTION = "User space application for Pattern Matcher"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://Freescale_Software_License.txt;md5=01425ba2740a00e5f5402177fa741238"

DEPENDS="libedit"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/fsl-pme.git"
SRCREV = "e9311b93b95426c4100ef6fcd2fb2937c6122e28"

S = "${WORKDIR}/git"

do_compile(){
    oe_runmake SYS_PATH=${STAGING_LIBDIR}/../
}

do_install() {
    install -d ${D}/opt/fsl_pme ${D}/etc
    install -d ${D}/usr/sbin
    install bin/* ${D}/usr/sbin/
    install -m 644 sample* ${D}/opt/fsl_pme/
    install -m 644 modprobe.conf ${D}/etc
    install -d ${D}/etc/hotplug
    install -m 755 misc.agent ${D}/etc/hotplug
}

FILES_${PN} += "/opt/fsl_pme/*"
INSANE_SKIP_${PN} += "ldflags"

