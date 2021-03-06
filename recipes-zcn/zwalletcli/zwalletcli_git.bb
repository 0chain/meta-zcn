SUMMARY = "A client 0chain CLI to interface the blockchain, storage platform, and blobbers (storage providers) "
DESCRIPTION = "zwallet is a command line interface (CLI) to demonstrate the functionalities of 0Chain.. The utility is built using 0Chain's goSDK library written in Go."
HOMEPAGE = "https://0chain.net/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "bls"
RDEPENDS_${PN} = " ca-certificates"

inherit go go-mod

GO_IMPORT = "github.com/0chain/zwalletcli"
SRC_URI = "git://github.com/0chain/zwalletcli.git;destsuffix=${BPN}-${PV}/src/${GO_IMPORT}"
SRCREV = "894f3d86b896f5cb55cf409194c3d6901d659cad"

GOBUILDFLAGS_append = " -modcacherw -x -v -tags bn256"

do_compile_prepend() {

  # avoid prebuilt binaries (CODE IS LAW)
  # we are using DEPENDS, which builds bls from source
  echo "exclude github.com/herumi/bls-go-binary v0.0.0-20191119080710-898950e1a520" >> go.mod

  ${GO} mod download -json

}

do_install_append() {

  # avoid prebuilt binaries
  # we are using DEPENDS, which builds bls from source
  rm -rf ${D}${libdir}/go/pkg/mod/github.com/herumi/bls-go-binary@v1.0.0/

  # install config.yaml
  install -d ${D}${sysconfdir}/zcn
  install -m 0644 ${WORKDIR}/${PN}-${PV}/src/${GO_IMPORT}/network/one.yaml ${D}${sysconfdir}/zcn/config.yaml

  # rename executable binary
  mv ${D}${bindir}/zwalletcli ${D}${bindir}/zwallet

}
