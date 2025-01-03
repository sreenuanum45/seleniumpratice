package mypraticework;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ExcelFile_14 {
    @Test
    public void method1() throws IOException {
        File ef=new File("src/test/resources/fileresultbook.xlsx");
        XSSFWorkbook wwb=new XSSFWorkbook();
        Font font=wwb.createFont();
        font.setFontHeightInPoints((short) 20);
        font.setFontName("Arial");
        font.setBold(true);
        font.setColor(IndexedColors.RED1.index);
        //cell style
        CellStyle cs=wwb.createCellStyle();
        cs.setFont(font);
        cs.setWrapText(true);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setShrinkToFit(true);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);
        cs.setFillBackgroundColor(IndexedColors.RED1.index);
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cs.setFillForegroundColor(IndexedColors.RED1.index);
        CellStyle cs1=wwb.createCellStyle();
        cs1.setFont(font);
        cs1.setWrapText(true);
        cs1.setVerticalAlignment(VerticalAlignment.CENTER);
        cs1.setShrinkToFit(true);
        cs1.setAlignment(HorizontalAlignment.CENTER);
        cs1.setBorderBottom(BorderStyle.THIN);
        cs1.setBorderLeft(BorderStyle.THIN);
        cs.setFillBackgroundColor(IndexedColors.RED1.index);
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cs.setFillForegroundColor(IndexedColors.RED1.index);
        cs.setWrapText(true);
        cs.setVerticalAlignment(VerticalAlignment.BOTTOM);
        cs.setShrinkToFit(true);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);
        Sheet sh=wwb.createSheet("Mysheet");
        Row r1=sh.createRow(0);
        Cell cell=r1.createCell(0);
        cell.setCellStyle(cs);
        r1.setHeight((short) 1000);
        r1.createCell(0).setCellValue("Name");
        r1.createCell(1).setCellValue("File/Folder");
        r1.createCell(2).setCellValue("Size");
        r1.createCell(3).setCellValue("Last modified");
        r1.createCell(4).setCellValue("Hidden");
        //Copy all files names and other details into excel sheet from 2nd row(index=1)
        File target=new File("D:\\batch264\\264pratice");
        File[] l=target.listFiles();
        int rowindex=1; //1st row(index=0) has names for columns
        for(File f:l) //take each file or folder from list/collection
        {
            //1. get name of file/folder and then store in 1st column
            sh.createRow(rowindex).createCell(0).setCellValue(f.getName());
            sh.autoSizeColumn(0);
            //2. get type and size and then store them into 2nd column and 3rd column
            if(f.isFile())
            {
                sh.getRow(rowindex).createCell(1).setCellValue("file");
                sh.autoSizeColumn(1);
                double b=f.length();
                double k=(b/1024);
                sh.getRow(rowindex).createCell(2).setCellValue(k+"KB");
                sh.autoSizeColumn(2);
            }
            else
            {
                sh.getRow(rowindex).createCell(1).setCellValue("folder");
                sh.autoSizeColumn(1);
                long b= FileUtils.sizeOfDirectory(f);
                double k=(b/1024);
                sh.getRow(rowindex).createCell(2).setCellValue(k+"KB");
                sh.autoSizeColumn(2);
            }
            //3. get last modified date and time of file/folder and then store in 4th column
            SimpleDateFormat sdf=new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss");
            sh.getRow(rowindex).createCell(3).setCellValue(sdf.format(f.lastModified()));
            sh.autoSizeColumn(3);
            //4. get the file/folder is hidden or not and store in 5th column
            if(f.isHidden())
            {
                sh.getRow(rowindex).createCell(4).setCellValue("Yes");
            }
            else
            {
                sh.getRow(rowindex).createCell(4).setCellValue("No");
            }
            sh.autoSizeColumn(4);
            rowindex++; //Mandatory to goto next row in excel sheet
        }
        //Take write permission on that file
        FileOutputStream fo=new FileOutputStream(ef);
        wwb.write(fo); //save file
        wwb.close();
        fo.close();
    }
}
