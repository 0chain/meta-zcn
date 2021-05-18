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

# Raspberry Pi

1. Install [Raspberry Pi Imager](https://www.raspberrypi.org/software/) into your Host.
2. Flash `${BUILD}/tmp/deploy/images/raspberrypi3-64/zcn-image-base-raspberrypi3-64.wic.bz2` into the SD Card.
3. Plug Raspberry Pi into DHCP-enabled LAN via Ethernet.
4. NMAP for the RPi's IP:
```
$ nmap 192.168.0.1/24 -p 22
```
5. SSH in (empty password):
```
$ ssh root@W.X.Y.Z
```

# Runtime

Since we are working with a cross-compiled Embedded Linux, the configuration file (originally placed at `network/one.yaml` in the project's repository) is deployed into `/etc/zcn/config.yaml` for an appropriate runtime environment.

Therefore the option `--configDir /etc/zcn` is necessary whenever we call `zboxcli` and `zwalletcli`.

1. Run `zwalletcli`:
```
# zwalletcli faucet --configDir /etc/zcn --methodName pour --input payMe
No wallet in path  /etc/zcn//wallet.json found. Creating wallet...
ZCN wallet created!!
Creating related read pool for storage smart-contract...
Read pool created successfully
Execute faucet smart contract success with txn :  d537bad4991f0fc7c9de86cbeb8bdf76900a0799cdbd6ea275d24135c7066a1
# cat /etc/zcn/wallet.json | jq
{
  "client_id": "7956b8d8fd3693907b2e8cdb5a75aa4453d350b2c7750868ad12e84d55055c6a",
  "client_key": "a95050b3159be237d077f5acbd6ddcd4b3d6a4be4a36256d51143438881d720f2aaa389cbe00dd0c3756c9763729d36afbcdb1b1f0845982aa02d7ec7a8b3717",
  "keys": [
    {
      "public_key": "a95050b3159be237d077f5acbd6ddcd4b3d6a4be4a36256d51143438881d720f2aaa389cbe00dd0c3756c9763729d36afbcdb1b1f0845982aa02d7ec7a8b3717",
      "private_key": "9c6ed9378821658a8ec7148a40bc6a801b1fb5f9990336bf19d3a368fe584513"
    }
  ],
  "mnemonics": "hurdle donate more crush enable angle buddy strike demise notice snap before visual prepare major skull system because spring rescue enforce brand drive evidence",
  "version": "1.0",
  "date_created": "2021-05-17 22:27:47.957514599 +0000 UTC m=+4.247339265"
}
# zwalletcli getbalance --configDir /etc/zcn
Balance: 1 (0.909656 USD)
```

2. Run `zboxcli`:
```
# zboxcli newallocation --lock 1 --configDir /etc/zcn        
Allocation created: 50b5a8c3654bda9480a790ed4a8b204b92235bd2e8700aed65b26345e4861e5f
# zboxcli get --allocation 50b5a8c3654bda9480a790ed4a8b204b92235bd2e8700aed65b26345e4861e5f --configDir /etc/zcn
allocation:
  id:              50b5a8c3654bda9480a790ed4a8b204b92235bd2e8700aed65b26345e4861e5f
  tx:              50b5a8c3654bda9480a790ed4a8b204b92235bd2e8700aed65b26345e4861e5f (latest create/update allocation transaction hash)
  data_shards:     2
  parity_shards:   2
  size:            2.0 GiB
  expiration_date: 2021-06-16 22:29:40 +0000 UTC
  blobbers:
    - blobber_id:       68cd771c6a34f2b6bf61980fc86b9255979beda9d5375377410aadafdf257c5c
      base URL:         http://one.devnet-0chain.net:31303
      size:             512.0 MiB
      min_lock_demand:  0.0005
      spent:            0 (moved to challenge pool or to the blobber)
      penalty:          0 (blobber stake slash)
      read_reward:      0
      returned:         0 (on challenge failed)
      challenge_reward: 0 (on challenge passed)
      final_reward:     0 (if finalized)
      terms: (allocation related terms)
        read_price:                0.01 tok / GB (by 64KB chunks)
        write_price:               0.01 tok / GB
        min_lock_demand:           10 %
        max_offer_duration:        744h0m0s
        challenge_completion_time: 2m0s
    - blobber_id:       cbe7945fc6aee3f5bdfa2ba531301fbe836d0fbfe99a056cc1a1b2d4c0711984
      base URL:         http://one.devnet-0chain.net:31301
      size:             512.0 MiB
      min_lock_demand:  0.0005
      spent:            0 (moved to challenge pool or to the blobber)
      penalty:          0 (blobber stake slash)
      read_reward:      0
      returned:         0 (on challenge failed)
      challenge_reward: 0 (on challenge passed)
      final_reward:     0 (if finalized)
      terms: (allocation related terms)
        read_price:                0.01 tok / GB (by 64KB chunks)
        write_price:               0.01 tok / GB
        min_lock_demand:           10 %
        max_offer_duration:        744h0m0s
        challenge_completion_time: 2m0s
    - blobber_id:       090dc72b647638509a02185dcc2ac031ee35117e27cd2e332e38d8445edc740d
      base URL:         http://walter.badminers.com:5052
      size:             512.0 MiB
      min_lock_demand:  0.0004032258
      spent:            0 (moved to challenge pool or to the blobber)
      penalty:          0 (blobber stake slash)
      read_reward:      0
      returned:         0 (on challenge failed)
      challenge_reward: 0 (on challenge passed)
      final_reward:     0 (if finalized)
      terms: (allocation related terms)
        read_price:                0.0161290322 tok / GB (by 64KB chunks)
        write_price:               0.0080645161 tok / GB
        min_lock_demand:           10 %
        max_offer_duration:        744h0m0s
        challenge_completion_time: 2m0s
    - blobber_id:       ac808ceeeba1026fbd9d1e495508af496aacc6f11a58fd202ea9f032a2419648
      base URL:         http://jesse.badminers.com:5051
      size:             512.0 MiB
      min_lock_demand:  0.0002840909
      spent:            0 (moved to challenge pool or to the blobber)
      penalty:          0 (blobber stake slash)
      read_reward:      0
      returned:         0 (on challenge failed)
      challenge_reward: 0 (on challenge passed)
      final_reward:     0 (if finalized)
      terms: (allocation related terms)
        read_price:                0.0113636363 tok / GB (by 64KB chunks)
        write_price:               0.0056818181 tok / GB
        min_lock_demand:           10 %
        max_offer_duration:        744h0m0s
        challenge_completion_time: 2m0s
  read_price_range:          0-922337203.6854776 (requested)
  write_price_range:         0-922337203.6854776 (requested)
  challenge_completion_time: 2m0s (max)
  start_time:                2021-05-17 22:29:40 +0000 UTC
  finalized:                 false
  canceled:                  false
  moved_to_challenge:        0
  moved_back:                0
  moved_to_validators:       0
  stats:
    total size:              2.0 GiB
    used size:               0 B
    number of writes:        0
    total challenges:        0
    passed challenges:       0
    failed challenges:       0
    open challenges:         0
    last challenge redeemed:
  price:
    time_unit:   720h0m0s
    read_price:  0.005942381 tok / GB (by 64KB)
    write_price: 0.0674926684 tok / GB / 720h0m0s
```
