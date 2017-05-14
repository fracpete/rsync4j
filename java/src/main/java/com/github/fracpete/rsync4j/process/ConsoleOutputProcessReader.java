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
 * SimpleOutputProcessReader.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j.process;

/**
 * Just outputs the data to stdout/stderr.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class ConsoleOutputProcessReader
  extends AbstractProcessReader {

  /** the default prefix for stdout. */
  public static String PREFIX_STDOUT = "[OUT] ";

  /** the default prefix for stderr. */
  public static String PREFIX_STDERR = "[ERR] ";

  /** the prefix to use. */
  protected String m_Prefix;

  /**
   * Initializes the reader.
   *
   * @param process the process to monitor
   * @param stdout  whether to read stdout or stderr
   */
  public ConsoleOutputProcessReader(Process process, boolean stdout) {
    this(process, stdout, null);
  }

  /**
   * Initializes the reader.
   *
   * @param process 	the process to monitor
   * @param stdout  	whether to read stdout or stderr
   * @param prefix	the prefix to use, null for auto-prefix
   */
  public ConsoleOutputProcessReader(Process process, boolean stdout, String prefix) {
    super(process, stdout);
    m_Prefix = (prefix == null) ? (stdout ? PREFIX_STDOUT : PREFIX_STDERR) : prefix;
  }

  /**
   * Returns the prefix in use.
   *
   * @return		the prefix
   */
  public String getPrefix() {
    return m_Prefix;
  }

  /**
   * For processing the line read from stdout/stderr.
   *
   * @param line	the output line
   */
  @Override
  protected void process(String line) {
    if (m_Stdout)
      System.out.println(m_Prefix + line);
    else
      System.err.println(m_Prefix + line);
  }
}
