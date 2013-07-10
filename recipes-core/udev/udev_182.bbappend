FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 3}"

SRC_URI += "file://disable-rpmb.patch"

