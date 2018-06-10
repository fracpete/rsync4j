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
 * AbstractBinaryWithTimeout.java
 * Copyright (C) 2018 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j.core;

import com.github.fracpete.processoutput4j.output.CollectingProcessOutput;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;

/**
 * Ancestor for binary wrappers that have an in-built timeout for operations.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public abstract class AbstractBinaryWithTimeout
  extends AbstractBinary {

  protected int max_time;

  /**
   * Resets the members.
   */
  public void reset() {
    super.reset();
    max_time = -1;
  }

  /**
   * Returns the maximum time in seconds for the rsync process to run.
   *
   * @return the maximum in seconds, ignored if less than 1
   */
  public int getMaxTime() {
    return max_time;
  }

  /**
   * Sets the maximum time in seconds for the rsync process to run.
   *
   * @param max_time the maximum time in seconds, ignored if less than 1
   * @return itself
   */
  public AbstractBinaryWithTimeout maxTime(int max_time) {
    if (max_time < 1)
      max_time = -1;
    this.max_time = max_time;
    return this;
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
    result.setTimeOut(max_time);
    result.monitor(builder());

    return result;
  }

  /**
   * Configures and returns the commandline parser.
   *
   * @return		the parser
   */
  protected ArgumentParser getParser() {
    ArgumentParser parser;

    parser = super.getParser();
    parser.addArgument("--maxtime")
      .setDefault(-1)
      .dest("maxtime")
      .help("set the maximum time for the process to run in seconds before getting killed");

    return parser;
  }

  /**
   * Sets the parsed options.
   *
   * @param ns		the parsed options
   * @return		if successfully set
   */
  protected boolean setOptions(Namespace ns) {
    boolean result;

    result = super.setOptions(ns);
    if (!result)
      return false;

    maxTime(ns.getInt("maxtime"));

    return true;
  }
}
