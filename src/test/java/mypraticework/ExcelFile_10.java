package mypraticework;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;




public class ExcelFile_10 {
    @Test
    public void method1() throws IOException {
        File f=new File("src\\test\\resources\\Datafiles\\pratice1.xlsx");
        FileInputStream fis=new FileInputStream(f);
        Workbook wb=WorkbookFactory. create(fis);
        Sheet sh=wb.getSheet("sheet1");
        int rows=sh.getPhysicalNumberOfRows();
        for(int i=1;i<rows;i++)
        {
            DataFormatter df=new DataFormatter();
            String x=df.formatCellValue(sh.getRow(i).getCell(0));
            Row r=sh.getRow(i);
            int a=Integer.parseInt(x);

            String y=df.formatCellValue(sh.getRow(i).getCell(1));
            int b=Integer.parseInt(y);
            sh.getRow(i).createCell(2).setCellValue(a+b);
            sh.getRow(i).createCell(3).setCellValue(a-b);
            sh.getRow(i).createCell(4).setCellValue(a*b);
            sh.getRow(i).createCell(5).setCellValue(a/b);
            FileOutputStream fos=new FileOutputStream(f);
            wb.write(fos);


        }
    }
}
