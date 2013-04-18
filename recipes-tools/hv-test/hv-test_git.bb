DESCRIPTION = "Hypervisor Tests"
SECTION = "hv-test"
LICENSE = "BSD"
PR = "r3"
LIC_FILES_CHKSUM = "file://test/Makefile;endline=22;md5=8c01493cac52b32609798388f739d624"

DEPENDS = "u-boot-mkimage-native"

# need this to avoid splitting into .debug folders that mess up the final
# packaging
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

inherit deploy

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"

# TODO: fix dtc to use the already built package
SRC_URI = " \
	git://git.am.freescale.net/gitolite/hv/hv-test.git;name=hv-test \
	git://git.am.freescale.net/gitolite/hv/kconfig.git;name=kconfig;destsuffix=git/kconfig \
	git://git.am.freescale.net/gitolite/hv/libos.git;name=libos;destsuffix=git/libos \
	git://git.am.freescale.net/gitolite/mirrors/dtc.git;name=dtc;destsuffix=git/dtc \
	  "

SRCREV_FORMAT="hypervisor"
SRCREV_dtc = "033089f29099bdfd5c2d6986cdb9fd07b16cfde0"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'
EXTRA_OEMAKE_powerpc64 = 'GUEST64=y CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

DEFCONFIG_e500mc = "e500mc_defconfig"
DEFCONFIG_e500v2 = "e500v2_defconfig"
DEFCONFIG_e5500 = "e500mc_defconfig"
DEFCONFIG_powerpc64 = "corenet64_defconfig"

do_configure () {
	cd test
	oe_runmake ${DEFCONFIG}
}

# build unit tests plus DTBs
do_compile () {
	cd test
	oe_runmake
	cd ../kvm
	oe_runmake
}

do_install () {
        find ${S} -name .git | xargs rm -rf
	rm -rf ${S}/test/output/bin
	mkdir -p ${D}/usr/src/
	cp -a ${S} ${D}/usr/src/hv-test
}

FILES_${PN} += "/usr/src/hv-test"

PACKAGES = "${PN}"

RDEPENDS_${PN} = " \
                qemu \
                lxc \
                make \
                python-pexpect \
                python-stringold \
                python-logging \
                gzip \
                socat \
                mingetty \
                inetutils \
                kernel-image \
"
