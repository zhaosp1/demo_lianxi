package com.example.springboot.repository.util.office.apache;//package com.example.alice.util.file;
//
//import cn.hutool.core.io.FileUtil;
//import cn.hutool.core.io.resource.ClassPathResource;
//import cn.hutool.core.io.resource.Resource;
//import com.aspose.words.*;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class Word2PdfAsposeUtil {
//
//
//  public static boolean getLicense() {
//    boolean result = false;
//    InputStream is = null;
//    try {
//      is = FileUtil.getInputStream("C:\\Users\\demo\\Desktop\\test.xml");
//      //InputStream is = Word2PdfAsposeUtil.class.getClassLoader().getResourceAsStream("license.xml"); // license.xml应放在..\WebRoot\WEB-INF\classes路径下
//      License aposeLic = new License();
//      aposeLic.setLicense(is);
//      result = true;
//    } catch (Exception e) {
//      e.printStackTrace();
//    }finally {
//      if (is != null) {
//        try {
//          is.close();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    }
//    return result;
//  }
//
//  public static boolean doc2pdf(String inPath, String outPath) {
//    if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
//      return false;
//    }
//    FileOutputStream os = null;
//    try {
//      long old = System.currentTimeMillis();
//      File file = new File(outPath); // 新建一个空白pdf文档
//      os = new FileOutputStream(file);
//      Document doc = new Document(inPath); // Address是将要被转化的word文档
//      doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,EPUB, XPS, SWF 相互转换
//      long now = System.currentTimeMillis();
//      System.out.println("pdf转换成功，共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
//    } catch (Exception e) {
//      e.printStackTrace();
//      return false;
//    }finally {
//      if (os != null) {
//        try {
//          os.flush();
//          os.close();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    }
//    return true;
//  }
//
//  public static void main(String[] arg){
//    String docPath = "E:\\Users\\alice\\Desktop\\面试题\\报表开发\\iReport中文教程.doc";
//    String pdfPath = "C:\\Users\\alice\\Desktop\\iReport中文教程.pdf";
//    Word2PdfAsposeUtil.doc2pdf(docPath,pdfPath);
//  }
//}