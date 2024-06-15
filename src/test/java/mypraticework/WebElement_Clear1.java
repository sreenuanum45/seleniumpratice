package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_Clear1 {
    RemoteWebDriver driver;
@Test
public void method1() throws InterruptedException {

    Thread.sleep(5000);
    driver.get("https://www.gmail.com");
    driver.findElement(By.name("identifier")).sendKeys("magnitiait");
    Thread.sleep(5000);
    //clear data in an element
    driver.findElement(By.name("identifier")).clear();
    Thread.sleep(5000);
}
    @BeforeTest
	    public void Setup() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	        Thread.sleep(3000);
	        driver.manage().window().maximize();
	
	    }
}
