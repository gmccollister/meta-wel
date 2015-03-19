require xfce-image.bb

IMAGE_INSTALL += " \ 
	chromium \ 
"

export IMAGE_BASENAME = "xfce-chromium-image"
