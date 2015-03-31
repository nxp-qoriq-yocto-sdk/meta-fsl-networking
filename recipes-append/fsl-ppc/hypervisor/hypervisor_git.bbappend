SRC_URI = " \
	${URL-HYPERVISOR};name=hypervisor \
	git://git.freescale.com/ppc/sdk/hypervisor/kconfig.git;name=kconfig;destsuffix=git/kconfig;nobranch=1 \
	${URL-LIBOS};name=libos;destsuffix=git/libos \
	git://git.kernel.org/pub/scm/utils/dtc/dtc.git;name=dtc;destsuffix=dtc \
	git://git.freescale.com/ppc/sdk/hypertrk.git;name=hypertrk;destsuffix=git/hypertrk;nobranch=1 \
	file://81-fsl-embedded-hv.rules \
"

SRCREV_FORMAT="hypervisor"
SRCREV = "${SHA-HYPERVISOR}"
SRCREV_kconfig = "a56025d4da992b856796b0eccac2e410d751dbac"
SRCREV_libos = "${SHA-LIBOS}"
SRCREV_dtc = "a6d55e039fd22048687fe061b4609e2807efe764"
SRCREV_hypertrk = "975c98b562186afbd3bbf103ae54b96cf9b3e533"
