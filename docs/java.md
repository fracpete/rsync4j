## Rsync

Here is an example of configuring and running `rsync` from within Java, only 
outputting the data from stdout/stderr after the process completes: 

```java
import com.github.fracpete.rsync4j.RSync;
import com.github.fracpete.processoutput4j.output.CollectingProcessOutput;
...
RSync rsync = new RSync()
  .source("/one/place/")
  .destination("/other/place/")
  .recursive(true);
// or if you prefer using commandline options:
// rsync.setOptions(new String[]{"-r", "/one/place/", "/other/place/"});
CollectingProcessOutput output = rsync.execute();
System.out.println(output.getStdOut());
System.out.println("Exit code: " + output.getExitCode());
if (output.getExitCode() > 0)
  System.err.println(output.getStdErr());
```

This example outputs stdout/stderr from the `rsync` process as it occurs, 
rather than waiting till the end:

```java
import com.github.fracpete.rsync4j.RSync;
import com.github.fracpete.processoutput4j.output.ConsoleOutputProcessOutput;
...
RSync rsync = new RSync()
  .source("/one/place/")
  .destination("/other/place/")
  .archive(true)
  .delete(true);
ConsoleOutputProcessOutput output = new ConsoleOutputProcessOutput();
output.monitor(rsync.builder());
```

If you want to process the output (stdout/stderr) from the rsync process
yourself, then you can use `StreamingProcessOutput` instead of 
`ConsoleOutputProcessOutput`. You only need to supply an object of a class
implementing the `StreamingProcessOwner` interface. Below is an example
that simply prefixes the output with either `[OUT]` or `[ERR]`: 

```java
import com.github.fracpete.rsync4j.RSync;
import com.github.fracpete.processoutput4j.core.StreamingProcessOutputType;
import com.github.fracpete.processoutput4j.core.StreamingProcessOwner;
import com.github.fracpete.processoutput4j.output.StreamingProcessOutput;

public static class Output implements StreamingProcessOwner {
  public StreamingProcessOutputType getOutputType() {
    return StreamingProcessOutputType.BOTH;
  }
  public void processOutput(String line, boolean stdout) {
    System.out.println((stdout ? "[OUT] " : "[ERR] ") + line);
  }
}

...
RSync rsync = new RSync()
  .source("/one/place/")
  .destination("/other/place/")
  .recursive(true)
  .verbose(true);
StreamingProcessOutput output = new StreamingProcessOutput(new Output());
output.monitor(rsync.builder());
```

### Windows

When supplying the `rsh` option with an identity, usually like `ssh -i /some/where/key.pub`, 
you need to supply the actual Windows binary and Windows path to the identity.
You can use the `com.github.fracpete.rsync4j.core.Binaries` class to help you
construct the path properly, for instance: 

```java
RSync rsync = new RSync()
  .source("C:\\somedir")
  .destination("D:\\otherdir")
  .recursive(true)
  .rsh(Binaries.sshBinary() + " -i " + Binaries.convertPath("C:\\keys\\mykey.pub"));
```

### Multiple sources

You can specify multiple sources when using the `sources` methods.

Either as array:

```java
String[] s = new String[]{
  "/first/place/", 
  "/second/place/",
};

RSync rsync = new RSync()
  .sources(s)
  .destination("/other/place/")
  .recursive(true)
  .verbose(true);
```

Or as `java.util.List<String>`:

```java
List<String> s = new ArrayList<>();
s.add("/first/place");
s.add("/second/place");

RSync rsync = new RSync()
  .sources(s)
  .destination("/other/place/")
  .recursive(true)
  .verbose(true);
```

## Rsync daemon

Instead of using rsync via ssh, you can also use the 
[rsync daemon](https://download.samba.org/pub/rsync/rsyncd.conf.html) approach.

On the server, you can use something like this as `/etc/rsyncd.conf` to make 
an upload directory `/home/public_rsync` available under the name `files`:

```inifile
pid file = /var/run/rsyncd.pid
lock file = /var/run/rsync.lock
log file = /var/log/rsync.log
port = 12000
charset = utf–8

[files]
path = /home/public_rsync
comment = "public rsync share"
use chroot = true
uid = root
gid = root
read only = false
```

For simplicity, we just start the daemon (running on port 12000) on the server 
(192.168.1.100) as root user as follows:

```bash
sudo rsync --daemon
```

The following command will upload the directory `/home/myuser/some/where` on the  
client to the `files` share:

```java
import com.github.fracpete.rsync4j.RSync;
import com.github.fracpete.processoutput4j.output.ConsoleOutputProcessOutput;
...
RSync rsync = new RSync()
  .recursive(true)
  .times(true)
  .dirs(true)
  .verbose(true)
  .source("/home/myuser/some/where")
  .destination("rsync://192.168.1.100:12000/files/");
ConsoleOutputProcessOutput output = new ConsoleOutputProcessOutput();
output.monitor(rsync.builder());
```

## Ssh

The following command lists all files in the `/tmp` directory of the localhost
in verbose mode and also outputting the generated command-line:

```java
import com.github.fracpete.rsync4j.Ssh;
import com.github.fracpete.processoutput4j.output.ConsoleOutputProcessOutput;
...
Ssh ssh = new Ssh()
  .outputCommandline(true)
  .verbose(1)
  .hostname("localhost")
  .command("ls /tmp");
ConsoleOutputProcessOutput output = new ConsoleOutputProcessOutput();
output.monitor(ssh.builder());
```

## SshKeyGen

The following command generates a key file named `testkey` in your home 
directory of type `dsa`, with no pass-phrase, outputting the bubble babble 
of the key:

```java
import com.github.fracpete.rsync4j.SshKeyGen;
import com.github.fracpete.processoutput4j.output.ConsoleOutputProcessOutput;
...
SshKeyGen keygen = new SshKeyGen()
  .outputCommandline(true)
  .verbose(1)
  .keyType("dsa")
  .newPassPhrase("")
  .comment("test key")
  .keyFile("~/testkey");
ConsoleOutputProcessOutput output = new ConsoleOutputProcessOutput();
output.monitor(keygen.builder());
```
