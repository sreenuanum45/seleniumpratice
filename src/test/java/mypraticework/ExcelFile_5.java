package mypraticework;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFile_5 {
    @Test
    public void method1() throws IOException {
        File f = new File("src/test/resources/Datafiles/excelpratice1.xls");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = new HSSFWorkbookFactory().create(fis);
        int nos = wb.getNumberOfSheets();
        System.out.println(nos);
        for (int i = 0; i < nos; i++) {
            Sheet sh = wb.getSheetAt(i);
            String sheetname = sh.getSheetName();
            try {
                int numberofrows = sh.getPhysicalNumberOfRows();
                int numberofcoloumns = sh.getRow(i).getLastCellNum();
                System.out.println(sheetname + " has " + numberofrows + " rows and  " + numberofcoloumns + "  coloums");
            } catch (NullPointerException e) {
               System.out.println(sheetname+"is empty");
            }

        }
    }
}
