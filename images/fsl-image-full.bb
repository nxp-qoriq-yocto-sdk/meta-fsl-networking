PRIVATE_FULL = "yes"

require images/fsl-image-flash.bb
require images/fsl-image-private.inc

PRINC := "${@int(PRINC) + 5}"

CORE_SPECIFIC = " \
    fm-ucode-image \
    rcw-image \
    hypervisor-image \
    hv-cfg-image \
"
CORE_SPECIFIC_e500v2 = ""
CORE_SPECIFIC_e6500 = " fm-ucode-image rcw-image"
CORE_SPECIFIC_e6500-64b = " fm-ucode-image rcw-image"

MACHINE_SPECIFIC = ""
MACHINE_SPECIFIC_p1023rds = " fm-ucode-image"
MACHINE_SPECIFIC_p1022ds = " packagegroup-fsl-x11"

IMAGE_INSTALL += " \
    packagegroup-core-basic \
    packagegroup-core-nfs-server \
    packagegroup-core-buildessential \
    packagegroup-self-hosted-debug \
    packagegroup-fsl-extend \
    ${@multilib_pkg_extend(d, "gcc")} \
    ${@multilib_pkg_extend(d, "binutils")} \
    ${@multilib_pkg_extend(d, "libgcc-dev")} \
    ${@multilib_pkg_extend(d, "eglibc-dev")} \
    u-boot-images \
    kernel-image \
    kernel-modules \
    dtc \
    qemu \
    ${CORE_SPECIFIC} \
    ${MACHINE_SPECIFIC} \
"

IMAGE_FSTYPES = "tar.gz"
