#Angstrom image to test systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

# Remove kernel image and other files from boot directory
ROOTFS_POSTINSTALL_COMMAND = "rm -f ${IMAGE_ROOTFS}/boot/*"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

IMAGE_INSTALL += " \
	angstrom-packagegroup-boot \
	packagegroup-basic \
	udev-extra-rules \
    usb-rndis-systemd \
	${ROOTFS_PKGMANAGE_PKGS} \
	timestamp-service \
	bash \
	ldd \
	bzip2 \
	ntpdate \
	mtd-utils \
	nano \
	iperf \
	bonnie++ \
	libsocketcan \
	canutils \
	iproute2 \
	sqlite3 \
	gdbserver \
	oprofile \
	evtest \
	linux-firmware-ralink \
    ppp \
    busybox \
    minicom \
    alsa-utils \
    alsa-utils-aplay \
    alsa-utils-amixer \
    autostart \
    wireless-tools \
    iptables \
"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "tinylogin shadow"

export IMAGE_BASENAME = "console-mx4-base-image"

inherit image
