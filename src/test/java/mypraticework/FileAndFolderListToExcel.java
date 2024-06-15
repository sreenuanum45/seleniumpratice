package mypraticework;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;

public class FileAndFolderListToExcel {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Optional: Run Chrome in headless mode

        // Create a new instance of the ChromeDriver
      RemoteWebDriver driver = new ChromeDriver(options);

        // Navigate to the folder's URL
        driver.get("src/test/resources/config.properties");

        // Create a new Excel workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        // Add headers to the Excel sheet
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Type");

        // Get a list of files and subfolders
        int rowNumber = 1;
        for (WebElement element : driver.findElements(By.xpath("//a[@href]"))) {
            String name = element.getText();
            String type = element.getAttribute("href").endsWith("/") ? "Folder" : "File";

            Row row = sheet.createRow(rowNumber);
            row.createCell(0).setCellValue(name);
            row.createCell(1).setCellValue(type);

            rowNumber++;
        }

        // Save the Excel file
        try {
            FileOutputStream outputStream = new FileOutputStream("folder_info.xlsx");
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("Folder information has been written to folder_info.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
