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
 * RSync.java
 * Copyright (C) 2017-2025 University of Waikato, Hamilton, New Zealand
 */
package com.github.fracpete.rsync4j;

import com.github.fracpete.rsync4j.core.AbstractBinaryWithTimeout;
import com.github.fracpete.rsync4j.core.Binaries;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;
import org.apache.commons.lang.SystemUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for rsync binary.
 *
 * @author  fracpete (fracpete at gmail dot com)
 */
public class RSync
  extends AbstractBinaryWithTimeout {

  /** the source path/url. */
  protected List<String> sources;

  /** the destination path/url. */
  protected String destination;

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

  protected boolean acls;

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

  protected String max_size;

  protected String min_size;

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

  protected String[] compare_dest;

  protected String[] copy_dest;

  protected String[] link_dest;

  protected boolean compress;

  protected int compress_level;

  protected String skip_compress;

  protected boolean cvs_exclude;

  protected List<String> include_exclude;

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

  protected String bwlimit;

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

  protected boolean trust_sender;

  protected boolean fsync;

  protected boolean copy_devices;

  protected String stop_after;

  protected String stop_at;

  protected boolean crtimes;

  protected boolean mkpath;

  protected String max_alloc;

  protected String early_input;

  protected boolean atimes;

  protected boolean open_noatime;

  protected boolean write_devices;

  protected String copy_as;

  protected String checksum_choice;

  protected String[] additional;

  protected SshPass sshPass;

  /**
   * Resets the members.
   */
  public void reset() {
    super.reset();

    sources = new ArrayList<>();
    destination = null;
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
    acls = false;
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
    max_size = "";
    min_size = "";
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
    compare_dest = new String[0];
    copy_dest = new String[0];
    link_dest = new String[0];
    compress = false;
    compress_level = -1;
    skip_compress = "";
    cvs_exclude = false;
    include_exclude = new ArrayList<>();
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
    bwlimit = "";
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
    trust_sender = false;
    fsync = false;
    copy_devices = false;
    stop_after = "";
    stop_at = "";
    crtimes = false;
    mkpath = false;
    max_alloc = "";
    early_input = "";
    atimes = false;
    open_noatime = false;
    write_devices = false;
    copy_as = "";
    checksum_choice = "";
    sshPass = null;
  }

  /**
   * Sets the source path/url.
   *
   * @param value	the source
   */
  public RSync source(String value) {
    sources.clear();
    sources.add(Binaries.convertPath(value));
    return this;
  }

  /**
   * Sets the source paths/urls.
   *
   * @param value	the sources
   */
  public RSync sources(String[] value) {
    sources.clear();
    for (String s: value)
      sources.add(Binaries.convertPath(s));
    return this;
  }

  /**
   * Sets the source paths/urls.
   *
   * @param value	the sources
   */
  public RSync sources(List<String> value) {
    sources.clear();
    for (String s: value)
      sources.add(Binaries.convertPath(s));
    return this;
  }

  /**
   * Returns the current source paths/urls.
   *
   * @return		the sources, empty list if not set
   */
  public List<String> getSources() {
    return sources;
  }

  /**
   * Sets the destination path/url.
   *
   * @param value	the destination
   * @return		itself
   */
  public RSync destination(String value) {
    destination = Binaries.convertPath(value);
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
  public RSync outputCommandline(boolean value) {
    return (RSync) super.outputCommandline(value);
  }

  /**
   * rsync option: --verbose/-v
   */
  public boolean isVerbose() {
    return verbose;
  }

  /**
   * rsync option: --verbose/-v
   */
  public RSync verbose(boolean verbose) {
    this.verbose = verbose;
    return this;
  }

  /**
   * rsync option: --info
   */
  public String getInfo() {
    return info;
  }

  /**
   * rsync option: --info
   */
  public RSync info(String info) {
    this.info = info;
    return this;
  }

  /**
   * rsync option: --debug
   */
  public String getDebug() {
    return debug;
  }

  /**
   * rsync option: --debug
   */
  public RSync debug(String debug) {
    this.debug = debug;
    return this;
  }

  /**
   * rsync option: --msgs2stderr
   */
  public boolean isMsgs2stderr() {
    return msgs2stderr;
  }

  /**
   * rsync option: --msgs2stderr
   */
  public RSync msgs2stderr(boolean msgs2stderr) {
    this.msgs2stderr = msgs2stderr;
    return this;
  }

  /**
   * rsync option: --quiet/-q
   */
  public boolean isQuiet() {
    return quiet;
  }

  /**
   * rsync option: --quiet/-q
   */
  public RSync quiet(boolean quiet) {
    this.quiet = quiet;
    return this;
  }

  /**
   * rsync option: --no-motd
   */
  public boolean isNoMotd() {
    return no_motd;
  }

  /**
   * rsync option: --no-motd
   */
  public RSync noMotd(boolean no_motd) {
    this.no_motd = no_motd;
    return this;
  }

  /**
   * rsync option: --checksum/-c
   */
  public boolean isChecksum() {
    return checksum;
  }

  /**
   * rsync option: --checksum/-c
   */
  public RSync checksum(boolean checksum) {
    this.checksum = checksum;
    return this;
  }

  /**
   * rsync option: --archive/-a
   */
  public boolean isArchive() {
    return archive;
  }

  /**
   * rsync option: --archive/-a
   */
  public RSync archive(boolean archive) {
    this.archive = archive;
    return this;
  }

  /**
   * rsync option: --recursive/-r
   */
  public boolean isRecursive() {
    return recursive;
  }

  /**
   * rsync option: --recursive/-r
   */
  public RSync recursive(boolean recursive) {
    this.recursive = recursive;
    return this;
  }

  /**
   * rsync option: --relative/-R
   */
  public boolean isRelative() {
    return relative;
  }

  /**
   * rsync option: --relative/-R
   */
  public RSync relative(boolean relative) {
    this.relative = relative;
    return this;
  }

  /**
   * rsync option: --no-implied-dirs
   */
  public boolean isNoImpliedDirs() {
    return no_implied_dirs;
  }

  /**
   * rsync option: --no-implied-dirs
   */
  public RSync noImpliedDirs(boolean no_implied_dirs) {
    this.no_implied_dirs = no_implied_dirs;
    return this;
  }

  /**
   * rsync option: --backup/-b
   */
  public boolean isBackup() {
    return backup;
  }

  /**
   * rsync option: --backup/-b
   */
  public RSync backup(boolean backup) {
    this.backup = backup;
    return this;
  }

  /**
   * rsync option: --backup-dir
   */
  public String getBackupDir() {
    return backup_dir;
  }

  /**
   * rsync option: --backup-dir
   */
  public RSync backupDir(String backup_dir) {
    this.backup_dir = backup_dir;
    return this;
  }

  /**
   * rsync option: --suffix
   */
  public String getSuffix() {
    return suffix;
  }

  /**
   * rsync option: --suffix
   */
  public RSync suffix(String suffix) {
    this.suffix = suffix;
    return this;
  }

  /**
   * rsync option: --update/-u
   */
  public boolean isUpdate() {
    return update;
  }

  /**
   * rsync option: --update/-u
   */
  public RSync update(boolean update) {
    this.update = update;
    return this;
  }

  /**
   * rsync option: --inplace
   */
  public boolean isInplace() {
    return inplace;
  }

  /**
   * rsync option: --inplace
   */
  public RSync inplace(boolean inplace) {
    this.inplace = inplace;
    return this;
  }

  /**
   * rsync option: --append
   */
  public boolean isAppend() {
    return append;
  }

  /**
   * rsync option: --append
   */
  public RSync append(boolean append) {
    this.append = append;
    return this;
  }

  /**
   * rsync option: --append-verify
   */
  public boolean isAppendVerify() {
    return append_verify;
  }

  /**
   * rsync option: --append-verify
   */
  public RSync appendVerify(boolean append_verify) {
    this.append_verify = append_verify;
    return this;
  }

  /**
   * rsync option: --dirs/-d
   */
  public boolean isDirs() {
    return dirs;
  }

  /**
   * rsync option: --dirs/-d
   */
  public RSync dirs(boolean dirs) {
    this.dirs = dirs;
    return this;
  }

  /**
   * rsync option: --links/-l
   */
  public boolean isLinks() {
    return links;
  }

  /**
   * rsync option: --links/-l
   */
  public RSync links(boolean links) {
    this.links = links;
    return this;
  }

  /**
   * rsync option: --copy-links/-L
   */
  public boolean isCopyLinks() {
    return copy_links;
  }

  /**
   * rsync option: --copy-links/-L
   */
  public RSync copyLinks(boolean copy_links) {
    this.copy_links = copy_links;
    return this;
  }

  /**
   * rsync option: --copy-unsafe-links
   */
  public boolean isCopyUnsafeLinks() {
    return copy_unsafe_links;
  }

  /**
   * rsync option: --copy-unsafe-links
   */
  public RSync copyUnsafeLinks(boolean copy_unsafe_links) {
    this.copy_unsafe_links = copy_unsafe_links;
    return this;
  }

  /**
   * rsync option: --safe-links
   */
  public boolean isSafeLinks() {
    return safe_links;
  }

  /**
   * rsync option: --safe-links
   */
  public RSync safeLinks(boolean safe_links) {
    this.safe_links = safe_links;
    return this;
  }

  /**
   * rsync option: --munge-links
   */
  public boolean isMungeLinks() {
    return munge_links;
  }

  /**
   * rsync option: --munge-links
   */
  public RSync mungeLinks(boolean munge_links) {
    this.munge_links = munge_links;
    return this;
  }

  /**
   * rsync option: --copy-dirlinks/-k
   */
  public boolean isCopyDirlinks() {
    return copy_dirlinks;
  }

  /**
   * rsync option: --copy-dirlinks/-k
   */
  public RSync copyDirlinks(boolean copy_dirlinks) {
    this.copy_dirlinks = copy_dirlinks;
    return this;
  }

  /**
   * rsync option: --keep-dirlinks/-K
   */
  public boolean isKeepDirlinks() {
    return keep_dirlinks;
  }

  /**
   * rsync option: --copy-dirlinks/-K
   */
  public RSync keepDirlinks(boolean keep_dirlinks) {
    this.keep_dirlinks = keep_dirlinks;
    return this;
  }

  /**
   * rsync option: --hard-links/-H
   */
  public boolean isHardLinks() {
    return hard_links;
  }

  /**
   * rsync option: --hard-links/-H
   */
  public RSync hardLinks(boolean hard_links) {
    this.hard_links = hard_links;
    return this;
  }

  /**
   * rsync option: --perms/-p
   */
  public boolean isPerms() {
    return perms;
  }

  /**
   * rsync option: --perms/-p
   */
  public RSync perms(boolean perms) {
    this.perms = perms;
    return this;
  }

  /**
   * rsync option: --executability/-E
   */
  public boolean isExecutability() {
    return executability;
  }

  /**
   * rsync option: --executability/-E
   */
  public RSync executability(boolean executability) {
    this.executability = executability;
    return this;
  }

  /**
   * rsync option: --chmod
   */
  public String getChmod() {
    return chmod;
  }

  /**
   * rsync option: --chmod
   */
  public RSync chmod(String chmod) {
    this.chmod = chmod;
    return this;
  }

  /**
   * rsync option: --acls/-A
   */
  public boolean isAcls() {
    return acls;
  }

  /**
   * rsync option: --acls/-A
   */
  public RSync acls(boolean acls) {
    this.acls = acls;
    return this;
  }

  /**
   * rsync option: --xattrs/-X
   */
  public boolean isXattrs() {
    return xattrs;
  }

  /**
   * rsync option: --xattrs/-X
   */
  public RSync xattrs(boolean xattrs) {
    this.xattrs = xattrs;
    return this;
  }

  /**
   * rsync option: --owner/-o
   */
  public boolean isOwner() {
    return owner;
  }

  /**
   * rsync option: --owner/-o
   */
  public RSync owner(boolean owner) {
    this.owner = owner;
    return this;
  }

  /**
   * rsync option: --group/-g
   */
  public boolean isGroup() {
    return group;
  }

  /**
   * rsync option: --group/-g
   */
  public RSync group(boolean group) {
    this.group = group;
    return this;
  }

  /**
   * rsync option: --devices
   */
  public boolean isDevices() {
    return devices;
  }

  /**
   * rsync option: --devices
   */
  public RSync devices(boolean devices) {
    this.devices = devices;
    return this;
  }

  /**
   * rsync option: --specials
   */
  public boolean isSpecials() {
    return specials;
  }

  /**
   * rsync option: --specials
   */
  public RSync specials(boolean specials) {
    this.specials = specials;
    return this;
  }

  /**
   * rsync option: --times/-t
   */
  public boolean isTimes() {
    return times;
  }

  /**
   * rsync option: --times/-t
   */
  public RSync times(boolean times) {
    this.times = times;
    return this;
  }

  /**
   * rsync option: --omit-dir-times/-O
   */
  public boolean isOmitDirTimes() {
    return omit_dir_times;
  }

  /**
   * rsync option: --omit-dir-times/-O
   */
  public RSync omitDirTimes(boolean omit_dir_times) {
    this.omit_dir_times = omit_dir_times;
    return this;
  }

  /**
   * rsync option: --omit-link-times/-J
   */
  public boolean isOmitLinkTimes() {
    return omit_link_times;
  }

  /**
   * rsync option: --omit-link-times/-J
   */
  public RSync omitLinkTimes(boolean omit_link_times) {
    this.omit_link_times = omit_link_times;
    return this;
  }

  /**
   * rsync option: --super
   */
  public boolean isSuper_() {
    return super_;
  }

  /**
   * rsync option: --super
   */
  public RSync super_(boolean super_) {
    this.super_ = super_;
    return this;
  }

  /**
   * rsync option: --fake-super
   */
  public boolean isFakeSuper() {
    return fake_super;
  }

  /**
   * rsync option: --fake-super
   */
  public RSync fakeSuper(boolean fake_super) {
    this.fake_super = fake_super;
    return this;
  }

  /**
   * rsync option: --sparse/-S
   */
  public boolean isSparse() {
    return sparse;
  }

  /**
   * rsync option: --sparse/-S
   */
  public RSync sparse(boolean sparse) {
    this.sparse = sparse;
    return this;
  }

  /**
   * rsync option: --preallocate
   */
  public boolean isPreallocate() {
    return preallocate;
  }

  /**
   * rsync option: --preallocate
   */
  public RSync preallocate(boolean preallocate) {
    this.preallocate = preallocate;
    return this;
  }

  /**
   * rsync option: --dry-run/-n
   */
  public boolean isDryRun() {
    return dry_run;
  }

  /**
   * rsync option: --dry-run/-n
   */
  public RSync dryRun(boolean dry_run) {
    this.dry_run = dry_run;
    return this;
  }

  /**
   * rsync option: --whole-file/-W
   */
  public boolean isWholeFile() {
    return whole_file;
  }

  /**
   * rsync option: --whole-file/-W
   */
  public RSync wholeFile(boolean whole_file) {
    this.whole_file = whole_file;
    return this;
  }

  /**
   * rsync option: --one-file-system/-x
   */
  public boolean isOneFileSystem() {
    return one_file_system;
  }

  /**
   * rsync option: --one-file-system/-x
   */
  public RSync oneFileSystem(boolean one_file_system) {
    this.one_file_system = one_file_system;
    return this;
  }

  /**
   * rsync option: --block-size/-B
   */
  public String getBlockSize() {
    return block_size;
  }

  /**
   * rsync option: --block-size/-B
   */
  public RSync blockSize(String block_size) {
    this.block_size = block_size;
    return this;
  }

  /**
   * On Windows: "ssh" will use the built-in ssh binary.
   * Other platforms: use absolute path of binary, eg "/usr/bin/ssh"
   * Empty for plain rsync protocol.
   *
   * rsync option: --rsh/-e
   *
   * @return		the rsh binary
   */
  public String getRsh() {
    return rsh;
  }

  /**
   * On Windows: use "ssh" to use built-in ssh binary.
   * Other platforms: absolute path of binary, eg "/usr/bin/ssh"
   * Leave empty for plain rsync protocol.
   *
   * rsync option: --rsh/-e
   *
   * @param rsh		the rsh binary
   * @return		itself
   */
  public RSync rsh(String rsh) {
    this.rsh = rsh;
    return this;
  }

  /**
   * rsync option: --rsync-path
   */
  public String getRsyncPath() {
    return rsync_path;
  }

  /**
   * rsync option: --rsync-path
   */
  public RSync rsyncPath(String rsync_path) {
    this.rsync_path = rsync_path;
    return this;
  }

  /**
   * rsync option: --existing
   */
  public boolean isExisting() {
    return existing;
  }

  /**
   * rsync option: --existing
   */
  public RSync existing(boolean existing) {
    this.existing = existing;
    return this;
  }

  /**
   * rsync option: --ignore-existing
   */
  public boolean isIgnoreExisting() {
    return ignore_existing;
  }

  /**
   * rsync option: --ignore-existing
   */
  public RSync ignoreExisting(boolean ignore_existing) {
    this.ignore_existing = ignore_existing;
    return this;
  }

  /**
   * rsync option: --remove-source-files
   */
  public boolean isRemoveSourceFiles() {
    return remove_source_files;
  }

  /**
   * rsync option: --remove-source-files
   */
  public RSync removeSourceFiles(boolean remove_source_files) {
    this.remove_source_files = remove_source_files;
    return this;
  }

  /**
   * rsync option: --delete
   */
  public boolean isDelete() {
    return delete;
  }

  /**
   * rsync option: --delete
   */
  public RSync delete(boolean delete) {
    this.delete = delete;
    return this;
  }

  /**
   * rsync option: --delete-before
   */
  public boolean isDeleteBefore() {
    return delete_before;
  }

  /**
   * rsync option: --delete-before
   */
  public RSync deleteBefore(boolean delete_before) {
    this.delete_before = delete_before;
    return this;
  }

  /**
   * rsync option: --delete-during
   */
  public boolean isDeleteDuring() {
    return delete_during;
  }

  /**
   * rsync option: --delete-during
   */
  public RSync deleteDuring(boolean delete_during) {
    this.delete_during = delete_during;
    return this;
  }

  /**
   * rsync option: --delete-delay
   */
  public boolean isDeleteDelay() {
    return delete_delay;
  }

  /**
   * rsync option: --delete-delay
   */
  public RSync deleteDelay(boolean delete_delay) {
    this.delete_delay = delete_delay;
    return this;
  }

  /**
   * rsync option: --delete-after
   */
  public boolean isDeleteAfter() {
    return delete_after;
  }

  /**
   * rsync option: --delete-after
   */
  public RSync deleteAfter(boolean delete_after) {
    this.delete_after = delete_after;
    return this;
  }

  /**
   * rsync option: --delete-excluded
   */
  public boolean isDeleteExcluded() {
    return delete_excluded;
  }

  /**
   * rsync option: --delete-excluded
   */
  public RSync deleteExcluded(boolean delete_excluded) {
    this.delete_excluded = delete_excluded;
    return this;
  }

  /**
   * rsync option: --ignore-missing-args
   */
  public boolean isIgnoreMissingArgs() {
    return ignore_missing_args;
  }

  /**
   * rsync option: --ignore-missing-args
   */
  public RSync ignoreMissingArgs(boolean ignore_missing_args) {
    this.ignore_missing_args = ignore_missing_args;
    return this;
  }

  /**
   * rsync option: --delete-missing-args
   */
  public boolean isDeleteMissingArgs() {
    return delete_missing_args;
  }

  /**
   * rsync option: --delete-missing-args
   */
  public RSync deleteMissingArgs(boolean delete_missing_args) {
    this.delete_missing_args = delete_missing_args;
    return this;
  }

  /**
   * rsync option: --ignore-errors
   */
  public boolean isIgnoreErrors() {
    return ignore_errors;
  }

  /**
   * rsync option: --ignore-errors
   */
  public RSync ignoreErrors(boolean ignore_errors) {
    this.ignore_errors = ignore_errors;
    return this;
  }

  /**
   * rsync option: --force
   */
  public boolean isForce() {
    return force;
  }

  /**
   * rsync option: --force
   */
  public RSync force(boolean force) {
    this.force = force;
    return this;
  }

  /**
   * rsync option: --max-delete
   */
  public int getMaxDelete() {
    return max_delete;
  }

  /**
   * rsync option: --max-delete
   */
  public RSync maxDelete(int max_delete) {
    this.max_delete = max_delete;
    return this;
  }

  /**
   * rsync option: --max-size
   */
  public String getMaxSize() {
    return max_size;
  }

  /**
   * rsync option: --max-size
   */
  public RSync maxSize(String max_size) {
    this.max_size = max_size;
    return this;
  }

  /**
   * rsync option: --min-size
   */
  public String getMinSize() {
    return min_size;
  }

  /**
   * rsync option: --min-size
   */
  public RSync minSize(String min_size) {
    this.min_size = min_size;
    return this;
  }

  /**
   * rsync option: --partial
   */
  public boolean isPartial() {
    return partial;
  }

  /**
   * rsync option: --partial
   */
  public RSync partial(boolean partial) {
    this.partial = partial;
    return this;
  }

  /**
   * rsync option: --partial-dir
   */
  public String getPartialDir() {
    return partial_dir;
  }

  /**
   * rsync option: --partial-dir
   */
  public RSync partialDir(String partial_dir) {
    this.partial_dir = partial_dir;
    return this;
  }

  /**
   * rsync option: --delay-updates
   */
  public boolean isDelayUpdates() {
    return delay_updates;
  }

  /**
   * rsync option: --delay-updates
   */
  public RSync delayUpdates(boolean delay_updates) {
    this.delay_updates = delay_updates;
    return this;
  }

  /**
   * rsync option: --prune-empty-dirs/-m
   */
  public boolean isPruneEmptyDirs() {
    return prune_empty_dirs;
  }

  /**
   * rsync option: --prune-empty-dirs/-m
   */
  public RSync pruneEmptyDirs(boolean prune_empty_dirs) {
    this.prune_empty_dirs = prune_empty_dirs;
    return this;
  }

  /**
   * rsync option: --numeric-ids
   */
  public boolean isNumericIds() {
    return numeric_ids;
  }

  /**
   * rsync option: --numeric-ids
   */
  public RSync numericIds(boolean numeric_ids) {
    this.numeric_ids = numeric_ids;
    return this;
  }

  /**
   * rsync option: --usermap
   */
  public String getUsermap() {
    return usermap;
  }

  /**
   * rsync option: --usermap
   */
  public RSync usermap(String usermap) {
    this.usermap = usermap;
    return this;
  }

  /**
   * rsync option: --groupmap
   */
  public String getGroupmap() {
    return groupmap;
  }

  /**
   * rsync option: --groupmap
   */
  public RSync groupmap(String groupmap) {
    this.groupmap = groupmap;
    return this;
  }

  /**
   * rsync option: --chown
   */
  public String getChown() {
    return chown;
  }

  /**
   * rsync option: --chown
   */
  public RSync chown(String chown) {
    this.chown = chown;
    return this;
  }

  /**
   * rsync option: --timeout
   */
  public int getTimeout() {
    return timeout;
  }

  /**
   * rsync option: --timeout
   */
  public RSync timeout(int timeout) {
    this.timeout = timeout;
    return this;
  }

  /**
   * rsync option: --contimeout
   */
  public int getContimeout() {
    return contimeout;
  }

  /**
   * rsync option: --contimeout
   */
  public RSync contimeout(int contimeout) {
    this.contimeout = contimeout;
    return this;
  }

  /**
   * rsync option: --ignore-times/-I
   */
  public boolean isIgnoreTimes() {
    return ignore_times;
  }

  /**
   * rsync option: --ignore-times/-I
   */
  public RSync ignoreTimes(boolean ignore_times) {
    this.ignore_times = ignore_times;
    return this;
  }

  /**
   * rsync option: --remote-option/-M
   */
  public String getRemoteOption() {
    return remote_option;
  }

  /**
   * rsync option: --remote-option/-M
   */
  public RSync remoteOption(String remote_option) {
    this.remote_option = remote_option;
    return this;
  }

  /**
   * rsync option: --size-only
   */
  public boolean isSizeOnly() {
    return size_only;
  }

  /**
   * rsync option: --size-only
   */
  public RSync sizeOnly(boolean size_only) {
    this.size_only = size_only;
    return this;
  }

  /**
   * rsync option: --modify-window
   */
  public int getModifyWindow() {
    return modify_window;
  }

  /**
   * rsync option: --modify-window
   */
  public RSync modifyWindow(int modify_window) {
    this.modify_window = modify_window;
    return this;
  }

  /**
   * rsync option: --temp-dir/-T
   */
  public String getTempDir() {
    return temp_dir;
  }

  /**
   * rsync option: --temp-dir/-T
   */
  public RSync tempDir(String temp_dir) {
    this.temp_dir = temp_dir;
    return this;
  }

  /**
   * rsync option: --fuzzy/-y
   */
  public boolean isFuzzy() {
    return fuzzy;
  }

  /**
   * rsync option: --fuzzy/-y
   */
  public RSync fuzzy(boolean fuzzy) {
    this.fuzzy = fuzzy;
    return this;
  }

  /**
   * rsync option: --compare-dest
   */
  public String[] getCompareDest() {
    return compare_dest;
  }

  /**
   * rsync option: --compare-dest
   */
  public RSync compareDest(String... compare_dest) {
    this.compare_dest = compare_dest.clone();
    return this;
  }

  /**
   * rsync option: --copy-dest
   */
  public String[] getCopyDest() {
    return copy_dest;
  }

  /**
   * rsync option: --copy-dest
   */
  public RSync copyDest(String... copy_dest) {
    this.copy_dest = copy_dest.clone();
    return this;
  }

  /**
   * rsync option: --link-dest
   */
  public String[] getLinkDest() {
    return link_dest;
  }

  /**
   * rsync option: --link-dest
   */
  public RSync linkDest(String... link_dest) {
    this.link_dest = link_dest.clone();
    return this;
  }

  /**
   * rsync option: --compress/-z
   */
  public boolean isCompress() {
    return compress;
  }

  /**
   * rsync option: --compress/-z
   */
  public RSync compress(boolean compress) {
    this.compress = compress;
    return this;
  }

  /**
   * rsync option: --compress-level
   */
  public int getCompressLevel() {
    return compress_level;
  }

  /**
   * rsync option: --compress-level
   */
  public RSync compressLevel(int compress_level) {
    this.compress_level = compress_level;
    return this;
  }

  /**
   * rsync option: --skip-compress
   */
  public String getSkipCompress() {
    return skip_compress;
  }

  /**
   * rsync option: --skip-compress
   */
  public RSync skipCompress(String skip_compress) {
    this.skip_compress = skip_compress;
    return this;
  }

  /**
   * rsync option: --cvs-exclude/-C
   */
  public boolean isCvsExclude() {
    return cvs_exclude;
  }

  /**
   * rsync option: --cvs-exclude/-C
   */
  public RSync cvsExclude(boolean cvs_exclude) {
    this.cvs_exclude = cvs_exclude;
    return this;
  }

  /**
   * rsync option: --filter/-f
   */
  public String[] getFilter() {
    return includeExcludeSubset("F");
  }

  /**
   * rsync option: --filter/-f
   */
  public RSync filter(String... filter) {
    return addIncludeExclude("F", filter);
  }

  /**
   * Returns a subset of the include/exclude list.
   *
   * @param id the subset to retrieve (I, E, IF, EF, F for include, exclude, include-from, exclude-from, filter)
   * @return the subset
   */
  protected String[] includeExcludeSubset(String id) {
    List<String> result = new ArrayList<>();
    id = id + "\t";
    for (String ie: include_exclude) {
      if (ie.startsWith(id))
        result.add(ie.substring(id.length()));
    }
    return result.toArray(new String[0]);
  }

  /**
   * Adds a list of include/exclude items.
   *
   * @param id the subset to retrieve (I, E, IF, EF, F for include, exclude, include-from, exclude-from, filter)
   * @param list the items to add
   * @return itself
   */
  protected RSync addIncludeExclude(String id, String... list) {
    for (String l: list)
      this.include_exclude.add(id + "\t" + l);
    return this;
  }

  protected String[] getIncludeExclude() {
    return include_exclude.toArray(new String[0]);
  }

  /**
   * rsync option: --exclude
   */
  public String[] getExclude() {
    return includeExcludeSubset("E");
  }

  /**
   * rsync option: --exclude
   */
  public RSync exclude(String... exclude) {
    return addIncludeExclude("E", exclude);
  }

  /**
   * rsync option: --exclude-from
   */
  public String[] getExcludeFrom() {
    return includeExcludeSubset("EF");
  }

  /**
   * rsync option: --exclude-from
   */
  public RSync excludeFrom(String... exclude_from) {
    for (int i = 0; i < exclude_from.length; i++)
      exclude_from[i] = Binaries.convertPath(exclude_from[i]);
    return addIncludeExclude("EF", exclude_from);
  }

  /**
   * rsync option: --include
   */
  public String[] getInclude() {
    return includeExcludeSubset("I");
  }

  /**
   * rsync option: --include
   */
  public RSync include(String... include) {
    return addIncludeExclude("I", include);
  }

  /**
   * rsync option: --include-from
   */
  public String[] getIncludeFrom() {
    return includeExcludeSubset("IF");
  }

  /**
   * rsync option: --include-from
   */
  public RSync includeFrom(String... include_from) {
    for (int i = 0; i < include_from.length; i++)
      include_from[i] = Binaries.convertPath(include_from[i]);
    return addIncludeExclude("IF", include_from);
  }

  /**
   * rsync option: --files-from
   */
  public String getFilesFrom() {
    return files_from;
  }

  /**
   * rsync option: --files-from
   */
  public RSync filesFrom(String files_from) {
    this.files_from = Binaries.convertPath(files_from);
    return this;
  }

  /**
   * rsync option: --from0/-0
   */
  public boolean isFrom0() {
    return from0;
  }

  /**
   * rsync option: --from0/-0
   */
  public RSync from0(boolean from0) {
    this.from0 = from0;
    return this;
  }

  /**
   * rsync option: --protect-args/-s
   * <br>
   * NB: --secluded-args starting 3.2.6
   */
  public boolean isProtectArgs() {
    return protect_args;
  }

  /**
   * rsync option: --protect-args/-s
   * <br>
   * NB: --secluded-args starting 3.2.6
   */
  public RSync protectArgs(boolean protect_args) {
    this.protect_args = protect_args;
    return this;
  }

  /**
   * rsync option: --address
   */
  public String getAddress() {
    return address;
  }

  /**
   * rsync option: --address
   */
  public RSync address(String address) {
    this.address = address;
    return this;
  }

  /**
   * rsync option: --port
   */
  public int getPort() {
    return port;
  }

  /**
   * rsync option: --port
   */
  public RSync port(int port) {
    this.port = port;
    return this;
  }

  /**
   * rsync option: --sockopts
   */
  public String getSockopts() {
    return sockopts;
  }

  /**
   * rsync option: --sockopts
   */
  public RSync sockopts(String sockopts) {
    this.sockopts = sockopts;
    return this;
  }

  /**
   * rsync option: --blocking-io
   */
  public boolean isBlockingIO() {
    return blocking_io;
  }

  /**
   * rsync option: --blocking-io
   */
  public RSync blockingIO(boolean blocking_io) {
    this.blocking_io = blocking_io;
    return this;
  }

  /**
   * rsync option: --stats
   */
  public boolean isStats() {
    return stats;
  }

  /**
   * rsync option: --stats
   */
  public RSync stats(boolean stats) {
    this.stats = stats;
    return this;
  }

  /**
   * rsync option: --8-bit-output/-8
   */
  public boolean isEightBitOutput() {
    return eight_bit_output;
  }

  /**
   * rsync option: --8-bit-output/-8
   */
  public RSync eightBitOutput(boolean eight_bit_output) {
    this.eight_bit_output = eight_bit_output;
    return this;
  }

  /**
   * rsync option: --human-readable/-h
   */
  public boolean isHumanReadable() {
    return human_readable;
  }

  /**
   * rsync option: --human-readable/-h
   */
  public RSync humanReadable(boolean human_readable) {
    this.human_readable = human_readable;
    return this;
  }

  /**
   * rsync option: --progress
   */
  public boolean isProgress() {
    return progress;
  }

  /**
   * rsync option: --progress
   */
  public RSync progress(boolean progress) {
    this.progress = progress;
    return this;
  }

  /**
   * rsync option: --itemize-changes/-i
   */
  public boolean isItemizeChanges() {
    return itemize_changes;
  }

  /**
   * rsync option: --itemize-changes/-i
   */
  public RSync itemizeChanges(boolean itemize_changes) {
    this.itemize_changes = itemize_changes;
    return this;
  }

  /**
   * rsync option: --out-format
   */
  public String getOutFormat() {
    return out_format;
  }

  /**
   * rsync option: --out-format
   */
  public RSync outFormat(String out_format) {
    this.out_format = out_format;
    return this;
  }

  /**
   * rsync option: --log-file
   */
  public String getLogFile() {
    return log_file;
  }

  /**
   * rsync option: --log-file
   */
  public RSync logFile(String log_file) {
    this.log_file = Binaries.convertPath(log_file);
    return this;
  }

  /**
   * rsync option: --log-file-format
   */
  public String getLogFileFormat() {
    return log_file_format;
  }

  /**
   * rsync option: --log-file-format
   */
  public RSync logFileFormat(String log_file_format) {
    this.log_file_format = log_file_format;
    return this;
  }

  /**
   * rsync option: --password-file
   */
  public String getPasswordFile() {
    return password_file;
  }

  /**
   * rsync option: --password-file
   */
  public RSync passwordFile(String password_file) {
    this.password_file = Binaries.convertPath(password_file);
    return this;
  }

  /**
   * rsync option: --list-only
   */
  public boolean isListOnly() {
    return list_only;
  }

  /**
   * rsync option: --list-only
   */
  public RSync listOnly(boolean list_only) {
    this.list_only = list_only;
    return this;
  }

  /**
   * rsync option: --bwlimit
   */
  public String getBwlimit() {
    return bwlimit;
  }

  /**
   * rsync option: --bwlimit
   */
  public RSync bwlimit(String bwlimit) {
    this.bwlimit = bwlimit;
    return this;
  }

  /**
   * rsync option: --outbuf
   */
  public char getOutbuf() {
    return outbuf;
  }

  /**
   * rsync option: --outbuf
   */
  public RSync outbuf(char outbuf) {
    this.outbuf = outbuf;
    return this;
  }

  /**
   * rsync option: --write-batch
   */
  public String getWriteBatch() {
    return write_batch;
  }

  /**
   * rsync option: --write-batch
   */
  public RSync writeBatch(String write_batch) {
    this.write_batch = Binaries.convertPath(write_batch);
    return this;
  }

  /**
   * rsync option: --only-write-batch
   */
  public String getOnlyWriteBatch() {
    return only_write_batch;
  }

  /**
   * rsync option: --only-write-batch
   */
  public RSync onlyWriteBatch(String only_write_batch) {
    this.only_write_batch = Binaries.convertPath(only_write_batch);
    return this;
  }

  /**
   * rsync option: --read-batch
   */
  public String getReadBatch() {
    return read_batch;
  }

  /**
   * rsync option: --read-batch
   */
  public RSync readBatch(String read_batch) {
    this.read_batch = Binaries.convertPath(read_batch);
    return this;
  }

  /**
   * rsync option: --protocol
   */
  public int getProtocol() {
    return protocol;
  }

  /**
   * rsync option: --protocol
   */
  public RSync protocol(int protocol) {
    this.protocol = protocol;
    return this;
  }

  /**
   * rsync option: --iconv
   */
  public String getIconv() {
    return iconv;
  }

  /**
   * rsync option: --iconv
   */
  public RSync iconv(String iconv) {
    this.iconv = iconv;
    return this;
  }

  /**
   * rsync option: --checksum-seed
   */
  public int getChecksumSeed() {
    return checksum_seed;
  }

  /**
   * rsync option: --checksum-seed
   */
  public RSync checksumSeed(int checksum_seed) {
    this.checksum_seed = checksum_seed;
    return this;
  }

  /**
   * rsync option: --ipv4/-4
   */
  public boolean isIpv4() {
    return ipv4;
  }

  /**
   * rsync option: --ipv4/-4
   */
  public RSync ipv4(boolean ipv4) {
    this.ipv4 = ipv4;
    return this;
  }

  /**
   * rsync option: --ipv6/-6
   */
  public boolean isIpv6() {
    return ipv6;
  }

  /**
   * rsync option: --ipv6/-6
   */
  public RSync ipv6(boolean ipv6) {
    this.ipv6 = ipv6;
    return this;
  }

  /**
   * rsync option: --version
   */
  public boolean isVersion() {
    return version;
  }

  /**
   * rsync option: --version
   */
  public RSync version(boolean version) {
    this.version = version;
    return this;
  }

  /**
   * rsync option: --trust-sender
   * @since 3.2.5
   */
  public boolean isTrustSender() {
    return trust_sender;
  }

  /**
   * rsync option: --trust-sender
   * @since 3.2.5
   */
  public RSync trustSender(boolean trust_sender) {
    this.trust_sender = trust_sender;
    return this;
  }

  /**
   * rsync option: --fsync
   * @since 3.2.4
   */
  public boolean isFsync() {
    return fsync;
  }

  /**
   * rsync option: --fsync
   * @since 3.2.4
   */
  public RSync fsync(boolean fsync) {
    this.fsync = fsync;
    return this;
  }

  /**
   * rsync option: --copy-devices
   * @since 3.2.4
   */
  public boolean isCopyDevices() {
    return copy_devices;
  }

  /**
   * rsync option: --copy-devices
   * @since 3.2.4
   */
  public RSync copyDevices(boolean copy_devices) {
    this.copy_devices = copy_devices;
    return this;
  }

  /**
   * rsync option: --stop-after
   * @since 3.2.3
   */
  public String getStopAfter() {
    return stop_after;
  }

  /**
   * rsync option: --stop-after
   * @since 3.2.3
   */
  public RSync stopAfter(String stop_after) {
    this.stop_after = stop_after;
    return this;
  }

  /**
   * rsync option: --stop-at
   * @since 3.2.3
   */
  public String getStopAt() {
    return stop_at;
  }

  /**
   * rsync option: --stop-at
   * @since 3.2.3
   */
  public RSync stopAt(String stop_at) {
    this.stop_at = stop_at;
    return this;
  }

  /**
   * rsync option: --crtimes
   * @since 3.2.3
   */
  public boolean isCrtimes() {
    return crtimes;
  }

  /**
   * rsync option: --crtimes
   * @since 3.2.3
   */
  public RSync crtimes(boolean crtimes) {
    this.crtimes = crtimes;
    return this;
  }

  /**
   * rsync option: --mkpath
   * @since 3.2.3
   */
  public boolean isMkpath() {
    return mkpath;
  }

  /**
   * rsync option: --mkpath
   * @since 3.2.3
   */
  public RSync mkpath(boolean mkpath) {
    this.mkpath = mkpath;
    return this;
  }

  /**
   * rsync option: --max-alloc
   * @since 3.2.2
   */
  public String getMaxAlloc() {
    return max_alloc;
  }

  /**
   * rsync option: --max-alloc
   * @since 3.2.2
   */
  public RSync maxAlloc(String max_alloc) {
    this.max_alloc = max_alloc;
    return this;
  }

  /**
   * rsync option: --early-input
   * @since 3.2.1
   */
  public String getEarlyInput() {
    return early_input;
  }

  /**
   * rsync option: --early-input
   * @since 3.2.1
   */
  public RSync earlyInput(String early_input) {
    this.early_input = early_input;
    return this;
  }

  /**
   * rsync option: --atimes
   * @since 3.2.0
   */
  public boolean isAtimes() {
    return atimes;
  }

  /**
   * rsync option: --atimes
   * @since 3.2.0
   */
  public RSync atimes(boolean atimes) {
    this.atimes = atimes;
    return this;
  }

  /**
   * rsync option: --open-noatime
   * @since 3.2.0
   */
  public boolean isOpenNoatime() {
    return open_noatime;
  }

  /**
   * rsync option: --open-noatime
   * @since 3.2.0
   */
  public RSync openNoatime(boolean open_noatime) {
    this.open_noatime = open_noatime;
    return this;
  }

  /**
   * rsync option: --write-devices
   * @since 3.2.0
   */
  public boolean isWriteDevices() {
    return write_devices;
  }

  /**
   * rsync option: --write-devices
   * @since 3.2.0
   */
  public RSync writeDevices(boolean write_devices) {
    this.write_devices = write_devices;
    return this;
  }

  /**
   * rsync option: --copy-as
   * @since 3.2.0
   */
  public String getCopyAs() {
    return copy_as;
  }

  /**
   * rsync option: --copy-as
   * @since 3.2.0
   */
  public RSync copyAs(String copy_as) {
    this.copy_as = copy_as;
    return this;
  }

  /**
   * rsync option: --checksum-choice
   * @since 3.1.3
   */
  public String getChecksumChoice() {
    return checksum_choice;
  }

  /**
   * rsync option: --checksum-choice
   * @since 3.1.3
   */
  public RSync checksumChoice(String checksum_choice) {
    this.checksum_choice = checksum_choice;
    return this;
  }

  public String[] getAdditional() {
    return additional;
  }

  /**
   * Automatically replaces leading "+" and "++" with corresponding "-" and "--".
   *
   * @param additional the additional parameters
   * @return itself
   */
  public RSync additional(String... additional) {
    this.additional = additional.clone();
    for (int i = 0; i < this.additional.length; i++)
      this.additional[i] = this.additional[i].replaceFirst("^[+][+]", "--").replaceFirst("^[+]", "-");
    return this;
  }

  /**
   * Sets the sshpass instance to use.
   *
   * @param value   the instance, use null to not use sshpass
   * @return        itselff
   */
  public RSync sshPass(SshPass value) {
    sshPass = value;
    return this;
  }

  /**
   * Returns the current sshpass instance in use.
   *
   * @return        the instance, null if none set
   */
  public SshPass getSshPass() {
    return sshPass;
  }

  /**
   * Assembles the arguments for the binary.
   *
   * @return		the options
   * @throws Exception	if failed to determine binary
   */
  public List<String> options() throws Exception {
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
    if (isAcls()) result.add("--acls");
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
    if (!getRsh().isEmpty()) {
      result.add("--rsh");
      if (SystemUtils.IS_OS_WINDOWS) {
        if (getRsh().equalsIgnoreCase("ssh"))
          result.add(Binaries.sshBinary());
        else
          result.add(getRsh());
      }
      else {
        result.add(getRsh());
      }
    }
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
    if (!getMaxSize().isEmpty()) result.add("--max-size=" + getMaxSize());
    if (!getMinSize().isEmpty()) result.add("--min-size=" + getMinSize());
    if (isPartial()) result.add("--partial");
    if (!getPartialDir().isEmpty()) result.add("--partial-dir=" + getPartialDir());
    if (isDelayUpdates()) result.add("--delay-updates");
    if (isPruneEmptyDirs()) result.add("--prune-empty-dirs");
    if (isNumericIds()) result.add("--numeric-ids");
    if (!getUsermap().isEmpty()) result.add("--usermap=" + getUsermap());
    if (!getGroupmap().isEmpty()) result.add("--groupmap=" + getGroupmap());
    if (!getChown().isEmpty()) result.add("--chown=" + getChown());
    if (getTimeout() > -1) result.add("--timeout=" + getTimeout());
    if (getContimeout() > -1) result.add("--contimeout=" + getContimeout());
    if (isIgnoreTimes()) result.add("--ignore-times");
    if (!getRemoteOption().isEmpty()) result.add("--remote-option=" + getRemoteOption());
    if (isSizeOnly()) result.add("--size-only");
    if (getModifyWindow() > -1) result.add("--modify-window=" + getModifyWindow());
    if (!getTempDir().isEmpty()) result.add("--temp-dir=" + getTempDir());
    if (isFuzzy()) result.add("--fuzzy");
    for (String compareDest: getCompareDest())
      result.add("--compare-dest=" + compareDest);
    for (String copyDest: getCopyDest())
      result.add("--copy-dest=" + copyDest);
    for (String linkDest: getLinkDest())
      result.add("--link-dest=" + linkDest);
    if (isCompress()) result.add("--compress");
    if (getCompressLevel() > -1) result.add("--compress-level=" + getCompressLevel());
    if (!getSkipCompress().isEmpty()) result.add("--skip-compress=" + getSkipCompress());
    if (isCvsExclude()) result.add("--cvs-exclude");
    for (String ie: getIncludeExclude()) {
      String id = ie.substring(0, ie.indexOf('\t'));
      String s = ie.substring(ie.indexOf('\t') + 1);
      switch (id) {
	case "E":
	  result.add("--exclude=" + s);
	  break;
	case "EF":
	  result.add("--exclude-from=" + s);
	  break;
	case "I":
	  result.add("--include=" + s);
	  break;
	case "IF":
	  result.add("--include-from=" + s);
	  break;
	case "F":
	  result.add("--filter=" + s);
	  break;
	default:
	  throw new IllegalStateException("Unhandled ID for include/exclude/include-from/exclude-from/filter list: " + id);
      }
    }
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
    if (!getBwlimit().isEmpty()) result.add("--bwlimit=" + getBwlimit());
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
    if (isTrustSender()) result.add("--trust-sender");
    if (isFsync()) result.add("--fsync");
    if (isCopyDevices()) result.add("--copy-devices");
    if (!getStopAfter().isEmpty()) result.add("--stop-after=" + getStopAfter());
    if (!getStopAt().isEmpty()) result.add("--stop-at=" + getStopAt());
    if (isCrtimes()) result.add("--crtimes");
    if (isMkpath()) result.add("--mkpath");
    if (!getMaxAlloc().isEmpty()) result.add("--max-alloc=" + getMaxAlloc());
    if (!getEarlyInput().isEmpty()) result.add("--early-input=" + getEarlyInput());
    if (isAtimes()) result.add("--atimes");
    if (isOpenNoatime()) result.add("--open-noatime");
    if (isWriteDevices()) result.add("--write-devices");
    if (!getCopyAs().isEmpty()) result.add("--copy-as=" + getCopyAs());
    if (!getChecksumChoice().isEmpty()) result.add("--checksum-choice=" + getChecksumChoice());
    // generic options
    if (additional != null) {
      for (String a : additional) {
	if ((a != null) && !a.isEmpty())
	  result.add(a);
      }
    }

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
    List<String>        sshPassArgs;
    int                 i;

    binary = Binaries.rsyncBinary();
    result = options();
    result.add(0, binary);
    if (getSources().size() == 0)
      throw new IllegalStateException("No source(s) defined!");
    result.addAll(getSources());
    if ((getDestination() == null) && !isListOnly())
      throw new IllegalStateException("No destination defined!");
    if (getDestination() != null)
      result.add(getDestination());

    if (getSshPass() != null) {
      sshPassArgs = getSshPass().commandLineArgs();
      for (i = sshPassArgs.size() - 1; i >= 0; i--)
        result.add(0, sshPassArgs.get(i));
    }

    return result;
  }

  /**
   * Returns a short description for the binary.
   *
   * @return		the description
   */
  @Override
  protected String description() {
    return "A fast, versatile, remote (and local) file-copying tool.\n"
      + "See man page:\n"
      + "https://linux.die.net/man/1/rsync";
  }

  /**
   * Configures and returns the commandline parser.
   *
   * @return		the parser
   */
  protected ArgumentParser getParser() {
    ArgumentParser 	parser;

    parser = super.getParser();
    parser.addArgument("-v", "--verbose")
      .dest("verbose")
      .help("increase verbosity")
      .setDefault(false)
      .action(Arguments.storeTrue());
    parser.addArgument("--info")
      .setDefault("")
      .help("fine-grained informational verbosity");
    parser.addArgument("--debug")
      .setDefault("")
      .help("fine-grained debug verbosity");
    parser.addArgument("--msgs2stderr")
      .setDefault(false)
      .dest("msgs2stderr")
      .help("special output handling for debugging")
      .action(Arguments.storeTrue());
    parser.addArgument("-q", "--quiet")
      .setDefault(false)
      .dest("quiet")
      .help("suppress non-error messages")
      .action(Arguments.storeTrue());
    parser.addArgument("--no-motd")
      .setDefault(false)
      .dest("nomotd")
      .help("suppress daemon-mode MOTD")
      .action(Arguments.storeTrue());
    parser.addArgument("-c", "--checksum")
      .setDefault(false)
      .dest("checksum")
      .help("skip based on checksum, not mod-time & size")
      .action(Arguments.storeTrue());
    parser.addArgument("-a", "--archive")
      .setDefault(false)
      .dest("archive")
      .help("archive mode; equals -rlptgoD (no -H,-A,-X)")
      .action(Arguments.storeTrue());
    parser.addArgument("-r", "--recursive")
      .setDefault(false)
      .dest("recursive")
      .help("recurse into directories")
      .action(Arguments.storeTrue());
    parser.addArgument("-R", "--relative")
      .setDefault(false)
      .dest("relative")
      .help("use relative path names")
      .action(Arguments.storeTrue());
    parser.addArgument("--no-implied-dirs")
      .setDefault(false)
      .dest("noimplieddirs")
      .help("use relative path names")
      .action(Arguments.storeTrue());
    parser.addArgument("-b", "--backup")
      .setDefault(false)
      .dest("backup")
      .help("make backups (see --suffix & --backup-dir)")
      .action(Arguments.storeTrue());
    parser.addArgument("--backup-dir")
      .setDefault("")
      .dest("backupdir")
      .help("make backups into hierarchy based in DIR");
    parser.addArgument("--suffix")
      .setDefault("")
      .dest("suffix")
      .help("set backup suffix (default ~ w/o --backup-dir)");
    parser.addArgument("-u", "--update")
      .setDefault(false)
      .dest("update")
      .help("skip files that are newer on the receiver")
      .action(Arguments.storeTrue());
    parser.addArgument("--inplace")
      .setDefault(false)
      .dest("inplace")
      .help("update destination files in-place")
      .action(Arguments.storeTrue());
    parser.addArgument("--append")
      .setDefault(false)
      .dest("append")
      .help("append data onto shorter files")
      .action(Arguments.storeTrue());
    parser.addArgument("--append-verify")
      .setDefault(false)
      .dest("appendverify")
      .help("like --append, but with old data in file checksum")
      .action(Arguments.storeTrue());
    parser.addArgument("-d", "--dirs")
      .setDefault(false)
      .dest("dirs")
      .help("transfer directories without recursing")
      .action(Arguments.storeTrue());
    parser.addArgument("-l", "--links")
      .setDefault(false)
      .dest("links")
      .help("copy symlinks as symlinks")
      .action(Arguments.storeTrue());
    parser.addArgument("-L", "--copy-links")
      .setDefault(false)
      .dest("copylinks")
      .help("transform symlink into referent file/dir")
      .action(Arguments.storeTrue());
    parser.addArgument("--copy-unsafe-links")
      .setDefault(false)
      .dest("copyunsafelinks")
      .help("only \"unsafe\" symlinks are transformed")
      .action(Arguments.storeTrue());
    parser.addArgument("--safe-links")
      .setDefault(false)
      .dest("safelinks")
      .help("ignore symlinks that point outside the source tree")
      .action(Arguments.storeTrue());
    parser.addArgument("--munge-links")
      .setDefault(false)
      .dest("mungelinks")
      .help("munge symlinks to make them safer (but unusable)")
      .action(Arguments.storeTrue());
    parser.addArgument("-k", "--copy-dirlinks")
      .setDefault(false)
      .dest("copydirlinks")
      .help("transform symlink to a dir into referent dir")
      .action(Arguments.storeTrue());
    parser.addArgument("-K", "--keep-dirlinks")
      .setDefault(false)
      .dest("keepdirlinks")
      .help("treat symlinked dir on receiver as dir")
      .action(Arguments.storeTrue());
    parser.addArgument("-H", "--hard-links")
      .setDefault(false)
      .dest("hardlinks")
      .help("preserve hard links")
      .action(Arguments.storeTrue());
    parser.addArgument("-p", "--perms")
      .setDefault(false)
      .dest("perms")
      .help("preserve permissions")
      .action(Arguments.storeTrue());
    parser.addArgument("-E", "--executability")
      .setDefault(false)
      .dest("executability")
      .help("preserve the file's executability")
      .action(Arguments.storeTrue());
    parser.addArgument("--chmod")
      .setDefault("")
      .dest("chmod")
      .help("affect file and/or directory permissions");
    parser.addArgument("-X", "--xattrs")
      .setDefault(false)
      .dest("xattrs")
      .help("preserve extended attributes")
      .action(Arguments.storeTrue());
    parser.addArgument("-o", "--owner")
      .setDefault(false)
      .dest("owner")
      .help("preserve owner (super-user only)")
      .action(Arguments.storeTrue());
    parser.addArgument("-g", "--group")
      .setDefault(false)
      .dest("group")
      .help("preserve group")
      .action(Arguments.storeTrue());
    parser.addArgument("--devices")
      .setDefault(false)
      .dest("devices")
      .help("preserve device files (super-user only)")
      .action(Arguments.storeTrue());
    parser.addArgument("--specials")
      .setDefault(false)
      .dest("specials")
      .help("preserve special files")
      .action(Arguments.storeTrue());
    parser.addArgument("-t", "--times")
      .setDefault(false)
      .dest("times")
      .help("preserve modification times")
      .action(Arguments.storeTrue());
    parser.addArgument("-O", "--omit-dir-times")
      .setDefault(false)
      .dest("omitdirtimes")
      .help("omit directories from --times")
      .action(Arguments.storeTrue());
    parser.addArgument("-J", "--omit-link-times")
      .setDefault(false)
      .dest("omitlinktimes")
      .help("omit symlinks from --times")
      .action(Arguments.storeTrue());
    parser.addArgument("--super")
      .setDefault(false)
      .dest("super_")
      .help("receiver attempts super-user activities")
      .action(Arguments.storeTrue());
    parser.addArgument("--fake-super")
      .setDefault(false)
      .dest("fakesuper")
      .help("store/recover privileged attrs using xattrs")
      .action(Arguments.storeTrue());
    parser.addArgument("-S", "--sparse")
      .setDefault(false)
      .dest("sparse")
      .help("handle sparse files efficiently")
      .action(Arguments.storeTrue());
    parser.addArgument("--preallocate")
      .setDefault(false)
      .dest("preallocate")
      .help("allocate dest files before writing them")
      .action(Arguments.storeTrue());
    parser.addArgument("-n", "--dry-run")
      .setDefault(false)
      .dest("dryrun")
      .help("perform a trial run with no changes made")
      .action(Arguments.storeTrue());
    parser.addArgument("-W", "--whole-file")
      .setDefault(false)
      .dest("wholefile")
      .help("copy files whole (without delta-xfer algorithm)")
      .action(Arguments.storeTrue());
    parser.addArgument("-x", "--one-file-system")
      .setDefault(false)
      .dest("onefilesystem")
      .help("don't cross filesystem boundaries")
      .action(Arguments.storeTrue());
    parser.addArgument("-B", "--block-size")
      .setDefault("")
      .dest("blocksize")
      .help("force a fixed checksum block-size");
    parser.addArgument("-e", "--rsh")
      .setDefault("")
      .dest("rsh")
      .help("specify the remote shell to use.\n"
	+ "On Windows, use 'ssh' to use built-in ssh binary; otherwise use absolute path, eg 'C:\\somewhere\\ssh' or '/usr/bin/ssh'.\n"
	+ "Uses plain protocol if left empty.");
    parser.addArgument("--rsync-path")
      .setDefault("")
      .dest("rsyncpath")
      .help("specify the rsync to run on the remote machine");
    parser.addArgument("--existing")
      .setDefault(false)
      .dest("existing")
      .help("skip creating new files on receiver")
      .action(Arguments.storeTrue());
    parser.addArgument("--ignore-existing")
      .setDefault(false)
      .dest("ignoreexisting")
      .help("skip updating files that already exist on receiver")
      .action(Arguments.storeTrue());
    parser.addArgument("--remove-source-files")
      .setDefault(false)
      .dest("removesourcefiles")
      .help("sender removes synchronized files (non-dirs)")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete")
      .setDefault(false)
      .dest("delete")
      .help("delete extraneous files from destination dirs")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-before")
      .setDefault(false)
      .dest("deletebefore")
      .help("receiver deletes before transfer, not during")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-during")
      .setDefault(false)
      .dest("deleteduring")
      .help("receiver deletes during the transfer")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-delay")
      .setDefault(false)
      .dest("deletedelay")
      .help("find deletions during, delete after")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-after")
      .setDefault(false)
      .dest("deleteafter")
      .help("receiver deletes after transfer, not during")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-excluded")
      .setDefault(false)
      .dest("deleteexcluded")
      .help("also delete excluded files from destination dirs")
      .action(Arguments.storeTrue());
    parser.addArgument("--ignore-missing-args")
      .setDefault(false)
      .dest("ignoremissingargs")
      .help("ignore missing source args without error")
      .action(Arguments.storeTrue());
    parser.addArgument("--delete-missing-args")
      .setDefault(false)
      .dest("deletemissingargs")
      .help("delete missing source args from destination")
      .action(Arguments.storeTrue());
    parser.addArgument("--ignore-errors")
      .setDefault(false)
      .dest("ignoreerrors")
      .help("delete even if there are I/O errors")
      .action(Arguments.storeTrue());
    parser.addArgument("--force")
      .setDefault(false)
      .dest("force")
      .help("force deletion of directories even if not empty")
      .action(Arguments.storeTrue());
    parser.addArgument("--max-delete")
      .setDefault(-1)
      .type(Integer.class)
      .dest("maxdelete")
      .help("don't delete more than NUM files");
    parser.addArgument("--max-size")
      .setDefault("")
      .dest("maxsize")
      .help("don't transfer any file larger than SIZE");
    parser.addArgument("--min-size")
      .setDefault("")
      .dest("minsize")
      .help("don't transfer any file smaller than SIZE");
    parser.addArgument("--partial")
      .setDefault(false)
      .dest("partial")
      .help("keep partially transferred files")
      .action(Arguments.storeTrue());
    parser.addArgument("--partial-dir")
      .setDefault(false)
      .dest("partialdir")
      .help("put a partially transferred file into DIR");
    parser.addArgument("--delay-updates")
      .setDefault(false)
      .dest("delayupdates")
      .help("put all updated files into place at transfer's end")
      .action(Arguments.storeTrue());
    parser.addArgument("-m", "--prune-empty-dirs")
      .setDefault(false)
      .dest("pruneemptydirs")
      .help("prune empty directory chains from the file-list")
      .action(Arguments.storeTrue());
    parser.addArgument("--numeric-ids")
      .setDefault(false)
      .dest("numericids")
      .help("don't map uid/gid values by user/group name")
      .action(Arguments.storeTrue());
    parser.addArgument("--usermap")
      .setDefault("")
      .dest("usermap")
      .help("custom username mapping");
    parser.addArgument("--groupmap")
      .setDefault("")
      .dest("groupmap")
      .help("custom groupname mapping");
    parser.addArgument("--chown")
      .setDefault("")
      .dest("chown")
      .help("simple username/groupname mapping");
    parser.addArgument("--timeout")
      .setDefault(-1)
      .type(Integer.class)
      .dest("timeout")
      .help("set I/O timeout in seconds");
    parser.addArgument("--contimeout")
      .setDefault(-1)
      .type(Integer.class)
      .dest("contimeout")
      .help("set daemon connection timeout in seconds");
    parser.addArgument("-I", "--ignore-times")
      .setDefault(false)
      .dest("ignoretimes")
      .help("don't skip files that match in size and mod-time")
      .action(Arguments.storeTrue());
    parser.addArgument("-M", "--remote-option")
      .setDefault("")
      .dest("remoteoption")
      .help("send OPTION to the remote side only");
    parser.addArgument("--size-only")
      .setDefault(false)
      .dest("sizeonly")
      .help("skip files that match in size")
      .action(Arguments.storeTrue());
    parser.addArgument("--modify-window")
      .setDefault(-1)
      .type(Integer.class)
      .dest("modifywindow")
      .help("compare mod-times with reduced accuracy");
    parser.addArgument("-T", "--temp-dir")
      .setDefault("")
      .dest("tempdir")
      .help("create temporary files in directory DIR");
    parser.addArgument("-y", "--fuzzy")
      .setDefault(false)
      .dest("fuzzy")
      .help("find similar file for basis if no dest file")
      .action(Arguments.storeTrue());
    parser.addArgument("--compare-dest")
      .setDefault(new ArrayList<String>())
      .dest("comparedest")
      .action(Arguments.append())
      .help("also compare destination files relative to DIR");
    parser.addArgument("--copy-dest")
      .setDefault(new ArrayList<String>())
      .dest("copydest")
      .action(Arguments.append())
      .help("... and include copies of unchanged files");
    parser.addArgument("--link-dest")
      .setDefault(new ArrayList<String>())
      .dest("linkdest")
      .action(Arguments.append())
      .help("hardlink to files in DIR when unchanged");
    parser.addArgument("-z", "--compress")
      .setDefault(false)
      .dest("compress")
      .help("compress file data during the transfer")
      .action(Arguments.storeTrue());
    parser.addArgument("--compress-level")
      .setDefault(-1)
      .type(Integer.class)
      .dest("compresslevel")
      .help("explicitly set compression level");
    parser.addArgument("--skip-compress")
      .setDefault("")
      .dest("skipcompress")
      .help("skip compressing files with a suffix in LIST");
    parser.addArgument("-C", "--cvs-exclude")
      .setDefault(false)
      .dest("cvsexclude")
      .help("auto-ignore files the same way CVS does")
      .action(Arguments.storeTrue());
    parser.addArgument("-f", "--filter")
      .setDefault(new ArrayList<String>())
      .dest("filter")
      .action(Arguments.append())
      .help("add a file-filtering RULE");
    parser.addArgument("--exclude")
      .setDefault(new ArrayList<String>())
      .dest("exclude")
      .action(Arguments.append())
      .help("exclude files matching PATTERN");
    parser.addArgument("--exclude-from")
      .setDefault(new ArrayList<String>())
      .dest("excludefrom")
      .help("read exclude patterns from FILE");
    parser.addArgument("--include")
      .setDefault(new ArrayList<String>())
      .dest("include")
      .action(Arguments.append())
      .help("include files matching PATTERN");
    parser.addArgument("--include-from")
      .setDefault(new ArrayList<String>())
      .dest("includefrom")
      .help("read include patterns from FILE");
    parser.addArgument("--files-from")
      .setDefault("")
      .dest("filesfrom")
      .help("read list of source-file names from FILE");
    parser.addArgument("-0", "--from0")
      .setDefault(false)
      .dest("from0")
      .help("all *-from/filter files are delimited by 0s")
      .action(Arguments.storeTrue());
    parser.addArgument("-s", "--protect-args")
      .setDefault(false)
      .dest("protectargs")
      .help("no space-splitting; only wildcard special-chars")
      .action(Arguments.storeTrue());
    parser.addArgument("--address")
      .setDefault("")
      .dest("address")
      .help("bind address for outgoing socket to daemon");
    parser.addArgument("--port")
      .setDefault(-1)
      .type(Integer.class)
      .dest("port")
      .help("specify double-colon alternate port number");
    parser.addArgument("--sockopts")
      .setDefault("")
      .dest("sockopts")
      .help("specify custom TCP options");
    parser.addArgument("--blocking-io")
      .setDefault(false)
      .dest("blockingio")
      .help("use blocking I/O for the remote shell")
      .action(Arguments.storeTrue());
    parser.addArgument("--stats")
      .setDefault(false)
      .dest("stats")
      .help("give some file-transfer stats")
      .action(Arguments.storeTrue());
    parser.addArgument("-8", "--8-bit-output")
      .setDefault(false)
      .dest("eightbitoutput")
      .help("leave high-bit chars unescaped in output")
      .action(Arguments.storeTrue());
    parser.addArgument("--human-readable")
      .setDefault(false)
      .dest("humanreadable")
      .help("output numbers in a human-readable format")
      .action(Arguments.storeTrue());
    parser.addArgument("--progress")
      .setDefault(false)
      .dest("progress")
      .help("show progress during transfer")
      .action(Arguments.storeTrue());
    parser.addArgument("-i", "--itemize-changes")
      .setDefault(false)
      .dest("itemizechanges")
      .help("output a change-summary for all updates")
      .action(Arguments.storeTrue());
    parser.addArgument("--out-format")
      .setDefault("")
      .dest("outformat")
      .help("output updates using the specified FORMAT");
    parser.addArgument("--log-file")
      .setDefault("")
      .dest("logfile")
      .help("log what we're doing to the specified FILE");
    parser.addArgument("--log-file-format")
      .setDefault("")
      .dest("logfileformat")
      .help("log updates using the specified FMT");
    parser.addArgument("--password-file")
      .setDefault("")
      .dest("passwordfile")
      .help("read daemon-access password from FILE");
    parser.addArgument("--list-only")
      .setDefault(false)
      .dest("listonly")
      .help("list the files instead of copying them (no target required)")
      .action(Arguments.storeTrue());
    parser.addArgument("--bwlimit")
      .setDefault("")
      .dest("bwlimit")
      .help("limit socket I/O bandwidth");
    parser.addArgument("--outbuf")
      .setDefault('\0')
      .dest("outbuf")
      .help("set output buffering to None, Line, or Block (N|L|B)");
    parser.addArgument("--write-batch")
      .setDefault("")
      .dest("writebatch")
      .help("write a batched update to FILE");
    parser.addArgument("--only-write-batch")
      .setDefault("")
      .dest("onlywritebatch")
      .help("like --write-batch but w/o updating destination");
    parser.addArgument("--read-batch")
      .setDefault("")
      .dest("readbatch")
      .help("read a batched update from FILE");
    parser.addArgument("--protocol")
      .setDefault(-1)
      .type(Integer.class)
      .dest("protocol")
      .help("force an older protocol version to be used");
    parser.addArgument("--iconv")
      .setDefault("")
      .dest("iconv")
      .help("request charset conversion of filenames");
    parser.addArgument("--checkum-seed")
      .setDefault(-1)
      .dest("checksumseed")
      .help("set block/file checksum seed (advanced)");
    parser.addArgument("-4", "--ipv4")
      .setDefault(false)
      .dest("ipv4")
      .help("prefer IPv4")
      .action(Arguments.storeTrue());
    parser.addArgument("-6", "--ipv6")
      .setDefault(false)
      .dest("ipv6")
      .help("prefer IPv6")
      .action(Arguments.storeTrue());
    parser.addArgument("--version")
      .setDefault(false)
      .dest("version")
      .help("print version number")
      .action(Arguments.storeTrue());
    parser.addArgument("--checksum-choice")
      .setDefault("auto")
      .dest("checksumchoice")
      .help("choose the checksum algorithm: auto, xxh128, xxh3, xxh64/xxhash, md5, md4, sha1, none (since 3.1.3)");
    parser.addArgument("-U", "--atimes")
      .setDefault(false)
      .dest("atimes")
      .help("preserve access (use) times (since 3.2.0)")
      .action(Arguments.storeTrue());
    parser.addArgument("--open-noatime")
      .setDefault(false)
      .dest("opennoatime")
      .help("avoid changing the atime on opened files (since 3.2.0)")
      .action(Arguments.storeTrue());
    parser.addArgument("--write-devices")
      .setDefault(false)
      .dest("writedevices")
      .help("write to devices as files, implies --inplace (since 3.2.0)")
      .action(Arguments.storeTrue());
    parser.addArgument("--copy-as")
      .setDefault("")
      .dest("copyas")
      .help("specify user & optional group for the copy 'USER[:GROUP]' (since 3.2.0)");
    parser.addArgument("--early-input")
      .setDefault("")
      .dest("earlyinput")
      .help("use FILE for daemon's early exec input (since 3.2.1)");
    parser.addArgument("--max-alloc")
      .setDefault("")
      .dest("maxalloc")
      .help("change a limit relating to memory alloc (since 3.2.2)");
    parser.addArgument("--mkpath")
      .setDefault(false)
      .dest("mkpath")
      .help("create destination's missing path components (since 3.2.3)")
      .action(Arguments.storeTrue());
    parser.addArgument("-N", "--crtimes")
      .setDefault(false)
      .dest("crtimes")
      .help("preserve create times (newness) (since 3.2.3)")
      .action(Arguments.storeTrue());
    parser.addArgument("--stop-at")
      .setDefault("")
      .dest("stopat")
      .help("stop rsync at the specified point in time 'y-m-dTh:m' (since 3.2.3)");
    parser.addArgument("--stop-after")
      .setDefault("")
      .dest("stopafter")
      .help("stop rsync after MINS minutes have elapsed (since 3.2.3)");
    parser.addArgument("--copy-devices")
      .setDefault(false)
      .dest("copydevices")
      .help("copy device contents as a regular file (since 3.2.4)")
      .action(Arguments.storeTrue());
    parser.addArgument("--fsync")
      .setDefault(false)
      .dest("fsync")
      .help("fsync every written file (since 3.2.4)")
      .action(Arguments.storeTrue());
    parser.addArgument("--trust-sender")
      .setDefault(false)
      .dest("trustsender")
      .help("trust the remote sender's file list (since 3.2.5)")
      .action(Arguments.storeTrue());
    parser.addArgument("--additional")
      .setDefault(new ArrayList<String>())
      .dest("additional")
      .action(Arguments.append())
      .help("generic option to pass on to rsync; for command-line parsing to work though, leading dashes must get replaced with '+', eg '--additional \"++exclude=*~\"'");
    parser.addArgument("source(s)/destination")
      .nargs("*")
      .help("Multiple local/remote paths (path or [user@]host:path), with the last one being the target and the others the source(s).");

    return parser;
  }

  /**
   * Sets the parsed options.
   *
   * @param ns		the parsed options
   * @return		if successfully set
   */
  protected boolean setOptions(Namespace ns) {
    boolean	result;

    result = super.setOptions(ns);
    if (!result)
      return false;

    verbose(ns.getBoolean("verbose"));
    info(ns.getString("info"));
    debug(ns.getString("debug"));
    msgs2stderr(ns.getBoolean("msgs2stderr"));
    quiet(ns.getBoolean("quiet"));
    noMotd(ns.getBoolean("nomotd"));
    checksum(ns.getBoolean("checksum"));
    archive(ns.getBoolean("archive"));
    recursive(ns.getBoolean("recursive"));
    relative(ns.getBoolean("relative"));
    noImpliedDirs(ns.getBoolean("noimplieddirs"));
    backup(ns.getBoolean("backup"));
    backupDir(ns.getString("backupdir"));
    suffix(ns.getString("suffix"));
    update(ns.getBoolean("update"));
    inplace(ns.getBoolean("inplace"));
    append(ns.getBoolean("append"));
    appendVerify(ns.getBoolean("appendverify"));
    dirs(ns.getBoolean("dirs"));
    links(ns.getBoolean("links"));
    copyLinks(ns.getBoolean("copylinks"));
    copyUnsafeLinks(ns.getBoolean("copyunsafelinks"));
    safeLinks(ns.getBoolean("safelinks"));
    mungeLinks(ns.getBoolean("mungelinks"));
    copyDirlinks(ns.getBoolean("copydirlinks"));
    keepDirlinks(ns.getBoolean("keepdirlinks"));
    hardLinks(ns.getBoolean("hardlinks"));
    perms(ns.getBoolean("perms"));
    executability(ns.getBoolean("executability"));
    chmod(ns.getString("chmod"));
    xattrs(ns.getBoolean("xattrs"));
    owner(ns.getBoolean("owner"));
    group(ns.getBoolean("group"));
    devices(ns.getBoolean("devices"));
    specials(ns.getBoolean("specials"));
    times(ns.getBoolean("times"));
    omitDirTimes(ns.getBoolean("omitdirtimes"));
    omitLinkTimes(ns.getBoolean("omitlinktimes"));
    super_(ns.getBoolean("super_"));
    fakeSuper(ns.getBoolean("fakesuper"));
    sparse(ns.getBoolean("sparse"));
    preallocate(ns.getBoolean("preallocate"));
    dryRun(ns.getBoolean("dryrun"));
    wholeFile(ns.getBoolean("wholefile"));
    oneFileSystem(ns.getBoolean("onefilesystem"));
    blockSize(ns.getString("blocksize"));
    rsh(ns.getString("rsh"));
    rsyncPath(ns.getString("rsyncpath"));
    existing(ns.getBoolean("existing"));
    ignoreExisting(ns.getBoolean("ignoreexisting"));
    removeSourceFiles(ns.getBoolean("removesourcefiles"));
    delete(ns.getBoolean("delete"));
    deleteBefore(ns.getBoolean("deletebefore"));
    deleteDuring(ns.getBoolean("deleteduring"));
    deleteDelay(ns.getBoolean("deletedelay"));
    deleteAfter(ns.getBoolean("deleteafter"));
    deleteExcluded(ns.getBoolean("deleteexcluded"));
    ignoreMissingArgs(ns.getBoolean("ignoremissingargs"));
    deleteMissingArgs(ns.getBoolean("deletemissingargs"));
    ignoreErrors(ns.getBoolean("ignoreerrors"));
    force(ns.getBoolean("force"));
    maxDelete(ns.getInt("maxdelete"));
    maxSize(ns.getString("maxsize"));
    minSize(ns.getString("minsize"));
    partial(ns.getBoolean("partial"));
    delayUpdates(ns.getBoolean("delayupdates"));
    pruneEmptyDirs(ns.getBoolean("pruneemptydirs"));
    numericIds(ns.getBoolean("numericids"));
    usermap(ns.getString("usermap"));
    groupmap(ns.getString("groupmap"));
    chown(ns.getString("chown"));
    timeout(ns.getInt("timeout"));
    contimeout(ns.getInt("contimeout"));
    ignoreTimes(ns.getBoolean("ignoretimes"));
    remoteOption(ns.getString("remoteoption"));
    sizeOnly(ns.getBoolean("sizeonly"));
    modifyWindow(ns.getInt("modifywindow"));
    tempDir(ns.getString("tempdir"));
    fuzzy(ns.getBoolean("fuzzy"));
    compareDest(ns.getList("comparedest").toArray(new String[0]));
    copyDest(ns.getList("copydest").toArray(new String[0]));
    linkDest(ns.getList("linkdest").toArray(new String[0]));
    compress(ns.getBoolean("compress"));
    compressLevel(ns.getInt("compresslevel"));
    skipCompress(ns.getString("skipcompress"));
    cvsExclude(ns.getBoolean("cvsexclude"));
    filter(ns.getList("filter").toArray(new String[0]));
    include(ns.getList("include").toArray(new String[0]));
    includeFrom(ns.getList("includefrom").toArray(new String[0]));
    exclude(ns.getList("exclude").toArray(new String[0]));
    excludeFrom(ns.getList("excludefrom").toArray(new String[0]));
    filesFrom(ns.getString("filesfrom"));
    from0(ns.getBoolean("from0"));
    protectArgs(ns.getBoolean("protectargs"));
    address(ns.getString("address"));
    port(ns.getInt("port"));
    sockopts(ns.getString("sockopts"));
    blockingIO(ns.getBoolean("blockingio"));
    stats(ns.getBoolean("stats"));
    eightBitOutput(ns.getBoolean("eightbitoutput"));
    humanReadable(ns.getBoolean("humanreadable"));
    progress(ns.getBoolean("progress"));
    itemizeChanges(ns.getBoolean("itemizechanges"));
    outFormat(ns.getString("outformat"));
    logFile(ns.getString("logfile"));
    logFileFormat(ns.getString("logfileformat"));
    passwordFile(ns.getString("passwordfile"));
    listOnly(ns.getBoolean("listonly"));
    bwlimit(ns.getString("bwlimit"));
    outbuf(ns.getString("outbuf").charAt(0));
    writeBatch(ns.getString("writebatch"));
    onlyWriteBatch(ns.getString("onlywritebatch"));
    readBatch(ns.getString("readbatch"));
    protocol(ns.getInt("protocol"));
    iconv(ns.getString("iconv"));
    checksumSeed(ns.getInt("checksumseed"));
    ipv4(ns.getBoolean("ipv4"));
    ipv6(ns.getBoolean("ipv6"));
    version(ns.getBoolean("version"));
    trustSender(ns.getBoolean("trustsender"));
    fsync(ns.getBoolean("fsync"));
    copyDevices(ns.getBoolean("copydevices"));
    stopAfter(ns.getString("stopafter"));
    stopAt(ns.getString("stopat"));
    crtimes(ns.getBoolean("crtimes"));
    mkpath(ns.getBoolean("mkpath"));
    maxAlloc(ns.getString("maxalloc"));
    earlyInput(ns.getString("earlyinput"));
    atimes(ns.getBoolean("atimes"));
    openNoatime(ns.getBoolean("opennoatime"));
    writeDevices(ns.getBoolean("writedevices"));
    copyAs(ns.getString("copyas"));
    checksumChoice(ns.getString("checksumchoice"));
    additional(ns.getList("additional").toArray(new String[0]));

    List<String> src_dest = ns.getList("source(s)/destination");
    if ((src_dest.size() < 1) && isListOnly()) {
      System.err.println("Source required!");
      return false;
    }
    if ((src_dest.size() < 2) && !isListOnly()) {
      System.err.println("Source and destination required!");
      return false;
    }
    if (!isListOnly()) {
      destination(src_dest.get(src_dest.size() - 1));
      src_dest.remove(src_dest.size() - 1);
    }
    sources(src_dest);

    return true;
  }

  /**
   * For running from the command-line.
   *
   * @param args	the arguments
   */
  public static void main(String[] args) throws Exception {
    run(new RSync(), args);
  }
}
