package com.example.springboot.repository.util.office.apache;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WordUtil {
  //创建word文档
  @Test
  public void createWord(){
    XWPFDocument document = new XWPFDocument();
    try(OutputStream fileOut = new FileOutputStream("yiidian.docx")) {
      document.write(fileOut);
      System.out.println("File created");
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  //创建word段落
  @Test
  public void createParagraph(){
    XWPFDocument doc = new XWPFDocument();
    try(OutputStream os = new FileOutputStream("yiidian.doc")) {
      XWPFParagraph paragraph = doc.createParagraph();
      XWPFRun run = paragraph.createRun();
      run.setText("Hello, This is yiidian. This paragraph is written "+
        "by using XWPFParagrah.");
      doc.write(os);
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //创建word表格
  @Test
  public void createTable(){
    XWPFDocument document= new XWPFDocument();
    try(FileOutputStream out = new FileOutputStream(new File("yiidian.docx"))){
      // Creating Table
      XWPFTable tab = document.createTable();
      XWPFTableRow row = tab.getRow(0); // First row
      // Columns
      row.getCell(0).setText("Sl. No.");
      row.addNewTableCell().setText("Name");
      row.addNewTableCell().setText("Email");
      row = tab.createRow(); // Second Row
      row.getCell(0).setText("1.");
      row.getCell(1).setText("eric");
      row.getCell(2).setText("eric@gmail.com");
      row = tab.createRow(); // Third Row
      row.getCell(0).setText("2.");
      row.getCell(1).setText("jack");
      row.getCell(2).setText("jack@gmail.com");
      document.write(out);
    }catch(Exception e) {
      System.out.println(e);
    }
  }
  //创建word字体样式
  @Test
  public void createFontStyle(){
    XWPFDocument doc = new XWPFDocument();
    try(OutputStream os = new FileOutputStream("yiidian.docx")) {
      XWPFParagraph paragraph = doc.createParagraph();
      //Set Bold an Italic
      XWPFRun xr = paragraph.createRun();
      xr.setBold(true);
      xr.setItalic(true);
      xr.setText("This text is Bold and have Italic style");
      xr.addBreak();
      doc.write(os);
    }catch(Exception e) {
      System.out.println(e);
    }
  }
  //word词对齐
  @Test
  public void createAlign(){
    XWPFDocument doc = new XWPFDocument();
    try(OutputStream os = new FileOutputStream("yiidian.docx")) {
      XWPFParagraph paragraph = doc.createParagraph();
      paragraph.setAlignment(ParagraphAlignment.RIGHT);
      XWPFRun run = paragraph.createRun();
      run.setText("Text is aligned right");
      doc.write(os);
    }catch(Exception e) {
      System.out.println(e);
    }
  }
  //word提出文本
  @Test
  public void getText(){
    try(FileInputStream fis = new FileInputStream("yiidian.docx")) {
      XWPFDocument file   = new XWPFDocument(OPCPackage.open(fis));
      XWPFWordExtractor ext = new XWPFWordExtractor(file);
      System.out.println(ext.getText());
    }catch(Exception e) {
      System.out.println(e);
    }
  }

  //word提出段落
  @Test
  public void getParagraph(){
    try(FileInputStream fis = new FileInputStream("yiidian.docx")) {
      XWPFDocument doc    = new XWPFDocument(OPCPackage.open(fis));
      java.util.List<XWPFParagraph> paragraphs =  doc.getParagraphs();
      for (XWPFParagraph paragraph: paragraphs){
        System.out.println(paragraph.getText());
      }
    }catch(Exception e) {
      System.out.println(e);
    }
  }
}
