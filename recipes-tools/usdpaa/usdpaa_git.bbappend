PRINC := "${@int(PRINC) + 2}"

SRC_URI = "${URL-USDPAA}"
SRCREV = "${SHA-USDPAA}"

do_compile_prepend () {
	case ${MACHINE} in
		b4420qds|b4420qds-64b|b4860qds|b4860qds-64b) SOC=B4860;;
		t4240qds|t4240qds-64b) SOC=T4240;;
		p1023rdb) SOC=P1023;;
		*) SOC=P4080;;
	esac
	export FMC_EXTRA_CFLAGS="-I ${STAGING_INCDIR}/fmc"
	export FMLIB_EXTRA_CFLAGS="-I ${STAGING_INCDIR}/fmd \
				-I ${STAGING_INCDIR}/fmd/Peripherals \
				-I ${STAGING_INCDIR}/fmd/integrations \
				-D $SOC"
}
