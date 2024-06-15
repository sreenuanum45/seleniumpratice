package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class GmailTest_1 {
    RemoteWebDriver driver;
    @Test
    public  void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.get("https://www.gmail.com");
        driver.findElement(By.name("identifier")).sendKeys("sreenu");
        driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys("Sreenu45@");
        driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
        WebElement e1=driver.findElement(By.xpath("(//table)[6]/tbody/tr[1]/td[4]/div[1]"));
        String o1=(String) driver.executeScript("return(arguments[0].textContent);",e1);
        System.out.println(o1);
        //way-2: locate target element hierarchically
        WebElement e2=driver.findElement(By.xpath("(//table)[6]/tbody"))
                .findElement(By.xpath("child::tr[1]")) //1st mail
                .findElement(By.xpath("child::td[4]"))
                .findElement(By.xpath("child::div[1]"));
        String o2=(String) driver.executeScript("return(arguments[0].textContent);",e2);
        System.out.println(o2);
        String x[]=o2.split(",");
        System.out.println(x[0].trim()); //read/unread
        System.out.println(x[1].trim()); //"from" address
        System.out.println(x[2].trim()); //subject
        System.out.println(x[3].trim()); //attachment
        System.out.println(x[4].trim()); //Received date and time
        System.out.println(x[5].trim()); //mail body
        //Close site
        driver.close();
    }
    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
