## RSync

The options of the `com.github.fracpete.rsync4j.RSync` tool are modeled after
the `rsync` executable itself. Here is the help screen:

```
usage: com.github.fracpete.rsync4j.RSync
       [-h] [--output-commandline] [--maxtime MAXTIME] [-v]
       [--info INFO] [--debug DEBUG] [--msgs2stderr] [-q] [--no-motd] [-c]
       [-a] [-r] [-R] [--no-implied-dirs] [-b] [--backup-dir BACKUPDIR]
       [--suffix SUFFIX] [-u] [--inplace] [--append] [--append-verify] [-d]
       [-l] [-L] [--copy-unsafe-links] [--safe-links] [--munge-links] [-k]
       [-K] [-H] [-p] [-E] [--chmod CHMOD] [-X] [-o] [-g] [--devices]
       [--specials] [-t] [-O] [-J] [--super] [--fake-super] [-S]
       [--preallocate] [-n] [-W] [-x] [-B BLOCKSIZE] [-e RSH]
       [--rsync-path RSYNCPATH] [--existing] [--ignore-existing]
       [--remove-source-files] [--delete] [--delete-before]
       [--delete-during] [--delete-delay] [--delete-after]
       [--delete-excluded] [--ignore-missing-args] [--delete-missing-args]
       [--ignore-errors] [--force] [--max-delete MAXDELETE]
       [--max-size MAXSIZE] [--min-size MINSIZE] [--partial]
       [--partial-dir PARTIALDIR] [--delay-updates] [-m] [--numeric-ids]
       [--usermap USERMAP] [--groupmap GROUPMAP] [--chown CHOWN]
       [--timeout TIMEOUT] [--contimeout CONTIMEOUT] [-I] [-M REMOTEOPTION]
       [--size-only] [--modify-window MODIFYWINDOW] [-T TEMPDIR] [-y]
       [--compare-dest COMPAREDEST] [--copy-dest COPYDEST]
       [--link-dest LINKDEST] [-z] [--compress-level COMPRESSLEVEL]
       [--skip-compress SKIPCOMPRESS] [-C] [-f FILTER] [--exclude EXCLUDE]
       [--exclude-from EXCLUDEFROM] [--include INCLUDE]
       [--include-from INCLUDEFROM] [--files-from FILESFROM] [-0] [-s]
       [--address ADDRESS] [--port PORT] [--sockopts SOCKOPTS]
       [--blocking-io] [--stats] [-8] [--human-readable] [--progress] [-i]
       [--out-format OUTFORMAT] [--log-file LOGFILE]
       [--log-file-format LOGFILEFORMAT] [--password-file PASSWORDFILE]
       [--list-only] [--bwlimit BWLIMIT] [--outbuf OUTBUF]
       [--write-batch WRITEBATCH] [--only-write-batch ONLYWRITEBATCH]
       [--read-batch READBATCH] [--protocol PROTOCOL] [--iconv ICONV]
       [--checkum-seed CHECKSUMSEED] [-4] [-6] [--version]
       [--additional ADDITIONAL]
       [source(s)/destination [source(s)/destination ...]]

A fast, versatile, remote (and local) file-copying tool.
See man page:
https://linux.die.net/man/1/rsync

positional arguments:
  source(s)/destination  Multiple local/remote paths  (path or [user@]host:
                         path), with the last one  being the target and the
                         others the source(s).

optional arguments:
  -h, --help             show this help message and exit
  --output-commandline   output the command-line generated  for the wrapped
                         binary
  --maxtime MAXTIME      set the maximum time  for  the  process  to run in
                         seconds before getting killed
  -v, --verbose          increase verbosity
  --info INFO            fine-grained informational verbosity
  --debug DEBUG          fine-grained debug verbosity
  --msgs2stderr          special output handling for debugging
  -q, --quiet            suppress non-error messages
  --no-motd              suppress daemon-mode MOTD
  -c, --checksum         skip based on checksum, not mod-time & size
  -a, --archive          archive mode; equals -rlptgoD (no -H,-A,-X)
  -r, --recursive        recurse into directories
  -R, --relative         use relative path names
  --no-implied-dirs      use relative path names
  -b, --backup           make backups (see --suffix & --backup-dir)
  --backup-dir BACKUPDIR
                         make backups into hierarchy based in DIR
  --suffix SUFFIX        set backup suffix (default ~ w/o --backup-dir)
  -u, --update           skip files that are newer on the receiver
  --inplace              update destination files in-place
  --append               append data onto shorter files
  --append-verify        like --append, but with old data in file checksum
  -d, --dirs             transfer directories without recursing
  -l, --links            copy symlinks as symlinks
  -L, --copy-links       transform symlink into referent file/dir
  --copy-unsafe-links    only "unsafe" symlinks are transformed
  --safe-links           ignore symlinks that point outside the source tree
  --munge-links          munge symlinks to make them safer (but unusable)
  -k, --copy-dirlinks    transform symlink to a dir into referent dir
  -K, --keep-dirlinks    treat symlinked dir on receiver as dir
  -H, --hard-links       preserve hard links
  -p, --perms            preserve permissions
  -E, --executability    preserve the file's executability
  --chmod CHMOD          affect file and/or directory permissions
  -X, --xattrs           preserve extended attributes
  -o, --owner            preserve owner (super-user only)
  -g, --group            preserve group
  --devices              preserve device files (super-user only)
  --specials             preserve special files
  -t, --times            preserve modification times
  -O, --omit-dir-times   omit directories from --times
  -J, --omit-link-times  omit symlinks from --times
  --super                receiver attempts super-user activities
  --fake-super           store/recover privileged attrs using xattrs
  -S, --sparse           handle sparse files efficiently
  --preallocate          allocate dest files before writing them
  -n, --dry-run          perform a trial run with no changes made
  -W, --whole-file       copy files whole (without delta-xfer algorithm)
  -x, --one-file-system  don't cross filesystem boundaries
  -B BLOCKSIZE, --block-size BLOCKSIZE
                         force a fixed checksum block-size
  -e RSH, --rsh RSH      specify the remote shell to use
  --rsync-path RSYNCPATH
                         specify the rsync to run on the remote machine
  --existing             skip creating new files on receiver
  --ignore-existing      skip updating files that already exist on receiver
  --remove-source-files  sender removes synchronized files (non-dirs)
  --delete               delete extraneous files from destination dirs
  --delete-before        receiver deletes before transfer, not during
  --delete-during        receiver deletes during the transfer
  --delete-delay         find deletions during, delete after
  --delete-after         receiver deletes after transfer, not during
  --delete-excluded      also delete excluded files from destination dirs
  --ignore-missing-args  ignore missing source args without error
  --delete-missing-args  delete missing source args from destination
  --ignore-errors        delete even if there are I/O errors
  --force                force deletion of directories even if not empty
  --max-delete MAXDELETE
                         don't delete more than NUM files
  --max-size MAXSIZE     don't transfer any file larger than SIZE
  --min-size MINSIZE     don't transfer any file smaller than SIZE
  --partial              keep partially transferred files
  --partial-dir PARTIALDIR
                         put a partially transferred file into DIR
  --delay-updates        put all updated files into place at transfer's end
  -m, --prune-empty-dirs
                         prune empty directory chains from the file-list
  --numeric-ids          don't map uid/gid values by user/group name
  --usermap USERMAP      custom username mapping
  --groupmap GROUPMAP    custom groupname mapping
  --chown CHOWN          simple username/groupname mapping
  --timeout TIMEOUT      set I/O timeout in seconds
  --contimeout CONTIMEOUT
                         set daemon connection timeout in seconds
  -I, --ignore-times     don't skip files that match in size and mod-time
  -M REMOTEOPTION, --remote-option REMOTEOPTION
                         send OPTION to the remote side only
  --size-only            skip files that match in size
  --modify-window MODIFYWINDOW
                         compare mod-times with reduced accuracy
  -T TEMPDIR, --temp-dir TEMPDIR
                         create temporary files in directory DIR
  -y, --fuzzy            find similar file for basis if no dest file
  --compare-dest COMPAREDEST
                         also compare destination files relative to DIR
  --copy-dest COPYDEST   ... and include copies of unchanged files
  --link-dest LINKDEST   hardlink to files in DIR when unchanged
  -z, --compress         compress file data during the transfer
  --compress-level COMPRESSLEVEL
                         explicitly set compression level
  --skip-compress SKIPCOMPRESS
                         skip compressing files with a suffix in LIST
  -C, --cvs-exclude      auto-ignore files the same way CVS does
  -f FILTER, --filter FILTER
                         add a file-filtering RULE
  --exclude EXCLUDE      exclude files matching PATTERN
  --exclude-from EXCLUDEFROM
                         read exclude patterns from FILE
  --include INCLUDE      include files matching PATTERN
  --include-from INCLUDEFROM
                         read include patterns from FILE
  --files-from FILESFROM
                         read list of source-file names from FILE
  -0, --from0            all *-from/filter files are delimited by 0s
  -s, --protect-args     no space-splitting; only wildcard special-chars
  --address ADDRESS      bind address for outgoing socket to daemon
  --port PORT            specify double-colon alternate port number
  --sockopts SOCKOPTS    specify custom TCP options
  --blocking-io          use blocking I/O for the remote shell
  --stats                give some file-transfer stats
  -8, --8-bit-output     leave high-bit chars unescaped in output
  --human-readable       output numbers in a human-readable format
  --progress             show progress during transfer
  -i, --itemize-changes  output a change-summary for all updates
  --out-format OUTFORMAT
                         output updates using the specified FORMAT
  --log-file LOGFILE     log what we're doing to the specified FILE
  --log-file-format LOGFILEFORMAT
                         log updates using the specified FMT
  --password-file PASSWORDFILE
                         read daemon-access password from FILE
  --list-only            list the files instead of copying them
  --bwlimit BWLIMIT      limit socket I/O bandwidth
  --outbuf OUTBUF        set output  buffering  to  None,  Line,  or  Block
                         (N|L|B)
  --write-batch WRITEBATCH
                         write a batched update to FILE
  --only-write-batch ONLYWRITEBATCH
                         like --write-batch but w/o updating destination
  --read-batch READBATCH
                         read a batched update from FILE
  --protocol PROTOCOL    force an older protocol version to be used
  --iconv ICONV          request charset conversion of filenames
  --checkum-seed CHECKSUMSEED
                         set block/file checksum seed (advanced)
  -4, --ipv4             prefer IPv4
  -6, --ipv6             prefer IPv6
  --version              print version number
  --additional ADDITIONAL
                         generic option to pass  on  to rsync; for command-
                         line parsing to work  though,  leading dashes must
                         get   replaced   with    '+',   eg   '--additional
                         "++exclude=*~"'
```

