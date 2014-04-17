require openssl_1.0.1e.inc

RDEPENDS_${PN} += "cryptodev"
DEPENDS_remove = "ocf-linux"
DEPENDS += "cryptodev-headers"
FILESEXTRAPATHS := "${THISDIR}/openssl-1.0.1e-oe"

SRC_URI = " git://git.am.freescale.net/gitolite/sdk/openssl.git;nobranch=1 "
SRCREV = "8138bc1ebaf9c37bd0e412747e864d3242a3ea26"

SRC_URI += " file://find.pl \
	file://openssl-fix-doc.patch \
	file://engines-install-in-libdir-ssl.patch \
	file://CVE-2014-0160.patch \
	"
# Digest offloading through cryptodev is not recommended because of the
# performance penalty of the Openssl engine interface. Openssl generates a huge
# number of calls to digest functions for even a small amount of work data.
# For example there are 70 calls to cipher code and over 10000 to digest code
# when downloading only 10 files of 700 bytes each.
# Do not build OpenSSL with cryptodev digest support until engine digest
# interface gets some rework:
CFLAG := "${@'${CFLAG}'.replace('-DUSE_CRYPTODEV_DIGESTS', '')}"

DEFAULT_PREFERENCE = "-1"
S = "${WORKDIR}/git"
