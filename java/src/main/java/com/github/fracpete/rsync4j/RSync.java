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
 * Copyright (C) 2017 University of Waikato, Hamilton, New Zealand
 */
package com.github.fracpete.rsync4j;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for rsync binaries.
 *
 * @author  fracpete (fracpete at gmail dot com)
 * @version $Revision: 8361 $
 */
public class RSync {

  /** the source path/url. */
  protected String source;

  /** the destination path/url. */
  protected String destination;

  /** whether to output the commandline. */
  protected boolean outputCommandline;

  protected boolean verbose;

  protected String info;

  protected String debug;

  protected boolean msgs2stderr;

  protected boolean quiet;

  protected boolean no_motd;

  protected boolean checksum;

  protected boolean archive;

  protected boolean recursive;

  protected boolean relative;

  protected boolean no_implied_dirs;

  protected boolean backup;

  protected String backup_dir;

  protected String suffix;

  protected boolean update;

  protected boolean inplace;

  protected boolean append;

  protected boolean append_verify;

  protected boolean dirs;

  protected boolean links;

  protected boolean copy_links;

  protected boolean copy_unsafe_links;

  protected boolean safe_links;

  protected boolean munge_links;

  protected boolean copy_dirlinks;

  protected boolean keep_dirlinks;

  protected boolean hard_links;

  protected boolean perms;

  protected boolean executability;

  protected String chmod;

  protected boolean xattrs;

  protected boolean owner;

  protected boolean group;

  protected boolean devices;

  protected boolean specials;

  protected boolean times;

  protected boolean omit_dir_times;

  protected boolean omit_link_times;

  protected boolean super_;

  protected boolean fake_super;

  protected boolean sparse;

  protected boolean preallocate;

  protected boolean dry_run;

  protected boolean whole_file;

  protected boolean one_file_system;

  protected String block_size;

  protected String rsh;

  protected String rsync_path;

  protected boolean existing;

  protected boolean ignore_existing;

  protected boolean remove_source_files;

  protected boolean delete;

  protected boolean delete_before;

  protected boolean delete_during;

  protected boolean delete_delay;

  protected boolean delete_after;

  protected boolean delete_excluded;

  protected boolean ignore_missing_args;

  protected boolean delete_missing_args;

  protected boolean ignore_errors;

  protected boolean force;

  protected int max_delete;

  protected int max_size;

  protected int min_size;

  protected boolean partial;

  protected String partial_dir;

  protected boolean delay_updates;

  protected boolean prune_empty_dirs;

  protected boolean numeric_ids;

  protected String usermap;

  protected String groupmap;

  protected String chown;

  protected int timeout;

  protected int contimeout;

  protected boolean ignore_times;

  protected String remote_option;

  protected boolean size_only;

  protected int modify_window;

  protected String temp_dir;

  protected boolean fuzzy;

  protected String compare_dest;

  protected String copy_dest;

  protected String link_dest;

  protected boolean compress;

  protected int compress_level;

  protected String skip_compress;

  protected boolean cvs_exclude;

  protected String filter;

  protected String exclude;

  protected String exclude_from;

  protected String include;

  protected String include_from;

  protected String files_from;

  protected boolean from0;

  protected boolean protect_args;

  protected String address;

  protected int port;

  protected String sockopts;

  protected boolean blocking_io;

  protected boolean stats;

  protected boolean eight_bit_output;

  protected boolean human_readable;

  protected boolean progress;

  protected boolean itemize_changes;

  protected String out_format;

  protected String log_file;

  protected String log_file_format;

  protected String password_file;

  protected boolean list_only;

  protected int bwlimit;

  protected char outbuf;

  protected String write_batch;

  protected String only_write_batch;

  protected String read_batch;

  protected int protocol;

  protected String iconv;

  protected int checksum_seed;

  protected boolean ipv4;

  protected boolean ipv6;

  protected boolean version;

  /**
   * Initializes the object.
   */
  public RSync() {
    reset();
  }

  /**
   * Resets the members.
   */
  public void reset() {
    source = null;
    destination = null;
    outputCommandline = false;
    verbose = false;
    info = "";
    debug = "";
    msgs2stderr = false;
    quiet = false;
    no_motd = false;
    checksum = false;
    archive = false;
    recursive = false;
    relative = false;
    no_implied_dirs = false;
    backup = false;
    backup_dir = "";
    suffix = "";
    update = false;
    inplace = false;
    append = false;
    append_verify = false;
    dirs = false;
    links = false;
    copy_links = false;
    copy_unsafe_links = false;
    safe_links = false;
    munge_links = false;
    copy_dirlinks = false;
    keep_dirlinks = false;
    hard_links = false;
    perms = false;
    executability = false;
    chmod = "";
    xattrs = false;
    owner = false;
    group = false;
    devices = false;
    specials = false;
    times = false;
    omit_dir_times = false;
    omit_link_times = false;
    super_ = false;
    fake_super = false;
    sparse = false;
    preallocate = false;
    dry_run = false;
    whole_file = false;
    one_file_system = false;
    block_size = "";
    rsh = "";
    rsync_path = "";
    existing = false;
    ignore_existing = false;
    remove_source_files = false;
    delete = false;
    delete_before = false;
    delete_during = false;
    delete_delay = false;
    delete_after = false;
    delete_excluded = false;
    ignore_missing_args = false;
    delete_missing_args = false;
    ignore_errors = false;
    force = false;
    max_delete = -1;
    max_size = -1;
    min_size = -1;
    partial = false;
    partial_dir = "";
    delay_updates = false;
    prune_empty_dirs = false;
    numeric_ids = false;
    usermap = "";
    groupmap = "";
    chown = "";
    timeout = -1;
    contimeout = -1;
    ignore_times = false;
    remote_option = "";
    size_only = false;
    modify_window = -1;
    temp_dir = "";
    fuzzy = false;
    compare_dest = "";
    copy_dest = "";
    link_dest = "";
    compress = false;
    compress_level = -1;
    skip_compress = "";
    cvs_exclude = false;
    filter = "";
    exclude = "";
    exclude_from = "";
    include = "";
    include_from = "";
    files_from = "";
    from0 = false;
    protect_args = false;
    address = "";
    port = -1;
    sockopts = "";
    blocking_io = false;
    stats = false;
    eight_bit_output = false;
    human_readable = false;
    progress = false;
    progress = false;
    itemize_changes = false;
    out_format = "";
    log_file = "";
    log_file_format = "";
    password_file = "";
    list_only = false;
    bwlimit = -1;
    outbuf = '\0';
    write_batch = "";
    only_write_batch = "";
    read_batch = "";
    protocol = -1;
    iconv = "";
    checksum_seed = -1;
    ipv4 = false;
    ipv6 = false;
    version = false;
  }

