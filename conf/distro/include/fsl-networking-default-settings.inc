# Freescale networking BSP default settings

IMAGE_CLASSES = "image_types_uboot"
CCACHE = ""

MKUBIFS_ARGS ??= " -m 512 -e 15360 -c 3600 "
UBINIZE_ARGS ??= " -p 16KiB -m 512 -s 512 "

