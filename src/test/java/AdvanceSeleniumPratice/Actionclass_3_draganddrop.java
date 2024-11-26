package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Actionclass_3_draganddrop {
    @Test
    public void method1() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();

        List<WebElement> childs = driver.findElements(By.xpath("//li[contains(@class,'block')]"));
        Actions builder = new Actions(driver);

        for (WebElement c : childs) {

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='shoppingCart']//child::div"));
           for(int i=0;i<elements.size();i++){

               builder.dragAndDrop(c, elements.get(i)).build().perform();

           }
        }
           }
        }


