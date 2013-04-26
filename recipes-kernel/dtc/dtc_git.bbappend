PRINC := "${@int(PRINC) + 2}"

SRC_URI = "${URL-DTC}"
SRCREV = "e4b497f367a3b2ae99cc52089a14a221b13a76ef"

FILES_${PN}-dev = "${includedir} ${libdir}/libfdt*.so*"
