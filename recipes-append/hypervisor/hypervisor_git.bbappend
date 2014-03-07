SRC_URI = " \
    ${URL-HV};name=hypervisor \
    ${URL-KCONFIG};name=kconfig;destsuffix=git/kconfig \
    ${URL-LIBOS};name=libos;destsuffix=git/libos \
    ${URL-DTC};name=dtc;destsuffix=dtc \
    git://git.freescale.com/ppc/sdk/hypertrk.git;name=hypertrk;destsuffix=git/hypertrk;nobranch=1 \
    file://81-fsl-embedded-hv.rules \
      "

SRCREV_FORMAT="hypervisor"
SRCREV = "${SHA-HV}"
SRCREV_kconfig = "${SHA-KCONFIG}"
SRCREV_libos = "${SHA-LIBOS}"
SRCREV_dtc = "${SHA-DTC}"
SRCREV_hypertrk = "975c98b562186afbd3bbf103ae54b96cf9b3e533"

