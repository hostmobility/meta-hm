require ruby.inc
PR = "${INC_PR}.0"

SRC_URI += "\
   file://readline.patch \
   "

SRC_URI += "\
"
SRC_URI[md5sum] = "c351450a0bed670e0f5ca07da3458a5b"
SRC_URI[sha256sum] = "3e71042872c77726409460e8647a2f304083a15ae0defe90d8000a69917e20d3"

EXTRA_OECONF = "\
    --disable-install-doc \
    --enable-load-relative \
    --disable-versioned-paths \
    --disable-rpath \
    --disable-dtrace \
    --enable-shared \
    ac_cv_sizeof_off_t=${ac_cv_sizeof_off_t=8} \
"
EXTRA_OEMAKE = " \
    CFLAGS=' -O3 -fPIC ' \
"

FILES_${PN}-dbg += "${libdir}/ruby/*/.debug \
                    ${libdir}/ruby/*/*/.debug \
                    ${libdir}/ruby/*/*/*/.debug\
                    ${libdir}/ruby/*/*/*/*/.debug\
"

BBCLASSEXTEND = "native"
