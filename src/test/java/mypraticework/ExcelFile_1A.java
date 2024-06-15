package mypraticework;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class ExcelFile_1A {
    @Test
    public void CreateXlsxFile () throws Exception

    {
        File f=new File("src/test/resources/Datafiles/exceldata.xlsx");
        FileInputStream fi=new FileInputStream(f);
        Workbook wb= WorkbookFactory.create(f);
        int nos=wb.getNumberOfSheets();
        System.out.println("number of sheets"+nos);
        for(int i=0;i<nos;i++){
            Sheet sh=wb.getSheetAt(i);
            String sheetname=sh.getSheetName();

            try{
                int numberofrows=sh.getPhysicalNumberOfRows();
                int numberofcoloums=sh.getRow(i).getLastCellNum();
                System.out.println(sheetname   +"   has  "+  numberofrows   +"in a row and "+  numberofcoloums  +"coloums");
            }catch (Exception e){
               System.out.println(e.getMessage());
            }


        }
        wb.close();
        fi.close();
    }
}
