package mypraticework;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class ExcelFile_1B {
    @Test
    public void CreateXlsFile () throws Exception
    {
        File f=new File("src//test//resources//Datafiles//exceldata.xls");
        FileInputStream fi=new FileInputStream(f);
        HSSFWorkbook hw=new HSSFWorkbook(fi);
        int nos=hw.getNumberOfSheets();
        System.out.println("number of sheets"+nos);
        for(int i=0;i<nos;i++){
            HSSFSheet sh=hw.getSheetAt(i);
            String sheetname=sh.getSheetName();
            System.out.println(sheetname);
        }
        HSSFSheet  sheet=hw.createSheet("test");
        sheet.createRow(0).createCell(0).setCellValue("naveen");
        sheet.getRow(0).createCell(1).setCellValue("india");
        try {
            //sheet.getRow(0).getCell(1);
            int numberofrows=sheet.getPhysicalNumberOfRows();
            int numberofcoloums=sheet.getRow(0).getLastCellNum();
            System.out.println(sheet   +"   has  "+  numberofrows   +"in a row and "+  numberofcoloums  +"coloums");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        hw.close();
        fi.close();

    }
}
