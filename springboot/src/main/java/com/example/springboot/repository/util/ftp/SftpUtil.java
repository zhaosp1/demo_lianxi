package com.example.springboot.repository.util.ftp;

import cn.hutool.core.io.FileUtil;
import com.jcraft.jsch.*;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 20210427@cjy
 * sftp连接
 */
public class SftpUtil {
  

  private String userName;
  private String password;
  private int port;
  private String hostName;
  private String priKeyFile;
  private String passphrase;
  Session session = null;
  Channel channel = null;

  /**
   * @param userName
   * @param password
   * @param port
   * @param hostName
   */
  public SftpUtil(String userName, String password, int port, String hostName) {
    super();
    this.userName = userName;
    this.password = password;
    this.port = port;
    this.hostName = hostName;
  }

  /**
   * @param userName
   * @param port
   * @param hostName
   * @param priKeyFile
   * @param passphrase
   */
  public SftpUtil(String userName, int port, String hostName, String priKeyFile, String passphrase) {
    super();
    this.userName = userName;
    this.port = port;
    this.hostName = hostName;
    this.priKeyFile = priKeyFile;
    this.passphrase = passphrase;
  }

  public ChannelSftp connect() {

    JSch jsch = new JSch();
    try {
      if (port > 0) {
        session = jsch.getSession(userName, hostName, port);
      } else {
        session = jsch.getSession(userName, hostName);
      }
      if (session == null) {
        // throw new Exception("session is null");
        System.out.println("session为空");
        return null;
      }
      // 设置登陆主机的密码
      session.setPassword(password);// 设置密码
      Properties sshConfig = new Properties();
      sshConfig.put("StrictHostKeyChecking", "no");
      sshConfig.put("kex", "diffie-hellman-group1-sha1");
      session.setConfig(sshConfig);
      session.setTimeout(20000);
      session.connect();
      // 创建sftp通信通道
      channel = (Channel) session.openChannel("sftp");
      channel.connect();
      return (ChannelSftp) channel;
    } catch (JSchException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  /**
   * 密钥文件连接
   *
   * @return
   */

  public ChannelSftp priKeyConnect() {
    JSch jsch = new JSch();
    try {
      if (priKeyFile != null && !"".equals(priKeyFile)) {
        if (passphrase != null && !"".equals(passphrase)) {
          jsch.addIdentity(priKeyFile, passphrase);
        } else {
          jsch.addIdentity(priKeyFile);
        }
      }
      if (port > 0) {
        session = jsch.getSession(userName, hostName, port);
      } else {
        session = jsch.getSession(userName, hostName);
      }
      Properties config = new Properties();
      config.put("StrictHostKeyChecking", "no");
      config.put("kex", "diffie-hellman-group1-sha1");
      session.setConfig(config);
      session.setTimeout(20000);
      session.connect();
      channel = session.openChannel("sftp");
      channel.connect();
      return (ChannelSftp) channel;
    } catch (JSchException e) {
      e.getMessage();
    }
    return null;
  }

  /**
   * @param is   要上传的本地文件流
   * @param dsc  目标目录或文件，若是目录则上传的目标文件名和本地文件名一样
   * @param sftp
   * @return
   */
  public boolean upload(InputStream is, String dsc, ChannelSftp sftp) {
    try {
      sftp.put(is, dsc);
      return true;
    } catch (SftpException e) {
      return false;
    }
  }

  /**
   * @param remotedir  要上传到的目录
   * @param uploadFile 上传的文件
   * @param sftp
   * @return
   */
  public boolean upload(String remotedir, String uploadFile, ChannelSftp sftp) {
    FileInputStream fis = null;
    File file = null;
    try {
      sftp.cd(remotedir);
      file = new File(uploadFile);
      fis = new FileInputStream(file);
      sftp.put(fis, file.getName());
      return true;
    } catch (Exception e) {
      System.out.println(this.getClass().getName().toString()+"sftp文件上传失败，原因：" + e.getMessage());
    } finally {
      if (file != null)
        file = null;
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e1) {
          System.out.println(this.getClass().getName()+e1.getMessage() + ExceptionUtils.getStackTrace(e1));
        }
      }

    }
    return false;
  }

