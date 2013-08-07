DESCRIPTION = "A library which provides easy access to huge pages of memory"
SECTION = "libhugetlbfs"
LICENSE = "LGPLv2.1"

DEPENDS = "sysfsutils perl"
RDEPENDS_${PN} += "python python-io python-lang python-subprocess python-resource"

LIC_FILES_CHKSUM = "file://LGPL-2.1;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRCREV = "7649454b6fed355bf53517d5106ae211b533aced"
SRC_URI = " git://libhugetlbfs.git.sourceforge.net/gitroot/libhugetlbfs/libhugetlbfs \
        	file://0001-Allow-compiler-to-be-override-regardless-of-32-or-64.patch \
	        file://0002-Fix-cross-compiling-on-PPC.patch \
	        file://0003-libhugetlbfs-Remove-segment-based-alignment-restric.patch \
	        file://0004-tests-run_tests.py-fix-typo-in-test-invocation.patch \
	        file://skip-checking-LIB32-and-LIB64-if-they-point-to-the-s.patch \
	        file://libhugetlbfs-Fix-perl-lib-can-not-be-shiped-to-sub-p.patch \
	        file://0001-install-perl-lib-to-directory-perl-instead-of-perl5.patch \
                file://checks-if-mtab-is-a-symlink.patch \
                file://0001-libhugetlbfs-avoid-search-host-library-path-for-cros.patch \
                file://tests-Makefile-install-static-4G-edge-testcases.patch \
"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'ARCH=${TARGET_ARCH}' 'OPT=${CFLAGS}' 'CC=${CC}' BUILDTYPE=NATIVEONLY"
CFLAGS += "-fexpensive-optimizations -frename-registers -fomit-frame-pointer -g0"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} \
          INST_TESTSDIR32=/opt/libhugetlbfs/tests \
          INST_TESTSDIR64=/opt/libhugetlbfs/tests \
          install-tests
}

PARALLEL_MAKE_pn-${PN} = ""

PACKAGES =+ "${PN}-perl ${PN}-tests"
FILES_${PN}-dbg += "${libdir}/libhugetlbfs/tests/obj32/.debug ${libdir}/libhugetlbfs/tests/obj64/.debug"
FILES_${PN}-perl = "${libdir}/perl"
FILES_${PN}-tests += "/opt/libhugetlbfs/tests"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP_${PN}-tests += "dev-deps"

