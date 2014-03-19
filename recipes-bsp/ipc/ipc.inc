DEPENDS = "virtual/kernel"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/ipc.git;branch=sdk_devel"
SRCREV = "cd730ccba14f591c19ae4fef0e73b7bbcfc9262d"

PVBASE := "0.0"
PV := "${PVBASE}+git${SRCPV}"

COMPATIBLE_MACHINE = "(bsc9132qds|bsc9131rdb|b4860qds)"

