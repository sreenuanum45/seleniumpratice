package mypraticework;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFile_7 {
    @Test
    public void method1() throws IOException {
        File f = new File("src/test/resources/Datafiles/excelpratice1.xls");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = new HSSFWorkbookFactory().create(fis);
        Sheet sh = wb.getSheet("test2");
        int numberofrows = sh.getPhysicalNumberOfRows();
        for (int i = 0; i < numberofrows; i++) {
            DataFormatter df = new DataFormatter();
            Row r = sh.getRow(i);
            int numberOfColoumn = r.getLastCellNum();
            for (int j = 0; j < numberOfColoumn; j++) {
                String cellvalue = df.formatCellValue(r.getCell(j));
                System.out.print(cellvalue+",");
            }
            System.out.println();
        }
        fis.close();
        wb.close();
    }
}
