FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit systemd

SRC_URI += "\
   file://ifplugd.service \
   file://ifplugd1.service \
   file://ifplugd2.service \
   file://ifplugd.action \
   file://busybox-syslog.default \
   "

do_configure_append() {
    echo "# Start manual config" >> .config

    sed -i -e '/CONFIG_HALT/d' .config
    echo "# CONFIG_HALT is not set" >> .config

    sed -i -e '/CONFIG_IFPLUGD/d' .config
    echo "CONFIG_IFPLUGD=y" >> .config

    sed -i -e '/CONFIG_TASKSET/d' .config
    echo "CONFIG_TASKSET=y" >> .config
    sed -i -e '/CONFIG_FEATURE_TASKSET_FANCY/d' .config
    echo "CONFIG_FEATURE_TASKSET_FANCY=y" >> .config

    # Consat stuffs
    sed -i -e '/CONFIG_ADJTIMEX/d' .config
    echo "CONFIG_ADJTIMEX=y" >> .config

    sed -i -e '/CONFIG_BASE64/d' .config
    echo "CONFIG_BASE64=y" >> .config

    sed -i -e '/CONFIG_BBCONFIG/d' .config
    echo "CONFIG_BBCONFIG=y" >> .config
    sed -i -e '/CONFIG_FEATURE_COMPRESS_BBCONFIG/d' .config
    echo "CONFIG_FEATURE_COMPRESS_BBCONFIG=y" >> .config

    sed -i -e '/CONFIG_ASH_BASH_COMPAT/d' .config
    echo "CONFIG_ASH_BASH_COMPAT=y" >> .config

    sed -i -e '/CONFIG_DEPMOD/d' .config
    echo "CONFIG_DEPMOD=y" >> .config

    sed -i -e '/CONFIG_DHCPRELAY/d' .config
    echo "CONFIG_DHCPRELAY=y" >> .config

    sed -i -e '/CONFIG_DOS2UNIX/d' .config
    echo "CONFIG_DOS2UNIX=y" >> .config
    sed -i -e '/CONFIG_UNIX2DOS/d' .config
    echo "CONFIG_UNIX2DOS=y" >> .config

    sed -i -e '/CONFIG_ETHER_WAKE/d' .config
    echo "CONFIG_ETHER_WAKE=y" >> .config

    sed -i -e '/CONFIG_FBSPLASH/d' .config
    echo "CONFIG_FBSPLASH=y" >> .config

    sed -i -e '/CONFIG_FTPD/d' .config
    echo "CONFIG_FTPD=y" >> .config

    sed -i -e '/CONFIG_FTPGET/d' .config
    echo "CONFIG_FTPGET=y" >> .config
    sed -i -e '/CONFIG_FTPPUT/d' .config
    echo "CONFIG_FTPPUT=y" >> .config

    sed -i -e '/CONFIG_GETOPT/d' .config
    echo "CONFIG_GETOPT=y" >> .config

    sed -i -e '/CONFIG_GETTY/d' .config
    echo "CONFIG_GETTY=y" >> .config

    sed -i -e '/CONFIG_HTTPD/d' .config
    echo "CONFIG_HTTPD=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_RANGES/d' .config
    echo "CONFIG_FEATURE_HTTPD_RANGES=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_USE_SENDFILE/d' .config
    echo "CONFIG_FEATURE_HTTPD_USE_SENDFILE=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_SETUID/d' .config
    echo "CONFIG_FEATURE_HTTPD_SETUID=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_BASIC_AUTH/d' .config
    echo "CONFIG_FEATURE_HTTPD_BASIC_AUTH=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_AUTH_MD5/d' .config
    echo "CONFIG_FEATURE_HTTPD_AUTH_MD5=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_CGI/d' .config
    echo "CONFIG_FEATURE_HTTPD_CGI=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_CONFIG_WITH_SCRIPT_INTERPR/d' .config
    echo "CONFIG_FEATURE_HTTPD_CONFIG_WITH_SCRIPT_INTERPR=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_SET_REMOTE_PORT_TO_ENV/d' .config
    echo "CONFIG_FEATURE_HTTPD_SET_REMOTE_PORT_TO_ENV=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_ENCODE_URL_STR/d' .config
    echo "CONFIG_FEATURE_HTTPD_ENCODE_URL_STR=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_ERROR_PAGES/d' .config
    echo "CONFIG_FEATURE_HTTPD_ERROR_PAGES=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_PROXY/d' .config
    echo "CONFIG_FEATURE_HTTPD_PROXY=y" >> .config

    sed -i -e '/CONFIG_FEATURE_HTTPD_GZIP/d' .config
    echo "CONFIG_FEATURE_HTTPD_GZIP=y" >> .config

    sed -i -e '/CONFIG_IONICE/d' .config
    echo "CONFIG_IONICE=y" >> .config

    sed -i -e '/CONFIG_INOTIFYD/d' .config
    echo "CONFIG_INOTIFYD=y" >> .config

    sed -i -e '/CONFIG_IOSTAT/d' .config
    echo "CONFIG_IOSTAT=y" >> .config

    sed -i -e '/CONFIG_FGCONSOLE/d' .config
    echo "CONFIG_FGCONSOLE=y" >> .config

    sed -i -e '/CONFIG_LAST /d' .config
    echo "CONFIG_LAST=y" >> .config
    sed -i -e '/CONFIG_FEATURE_LAST_FANCY/d' .config
    echo "CONFIG_FEATURE_LAST_FANCY=y" >> .config
    sed -i -e '/CONFIG_FEATURE_WTMP/d' .config
    echo "CONFIG_FEATURE_WTMP=y" >> .config

    sed -i -e '/CONFIG_NANDWRITE/d' .config
    echo "CONFIG_NANDWRITE=y" >> .config
    sed -i -e '/CONFIG_NANDDUMP/d' .config
    echo "CONFIG_NANDDUMP=y" >> .config

    sed -i -e '/CONFIG_NICE/d' .config
    echo "CONFIG_NICE=y" >> .config

    sed -i -e '/CONFIG_RESIZE/d' .config
    echo "CONFIG_RESIZE=y" >> .config

    sed -i -e '/CONFIG_SETSID/d' .config
    echo "CONFIG_SETSID=y" >> .config

    sed -i -e '/CONFIG_STAT /d' .config
    echo "CONFIG_STAT=y" >> .config
    sed -i -e '/CONFIG_FEATURE_STAT_FORMAT/d' .config
    echo "CONFIG_FEATURE_STAT_FORMAT=y" >> .config

    sed -i -e '/CONFIG_TFTPD/d' .config
    echo "CONFIG_TFTPD=y" >> .config

    sed -i -e '/CONFIG_NC_EXTRA/d' .config
    sed -i -e '/CONFIG_NC_SERVER/d' .config
    sed -i -e '/CONFIG_NC[^_]/d' .config
    echo "CONFIG_NC=y" >> .config
    echo "CONFIG_NC_SERVER=y" >> .config
    echo "CONFIG_NC_EXTRA=y" >> .config
}

do_install_append() {
    # Run ifplugd at startup
    install -d ${D}${sysconfdir}/systemd/system
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/ifplugd.service ${D}${systemd_unitdir}/system/ifplugd.service
    install -m 0644 ${WORKDIR}/ifplugd1.service ${D}${systemd_unitdir}/system/ifplugd1.service
    install -m 0644 ${WORKDIR}/ifplugd2.service ${D}${systemd_unitdir}/system/ifplugd2.service

    # ifplugd config
    install -d ${D}${sysconfdir}/ifplugd
    install -m 0744 ${WORKDIR}/ifplugd.action ${D}${sysconfdir}/ifplugd/ifplugd.action

    # Default syslog environment
    install -d ${D}${sysconfdir}/default/
    install -m 0644 ${WORKDIR}/busybox-syslog.default ${D}${sysconfdir}/default/busybox-syslog
}

FILES_${PN} += "${systemd_unitdir}/*"
SYSTEMD_SERVICE_${PN} = "ifplugd.service"
SYSTEMD_SERVICE_${PN} = "ifplugd1.service"
SYSTEMD_SERVICE_${PN} = "ifplugd2.service"
