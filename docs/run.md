# QEMU

1. Load environment variables:
```
$ source poky/oe-init-build-env build
```

2. Start QEMU:
```
$ runqemu qemuarm64 zcn-image-base nographic
```

3. Log in with `root`, no password.

4. Run `zwalletcli`:
```
# zwalletcli ls-miners --configDir /etc/zwalletcli/
...
# zwalletcli mn-config --configDir /etc/zwalletcli/
...
root@qemuarm64:~# cat /etc/zwalletcli/wallet.json
```

4. Run `zboxcli`:
```
# zboxcli --configDir /etc/zboxcli/ ???
```

# Raspberry Pi

1. Install [Raspberry Pi Imager](https://www.raspberrypi.org/software/) into your Host.
2. Flash `${BUILD}/tmp-glibc/deploy/images/raspberrypi{3,4}-64/zcn-image-base-raspberrypi3-64.wic.bz2` into the SD Card.
3. Plug Raspberry Pi into DHCP-enabled LAN via Ethernet.
4. NMAP for the RPi:
```
$ nmap 192.168.0.1/24 -p 22 | grep Raspberry
```
5. SSH in:
```
$ ssh root@W.X.Y.Z
```
6. Run `zwalletcli`:
```
# zwalletcli ls-miners --configDir /etc/zwalletcli/
...
# zwalletcli mn-config --configDir /etc/zwalletcli/
...
# cat /etc/zwalletcli/wallet.json
```

7. Run `zboxcli`:
```
# zboxcli --configDir /etc/zboxcli/ ???
```
