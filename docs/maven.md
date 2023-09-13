Add the following artifact to your dependencies of your `pom.xml` fot cross-platform support:

```xml
    <dependency>
      <groupId>com.github.fracpete</groupId>
      <artifactId>rsync4j-all</artifactId>
      <version>3.2.7-4</version>
    </dependency>
```

Available artifacts:

* `rsync4j-core`: just the Java wrappers (sufficient for Linux/Mac)
* `rsync4j-windows64`: includes Windows 64-bit binaries in addition to the core module (the 32-bit version has been dropped since cygwin no longer supports win32)
* `rsync4j-all`: combines all modules
