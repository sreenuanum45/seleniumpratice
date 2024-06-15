package mypraticework;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile_12 {
    @Test
    public void method1() throws IOException, InvalidFormatException {
        File f = new File("src\\test\\resources\\Datafiles\\pratice3.xlsx");
        XSSFWorkbook xw;

        if (f.exists()) {
            // If the file exists, load the existing workbook
            xw = new XSSFWorkbook();
        } else {
            // If the file doesn't exist, create a new workbook
            xw = new XSSFWorkbook();
        }

        Sheet sh = xw.getSheet("Sheet1");
        if (sh == null) {
            sh = xw.createSheet("Sheet1");
        }
     Font ff= xw.createFont();
        ff.setFontHeightInPoints((short) 10);
        ff.setColor(IndexedColors.BROWN.getIndex());
        ff.setFontName("Arial");
        ff.setItalic(true);
        CellStyle cellStyle = xw.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
       cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
cellStyle.getFillBackgroundColorColor();
        Cell cell = sh.createRow(0).createCell(0);
        Cell cell1 = sh.getRow(0).createCell(1);

        cell.setCellValue("hi");
        cell1.setCellValue("hello");
        cellStyle.setFont(ff);
        cell.setCellStyle(cellStyle);
        cell1.setCellStyle(cellStyle);

        sh.autoSizeColumn(0);
        sh.autoSizeColumn(1);

        FileOutputStream fos = new FileOutputStream(f);
        xw.write(fos);
        fos.close();
    }
}
