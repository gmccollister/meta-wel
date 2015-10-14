LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4fbd65380cdd255951079008b364516c"

HOMEPAGE = "https://github.com/systemd/python-systemd"
SUMMARY = "Native interface to the facilities of systemd"

DEPENDS = "systemd"

SRC_URI = "https://github.com/systemd/python-systemd/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "6902e5588397c796c85febc8334d434b"
SRC_URI[sha256sum] = "656a83ff695f5de7d63411a86ea38601ad5a918595eebd0817d7b8e68642c64d"

inherit distutils

RDEPENDS_${PN} += "libsystemd0 python-core"

do_configure() {
}

do_compile_prepend() {
	make systemd/id128-constants.h
}
