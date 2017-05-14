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
 * AbstractProcessReader.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ancestor for readers that read line from stdout/stderr of the provided
 * {@link Process} object.
 *
 * @author fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision: 6502 $
 */
public abstract class AbstractProcessReader
  implements Runnable {

  /** the process to read from. */
  protected Process m_Process;

  /** whether to use stdout or stderr. */
  protected boolean m_Stdout;

  /**
   * Initializes the reader.
   *
   * @param process	the process to monitor
   * @param stdout	whether to read stdout or stderr
   */
  public AbstractProcessReader(Process process, boolean stdout) {
    m_Process = process;
    m_Stdout = stdout;
  }

  /**
   * Returns whether the reader is for stdout or stderr.
   *
   * @return		true if for stdout
   */
  public boolean isStdout() {
    return m_Stdout;
  }

  /**
   * Returns the underlying {@link Process} object.
   *
   * @return		the process object
   */
  public Process getProcess() {
    return m_Process;
  }

  /**
   * For processing the line read from stdout/stderr.
   *
   * @param line	the output line
   */
  protected abstract void process(String line);

  /**
   * Reads the data from the process.
   */
  @Override
  public void run() {
    String 		line;
    BufferedReader reader;

    try {
      if (m_Stdout)
	reader = new BufferedReader(new InputStreamReader(m_Process.getInputStream()), 1024);
      else
	reader = new BufferedReader(new InputStreamReader(m_Process.getErrorStream()), 1024);

      while ((line = reader.readLine()) != null)
	process(line);
    }
    catch (Exception e) {
      System.err.println("Failed to read from " + (m_Stdout ? "stdout" : "stderr") + " for process #" + m_Process.hashCode() + ":");
      e.printStackTrace();
    }
  }
}
