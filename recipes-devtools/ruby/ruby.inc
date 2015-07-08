SUMMARY = "An interpreter of object-oriented scripting language"
DESCRIPTION = "Ruby is an interpreted scripting language for quick \
and easy object-oriented programming. It has many features to process \
text files and to do system management tasks (as in Perl). \
It is simple, straight-forward, and extensible. \
"
HOMEPAGE = "http://www.ruby-lang.org/"
SECTION = "devel/ruby"
LICENSE = "Ruby | BSD | GPLv2"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=837b32593517ae48b9c3b5c87a5d288c \
    file://BSDL;md5=19aaf65c88a40b508d17ae4be539c4b5 \
    file://GPL;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LEGAL;md5=3ce1fae39fe573b818c0af162bce6579 \
"
INC_PR = "r1"

SHRT_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "http://ftp.ruby-lang.org/pub/ruby/${SHRT_VER}/ruby-${PV}.tar.gz \
"

S = "${WORKDIR}/ruby-${PV}"

inherit autotools


# This snippet lets compiled extensions which rely on external libraries,
# such as zlib, compile properly.  If we don't do this, then when extmk.rb
# runs, it uses the native libraries instead of the target libraries, and so
# none of the linking operations succeed -- which makes extconf.rb think
# that the libraries aren't available and hence that the extension can't be
# built.

do_configure_prepend() {
    sed -i "s#%%TARGET_CFLAGS%%#$TARGET_CFLAGS#; s#%%TARGET_LDFLAGS%%#$TARGET_LDFLAGS#" ${S}/common.mk
    rm -rf ${S}/ruby/
    git clone https://github.com/msgpack/msgpack-ruby
    mv msgpack-ruby/ext/msgpack ${S}/ext/
}

do_compile_prepend() {
    sed -i 's#default_ipv6 = /cygwin|beos|haiku/ !~ RUBY_PLATFORM#default_ipv6 = false#' ${S}/ext/socket/extconf.rb
}

do_install_append() {
    cat <<_EOT_ > ${D}${libdir}/ruby/2.0.0/msgpack.rb
require 'msgpack/msgpack.so'

_EOT_
}