  /**
   * Sets the source path/url.
   *
   * @param value	the source
   */
  public RSync setSource(String value) {
    source = value.replace("\\", "/");
    return this;
  }

  /**
   * Returns the current source path/url.
   *
   * @return		the source, null if not set
   */
  public String getSource() {
    return source;
  }

  /**
   * Sets the destination path/url.
   *
   * @param value	the destination
   * @return		itself
   */
  public RSync setDestination(String value) {
    destination = value.replace("\\", "/");
    return this;
  }

  /**
   * Returns the current destination path/url.
   *
   * @return		the destination, null if not set
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Sets output commandline flag.
   *
   * @param value	true if to output commandline
   * @return		itself
   */
  public RSync setOutputCommandline(boolean value) {
    outputCommandline = value;
    return this;
  }

  /**
   * Returns output commandline flag.
   *
   * @return		true if to output commandline
   */
  public boolean getOutputCommandline() {
    return outputCommandline;
  }

  public boolean isVerbose() {
    return verbose;
  }

  public RSync verbose(boolean verbose) {
    this.verbose = verbose;
    return this;
  }

  public String getInfo() {
    return info;
  }

  public RSync info(String info) {
    this.info = info;
    return this;
  }

  public String getDebug() {
    return debug;
  }

  public RSync debug(String debug) {
    this.debug = debug;
    return this;
  }

  public boolean isMsgs2stderr() {
    return msgs2stderr;
  }

  public RSync msgs2stderr(boolean msgs2stderr) {
    this.msgs2stderr = msgs2stderr;
    return this;
  }

  public boolean isQuiet() {
    return quiet;
  }

  public RSync quiet(boolean quiet) {
    this.quiet = quiet;
    return this;
  }

  public boolean isNoMotd() {
    return no_motd;
  }

  public RSync noMotd(boolean no_motd) {
    this.no_motd = no_motd;
    return this;
  }

  public boolean isChecksum() {
    return checksum;
  }

  public RSync checksum(boolean checksum) {
    this.checksum = checksum;
    return this;
  }

  public boolean isArchive() {
    return archive;
  }

  public RSync archive(boolean archive) {
    this.archive = archive;
    return this;
  }

  public boolean isRecursive() {
    return recursive;
  }

  public RSync recursive(boolean recursive) {
    this.recursive = recursive;
    return this;
  }

  public boolean isRelative() {
    return relative;
  }

  public RSync relative(boolean relative) {
    this.relative = relative;
    return this;
  }

  public boolean isNoImpliedDirs() {
    return no_implied_dirs;
  }

  public RSync noImpliedDirs(boolean no_implied_dirs) {
    this.no_implied_dirs = no_implied_dirs;
    return this;
  }

  public boolean isBackup() {
    return backup;
  }

  public RSync backup(boolean backup) {
    this.backup = backup;
    return this;
  }

  public String getBackupDir() {
    return backup_dir;
  }

  public RSync backupDir(String backup_dir) {
    this.backup_dir = backup_dir;
    return this;
  }

  public String getSuffix() {
    return suffix;
  }

  public RSync suffix(String suffix) {
    this.suffix = suffix;
    return this;
  }

  public boolean isUpdate() {
    return update;
  }

  public RSync update(boolean update) {
    this.update = update;
    return this;
  }

  public boolean isInplace() {
    return inplace;
  }

  public RSync inplace(boolean inplace) {
    this.inplace = inplace;
    return this;
  }

  public boolean isAppend() {
    return append;
  }

  public RSync append(boolean append) {
    this.append = append;
    return this;
  }

  public boolean isAppendVerify() {
    return append_verify;
  }

  public RSync appendVerify(boolean append_verify) {
    this.append_verify = append_verify;
    return this;
  }

  public boolean isDirs() {
    return dirs;
  }

  public RSync dirs(boolean dirs) {
    this.dirs = dirs;
    return this;
  }

  public boolean isLinks() {
    return links;
  }

  public RSync links(boolean links) {
    this.links = links;
    return this;
  }

  public boolean isCopyLinks() {
    return copy_links;
  }

  public RSync copyLinks(boolean copy_links) {
    this.copy_links = copy_links;
    return this;
  }

  public boolean isCopyUnsafeLinks() {
    return copy_unsafe_links;
  }

  public RSync copyUnsafeLinks(boolean copy_unsafe_links) {
    this.copy_unsafe_links = copy_unsafe_links;
    return this;
  }

  public boolean isSafeLinks() {
    return safe_links;
  }

  public RSync safeLinks(boolean safe_links) {
    this.safe_links = safe_links;
    return this;
  }

  public boolean isMungeLinks() {
    return munge_links;
  }

  public RSync mungeLinks(boolean munge_links) {
    this.munge_links = munge_links;
    return this;
  }

  public boolean isCopyDirlinks() {
    return copy_dirlinks;
  }

  public RSync copyDirlinks(boolean copy_dirlinks) {
    this.copy_dirlinks = copy_dirlinks;
    return this;
  }

  public boolean isKeepDirlinks() {
    return keep_dirlinks;
  }

  public RSync keepDirlinks(boolean keep_dirlinks) {
    this.keep_dirlinks = keep_dirlinks;
    return this;
  }

  public boolean isHardLinks() {
    return hard_links;
  }

  public RSync hardLinks(boolean hard_links) {
    this.hard_links = hard_links;
    return this;
  }

  public boolean isPerms() {
    return perms;
  }

  public RSync perms(boolean perms) {
    this.perms = perms;
    return this;
  }

  public boolean isExecutability() {
    return executability;
  }

  public RSync executability(boolean executability) {
    this.executability = executability;
    return this;
  }

  public String getChmod() {
    return chmod;
  }

  public RSync chmod(String chmod) {
    this.chmod = chmod;
    return this;
  }

  public boolean isXattrs() {
    return xattrs;
  }

  public RSync xattrs(boolean xattrs) {
    this.xattrs = xattrs;
    return this;
  }

  public boolean isOwner() {
    return owner;
  }

  public RSync owner(boolean owner) {
    this.owner = owner;
    return this;
  }

  public boolean isGroup() {
    return group;
  }

  public RSync group(boolean group) {
    this.group = group;
    return this;
  }

  public boolean isDevices() {
    return devices;
  }

  public RSync devices(boolean devices) {
    this.devices = devices;
    return this;
  }

  public boolean isSpecials() {
    return specials;
  }

  public RSync specials(boolean specials) {
    this.specials = specials;
    return this;
  }

  public boolean isTimes() {
    return times;
  }

  public RSync times(boolean times) {
    this.times = times;
    return this;
  }

