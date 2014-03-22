SUMMARY = "core packagegroup for fsl SDK"
LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = "\
    packagegroup-fsl-core \
    packagegroup-fsl-distro \
    packagegroup-fsl-machine \
    ${@base_contains('DISTRO_FEATURES', 'benchmark', 'packagegroup-fsl-core-benchmark', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'vfat', 'packagegroup-fsl-core-vfat', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'ext2', 'packagegroup-fsl-core-ext2', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'mtd', 'packagegroup-fsl-core-mtd', '',d)} \
    packagegroup-fsl-core-misc \
"

RDEPENDS_packagegroup-fsl-core = "\
    packagegroup-fsl-distro \
    packagegroup-fsl-machine \
    ${@base_contains('DISTRO_FEATURES', 'benchmark', 'packagegroup-fsl-core-benchmark', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'vfat', 'packagegroup-fsl-core-vfat', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'ext2', 'packagegroup-fsl-core-ext2', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'mtd', 'packagegroup-fsl-core-mtd', '',d)} \
    packagegroup-fsl-core-misc \
"

DEPENDS_packagegroup-fsl-distro = "${DISTRO_EXTRA_DEPENDS}"
RDEPENDS_packagegroup-fsl-distro = "${DISTRO_EXTRA_RDEPENDS}"
RRECOMMENDS_packagegroup-fsl-distro = "${DISTRO_EXTRA_RRECOMMENDS}"
RDEPENDS_packagegroup-fsl-machine = "${MACHINE_EXTRA_RDEPENDS}"
RRECOMMENDS_packagegroup-fsl-machine = "${MACHINE_EXTRA_RRECOMMENDS}"

RDEPENDS_packagegroup-fsl-core-benchmark = "\
"
RRECOMMENDS_packagegroup-fsl-core-benchmark = "\
    iperf \
    iozone3 \
    lmbench \
    netperf \
"

RRECOMMENDS_packagegroup-fsl-core-vfat = "\
    dosfstools \
"

RDEPENDS_packagegroup-fsl-core-ext2 = "\
    hdparm \
    e2fsprogs \
    e2fsprogs-badblocks \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-tune2fs \
"

RDEPENDS_packagegroup-fsl-core-mtd = "\
    mtd-utils \
    mtd-utils-jffs2 \
    mtd-utils-ubifs \
"

RDEPENDS_packagegroup-fsl-core-misc = "\
    bash \
    coreutils \
    elfutils \
    ethtool \
    file \
    iproute2 \
    iptables \
    iputils \
    kernel-modules \
    kmod \
    mdadm \
    net-tools \
    pkgconfig \
    procps \
    psmisc \
    sysfsutils \
    sysklogd \
    sysstat \
    util-linux \
"

RRECOMMENDS_packagegroup-fsl-core-misc = "\
    bridge-utils \
    i2c-tools \
    inetutils \
    ipsec-tools \
    libhugetlbfs \
    lmsensors-sensors \
    tcpdump \
"
