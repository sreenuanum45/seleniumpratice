package mypraticework;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile_6 {
    @Test
    public void method1() throws IOException {
        File f = new File("src/test/resources/Datafiles/excelpratice1.xls");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = new HSSFWorkbookFactory().create(fis);
      Sheet sh=wb.createSheet("test2");
      //create row in the  sheet
        Row r1=sh.createRow(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(FillPatternType.LEAST_DOTS);
        r1.createCell(0).setCellValue("sreenu");
        r1.createCell(1).setCellValue("peddavangara");
        Row r2=sh.createRow(1);
        r2.createCell(0).setCellValue("naveen");
        r2.createCell(1).setCellValue("hyderabad");
        Row r3=sh.createRow(2);
        r3.createCell(0).setCellValue("veeresh");
        r3.createCell(1).setCellValue("pune");
        sh.autoSizeColumn(0);
        sh.autoSizeColumn(1);
        FileOutputStream fos=new FileOutputStream(f);
        wb.write(fos);
        fos.close();
        fis.close();
        wb.close();

    }
}
