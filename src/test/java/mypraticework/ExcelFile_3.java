package mypraticework;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile_3 {
    @Test
    public void  method1() throws IOException {
        HSSFWorkbook hw=new HSSFWorkbook();
        HSSFSheet hs=hw.createSheet("Test1");
        HSSFRow row=hs.createRow(0);
        HSSFCell cell= row.createCell(0);
        cell.setCellValue("sreenu");
        FileOutputStream fos=new FileOutputStream("src/test/resources/Datafiles/excelpratice1.xls");
        hw.write(fos);
        fos.close();
        hw.close();
        System.out.println("excel file created suceeesfully");

    }
}