## Ssh

The options of the `com.github.fracpete.rsync4j.Ssh` tool are modeled after
the `ssh` executable itself. Here is the help screen:

```
usage: com.github.fracpete.rsync4j.Ssh
       [-h] [--output-commandline] [--maxtime MAXTIME] [-1] [-2] [-4]
       [-6] [-A] [-a] [-b BINDADDRESS] [-C] [-c CIPHERSPEC]
       [-D DYNAMICBINDADDRESS] [-E LOGFILE] [-e ESCAPECHAR] [-F CONFIGFILE]
       [-f] [-G] [-g] [-I PKCS11] [-K] [-k] [-L LOCAL] [-l LOGINNAME] [-M]
       [-m MACSPEC] [-N] [-n] [-O CONTROLCOMMAND] [-o OPTION] [-p PORT]
       [-q] [-R REMOTE] [-s] [-T] [-t] [-v] [-vv] [-vvv] [-W FORWARDTO]
       [-w FORWARDTUNNEL] [-X] [-x] [-Y] [-y] hostname  [command]

OpenSSH  SSH  client  (remote  login   program).  No  interactive  sessions
possible.
See man page:
https://linux.die.net/man/1/ssh

positional arguments:
  hostname               The hostname to connect to.
                         The hostname to connect to.
  command                The remote command to execute.

optional arguments:
  -h, --help             show this help message and exit
  --output-commandline   output the command-line generated  for the wrapped
                         binary
  --maxtime MAXTIME      set the maximum time  for  the  process  to run in
                         seconds before getting killed
  -1                     Forces ssh to try protocol version 1 only.
  -2                     Forces ssh to try protocol version 2 only.
  -4                     Forces ssh to use IPv4 addresses only.
  -6                     Forces ssh to use IPv6 addresses only.
  -A                     Enables forwarding  of  the  authentication  agent
                         connection.
  -a                     Disables forwarding  of  the  authentication agent
                         connection.
  -b BINDADDRESS         Use bind_address  on  the  local  machine  as  the
                         source address of the connection.
  -C                     Requests compression of all data.
  -c CIPHERSPEC          Selects the  cipher  specification  for encrypting
                         the session.
  -D DYNAMICBINDADDRESS  Specifies  a  local   “dynamic”  application-level
                         port forwarding ([bind_address:]port).
  -E LOGFILE             Append debug logs to  log_file instead of standard
                         error.
  -e ESCAPECHAR          Sets the escape character for  sessions with a pty
                         (default: ‘~’).
  -F CONFIGFILE          Specifies an  alternative  per-user  configuration
                         file.
  -f                     Requests ssh  to  go  to  background  just  before
                         command execution.
  -G                     Causes  ssh  to  print   its  configuration  after
                         evaluating Host and Match blocks and exit.
  -g                     Allows remote hosts to  connect to local forwarded
                         ports
  -I PKCS11              Specify the PKCS#11 shared  library ssh should use
                         to communicate with a  PKCS#11 token providing the
                         user's private RSA key.
  -K                     Enables    GSSAPI-based     authentication     and
                         forwarding (delegation) of  GSSAPI  credentials to
                         the server.
  -k                     Disables   forwarding   (delegation)   of   GSSAPI
                         credentials to the server.
  -L LOCAL               Specifies that connections to  the  given TCP port
                         or Unix socket on the  local  (client) host are to
                         be forwarded to the given  host  and port, or Unix
                         socket, on the remote side.
  -l LOGINNAME           Specifies the user  to  log  in  as  on the remote
                         machine.
  -M                     Places the  ssh  client  into  “master”  mode  for
                         connection sharing.
  -m MACSPEC             A   comma-separated   list    of    MAC   (message
                         authentication  code)  algorithms,   specified  in
                         order of preference.
  -N                     Do not execute a  remote  command.  This is useful
                         for just forwarding ports.
  -n                     Redirects   stdin   from    /dev/null   (actually,
                         prevents reading from stdin).
  -O CONTROLCOMMAND      Control an active  connection  multiplexing master
                         process.
  -o OPTION              Can be used to give options  in the format used in
                         the configuration file.
  -p PORT                Port to connect to on the remote host.
  -q                     Quiet mode.  Causes  most  warning  and diagnostic
                         messages to be suppressed.
  -R REMOTE              Specifies that connections to  the  given TCP port
                         or Unix socket on the  remote (server) host are to
                         be forwarded to the given  host  and port, or Unix
                         socket, on the local side.
  -s                     May be used to  request  invocation of a subsystem
                         on the remote system.
  -T                     Disable pseudo-terminal allocation.
  -t                     Force pseudo-terminal allocation.
  -v                     Verbose mode.
  -vv                    Very verbose mode.
  -vvv                   Very, very verbose mode.
  -W FORWARDTO           Requests that standard  input  and  output  on the
                         client be  forwarded  to  host  on  port  over the
                         secure channel.
  -w FORWARDTUNNEL       Requests  tunnel   device   forwarding   with  the
                         specified  tun(4)  devices   between   the  client
                         (local_tun) and the server (remote_tun).
  -X                     Enables X11 forwarding.
  -x                     Disables X11 forwarding.
  -Y                     Enables trusted X11 forwarding.
  -y                     Send  log  information  using  the  syslog  system
                         module.
```

