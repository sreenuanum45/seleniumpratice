package mypraticework;

import mypractice_utility.CSSPropertiesList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class pratice1 {
    @Test
    public  void merhod1(){
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        WebElement e= driver.findElement(By.name("q"));
        CSSPropertiesList cs=new CSSPropertiesList();
        System.out.println(cs.cssPropertiesOfEachElement(e,driver));

    }
}
