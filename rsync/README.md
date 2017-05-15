# rsync

## Download
Download rsync from:

https://download.samba.org/pub/rsync/

## Compilation

### Linux
Use the following command to compile a static rsync binary using gcc:
```
CFLAGS=-static ./configure && make clean && make
```

### Windows
* download cygwin installer
  
  https://cygwin.com/install.html
  
* install packages

  * rsync

* use (dependency walker)[http://www.dependencywalker.com/] to determine required 
  dlls for `rysnc.exe` binary, most likely:

  * cygwin1.dll
  * cygiconv-2.dll
  

### OSX
Make sure to have Xcode installed with command-line build tools support.

Use the following command to compile a static rsync binary using gcc:
```
CFLAGS=-static ./configure && make clean && make
```

