DESCRIPTION = "A library which provides easy access to huge pages of memory"
SECTION = "libhugetlbfs"
LICENSE = "LGPLv2.1"
PR = "r5"

DEPENDS = "sysfsutils perl"
RDEPENDS_${PN} += "python python-io python-lang python-subprocess python-resource"

LIC_FILES_CHKSUM = "file://LGPL-2.1;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRCREV = "03687a4235f9e1bb972dd13f16792e4adf2ebb17"
SRC_URI = " git://libhugetlbfs.git.sourceforge.net/gitroot/libhugetlbfs/libhugetlbfs \
        	file://0001-Allow-compiler-to-be-override-regardless-of-32-or-64.patch \
	        file://0002-Fix-cross-compiling-on-PPC.patch \
	        file://0003-libhugetlbfs-Remove-segment-based-alignment-restric.patch \
	        file://0004-tests-run_tests.py-fix-typo-in-test-invocation.patch \
	        file://skip-checking-LIB32-and-LIB64-if-they-point-to-the-s.patch \
"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'ARCH=${TARGET_ARCH}' 'OPT=${CFLAGS}' 'CC=${CC}' BUILDTYPE=NATIVEONLY"
CFLAGS += "-fexpensive-optimizations -frename-registers -fomit-frame-pointer -g0"

do_install() {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install
}

PARALLEL_MAKE_pn-${PN} = ""

PACKAGES += "${PN}-perl"
FILES_${PN}-perl = "${libdir}/perl5"
