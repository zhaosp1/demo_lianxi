//package servlet.yidian.servlet.report;
//
//import com.lowagie.text.Document;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.*;
//import java.io.IOException;
//
///**
// * 一点教程网 - http://www.yiidian.com
// */
//
//@WebServlet(urlPatterns = "/exportPDF")
//public class PdfServlet extends HttpServlet {
//
//  public void doGet(HttpServletRequest request, HttpServletResponse response)
//          throws ServletException, IOException {
//    try {
//      //设置响应类
//      response.setContentType("application/pdf");
//      //设置响应头，用于浏览器弹出下载提示框
//      response.setHeader("Content-disposition", "attachment;filename=yiidian.pdf");
//
//      Document document = new Document(PageSize.A4, 5, 5, 5, 5);
//
//      PdfWriter.getInstance(document, response.getOutputStream());
//      document.open();
//
//      //设置中文字体，解决中文无法显示的问题
//      BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//
//      Font titleFont = new Font(bfChinese, 10, Font.NORMAL, Color.RED);
//
//      document.add(new Paragraph("欢迎访问一点教程网学习IT教程", titleFont));
//      document.close();
//
//    } catch (Exception e) {
//      System.out.println(e);
//    }
//  }
//}