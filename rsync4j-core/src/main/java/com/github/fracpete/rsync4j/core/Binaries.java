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
 * Binaries.java
 * Copyright (C) 2017-2021 University of Waikato, Hamilton, New Zealand
 */

package com.github.fracpete.rsync4j.core;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper class for dealing with the rsync binaries.
 * On Linux and OSX, rsync and ssh must be present.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class Binaries {

  /** the resource prefix. */
  public final static String RESOURCE_DIR = "com/github/fracpete/rsync4j/";

  /** the sub-directory for the windows 32bit binaries. */
  public final static String WINDOWS_DIR_32 = "windows32/";

  /** the sub-directory for the windows 64bit binaries. */
  public final static String WINDOWS_DIR_64 = "windows64/";

  /** the windows environment variable for the rsyncj4 home directory. */
  public final static String WINDOWS_HOME_DIR = "RSYNC4J_HOME";

  public static final String LIBRARIES = "libraries.txt";

  /** for storing any previously extract binary. */
  protected static Boolean binariesExtracted;

  /** the rsync binary. */
  protected static String rsyncBinary;

  /** the ssh binary. */
  protected static String sshBinary;

  /** the ssh-keygen binary. */
  protected static String sshkeygenBinary;

  /** for logging. */
  protected static Logger LOGGER = Logger.getLogger(Binaries.class.getName());

  /**
   * Returns the "bitness", ie 32 or 64 bit of the underlying OS.
   *
   * @return		the number of bits
   */
  public synchronized static int getBitness() {
    String	arch;

    arch = System.getProperty("os.arch");
    if (arch.endsWith("86"))
      return 32;
    else if (arch.endsWith("64"))
      return 64;
    else
      throw new IllegalStateException("Cannot interpret 'os.arch' for bitness: " + arch);
  }

  /**
   * Copies the specified resource to the output directory.
   *
   * @param inDir	the resource directory to use
   * @param name	the name of the resource
   * @param outDir	the output directory
   * @return		the full path
   */
  protected static String copyResourceTo(String inDir, String name, String outDir) throws Exception {
    String			result;
    String			resource;
    InputStream 		is;
    BufferedInputStream 	bis;
    String			outFull;
    File 			out;
    FileOutputStream 		fos;
    BufferedOutputStream 	bos;

    result = null;
    is     = null;
    bis    = null;
    fos    = null;
    bos    = null;

    try {
      resource = inDir;
      if (!resource.endsWith("/"))
	resource += "/";
      resource += name;
      outFull = outDir + File.separator + name;
      LOGGER.info("Copying resource '" + resource + "' to '" + outFull + "'");
      is  = Binaries.class.getClassLoader().getResourceAsStream(resource);
      bis = new BufferedInputStream(is);
      out = new File(outFull);
      fos = new FileOutputStream(out);
      bos = new BufferedOutputStream(fos);
      IOUtils.copy(bis, bos);
      result = out.getAbsolutePath();
    }
    catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Copying failed!", e);
      throw e;
    }
    finally {
      IOUtils.closeQuietly(bis, null);
      IOUtils.closeQuietly(is, null);
      IOUtils.closeQuietly(bos, null);
      IOUtils.closeQuietly(fos, null);
    }

    return result;
  }

  /**
   * Returns the home directory to use for rsync4j.
   * On Windows, use the {@link #WINDOWS_HOME_DIR} environment variable
   * to point it to a custom location.
   *
   * @return		the directory
   */
  protected static String homeDir() {
    String	result;
    File	dir;

    result = System.getProperty("user.home") + File.separator + "rsync4j";

    if (SystemUtils.IS_OS_WINDOWS) {
      if (System.getenv(WINDOWS_HOME_DIR) != null) {
        dir = new File(System.getenv(WINDOWS_HOME_DIR));
        if (!dir.exists() || dir.isDirectory())
          result = dir.getAbsolutePath();
      }
    }

    return result;
  }

  /**
   * Returns the sub-directory for the Windows binaries, depending on the
   * bitness.
   *
   * @return		the sub-directory of the binaries
   */
  protected static String getWindowsDir() {
    if (getBitness() == 32)
      return WINDOWS_DIR_32;
    else
      return WINDOWS_DIR_64;
  }

  /**
   * Returns the list of libraries to copy.
   *
   * @return		the libraries
   * @throws Exception	if reading
   */
  protected static List<String> getLibraries() throws Exception {
    List<String>	result;
    String		resource;
    InputStream		is;
    StringBuilder	buf;
    int			c;

    result   = new ArrayList<>();
    resource = RESOURCE_DIR + getWindowsDir() + LIBRARIES;
    is       = null;
    try {
      buf = new StringBuilder();
      is = Binaries.class.getClassLoader().getResourceAsStream(resource);
      while ((c = is.read()) != -1)
	buf.append((char) c);
      result.addAll(Arrays.asList(buf.toString().split("\n")));
    }
    catch (Exception e) {
      throw new IllegalStateException("Failed to read list of libraries from: " + resource);
    }
    finally {
      IOUtils.closeQuietly(is, null);
    }

    return result;
  }

  /**
   * Extracts the binaries to the tmp directory.
   *
   * @throws Exception	if extraction fails
   */
  protected static void extractBinaries() throws Exception {
    String	homeDir;
    String	winDir;
    String	binDir;
    String	sshDir;
    File	dir;


    sshBinary    = "/usr/bin/ssh";
    rsyncBinary  = "/usr/bin/rsync";
    sshkeygenBinary = "/usr/bin/ssh-keygen";

    if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC_OSX) {
      if (!new File(rsyncBinary).exists())
	throw new IllegalStateException("rsync not installed (" + rsyncBinary + ")?");
      if (!new File(sshBinary).exists())
	throw new IllegalStateException("ssh not installed (" + sshBinary + ")?");
      if (!new File(sshkeygenBinary).exists())
	throw new IllegalStateException("ssh-keygen not installed (" + sshkeygenBinary + ")?");
    }
    else if (SystemUtils.IS_OS_WINDOWS) {
      homeDir = homeDir();
      binDir  = homeDir + File.separator + "bin";
      sshDir  = homeDir + File.separator + "home" + File.separator + System.getProperty("user.name") + File.separator + ".ssh";
      if (!new File(binDir + File.separator + "rsync.exe").exists()) {
	LOGGER.info("Setting up rsync4j environment in '" + homeDir + "'...");
	dir = new File(binDir);
	if (!dir.exists()) {
	  LOGGER.info("Creating directory: " + dir);
	  if (!dir.mkdirs())
	    throw new IllegalStateException("Failed to create directory: " + dir);
	}
	dir = new File(sshDir);
	if (!dir.exists()) {
	  LOGGER.info("Creating directory: " + dir);
	  if (!dir.mkdirs())
	    throw new IllegalStateException("Failed to create directory: " + dir);
	}
	LOGGER.info("Copy your public key pairs into: " + dir);
	winDir = getWindowsDir();
	for (String lib: getLibraries())
	  copyResourceTo(RESOURCE_DIR + winDir, lib, binDir);
	sshBinary    = copyResourceTo(RESOURCE_DIR + winDir, "ssh.exe", binDir);
	rsyncBinary  = copyResourceTo(RESOURCE_DIR + winDir, "rsync.exe", binDir);
	sshkeygenBinary = copyResourceTo(RESOURCE_DIR + winDir, "ssh-keygen.exe", binDir);
      }
      else {
	sshBinary    = binDir + File.separator + "ssh.exe";
	rsyncBinary  = binDir + File.separator + "rsync.exe";
	sshkeygenBinary = binDir + File.separator + "ssh-keygen.exe";
      }
    }
    else {
      throw new IllegalStateException(
	"Unsupported operating system: "
	  + SystemUtils.OS_NAME + "/" + SystemUtils.OS_ARCH + "/" + SystemUtils.OS_VERSION);
    }

    binariesExtracted = true;
  }

  /**
   * Returns the rsync binary (if necessary extracts the binaries to the temp directory).
   *
   * @return		the filename of the binary
   * @throws Exception	if extraction fails
   */
  public static String rsyncBinary() throws Exception {
    if (binariesExtracted == null)
      extractBinaries();
    return rsyncBinary;
  }

  /**
   * Returns the ssh binary (if necessary extracts the binaries to the temp directory).
   *
   * @return		the filename of the binary
   * @throws Exception	if extraction fails
   */
  public static String sshBinary() throws Exception {
    if (binariesExtracted == null)
      extractBinaries();
    return sshBinary;
  }

  /**
   * Returns the ssh-keygen binary (if necessary extracts the binaries to the temp directory).
   *
   * @return		the filename of the binary
   * @throws Exception	if extraction fails
   */
  public static String sshkeygenBinary() throws Exception {
    if (binariesExtracted == null)
      extractBinaries();
    return sshkeygenBinary;
  }

  /**
   * Converts the path into cygwin notation on Windows platform.
   *
   * @param path	the path to convert
   * @return		the (potentially) converted path
   */
  public static String convertPath(String path) {
    String result;

    result = path;

    if (SystemUtils.IS_OS_WINDOWS) {
      result = result.replace("\\", "/");
      if (result.matches("^[a-zA-Z]:.*"))
	result = "/cygdrive/" + result.substring(0, 1).toLowerCase() + "/" + result.substring(2);
    }

    return result;
  }
}
