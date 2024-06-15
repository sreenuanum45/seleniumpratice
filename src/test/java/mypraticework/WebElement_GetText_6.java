package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_GetText_6 {
    RemoteWebDriver driver;
    @Test
    public void method1() {
        driver.get("https://www.google.co.in");
        //paried tag with text
        WebElement e=driver.findElement(By.xpath("(//div[@id='gb']/descendant::a)[1]"));
        String s=e.getText();
        System.out.println(s);
        String s2=(String) driver.executeScript("return(arguments[0].textContent);",e);
        System.out.println(s2);
        /////paried tag without text
        WebElement e1=driver.findElement(By.xpath("//textarea[@type='search']"));
        e1.sendKeys("sreenu");
        String s1=e.getText();
        System.out.println(s1);
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_hr_test");
        driver.switchTo().frame("iframeResult");


       String s3= driver.findElement(By.xpath("//h1[text()='The Main Languages of the Web']/following-sibling ::hr[1]")).getText();
       System.out.println(s3);
       driver.close();
    }
    @BeforeTest
    public void  setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }
}
