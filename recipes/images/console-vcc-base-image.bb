#Angstrom image to test systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

# Remove kernel image and other files from boot directory. Remove non working feeds.
do_mkrmscript () {
    echo "rm -f ${IMAGE_ROOTFS}/boot/*; rm -f ${IMAGE_ROOTFS}/etc/init.d/syslog*; sed -i '/Journal/a Storage=none' ${IMAGE_ROOTFS}/etc/systemd/journald.conf; for line in `ls ${IMAGE_ROOTFS}/etc/opkg/ | grep -v arch.conf | grep -v hm-feed.conf`; do rm ${IMAGE_ROOTFS}/etc/opkg/$line; done;  rm -f ${IMAGE_ROOTFS}/var/lib/opkg/info/debianutils.postinst" >> ${WORKDIR}/rmscript
    chmod +x ${WORKDIR}/rmscript
    readlink -e ${WORKDIR}/rmscript
    cat ${WORKDIR}/rmscript
}
addtask mkrmscript before do_rootfs


DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

GSTREAMER = "\
    gstreamer \
    gst-plugins-base \
    gst-plugins-base-alsa \
    gst-plugins-base-audioconvert \
    gst-plugins-base-audioresample \
    gst-plugins-base-audiotestsrc \
    gst-plugins-base-decodebin \
    gst-plugins-base-decodebin2 \
    gst-plugins-base-playbin \
    gst-plugins-base-ogg \
    \
    gst-plugins-good-wavenc \
    gst-plugins-good-wavparse \
    \
    gst-plugins-bad \
    gst-plugins-bad-opus \
"

IMAGE_INSTALL += " \
	angstrom-packagegroup-boot \
	packagegroup-basic \
	automount-udev \
    usb-rndis-systemd \
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
    alsa-utils \
    alsa-utils-aplay \
    alsa-utils-amixer \
    autostart \
    wireless-tools \
    strongswan \
    iptables \
    sudo \
    ruby \
    msgpack \
    msgpack-dev \
    e2fsprogs \
    e2fsprogs-mke2fs \
    file \
    hmfeed \
    openssl \
    init-ifupdown \
    rsyslog \
    update-alternatives-cworth \
    dnsmasq \
    ${GSTREAMER} \
    linux-firmware-ath9k \
    linux-firmware-atheros-license \
    hostapd \
    zcomax-wifi \
    mount-config \
"


IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "console-vcc-base-image"

inherit image
