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
 * Binaries.java
 * Copyright (C) 2017 University of Waikato, Hamilton, New Zealand
 */

package com.github.fracpete.rsync4j;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Helper class for dealing with the rsync binaries.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class Binaries {

  /** the resource prefix. */
  public final static String RESOURCE_DIR = "com/github/fracpete/rsync4j/";

  /** the sub-directory for the linux binary. */
  public final static String LINUX_DIR = "linux-x86_64/";

  /** the sub-directory for the windows binaries. */
  public final static String WINDOWS_DIR = "windows-x86_64/";

  /**
   * Copies the specified resource to the tmp directory.
   *
   * @param dir		the resource directory to use
   * @param name	the name of the resource
   * @return		the full path
   */
  public static String copyResourceToTmp(String dir, String name) throws Exception {
    String			result;
    String			resource;
    InputStream 		is;
    BufferedInputStream 	bis;
    File 			tmp;
    FileOutputStream 		fos;
    BufferedOutputStream 	bos;

    result = null;
    is     = null;
    bis    = null;
    fos    = null;
    bos    = null;

    try {
      resource = dir;
      if (!resource.endsWith("/"))
	resource += "/";
      resource += name;
      is  = ClassLoader.getSystemResourceAsStream(resource);
      bis = new BufferedInputStream(is);
      tmp = new File(System.getProperty("java.io.tmpdir") + File.separator + name);
      tmp.deleteOnExit();
      fos = new FileOutputStream(tmp);
      bos = new BufferedOutputStream(fos);
      IOUtils.copy(bis, bos);
      result = tmp.getAbsolutePath();
    }
    catch (Exception e) {
      throw e;
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
   * Extracts the binary to the temp directory and returns the name of the
   * binary.
   *
   * @return		the filename of the binary
   * @throws Exception	if extraction fails
   */
  public static String extractBinary() throws Exception {
    String	result;

    result = null;

    try {
      if (SystemUtils.IS_OS_LINUX) {
	result = copyResourceToTmp(RESOURCE_DIR + LINUX_DIR, "rsync");
	Files.setPosixFilePermissions(
	  new File(result).toPath(),
	  new HashSet<>(Arrays.asList(PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_EXECUTE)));
      }
      else if (SystemUtils.IS_OS_WINDOWS) {
	copyResourceToTmp(RESOURCE_DIR + WINDOWS_DIR, "cygiconv-2.dll");
	copyResourceToTmp(RESOURCE_DIR + WINDOWS_DIR, "cygwin1.dll");
	result = copyResourceToTmp(RESOURCE_DIR + WINDOWS_DIR, "rsync.exe");
      }
      /*
      else if (SystemUtils.IS_OS_MAC_OSX) {
        // TODO
      }
      */
      else {
	throw new IllegalStateException(
	  "Unsupported operating system: "
	    + SystemUtils.OS_NAME + "/" + SystemUtils.OS_ARCH + "/" + SystemUtils.OS_VERSION);
      }
    }
    catch (Exception e) {
      throw e;
    }

    return result;
  }
}
