require core-image-minimal.bb

DESCRIPTION = "Small image capable of booting a device with support for the \
Minimal MTD Utilities, which let the user interact with the MTD subsystem in \
the kernel to perform operations on flash devices. Generated as cpio image."

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

ROOTFS_POSTINSTALL_COMMAND = "sed -i '/Journal/a Storage=none' ${IMAGE_ROOTFS}/etc/systemd/journald.conf; echo hm-ramdisk > ${IMAGE_ROOTFS}/etc/hostname"

IMAGE_INSTALL += "mtd-utils dropbear automount-udev ramdisk-autostart mtd-utils-ubifs"
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

export IMAGE_BASENAME = "ramdisk-minimal-mtdutils"
