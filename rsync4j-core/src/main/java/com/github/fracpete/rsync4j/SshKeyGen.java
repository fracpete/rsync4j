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

  public SshKeyGen verbose(int value) {
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
