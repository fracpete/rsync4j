Add the following artifact to your dependencies of your `pom.xml` for Windows64 support:

```xml
    <dependency>
      <groupId>com.github.fracpete</groupId>
      <artifactId>rsync4j-windows64</artifactId>
      <version>3.3.0-6</version>
    </dependency>
```

Other operating systems like Linux/Mac need the rsync/ssh binaries installed locally and only require the
dependency for the Java wrapper classes:

```xml
    <dependency>
      <groupId>com.github.fracpete</groupId>
      <artifactId>rsync4j-core</artifactId>
      <version>3.3.0-6</version>
    </dependency>
```