  /**
   * 上传文件
   *
   * @param remotedir  上传sftp服务器根路径
   * @param tempFloder 远程文件存储目录
   * @param uploadFile 上传文件
   * @param sftp
   * @throws Exception
   */
  public void upload(String remotedir, String tempFloder, String uploadFile, ChannelSftp sftp)
    throws Exception {
    FileInputStream fis = null;
    String sftpPath = remotedir + tempFloder;
    try {
      System.out.println(this.getClass().getName()+"sftp切换到"+sftpPath);
      sftp.cd(sftpPath);
      System.out.println(this.getClass().getName()+"sftp成功切换到"+sftpPath);
    } catch (SftpException e) {
      System.out.println(this.getClass().getName()+"sftp是失败切换到"+sftpPath);
      try {
        //目录不存在，则创建文件夹
        String[] dirs = sftpPath.split("/+|\\\\+");
        String tempPath = "";
        for (String dir : dirs) {
          if (null == dir || "".equals(dir)) {
            continue;
          }
          tempPath += "/" + dir;
          try {
             System.out.println(this.getClass().getName()+"sftp切换到"+tempPath);
            sftp.cd(tempPath);
             System.out.println(this.getClass().getName()+"sftp成功切换到"+tempPath);
          } catch (SftpException ex) {
             System.out.println(this.getClass().getName()+"sftp失败切换到"+tempPath);
             System.out.println(this.getClass().getName()+"sftp创建"+tempPath);
            sftp.mkdir(tempPath);
             System.out.println(this.getClass().getName()+"sftp成功创建"+tempPath);
            sftp.cd(tempPath);
          }
        }
      } catch (Exception e1) {
        throw new Exception("创建目录失败，原因:" + e1.getMessage());
      }
    }

    try {
      File file = new File(uploadFile);
      fis = new FileInputStream(file);
      sftp.put(fis, file.getName());
    } catch (Exception e) {
       System.out.println(this.getClass().getName()+ "文件上传失败，原因：" + e.getMessage());
      throw new Exception("文件上传失败");
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e1) {
           System.out.println(this.getClass().getName()+ e1.getMessage() + ExceptionUtils.getStackTrace(e1));
        }
      }
    }
  }

  /**
   * 下载文件
   *
   * @param directory    下载目录
   * @param downloadFile 下载的文件
   * @param saveFile     存在本地的路径
   * @param sftp
   */
  public boolean download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
    try {
      sftp.cd(directory);
      sftp.get(downloadFile, saveFile);
      return true;
    } catch (Exception e) {
       System.out.println(e.getMessage() + ExceptionUtils.getStackTrace(e));
    }
    return false;
  }

  /**
   * 删除文件
   *
   * @param directory  要删除文件所在目录
   * @param deleteFile 要删除的文件
   * @param sftp
   */
  public void delete(String directory,String tempFloder, String deleteFile, ChannelSftp sftp) {
    try {
      sftp.cd(directory+tempFloder);
      sftp.rm(FileUtil.file(deleteFile).getName());
    } catch (Exception e) {
      System.out.println(this.getClass().getName()+"远程sftp文件删除失败，原因："+e.getMessage());
    }
  }

  /**
   * 删除文件
   *
   * @param directory  要删除文件所在目录
   * @param deleteFile 要删除的文件
   * @param sftp
   */
  public void delete(String directory, String deleteFile, ChannelSftp sftp) {
    try {
      sftp.cd(directory);
      sftp.rm(deleteFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void disconnected(ChannelSftp sftp) {
    if (sftp != null) {
      try {
        sftp.getSession().disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
      sftp.disconnect();
    }
  }
}
