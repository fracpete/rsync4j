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


## Ssh

The following command lists all files in the `/tmp` directory of the localhost
in verbose mode and also outputting the generated command-line:

```java
import com.github.fracpete.rsync4j.Ssh;
import com.github.fracpete.processoutput4j.output.CollectingProcessOutput;
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
import com.github.fracpete.processoutput4j.output.CollectingProcessOutput;
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
