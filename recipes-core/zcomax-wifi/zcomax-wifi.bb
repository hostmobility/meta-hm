SECTION = "network"
DESCRIPTION = "Package to setup wifi led correctly on MX-4 VCC/CT"
RDEPENDS_${PN} = ""
# The license is meant for this recipe and the files it installs.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

SRC_URI = " \
    file://zcomax-setup.sh \
    file://zcomax-wifi.rules \
    "

do_install() {
    install -d ${D}/${sysconfdir}/udev/rules.d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/zcomax-setup.sh ${D}/${bindir}/
    install -m 0644 ${WORKDIR}/zcomax-wifi.rules ${D}/${sysconfdir}/udev/rules.d/
}

