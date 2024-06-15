package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_GetText_8 {
    RemoteWebDriver driver;

    @Test
    public void method1() {
        driver.get("https://www.worldometers.info/world-population");
        WebElement e=driver.findElement(By.xpath("//span[@rel='current_population']"));
        //gettext
        String s=e.getText();
        System.out.println(s);
        String s1=(String) driver.executeScript("return(arguments[0].childNodes[0].textContent);",e);
        System.out.println(s1);


    }

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }
}
