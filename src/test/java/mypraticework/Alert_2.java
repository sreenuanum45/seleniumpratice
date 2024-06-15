package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Alert_2 {
    RemoteWebDriver driver;

    @Test(priority = 1)
    public void method1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        /*WebElement e=driver.findElement(By.id("alertButton"));
        e.click();
        String s=driver.switchTo().alert().getText();
        System.out.println(s);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);*/
        driver.navigate().to("https://demoqa.com/slider");
        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        Actions sliderAction = new Actions(driver);
        sliderAction.clickAndHold(slider).moveByOffset(50, 0).release().perform();
    }
}
