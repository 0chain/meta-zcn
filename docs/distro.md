# Distro

`conf/distro/zcn.conf` defines the `zcn` [`DISTRO`](https://www.yoctoproject.org/docs/current/mega-manual/mega-manual.html#var-DISTRO) variable.

It is a derivative of [Poky](https://www.yoctoproject.org/software-item/poky/), which is the reference distribution from the Yocto Project.

The `zcn` distribution provides the following features:
- `systemd` as service and networking manager.
- `docker` as virtualization manager.
- `opkg`as package manager.

# References

- Poky - Yocto Mega Manual: https://www.yoctoproject.org/docs/current/mega-manual/mega-manual.html
- Creating a custom OpenEmbedded distro: https://ltekieli.com/openembedded/
- Using Package Manager to Efficiently Develop Yocto Project-based Systems: https://www.intel.com/content/dam/www/public/us/en/documents/white-papers/package-manager-white-paper.pdf
- How to embed a Docker image into Yocto’s root filesystem: https://blog.savoirfairelinux.com/en-ca/2020/how-to-embed-a-docker-image-into-yoctos-root-filesystem/
- How to configure networking using systemd in Yocto Project: https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097
