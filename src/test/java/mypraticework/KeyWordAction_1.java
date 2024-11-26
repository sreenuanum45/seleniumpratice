package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class KeyWordAction_1 {
    @Test
    public void keyWordAction() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Actions ac=new Actions(driver);
        Thread.sleep(10000);

        WebElement ele=driver.findElement(By.linkText("Register"));
        ac.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).build().perform();
        List<String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Register");
        driver.switchTo().defaultContent();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://demoqa.com/selectable");
    }
}
