package AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class FirefoxOptionsTest {
    @Test
    public void test() {
        //way-1: code bypassing
        //Open browser and launch site
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions fo=new FirefoxOptions();
        fo.addPreference("dom.webnotifications.enabled",false); //firefox native command as arg
        FirefoxDriver driver=new FirefoxDriver(fo);
        driver.manage().window().maximize();
        driver.get("http://www.spicejet.com");
    }
}
