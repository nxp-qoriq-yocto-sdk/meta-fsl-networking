PRINC := "${@int(PRINC) + 3}"

inherit update-alternatives

ALTERNATIVE_${PN} = "ifconfig"
ALTERNATIVE_LINK_NAME[ifconfig] = "${base_sbindir}/ifconfig"
ALTERNATIVE_PRIORITY = "200"

