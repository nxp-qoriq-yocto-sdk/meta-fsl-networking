DESCRIPTION = "Generate flash images"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=457d7f1ad0c73c7102bc0563e8cb9aac"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r5"
inherit deploy

S = "${WORKDIR}/git"

SRC_URI = "git://git.am.freescale.net/gitolite/users/b28495/flash-image-tool.git"
SRCREV = "dfb75537fe88142d73badc7d6c26cc11126b7d80"

FLASH_MAP ?= "flashmap.cfg"
UBOOT_ENV ?= "uboot_env.txt"
ROOTFS_TYPE ?= "fsl-image-flash"

IMAGE_TAG ?= "QorIQ_SDK_V1.6"
IMAGE_NAME ?= "${IMAGE_TAG}_${MACHINE}_${DATE}_FLASH.bin"

SCRIPT_NAME ?= "gen_flash_image.pl"
SCRIPT_OPTION ?= "-c ${MACHINE}/${FLASH_MAP} -d ${DEPLOY_DIR_IMAGE} -t ${IMAGE_TAG}"

do_deploy () {
    perl ./${SCRIPT_NAME} ${SCRIPT_OPTION}
    install -d ${DEPLOYDIR}/
    install -m 644 ${S}/${IMAGE_NAME} ${DEPLOYDIR}/
}
addtask deploy before do_build after do_install

do_deploy_append_mpc8548cds () {
    #For MPC8548CDS, the generated image is 16MB. This image needs to be split 
    #to be flashed into the two discrete 8MB flash devices
    split -b 8m ${IMAGE_NAME}
    mv xaa ${IMAGE_NAME}_#1
    mv xab ${IMAGE_NAME}_#0
    install -m 644 ${S}/${IMAGE_NAME}_* ${DEPLOYDIR}/
}

do_deploy_mpc8544ds () {
    perl ./${SCRIPT_NAME} ${SCRIPT_OPTION} -p
    # mpc8444ds flash_size:8192k, uboot_env (environment.bin) overlaps the last 64k
    split -b 8128k ${IMAGE_NAME}
    cat xaa environment.bin xab >${IMAGE_NAME}.tmp
    dd if=${IMAGE_NAME}.tmp of=${IMAGE_NAME} bs=1K count=8192
    install -d ${DEPLOYDIR}/
    install -m 644 ${S}/${IMAGE_NAME} ${DEPLOYDIR}/
}


ALLOW_EMPTY_${PN} = "1"

do_deploy[nostamp] = "1"
do_deploy[depends] += "${ROOTFS_TYPE}:do_rootfs"

