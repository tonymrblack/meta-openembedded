SUMMARY = "Crontab entry to provide weekly updates of the GeoIP free databases."
DESCRIPTION = "update databases for GeoIP"

HOMEPAGE = "http://dev.maxmind.com/geoip/"
SECTION = "net"

DEPENDS = "zlib curl"

SRC_URI = "https://github.com/maxmind/geoipupdate/releases/download/v${PV}/geoipupdate-${PV}.tar.gz \
           file://GeoIP.conf \
           file://geoipupdate.cron \
          "

SRC_URI[md5sum] = "94de6553bc213703ae07542089c280bc"
SRC_URI[sha256sum] = "4f71e911774c4fd32e217889c242d2c311fa5ffd3df56be48a2d1aedfe2e671c"

LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "\
file://ChangeLog.md;md5=ca457cc1427b57972707b741adb7fe1d \
"

inherit autotools

do_install_append() {
    install -d ${D}/${sysconfdir}
    install -d ${D}/${sysconfdir}/cron.d
    install ${WORKDIR}/GeoIP.conf ${D}/${sysconfdir}/
    install ${WORKDIR}/geoipupdate.cron ${D}/${sysconfdir}/cron.d/
}
