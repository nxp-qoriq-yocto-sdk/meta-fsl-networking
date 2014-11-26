SRC_URI = "git://git.am.freescale.net/gitolite/users/b38951/web-sysmon-dev.git"
SRCREV = "0a2ab29cc7799eb7aeb72e26130289ee95dddaff"

inherit update-rc.d

EXTRA_OEMAKE += "D=${D}"

do_install () {
	oe_runmake install
}

INITSCRIPT_NAME = "web-sysmon.sh"
INITSCRIPT_PARAMS = "defaults 99 20"
