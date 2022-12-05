## Q: I'm trying to sync, but it just sits there and does nothing!  {: #known_hosts }
  
**A:** Since *rsync4j* is not interactive, you will have to connect to the 
remote host at least once before to add the host to the `known_hosts` file.


## Q: How do I use a specific public key pair? {: #identity }

**A:** You can let `ssh` know what identity file to use using rsync's `--rsh` 
option and ssh's `-i` option, e.g.: `rsync --rsh="ssh -i /some/where/id_rsa" ...`


## Q: I cannot store ssh keys on the remote machine, how do I use user/password for the login? {: #sshpass }

**A:** Using Java, you can supply an instance of the `SshPass` class to the `Rsync` or `Ssh` object 
that will then feed the password to the underlying binary.

  
## Q: How can I suppress the prompt for accepting a remote fingerprint (`The authenticity of host 'XYZ' can't be established. Are you sure you want to continue connecting (yes/no/[fingerprint])?`)? {: #stricthostkeychecking } 

**A:** Supply the following option to ssh (via `-o ...`): 
  
`StrictHostKeyChecking=no`


## Q: How can I fix the incorrect permissions in the target directory under Windows (e.g., `The permissions are incorrectly ordered, which may cause some entries to be ineffective.` or `Deny for "NULL SID"`)? {: #windows-permissions }
  
**A:** Use the `chmod` argument of the `RSync` class with something like `.chmod("ugo=rwX")` ([source](https://stackoverflow.com/a/5911943/4698227)).
