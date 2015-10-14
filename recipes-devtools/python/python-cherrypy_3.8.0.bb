LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://cherrypy/LICENSE.txt;md5=a476d86a3f85c89411ecaad012eed1e3"

HOMEPAGE = "http://www.cherrypy.org"
SUMMARY = "Object-Oriented HTTP framework"

SRC_URI = "https://pypi.python.org/packages/source/C/CherryPy/CherryPy-${PV}.tar.gz"
SRC_URI[md5sum] = "542b96b2cd825e8120e8cd822bc18f4b"
SRC_URI[sha256sum] = "ffcdb43667d4098247efaf8c82dd36d3dd4f8e5dc768ef5e90b480899e523bea"

S = "${WORKDIR}/CherryPy-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-compiler python-compression python-core python-crypt python-ctypes python-datetime python-email python-io python-json python-lang python-logging python-math python-mime python-misc python-netclient python-netserver python-pickle python-pprint python-profile python-pydoc python-re python-stringold python-subprocess python-terminal python-textutils python-threading python-unittest python-xml python-xmlrpc"

# Remove files installed to /usr/share
# (take this out if we decide we need some of them)
do_install_append() {
    rm -rf ${D}${datadir}
}
