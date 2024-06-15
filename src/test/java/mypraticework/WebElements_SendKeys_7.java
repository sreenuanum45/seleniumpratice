package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElements_SendKeys_7 {
    RemoteWebDriver driver;
@Test
public void method1() throws InterruptedException {


    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    Thread.sleep(2000);
    driver.findElement(By.name("username")).sendKeys("Admin",Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));
driver.findElement(By.name("password")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
}
    @BeforeTest
	    public void Setup() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        Thread.sleep(3000);
	        driver.manage().window().maximize();
	
	    }
}
