FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

PACKAGECONFIG_append = " modemmanager ppp"

SRC_URI_append = "\ 
    file://ModemConnection \
    file://interfaces \
"

do_install_append() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections
    install -m 600 ${WORKDIR}/ModemConnection ${D}${sysconfdir}/NetworkManager/system-connections/ModemConnection

    install -d ${D}${sysconfdir}/network
    install -m 600 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}

FILES_${PN} += " \
    ${sysconfdir}/NetworkManager/system-connections/ModemConnection \
    ${sysconfdir}/network/interfaces \
"

