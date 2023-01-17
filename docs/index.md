Maven project for generating a Java wrapper around [rsync](http://rsync.samba.org/) 
for Linux, Mac OSX and Windows. 

For Windows, binaries are included in the jars and *rsync4j* 
will set up an environment in the user's home directory (`%USERPROFILE%\rsync4j`)
on first usage (can be customized, see Section [Environment variables/Windows](env_vars/#windows)). 

In November 2022, the 32-bit version of Cygwin reached its end-of-life.
Therefore 32-bit support is only available up to version: 3.2.3-12 
