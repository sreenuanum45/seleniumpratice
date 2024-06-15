package mypraticework;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile_11 {
    @Test
    public void method1() throws IOException {
        File f = new File("src\\test\\resources\\Datafiles\\pratice1.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb= WorkbookFactory.create(fis);
        Sheet sh=wb.getSheet("Sheet1");
        int rows=sh.getPhysicalNumberOfRows();
        XSSFWorkbook xw=new XSSFWorkbook();
        XSSFSheet nsh=xw.createSheet("sheet11");
       XSSFRow r1=nsh.createRow(0);
        r1.createCell(0).setCellValue("add");
        r1.createCell(1).setCellValue("substract");
        r1.createCell(2).setCellValue("multiply");
        r1.createCell(3).setCellValue("divide");
        for(int i=1;i<rows;i++){
            DataFormatter df=new DataFormatter();
            String x=df.formatCellValue(sh.getRow(i).getCell(0));

            int a=Integer.parseInt(x);

            String y=df.formatCellValue(sh.getRow(i).getCell(1));
            int b=Integer.parseInt(y);

                nsh.createRow(i).createCell(0).setCellValue(a + b);
                nsh.getRow(i).createCell(1).setCellValue(a - b);
                nsh.getRow(i).createCell(2).setCellValue(a * b);
                nsh.getRow(i).createCell(3).setCellValue(a/b);
            File ff=new File("D:\\batch264\\264pratice\\src\\test\\resources\\Datafiles\\pratice2.xlsx");
            FileOutputStream fos=new FileOutputStream(ff);
            xw.write(fos);
            fos.close();
            fis.close();

        }
        File ff=new File("D:\\batch264\\264pratice\\src\\test\\resources\\Datafiles\\pratice2.xlsx");
        FileOutputStream fos=new FileOutputStream(ff);
        xw.write(fos);



































































    }
}
