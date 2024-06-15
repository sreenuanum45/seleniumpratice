package mypraticework;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile_13_RowAndColoumSum {
    int nouc;

    int nour;
    @Test
    public void method1() throws IOException,NumberFormatException {

            File f = new File("src\\test\\resources\\Datafiles\\pratice4.xlsx");
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet("Sheet1");
            nour = sh.getPhysicalNumberOfRows();

            for (int i = 0; i < nour; i++) {
                int sumofrows=0;

                nouc = sh.getRow(i).getLastCellNum();
                for (int j = 0; j < nouc; j++) {
                    DataFormatter df = new DataFormatter();

                    String temp=df.formatCellValue(sh.getRow(i).getCell(j));
                    int x=(int) Integer.parseInt(temp);

                    sumofrows=sumofrows+x;
                }
                sh.getRow(i).createCell(nouc).setCellValue(sumofrows);
            }

            for (int i = 0; i < nouc; i++) {
                int sumofcolomn = 0;
                DataFormatter df = new DataFormatter();
                for (int j = 0; j < nour; j++) {
                    String temp = df.formatCellValue(sh.getRow(i).getCell(j));
                    int x = Integer.parseInt(temp);
                    sumofcolomn = sumofcolomn + x;
                }
                if (i == 0) {
                    sh.createRow(nour).createCell(i).setCellValue(sumofcolomn);
                } else {
                    sh.createRow(nouc).createCell(i).setCellValue(sumofcolomn);
                    FileOutputStream fos = new FileOutputStream(f);
                    wb.write(fos);
                    fos.close();
                }

            }


    }
}
