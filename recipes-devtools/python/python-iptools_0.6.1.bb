LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c78b74ed26008fef8739fa2a2ba6955d"

HOMEPAGE = "https://github.com/bd808/python-iptools"
SUMMARY = "Python utilites for manipulating IPv4 and IPv6 addresses"

SRC_URI = "https://pypi.python.org/packages/source/i/iptools/iptools-${PV}.tar.gz"
SRC_URI[md5sum] = "aed4045638fd40c16f8d9bb04606f700"
SRC_URI[sha256sum] = "0f03875a5bed740ba4bf44decb6a78679cca914a1ee8a6cc468114485c4d98e3"

S = "${WORKDIR}/iptools-${PV}"

inherit setuptools

PACKAGECONFIG[testing] = ",,,python-nose"

RDEPENDS_${PN} += "python-core python-re"
