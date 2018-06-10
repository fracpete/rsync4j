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
 * AbstractBinary.java
 * Copyright (C) 2017-2018 University of Waikato, Hamilton, New Zealand
 */
package com.github.fracpete.rsync4j.core;

import com.github.fracpete.processoutput4j.output.CollectingProcessOutput;
import com.github.fracpete.processoutput4j.output.ConsoleOutputProcessOutput;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.List;
import java.util.logging.Logger;

/**
 * Ancestor of wrappers for binaries.
 *
 * @author  fracpete (fracpete at gmail dot com)
 */
public abstract class AbstractBinary {

  /** for logging. */
  protected Logger logger = Logger.getLogger(getClass().getName());

  /** whether to output the commandline. */
  protected boolean outputCommandline;

  /**
   * Initializes the object.
   */
  public AbstractBinary() {
    reset();
  }

  /**
   * Resets the members.
   */
  public void reset() {
    outputCommandline = false;
  }

  /**
   * Sets output commandline flag.
   *
   * @param value	true if to output commandline
   * @return		itself
   */
  public AbstractBinary outputCommandline(boolean value) {
    outputCommandline = value;
    return this;
  }

  /**
   * Returns output commandline flag.
   *
   * @return		true if to output commandline
   */
  public boolean getOutputCommandline() {
    return outputCommandline;
  }

  /**
   * Assembles the arguments for the rsync binary.
   *
   * @return		the options
   * @throws Exception	if failed to determine binary
   */
  public abstract List<String> options() throws Exception;

  /**
   * Assembles the full command-line arguments.
   *
   * @return		the command-line arguments
   * @throws Exception	if failed to determine binary
   * @see		#options()
   */
  public abstract List<String> commandLineArgs() throws Exception;

  /**
   * Returns a configured {@link ProcessBuilder} to be used for executing
   * the rsync process.
   *
   * @return		the configured process builder
   * @throws Exception	if execution fails or failed to determine binary
   * @see		#commandLineArgs()
   */
  public ProcessBuilder builder() throws Exception {
    ProcessBuilder	builder;
    List<String>	args;

    args = commandLineArgs();

    if (getOutputCommandline())
      logger.info("Command-line: " + Utils.flatten(args, " "));

    builder = new ProcessBuilder();
    builder.command(args);

    return builder;
  }

  /**
   * Starts the rsync process for the platform.
   * <br>
   * If you are not interested in an incremental progress output, then
   * you can also use {@link #execute()}, which waits for the process to
   * finish while collecting stdout and stderr output.
   *
   * @return		the process object
   * @throws Exception	if execution fails or failed to determine binary
   * @see		#builder()
   */
  public Process start() throws Exception {
    return builder().start();
  }

  /**
   * Executes the rsync binary for the platform and waits for its completion.
   * Collects stdout and stderr output in the result.
   * <br>
   * If you want an incremental output, you can use {@link #start()} and
   * monitor the output yourself.
   *
   * @return		the process result object
   * @throws Exception	if execution fails or failed to determine binary
   * @see		#commandLineArgs()
   */
  public CollectingProcessOutput execute() throws Exception {
    CollectingProcessOutput	result;

    result = new CollectingProcessOutput();
    result.monitor(builder());

    return result;
  }

  /**
   * Returns a short description for the binary.
   *
   * @return		the description
   */
  protected abstract String description();

  /**
   * Configures and returns the commandline parser.
   *
   * @return		the parser
   */
  protected ArgumentParser getParser() {
    ArgumentParser 	parser;

    parser = ArgumentParsers.newArgumentParser(getClass().getName());
    parser.description(description());
    parser.addArgument("--output-commandline")
      .setDefault(false)
      .dest("outputCommandline")
      .help("output the command-line generated for the wrapped binary")
      .action(Arguments.storeTrue());

    return parser;
  }

  /**
   * Sets the parsed options.
   *
   * @param ns		the parsed options
   * @return		if successfully set
   */
  protected boolean setOptions(Namespace ns) {
    outputCommandline(ns.get("outputCommandline"));
    return true;
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

    parser = getParser();
    try {
      ns = parser.parseArgs(options);
    }
    catch (ArgumentParserException e) {
      parser.handleError(e);
      return false;
    }

    return setOptions(ns);
  }

  /**
   * Runs the binary with the arguments.
   *
   * @param args	the arguments
   */
  public static void run(AbstractBinary binary, String[] args) throws Exception {
    ConsoleOutputProcessOutput	output;

    if (binary.setOptions(args)) {
      output = new ConsoleOutputProcessOutput();
      output.monitor(binary.builder());
    }
    else {
      System.exit(1);
    }
  }
}
