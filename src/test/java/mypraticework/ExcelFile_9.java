package mypraticework;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ExcelFile_9 {
    @Test
    public void method1() throws IOException {

        Workbook workbook = new XSSFWorkbook();

        // Create a sheet
        Sheet sheet = workbook.createSheet("Sheet 1");

        // Create and format a cell
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("sreenu");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("peddavangara");
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.YELLOW.getIndex());
        style.setFont(font);
        cell.setCellStyle(style);
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        // Add a formula
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue(5);
        cell = row.createCell(1);
        cell.setCellValue(7);
        cell = row.createCell(2);
        cell.setCellFormula("A2+B2");

        // Save the workbook to a file
        try (FileOutputStream fos = new FileOutputStream("src/test/resources/Datafiles/Test1.xlsx")) {
            workbook.write(fos);
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read data from an existing Excel file
        try (FileInputStream fis = new FileInputStream("src/test/resources/Datafiles/Test1.xlsx")) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(0);
            cell = row.getCell(0);
            System.out.println("Read from Excel: " + cell.getStringCellValue());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add a date value
        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue(new Date());

        // Save the updated workbook
        try (FileOutputStream fos = new FileOutputStream("example.xlsx")) {
            workbook.write(fos);
            System.out.println("Excel file updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        }



