package mypraticework;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class TextFileRead_8_HardAssertion
{
    @Test(priority = 1)
    public void method1() throws IOException, InterruptedException {
        File f = new File("src\\test\\resources\\Data1.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null) {

            RemoteWebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.gmail.com");
            String data[] = line.split(",");
            driver.findElement(By.name("identifier")).sendKeys(data[0]);
            driver.findElement(By.xpath("//button//span[text()='Next']")).click();
            FluentWait<RemoteWebDriver> fwait = new FluentWait<RemoteWebDriver>(driver);
            fwait.withTimeout(Duration.ofSeconds(20));
            fwait.pollingEvery(Duration.ofSeconds(2));
            try {
                if (data[1].equalsIgnoreCase("valid") && driver.findElement(By.xpath("//div[text()='Enter your password']")).isDisplayed()) {
                    Reporter.log("valid UID Test passed");
                    Assert.assertTrue(true);
                } else if (data[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//div[text()='Couldn’t find your Google Account']")).isDisplayed()) {
                    Reporter.log("invalid UID Test falied");
                    Assert.assertTrue(true);
                } else if (data[1].equalsIgnoreCase("blank") && driver.findElement(By.xpath("//div[text()='Enter an email or phone number']")).isDisplayed()) {
                    Reporter.log("blank UID Test passed");
                    Assert.assertTrue(true);
                } else {
                    Reporter.log(data[1] + " UID Test failed");
                    //code for screenshot or video recording along with mail sending to manager
                    Assert.assertTrue(false);
                }

            } catch (Exception e) {
                Reporter.log(data[1]+" UID Test failed<br>");
                //code for screenshot or video recording along with mail sending to manager

                Assert.assertTrue(false);

            }
          //  driver.close();

        }
        br.close();
        fr.close();
    }
}
