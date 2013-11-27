PRIVATE_FULL = "yes"

require images/fsl-image-flash.bb
require images/fsl-image-private.inc

PRINC := "${@int(PRINC) + 6}"

CORE_SPECIFIC = " \
    fm-ucode-image \
    rcw-image \
    hypervisor-image \
    hv-cfg-image \
"
CORE_SPECIFIC_e500v2 = ""
CORE_SPECIFIC_e6500 = " fm-ucode-image"
CORE_SPECIFIC_e6500-64b = " fm-ucode-image"

MACHINE_SPECIFIC = ""
MACHINE_SPECIFIC_p1023rds = " fm-ucode-image"
MACHINE_SPECIFIC_p1022ds = " packagegroup-fsl-x11"
MACHINE_SPECIFIC_b4420qds = " rcw-image"
MACHINE_SPECIFIC_b4420qds-64b = " rcw-image"
MACHINE_SPECIFIC_b4860qds = " rcw-image"
MACHINE_SPECIFIC_b4860qds-64b = " rcw-image"
MACHINE_SPECIFIC_t4240qds = " rcw-image"
MACHINE_SPECIFIC_t4240qds-64b = " rcw-image"

IMAGE_INSTALL += " \
    packagegroup-core-basic \
    packagegroup-core-nfs-server \
    packagegroup-core-buildessential \
    packagegroup-self-hosted-debug \
    packagegroup-fsl-extend \
    ${@multilib_pkg_extend(d, "gcc")} \
    ${@multilib_pkg_extend(d, "cpp")} \
    ${@multilib_pkg_extend(d, "g++")} \
    ${@multilib_pkg_extend(d, "binutils")} \
    ${@multilib_pkg_extend(d, "libgcc-dev")} \
    ${@multilib_pkg_extend(d, "eglibc-dev")} \
    ${@multilib_pkg_extend(d, "valgrind")} \
    u-boot-images \
    kernel-image \
    kernel-modules \
    kernel-devicetree \
    dtc \
    qemu \
    subversion \
    ${CORE_SPECIFIC} \
    ${MACHINE_SPECIFIC} \
"

IMAGE_FSTYPES = "tar.gz"
