package mypraticework;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

public class ExistingExcelFile {
    @Test
    public void method1 () throws Exception

    {
        HashMap<Object,Object>hs;
        File f=new File("src/test/resources/Datafiles/exceldata.xlsx");
        FileInputStream fi=new FileInputStream(f);
        Workbook wb= WorkbookFactory.create(fi);
        Sheet sh=wb.createSheet("Test3");
        sh.createRow(0).createCell(0).setCellValue("naveen");
        sh.getRow(0).createCell(1).setCellValue("india");
        sh.createRow(1).createCell(0).setCellValue("sreenu");
        sh.getRow(1).createCell(1).setCellValue("new york");
        sh.createRow(2).createCell(0).setCellValue("veeresh");
        sh.getRow(2).createCell(1).setCellValue("china");
        sh.autoSizeColumn(0);
        sh.autoSizeColumn(1);
        FileOutputStream fos=new FileOutputStream(f);
        wb.write(fos);
        int numberofrows=sh.getPhysicalNumberOfRows();
        for(int i= 0;i<numberofrows;i++)
        {
            DataFormatter df=new DataFormatter();
            String x=df.formatCellValue(sh.getRow(i).getCell(0));
            String y=df.formatCellValue(sh.getRow(i).getCell(1));
            hs=new HashMap<>();
            hs.put(x,y);
            System.out.println(hs.entrySet());
        }
        fos.close();
        fi.close();
        wb.close();
    }
}
