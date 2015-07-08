DESCRIPTION = "Call an autostart script at boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
PR = "r0"

inherit allarch

SRC_URI += "\
   file://autostart.service"

do_configure() {
  :
}

do_compile() {
  :
}

do_install() {
  install -d ${D}${sysconfdir}/systemd/system
  install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
  install -m 0644 ${WORKDIR}/autostart.service ${D}${sysconfdir}/systemd/system/autostart.service
  install -m 0644 ${WORKDIR}/autostart.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/autostart.service
}
