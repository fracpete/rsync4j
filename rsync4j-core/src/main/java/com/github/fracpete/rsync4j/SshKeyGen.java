/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * SshKeyGen.java
 * Copyright (C) 2018 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j;

import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wrapper for the ssh-keygen binary.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class SshKeyGen
  extends AbstractBinary {

  protected boolean forAll;

  protected int rounds;

  protected boolean bubbleBabble;

  protected int bits;

  protected String comment;

  protected String pkcs11;

  protected String fingerprint;

  protected boolean export;

  protected String findHost;

  protected String keyFile;

  protected String candidatePrimes;

  protected boolean genericDnsFormat;

  protected boolean hashKnownHosts;

  protected boolean createHostCertificate;

  protected String certificateIdentity;

  protected boolean importUnencrypted;

  protected int screenNumLines;

  protected int screenStartLine;

  protected String screenCheckPoint;

  protected boolean generateKRL;

  protected boolean printContents;

  protected boolean showFingerprint;

  protected int memory;

  protected String keyFormat;

  protected String newPassPhrase;

  protected String principals;

  protected List<String> option;

  protected int verbose;

  /**
   * Resets the members.
   */
  @Override
  public void reset() {
    super.reset();
    forAll = false;
    rounds = -1;
    bubbleBabble = false;
    bits = -1;
    comment = "";
    pkcs11 = "";
    fingerprint = "";
    export = false;
    findHost = "";
    keyFile = "";
    candidatePrimes = "";
    genericDnsFormat = false;
    hashKnownHosts = false;
    createHostCertificate = false;
    certificateIdentity = "";
    importUnencrypted = false;
    screenNumLines = -1;
    screenStartLine = -1;
    screenCheckPoint = "";
    generateKRL = false;
    printContents = false;
    showFingerprint = false;
    memory = -1;
    keyFormat = "";
    newPassPhrase = "";
    principals = "";
    option = new ArrayList<>();
    verbose = 0;
  }

  public SshKeyGen forAll(boolean value) {
    forAll = value;
    return this;
  }

  public boolean isForAll() {
    return forAll;
  }

  public SshKeyGen rounds(int value) {
    rounds = value;
    return this;
  }

  public int getRounds() {
    return verbose;
  }

  public SshKeyGen bubbleBabble(boolean value) {
    bubbleBabble = value;
    return this;
  }

  public boolean isBubbleBabble() {
    return bubbleBabble;
  }

  public SshKeyGen bits(int value) {
    bits = value;
    return this;
  }

  public int getBits() {
    return bits;
  }

  public SshKeyGen comment(String value) {
    comment = value;
    return this;
  }

  public String getComment() {
    return comment;
  }

  public SshKeyGen pkcs11(String value) {
    pkcs11 = value;
    return this;
  }

  public String getPkcs11() {
    return pkcs11;
  }

  public SshKeyGen fingerprint(String value) {
    fingerprint = value;
    return this;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public SshKeyGen export(boolean value) {
    export = value;
    return this;
  }

  public boolean isExport() {
    return export;
  }

  public SshKeyGen findHost(String value) {
    findHost = value;
    return this;
  }

  public String getFindHost() {
    return findHost;
  }

  public SshKeyGen keyFile(String value) {
    keyFile = value;
    return this;
  }

  public String getKeyFile() {
    return keyFile;
  }

  public SshKeyGen candidatePrimes(String value) {
    candidatePrimes = value;
    return this;
  }

  public String getCandidatePrimes() {
    return candidatePrimes;
  }

  public SshKeyGen genericDnsFormat(boolean value) {
    genericDnsFormat = value;
    return this;
  }

  public boolean isGenericDnsFormat() {
    return genericDnsFormat;
  }

  public SshKeyGen hashKnownHosts(boolean value) {
    hashKnownHosts = value;
    return this;
  }

  public boolean isHashKnownHosts() {
    return hashKnownHosts;
  }

  public SshKeyGen createHostCertificate(boolean value) {
    createHostCertificate = value;
    return this;
  }

  public boolean isCreateHostCertificate() {
    return createHostCertificate;
  }

  public SshKeyGen certificateIdentity(String value) {
    certificateIdentity = value;
    return this;
  }

  public String getCertificateIdentity() {
    return certificateIdentity;
  }

  public SshKeyGen importUnencrypted(boolean value) {
    importUnencrypted = value;
    return this;
  }

  public boolean isImportUnencrypted() {
    return importUnencrypted;
  }

  public SshKeyGen screenNumLines(int value) {
    if (value >= -1)
      screenNumLines = value;
    return this;
  }

  public int getScreenNumLines() {
    return screenNumLines;
  }

  public SshKeyGen screenStartLine(int value) {
    if (value >= -1)
      screenStartLine = value;
    return this;
  }

  public int getScreenStartLine() {
    return screenStartLine;
  }

  public SshKeyGen screenCheckPoint(String value) {
    screenCheckPoint = value;
    return this;
  }

  public String getScreenCheckPoint() {
    return screenCheckPoint;
  }

  public SshKeyGen generateKRL(boolean value) {
    generateKRL = value;
    return this;
  }

  public boolean isGenerateKRL() {
    return generateKRL;
  }

  public SshKeyGen printContents(boolean value) {
    printContents = value;
    return this;
  }

  public boolean isPrintContents() {
    return printContents;
  }

  public SshKeyGen showFingerprint(boolean value) {
    showFingerprint = value;
    return this;
  }

  public boolean isShowFingerprint() {
    return showFingerprint;
  }

  public SshKeyGen memory(int value) {
    if ((value == -1) || (value > 0))
      memory = value;
    return this;
  }

  public int getMemory() {
    return memory;
  }

  public SshKeyGen keyFormat(String value) {
    keyFormat = value;
    return this;
  }

  public String getKeyFormat() {
    return keyFormat;
  }

  public SshKeyGen newPassPhrase(String value) {
    newPassPhrase = value;
    return this;
  }

  public String getNewPassPhrase() {
    return newPassPhrase;
  }

  public SshKeyGen principals(String value) {
    principals = value;
    return this;
  }

  public String getPrincipals() {
    return principals;
  }

  public SshKeyGen option(String... value) {
    option = new ArrayList<>(Arrays.asList(value));
    return this;
  }

  public SshKeyGen option(List<String> value) {
    option = new ArrayList<>(value);
    return this;
  }

  public List<String> getOption() {
    return option;
  }

  public SshKeyGen verbose(int value) {
    if ((value >= -1) && (value <= 3))
      verbose = value;
    return this;
  }

  public int getVerbose() {
    return verbose;
  }

  /**
   * Sets output commandline flag.
   *
   * @param value	true if to output commandline
   * @return		itself
   */
  public SshKeyGen outputCommandline(boolean value) {
    return (SshKeyGen) super.outputCommandline(value);
  }

  /**
   * Assembles the arguments for the binary.
   *
   * @return		the options
   * @throws Exception	if failed to determine binary
   */
  @Override
  public List<String> options() throws Exception {
    List<String> 	result;

    result = new ArrayList<>();
    if (isForAll()) result.add("-A");
    if (getRounds() > -1) {
      result.add("-a");
      result.add("" + getRounds());
    }
    if (isBubbleBabble()) result.add("-B");
    if (getBits() > -1) {
      result.add("-b");
      result.add("" + getBits());
    }
    if (!getComment().isEmpty()) {
      result.add("-C");
      result.add(getComment());
    }
    if (!getPkcs11().isEmpty()) {
      result.add("-D");
      result.add(getPkcs11());
    }
    if (!getFingerprint().isEmpty()) {
      result.add("-E");
      result.add(getFingerprint());
    }
    if (isExport()) result.add("-e");
    if (!getFindHost().isEmpty()) {
      result.add("-F");
      result.add(getFindHost());
    }
    if (!getKeyFile().isEmpty()) {
      result.add("-f");
      result.add(getKeyFile());
    }
    if (!getCandidatePrimes().isEmpty()) {
      result.add("-G");
      result.add(getCandidatePrimes());
    }
    if (isGenericDnsFormat()) result.add("-g");
    if (isHashKnownHosts()) result.add("-H");
    if (isCreateHostCertificate()) result.add("-h");
    if (!getCertificateIdentity().isEmpty()) {
      result.add("-I");
      result.add(getCertificateIdentity());
    }
    if (isImportUnencrypted()) result.add("-i");
    if (getScreenNumLines() > -1) {
      result.add("-J");
      result.add("" + getScreenNumLines());
    }
    if (getScreenStartLine() > -1) {
      result.add("-j");
      result.add("" + getScreenStartLine());
    }
    if (!getScreenCheckPoint().isEmpty()) {
      result.add("-K");
      result.add(getScreenCheckPoint());
    }
    if (isGenerateKRL()) result.add("-k");
    if (isPrintContents()) result.add("-L");
    if (isShowFingerprint()) result.add("-l");
    if (getMemory() > -1) {
      result.add("-M");
      result.add("" + getMemory());
    }
    if (!getKeyFormat().isEmpty()) {
      result.add("-m");
      result.add(getKeyFormat());
    }
    if (!getNewPassPhrase().isEmpty()) {
      result.add("-N");
      result.add(getNewPassPhrase());
    }
    if (!getPrincipals().isEmpty()) {
      result.add("-n");
      result.add(getPrincipals());
    }
    for (String o: getOption()) {
      result.add("-O");
      result.add(o);
    }
    if (getVerbose() == 1) result.add("-v");
    if (getVerbose() == 2) result.add("-vv");
    if (getVerbose() == 3) result.add("-vvv");

    return result;
  }

  /**
   * Assembles the full command-line arguments.
   *
   * @return		the command-line arguments
   * @throws Exception	if failed to determine binary
   * @see		#options()
   */
  public List<String> commandLineArgs() throws Exception {
    List<String> 	result;
    String 		binary;

    binary = Binaries.sshBinary();
    result = options();
    result.add(0, binary);

    return result;
  }

  /**
   * Returns a short description for the binary.
   *
   * @return		the description
   */
  @Override
  protected String description() {
    return "Authentication key generation, management and conversion.\n"
      + "See man page:\n"
      + "https://linux.die.net/man/1/ssh-keygen";
  }

  /**
   * Configures and returns the commandline parser.
   *
   * @return		the parser
   */
  protected ArgumentParser getParser() {
    ArgumentParser 	parser;

    parser = super.getParser();
    parser.addArgument("-A")
      .dest("forAll")
      .help("For each of the key types (rsa1, rsa, dsa, ecdsa and ed25519) for which host keys do not exist, generate the host keys with the default key file path, an empty passphrase, default bits for the key type, and default comment.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-a")
      .dest("rounds")
      .help("When saving a new-format private key (i.e. an ed25519 key or any SSH protocol 2 key when the -o flag is set), this option specifies the number of KDF (key derivation function) rounds used.")
      .setDefault(-1);
    parser.addArgument("-B")
      .dest("bubbleBabble")
      .help("Show the bubblebabble digest of specified private or public key file.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-b")
      .dest("bits")
      .help("Specifies the number of bits in the key to create.")
      .setDefault(-1);
    parser.addArgument("-C")
      .dest("comment")
      .help("Provides a new comment.")
      .setDefault("");
    parser.addArgument("-D")
      .dest("pkcs11")
      .help("Download the RSA public keys provided by the PKCS#11 shared library pkcs11.")
      .setDefault("");
    parser.addArgument("-E")
      .dest("fingerprint")
      .help("Specifies the hash algorithm used when displaying key fingerprints.")
      .setDefault("");
    parser.addArgument("-e")
      .dest("export")
      .help("This option will read a private or public OpenSSH key file and print to stdout the key in one of the formats specified by the -m option.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-F")
      .dest("findHost")
      .help("Search for the specified hostname in a known_hosts file, listing any occurrences found.")
      .setDefault("");
    parser.addArgument("-f")
      .dest("keyFile")
      .help("Specifies the filename of the key file.")
      .setDefault("");
    parser.addArgument("-G")
      .dest("candidatePrimes")
      .help("Generate candidate primes for DH-GEX..")
      .setDefault("");
    parser.addArgument("-g")
      .dest("genericDnsFormat")
      .help("Use generic DNS format when printing fingerprint resource records using the -r command.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-H")
      .dest("hashKnownHosts")
      .help("Hash a known_hosts file.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("--host")
      .dest("createHostCertificate")
      .help("When signing a key, create a host certificate instead of a user certificate.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-i")
      .dest("importUnencrypted")
      .help("This option will read an unencrypted private (or public) key file in the format specified by the -m option and print an OpenSSH compatible private (or public) key to stdout.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-J")
      .dest("screenNumLines")
      .help("Exit after screening the specified number of lines while performing DH candidate screening using the -T option.")
      .setDefault(-1);
    parser.addArgument("-j")
      .dest("screenStartLine")
      .help("Start screening at the specified line number while performing DH candidate screening using the -T option.")
      .setDefault(-1);
    parser.addArgument("-K")
      .dest("screenCheckPoint")
      .help("Write the last line processed to the file checkpt while performing DH candidate screening using the -T option.")
      .setDefault("");
    parser.addArgument("-k")
      .dest("generateKRL")
      .help("Generate a KRL file.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-L")
      .dest("printContents")
      .help("Prints the contents of one or more certificates.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-l")
      .dest("showFingerprint")
      .help("Show fingerprint of specified public key file.")
      .action(Arguments.storeTrue())
      .setDefault(false);
    parser.addArgument("-M")
      .dest("memory")
      .help("Specify the amount of memory to use (in megabytes) when generating candidate moduli for DH-GEX.")
      .setDefault(-1);
    parser.addArgument("-m")
      .dest("keyFormat")
      .help("Specify a key format for the -i (import) or -e (export) conversion options.")
      .setDefault("");
    parser.addArgument("-N")
      .dest("newPassPhrase")
      .help("Provides the new passphrase.")
      .setDefault("");
    parser.addArgument("-n")
      .dest("principals")
      .help("Specify one or more principals (user or host names) to be included in a certificate when signing a key.")
      .setDefault("");
    parser.addArgument("-O")
      .dest("option")
      .help("Specify a certificate option when signing a key.")
      .setDefault(new ArrayList<>());
    parser.addArgument("-v")
      .dest("verbose")
      .help("Verbose mode.")
      .action(Arguments.storeConst())
      .setConst(1)
      .setDefault(0);
    parser.addArgument("-vv")
      .dest("verbose")
      .help("Very verbose mode.")
      .action(Arguments.storeConst())
      .setConst(2)
      .setDefault(0);
    parser.addArgument("-vvv")
      .dest("verbose")
      .help("Very, very verbose mode.")
      .action(Arguments.storeConst())
      .setConst(3)
      .setDefault(0);

    return parser;
  }

  /**
   * Sets the parsed options.
   *
   * @param ns		the parsed options
   * @return		if successfully set
   */
  @Override
  protected boolean setOptions(Namespace ns) {
    boolean	result;

    result = super.setOptions(ns);
    if (!result)
      return false;

    forAll(ns.getBoolean("forAll"));
    rounds(ns.getInt("rounds"));
    bubbleBabble(ns.getBoolean("bubbleBabble"));
    bits(ns.getInt("bits"));
    comment(ns.getString("comment"));
    pkcs11(ns.getString("pkcs11"));
    fingerprint(ns.getString("fingerprint"));
    export(ns.getBoolean("export"));
    findHost(ns.getString("findHost"));
    keyFile(ns.getString("keyFile"));
    candidatePrimes(ns.getString("candidatePrimes"));
    genericDnsFormat(ns.getBoolean("genericDnsFormat"));
    hashKnownHosts(ns.getBoolean("hashKnownHosts"));
    createHostCertificate(ns.getBoolean("createHostCertificate"));
    certificateIdentity(ns.getString("certificateIdentity"));
    importUnencrypted(ns.getBoolean("importUnencrypted"));
    screenNumLines(ns.getInt("screenNumLines"));
    screenStartLine(ns.getInt("screenStartLine"));
    screenCheckPoint(ns.getString("screenCheckPoint"));
    generateKRL(ns.getBoolean("generateKRL"));
    printContents(ns.getBoolean("printContents"));
    showFingerprint(ns.getBoolean("showFingerprint"));
    memory(ns.getInt("memory"));
    keyFormat(ns.getString("keyFormat"));
    newPassPhrase(ns.getString("newPassPhrase"));
    principals(ns.getString("principals"));
    option(ns.getList("option"));
    verbose(ns.getInt("verbose"));

    return true;
  }

  /**
   * For running from the command-line.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Exception {
    run(new SshKeyGen(), args);
  }
}
