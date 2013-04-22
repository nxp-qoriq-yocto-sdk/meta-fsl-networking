DESCRIPTION = "skmm host driver offload data to PCIe EP and push the data en-decrypted back to application"
SECTION = "c293-skmm-host"
LICENSE = "Freescale EULA"
LIC_FILES_CHKSUM = "file://Makefile;endline=7;md5=14a432c6c88303f3e573ce4c11e86ac6"

inherit  module

SRC_URI = "git://bus.ap.freescale.net/scm/c29x/c293_skmm_host.git"
SRCREV = "${AUTOREV}"

EXTRA_OEMAKE='KERNEL_DIR="${STAGING_KERNEL_DIR}" PREFIX="${D}"'

S = "${WORKDIR}/git"

FILES_${PN} += "/etc/skmm/"
