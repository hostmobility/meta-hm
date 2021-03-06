#additional packages to include in our MX4 images

#the following builds cross gdb and gdbserver
DEPENDS += "gdb-cross"

#IMAGE_INSTALL_T20_T30 = " \
#	trdx-nv-binaries \
#"
IMAGE_INSTALL_T20_T30 = " "

IMAGE_INSTALL_MACHINE_colibri-t20 = "${IMAGE_INSTALL_T20_T30}"
IMAGE_INSTALL_MACHINE_colibri-t30 = "${IMAGE_INSTALL_T20_T30}"
IMAGE_INSTALL_MACHINE_apalis-t30 = "${IMAGE_INSTALL_T20_T30} \
    udisks \
    pciutils \
    iproute2 \
    canutils \
    max9526-i2c \
"

IMAGE_INSTALL_MACHINE = ""

IMAGE_INSTALL += " \
    max9526-i2c \
    linux-firmware-ralink \
    usb-rndis-systemd \
    \
    alsa-utils \
    alsa-utils-aplay \
    alsa-utils-amixer \
    \
    aspell \
    consolekit \
    sqlite3 \
    \
    curl \
    ntp \
    nfs-utils-client \
    openssh-scp \
    openssh-sftp \
    pam-plugin-ck-connector \
    \
    bzip2 \
    gdbserver \
    grep \
    joe \
    minicom \
    ldd \
    lsof \
    mtd-utils \
    update-modules \
    \
    devmem2 \
    evtest \
    hdparm \
    iperf \
    i2c-tools \
    memtester \
    stress \
    lmbench \
    nbench-byte \
    \
    ${IMAGE_INSTALL_MACHINE} \
    trdx-config \
    \
    trdx-oak-sensors \
"
#    openssl-conf 
#    ntpclient 
