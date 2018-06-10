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
 * Utils.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j.core;

import java.util.List;

/**
 * Various helper methods.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class Utils {

  /**
   * Flattens the list.
   *
   * @param parts	the list to flatten
   * @param sep		the separator to use
   * @return		the flattened array
   */
  public static String flatten(List parts, String sep) {
    Object[]	array;
    int		i;

    array = new Object[parts.size()];
    for (i = 0; i < parts.size(); i++)
      array[i] = parts.get(i);

    return flatten(array, sep);
  }

  /**
   * Flattens the array.
   *
   * @param parts	the array to flatten
   * @param sep		the separator to use
   * @return		the flattened array
   */
  public static String flatten(Object[] parts, String sep) {
    StringBuilder	result;
    int			i;

    result = new StringBuilder();
    for (i = 0; i < parts.length; i++) {
      if (i > 0)
	result.append(sep);
      result.append(parts[i].toString());
    }

    return result.toString();
  }
}
