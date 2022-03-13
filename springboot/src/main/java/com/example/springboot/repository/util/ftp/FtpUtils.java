package com.example.springboot.repository.util.ftp;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.ftp.AbstractFtp;
import cn.hutool.extra.ftp.FtpConfig;
import cn.hutool.extra.ftp.FtpException;
import cn.hutool.extra.ftp.FtpMode;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FtpUtils extends AbstractFtp {
  public static final int DEFAULT_PORT = 21;
  private FTPClient client;
  private FtpMode mode;
  private boolean backToPwd;

  public FtpUtils(String host) {
    this(host, 21);
  }

  public FtpUtils(String host, int port) {
    this(host, port, "anonymous", "");
  }

  public FtpUtils(String host, int port, String user, String password) {
    this(host, port, user, password, CharsetUtil.CHARSET_UTF_8);
  }

  public FtpUtils(String host, int port, String user, String password, Charset charset) {
    this(host, port, user, password, charset, (FtpMode)null);
  }

  public FtpUtils(String host, int port, String user, String password, Charset charset, FtpMode mode) {
    this(new FtpConfig(host, port, user, password, charset), mode);
  }

  public FtpUtils(FtpConfig config, FtpMode mode) {
    super(config);
    this.mode = mode;
    this.init();
  }

  public FtpUtils init() {
    return this.init(this.ftpConfig, this.mode);
  }

  public FtpUtils init(String host, int port, String user, String password) {
    return this.init(host, port, user, password, (FtpMode)null);
  }

  public FtpUtils init(String host, int port, String user, String password, FtpMode mode) {
    return this.init(new FtpConfig(host, port, user, password, this.ftpConfig.getCharset()), mode);
  }

  public FtpUtils init(FtpConfig config, FtpMode mode) {
    FTPClient client = new FTPClient();
    client.setControlEncoding(config.getCharset().toString());
    client.setConnectTimeout((int)config.getConnectionTimeout());

    try {
      client.connect(config.getHost(), config.getPort());
      client.setSoTimeout((int)config.getSoTimeout());
      client.login(config.getUser(), config.getPassword());
    } catch (IOException var7) {
      throw new FtpException(var7);
    }

    int replyCode = client.getReplyCode();
    if (!FTPReply.isPositiveCompletion(replyCode)) {
      try {
        client.disconnect();
      } catch (IOException var6) {
      }

      throw new FtpException("Login failed for user [{}], reply code is: [{}]", new Object[]{config.getUser(), replyCode});
    } else {
      this.client = client;
      if (mode != null) {
        this.setMode(mode);
      }

      return this;
    }
  }

  public FtpUtils setMode(FtpMode mode) {
    this.mode = mode;
    switch(mode) {
    case Active:
      this.client.enterLocalActiveMode();
      break;
    case Passive:
      this.client.enterLocalPassiveMode();
    }

    return this;
  }

  public FtpUtils setBackToPwd(boolean backToPwd) {
    this.backToPwd = backToPwd;
    return this;
  }

  public FtpUtils reconnectIfTimeout() {
    String pwd = null;

    try {
      pwd = this.pwd();
    } catch (FtpException var3) {
    }

    return pwd == null ? this.init() : this;
  }

  public boolean cd(String directory) {
    if (StrUtil.isBlank(directory)) {
      return false;
    } else {
      try {
        return this.client.changeWorkingDirectory(directory);
      } catch (IOException var3) {
        throw new FtpException(var3);
      }
    }
  }

  public String pwd() {
    try {
      return this.client.printWorkingDirectory();
    } catch (IOException var2) {
      throw new FtpException(var2);
    }
  }

  public List<String> ls(String path) {
    FTPFile[] ftpFiles = this.lsFiles(path);
    List<String> fileNames = new ArrayList();
    FTPFile[] var4 = ftpFiles;
    int var5 = ftpFiles.length;

    for(int var6 = 0; var6 < var5; ++var6) {
      FTPFile ftpFile = var4[var6];
      fileNames.add(ftpFile.getName());
    }

    return fileNames;
  }

  public List<FTPFile> lsFiles(String path, Filter<FTPFile> filter) {
    FTPFile[] ftpFiles = this.lsFiles(path);
    if (ArrayUtil.isEmpty(ftpFiles)) {
      return ListUtil.empty();
    } else {
      List<FTPFile> result = new ArrayList(ftpFiles.length - 2 <= 0 ? ftpFiles.length : ftpFiles.length - 2);
      FTPFile[] var6 = ftpFiles;
      int var7 = ftpFiles.length;

      for(int var8 = 0; var8 < var7; ++var8) {
        FTPFile ftpFile = var6[var8];
        String fileName = ftpFile.getName();
        if (!StrUtil.equals(".", fileName) && !StrUtil.equals("..", fileName) && (null == filter || filter.accept(ftpFile))) {
          result.add(ftpFile);
        }
      }

      return result;
    }
  }

  public FTPFile[] lsFiles(String path) {
    String pwd = null;
    if (StrUtil.isNotBlank(path)) {
      pwd = this.pwd();
      this.cd(path);
    }

    FTPFile[] ftpFiles;
    try {
      ftpFiles = this.client.listFiles();
    } catch (IOException var8) {
      throw new FtpException(var8);
    } finally {
      this.cd(pwd);
    }

    return ftpFiles;
  }

  public boolean mkdir(String dir) {
    try {
      return this.client.makeDirectory(dir);
    } catch (IOException var3) {
      throw new FtpException(var3);
    }
  }

  public boolean existFile(String path) {
    FTPFile[] ftpFileArr;
    try {
      ftpFileArr = this.client.listFiles(path);
    } catch (IOException var4) {
      throw new FtpException(var4);
    }

    return ArrayUtil.isNotEmpty(ftpFileArr);
  }

  public boolean delFile(String path) {
    String pwd = this.pwd();
    String fileName = FileUtil.getName(path);
    String dir = StrUtil.removeSuffix(path, fileName);
    this.cd(dir);

    boolean isSuccess;
    try {
      isSuccess = this.client.deleteFile(fileName);
    } catch (IOException var10) {
      throw new FtpException(var10);
    } finally {
      this.cd(pwd);
    }

    return isSuccess;
  }

  public boolean delDir(String dirPath) {
    FTPFile[] dirs;
    try {
      dirs = this.client.listFiles(dirPath);
    } catch (IOException var10) {
      throw new FtpException(var10);
    }

    FTPFile[] var5 = dirs;
    int var6 = dirs.length;

    for(int var7 = 0; var7 < var6; ++var7) {
      FTPFile ftpFile = var5[var7];
      String name = ftpFile.getName();
      String childPath = StrUtil.format("{}/{}", new Object[]{dirPath, name});
      if (ftpFile.isDirectory()) {
        if (!".".equals(name) && !"..".equals(name)) {
          this.delDir(childPath);
        }
      } else {
        this.delFile(childPath);
      }
    }

    try {
      return this.client.removeDirectory(dirPath);
    } catch (IOException var9) {
      throw new FtpException(var9);
    }
  }

  public boolean upload(String destPath, File file) {
    Assert.notNull(file, "file to upload is null !", new Object[0]);
    return this.upload(destPath, file.getName(), file);
  }

  public boolean upload(String path, String fileName, File file) {
    try {
      InputStream in = FileUtil.getInputStream(file);
      Throwable var5 = null;

      boolean var6;
      try {
        var6 = this.upload(path, fileName, (InputStream)in);
      } catch (Throwable var16) {
        var5 = var16;
        throw var16;
      } finally {
        if (in != null) {
          if (var5 != null) {
            try {
              in.close();
            } catch (Throwable var15) {
              var5.addSuppressed(var15);
            }
          } else {
            in.close();
          }
        }

      }

      return var6;
    } catch (IOException var18) {
      throw new FtpException(var18);
    }
  }

  public boolean upload(String path, String fileName, InputStream fileStream) {
    try {
      this.client.setFileType(2);
    } catch (IOException var11) {
      throw new FtpException(var11);
    }

    String pwd = null;
    if (this.backToPwd) {
      pwd = this.pwd();
    }

    boolean isOk;
    if (StrUtil.isNotBlank(path)) {
      this.mkDirs(path);
      isOk = this.cd(path);
      if (!isOk) {
        return false;
      }
    }

    try {
      isOk = this.client.storeFile(fileName, fileStream);
    } catch (IOException var10) {
      throw new FtpException(var10);
    } finally {
      if (this.backToPwd) {
        this.cd(pwd);
      }

    }

    return isOk;
  }

  public void download(String path, File outFile) {
    String fileName = FileUtil.getName(path);
    String dir = StrUtil.removeSuffix(path, fileName);
    this.download(dir, fileName, outFile);
  }

  public void recursiveDownloadFolder(String sourcePath, File destDir) {
    Iterator var6 = this.lsFiles(sourcePath, (Filter)null).iterator();

    while(true) {
      String srcFile;
      File destFile;
      FTPFile ftpFile;
      label24:
      do {
        while(var6.hasNext()) {
          ftpFile = (FTPFile)var6.next();
          String fileName = ftpFile.getName();
          srcFile = StrUtil.format("{}/{}", new Object[]{sourcePath, fileName});
          destFile = FileUtil.file(destDir, fileName);
          if (!ftpFile.isDirectory()) {
            continue label24;
          }

          FileUtil.mkdir(destFile);
          this.recursiveDownloadFolder(srcFile, destFile);
        }

        return;
      } while(FileUtil.exist(destFile) && ftpFile.getTimestamp().getTimeInMillis() <= destFile.lastModified());

      this.download(srcFile, destFile);
    }
  }

  public void download(String path, String fileName, File outFile) {
    if (outFile.isDirectory()) {
      outFile = new File(outFile, fileName);
    }

    if (!outFile.exists()) {
      FileUtil.touch(outFile);
    }

    try {
      OutputStream out = FileUtil.getOutputStream(outFile);
      Throwable var5 = null;

      try {
        this.download(path, fileName, (OutputStream)out);
      } catch (Throwable var15) {
        var5 = var15;
        throw var15;
      } finally {
        if (out != null) {
          if (var5 != null) {
            try {
              out.close();
            } catch (Throwable var14) {
              var5.addSuppressed(var14);
            }
          } else {
            out.close();
          }
        }

      }

    } catch (IOException var17) {
      throw new FtpException(var17);
    }
  }

  public void download(String path, String fileName, OutputStream out) {
    String pwd = null;
    if (this.backToPwd) {
      pwd = this.pwd();
    }

    this.cd(path);

    try {
      this.client.setFileType(2);
      this.client.retrieveFile(fileName, out);
    } catch (IOException var9) {
      throw new FtpException(var9);
    } finally {
      if (this.backToPwd) {
        this.cd(pwd);
      }

    }

  }

  public FTPClient getClient() {
    return this.client;
  }

  public void close() throws IOException {
    if (null != this.client) {
      this.client.logout();
      if (this.client.isConnected()) {
        this.client.disconnect();
      }

      this.client = null;
    }

  }
}

