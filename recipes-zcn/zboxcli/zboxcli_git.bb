SUMMARY = "A client 0chain CLI to interface the blockchain, storage platform, and blobbers (storage providers) "
DESCRIPTION = "zbox is a command line interface (CLI) tool to understand the capabilities of 0Chain dStorage and prototype your app. The utility is built using 0Chain's goSDK library written in Go."
HOMEPAGE = "https://0chain.net/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "bls"
RDEPENDS_${PN} = " ca-certificates"

inherit go go-mod

GO_IMPORT = "github.com/0chain/zboxcli"
SRC_URI = "git://github.com/0chain/zboxcli.git;destsuffix=${BPN}-${PV}/src/${GO_IMPORT}"
SRCREV = "${AUTOREV}"

GOBUILDFLAGS_append = " -modcacherw -x -v -tags bn256"

do_compile_prepend() {

  # avoid prebuilt binaries (CODE IS LAW)
  # we are using DEPENDS, which builds bls from source
  echo "exclude github.com/herumi/bls-go-binary v0.0.0-20191119080710-898950e1a520" >> go.mod
  ${GO} mod download -json

}

do_install_append() {

  # avoid prebuilt binaries (CODE IS LAW)
  # we are using DEPENDS, which builds bls from source
  rm -rf ${D}${libdir}/go/pkg/mod/github.com/herumi/bls-go-binary@v1.0.0/

  # install config.yaml
  install -d ${D}${sysconfdir}/${PN}
  install -m 0644 ${WORKDIR}/${PN}-${PV}/src/${GO_IMPORT}/network/one.yaml ${D}${sysconfdir}/${PN}/config.yaml

}
