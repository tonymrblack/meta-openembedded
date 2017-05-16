SUMMARY = "C library and tools for interacting with the linux GPIO character device"
HOMEPAGE = "https://github.com/brgl/libgpiod"

LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2caced0b25dfefd4c601d92bd15116de"

UPSTREAM_CHECK_URI = "https://github.com/brgl/libgpiod/releases"

SRC_URI = "https://github.com/brgl/libgpiod/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "e3430f35b6efa842693d659c0bfb7ad5"
SRC_URI[sha256sum] = "de1947f3cb2cc4174364af430309fe6238976658575655bdbd76c60cffa7df92"

inherit autotools pkgconfig

# enable tools
PACKAGECONFIG ?= "tools"

PACKAGECONFIG[tests] = "--enable-tests,--disable-tests,kmod udev"
PACKAGECONFIG[tools] = "--enable-tools,--disable-tools,"

PACKAGES += " ${PN}-tools"

FILES_${PN} = "${libdir}/*"
FILES_${PN}-tools = "${bindir}/*"
