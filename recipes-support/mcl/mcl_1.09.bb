SUMMARY = "a portable and fast pairing-based cryptography library "
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://github.com/herumi/mcl.git \
           file://0001-rm-native-flag.patch \
           file://0002-cmake-static-lib.patch \
"
SRCREV = "v${PV}"

DEPENDS = "gmp"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DUSE_GMP=ON"
