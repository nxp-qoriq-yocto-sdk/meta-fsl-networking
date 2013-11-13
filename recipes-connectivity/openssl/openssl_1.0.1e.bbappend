DEPENDS = "cryptodev"
FILESEXTRAPATHS := "${THISDIR}/openssl-${PV}"

SRC_URI += "file://0001-remove-double-initialization-of-cryptodev-engine.patch \
	    file://0002-add-support-for-TLS-algorithms-offload.patch \
	    file://0003-workaround-for-ENG00289183.patch \
"

BBCLASSEXTEND = ""
