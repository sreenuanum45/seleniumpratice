package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ActionSelectable {
    @Test
    public void method1() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/selectable/");
        Actions action = new Actions(driver);
        driver.switchTo().frame(0);
        List<WebElement> selectable = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
        System.out.println(selectable.size());
        action.keyDown(Keys.CONTROL);
        for (WebElement e : selectable) {
            action.click(e).build().perform();
        }
    action.keyUp(Keys.CONTROL).perform();
    }
}
