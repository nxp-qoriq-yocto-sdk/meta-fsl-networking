require flash-image.inc

UBOOT_ENV = "uboot_env_nor.txt"
FLASH_MAP = "flashmap_nor.cfg"

IMAGE_NAME = "${IMAGE_TAG}_${MACHINE}_${DATE}_NOR_FLASH.bin"
SCRIPT_OPTION += "-e ${MACHINE}/${UBOOT_ENV} -o ${IMAGE_NAME}"

COMPATIBLE_MACHINE = "(p2041rdb|p3041ds|p4080ds|p5020ds|p5020ds-64b|p5040ds|p5040ds-64b|mpc8536ds|mpc8544ds|mpc8548cds|mpc8572ds|p1010rdb|p1020rdb|p1020utm|p1020mbg|p1021rdb|p1022ds|p1024rdb|p1025rdb|p2020rdb)"

