FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://tests-Makefile-install-static-4G-edge-testcases.patch \
                   file://0001-run_test.py-not-use-hard-coded-path-.-obj-hugeadm.patch \
                   file://0001-install-perl-lib-to-directory-perl-instead-of-perl5.patch \
"

