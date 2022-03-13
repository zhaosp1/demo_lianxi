package com.example.springboot.repository.util.office.apache;

import com.example.springboot.repository.util.constant.CommonConstant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import javax.sql.CommonDataSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class ExcelUtil {
  //创建一个excel文本
  @Test
  public void createExcel(){
    Workbook wb = new HSSFWorkbook();
    try(OutputStream fileOut = new FileOutputStream(CommonConstant.DESKTOP+"yiidian.xls")) {
      wb.write(fileOut);
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //创建excel的页签
  @Test
  public void createSheet(){
    Workbook wb = new HSSFWorkbook();
    try  (OutputStream fileOut = new FileOutputStream("yiidian.xls")) {
      Sheet sheet1 = wb.createSheet("First Sheet");
      Sheet sheet2 = wb.createSheet("Second Sheet");
      wb.write(fileOut);
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //创建excel单元格
  @Test
  public void createCell(){
    Workbook wb = new HSSFWorkbook();
    try  (OutputStream os = new FileOutputStream("yiidian.xls")) {
      Sheet sheet = wb.createSheet("New Sheet");
      Row row     = sheet.createRow(2);
      Cell cell   = row.createCell(5);
      cell.setCellValue("一点教程网");
      wb.write(os);
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //创建日期单元格
  @Test
  public void createDateCell(){
    Workbook wb = new HSSFWorkbook();
    CreationHelper createHelper = wb.getCreationHelper();
    try(OutputStream os = new FileOutputStream("yiidian.xls")){
      Sheet sheet = wb.createSheet("New Sheet");
      Row row     = sheet.createRow(0);
      Cell cell   = row.createCell(0);
      CellStyle cellStyle = wb.createCellStyle();
      cellStyle.setDataFormat(
        createHelper.createDataFormat().getFormat("d-mmm-yy"));
      cell = row.createCell(1);
      cell.setCellValue(new Date());
      cell.setCellStyle(cellStyle);
      wb.write(os);
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) throws FileNotFoundException, IOException {
    Workbook wb = new HSSFWorkbook();
    try(OutputStream fileOut = new FileOutputStream(CommonConstant.DESKTOP+"yiidian.xls")) {
      wb.write(fileOut);
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}