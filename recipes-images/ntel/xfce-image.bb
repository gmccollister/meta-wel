require console-base-image.bb

IMAGE_INSTALL += " \ 
	packagegroup-xfce-base \ 
	packagegroup-core-x11-xserver \ 
	liberation-fonts \
	xorg-minimal-fonts \
	iso-codes \
	mime-support \
	xauth \
	xdg-utils \
	xhost \
	xinetd \
	xinit \
	xrandr \
	xrdb \
	xset \
	xvinfo \
"

export IMAGE_BASENAME = "xfce-image"
