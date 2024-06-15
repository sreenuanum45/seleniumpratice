package mypractice_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FileUpload_1 {
    @Test
    public void method1() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
        Thread.sleep(5000);
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("E:\\caputureimages\\Screenshot 2024-01-17 191108.png");
   driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
    }
}
