SRC_URI = "${URL-SKMM-HOST}"
SRCREV = "${SHA-SKMM-HOST}"

LICENSE = "BSD & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=99803d8e9a595c0bdb45ca710f353813"

RDEPENDS_${PN} += "bc"

FILES_${PN} += " /etc/skmm/crypto.cfg \
	/usr/bin/c29x_skmm_perf_profile.sh \
"
