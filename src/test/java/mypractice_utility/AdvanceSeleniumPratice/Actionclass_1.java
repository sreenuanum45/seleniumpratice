package mypractice_utility.AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actionclass_1 {
    @Test
    public  void method1() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://nxtgenaiacademy.com/mouseevent");
        driver.manage().window().maximize();
        Actions ac=new Actions(driver);
        WebElement e1=driver.findElement(By.id("textbox"));
        //e1.sendKeys("hi");
        ac.click(e1).sendKeys("hi").perform();


        //doubleclick
        WebElement e2= driver.findElement(By.id("dblclick"));
        ac.doubleClick(e2).perform();
        //Rightclick
        WebElement e3=driver.findElement(By.id("rightclick"));
     ac.contextClick(e3).perform();
     //draganddrop
        // Wait for the source element to be clickable
        WebElement e4 = driver.findElement(By.id("draggableElement"));
        WebElement e5 = driver.findElement(By.id("droppableElement"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", e5);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(e4));

// Wait for the target element to be present
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("droppableElement")));

// Perform the drag-and-drop operation

      /*  ac.clickAndHold(e4)
                .moveToElement(e5)
                .release(e4)
                .build();
        ac.perform();*/
        Actions actions = new Actions(driver);

        // Perform the drag and drop action
        actions.dragAndDrop(e4, e5).build().perform();


    }
}
