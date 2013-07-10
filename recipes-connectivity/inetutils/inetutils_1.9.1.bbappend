do_install_append () {

        mv ${D}${bindir}/ping6 ${D}${base_bindir}/ping6.${BPN}
}

