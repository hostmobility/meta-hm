SUMMARY = "Udev rule to automount usb"
DESCRIPTION = "Extra machine specific configuration files for udev, specifically blacklist information."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit allarch systemd

PR = "r6"

SRC_URI = " \
       file://automount.rules \
       file://mount.sh \
       file://mount.blacklist \
       file://automnt.service \
"


do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d

    install -m 0644 ${WORKDIR}/automount.rules     ${D}${sysconfdir}/udev/rules.d/automount.rules

    install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/

    install -d ${D}${sysconfdir}/udev/scripts/

    install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh

    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/automnt.service ${D}${systemd_unitdir}/system/automnt\@.service
}

FILES_${PN} = "${sysconfdir}/udev"
RDEPENDS_${PN} = "udev"
CONFFILES_${PN} = "${sysconfdir}/udev/mount.blacklist"
SYSTEMD_SERVICE_${PN} = "automnt@.service"

# to replace udev-extra-rules from meta-oe
RPROVIDES_${PN} = "udev-extraconf"
RREPLACES_${PN} = "udev-extraconf"
RCONFLICTS_${PN} = "udev-extraconf"
