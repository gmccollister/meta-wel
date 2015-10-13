SUMMARY = "Supports the Python WSGI interface"
DESCRIPTION = "\
  The aim of mod_wsgi is to implement a simple to use Apache module which can host \
  any Python application which supports the Python WSGI interface. The module would \
  be suitable for use in hosting high performance production web sites, as well as \
  your average self managed personal sites running on web hosting services."

HOMEPAGE = "http://www.modwsgi.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCNAME = "mod_wsgi"
SRC_URI = "\
	https://github.com/GrahamDumpleton/${SRCNAME}/archive/${PV}.tar.gz \
	file://0001-Fix-separated-directory-build.patch \
	file://0002-Fix-configure-paths.patch \
	"

S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "f092e96cdc0fe3e83bfe5dac04d1dbcc"
SRC_URI[sha256sum] = "5bb575297767fcab94d0f34f7c06cb29819c545bae843c1b2759ca91833fe085"

inherit autotools distutils-base

DEPENDS += "apache2-native apache2 python-native"
RDEPENDS_${PN} = "python"

EXTRA_OECONF = "\
	--with-apxs=${STAGING_BINDIR_CROSS}/apxs \
	--disable-framework \
	PYTHON_VERSION=${PYTHON_BASEVERSION} \
	PYTHON_INCLUDEPY=-I${STAGING_INCDIR}/python${PYTHON_BASEVERSION} \
	PYTHON_CFLAGS='-DNDEBUG' \
	PYTHON_LIBDIR=${STAGING_LIBDIR} \
	PYTHON_CFGDIR=${STAGING_LIBDIR}/python${PYTHON_BASEVERSION}/config \
	PYTHON_FRAMEWORKDIR='no-framework' \
	PYTHON_FRAMEWORKPREFIX=' ' \
	PYTHON_FRAMEWORK=' ' \
	PYTHON_LIBS='-lpthread -ldl  -lpthread -lutil' \
	PYTHON_SYSLIBS='-lm' \
	"

CFLAGS += " -I${STAGING_INCDIR}/apache2"

FILES_${PN} += "/etc/apache2/"
FILES_${PN}-dbg += "${libdir}/apache2/modules/.debug"

do_install_append() {
	mkdir -p ${D}/etc/apache2/modules.d/
	echo "LoadModule wsgi_module ${libdir}/apache2/modules/mod_wsgi.so" > \
	  ${D}/etc/apache2/modules.d/wsgi.load
}

# to load:
# LoadModule wsgi_module modules/mod_wsgi.so

# Apache/2.2.2 (Unix) mod_wsgi/1.0 Python/2.3 configured
