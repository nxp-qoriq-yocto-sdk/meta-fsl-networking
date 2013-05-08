SUMMARY = "extend packagegroup for fsl SDK"
LICENSE = "MIT"

inherit packagegroup

# packages in oe-core
RDEPENDS_packagegroup-fsl-extend = "\
    alsa-lib \
    alsa-utils \
    bind \
    bison \
    ccache \
    chkconfig \
    curl \
    db \
    dhcp-client \
    diffstat \
    expat \
    gdbm \
    genext2fs \
    gettext-runtime \
    git \
    groff \
    hdparm \
    intltool \
    libaio \
    libusb1 \
    libxml2 \
    lsb \
    lsbtest \
    lsof \
    man \
    man-pages \
    mdadm \
    oprofile \
    parted \
    perf \
    perl \
    perl-misc \
    perl-module-re \
    perl-pod \
    portmap \
    ppp \
    ppp-dialin \
    python \
    python-misc \
    python-modules \
    quilt \
    readline \
    rpm \
    rt-tests \
    sqlite3 \
    u-boot-mkimage \
    tcl \
    unzip \
    usbutils \
    valgrind \
    watchdog \
    which \
    xinetd \
    zip \
"

# packages in meta-oe
RRECOMMENDS_packagegroup-fsl-extend = "\
    bonnie++ \
    bridge-utils \
    cramfs \
    dbench \
    debianutils \
    i2c-tools \
    inetutils \
    iozone3 \
    iperf \
    ipsec-tools \
    libnfnetlink \
    lmbench \
    lmsensors \
    netperf \
    ptpd \
    rng-tools \
    rp-pppoe \
    samba \
    strongswan \
    tcpdump \
    tiobench \
    wget \
"

# packages in meta-virtualization
RRECOMMENDS_packagegroup-fsl-extend += "\
    lxc \
    libvirt \
    libvirt-libvirtd \
    libvirt-virsh \
"
