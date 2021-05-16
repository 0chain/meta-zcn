# Podman

Podman is a daemonless container engine for developing, managing, and running OCI Containers on your Linux System.

# BitBake class

In the context of `0chain`, `blobber` was written as a golang-based Docker container. We need to be able to cross-compile and deploy `blobber` into Embedded production scenarios.

The OpenEmbedded space has a few container-based solutions, such as:
- [BalenaOS](https://balena.io/)
- [LmP](https://foundries.io/products/#linux)
- [Torizon](https://www.toradex.com/operating-systems/torizon)

We need however, an approach that is generic enough and doesn't necessarily tie our pipeline to third-party products.

It is important to note that we do not do a `docker pull <image>` at runtime. The container is expected to be a static entity residing on the target's `rootfs`. In case updates are needed, a new package must be cross-compiled and deployed to the target, effectively overwriting the Docker store.

The following guides written by [stobajas](https://blog.savoirfairelinux.com/en-ca/author/stobajas/), from [Savoir-faire Linux](https://savoirfairelinux.com/en), serve as our main reference:
- [How to embed a Docker image into Yocto’s root filesystem](https://blog.savoirfairelinux.com/en-ca/2020/how-to-embed-a-docker-image-into-yoctos-root-filesystem/)
- [Integrating container image in Yocto]( https://blog.savoirfairelinux.com/en-ca/2020/integrating-container-image-in-yocto/)
- [Containers on Linux embedded systems](https://blog.savoirfairelinux.com/en-ca/2020/containers-on-linux-embedded-systems/)

Podman's ability to pull the container images, and install a cross-compiled Docker archive to the target RootFS seems like a good candidate for our needs, especially because we need it to be tightly integrated to the `gosdk`-based cross-compilation chain.

## Docker Store

The Docker store is the root directory of persistent Docker state (`/var/lib/docker`). It needs to be on a write-able partition, however it could be either volatile or non-volatile (e.g.: `tmpfs`).

# BitBake Vars

## Preset

The following BitBake variables are set by `podman.bbclass`:
- `DOCKER_STORE`:
- `HOSTTOOLS_NONFATAL`:

## Expected

The following BitBake variables are expected to be set by any `.bb` recipe that does `inherit podman`:
- `SRC_URI`:
- `SRCREV`:
- `MANIFEST`: path to manifest file relative project's source root directory. It lists the Docker image(s) to be installed on the target container describing: the image name with its registry if any, its tag and its local archive name.

# Dependencies

`podman.bbclass` assumes the following tools to be available on the Host machine:
- [`podman`](https://podman.io/)
- `dockerd`
- `pidof`
- `newgidmap`
- `newuidmap`

`podman.bbcclass` introduces the layer dependency for `meta-virtualization`.

# Limitations

In case `podman.bbclass` is ever used outside of `zcn` distro, the systemd is locked as a distro feature into the class, which could lead to conflicts with higher prioritized distro features:
```
DISTRO_FEATURES_append = " virtualization"
DISTRO_FEATURES_append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_initscripts = ""
```
