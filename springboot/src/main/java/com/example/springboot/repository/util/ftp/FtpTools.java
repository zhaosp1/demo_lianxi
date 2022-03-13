package com.example.springboot.repository.util.ftp;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;

//使用hutool工具集合封装的ftp工具包
public class FtpTools {


  //根据区划获取ftp
  public static FtpUtils getFtp(String finance_code) throws Exception{
//    String ftpHost = paramConfBO.getEBankConfParam(FsiConstants.FTP_HOST, "defaultValue", finance_code);
//    String ftpPort = paramConfBO.getEBankConfParam(FsiConstants.FTP_PORT, "defaultValue", finance_code);
//    String ftpUserName = paramConfBO.getEBankConfParam(FsiConstants.FTP_USER_NAME, "defaultValue", finance_code);
//    String ftpPassword = paramConfBO.getEBankConfParam(FsiConstants.FTP_PSWD, "defaultValue", finance_code);
//    FtpUtils ftpClient = FtpTools.getFtp(ftpHost, Integer.parseInt(ftpPort), ftpUserName, ftpPassword);
    //#test
    FtpUtils ftpClient = getFtp("10.6.253.242", Integer.parseInt("21"), "alice", "20133073");
    return ftpClient;
  }
  public static FtpUtils getFtp(String host,int port,String user,String password){
    try {
      return new FtpUtils(host,port,user,password);
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("ftp连接失败！");
      return null;
    }
  }

  //自定义上传文件名
  public static void uploadFile(FtpUtils ftp,String localPath, String localFileName, String uploadFileName,String uploadPath){
    String localFile=localPath + File.separatorChar + localFileName;
    try {
      ftp.upload(uploadPath,uploadFileName, FileUtil.file(localFile));
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("ftp文件上传失败！");
    }
  }

  //默认上传文件名
  public static void uploadFile(FtpUtils ftp,String localPath, String localFileName, String uploadPath){
    String localFile=localPath + File.separatorChar + localFileName;
    try {
      ftp.upload(uploadPath, FileUtil.file(localFile));
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("ftp文件上传失败！");
    }
  }

  //默认上传文件名
  public static void uploadFile(FtpUtils ftp,String uploadPath,String localFileName) throws Exception{
    try {
      ftp.upload(uploadPath, FileUtil.file(localFileName));
    }catch (Exception e){
      throw new Exception("ftp文件上传失败，原因"+e.getMessage());
    }
  }
  //指定路径文件名下载文件名
  public static void downloadFile(FtpUtils ftp,String localPath, String localFileName, String uploadPath,String uploadFileName){
    String localFile=localPath + File.separatorChar + localFileName;
    try {
      ftp.download(uploadPath,uploadFileName, FileUtil.file(localFile));
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("ftp文件下载失败！");
    }
  }

  //指定路径下载文件
  public static void downloadFile(FtpUtils ftp,String uploadName,String localFile){
    try {
      ftp.download(uploadName, FileUtil.file(localFile));
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("ftp文件下载失败！");
    }
  }

  public static void main(String[] args) throws IOException {
    //匿名登录（无需帐号密码的FTP服务器）
    FtpUtils ftp = new FtpUtils("10.6.253.242",21,"alice","20133073");
    System.out.println(ftp.pwd());
    System.out.println(ftp.ls("./"));

    //上传本地文件
    for(int i=1;i<=5;i++){
      FtpUtils tmp=ftp;
      tmp.upload("/doubi", FileUtil.file("C:\\Users\\demo\\Desktop\\test"+i+".txt"));
    }
    //关闭连接
    ftp.close();
  }
}