  public boolean isOmitDirTimes() {
    return omit_dir_times;
  }

  public RSync omitDirTimes(boolean omit_dir_times) {
    this.omit_dir_times = omit_dir_times;
    return this;
  }

  public boolean isOmitLinkTimes() {
    return omit_link_times;
  }

  public RSync setOmitLinkTimes(boolean omit_link_times) {
    this.omit_link_times = omit_link_times;
    return this;
  }

  public boolean isSuper_() {
    return super_;
  }

  public RSync super_(boolean super_) {
    this.super_ = super_;
    return this;
  }

  public boolean isFakeSuper() {
    return fake_super;
  }

  public RSync fakeSuper(boolean fake_super) {
    this.fake_super = fake_super;
    return this;
  }

  public boolean isSparse() {
    return sparse;
  }

  public RSync sparse(boolean sparse) {
    this.sparse = sparse;
    return this;
  }

  public boolean isPreallocate() {
    return preallocate;
  }

  public RSync preallocate(boolean preallocate) {
    this.preallocate = preallocate;
    return this;
  }

  public boolean isDryRun() {
    return dry_run;
  }

  public RSync dryRun(boolean dry_run) {
    this.dry_run = dry_run;
    return this;
  }

  public boolean isWholeFile() {
    return whole_file;
  }

  public RSync wholeFile(boolean whole_file) {
    this.whole_file = whole_file;
    return this;
  }

  public boolean isOneFileSystem() {
    return one_file_system;
  }

  public RSync oneFileSystem(boolean one_file_system) {
    this.one_file_system = one_file_system;
    return this;
  }

  public String getBlockSize() {
    return block_size;
  }

  public RSync setBlockSize(String block_size) {
    this.block_size = block_size;
    return this;
  }

  public String getRsh() {
    return rsh;
  }

  public RSync rsh(String rsh) {
    this.rsh = rsh;
    return this;
  }

  public String getRsyncPath() {
    return rsync_path;
  }

  public RSync rsyncPath(String rsync_path) {
    this.rsync_path = rsync_path;
    return this;
  }

  public boolean isExisting() {
    return existing;
  }

  public RSync existing(boolean existing) {
    this.existing = existing;
    return this;
  }

  public boolean isIgnoreExisting() {
    return ignore_existing;
  }

  public RSync ignoreExisting(boolean ignore_existing) {
    this.ignore_existing = ignore_existing;
    return this;
  }

  public boolean isRemoveSourceFiles() {
    return remove_source_files;
  }

  public RSync removeSourceFiles(boolean remove_source_files) {
    this.remove_source_files = remove_source_files;
    return this;
  }

  public boolean isDelete() {
    return delete;
  }

  public RSync delete(boolean delete) {
    this.delete = delete;
    return this;
  }

  public boolean isDeleteBefore() {
    return delete_before;
  }

  public RSync deleteBefore(boolean delete_before) {
    this.delete_before = delete_before;
    return this;
  }

  public boolean isDeleteDuring() {
    return delete_during;
  }

  public RSync deleteDuring(boolean delete_during) {
    this.delete_during = delete_during;
    return this;
  }

  public boolean isDeleteDelay() {
    return delete_delay;
  }

  public RSync deleteDelay(boolean delete_delay) {
    this.delete_delay = delete_delay;
    return this;
  }

  public boolean isDeleteAfter() {
    return delete_after;
  }

  public RSync deleteAfter(boolean delete_after) {
    this.delete_after = delete_after;
    return this;
  }

  public boolean isDeleteExcluded() {
    return delete_excluded;
  }

  public RSync deleteExcluded(boolean delete_excluded) {
    this.delete_excluded = delete_excluded;
    return this;
  }

  public boolean isIgnoreMissingArgs() {
    return ignore_missing_args;
  }

  public RSync ignoreMissingArgs(boolean ignore_missing_args) {
    this.ignore_missing_args = ignore_missing_args;
    return this;
  }

  public boolean isDeleteMissingArgs() {
    return delete_missing_args;
  }

  public RSync deleteMissingArgs(boolean delete_missing_args) {
    this.delete_missing_args = delete_missing_args;
    return this;
  }

  public boolean isIgnoreErrors() {
    return ignore_errors;
  }

  public RSync ignoreErrors(boolean ignore_errors) {
    this.ignore_errors = ignore_errors;
    return this;
  }

  public boolean isForce() {
    return force;
  }

  public RSync force(boolean force) {
    this.force = force;
    return this;
  }

  public int getMaxDelete() {
    return max_delete;
  }

  public RSync maxDelete(int max_delete) {
    this.max_delete = max_delete;
    return this;
  }

  public int getMaxSize() {
    return max_size;
  }

  public RSync maxSize(int max_size) {
    this.max_size = max_size;
    return this;
  }

  public int getMinSize() {
    return min_size;
  }

  public RSync minSize(int min_size) {
    this.min_size = min_size;
    return this;
  }

  public boolean isPartial() {
    return partial;
  }

  public RSync partial(boolean partial) {
    this.partial = partial;
    return this;
  }

  public String getPartialDir() {
    return partial_dir;
  }

  public RSync partialDir(String partial_dir) {
    this.partial_dir = partial_dir;
    return this;
  }

  public boolean isDelayUpdates() {
    return delay_updates;
  }

  public RSync delayUpdates(boolean delay_updates) {
    this.delay_updates = delay_updates;
    return this;
  }

  public boolean isPruneEmptyDirs() {
    return prune_empty_dirs;
  }

  public RSync pruneEmptyDirs(boolean prune_empty_dirs) {
    this.prune_empty_dirs = prune_empty_dirs;
    return this;
  }

  public boolean isNumericIds() {
    return numeric_ids;
  }

  public RSync numericIds(boolean numeric_ids) {
    this.numeric_ids = numeric_ids;
    return this;
  }

  public String getUsermap() {
    return usermap;
  }

  public RSync usermap(String usermap) {
    this.usermap = usermap;
    return this;
  }

  public String getGroupmap() {
    return groupmap;
  }

  public RSync groupmap(String groupmap) {
    this.groupmap = groupmap;
    return this;
  }

  public String getChown() {
    return chown;
  }

  public RSync chown(String chown) {
    this.chown = chown;
    return this;
  }

  public int getTimeout() {
    return timeout;
  }

  public RSync timeout(int timeout) {
    this.timeout = timeout;
    return this;
  }

  public int getContimeout() {
    return contimeout;
  }

  public RSync contimeout(int contimeout) {
    this.contimeout = contimeout;
    return this;
  }

  public boolean isIgnoreTimes() {
    return ignore_times;
  }

  public RSync ignoreTimes(boolean ignore_times) {
    this.ignore_times = ignore_times;
    return this;
  }

