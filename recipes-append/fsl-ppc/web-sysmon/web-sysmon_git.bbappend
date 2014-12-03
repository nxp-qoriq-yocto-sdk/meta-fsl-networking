SRC_URI = "git://git.am.freescale.net/gitolite/users/b38951/web-sysmon-dev.git;branch=sdk"
SRCREV = "8d0c6eca1113832fabe917fd0cb25abe2d4d7157"

inherit update-rc.d

EXTRA_OEMAKE += "D=${D}"

do_install () {
	oe_runmake install
}

INITSCRIPT_NAME = "web-sysmon.sh"
INITSCRIPT_PARAMS = "defaults 99 20"
