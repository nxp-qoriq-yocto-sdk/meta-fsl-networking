FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR_append = "+fsl.4"

SRC_URI_append = " \
	git://git.am.freescale.net/gitolite/sdk/hypertrk.git;name=hypertrk;destsuffix=git/hypertrk \
"
SRCREV_hypertrk = "975c98b562186afbd3bbf103ae54b96cf9b3e533"

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
