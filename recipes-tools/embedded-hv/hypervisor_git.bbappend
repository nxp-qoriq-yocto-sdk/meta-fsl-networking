FILESEXTRAPATHS_prepend_fsl-networking := "${THISDIR}/files:"

PR_append_fsl-networking = "+fsl_ppc_private.3"

SRC_URI_append_fsl-networking = " \
	git://git.am.freescale.net/gitolite/sdk/hypertrk.git;name=hypertrk;destsuffix=git/hypertrk \
"
SRCREV_hypertrk_fsl-networking = "975c98b562186afbd3bbf103ae54b96cf9b3e533"

PKG_HV_HYPERTRK_SUPPORT_fsl-networking="n"

do_compile_prepend_fsl-networking () {
    if [ "${PKG_HV_HYPERTRK_SUPPORT}" == "y" ]
    then
        oe_runmake silentoldconfig
        export HV_DIR=$PWD
        cd hypertrk
        oe_runmake deploy
        cd ..
    fi
}