  public String getRemoteOption() {
    return remote_option;
  }

  public RSync remoteOption(String remote_option) {
    this.remote_option = remote_option;
    return this;
  }

  public boolean isSizeOnly() {
    return size_only;
  }

  public RSync sizeOnly(boolean size_only) {
    this.size_only = size_only;
    return this;
  }

  public int getModifyWindow() {
    return modify_window;
  }

  public RSync modifyWindow(int modify_window) {
    this.modify_window = modify_window;
    return this;
  }

  public String getTempDir() {
    return temp_dir;
  }

  public RSync tempDir(String temp_dir) {
    this.temp_dir = temp_dir;
    return this;
  }

  public boolean isFuzzy() {
    return fuzzy;
  }

  public RSync fuzzy(boolean fuzzy) {
    this.fuzzy = fuzzy;
    return this;
  }

  public String getCompareDest() {
    return compare_dest;
  }

  public RSync compareDest(String compare_dest) {
    this.compare_dest = compare_dest;
    return this;
  }

  public String getCopyDest() {
    return copy_dest;
  }

  public RSync copyDest(String copy_dest) {
    this.copy_dest = copy_dest;
    return this;
  }

  public String getLinkDest() {
    return link_dest;
  }

  public RSync linkDest(String link_dest) {
    this.link_dest = link_dest;
    return this;
  }

  public boolean isCompress() {
    return compress;
  }

  public RSync compress(boolean compress) {
    this.compress = compress;
    return this;
  }

  public int getCompressLevel() {
    return compress_level;
  }

  public RSync compressLevel(int compress_level) {
    this.compress_level = compress_level;
    return this;
  }

  public String getSkipCompress() {
    return skip_compress;
  }

  public RSync skipCompress(String skip_compress) {
    this.skip_compress = skip_compress;
    return this;
  }

  public boolean isCvsExclude() {
    return cvs_exclude;
  }

  public RSync cvsExclude(boolean cvs_exclude) {
    this.cvs_exclude = cvs_exclude;
    return this;
  }

  public String getFilter() {
    return filter;
  }

  public RSync filter(String filter) {
    this.filter = filter;
    return this;
  }

  public String getExclude() {
    return exclude;
  }

  public RSync exclude(String exclude) {
    this.exclude = exclude;
    return this;
  }

  public String getExcludeFrom() {
    return exclude_from;
  }

  public RSync excludeFrom(String exclude_from) {
    this.exclude_from = exclude_from;
    return this;
  }

  public String getInclude() {
    return include;
  }

  public RSync include(String include) {
    this.include = include;
    return this;
  }

  public String getIncludeFrom() {
    return include_from;
  }

  public RSync includeFrom(String include_from) {
    this.include_from = include_from;
    return this;
  }

  public String getFilesFrom() {
    return files_from;
  }

  public RSync filesFrom(String files_from) {
    this.files_from = files_from;
    return this;
  }

  public boolean isFrom0() {
    return from0;
  }

  public RSync from0(boolean from0) {
    this.from0 = from0;
    return this;
  }

  public boolean isProtectArgs() {
    return protect_args;
  }

