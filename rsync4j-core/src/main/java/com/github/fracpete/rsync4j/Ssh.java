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
 * Ssh.java
 * Copyright (C) 2018 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j;

import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for the ssh binary.
 * <br>
 * NB: No interactive shell possible.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class Ssh
  extends AbstractBinary {

  protected int verbose;

  /**
   * Resets the members.
   */
  @Override
  public void reset() {
    super.reset();
    verbose = 0;
  }

  /**
   * Sets output commandline flag.
   *
   * @param value	true if to output commandline
   * @return		itself
   */
  public Ssh outputCommandline(boolean value) {
    return (Ssh) super.outputCommandline(value);
  }

  public Ssh verbose(int value) {
    verbose = value;
    return this;
  }

  public int getVerbose() {
    return verbose;
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
    if (getVerbose() > 0) {
      result.add("-v");
      result.add("" + getVerbose());
    }

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
    return "OpenSSH SSH client (remote login program). No interactive sessions possible.";
  }

  /**
   * Configures and returns the commandline parser.
   *
   * @return		the parser
   */
  protected ArgumentParser getParser() {
    ArgumentParser 	parser;

    parser = super.getParser();
    parser.addArgument("-v", "--verbose")
      .dest("verbose")
      .help("increase verbosity")
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

    verbose(ns.getInt("verbose"));

    return true;
  }

  /**
   * For running from the command-line.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Exception {
    run(new Ssh(), args);
  }
}