## SshKeyGen

The options of the `com.github.fracpete.rsync4j.SshKeyGen` tool are modeled after
the `ssh-keygen` executable itself. Here is the help screen:

```
usage: com.github.fracpete.rsync4j.SshKeyGen
       [-h] [--output-commandline] [-A] [-a ROUNDS] [-B] [-b BITS]
       [-C COMMENT] [-D PKCS11] [-E FINGERPRINT] [-e] [-F FINDHOST]
       [-f KEYFILE] [-G CANDIDATEPRIMES] [-g] [-H] [--host] [-i]
       [-J SCREENNUMLINES] [-j SCREENSTARTLINE] [-K SCREENCHECKPOINT] [-k]
       [-L] [-l] [-M MEMORY] [-m KEYFORMAT] [-N NEWPASSPHRASE]
       [-n PRINCIPALS] [-O OPTION] [-o] [-P PASSPHRASE] [-p] [-Q] [-q]
       [-R REMOVEKEYS] [-r PRINTFINGERPRINT] [-S STARTPOINT] [-s SIGNCAKEY]
       [-T TESTCANDIDATEPRIMES] [-t KEYTYPE] [-u] [-V VALIDITYINTERVAL]
       [-v] [-vv] [-vvv] [-W GENERATOR] [-y] [-z SERIALNUMBER]
       [file [file ...]]

Authentication key generation, management and conversion.
See man page:
https://linux.die.net/man/1/ssh-keygen

positional arguments:
  file                   The key file(s).

optional arguments:
  -h, --help             show this help message and exit
  --output-commandline   output the command-line generated  for the wrapped
                         binary
  -A                     For each of the key  types  (rsa1, rsa, dsa, ecdsa
                         and ed25519) for  which  host  keys  do not exist,
                         generate the host keys  with  the default key file
                         path, an empty  passphrase,  default  bits for the
                         key type, and default comment.
  -a ROUNDS              When saving  a  new-format  private  key  (i.e. an
                         ed25519 key or any SSH protocol  2 key when the -o
                         flag is set), this option  specifies the number of
                         KDF (key derivation function) rounds used.
  -B                     Show the bubblebabble digest  of specified private
                         or public key file.
  -b BITS                Specifies the number of bits in the key to create.
  -C COMMENT             Provides a new comment.
  -D PKCS11              Download the  RSA  public  keys  provided  by  the
                         PKCS#11 shared library pkcs11.
  -E FINGERPRINT         Specifies the hash algorithm  used when displaying
                         key fingerprints.
  -e                     This option will read a  private or public OpenSSH
                         key file and print  to  stdout  the  key in one of
                         the formats specified by the -m option.
  -F FINDHOST            Search   for   the   specified   hostname   in   a
                         known_hosts file, listing any occurrences found.
  -f KEYFILE             Specifies the filename of the key file.
  -G CANDIDATEPRIMES     Generate candidate primes for DH-GEX..
  -g                     Use generic DNS  format  when printing fingerprint
                         resource records using the -r command.
  -H                     Hash a known_hosts file.
  --host                 When signing  a  key,  create  a  host certificate
                         instead of a user certificate.
  -i                     This option will read  an  unencrypted private (or
                         public) key file in the  format specified by the -
                         m option and print  an  OpenSSH compatible private
                         (or public) key to stdout.
  -J SCREENNUMLINES      Exit  after  screening  the  specified  number  of
                         lines  while  performing  DH  candidate  screening
                         using the -T option.
  -j SCREENSTARTLINE     Start  screening  at  the  specified  line  number
                         while performing DH candidate  screening using the
                         -T option.
  -K SCREENCHECKPOINT    Write the last line processed  to the file checkpt
                         while performing DH candidate  screening using the
                         -T option.
  -k                     Generate a KRL file.
  -L                     Prints the contents of one or more certificates.
  -l                     Show fingerprint of specified public key file.
  -M MEMORY              Specify  the  amount   of   memory   to   use  (in
                         megabytes) when  generating  candidate  moduli for
                         DH-GEX.
  -m KEYFORMAT           Specify a key format  for  the  -i  (import) or -e
                         (export) conversion options.
  -N NEWPASSPHRASE       Provides the new passphrase.
  -n PRINCIPALS          Specify one  or  more  principals  (user  or  host
                         names)  to  be  included  in  a  certificate  when
                         signing a key.
  -O OPTION              Specify a certificate option when signing a key.
  -o                     Causes ssh-keygen to save  private  keys using the
                         new  OpenSSH   format   rather   than   the   more
                         compatible PEM format.
  -P PASSPHRASE          Provides the (old) passphrase.
  -p                     Requests changing the passphrase  of a private key
                         file instead of creating a new private key.
  -Q                     Test whether keys have been revoked in a KRL.
  -q                     Silence ssh-keygen.
  -R REMOVEKEYS          Removes all  keys  belonging  to  hostname  from a
                         known_hosts file.
  -r PRINTFINGERPRINT    Print the SSHFP fingerprint  resource record named
                         hostname for the specified public key file.
  -S STARTPOINT          Specify  start  point  (in  hex)  when  generating
                         candidate moduli for DH-GEX.
  -s SIGNCAKEY           Certify (sign) a  public  key  using the specified
                         CA key.
  -T TESTCANDIDATEPRIMES
                         Test   DH   group    exchange   candidate   primes
                         (generated using the -G option) for safety.
  -t KEYTYPE             Specifies the type of key to create.
  -u                     Update a KRL.
  -V VALIDITYINTERVAL    Specify  a  validity   interval   when  signing  a
                         certificate.
  -v                     Verbose mode.
  -vv                    Very verbose mode.
  -vvv                   Very, very verbose mode.
  -W GENERATOR           Specify desired generator  when  testing candidate
                         moduli for DH-GEX.
  -y                     This option will  read  a  private  OpenSSH format
                         file and print an OpenSSH public key to stdout.
  -z SERIALNUMBER        Specifies a serial number  to  be  embedded in the
                         certificate to distinguish  this  certificate from
                         others from the same CA.
```
