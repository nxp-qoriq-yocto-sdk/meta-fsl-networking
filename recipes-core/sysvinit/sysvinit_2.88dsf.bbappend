FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://auto-detect-hostname.patch;patchdir=../"
