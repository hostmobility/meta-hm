DESCRIPTION = "Setup Host Mobility feeds"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
PR = "r0"

inherit allarch

SRC_URI += "\
   file://hm-feed.conf \
   "

do_configure() {
  :
}

do_compile() {
  :
}

do_install() {
  install -d ${D}${sysconfdir}/opkg
  install -m 0644 ${WORKDIR}/hm-feed.conf ${D}${sysconfdir}/opkg/hm-feed.conf
}
