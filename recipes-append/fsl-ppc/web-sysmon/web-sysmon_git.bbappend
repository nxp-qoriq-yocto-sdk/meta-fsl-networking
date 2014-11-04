SRC_URI = "git://git.am.freescale.net/gitolite/users/b38951/web-sysmon-dev.git"
SRCREV = "0122ddeee7136e82bc44dcf89235c075a73ffbc6"

inherit update-rc.d

EXTRA_OEMAKE += "D=${D}"

do_install () {
	oe_runmake install
}

INITSCRIPT_NAME = "web-sysmon.sh"
INITSCRIPT_PARAMS = "defaults 99 20"
