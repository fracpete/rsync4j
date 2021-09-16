* **Q** I'm trying to sync, but it just sits there and does nothing!
  
  **A** Since *rsync4j* is not interactive, you will have to connect to the 
  remote host at least once before to add the host to the `known_hosts` file.

* **Q** How do I use a specific public key pair?

  **A** You can let `ssh` know what identity file to use using rsync's `--rsh` 
  option and ssh's `-i` option, e.g.: `rsync --rsh="ssh -i /some/where/id_rsa" ...`

* **Q** I cannot store ssh keys on the remote machine, how do I use user/password for the login?

  **A** Using Java, you can supply an instance of the `SshPass` class to the `Rsync` or `Ssh` object 
  that will then feed the password to the underlying binary.
  
* **Q** How can I suppress the prompt for accepting a remote fingerprint 
  (`The authenticity of host 'XYZ' can't be established. Are you sure you want to continue connecting (yes/no/[fingerprint])?`)? 

  **A** Supply the following option to ssh (via `-o ...`): 
  
  `StrictHostKeyChecking=no`
