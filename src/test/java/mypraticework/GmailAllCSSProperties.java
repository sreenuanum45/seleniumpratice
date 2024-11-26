package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CSSProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GmailAllCSSProperties
{
    @Test
    public void method() throws Exception
    {
        //open browser
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver();
        //Launch site(operation)
        driver.get("https://www.gmail.com");
        Thread.sleep(5000);
        //Locate element
        WebElement e=driver.findElement(By.xpath("//button[text()='Forgot email?']"));
        // 1. Get all attributes and properties of the element via the console tab in the inspect window
        // 2. Get all CSS properties of the element via the styles tab in inspect or via the below code
        CSSProperties cp = new CSSProperties();;
// System.out.println(cp.getCSSPropertiesNames(e, driver));
        System.out.println(cp.getCSSPropertiesValues(e, driver));
 driver.close();
    }
}
