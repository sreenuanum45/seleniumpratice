package AdvanceSeleniumPratice.Capabilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Headless {
    @Test
    public void test() throws InterruptedException {
        ChromeOptions o=new ChromeOptions();
        o.setAcceptInsecureCerts(true);
        o.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        File f=new File("C:\\Users\\sreenu\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
        File f1=new File("C:\\Users\\sreenu\\Downloads\\Adblock-for-Youtube™-Chrome-Web-Store.crx");
        o.addExtensions(f,f1);
        o.addArguments("--incognito");
        //o.addArguments("--headless"); //native command as argument
        ChromeDriver driver=new ChromeDriver(o);
        Thread.sleep(5000);
        driver.get("http://www.google.co.in");
        Thread.sleep(5000);
        String x=driver.getTitle();
        System.out.println(x);
       String y= driver.getCurrentUrl();
       System.out.println(y);
       driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
       // driver.close();
    }
}
