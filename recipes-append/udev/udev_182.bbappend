FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI_append = " file://udev-fix-kernel-hang-issue.patch;patchdir=../"
