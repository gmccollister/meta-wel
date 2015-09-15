
DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += " \
	packagegroup-boot \
	packagegroup-basic \
	packagegroup-core-selinux \
	${ROOTFS_PKGMANAGE_PKGS} \
	systemd \
	bzip2 \
	attr \
	grep \
"

export IMAGE_BASENAME = "console-base-image"

inherit image
