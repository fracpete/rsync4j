On first execution, these binaries will get placed in the following directory
(on a per user basis):
```
%USERPROFILE%\rsync4j
```

Below that directory there are `home/%USERNAME%/.ssh` and `bin`.

### ssh vs plain protocol
By default, plain protocol is used. If you want to use ssh, then
simply supply this via the dummy string `ssh`. In Java code, this is done via 
`rsh("ssh")`. On the command-line, via `--rsh=ssh`.

### SSH keys
You can place your ssh key pairs in the following directory:

```
%USERPROFILE%\rsync4j\home\%USERNAME%\.ssh
```

### Binaries (64-bit)
*rsync4j* uses the `rsync.exe`, `ssh.exe` and `ssh-keygen.exe` executables and 
their dependencies from the 64-bit version of [cywgin](https://cygwin.com/).

The dependencies, as of 2023-10-31 (OpenSSH 9.4p1-1), are as follows:

* cygcom_err-2.dll
* cygcrypto-1.1.dll
* cyggcc_s-seh-1.dll
* cyggssapi_krb5-2.dll
* cygiconv-2.dll
* cygintl-8.dll
* cygk5crypto-3.dll
* cygkrb5-3.dll
* cygkrb5support-0.dll
* cyglz4-1.dll
* cygwin1.dll
* cygxxhash-0.dll
* cygz.dll
* cygzstd-1.dll

You can easily determine the dependencies by running the executables. Windows
will automatically pop up a dialog mentioning any DLLs that are missing. Place
any missing DLLs in the following directory:

```
rsync4j-windows64/src/main/resources/com/github/fracpete/rsync4j/windows64
```

And list the DLLs in the following text file:

```
rsync4j-windows64/src/main/resources/com/github/fracpete/rsync4j/windows64/libraries.txt
```

### Paths
Since cygwin is being used, local paths get converted to cywgin notation.

For example:
```
C:\some\path\blah.txt
```
Will get automatically get converted to:
```
/cygdrive/c/some/path/blah.txt
```

### Syncing between Windows hosts

You can easily synchronize two Windows hosts by using a UNC path for the remote
host. For instance, directory `C:\some\dir` on the local machine can be synced
to remotehost `otherbox` into directory `C:\other\dir` using these paths:

* source: `/cygdrive/c/some/dir/`
* destination: `//otherbox/C$/other/dir`


### Custom location {: #custom-location }

See [Environment variables/Windows](/env_vars/#windows).

