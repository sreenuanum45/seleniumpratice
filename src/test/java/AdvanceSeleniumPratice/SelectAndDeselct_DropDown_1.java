package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SelectAndDeselct_DropDown_1 {
    @Test
    public void method() throws IOException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        FluentWait<RemoteWebDriver>wait=new FluentWait<>(driver);
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.withTimeout(Duration.ofSeconds(20));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));
        WebElement e=driver.findElement(By.id("cars"));
        Select s=new Select(e);
        if(s.isMultiple()){
            System.out.println("multi selected drop down");

        }
        else{
            System.out.println("single selected drop down");
        }
       List<WebElement> ee= s.getOptions();
        System.out.println("size of select drop down"+ee.size());
        for(WebElement option:ee){
            System.out.println(option.getText());
        }
        Actions act=new Actions(driver);
        if(System.getProperty("os.name").contains("Windows")){
act.keyDown(Keys.CONTROL)
        .click(ee.get(1)).pause(5000).click(ee.get(2)).pause(5000).click(ee.get(3)).pause(5000).keyUp(Keys.CONTROL).build().perform();
        } else if (System.getProperty("os.mac").contains("mac")) {
            act.keyDown(Keys.COMMAND).click(ee.get(1)).pause(5000).click(ee.get(2)).pause(5000).click(ee.get(3)).pause(5000).keyUp(Keys.COMMAND).build().perform();
        } else if (System.getProperty("os.linux").contains("linux")) {
            act.keyDown(Keys.CONTROL).click(ee.get(1)).pause(5000).click(ee.get(2)).pause(5000).click(ee.get(3)).pause(5000).keyUp(Keys.CONTROL).build().perform();
        } else {
            System.out.println("unknow type");
            System.exit(0);
        }
       WebElement eee= s.getFirstSelectedOption();
        System.out.println(eee.getText());
      List<WebElement>webElementList=  s.getAllSelectedOptions();
      for(WebElement webElement:webElementList){
          System.out.println(webElement.getText());
      }
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']"))).click();
       /* s.deselectByIndex(1);
      s.deselectByValue("audi");
      s.deselectByVisibleText("Opel");
        s.deselectAll();*/
        for(WebElement l:webElementList){
           String ss= l.getAttribute("value");
            s.deselectByValue(ss);
        }
        driver.close();


    }
}
