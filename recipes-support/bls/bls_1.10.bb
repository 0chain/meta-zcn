SUMMARY = "BLS threshold signature"
DESCRIPTION = "This library is an implementation of BLS threshold signature, which supports the new BLS Signatures specified at Ethereum 2.0 Phase 0."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "gitsm://github.com/herumi/bls.git \
           file://0001-static-libs-cmake.patch \
"
SRCREV = "v${PV}"

DEPENDS = "mcl"

S = "${WORKDIR}/git"

inherit cmake

do_install_append(){
  mv ${D}${libdir}/libbls_c256.a ${D}${libdir}/libbls256.a
  mv ${D}${libdir}/libbls_c384_256.a ${D}${libdir}/libbls384_256.a
  mv ${D}${libdir}/libbls_c384.a ${D}${libdir}/libbls384.a
}
