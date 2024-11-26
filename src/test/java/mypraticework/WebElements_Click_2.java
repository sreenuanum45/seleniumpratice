package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElements_Click_2 {
    RemoteWebDriver driver;

    @Test
    public  void method1(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
       driver.findElement(By.linkText("31")).click();
    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().browserVersion("115").driverVersion("115.0.5790.173").setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