  public RSync protectArgs(boolean protect_args) {
    this.protect_args = protect_args;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public RSync address(String address) {
    this.address = address;
    return this;
  }

  public int getPort() {
    return port;
  }

  public RSync port(int port) {
    this.port = port;
    return this;
  }

  public String getSockopts() {
    return sockopts;
  }

  public RSync sockopts(String sockopts) {
    this.sockopts = sockopts;
    return this;
  }

  public boolean isBlockingIO() {
    return blocking_io;
  }

  public RSync blockingIO(boolean blocking_io) {
    this.blocking_io = blocking_io;
    return this;
  }

  public boolean isStats() {
    return stats;
  }

  public RSync stats(boolean stats) {
    this.stats = stats;
    return this;
  }

  public boolean isEightBitOutput() {
    return eight_bit_output;
  }

  public RSync eightBitOutput(boolean eight_bit_output) {
    this.eight_bit_output = eight_bit_output;
    return this;
  }

  public boolean isHumanReadable() {
    return human_readable;
  }

  public RSync humanReadable(boolean human_readable) {
    this.human_readable = human_readable;
    return this;
  }

  public boolean isProgress() {
    return progress;
  }

  public RSync progress(boolean progress) {
    this.progress = progress;
    return this;
  }

  public boolean isItemizeChanges() {
    return itemize_changes;
  }

  public RSync itemizeChanges(boolean itemize_changes) {
    this.itemize_changes = itemize_changes;
    return this;
  }

  public String getOutFormat() {
    return out_format;
  }

  public RSync outFormat(String out_format) {
    this.out_format = out_format;
    return this;
  }

  public String getLogFile() {
    return log_file;
  }

  public RSync logFile(String log_file) {
    this.log_file = log_file;
    return this;
  }

  public String getLogFileFormat() {
    return log_file_format;
  }

  public RSync logFileFormat(String log_file_format) {
    this.log_file_format = log_file_format;
    return this;
  }

  public String getPasswordFile() {
    return password_file;
  }

  public RSync passwordFile(String password_file) {
    this.password_file = password_file;
    return this;
  }

  public boolean isListOnly() {
    return list_only;
  }

  public RSync listOnly(boolean list_only) {
    this.list_only = list_only;
    return this;
  }

  public int getBwlimit() {
    return bwlimit;
  }

  public RSync bwlimit(int bwlimit) {
    this.bwlimit = bwlimit;
    return this;
  }

  public char getOutbuf() {
    return outbuf;
  }

  public RSync outbuf(char outbuf) {
    this.outbuf = outbuf;
    return this;
  }

  public String getWriteBatch() {
    return write_batch;
  }

  public RSync writeBatch(String write_batch) {
    this.write_batch = write_batch;
    return this;
  }

  public String getOnlyWriteBatch() {
    return only_write_batch;
  }

  public RSync onlyWriteBatch(String only_write_batch) {
    this.only_write_batch = only_write_batch;
    return this;
  }

  public String getReadBatch() {
    return read_batch;
  }

  public RSync readBatch(String read_batch) {
    this.read_batch = read_batch;
    return this;
  }

  public int getProtocol() {
    return protocol;
  }

  public RSync protocol(int protocol) {
    this.protocol = protocol;
    return this;
  }

  public String getIconv() {
    return iconv;
  }

  public RSync iconv(String iconv) {
    this.iconv = iconv;
    return this;
  }

  public int getChecksumSeed() {
    return checksum_seed;
  }

  public RSync checksumSeed(int checksum_seed) {
    this.checksum_seed = checksum_seed;
    return this;
  }

  public boolean isIpv4() {
    return ipv4;
  }

  public RSync ipv4(boolean ipv4) {
    this.ipv4 = ipv4;
    return this;
  }

  public boolean isIpv6() {
    return ipv6;
  }

  public RSync ipv6(boolean ipv6) {
    this.ipv6 = ipv6;
    return this;
  }

  public boolean isVersion() {
    return version;
  }

  public RSync version(boolean version) {
    this.version = version;
    return this;
  }

  /**
   * Assembles the options.
   *
   * @return		the options
   */
  public List<String> options() {
    List<String> 	result;

    result = new ArrayList<>();

    if (isVerbose()) result.add("--verbose");
    if (!getInfo().isEmpty()) result.add("--info=" + getInfo());
    if (!getDebug().isEmpty()) result.add("--debug=" + getDebug());
    if (isMsgs2stderr()) result.add("--msgs2stderr");
    if (isQuiet()) result.add("--quiet");
    if (isNoMotd()) result.add("--no-motd");
    if (isChecksum()) result.add("--checksum");
    if (isArchive()) result.add("--archive");
    if (isRecursive()) result.add("--recursive");
    if (isRelative()) result.add("--relative");
    if (isNoImpliedDirs()) result.add("--no-implied-dirs");
    if (isBackup()) result.add("--backup");
    if (!getBackupDir().isEmpty()) result.add("--backup-dir=" + getBackupDir());
    if (!getSuffix().isEmpty()) result.add("--suffix=" + getSuffix());
    if (isUpdate()) result.add("--update");
    if (isInplace()) result.add("--inplace");
    if (isAppend()) result.add("--append");
    if (isAppendVerify()) result.add("--append-verify");
    if (isDirs()) result.add("--dirs");
    if (isLinks()) result.add("--links");
    if (isCopyLinks()) result.add("--copy-links");
    if (isCopyUnsafeLinks()) result.add("--copy-unsafe-links");
    if (isSafeLinks()) result.add("--safe-links");
    if (isMungeLinks()) result.add("--munge-links");
    if (isCopyDirlinks()) result.add("--copy-dirlinks");
    if (isKeepDirlinks()) result.add("--keep-dirlinks");
    if (isHardLinks()) result.add("--hard-links");
    if (isPerms()) result.add("--perms");
    if (isExecutability()) result.add("--executability");
    if (!getChmod().isEmpty()) result.add("--chmod=" + getChmod());
    if (isXattrs()) result.add("--xattrs");
    if (isOwner()) result.add("--owner");
    if (isGroup()) result.add("--group");
    if (isDevices()) result.add("--devices");
    if (isSpecials()) result.add("--specials");
    if (isTimes()) result.add("--times");
    if (isOmitDirTimes()) result.add("--omit-dir-times");
    if (isOmitLinkTimes()) result.add("--omit-link-times");
    if (isSuper_()) result.add("--super");
    if (isFakeSuper()) result.add("--fake-super");
    if (isSparse()) result.add("--sparse");
    if (isPreallocate()) result.add("--preallocate");
    if (isDryRun()) result.add("--dry-run");
    if (isWholeFile()) result.add("--whole-file");
    if (isOneFileSystem()) result.add("--one-file-system");
    if (!getBlockSize().isEmpty()) result.add("--block-size=" + getBlockSize());
    if (!getRsh().isEmpty()) result.add("--rsh=" + getRsh());
    if (!getRsyncPath().isEmpty()) result.add("--rsync-path=" + getRsyncPath());
    if (isExisting()) result.add("--existing");
    if (isIgnoreExisting()) result.add("--ignore-existing");
    if (isRemoveSourceFiles()) result.add("--remove-source-files");
    if (isDelete()) result.add("--delete");
    if (isDeleteBefore()) result.add("--delete-before");
    if (isDeleteDuring()) result.add("--delete-during");
    if (isDeleteDelay()) result.add("--delete-delay");
    if (isDeleteAfter()) result.add("--delete-after");
    if (isDeleteExcluded()) result.add("--delete-excluded");
    if (isIgnoreMissingArgs()) result.add("--ignore-missing-args");
    if (isDeleteMissingArgs()) result.add("--delete-missing-args");
    if (isIgnoreErrors()) result.add("--ignore-errors");
    if (isForce()) result.add("--force");
    if (getMaxDelete() > -1) result.add("--max-delete=" + getMaxDelete());
    if (getMaxSize() > -1) result.add("--max-size=" + getMaxSize());
    if (getMinSize() > -1) result.add("--min-size=" + getMinSize());
    if (isPartial()) result.add("--partial");
    if (isDelayUpdates()) result.add("--delay-updates");
    if (isPruneEmptyDirs()) result.add("--prune-empty-dirs");
    if (isNumericIds()) result.add("--numeric-ids");
    if (!getUsermap().isEmpty()) result.add("--usermap=" + getUsermap());
    if (!getGroupmap().isEmpty()) result.add("--groupmap=" + getGroupmap());
    if (getTimeout() > -1) result.add("--timeout=" + getTimeout());
    if (getContimeout() > -1) result.add("--contimeout=" + getContimeout());
    if (isIgnoreTimes()) result.add("--ignore-times");
    if (!getRemoteOption().isEmpty()) result.add("--remote-option=" + getRemoteOption());
    if (isSizeOnly()) result.add("--size-only");
    if (getModifyWindow() > -1) result.add("--modify-window=" + getModifyWindow());
    if (!getTempDir().isEmpty()) result.add("--temp-dir=" + getTempDir());
    if (isFuzzy()) result.add("--fuzzy");
    if (!getCompareDest().isEmpty()) result.add("--compare-dest=" + getCompareDest());
    if (!getCopyDest().isEmpty()) result.add("--copy-dest=" + getCopyDest());
    if (!getLinkDest().isEmpty()) result.add("--link-dest=" + getLinkDest());
    if (isCompress()) result.add("--compress");
    if (getCompressLevel() > -1) result.add("--compress-level=" + getCompressLevel());
    if (!getSkipCompress().isEmpty()) result.add("--skip-compress=" + getSkipCompress());
    if (isCvsExclude()) result.add("--cvs-exclude");
    if (!getFilter().isEmpty()) result.add("--filter=" + getFilter());
    if (!getExclude().isEmpty()) result.add("--exclude=" + getExclude());
    if (!getExcludeFrom().isEmpty()) result.add("--exclude-from=" + getExcludeFrom());
    if (!getInclude().isEmpty()) result.add("--include=" + getInclude());
    if (!getIncludeFrom().isEmpty()) result.add("--include-from=" + getIncludeFrom());
    if (!getFilesFrom().isEmpty()) result.add("--files-from=" + getFilesFrom());
    if (isFrom0()) result.add("--from0");
    if (isProtectArgs()) result.add("--protect-args");
    if (!getAddress().isEmpty()) result.add("--address=" + getAddress());
    if (getPort() > -1) result.add("--port=" + getPort());
    if (!getSockopts().isEmpty()) result.add("--sockopts=" + getSockopts());
    if (isBlockingIO()) result.add("--blocking-io");
    if (isStats()) result.add("--stats");
    if (isEightBitOutput()) result.add("--8-bit-output");
    if (isHumanReadable()) result.add("--human-readable");
    if (isProgress()) result.add("--progress");
    if (isItemizeChanges()) result.add("--itemize-changes");
    if (!getOutFormat().isEmpty()) result.add("--out-format=" + getOutFormat());
    if (!getLogFile().isEmpty()) result.add("--log-file=" + getLogFile());
    if (!getLogFileFormat().isEmpty()) result.add("--log-file-format=" + getLogFileFormat());
    if (!getPasswordFile().isEmpty()) result.add("--password-file=" + getPasswordFile());
    if (isListOnly()) result.add("--list-only");
    if (getBwlimit() > -1) result.add("--bwlimit=" + getBwlimit());
    if (getOutbuf() != '\0') result.add("--outbuf=" + getOutbuf());
    if (!getWriteBatch().isEmpty()) result.add("--write-batch=" + getWriteBatch());
    if (!getOnlyWriteBatch().isEmpty()) result.add("--only-write-batch=" + getOnlyWriteBatch());
    if (!getReadBatch().isEmpty()) result.add("--read-batch=" + getReadBatch());
    if (getProtocol() > -1) result.add("--protocol=" + getProtocol());
    if (!getIconv().isEmpty()) result.add("--iconv=" + getIconv());
    if (getChecksumSeed() > -1) result.add("--checksum-seed=" + getChecksumSeed());
    if (isIpv4()) result.add("--ipv4");
    if (isIpv6()) result.add("--ipv6");
    if (isVersion()) result.add("--version");

    return result;
  }

  /**
   * Executes the rsync binary for the platform.
   *
   * @return		the process object
   * @throws Exception	if execution fails or fails to determine binary
   */
  public ProcessResult execute() throws Exception {
    ProcessBuilder	builder;
    String 		binary;
    List<String>	args;

    binary = Binaries.extractBinary();
    args   = options();
    args.add(0, binary);
    if (getSource() == null)
      throw new IllegalStateException("No source defined!");
    args.add(getSource());
    if (getDestination() == null)
      throw new IllegalStateException("No destination defined!");
    args.add(getDestination());

    if (getOutputCommandline())
      System.out.println("Command-line: " + Utils.flatten(args, " "));

    builder = new ProcessBuilder();
    builder.directory(new File(binary).getParentFile());
    builder.command(args);

    return new ProcessResult(args.toArray(new String[args.size()]), null, null, builder.start());
  }

  /**
   * Sets the commandline options.
   *
   * @param options	the options to use
   * @return		true if successful
   * @throws Exception	in case of an invalid option
   */
  public boolean setOptions(String[] options) throws Exception {
    ArgumentParser 	parser;
    Namespace 		ns;

    parser = ArgumentParsers.newArgumentParser(RSync.class.getName());
    parser.addArgument("-v", "--verbose")
      .dest("verbose")
      .help("increase verbosity")
      .action(Arguments.storeTrue());
    parser.addArgument("--info")
      .help("fine-grained informational verbosity");
    parser.addArgument("--debug")
      .help("fine-grained debug verbosity");
    parser.addArgument("--msgs2stderr")
      .dest("msgs2stderr")
      .help("special output handling for debugging")
      .action(Arguments.storeTrue());
    parser.addArgument("-q", "--quiet")
      .dest("quiet")
      .help("suppress non-error messages")
      .action(Arguments.storeTrue());
    parser.addArgument("--no-motd")
      .dest("nomotd")
      .help("suppress daemon-mode MOTD")
      .action(Arguments.storeTrue());
    parser.addArgument("-c", "--checksum")
      .dest("checksum")
      .help("skip based on checksum, not mod-time & size")
      .action(Arguments.storeTrue());
    parser.addArgument("-a", "--archive")
      .dest("archive")
      .help("archive mode; equals -rlptgoD (no -H,-A,-X)")
      .action(Arguments.storeTrue());
    parser.addArgument("-r", "--recursive")
      .dest("recursive")
      .help("recurse into directories")
      .action(Arguments.storeTrue());
    parser.addArgument("-R", "--relative")
      .dest("relative")
      .help("use relative path names")
      .action(Arguments.storeTrue());
    parser.addArgument("--no-implied-dirs")
      .dest("noimplieddirs")
      .help("use relative path names")
      .action(Arguments.storeTrue());
    parser.addArgument("-b", "--backup")
      .dest("backup")
      .help("make backups (see --suffix & --backup-dir)")
      .action(Arguments.storeTrue());
    parser.addArgument("--backup-dir")
      .dest("backupdir")
      .help("make backups into hierarchy based in DIR");
    parser.addArgument("--suffix")
      .dest("suffix")
      .help("set backup suffix (default ~ w/o --backup-dir)");
    parser.addArgument("-u", "--update")
      .dest("update")
      .help("skip files that are newer on the receiver")
      .action(Arguments.storeTrue());
    parser.addArgument("--inplace")
      .dest("inplace")
      .help("update destination files in-place")
      .action(Arguments.storeTrue());
    parser.addArgument("--append")
      .dest("append")
      .help("append data onto shorter files")
      .action(Arguments.storeTrue());
    parser.addArgument("--append-verify")
      .dest("appendverify")
      .help("like --append, but with old data in file checksum")
      .action(Arguments.storeTrue());
    parser.addArgument("-d", "--dirs")
      .dest("dirs")
      .help("transfer directories without recursing")
      .action(Arguments.storeTrue());
    parser.addArgument("-l", "--links")
      .dest("links")
      .help("copy symlinks as symlinks")
      .action(Arguments.storeTrue());
    parser.addArgument("-L", "--copy-links")
      .dest("copylinks")
      .help("transform symlink into referent file/dir")
      .action(Arguments.storeTrue());
    parser.addArgument("--copy-unsafe-links")
      .dest("copyunsafelinks")
      .help("only \"unsafe\" symlinks are transformed")
      .action(Arguments.storeTrue());
    parser.addArgument("--safe-links")
      .dest("safelinks")
      .help("ignore symlinks that point outside the source tree")
      .action(Arguments.storeTrue());
    parser.addArgument("--munge-links")
      .dest("mungelinks")
      .help("munge symlinks to make them safer (but unusable)")
      .action(Arguments.storeTrue());
    parser.addArgument("-k", "--copy-dirlinks")
      .dest("copydirlinks")
      .help("transform symlink to a dir into referent dir")
      .action(Arguments.storeTrue());
    parser.addArgument("-K", "--keep-dirlinks")
      .dest("keepdirlinks")
      .help("treat symlinked dir on receiver as dir")
      .action(Arguments.storeTrue());
    parser.addArgument("-H", "--hard-links")
      .dest("hardlinks")
      .help("preserve hard links")
      .action(Arguments.storeTrue());
    parser.addArgument("-p", "--perms")
      .dest("perms")
      .help("preserve permissions")
      .action(Arguments.storeTrue());
    parser.addArgument("-E", "--executability")
      .dest("executability")
      .help("preserve the file's executability")
      .action(Arguments.storeTrue());
    parser.addArgument("--chmod")
      .dest("chmod")
      .help("affect file and/or directory permissions");
    parser.addArgument("-X", "--xattrs")
      .dest("xattrs")
      .help("preserve extended attributes")
      .action(Arguments.storeTrue());
    parser.addArgument("-o", "--owner")
      .dest("owner")
      .help("preserve owner (super-user only)")
      .action(Arguments.storeTrue());
    parser.addArgument("-g", "--group")
      .dest("group")
      .help("preserve group")
      .action(Arguments.storeTrue());
    parser.addArgument("--devices")
      .dest("devices")
      .help("preserve device files (super-user only)")
      .action(Arguments.storeTrue());
    parser.addArgument("--specials")
      .dest("specials")
      .help("preserve special files")
      .action(Arguments.storeTrue());
    parser.addArgument("-t", "--times")
      .dest("times")
      .help("preserve modification times")
      .action(Arguments.storeTrue());
    parser.addArgument("-O", "--omit-dir-times")
      .dest("omitdirtimes")
      .help("omit directories from --times")
      .action(Arguments.storeTrue());
    parser.addArgument("-J", "--omit-link-times")
      .dest("omitlinktimes")
      .help("omit symlinks from --times")
      .action(Arguments.storeTrue());
    parser.addArgument("--super")
      .dest("super_")
      .help("receiver attempts super-user activities")
      .action(Arguments.storeTrue());
    parser.addArgument("--fake-super")
      .dest("fakesuper")
      .help("store/recover privileged attrs using xattrs")
      .action(Arguments.storeTrue());
    parser.addArgument("-S", "--sparse")
      .dest("sparse")
      .help("handle sparse files efficiently")
      .action(Arguments.storeTrue());
    parser.addArgument("--preallocate")
      .dest("preallocate")
      .help("allocate dest files before writing them")
      .action(Arguments.storeTrue());
    parser.addArgument("-n", "--dry-run")
      .dest("dryrun")
      .help("perform a trial run with no changes made")
      .action(Arguments.storeTrue());
    parser.addArgument("-W", "--whole-file")
      .dest("wholefile")
      .help("copy files whole (without delta-xfer algorithm)")
      .action(Arguments.storeTrue());
    parser.addArgument("-B", "--block-size")
      .dest("blocksize")
      .help("force a fixed checksum block-size");
    parser.addArgument("-e", "--rsh")
      .dest("rsh")
      .help("specify the remote shell to use");
    parser.addArgument("--rsync-path")
      .dest("rsyncpath")
      .help("specify the rsync to run on the remote machine");
    parser.addArgument("--existing")
      .dest("existing")
      .help("skip creating new files on receiver")
      .action(Arguments.storeTrue());
    parser.addArgument("--ignore-existing")
      .dest("ignoreexisting")
      .help("skip updating files that already exist on receiver")
      .action(Arguments.storeTrue());
    parser.addArgument("--remove-source-files")
      .dest("removesourcefiles")
      .help("sender removes synchronized files (non-dirs)")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete")
      .dest("delete")
      .help("delete extraneous files from destination dirs")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-before")
      .dest("deletebefore")
      .help("receiver deletes before transfer, not during")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-during")
      .dest("deleteduring")
      .help("receiver deletes during the transfer")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-delay")
      .dest("deletedelay")
      .help("find deletions during, delete after")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-after")
      .dest("deleteafter")
      .help("receiver deletes after transfer, not during")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-excluded")
      .dest("deleteexcluded")
      .help("also delete excluded files from destination dirs")
      .action(Arguments.storeTrue());
    parser.addArgument("--ignore-missing-args")
      .dest("ignoremissingargs")
      .help("ignore missing source args without error")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-missing-args")
      .dest("deletemissingargs")
      .help("delete missing source args from destination")
      .action(Arguments.storeTrue());
    parser.addArgument("--ignore-errors")
      .dest("ignoreerrors")
      .help("delete even if there are I/O errors")
      .action(Arguments.storeTrue());
    parser.addArgument("--force")
      .dest("force")
      .help("force deletion of directories even if not empty")
      .action(Arguments.storeTrue());
    parser.addArgument("--max-delete")
      .dest("maxdelete")
      .help("don't delete more than NUM files");
    parser.addArgument("--max-size")
      .dest("maxsize")
      .help("don't transfer any file larger than SIZE");
    parser.addArgument("--min-size")
      .dest("minsize")
      .help("don't transfer any file smaller than SIZE");
    parser.addArgument("--partial")
      .dest("partial")
      .help("keep partially transferred files")
      .action(Arguments.storeTrue());
    parser.addArgument("--partial-dir")
      .dest("partialdir")
      .help("put a partially transferred file into DIR");
    parser.addArgument("--delay-updates")
      .dest("delayupdates")
      .help("put all updated files into place at transfer's end")
      .action(Arguments.storeTrue());
    parser.addArgument("-m", "--prune-empty-dirs")
      .dest("pruneemptydirs")
      .help("prune empty directory chains from the file-list")
      .action(Arguments.storeTrue());
    parser.addArgument("--numeric-ids")
      .dest("numericids")
      .help("don't map uid/gid values by user/group name")
      .action(Arguments.storeTrue());
    parser.addArgument("--usermap")
      .dest("usermap")
      .help("custom username mapping");
    parser.addArgument("--groupmap")
      .dest("groupmap")
      .help("custom groupname mapping");
    parser.addArgument("--chown")
      .dest("chown")
      .help("simple username/groupname mapping");
    parser.addArgument("--timeout")
      .dest("timeout")
      .help("set I/O timeout in seconds");
    parser.addArgument("--contimeout")
      .dest("contimeout")
      .help("set daemon connection timeout in seconds");
    parser.addArgument("-I", "--ignore-times")
      .dest("ignoretimes")
      .help("don't skip files that match in size and mod-time")
      .action(Arguments.storeTrue());
    parser.addArgument("-M", "--remote-option")
      .dest("remoteoption")
      .help("send OPTION to the remote side only");
    parser.addArgument("--size-only")
      .dest("sizeonly")
      .help("skip files that match in size")
      .action(Arguments.storeTrue());
    parser.addArgument("--modify-window")
      .dest("modifywindow")
      .help("compare mod-times with reduced accuracy");
    parser.addArgument("-T", "--temp-dir")
      .dest("tempdir")
      .help("create temporary files in directory DIR");
    parser.addArgument("-y", "--fuzzy")
      .dest("fuzzy")
      .help("find similar file for basis if no dest file")
      .action(Arguments.storeTrue());
    parser.addArgument("--compare-dest")
      .dest("comparedest")
      .help("also compare destination files relative to DIR");
    parser.addArgument("--copy-dest")
      .dest("copydest")
      .help("... and include copies of unchanged files");
    parser.addArgument("--link-dest")
      .dest("linkdest")
      .help("hardlink to files in DIR when unchanged");
    parser.addArgument("-z", "--compress")
      .dest("compress")
      .help("compress file data during the transfer")
      .action(Arguments.storeTrue());
    parser.addArgument("--compress-level")
      .dest("compresslevel")
      .help("explicitly set compression level");
    parser.addArgument("-C", "--cvs-exclude")
      .dest("csvexclude")
      .help("auto-ignore files the same way CVS does")
      .action(Arguments.storeTrue());
    parser.addArgument("-f", "--filter-rule")
      .dest("filterrule")
      .help("add a file-filtering RULE");
    parser.addArgument("--exclude")
      .dest("exclude")
      .help("exclude files matching PATTERN");
    parser.addArgument("--exclude-from")
      .dest("excludefrom")
      .help("read exclude patterns from FILE");
    parser.addArgument("--include")
      .dest("include")
      .help("include files matching PATTERN");
    parser.addArgument("--include-from")
      .dest("includefrom")
      .help("read include patterns from FILE");
    parser.addArgument("--files-from")
      .dest("filesfrom")
      .help("read list of source-file names from FILE");
    parser.addArgument("-0", "--from0")
      .dest("from0")
      .help("all *-from/filter files are delimited by 0s")
      .action(Arguments.storeTrue());
    parser.addArgument("-s", "--protect-args")
      .dest("protectargs")
      .help("no space-splitting; only wildcard special-chars")
      .action(Arguments.storeTrue());
    parser.addArgument("--address")
      .dest("address")
      .help("bind address for outgoing socket to daemon");
    parser.addArgument("--port")
      .dest("port")
      .help("specify double-colon alternate port number");
    parser.addArgument("--sockopts")
      .dest("sockopts")
      .help("specify custom TCP options");
    parser.addArgument("--blocking-io")
      .dest("blockingio")
      .help("use blocking I/O for the remote shell")
      .action(Arguments.storeTrue());
    parser.addArgument("--stats")
      .dest("stats")
      .help("give some file-transfer stats")
      .action(Arguments.storeTrue());
    parser.addArgument("-8", "--8-bit-output")
      .dest("eightbitoutput")
      .help("leave high-bit chars unescaped in output")
      .action(Arguments.storeTrue());
    parser.addArgument("-h", "--human-readable")
      .dest("humanreadable")
      .help("output numbers in a human-readable format")
      .action(Arguments.storeTrue());
    parser.addArgument("--progress")
      .dest("progress")
      .help("show progress during transfer")
      .action(Arguments.storeTrue());
    parser.addArgument("-i", "--itemize-changes")
      .dest("itemizechanges")
      .help("output a change-summary for all updates")
      .action(Arguments.storeTrue());
    parser.addArgument("--out-format")
      .dest("outformat")
      .help("output updates using the specified FORMAT");
    parser.addArgument("--log-file")
      .dest("logfile")
      .help("log what we're doing to the specified FILE");
    parser.addArgument("--log-file-format")
      .dest("logfileformat")
      .help("log updates using the specified FMT");
    parser.addArgument("--password-file")
      .dest("passwordfile")
      .help("read daemon-access password from FILE");
    parser.addArgument("--list-only")
      .dest("listonly")
      .help("list the files instead of copying them")
      .action(Arguments.storeTrue());
    parser.addArgument("--bwlimit")
      .dest("bwlimit")
      .help("limit socket I/O bandwidth");
    parser.addArgument("--outbuf")
      .dest("outbuf")
      .help("set output buffering to None, Line, or Block (N|L|B)");
    parser.addArgument("--write-batch")
      .dest("writebatch")
      .help("write a batched update to FILE");
    parser.addArgument("--only-write-batch")
      .dest("onlywritebatch")
      .help("like --write-batch but w/o updating destination");
    parser.addArgument("--read-batch")
      .dest("readbatch")
      .help("read a batched update from FILE");
    parser.addArgument("--protocol")
      .dest("protocol")
      .help("force an older protocol version to be used");
    parser.addArgument("--iconv")
      .dest("iconv")
      .help("request charset conversion of filenames");
    parser.addArgument("--checkum-seed")
      .dest("checksumseed")
      .help("set block/file checksum seed (advanced)");
    parser.addArgument("-4", "--ipv4")
      .dest("ipv4")
      .help("prefer IPv4")
      .action(Arguments.storeTrue());
    parser.addArgument("-6", "--ipv6")
      .dest("ipv6")
      .help("prefer IPv6")
      .action(Arguments.storeTrue());
    parser.addArgument("--version")
      .dest("version")
      .help("print version number")
      .action(Arguments.storeTrue());
    parser.addArgument("--output-commandline")
      .dest("outputCommandline")
      .help("output the command-line generated for the rsync binary")
      .action(Arguments.storeTrue());
    parser.addArgument("src")
      .help("The local or remote source path (path or [user@]host:path)");
    parser.addArgument("dest")
      .help("The local or remote destination path (path or [user@]host:path)");
    try {
      ns = parser.parseArgs(options);
    }
    catch (ArgumentParserException e) {
      parser.handleError(e);
      return false;
    }

    verbose(ns.getBoolean("verbose"));
    recursive(ns.getBoolean("recursive"));
    setOutputCommandline(ns.get("outputCommandline"));
    setSource(ns.getString("src"));
    setDestination(ns.getString("dest"));

    return true;
  }

  /**
   * For testing.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Exception {
    RSync 		rsync;
    ProcessResult 	result;

    rsync = new RSync();
    if (rsync.setOptions(args)) {
      result = rsync.execute();
      System.out.println(result.getStdOut());
      System.out.println("Exit code: " + result.getExitCode());
      if (result.getExitCode() > 0)
	System.err.println(result.getStdErr());
    }
    else {
      System.exit(1);
    }
  }
}
