require flash-image.inc

UBOOT_ENV = "uboot_env_nand.txt"
FLASH_MAP = "flashmap_nand.cfg"

IMAGE_NAME = "${IMAGE_TAG}_${MACHINE}_${DATE}_NAND_FLASH.bin"
SCRIPT_OPTION_append = " -o ${IMAGE_NAME}"
SCRIPT_OPTION_append_p1023rds = " -e ${MACHINE}/${UBOOT_ENV}"
SCRIPT_OPTION_append_bsc9131rdb = " -e ${MACHINE}/${UBOOT_ENV}"
SCRIPT_OPTION_append_bsc9132qds = " -e ${MACHINE}/${UBOOT_ENV}"

