FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

PACKAGECONFIG_append = " modemmanager ppp"

SRC_URI_append = " file://ModemConnection"

do_install_append() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections
    install -m 600 ${WORKDIR}/ModemConnection ${D}${sysconfdir}/NetworkManager/system-connections/ModemConnection
}

FILES_${PN} += "${sysconfdir}/NetworkManager/system-connections/ModemConnection"
