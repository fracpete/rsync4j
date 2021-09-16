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
 * SshPass.java
 * Copyright (C) 2021 University of Waikato, Hamilton, New Zealand
 */

package com.github.fracpete.rsync4j;

import com.github.fracpete.rsync4j.core.AbstractBinary;
import com.github.fracpete.rsync4j.core.Binaries;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for the sshpass binary.
 *
 * @author fracpete (fracpete at waikato dot ac dot nz)
 */
public class SshPass
  extends AbstractBinary {

  protected String password;

  protected String filename;

  protected boolean fromEnvVar;

  protected boolean verbose;

  /**
   * Resets the members.
   */
  @Override
  public void reset() {
    super.reset();
    password = "";
    filename = "";
    fromEnvVar = false;
    verbose = false;
  }

  /**
   * sshpass option: -p
   */
  public SshPass password(String value) {
    password = value;
    return this;
  }

  /**
   * sshpass option: -p
   */
  public String getPassword() {
    return password;
  }

  /**
   * sshpass option: -f
   */
  public SshPass filename(String value) {
    filename = value;
    return this;
  }

  /**
   * sshpass option: -f
   */
  public String getFilename() {
    return filename;
  }

  /**
   * sshpass option: -e
   */
  public SshPass fromEnvVar(boolean value) {
    fromEnvVar = value;
    return this;
  }

  /**
   * sshpass option: -e
   */
  public boolean getFromEnvVar() {
    return fromEnvVar;
  }

  /**
   * sshpass option: -v
   */
  public SshPass verbose(boolean value) {
    verbose = value;
    return this;
  }

  /**
   * sshpass option: -v
   */
  public boolean getVerbose() {
    return verbose;
  }

  /**
   * Sets output commandline flag.
   *
   * @param value	true if to output commandline
   * @return		itself
   */
  public SshPass outputCommandline(boolean value) {
    return (SshPass) super.outputCommandline(value);
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
    if (!getPassword().isEmpty()) {
      result.add("-p");
      result.add(getPassword());
    }
    if (!getFilename().isEmpty()) {
      result.add("-f");
      result.add(getFilename());
    }
    if (getFromEnvVar()) result.add("-e");
    if (getVerbose()) result.add("-v");

    return result;
  }

  /**
   * Assembles the full command-line arguments.
   *
   * @throws Exception if failed to determine binary
   * @return the command-line arguments
   * @see                #options()
   */
  @Override
  public List<String> commandLineArgs() throws Exception {
    List<String> 	result;
    String 		binary;

    binary = Binaries.sshpassBinary();
    result = options();
    result.add(0, binary);

    return result;
  }

  /**
   * Returns a short description for the binary.
   *
   * @return the description
   */
  @Override
  protected String description() {
    return "Non-interactive ssh password provider.\n"
	+ "See man page:\n"
	+ "https://linux.die.net/man/1/sshpass";
  }

  /**
   * Configures and returns the commandline parser.
   *
   * @return		the parser
   */
  protected ArgumentParser getParser() {
    ArgumentParser 	parser;

    parser = super.getParser();
    parser.addArgument("-p")
	.dest("password")
	.help("The password is given on the command line (least secure option).")
	.setDefault("");
    parser.addArgument("-f")
	.dest("filename")
	.help("The password is the first line of the file filename.")
	.setDefault("");
    parser.addArgument("-e")
	.dest("fromEnvVar")
	.help("The password is taken from the environment variable \"SSHPASS\".")
	.action(Arguments.storeTrue())
	.setDefault(false);
    parser.addArgument("-v")
	.dest("verbose")
	.help("Be verbose. sshpass will output to stderr information that should help debug cases where the connection hangs, seemingly for no good reason.")
	.action(Arguments.storeTrue())
	.setDefault(false);

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

    password(ns.getString("password"));
    filename(ns.getString("filename"));
    fromEnvVar(ns.getBoolean("fromEnvVar"));
    verbose(ns.getBoolean("verbose"));

    return true;
  }

  /**
   * For running from the command-line.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Exception {
    run(new SshPass(), args);
  }
}
