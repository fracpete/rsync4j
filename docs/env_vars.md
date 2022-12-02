# Linux/Mac {: #linux_mac }

Starting with release 3.2.3-12, the locations of the underlying binaries can be 
changed via the following environment variables:

* `RSYNC4J_RSYNC`
* `RSYNC4J_SSH`
* `RSYNC4J_SSHPASS`
* `RSYNC4J_SSHKEYGEN`


# Windows {: #windows }

It is possible to use another location than `%USERPROFILE%\rsync4j`. You only
have to configure the `RSYNC4J_HOME` environment variable to point to the top-level
directory (doesn't have to exist) where you want to house the binaries and keys. 
