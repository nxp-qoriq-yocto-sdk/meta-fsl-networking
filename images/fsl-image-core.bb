#PRIVATE_FULL = "yes"

require images/fsl-image-flash.bb
require images/fsl-image-private.inc

PRINC := "${@int(PRINC) + 3}"

# common opensource packages
# FIXME: add bridge-utils back
IMAGE_INSTALL += " \
    kernel-modules \
    bridge-utils \
    coreutils \
    elfutils \
    ethtool \
    file \
    hdparm \
    i2c-tools \
    inetutils \
    iozone3 \
    iperf \
    iproute2 \
    ipsec-tools \
    iptables \
    iputils \
    lmbench \
    mdadm \
    netperf \
    pkgconfig \
    procps \
    psmisc \
    tcpdump \
    libhugetlbfs \
"
