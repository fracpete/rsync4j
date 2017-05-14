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
 * CollectingProcessReader.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j.process;

/**
 * Reader for storing all content.
 *
 * @author fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision: 6502 $
 */
public class CollectingProcessReader
  extends AbstractProcessReader {

  /** the string builder to store the data in. */
  protected StringBuilder m_Content;

  /**
   * Initializes the reader.
   *
   * @param process	the process to monitor
   * @param stdout  	whether to read stdout or stderr
   * @param content	for storing the content
   */
  public CollectingProcessReader(Process process, boolean stdout, StringBuilder content) {
    super(process, stdout);
    m_Content = content;
  }

  /**
   * Returns the string builder for storing the content.
   *
   * @return		the string builder
   */
  public StringBuilder getContent() {
    return m_Content;
  }

  /**
   * For processing the line read from stdout/stderr.
   *
   * @param line	the output line
   */
  @Override
  protected void process(String line) {
    m_Content.append(line);
    m_Content.append('\n');
  }
}
