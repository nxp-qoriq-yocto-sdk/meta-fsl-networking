# cryptodev-linux is replaced with FSL cryptodev-headers
# The native package does not require cryptodev kernel module at runtime so we
# set the dependency only for class-target
DEPENDS_remove="cryptodev-linux"
DEPENDS +="cryptodev-headers"
RDEPENDS_${PN}_class-target="cryptodev"

# the same patches are used for both class-native and class-target but the
# base package is taken from Freescale repository
SRC_URI = "git://git.am.freescale.net/gitolite/sdk/openssl.git;nobranch=1"
SRCREV = "7a6848210c3b2f42aed4de60646e0e63c0e35fcb"

SRC_URI += "file://configure-targets.patch \
            file://shared-libs.patch \
            file://oe-ldflags.patch \
            file://engines-install-in-libdir-ssl.patch \
            file://openssl-fix-link.patch \
            file://debian/version-script.patch \
            file://debian/pic.patch \
            file://debian/c_rehash-compat.patch \
            file://debian/ca.patch \
            file://debian/make-targets.patch \
            file://debian/no-rpath.patch \
            file://debian/man-dir.patch \
            file://debian/man-section.patch \
            file://debian/no-symbolic.patch \
            file://debian/debian-targets.patch \
            file://openssl_fix_for_x32.patch \
            file://openssl-fix-doc.patch \
            file://fix-cipher-des-ede3-cfb1.patch \
            file://openssl-avoid-NULL-pointer-dereference-in-EVP_DigestInit_ex.patch \
            file://openssl-avoid-NULL-pointer-dereference-in-dh_pub_encode.patch \
            file://initial-aarch64-bits.patch \
            file://find.pl \
            file://openssl-fix-des.pod-error.patch \
           "
S = "${WORKDIR}/git"
