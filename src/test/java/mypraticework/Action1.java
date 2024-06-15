package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Action1 {
    RemoteWebDriver driver;

    @Test(priority = 1)
    public void method1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        WebElement e=driver.findElement(By.name("q"));
        String s=e.getCssValue("overflow-x");
        System.out.println(s);
        Actions act=new Actions(driver);
        act.moveToElement(e).perform();
        String z=e.getCssValue("overflow-x");
        System.out.println(z);
        if(z.contains("hidden")){
            System.out.println("test passed");
        }
        else{
            System.out.println("it is not hidden");
        }
        driver.close();
    }
}
