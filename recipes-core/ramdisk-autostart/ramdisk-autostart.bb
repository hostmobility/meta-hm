DESCRIPTION = "Call an autostart script at boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
PR = "r0"

inherit allarch systemd

SRC_URI += "\
   file://probe-autoboot.service \
   file://probe-autoboot.sh \
   "

SYSTEMD_SERVICE_${PN} = "probe-autoboot.service"

do_configure() {
  :
}

do_compile() {
  :
}

do_install() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/probe-autoboot.service ${D}${systemd_unitdir}/system/probe-autoboot.service

  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/probe-autoboot.sh ${D}${bindir}/probe-autoboot.sh
}
