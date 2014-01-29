DESCRIPTION = "Pattern Matcher Regex Analyzer"
SECTION = "pme"
LICENSE = "Freescale-EULA"
PR = "r6"
LIC_FILES_CHKSUM = "file://COPYING;md5=d2626c94d1a34e8c168bb23682afc98e"

SRCREV = "6c8c601232fe916b44a7683e0adee982ab1e0a36"
SRC_URI = "git://git.am.freescale.net/gitolite/sdk/pme_regex_analyzer.git"

S= "${WORKDIR}/git"

do_install() {
    install -m 755 -d ${D}/${bindir}
    install -m 755 -d ${D}/${datadir}/pme_regex_analyzer
    install -m 755 *.pl pmm_* ${D}/${bindir}
    install -m 644 COPYING README.txt ${D}/${datadir}/pme_regex_analyzer
}

FILES_${PN} += "${datadir}/pme_regex_analyzer"

BBCLASSEXTEND = "native nativesdk"
