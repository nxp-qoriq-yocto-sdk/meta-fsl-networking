SUMMARY = "Linux IPC KERNEL MODULE "
DESCRIPTION = "DSP boot application and ipc test application"
LICENSE = "BSD"

# no COPYING file in current git tree, need to be fixed
LIC_FILES_CHKSUM = "file://../COPYING;md5=fa38cd73d71527dc6efb546474f64d10"

inherit  module

DEPENDS = "virtual/kernel"

COMPATIBLE_MACHINE = "(bsc9132qds|bsc9131rdb|b4860qds)"

SRCREV = "f9d9114675e6a30fd51af79dc7b0d2a76e1f2a4f"
SRC_URI = " git://git.am.freescale.net/gitolite/sdk/ipc.git\
"


S = "${WORKDIR}/git/kernel"
python () {
        ma = d.getVar("DISTRO_FEATURES", True)
        arch = d.getVar("OVERRIDES", True)

        # the : after the arch is to skip the message on 64b
        if not "multiarch" in ma and ("e5500:" in arch or "e6500:" in arch):
                raise bb.parse.SkipPackage("Building the kernel for this arch requires multiarch to be in DISTRO_FEATURES")

        promote_kernel = d.getVar('BUILD_64BIT_KERNEL')

        if promote_kernel == "1":
                d.setVar('KERNEL_CC_append', ' -m64')
                d.setVar('KERNEL_LD_append', ' -melf64ppc')

        error_qa = d.getVar('ERROR_QA', True)
        if 'arch' in error_qa:
                d.setVar('ERROR_QA', error_qa.replace(' arch', ''))
}



do_compile_prepend () {
    case ${MACHINE} in
        bsc9132qds|bsc9131rdb) SOC=B913x;;
        b4860qds) SOC=B4860;;
    esac
}
