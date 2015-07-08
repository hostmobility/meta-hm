DESCRIPTION = "Call ultra autostart script at boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
PR = "r0"

inherit allarch systemd

SRC_URI += "\
   file://ultra.service"

SYSTEMD_SERVICE_${PN} = "ultra.service"

do_configure() {
  :
}

do_compile() {
  :
}

do_install() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/ultra.service ${D}/${systemd_unitdir}/system/ultra.service
}

