package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 上传接口
 * 一点教程网 - www.yiidian.com
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
  @RequestMapping("/test")
  public String getUploadPage(){
    return "upload";
  }

  @RequestMapping("/save")
  @ResponseBody
  public String upload(@RequestParam("attach") MultipartFile file) throws Exception{
    try{
      //处理文件
      System.out.println("文件原名称："+file.getOriginalFilename());
      System.out.println("文件类型："+file.getContentType());
      //保存到硬盘
      file.transferTo(new File("H:\\upload\\"+file.getOriginalFilename()));
      return "上传成功";
    }catch (Exception e){
      return "上传失败!";
    }
  }
}