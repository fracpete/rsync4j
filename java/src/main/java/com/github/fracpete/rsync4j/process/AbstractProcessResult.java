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
 * ProcessResult.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j.process;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Serializable;

/**
 * A container class for the results obtained from executing a process.
 *
 * @author fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision: 6502 $
 */
public abstract class AbstractProcessResult
  implements Serializable {

  /** for serialization. */
  private static final long serialVersionUID = 1902809285333524039L;

  /** the command. */
  protected String[] m_Command;

  /** the environment variables. */
  protected String[] m_Environment;

  /** the exit code. */
  protected int m_ExitCode;

  /**
   * Initializes the container.
   *
   * @param cmd		the command that was used
   * @param env		the environment
   * @param input	the input to be written to the process, can be null
   * @param process	the process to obtain the results from
   * @throws Exception	if collection of data fails
   */
  public AbstractProcessResult(String cmd, String[] env, String input, Process process) throws Exception {
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
  public AbstractProcessResult(String[] cmd, String[] env, String input, Process process) throws Exception {
    initialize();

    m_Command     = cmd;
    m_Environment = env;

    monitor(input, process);
  }

  /**
   * For initializing the members.
   */
  protected void initialize() {
  }

  /**
   * Performs the actual process monitoring.
   *
   * @param input	the input to be written to the process via stdin, ignored if null
   * @param process 	the process to monitor
   * @throws Exception	if writing to stdin fails
   */
  protected void monitor(String input, Process process) throws Exception {
    // stderr
    Thread threade = new Thread(configureStdErr(process));
    threade.start();

    // stdout
    Thread threado = new Thread(configureStdOut(process));
    threado.start();

    // writing the input to the standard input of the process
    if (input != null) {
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
	process.getOutputStream()));
      writer.write(input);
      writer.close();
    }

    m_ExitCode    = process.waitFor();

    // wait for threads to finish
    while (threade.isAlive() || threado.isAlive()) {
      try {
	synchronized (this) {
	  wait(100);
	}
      }
      catch (Exception e) {
	// ignored
      }
    }
  }

  /**
   * Configures the thread for stderr.
   *
   * @param process 	the process to monitor
   * @return		the configured thread, not yet started
   */
  protected abstract Thread configureStdErr(Process process);

  /**
   * Configures the thread for stdout.
   *
   * @param process 	the process to monitor
   * @return		the configured thread, not yet started
   */
  protected abstract Thread configureStdOut(Process process);

  /**
   * Returns the command that was used for the process.
   *
   * @return the command
   */
  public String[] getCommand() {
    return m_Command;
  }

  /**
   * Returns the environment.
   *
   * @return the environment, null if process inherited current one
   */
  public String[] getEnvironment() {
    return m_Environment;
  }

  /**
   * Returns whether the process has succeeded.
   *
   * @return true if succeeded, i.e., exit code = 0
   */
  public boolean hasSucceeded() {
    return (m_ExitCode == 0);
  }

  /**
   * Returns the exit code.
   *
   * @return the exit code
   */
  public int getExitCode() {
    return m_ExitCode;
  }

  /**
   * Returns a short description string.
   *
   * @return the description
   */
  @Override
  public String toString() {
    return "exit code=" + m_ExitCode;
  }
}
