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

/**
 * RSync.java
 * Copyright (C) 2017 University of Waikato, Hamilton, New Zealand
 */
package com.github.fracpete.rsync4j;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for rsync binaries.
 *
 * @author  fracpete (fracpete at gmail dot com)
 * @version $Revision: 8361 $
 */
public class RSync {

  /** the source path/url. */
  protected String m_Source;

  /** the destination path/url. */
  protected String m_Destination;

  /** whether to output the commandline. */
  protected boolean m_OutputCommandline;

  /** whether to be verbose. */
  protected boolean m_Verbose;

  /** whether to recurse into sub-directories. */
  protected boolean m_Recursive;

  /**
   * Initializes the object.
   */
  public RSync() {
    reset();
  }

  /**
   * Resets the members.
   */
  public void reset() {
    m_Source            = null;
    m_Destination       = null;
    m_OutputCommandline = false;
    m_Verbose           = false;
    m_Recursive         = false;
  }

  /**
   * Sets the source path/url.
   *
   * @param value	the source
   */
  public RSync setSource(String value) {
    m_Source = value.replace("\\", "/");
    return this;
  }

  /**
   * Returns the current source path/url.
   *
   * @return		the source, null if not set
   */
  public String getSource() {
    return m_Source;
  }

  /**
   * Sets the destination path/url.
   *
   * @param value	the destination
   * @return		itself
   */
  public RSync setDestination(String value) {
    m_Destination = value.replace("\\", "/");
    return this;
  }

  /**
   * Returns the current destination path/url.
   *
   * @return		the destination, null if not set
   */
  public String getDestination() {
    return m_Destination;
  }

  /**
   * Sets verbose flag.
   *
   * @param value	true if verbose
   * @return		itself
   */
  public RSync setVerbose(boolean value) {
    m_Verbose = value;
    return this;
  }

  /**
   * Returns verbose flag.
   *
   * @return		true if verbose
   */
  public boolean getVerbose() {
    return m_Verbose;
  }

  /**
   * Sets whether to recurse into sub-directories.
   *
   * @param value	true if to recurse
   * @return		itself
   */
  public RSync setRecursive(boolean value) {
    m_Recursive = value;
    return this;
  }

  /**
   * Returns whether to recurse into sub-directories.
   *
   * @return		true if to recurse
   */
  public boolean getRecursive() {
    return m_Recursive;
  }

  /**
   * Sets output commandline flag.
   *
   * @param value	true if to output commandline
   * @return		itself
   */
  public RSync setOutputCommandline(boolean value) {
    m_OutputCommandline = value;
    return this;
  }

  /**
   * Returns output commandline flag.
   *
   * @return		true if to output commandline
   */
  public boolean getOutputCommandline() {
    return m_OutputCommandline;
  }

  /**
   * Executes the rsync binary for the platform.
   *
   * @return		the process object
   * @throws Exception	if execution fails
   */
  public ProcessResult execute() throws Exception {
    ProcessBuilder	builder;
    String 		binary;
    List<String>	args;

    binary = Binaries.extractBinary();
    args   = new ArrayList<>();
    args.add(binary);
    if (getVerbose())
      args.add("-v");
    if (getRecursive())
      args.add("-r");

    if (getSource() == null)
      throw new IllegalStateException("No source defined!");
    args.add(getSource());

    if (getDestination() == null)
      throw new IllegalStateException("No destination defined!");
    args.add(getDestination());

    if (m_OutputCommandline)
      System.out.println("Command-line: " + Utils.flatten(args, " "));

    builder = new ProcessBuilder();
    builder.directory(new File(binary).getParentFile());
    builder.command(args);

    return new ProcessResult(args.toArray(new String[args.size()]), null, null, builder.start());
  }

  /**
   * Sets the commandline options.
   *
   * @param options	the options to use
   * @return		true if successful
   * @throws Exception	in case of an invalid option
   */
  public boolean setOptions(String[] options) throws Exception {
    ArgumentParser 	parser;
    Namespace 		ns;

    parser = ArgumentParsers.newArgumentParser(RSync.class.getName());
    parser.addArgument("src")
      .help("The local or remote source path (path or [user@]host:path)");
    parser.addArgument("dest")
      .help("The local or remote destination path (path or [user@]host:path)");
    parser.addArgument("-v", "--verbose")
      .dest("verbose")
      .help("increase verbosity")
      .action(Arguments.storeTrue());
    parser.addArgument("-r", "--recursive")
      .dest("recursive")
      .help("recurse into directories")
      .action(Arguments.storeTrue());
    parser.addArgument("--output-commandline")
      .dest("outputCommandline")
      .help("output the command-line used")
      .action(Arguments.storeTrue());
    try {
      ns = parser.parseArgs(options);
    }
    catch (ArgumentParserException e) {
      parser.handleError(e);
      return false;
    }

    setVerbose(ns.getBoolean("verbose"));
    setRecursive(ns.getBoolean("recursive"));
    setOutputCommandline(ns.get("outputCommandline"));
    setSource(ns.getString("src"));
    setDestination(ns.getString("dest"));

    return true;
  }

  /**
   * For testing.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Exception {
    RSync 		rsync;
    ProcessResult 	result;

    rsync = new RSync();
    if (rsync.setOptions(args)) {
      result = rsync.execute();
      System.out.println(result.getStdOut());
      System.out.println("Exit code: " + result.getExitCode());
      if (result.getExitCode() > 0)
	System.err.println(result.getStdErr());
    }
    else {
      System.exit(1);
    }
  }
}
