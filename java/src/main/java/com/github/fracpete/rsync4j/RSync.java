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
 * Copyright (C) 2017 FracPete
 */
package com.github.fracpete.rsync4j;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Wrapper for rsync binaries.
 * 
 * @author  fracpete (fracpete at gmail dot com)
 * @version $Revision: 8361 $
 */
public class RSync {

  /** the resource prefix. */
  public final static String RESOURCE_DIR = "com/github/fracpete/rsync4j/";

  /** the sub-directory for the linux binary. */
  public final static String LINUX_DIR = "linux-x86_64/";

  /** the name of the linux binary. */
  public final static String LINUX_BINARY = "rsync";

  /**
   * Extracts the binary to the temp directory and returns the name of the
   * binary.
   *
   * @return		the filename of the binary
   * @throws Throwable	if extraction fails
   */
  public static String extractBinary() throws Throwable {
    String			result;
    String			resource;
    InputStream			is;
    BufferedInputStream		bis;
    File			tmp;
    FileOutputStream		fos;
    BufferedOutputStream	bos;

    result   = null;
    resource = RESOURCE_DIR;
    is       = null;
    bis      = null;
    fos      = null;
    bos      = null;

    try {
      if (SystemUtils.IS_OS_LINUX) {
	resource += LINUX_DIR + LINUX_BINARY;
	is = ClassLoader.getSystemResourceAsStream(resource);
	bis = new BufferedInputStream(bis);
	tmp = File.createTempFile("rsync", "");
	tmp.deleteOnExit();
	fos = new FileOutputStream(tmp);
	bos = new BufferedOutputStream(fos);
	IOUtils.copy(bis, bos);
	result = tmp.getAbsolutePath();
      }
    /*
    else if (SystemUtils.IS_OS_MAC_OSX) {
      // TODO
    }
    else if (SystemUtils.IS_OS_WINDOWS) {
      // TODO
    }
    */
      else {
	throw new IllegalStateException(
	  "Unsupported operating system: "
	    + SystemUtils.OS_NAME + "/" + SystemUtils.OS_ARCH + "/" + SystemUtils.OS_VERSION);
      }
    }
    catch (Throwable t) {
      throw t;
    }
    finally {
      IOUtils.closeQuietly(bis);
      IOUtils.closeQuietly(is);
      IOUtils.closeQuietly(bos);
      IOUtils.closeQuietly(fos);
    }

    return result;
  }

  /**
   * For testing.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Throwable {
    System.out.println(extractBinary());
  }
}
