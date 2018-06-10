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
 * Ssh.java
 * Copyright (C) 2018 University of Waikato, Hamilton, NZ
 */

package com.github.fracpete.rsync4j;

import com.github.fracpete.rsync4j.core.AbstractBinaryWithTimeout;
import com.github.fracpete.rsync4j.core.Binaries;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.FeatureControl;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wrapper for the ssh binary.
 * <br>
 * NB: No interactive shell possible.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class Ssh
  extends AbstractBinaryWithTimeout {

  protected boolean version1;

  protected boolean version2;

  protected boolean ipv4;

  protected boolean ipv6;

  protected Boolean forwardAgent;

  protected String bindAddress;

  protected boolean compression;

  protected String cipherSpec;

  protected String dynamicBindAddress;

  protected String logFile;

  protected String escapeChar;

  protected String configFile;

  protected boolean background;

  protected boolean printConfig;

  protected boolean allowRemoteConnect;

  protected String pkcs11;

  protected String identifyFile;

  protected Boolean gssapi;

  protected String local;

  protected String loginName;

  protected boolean masterMode;

  protected String macSpec;

  protected boolean noRemoteExecute;

  protected boolean fromNull;

  protected String controlCommand;

  protected List<String> option;

  protected int port;

  protected String queryOption;

  protected boolean quiet;

  protected String remote;

  protected String controlSocket;

  protected boolean subsystem;

  protected Boolean terminal;

  protected boolean version;

  protected int verbose;

  protected String forwardTo;

  protected String forwardTunnel;

  protected Boolean x11;

  protected boolean trustedX11;

  protected boolean syslog;

  protected String hostname;

  protected String command;

  /**
   * Resets the members.
   */
  @Override
  public void reset() {
    super.reset();
    version1 = false;
    version2 = false;
    ipv4 = false;
    ipv6 = false;
    forwardAgent = null;
    bindAddress = "";
    compression = false;
    cipherSpec = "";
    dynamicBindAddress = "";
    logFile = "";
    escapeChar = "";
    configFile = "";
    background = false;
    printConfig = false;
    allowRemoteConnect = false;
    pkcs11 = "";
    identifyFile = "";
    gssapi = null;
    local = "";
    loginName = "";
    masterMode = false;
    macSpec = "";
    noRemoteExecute = false;
    fromNull = false;
    controlCommand = "";
    option = new ArrayList<>();
    port = -1;
    queryOption = "";
    quiet = false;
    remote = "";
    controlSocket = "";
    subsystem = false;
    terminal = null;
    version = false;
    verbose = 0;
    forwardTo = "";
    forwardTunnel = "";
    x11 = null;
    trustedX11 = false;
    syslog = false;
    hostname = "";
    command = "";
  }

  /**
   * Sets output commandline flag.
   *
   * @param value	true if to output commandline
   * @return		itself
   */
  public Ssh outputCommandline(boolean value) {
    return (Ssh) super.outputCommandline(value);
  }

  public Ssh version1(boolean value) {
    version1 = value;
    return this;
  }

  public boolean getVersion1() {
    return version1;
  }

  public Ssh version2(boolean value) {
    version2 = value;
    return this;
  }

  public boolean getVersion2() {
    return version2;
  }

  public Ssh ipv4(boolean value) {
    ipv4 = value;
    return this;
  }

  public boolean getIpv4() {
    return ipv4;
  }

  public Ssh ipv6(boolean value) {
    ipv6 = value;
    return this;
  }

  public boolean getIpv6() {
    return ipv6;
  }

  /**
   * Use null to set it to user/system default. Other true/false to turn
   * on/off.
   *
   * @param value the value, null for default
   * @return itself
   */
  public Ssh forwardAgent(Boolean value) {
    forwardAgent = value;
    return this;
  }

  public Boolean getForwardAgent() {
    return forwardAgent;
  }

  public Ssh bindAddress(String value) {
    bindAddress = value;
    return this;
  }

  public String getBindAddress() {
    return bindAddress;
  }

  public Ssh compression(boolean value) {
    compression = value;
    return this;
  }

  public boolean getCompression() {
    return compression;
  }

  public Ssh cipherSpec(String value) {
    cipherSpec = value;
    return this;
  }

  public String getCipherSpec() {
    return cipherSpec;
  }

  public Ssh dynamicBindAddress(String value) {
    dynamicBindAddress = value;
    return this;
  }

  public String getDynamicBindAddress() {
    return dynamicBindAddress;
  }

  public Ssh logFile(String value) {
    logFile = value;
    return this;
  }

  public String getLogFile() {
    return logFile;
  }

  public Ssh escapeChar(String value) {
    escapeChar = value;
    return this;
  }

  public String getEscapeChar() {
    return escapeChar;
  }

  public Ssh configFile(String value) {
    configFile = value;
    return this;
  }

  public String getConfigFile() {
    return configFile;
  }

  public Ssh background(boolean value) {
    background = value;
    return this;
  }

  public boolean getBackground() {
    return background;
  }

  public Ssh printConfig(boolean value) {
    printConfig = value;
    return this;
  }

  public boolean getPrintConfig() {
    return printConfig;
  }

  public Ssh allowRemoteConnect(boolean value) {
    allowRemoteConnect = value;
    return this;
  }

  public boolean getAllowRemoteConnect() {
    return allowRemoteConnect;
  }

  public Ssh pkcs11(String value) {
    pkcs11 = value;
    return this;
  }

  public String getPkcs11() {
    return pkcs11;
  }

  public Ssh identifyFile(String value) {
    identifyFile = value;
    return this;
  }

  public String getIdentifyFile() {
    return identifyFile;
  }

  /**
   * Use null to set it to user/system default. Other true/false to turn
   * on/off.
   *
   * @param value the value, null for default
   * @return itself
   */
  public Ssh gssapi(Boolean value) {
    gssapi = value;
    return this;
  }

  public Boolean getGssapi() {
    return gssapi;
  }

  public Ssh local(String value) {
    local = value;
    return this;
  }

  public String getLocal() {
    return local;
  }

  public Ssh loginName(String value) {
    loginName = value;
    return this;
  }

  public String getLoginName() {
    return loginName;
  }

  public Ssh masterMode(boolean value) {
    masterMode = value;
    return this;
  }

  public boolean getMasterMode() {
    return masterMode;
  }

  public Ssh macSpec(String value) {
    macSpec = value;
    return this;
  }

  public String getMacSpec() {
    return macSpec;
  }

  public Ssh noRemoteExecute(boolean value) {
    noRemoteExecute = value;
    return this;
  }

  public boolean getNoRemoteExecute() {
    return noRemoteExecute;
  }

  public Ssh fromNull(boolean value) {
    fromNull = value;
    return this;
  }

  public boolean getFromNull() {
    return fromNull;
  }

  public Ssh controlCommand(String value) {
    controlCommand = value;
    return this;
  }

  public String getControlCommand() {
    return controlCommand;
  }

  public Ssh option(String... value) {
    option = new ArrayList<>(Arrays.asList(value));
    return this;
  }

  public Ssh option(List<String> value) {
    option = new ArrayList<>(value);
    return this;
  }

  public List<String> getOption() {
    return option;
  }

  public Ssh port(int value) {
    if ((value == -1) || ((value > 0) && (value < 65536)))
      port = value;
    return this;
  }

  public int getPort() {
    return port;
  }

  public Ssh queryOption(String value) {
    queryOption = value;
    return this;
  }

  public String getQueryOption() {
    return queryOption;
  }

  public Ssh quiet(boolean value) {
    quiet = value;
    return this;
  }

  public boolean getQuiet() {
    return quiet;
  }

  public Ssh remote(String value) {
    remote = value;
    return this;
  }

  public String getRemote() {
    return remote;
  }

  public Ssh controlSocket(String value) {
    controlSocket = value;
    return this;
  }

  public String getControlSocket() {
    return controlSocket;
  }

  public Ssh subsystem(boolean value) {
    subsystem = value;
    return this;
  }

  public boolean getSubsystem() {
    return subsystem;
  }

  /**
   * Use null to set it to user/system default. Other true/false to turn
   * on/off.
   *
   * @param value the value, null for default
   * @return itself
   */
  public Ssh terminal(Boolean value) {
    terminal = value;
    return this;
  }

  public Boolean getTerminal() {
    return terminal;
  }

  public Ssh version(boolean value) {
    version = value;
    return this;
  }

  public boolean getVersion() {
    return version;
  }

  public Ssh verbose(int value) {
    if (value >= 0)
      verbose = value;
    return this;
  }

  public int getVerbose() {
    return verbose;
  }

  public Ssh forwardTo(String value) {
    forwardTo = value;
    return this;
  }

  public String getForwardTo() {
    return forwardTo;
  }

  public Ssh forwardTunnel(String value) {
    forwardTunnel = value;
    return this;
  }

  public String getForwardTunnel() {
    return forwardTunnel;
  }

  /**
   * Use null to set it to user/system default. Other true/false to turn
   * on/off.
   *
   * @param value the value, null for default
   * @return itself
   */
  public Ssh x11(Boolean value) {
    x11 = value;
    return this;
  }

  public Boolean getX11() {
    return x11;
  }

  public Ssh trustedX11(boolean value) {
    trustedX11 = value;
    return this;
  }

  public boolean getTrustedX11() {
    return trustedX11;
  }

  public Ssh syslog(boolean value) {
    syslog = value;
    return this;
  }

  public boolean getSyslog() {
    return syslog;
  }

  public Ssh hostname(String value) {
    hostname = value;
    return this;
  }

  public String getHostname() {
    return hostname;
  }

  public Ssh command(String value) {
    command = value;
    return this;
  }

  public String getCommand() {
    return command;
  }

  /**
   * Assembles the arguments for the binary.
   *
   * @return		the options
   * @throws Exception	if failed to determine binary
   */
  @Override
  public List<String> options() throws Exception {
    List<String> 	result;

    result = new ArrayList<>();
    if (getVersion1()) result.add("-1");
    if (getVersion2()) result.add("-2");
    if (getIpv4()) result.add("-4");
    if (getIpv6()) result.add("-6");
    if (getForwardAgent() != null) {
      if (getForwardAgent())
        result.add("-A");
      else
        result.add("-a");
    }
    if (!getBindAddress().isEmpty()) {
      result.add("-b");
      result.add(getBindAddress());
    }
    if (getCompression()) result.add("-C");
    if (!getCipherSpec().isEmpty()) {
      result.add("-C");
      result.add(getCipherSpec());
    }
    if (!getDynamicBindAddress().isEmpty()) {
      result.add("-D");
      result.add(getDynamicBindAddress());
    }
    if (!getLogFile().isEmpty()) {
      result.add("-E");
      result.add(getLogFile());
    }
    if (!getEscapeChar().isEmpty()) {
      result.add("-e");
      result.add(getEscapeChar());
    }
    if (!getConfigFile().isEmpty()) {
      result.add("-F");
      result.add(getConfigFile());
    }
    if (getBackground()) result.add("-f");
    if (getPrintConfig()) result.add("-G");
    if (getAllowRemoteConnect()) result.add("-g");
    if (!getPkcs11().isEmpty()) {
      result.add("-I");
      result.add(getPkcs11());
    }
    if (!getIdentifyFile().isEmpty()) {
      result.add("-i");
      result.add(getIdentifyFile());
    }
    if (getGssapi() != null) {
      if (getGssapi())
        result.add("-K");
      else
        result.add("-k");
    }
    if (!getLocal().isEmpty()) {
      result.add("-L");
      result.add(getLocal());
    }
    if (!getLoginName().isEmpty()) {
      result.add("-l");
      result.add(getLoginName());
    }
    if (getMasterMode()) result.add("-M");
    if (!getMacSpec().isEmpty()) {
      result.add("-m");
      result.add(getMacSpec());
    }
    if (getNoRemoteExecute()) result.add("-N");
    if (getFromNull()) result.add("-n");
    if (!getControlCommand().isEmpty()) {
      result.add("-O");
      result.add(getControlCommand());
    }
    for (String o: getOption()) {
      result.add("-o");
      result.add(o);
    }
    if (getPort() > -1) {
      result.add("-p");
      result.add("" + getPort());
    }
    if (!getQueryOption().isEmpty()) {
      result.add("-Q");
      result.add(getQueryOption());
    }
    if (getQuiet()) result.add("-q");
    if (!getRemote().isEmpty()) {
      result.add("-R");
      result.add(getRemote());
    }
    if (!getControlSocket().isEmpty()) {
      result.add("-S");
      result.add(getControlSocket());
    }
    if (getSubsystem()) result.add("-s");
    if (getTerminal() != null) {
      if (getTerminal())
        result.add("-t");
      else
        result.add("-T");
    }
    if (getVersion()) result.add("-V");
    if (getVerbose() == 1) result.add("-v");
    if (getVerbose() == 2) result.add("-vv");
    if (getVerbose() == 3) result.add("-vvv");
    if (!getForwardTo().isEmpty()) {
      result.add("-W");
      result.add(getForwardTo());
    }
    if (!getForwardTunnel().isEmpty()) {
      result.add("-w");
      result.add(getForwardTunnel());
    }
    if (getX11() != null) {
      if (getX11())
        result.add("-X");
      else
        result.add("-x");
    }
    if (getTrustedX11()) result.add("-Y");
    if (getSyslog()) result.add("-y");

    result.add(getHostname());

    if (!getCommand().isEmpty()) result.add(getCommand());

    return result;
  }

  /**
   * Assembles the full command-line arguments.
   *
   * @return		the command-line arguments
   * @throws Exception	if failed to determine binary
   * @see		#options()
   */
  public List<String> commandLineArgs() throws Exception {
    List<String> 	result;
    String 		binary;

    binary = Binaries.sshBinary();
    result = options();
    result.add(0, binary);

    return result;
  }

  /**
   * Returns a short description for the binary.
   *
   * @return		the description
   */
  @Override
  protected String description() {
    return "OpenSSH SSH client (remote login program). No interactive sessions possible.\n"
      + "See man page:\n"
      + "https://linux.die.net/man/1/ssh";
  }

  /**
   * Configures and returns the commandline parser.
   *
   * @return		the parser
   */
  protected ArgumentParser getParser() {
    ArgumentParser 	parser;

    parser = super.getParser();
    parser.addArgument("-1")
      .dest("version1")
      .help("Forces ssh to try protocol version 1 only.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-2")
      .dest("version2")
      .help("Forces ssh to try protocol version 2 only.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-4")
      .dest("ipv4")
      .help("Forces ssh to use IPv4 addresses only.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-6")
      .dest("ipv6")
      .help("Forces ssh to use IPv6 addresses only.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-A")
      .dest("forwardAgent")
      .help("Enables forwarding of the authentication agent connection.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeTrue());
    parser.addArgument("-a")
      .dest("forwardAgent")
      .help("Disables forwarding of the authentication agent connection.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeFalse());
    parser.addArgument("-b")
      .dest("bindAddress")
      .help("Use bind_address on the local machine as the source address of the connection.")
      .setDefault("");
    parser.addArgument("-C")
      .dest("compression")
      .help("Requests compression of all data.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-c")
      .dest("cipherSpec")
      .help("Selects the cipher specification for encrypting the session.")
      .setDefault("");
    parser.addArgument("-D")
      .dest("dynamicBindAddress")
      .help("Specifies a local “dynamic” application-level port forwarding ([bind_address:]port).")
      .setDefault("");
    parser.addArgument("-E")
      .dest("logFile")
      .help("Append debug logs to log_file instead of standard error.")
      .setDefault("");
    parser.addArgument("-e")
      .dest("escapeChar")
      .help("Sets the escape character for sessions with a pty (default: ‘~’).")
      .setDefault('\0');
    parser.addArgument("-F")
      .dest("configFile")
      .help("Specifies an alternative per-user configuration file.")
      .setDefault("");
    parser.addArgument("-f")
      .dest("background")
      .help("Requests ssh to go to background just before command execution.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-G")
      .dest("printConfig")
      .help("Causes ssh to print its configuration after evaluating Host and Match blocks and exit.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-g")
      .dest("allowRemoteConnect")
      .help("Allows remote hosts to connect to local forwarded ports")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-I")
      .dest("pkcs11")
      .help("Specify the PKCS#11 shared library ssh should use to communicate with a PKCS#11 token providing the user's private RSA key.")
      .setDefault("");
    parser.addArgument("-K")
      .dest("gssapi")
      .help("Enables GSSAPI-based authentication and forwarding (delegation) of GSSAPI credentials to the server.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeTrue());
    parser.addArgument("-k")
      .dest("gssapi")
      .help("Disables forwarding (delegation) of GSSAPI credentials to the server.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeFalse());
    parser.addArgument("-L")
      .dest("local")
      .help("Specifies that connections to the given TCP port or Unix socket on the local (client) host are to be forwarded to the given host and port, or Unix socket, on the remote side.")
      .setDefault("");
    parser.addArgument("-l")
      .dest("loginName")
      .help("Specifies the user to log in as on the remote machine.")
      .setDefault("");
    parser.addArgument("-M")
      .dest("masterMode")
      .help("Places the ssh client into “master” mode for connection sharing.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-m")
      .dest("macSpec")
      .help("A comma-separated list of MAC (message authentication code) algorithms, specified in order of preference.")
      .setDefault("");
    parser.addArgument("-N")
      .dest("noRemoteExecute")
      .help("Do not execute a remote command. This is useful for just forwarding ports.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-n")
      .dest("fromNull")
      .help("Redirects stdin from /dev/null (actually, prevents reading from stdin).")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-O")
      .dest("controlCommand")
      .help("Control an active connection multiplexing master process.")
      .setDefault("");
    parser.addArgument("-o")
      .dest("option")
      .help("Can be used to give options in the format used in the configuration file.")
      .setDefault(new ArrayList<>());
    parser.addArgument("-p")
      .dest("port")
      .help("Port to connect to on the remote host.")
      .setDefault(-1);
    parser.addArgument("-q")
      .dest("quiet")
      .help("Quiet mode. Causes most warning and diagnostic messages to be suppressed.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-R")
      .dest("remote")
      .help("Specifies that connections to the given TCP port or Unix socket on the remote (server) host are to be forwarded to the given host and port, or Unix socket, on the local side.")
      .setDefault("");
    parser.addArgument("-s")
      .dest("subsystem")
      .help("May be used to request invocation of a subsystem on the remote system.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-T")
      .dest("terminal")
      .help("Disable pseudo-terminal allocation.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeFalse());
    parser.addArgument("-t")
      .dest("terminal")
      .help("Force pseudo-terminal allocation.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeTrue());
    parser.addArgument("-v")
      .dest("verbose")
      .help("Verbose mode.")
      .action(Arguments.storeConst())
      .setConst(1)
      .setDefault(0);
    parser.addArgument("-vv")
      .dest("verbose")
      .help("Very verbose mode.")
      .action(Arguments.storeConst())
      .setConst(2)
      .setDefault(0);
    parser.addArgument("-vvv")
      .dest("verbose")
      .help("Very, very verbose mode.")
      .action(Arguments.storeConst())
      .setConst(3)
      .setDefault(0);
    parser.addArgument("-W")
      .dest("forwardTo")
      .help("Requests that standard input and output on the client be forwarded to host on port over the secure channel.")
      .setDefault("");
    parser.addArgument("-w")
      .dest("forwardTunnel")
      .help("Requests tunnel device forwarding with the specified tun(4) devices between the client (local_tun) and the server (remote_tun).")
      .setDefault("");
    parser.addArgument("-X")
      .dest("x11")
      .help("Enables X11 forwarding.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeTrue());
    parser.addArgument("-x")
      .dest("x11")
      .help("Disables X11 forwarding.")
      .setDefault(FeatureControl.SUPPRESS)
      .action(Arguments.storeFalse());
    parser.addArgument("-Y")
      .dest("trustedX11")
      .help("Enables trusted X11 forwarding.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("-y")
      .dest("syslog")
      .help("Send log information using the syslog system module.")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("")
      .dest("hostname")
      .required(true)
      .help("The hostname to connect to.");
    parser.addArgument("hostname")
      .metavar("")
      .dest("hostname")
      .required(true)
      .help("The hostname to connect to.");
    parser.addArgument("command")
      .nargs("?")
      .dest("command")
      .required(false)
      .help("The remote command to execute.");

    return parser;
  }

  /**
   * Sets the parsed options.
   *
   * @param ns		the parsed options
   * @return		if successfully set
   */
  @Override
  protected boolean setOptions(Namespace ns) {
    boolean	result;

    result = super.setOptions(ns);
    if (!result)
      return false;

    verbose(ns.getInt("verbose"));
    version1(ns.getBoolean("version1"));
    version2(ns.getBoolean("version2"));
    ipv4(ns.getBoolean("ipv4"));
    ipv6(ns.getBoolean("ipv6"));
    forwardAgent(ns.getBoolean("forwardAgent"));
    bindAddress(ns.getString("bindAddress"));
    compression(ns.getBoolean("compression"));
    cipherSpec(ns.getString("cipherSpec"));
    dynamicBindAddress(ns.getString("dynamicBindAddress"));
    logFile(ns.getString("logFile"));
    escapeChar(ns.get("escapeChar"));
    configFile(ns.getString("configFile"));
    background(ns.getBoolean("background"));
    printConfig(ns.getBoolean("printConfig"));
    allowRemoteConnect(ns.getBoolean("allowRemoteConnect"));
    pkcs11(ns.getString("pkcs11"));
    identifyFile(ns.getString("identifyFile"));
    gssapi(ns.getBoolean("gssapi"));
    local(ns.getString("local"));
    loginName(ns.getString("loginName"));
    masterMode(ns.getBoolean("masterMode"));
    macSpec(ns.getString("macSpec"));
    noRemoteExecute(ns.getBoolean("noRemoteExecute"));
    fromNull(ns.getBoolean("fromNull"));
    controlCommand(ns.getString("controlCommand"));
    option(ns.getList("option"));
    port(ns.getInt("port"));
    queryOption(ns.getString("queryOption"));
    quiet(ns.getBoolean("quiet"));
    remote(ns.getString("remote"));
    controlSocket(ns.getString("controlSocket"));
    subsystem(ns.getBoolean("subsystem"));
    terminal(ns.getBoolean("terminal"));
    version(ns.getBoolean("version"));
    forwardTo(ns.getString("forwardTo"));
    forwardTunnel(ns.getString("forwardTunnel"));
    x11(ns.getBoolean("x11"));
    trustedX11(ns.getBoolean("trustedX11"));
    syslog(ns.getBoolean("syslog"));

    return true;
  }

  /**
   * For running from the command-line.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Exception {
    run(new Ssh(), args);
  }
}
