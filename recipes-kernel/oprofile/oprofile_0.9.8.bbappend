FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}"

SRC_URI_append = " \
           file://0001-add-e500mc-support.patch \
           file://0002-add-e6500-support.patch \
"

