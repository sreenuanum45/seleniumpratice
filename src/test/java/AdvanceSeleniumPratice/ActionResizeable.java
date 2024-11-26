package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ActionResizeable {
    @Test
    public void method1() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/resizable/");
        driver.switchTo().frame(0);
        WebElement resize = driver.findElement(By.id("resizable"));
        WebElement e1=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
        //WebElement e2=driver.findElement(By.className("ui-resizable-handle ui-resizable-s"));
        WebElement e3=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
        //resize
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(e3, 100, 100).perform();
        builder.dragAndDropBy(e1, 100, 100).perform();
        builder.dragAndDropBy(e1, -100, 100).perform();
        Thread.sleep(3000);
       /* WebElement Selectable=driver.findElement(By.xpath("((//div[@id='sidebar']//ul)[1])//li[4]"));
        builder.keyDown(Keys.CONTROL).click(Selectable).keyUp(Keys.CONTROL).perform();
       // new ArrayList<String>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Selectable"*/;
    }
}
