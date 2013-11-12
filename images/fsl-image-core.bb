#PRIVATE_FULL = "yes"

require images/fsl-image-flash.bb
require images/fsl-image-private.inc

PRINC := "${@int(PRINC) + 4}"

# common opensource packages
# FIXME: add bridge-utils back
IMAGE_INSTALL += " \
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
    kernel-modules \
    libhugetlbfs \
    lmbench \
    lmsensors-sensors \
    mdadm \
    netperf \
    pkgconfig \
    procps \
    psmisc \
    tcpdump \
"

ROOTFS_POSTPROCESS_COMMAND += "find ${IMAGE_ROOTFS} -type f -name uImage* | xargs rm -rf; "
