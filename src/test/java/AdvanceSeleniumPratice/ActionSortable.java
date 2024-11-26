package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionSortable {
    @Test

    public void method1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/sortable/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
       List<WebElement > sortable = driver.findElements(By.xpath("//ul[@id='sortable']//li"));
        Actions action = new Actions(driver);
 // sort random
    /*    for(int i=0;i<sortable.size();i++){
            action.keyDown(Keys.CONTROL).dragAndDrop(sortable.get(sortable.size()-1-i),sortable.get(i)).keyUp(Keys.CONTROL).perform();
        }*/
        for(int i=0;i<sortable.size();i++){
            action.keyDown(Keys.CONTROL).dragAndDrop(sortable.get(i),sortable.get(sortable.size()-1-i)).keyUp(Keys.CONTROL).perform();
            Thread.sleep(2000);
        }
    }
}
