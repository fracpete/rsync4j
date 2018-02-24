* **Q** I'm trying to sync, but it just sits there and does nothing!
* **A** Since *rsync4j* is not interactive, you will have to connect to the 
  remote host at least once before to add the host to the `known_hosts` file.
* **Q** How do I use a specific public key pair?
* **A** You can let `ssh` know what identity file to use using rsync's `--rsh` 
  option and ssh's `-i` option, e.g.: `rsync --rsh="ssh -i /some/where/id_rsa" ...`
