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
 * CollectingProcessResult.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j.process;

import com.github.fracpete.rsync4j.Utils;

/**
 * Collects the process output (stdout and stderr) and makes them available
 * once the process finishes.
 *
 * @author fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision: 6502 $
 */
public final class CollectingProcessResult
  extends AbstractProcessResult {

  /** for serialization. */
  private static final long serialVersionUID = 1902809285333524039L;

  /** the stdout content. */
  protected StringBuilder m_StdOut;

  /** the stderr content. */
  protected StringBuilder m_StdErr;

  /**
   * Initializes the container.
   *
   * @param cmd		the command that was used
   * @param env		the environment
   * @param input	the input to be written to the process, can be null
   * @param process	the process to obtain the results from
   * @throws Exception	if collection of data fails
   */
  public CollectingProcessResult(String cmd, String[] env, String input, Process process) throws Exception {
    this(new String[] {cmd}, env, input, process);
  }

  /**
   * Initializes the container.
   *
   * @param cmd		the command that was used
   * @param env		the environment
   * @param input	the input to be written to the process, can be null
   * @param process	the process to obtain the results from
   * @throws Exception	if collection of data fails
   */
  public CollectingProcessResult(String[] cmd, String[] env, String input, Process process) throws Exception {
    super(cmd, env, input, process);
  }

  /**
   * For initializing the members.
   */
  @Override
  protected void initialize() {
    super.initialize();
    m_StdOut = new StringBuilder();
    m_StdErr = new StringBuilder();
  }

  /**
   * Configures the thread for stderr.
   *
   * @param process 	the process to monitor
   * @return		the configured thread, not yet started
   */
  protected Thread configureStdErr(Process process) {
    return new Thread(new CollectingProcessReader(process, false, m_StdErr));
  }

  /**
   * Configures the thread for stdout.
   *
   * @param process 	the process to monitor
   * @return		the configured thread, not yet started
   */
  protected Thread configureStdOut(Process process) {
    return new Thread(new CollectingProcessReader(process, true, m_StdOut));
  }

  /**
   * Returns the output on stdout.
   *
   * @return the output
   */
  public String getStdOut() {
    return m_StdOut.toString();
  }

  /**
   * Returns the output on stderr.
   *
   * @return the output
   */
  public String getStdErr() {
    return m_StdErr.toString();
  }

  /**
   * Returns an error output based on the information stored.
   *
   * @return the error output
   */
  public String toErrorOutput() {
    StringBuilder result;

    result = new StringBuilder();

    if (m_ExitCode == 0) {
      result.append("Command succeeded!");
    }
    else {
      result.append("Command failed with exit code " + m_ExitCode + "!\n");
      result.append("--> Command:\n");
      result.append(Utils.flatten(m_Command, "\n"));
      result.append("\n\n");
      if (m_Environment != null) {
	result.append("--> Environemtn:\n");
	result.append(Utils.flatten(m_Environment, "\n"));
	result.append("\n\n");
      }
      result.append("--> Error output:\n");
      result.append(m_StdErr);
    }

    return result.toString();
  }
}
