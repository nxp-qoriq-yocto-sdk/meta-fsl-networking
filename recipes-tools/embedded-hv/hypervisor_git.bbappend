FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI = " \
        git://git.am.freescale.net/gitolite/hv/hypervisor.git;name=hypervisor \
        git://git.am.freescale.net/gitolite/hv/kconfig.git;name=kconfig;destsuffix=git/kconfig \
        git://git.am.freescale.net/gitolite/hv/libos.git;name=libos;destsuffix=git/libos \
        git://www.jdl.com/software/dtc.git;name=dtc;destsuffix=dtc \
        file://81-fsl-embedded-hv.rules \
         "

SRC_URI_append = " \
	git://git.am.freescale.net/gitolite/sdk/hypertrk.git;name=hypertrk;destsuffix=git/hypertrk \
"

SRCREV_hypervisor = "${AUTOREV}"
SRCREV_kconfig = "${AUTOREV}"
SRCREV_libos = "${AUTOREV}"
SRCREV_hypertrk = "${AUTOREV}"

PKG_HV_HYPERTRK_SUPPORT = "n"

do_compile_prepend () {
    if [ "${PKG_HV_HYPERTRK_SUPPORT}" == "y" ]
    then
        oe_runmake silentoldconfig
        export HV_DIR=$PWD
        cd hypertrk
        oe_runmake deploy
        cd ..
    fi
}
