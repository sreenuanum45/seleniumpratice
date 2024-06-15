package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GetShadowroot {
    @Test
    public void m1(){
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://books-pwakit.appspot.com");
       WebElement e= driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']")).getShadowRoot().findElement(By.id("input"));
               e .sendKeys("java", Keys.ENTER);
    }
}
