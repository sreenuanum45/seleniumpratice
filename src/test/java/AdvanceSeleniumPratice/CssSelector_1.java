package AdvanceSeleniumPratice;

import mypractice_utility.WebTableUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CssSelector_1 {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://selectorshub.com/xpath-practice-page/");
        WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='Close']")));
        close.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".element-companyId input[name='company']"))).sendKeys("amazon");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".element-companyId input[name='mobile number']"))).sendKeys("kalam");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']"))).sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass"))).sendKeys("b");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div>input.nameFld"))).sendKeys("sreeenu");
        //because element is disable
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.dropbtn"))).click();

        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cars")));
        Select s = new Select(e);
        if (s.isMultiple()) {
            System.out.println("multi select");
        } else {
            System.out.println("single select");
        }
        List<WebElement> optionlist = s.getOptions();
        System.out.println(optionlist.size());
        s.selectByVisibleText("Volvo");

        s.selectByIndex(1);
        List<WebElement> selectlist = s.getAllSelectedOptions();
        for (WebElement option : selectlist) {
            System.out.println("selected item:" + option.getText());
        }

        s.selectByIndex(2);
        WebElement eee = s.getWrappedElement();
        System.out.println(eee.getText());
        WebTableUtility wt = new WebTableUtility();
        WebElement tableelement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#resultTable")));
        List<WebElement>ls=wt.getHeaders(tableelement);
        System.out.println(ls.size());
   int rows=wt.getRowsCount(tableelement);
   for(int i=1;i<rows;i++){
       List<WebElement>ll=wt.getRows(tableelement);
       for(int j=0;j<ll.size();j++){
           System.out.println(ll.get(j).getText());
       }
       WebElement tabel2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]")));
       List<WebElement>lll=wt.getRows(tabel2);
       for(int j=0;j<lll.size();j++){
           for (int k=0;k<wt.getColumnsCountInRow(tabel2,j);k++){
              System.out.println(lll.get(k).getText());

           }
       }

   }



    }
}
