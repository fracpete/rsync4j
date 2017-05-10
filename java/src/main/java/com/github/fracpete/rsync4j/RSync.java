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
    m_Source      = null;
    m_Destination = null;
    m_Recursive   = false;
  }

  /**
   * Sets the source path/url.
   *
   * @param value	the source
   */
  public RSync setSource(String value) {
    m_Source = value;
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
    m_Destination = value;
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
   * Executes the rsync binary for the platform.
   *
   * @return		the process object
   * @throws Exception	if execution fails
   */
  public Process execute() throws Exception {
    ProcessBuilder	builder;
    List<String>	args;

    args = new ArrayList<>();
    args.add(Binaries.extractBinary());
    if (getRecursive())
      args.add("-r");

    if (getSource() == null)
      throw new IllegalStateException("No source defined!");
    args.add(getSource());

    if (getDestination() == null)
      throw new IllegalStateException("No destination defined!");
    args.add(getDestination());

    builder = new ProcessBuilder();
    builder.command(args);

    return builder.start();
  }

  /**
   * For testing.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Throwable {
    ArgumentParser 	parser;
    Namespace 		ns;
    RSync 		rsync;
    Process		proc;

    parser = ArgumentParsers.newArgumentParser(RSync.class.getName());
    parser.addArgument("src")
      .help("The local or remote source path (path or [user@]host:path)");
    parser.addArgument("dest")
      .help("The local or remote destination path (path or [user@]host:path)");
    parser.addArgument("-r", "--recursive")
      .dest("recursive")
      .help("recurse into directories")
      .action(Arguments.storeTrue());
    ns = null;
    try {
      ns = parser.parseArgs(args);
    }
    catch (ArgumentParserException e) {
      parser.handleError(e);
      System.exit(1);
    }

    rsync = new RSync();
    rsync.setRecursive(ns.getBoolean("recursive"));
    rsync.setSource(ns.getString("src"));
    rsync.setDestination(ns.getString("dest"));
    proc = rsync.execute();
    System.out.println("Exit code: " + proc.waitFor());
  }
}
