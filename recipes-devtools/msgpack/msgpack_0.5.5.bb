require msgpack.inc
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "5969bea1a92b80191372793d0759c2ac"
SRC_URI[sha256sum] = "07f1c5c2d4b3ec4701cc6be85ef9cda4994fbf464e0cb0807f634605d58f4e2d"

inherit autotools

do_compile() {
    oe_runmake
}
do_insatll() {
    oe_runmake 'DESTDIR=${D}' install
}

