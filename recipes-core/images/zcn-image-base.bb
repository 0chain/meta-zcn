DESCRIPTION = "A headless 0chain image"
LICENSE = "MIT"

require recipes-core/images/core-image-base.bb

IMAGE_FEATURES += " \
                   debug-tweaks \
                   tools-debug \
                   tools-sdk \
                   doc-pkgs \
                   empty-root-password \
"

IMAGE_INSTALL_append += "\
                          zboxcli \
                          zwalletcli \
                          git \
                          nano \
                          vim \
                          jq \
                          python3 \
                          python3-dev \
                          python3-pip \
                          python3-setuptools \
                          go \
                          go-runtime \
"

IMAGE_ROOTFS_SIZE = "512000"

# dns() {
#    echo "nameserver 8.8.8.8" > ${IMAGE_ROOTFS}/etc/resolv.conf
# }
# ROOTFS_POSTPROCESS_COMMAND += "dns; "
