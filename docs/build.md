# Build

Prepare your host for Yocto/OpenEmbedded development. Refer to [Yocto's official documentation](https://www.yoctoproject.org/docs/latest/mega-manual/mega-manual.html#detailed-supported-distros) for more details on setting up.
Bear in mind that running a build will take up to 50Gb of disk space.

1. Assuming you are using Ubuntu (20.04):
```
$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
     build-essential chrpath socat cpio python3 python3-pip python3-pexpect \
     xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
     pylint3 xterm file
```

2. Install `kas`:
```
$ sudo pip3 install kas
```

2. Clone `oe-zcn`:
```
$ git clone https://github.com/0chain/oe-zcn.git
$ cd oe-zcn
```

3. Start build via `kas`. You can choose one of the following options:
- `zcn-image-base-qemuarm64`: QEMU image (`aarch64`)
- `zcn-image-base-raspberrypi3-64`: Raspberry Pi 3 image (B, B+, `aarch64`) .
- `zcn-image-base-raspberrypi4-64`: Raspberry Pi 4 image (B, `aarch64`) .
- `zcn-image-base-qemux86-64`: x86-64 QEMU image (`x86-64`).
- `zcn-image-base-genericx86-64`: generic x86-64 image (compatible with most `x86-64` mobos).

For example:
```
$ kas build zcn-image-base-qemuarm64.yml
```

You can tune the build speed to match your available resources by modifying `kas.yml`.
Set `PARALLEL_MAKE = -jX` so that `X` matches the number of available CPU cores.
Set `BB_NUMBER_THREADS = Y` so that `Y=1.5*X`.
