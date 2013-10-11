# Freescale networking BSP git url/commit for FSL private packages

#================== FSL packages managed by sdk-devel.git ================#
# asf
URL-ASF = "git://git.am.freescale.net/gitolite/asf.git"
SHA-ASF = "${AUTOREV}"

# flib
URL-FLIB = "git://git.am.freescale.net/gitolite/sdk/flib.git"
SHA-FLIB = "${AUTOREV}"

# fmc
URL-FMC = "git://git.am.freescale.net/gitolite/dpaa-modules/fmc.git"
SHA-FMC = "${AUTOREV}"

# fmlib
URL-FMLIB = "git://git.am.freescale.net/gitolite/dpaa-modules/fmlib.git"
SHA-FMLIB = "${AUTOREV}"

# fm-ucode
URL-FMUCODE = "git://git.am.freescale.net/gitolite/dpaa-modules/fm-ucode.git"
SHA-FMUCODE = "${AUTOREV}"

# hypervisor
URL-HYPERVISOR = "git://git.am.freescale.net/gitolite/hv/hypervisor.git;name=hypervisor \
	        git://git.am.freescale.net/gitolite/hv/kconfig.git;name=kconfig;destsuffix=git/kconfig \
			git://git.am.freescale.net/gitolite/hv/libos.git;name=libos;destsuffix=git/libos \
		    git://www.jdl.com/software/dtc.git;name=dtc;destsuffix=dtc \
		    git://git.freescale.com/ppc/sdk/hypertrk.git;name=hypertrk;destsuffix=git/hypertrk \
		    file://81-fsl-embedded-hv.rules \
"
SHA-HYPERVISOR = "ac860fabba52ac4bb0f71a6a81d164f36dc1f612"
SHA-KCONFIG = "a56025d4da992b856796b0eccac2e410d751dbac"
SHA-LIBOS = "8090dcca97827defd545cf2eb015bcee016dd540"

# libppc
URL-LIBPPC = "git://git.am.freescale.net/gitolite/libppc.git"
SHA-LIBPPC = "fd5d8798663f7a55ff249c5d0a41cf80a02534a2"

# linux
URL-LINUX =  "git://git.am.freescale.net/gitolite/sdk/linux-devel.git"
SHA-LINUX = "${AUTOREV}"

# pme-tools
URL-PMETOOLS = "git://git.am.freescale.net/gitolite/pme_tools.git"
SHA-PMETOOLS = "549a22328672ad0ae76835105ad5e95ece2f7b21"

# rcw
URL-RCW = "git://git.am.freescale.net/gitolite/sdk/rcw.git"
SHA-RCW = "${AUTOREV}"


# u-boot
URL-UBOOT = "git://git.am.freescale.net/gitolite/sdk/u-boot-devel.git"
SHA-UBOOT = "${AUTOREV}"

# usdpaa
URL-USDPAA = "git://git.am.freescale.net/gitolite/usdpaa.git"
SHA-USDPAA = "${AUTOREV}"



#================== FSL packages out side of sdk-devel.git ================#
# hv-test
URL-HVTEST = "git://git.am.freescale.net/gitolite/hv/hv-test.git"
SHA-HVTEST = "2660090f9869b5364362dfb63302f89da03f7b63"

# skmmhost
URL-SKMMHOST = "git://git.am.freescale.net/gitolite/users/b21284/skmm-host.git"
SHA-SKMMHOST = "32284e0b3e2307b107f84e31ea8ca864af83972c"

