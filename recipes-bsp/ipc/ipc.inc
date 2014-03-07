DEPENDS = "virtual/kernel"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/ipc.git;branch=sdk_devel"
SRCREV = "cee9afc838693862f1fe8ae413b87bec12bc0423"

PVBASE := "0.0"
PV := "${PVBASE}+git${SRCPV}"

COMPATIBLE_MACHINE = "(bsc9132qds|bsc9131rdb|b4860qds)"

