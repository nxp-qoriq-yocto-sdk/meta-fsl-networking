FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

require linux-qoriq-sdk.inc

SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"
