DESCRIPTION = "Put specified files into rootfs"
SECTION = "merge-files"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://../merge/README;endline=3;md5=48cfa72ed1089e8072eef6a9cb7518c4"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r10"

SRC_URI = "file://merge"
S = "${WORKDIR}/merge"

do_install () {
    find ${S}/ -maxdepth 1 -mindepth 1 -not -name README \
    -exec cp -fr '{}' ${D}/ \;
    find ${S}/ -maxdepth 1 -mindepth 1 -exec rm -fr '{}' \;
}
do_unpack[nostamp] = "1"
do_install[nostamp] = "1"

PACKAGES = "${PN}"
FILES_${PN} += "/*"
ALLOW_EMPTY_${PN} = "1"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = "debug-files dev-so"
