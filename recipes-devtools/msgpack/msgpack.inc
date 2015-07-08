SUMMARY = "A binary version of JSON"
DESCRIPTION = "MessagePack is an efficient binary serialization format. It lets you exchange data among multiple languages like JSON. But it's faster and smaller. Small integers are encoded into a single byte, and typical short strings require only one extra byte in addition to the strings themselves."

HOMEPAGK = "http://msgpack.org/"
SECTION = "devel/msgpack"
LICENSE = "Apache2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

INC_PR = "r1"

SHRT_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "http://msgpack.org/releases/cpp/msgpack-${PV}.tar.gz"

S = "${WORKDIR}/msgpack-${PV}"

