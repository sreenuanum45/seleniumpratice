package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebElement_Attribute_Css_1 {
    RemoteWebDriver driver;
    @Test
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        WebElement e=driver.findElement(By.linkText("Gmail"));
        String x=e.getCssValue("text-decoration");
        System.out.println(x);
        Actions ac= new Actions(driver);
        ac.moveToElement(e).perform();
        String z=e.getCssValue("text-decoration");
        System.out.println(z);
        if(z.contains("underline")){
            System.out.println("test passed");
        }
        else{
            System.out.println("test falled due to underline");
        }
        driver.close();

    }
}
