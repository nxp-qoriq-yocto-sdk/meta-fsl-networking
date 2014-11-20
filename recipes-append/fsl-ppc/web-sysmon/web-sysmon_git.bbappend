SRC_URI = "git://git.am.freescale.net/gitolite/users/b38951/web-sysmon-dev.git"
SRCREV = "a77aa8484a4fc2c6d460ad796228fd1d29f45dea"

inherit update-rc.d

EXTRA_OEMAKE += "D=${D}"

do_install () {
	oe_runmake install
}

INITSCRIPT_NAME = "web-sysmon.sh"
INITSCRIPT_PARAMS = "defaults 99 20"
