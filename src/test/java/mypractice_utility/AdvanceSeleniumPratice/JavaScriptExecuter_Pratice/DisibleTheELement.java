package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DisibleTheELement {
    @Test
    public void method() throws Exception {
        //Open browser and launch site
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.co.in");
        Thread.sleep(5000);
        WebElement e=driver.findElement(By.name("q"));
        driver.executeScript("arguments[0].style.background='pink';",e);
        driver.executeScript("arguments[0].style.border='5px dotted yellow';",e);
        driver.executeScript("arguments[0].value='kalam';",e);
        driver.executeScript("arguments[0].disabled=true;",e);
        Thread.sleep(10000);
        driver.executeScript("arguments[0].disabled=false;",e);
        driver.executeScript("arguments[0].style.background='red';",e);
        driver.executeScript("arguments[0].style.border='5px dotted blue';",e);
    }
}
