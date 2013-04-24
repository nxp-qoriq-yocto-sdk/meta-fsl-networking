PRINC := "${@int(PRINC) + 1}"

SRC_URI = "${URL-DTC}"
SRCREV = "${SHA-DTC}"

FILES_${PN}-dev = "${includedir} ${libdir}/libfdt*.so*"
