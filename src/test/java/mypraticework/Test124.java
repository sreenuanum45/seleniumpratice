package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test124
{
    @Test
    public void method() throws Exception
    {
        //Open Chrome browser
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Launch site
        driver.get("https://www.flipkart.com");
        Thread.sleep(5000);
        //close banner if exists
        try
        {
            driver.findElement(By.xpath(
                    "(//span[text()='Login'])[1]/preceding::button[1]||(//span[@role='button')||(//div/span[@role='button'])")).click();
            Thread.sleep(5000);
        }
        catch(Exception ex) {
            try {
                driver.findElement(By.xpath("//span[@role='button']")).click();
                Thread.sleep(5000);

            } catch (Exception ex1) {

            }
        }
        //click on "mobiles" link
        Thread.sleep(6000);
       WebElement ex= driver.findElement(By.xpath("//span[text()='Mobiles']"));
       driver.executeScript("arguments[0].click();",ex);
        Thread.sleep(5000);
        //click on "Shop Now" for 1st product
        driver.findElement(By.name("q")).sendKeys("realmemoblies"+ Keys.ENTER);
        Thread.sleep(5000);
        //pagination
        while(true)
        {
            //goto next page if exists by clicking on Next link
            try
            {
                driver.findElement(By.xpath("//span[text()='Next']")).click();
                Thread.sleep(3000);
            }
            catch(Exception e)
            {
                break; //terminate from loop
            }
        }
        //close site
        //driver.close();
    }
}
