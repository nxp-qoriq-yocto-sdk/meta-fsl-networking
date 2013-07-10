require flash-image.inc

UBOOT_ENV = "uboot_env_nand.txt"
FLASH_MAP = "flashmap_nand.cfg"

IMAGE_NAME = "${IMAGE_TAG}_${MACHINE}_${DATE}_NAND_FLASH.bin"
SCRIPT_OPTION += "-o ${IMAGE_NAME}"
SCRIPT_OPTION_append_p1023rds = " -e ${MACHINE}/${UBOOT_ENV} -o ${IMAGE_NAME}"

COMPATIBLE_MACHINE = "(p1010rdb|p1020rdb|p1021rdb|p1022ds|p1024rdb|p2020rdb|p1023rds)"

