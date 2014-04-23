DEPENDS = "virtual/kernel"

SRC_URI = "${URL-IPC}"
SRCREV = "${SHA-IPC}"

PVBASE := "0.0"
PV := "${PVBASE}+git${SRCPV}"

COMPATIBLE_MACHINE = "(bsc9132qds|bsc9131rdb|b4860qds|b4420qds)"

