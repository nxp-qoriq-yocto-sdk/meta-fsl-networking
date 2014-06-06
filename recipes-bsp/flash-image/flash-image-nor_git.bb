require flash-image.inc

UBOOT_ENV = "uboot_env_nor.txt"
FLASH_MAP = "flashmap_nor.cfg"

IMAGE_NAME = "${IMAGE_TAG}_${MACHINE}_${DATE}_NOR_FLASH.bin"
SCRIPT_OPTION_append = " -e ${MACHINE}/${UBOOT_ENV} -o ${IMAGE_NAME}"

