SUMMARY = "bcachefs - the COW filesystem for Linux that won't eat your data."
DESCRIPTION = "Bcachefs is an advanced new filesystem for Linux, with an emphasis on reliability and robustness."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://evilpiepirate.org/git/bcache-tools;protocol=https \
           file://0001-inject-I-from-util-linux-on-sysroot.patch \
"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

DEPENDS = "util-linux"

EXTRA_OEMAKE = "INCLUDE=${STAGING_INCDIR}/blkid"
