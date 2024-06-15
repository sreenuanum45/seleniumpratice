package mypractice_utility.AdvanceSeleniumPratice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebPushNotifications {
    @Test
    public void method() {
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--disable-notifications");
       System.out.println( co.getBrowserName());
        RemoteWebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com");
    }
}
