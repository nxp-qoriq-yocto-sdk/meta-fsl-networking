PRINC := "${@int(PRINC) + 2}"

inherit update-alternatives

ALTERNATIVE_NAME = "ifconfig"
ALTERNATIVE_LINK = "${base_sbindir}/ifconfig"
ALTERNATIVE_PATH = "${base_sbindir}/ifconfig.net-tools"
ALTERNATIVE_PRIORITY = "200"

