package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LocateAndOperating {
    @Test
    public void method() throws Exception {
        //Open browser and launch site
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.co.in");
        Thread.sleep(5000);
driver.executeScript("document.getElementsByName('q')[0].value='bse sensex';");
        WebElement e=driver.findElement(By.name("q"));
        driver.executeScript("arguments[0].value='kalam';",e);
        driver.executeScript("arguments[0].style.background='green';",e);
        driver.executeScript("arguments[0].style.border='5px dotted blue';",e);
       driver.executeScript("document.getElementsByClassName('gNO89b')[0].click();");
        //driver.executeScript("document.getElementsByName('btnK')[0].click();");

    }
}
