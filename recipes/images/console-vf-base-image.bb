#Angstrom image to test systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

# Remove kernel image and other files from boot directory. Remove non working feeds.
ROOTFS_POSTINSTALL_COMMAND = "rm -f ${IMAGE_ROOTFS}/boot/*; rm -f ${IMAGE_ROOTFS}/etc/init.d/syslog*; sed -i '/Journal/a Storage=none' ${IMAGE_ROOTFS}/etc/systemd/journald.conf; rm -f ${IMAGE_ROOTFS}/var/lib/opkg/info/debianutils.postinst"


DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

IMAGE_INSTALL += " \
	angstrom-packagegroup-boot \
	packagegroup-basic \
	automount-udev \
	${ROOTFS_PKGMANAGE_PKGS} \
	timestamp-service \
	bash \
	ldd \
	bzip2 \
	ntpdate \
	mtd-utils \
    mtd-utils-ubifs \
	libsocketcan \
	canutils \
	iproute2 \
	evtest \
    ppp \
    busybox \
    minicom \
    autostart \
    iptables \
    sudo \
    e2fsprogs \
    e2fsprogs-mke2fs \
    file \
    init-ifupdown \
    update-alternatives-cworth \
    libstdc++ \
    mqxboot \
    libmcc \
    mount-config \
"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "tinylogin shadow"

export IMAGE_BASENAME = "console-vf-base-image"

inherit image
