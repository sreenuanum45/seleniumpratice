package mypraticework;


import mypractice_utility.ExcelFileUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class DataDrivenTestData {

    public static void main(String[] args) throws Exception {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        String filepath="D:\\batch264\\264pratice\\src\\test\\resources\\Datafiles\\DatadrivenTestData.xlsx";
        ExcelFileUtility excelFileUtility =new ExcelFileUtility(filepath);
        for(int i=1;i<excelFileUtility.getRowsCount("Sheet1");i++){
            String intialdeposit=excelFileUtility.getCellValue(i,0,"Sheet1");
            String lengthOfCd=excelFileUtility.getCellValue(i,1,"Sheet1");
            String rate=excelFileUtility.getCellValue(i,2,"Sheet1");
            String compounding=excelFileUtility.getCellValue(i,3,"Sheet1");
            String total=excelFileUtility.getCellValue(i,4,"Sheet1");
            String expected=excelFileUtility.getCellValue(i,5,"Sheet1");
            FluentWait<RemoteWebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(1000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-0"))).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-0"))).sendKeys(intialdeposit);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-1"))).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-1"))).sendKeys(lengthOfCd);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-2"))).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-2"))).sendKeys(rate);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("mat-select-0"))).click();
            List<WebElement> list=driver.findElements(By.xpath("(//div[@role='listbox']//mat-option)//span"));
            for(int j=0;j<list.size();j++){
                if(list.get(j).getText().equals(compounding)){
                    list.get(j).click();
                    break;
                }
            }
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
           String actualTotal= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/span[@id='displayTotalValue']"))).getText();
if(total.equals(actualTotal)){
   System.out.println("pass");
   excelFileUtility.setCellData("pass",i,6,"Sheet1");
}
        }
        excelFileUtility.saveAndCloseExcel();

    }
}
