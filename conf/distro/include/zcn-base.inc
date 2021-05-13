require conf/distro/poky.conf

DISTRO = "zcn"
DISTRO_NAME = "0chain"
DISTRO_VERSION = "0.1.0"

SDK_VERSION="${DISTRO_VERSION}"
SDKIMAGE_FEATURES += "package-management"

IMAGE_FEATURES += "package-management"
PACKAGE_CLASSES = "package_ipk"

PACKAGE_FEED_URIS = "\
    http://192.168.20.1:8080/deb \
"

MAINTAINER = "Bernardo A. Rodrigues <barodrigues@pm.me>"

GOVERSION = "1.14%"

DISTRO_FEATURES += " \
                     systemd \
                     virtualization \
"

INIT_MANAGER="systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

EXTRA_IMAGE_FEATURES += "\
    package-management \
    ssh-server-openssh \
"

DISTRO_FEATURES_DEFAULT_remove = " alsa bluetooth nfs 3g nfc x11"


# Add these binaries to the HOSTTOOLS_NONFATAL variable to allow them to
# be called from within the recipe build task. They are specified as
# NONFATAL as they are not installed at the same time on the build
# system.
HOSTTOOLS_NONFATAL += "sudo pidof dockerd podman newgidmap newuidmap"
