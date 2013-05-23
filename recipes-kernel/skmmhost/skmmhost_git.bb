DESCRIPTION = "skmm host driver offload data to PCIe EP and push the data en-decrypted back to application"
SECTION = "c293-skmm-host"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://Makefile;endline=7;md5=14a432c6c88303f3e573ce4c11e86ac6"

inherit  module

SRC_URI = "${URL-SKMMHOST}"
SRCREV = "${SHA-SKMMHOST}"

EXTRA_OEMAKE='KERNEL_DIR="${STAGING_KERNEL_DIR}" PREFIX="${D}"'

S = "${WORKDIR}/git"

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

FILES_${PN} += "/etc/skmm/"
