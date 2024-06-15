package mypractice_utility.AdvanceSeleniumPratice.Capabilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class openExistingBrowser {
    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        System.out.println(driver.getTitle());
        driver.get("http://www.google.co.in");
        driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);


    }
}
