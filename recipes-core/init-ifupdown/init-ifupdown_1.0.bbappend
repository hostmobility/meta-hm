FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://interfaces \
	file://mx4_down \
	file://mx4_up \
	"

do_install_append() {
		install -d ${D}${sysconfdir}/network/if-up.d \
			${D}${sysconfdir}/network/if-down.d \
			${D}${sysconfdir}/network/

	install -m 0755 ${WORKDIR}/mx4_down ${D}${sysconfdir}/network/if-down.d/01ultra_down
	install -m 0755 ${WORKDIR}/mx4_up ${D}${sysconfdir}/network/if-up.d/01ultra_up
}