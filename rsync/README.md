# rsync

## Download
Download rsync from:

https://download.samba.org/pub/rsync/

## Compilation

### Linux
It is expected that a Linux system has `rsync` and `ssh` already installed.
However, you can use the following command to compile a static rsync binary 
using gcc:

```
CFLAGS=-static ./configure && make clean && make
```

### Windows
* download cygwin installer
  
  https://cygwin.com/install.html
  
* install packages

  * rsync

* use [dependency walker](http://www.dependencywalker.com/) to determine required 
  dlls for `rysnc.exe` and `ssh.exe` binaries, most likely:

  * cygcom_err-2.dll
  * cygcrypto-1.0.0.dll
  * cyggcc_s-seh-1.dll
  * cyggssapi_krb5-2.dll
  * cygiconv-2.dll
  * cygintl-8.dll
  * cygk5crypto-3.dll
  * cygkrb5-3.dll
  * cygkrb5support-0.dll
  * cygssp-0.dll
  * cygwin1.dll
  * cygz.dll
  

### OSX
It is expected that an OSX system has `rsync` and `ssh` already installed.
However, you can compile the `rsync` binary using Xcode. But make sure to 
have Xcode installed with command-line build tools support.

Use the following command to compile a static rsync binary using gcc:
```
CFLAGS=-static ./configure && make clean && make
```

