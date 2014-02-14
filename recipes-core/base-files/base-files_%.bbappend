do_install_append () {
   echo "export COLUMNS=2000" >> ${D}${sysconfdir}/profile
}

