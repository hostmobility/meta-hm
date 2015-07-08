require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Host Mobility MX-4 Vxx boards"

SRC_URI = "git://git@ggithub.com:hostmobility/linux-toradex.git;protocol=ssh;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-mx4-bsp-v1.3.x+git"
SRCBRANCH = "hm_vf_4.0"
SRCREV = "1321fcc31f57fe16e073a80953af6fb9de448679"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(colibri-vf)"
