DESCRIPTION = "Service which will mount persistant config partition on MX-4 boards"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit systemd

PR = "r0"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " file://mount-config.service "

do_compile() {
	:
}


do_install () {
	install -d ${D}/${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/mount-config.service ${D}/${base_libdir}/systemd/system/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "mount-config.service"

FILES_${PN} += "${base_libdir}/systemd"
