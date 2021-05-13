DESCRIPTION = "A headless 0chain image"
LICENSE = "MIT"

require recipes-core/images/core-image-base.bb

IMAGE_FEATURES += " \
                   tools-debug \
                   tools-sdk \
                   doc-pkgs \
                   empty-root-password \
"

IMAGE_INSTALL_append += "\
                          zboxcli \
                          zwalletcli \
                          jq \
                          go \
                          go-runtime \
                          git \
"

IMAGE_ROOTFS_SIZE = "512000"

# dns() {
#    echo "nameserver 8.8.8.8" > ${IMAGE_ROOTFS}/etc/resolv.conf
# }
# ROOTFS_POSTPROCESS_COMMAND += "dns; "
