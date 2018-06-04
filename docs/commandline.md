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
       [--additional ADDITIONAL] src dest

A fast, versatile, remote (and local) file-copying tool.

positional arguments:
  src                    The local or remote  source  path (path or [user@]
                         host:path)
  dest                   The local  or  remote  destination  path  (path or
                         [user@]host:path)

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
