DESCRIPTION = "The stack images of ptp"
LICENSE = "IXXAT-EULA"
LIC_FILES_CHKSUM = "file://ptp_b4860;md5=3ecc86ad31dfd97f240f3d116bab5977"

SRC_URI = "git://git.am.freescale.net/gitolite/sdk/ixxat-demopackage.git"
SRCREV = "8b8355a3ccb573361ddeaa3ae5ee405b1e1691c7"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}/${bindir}

    case ${MACHINE} in
        b4860qds)
            PTP_BINARY=ptp_b4860;;
        bsc9131rdb)
            PTP_BINARY=ptp_bsc9131;;
        t2080rdb)
            PTP_BINARY=ptp_t2080rdb;;
    esac

    install -m 755 ${PTP_BINARY} ${D}/${bindir}
}

INSANE_SKIP_${PN} += "ldflags"

COMPATIBLE_MACHINE = "(b4860qds|bsc9131rdb|t2080rdb)"
