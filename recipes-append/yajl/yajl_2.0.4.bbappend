PRINC := "${@int(PRINC) + 1}"

EXTRA_OECMAKE = "-DLIB_SUFFIX=${@d.getVar('baselib',True).replace('lib','')}"
