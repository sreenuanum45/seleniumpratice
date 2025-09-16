import mypractice_utility.DataPicker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.rmi.Remote;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConvertKit_1 {
    @Test
    public void Test1() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        DataPicker dataPicker=new DataPicker();
        FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(1));
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
       driver.get("https://app.kit.com/");
        driver.findElement(By.id("user_email")).sendKeys("sreenua@onlightenmedia.onmicrosoft.com");
        driver.findElement(By.id("user_password")).sendKeys("!OnlightenMedia05!");
        driver.findElement(By.id("user_log_in")).click();
        driver.findElement(By.xpath("//button[text()='Re-send Email']"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.microsoft.com/en-us/microsoft-365/outlook/log-in");
  driver.findElement(By.xpath("(//a[text()=' Sign in '])[1]")).click();
  Set<String> sl=driver.getWindowHandles();
        List<String>ls=new ArrayList<>(sl);
        driver.switchTo().window(ls.get(2));
        driver.findElement(By.name("loginfmt")).sendKeys("sreenua@onlightenmedia.onmicrosoft.com");
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(2000);
driver.findElement(By.name("passwd")).sendKeys("Veeru8080@");
Thread.sleep(2000);
WebElement signinlink=driver.findElement(By.xpath("//input[@type='submit']"));
signinlink.click();
WebElement signbutton=driver.findElement(By.id("idSIButton9"));
try {
    driver.executeScript("arguments[0].click();", signbutton);
}catch (StaleElementReferenceException e){
    wait.until(ExpectedConditions.elementToBeClickable(signbutton)).click();
}
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='MailList']/div/div/div/div/div/div/div"));
      driver.findElement(By.xpath("//*[@id='MailList']/div/div/div/div/div/div/div/div[2]")).click();
driver.findElement(By.xpath("(//table[@role='presentation'])[1]"));
Thread.sleep(2000);
driver.findElement(By.linkText("Trust this device")).click();

Thread.sleep(5000);
        Set<String> totaltabs=driver.getWindowHandles();
        List<String>totaltabsfromSet=new ArrayList<>(totaltabs);
        System.out.println("Total tabs are"+totaltabsfromSet.size());
driver.switchTo().window(totaltabsfromSet.get(totaltabsfromSet.size()-1));
driver.findElement(By.xpath("//button[text()='Automate']")).click();
driver.findElement(By.xpath("/html/body/reach-portal[3]/div"));
driver.findElement(By.xpath("//div[text()='Visual Automations']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//span[text()='New automation']")).click();
Thread.sleep(2000);
driver.findElement(By.linkText("Start from scratch")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[text()='Start building']")).click();
driver.findElement(By.id("tabs--1--tab--1")).click();
WebElement selctingTag=driver.findElement(By.xpath("//div[text()='Search or create tag']"));
selctingTag.click();
//for new tag
        try {
            selctingTag.sendKeys("dddd", Keys.ENTER);
        }
        catch (ElementNotInteractableException ee){
            selctingTag=driver.findElement(By.xpath(""));
           driver.executeScript("arguments[0].scrollintoview",selctingTag);
            wait.until(ExpectedConditions.elementToBeClickable(selctingTag)).sendKeys("dddd");
        }
driver.findElement(By.xpath("//button[text()='Add Event']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//div[@class='workflow-add-button-border'])[1]")).click();
List<WebElement> headerButton=driver.findElements(By.xpath("//header//button"));
driver.findElement(By.xpath("//header//button[1]")).click();
driver.findElement(By.xpath("//button[text()='Date occurs']")).click();
WebElement selectindDateButton=driver.findElement(By.xpath("//input[@type='text']"));
selectindDateButton.clear();
selectindDateButton.sendKeys("December 25, 2025");
List<WebElement>time=driver.findElements(By.xpath("//ul//li"));
        /*WebElement dp=driver.findElement(By.className("react-datepicker"));*/

        String Expectedtime="12:15 AM";

        for(WebElement e: time){
            String t=e.getText();
            if(t.equals(Expectedtime)){
                e.click();
            }
        }
        driver.findElement(By.xpath("//footer//button[@type='button']")).click();
////div[@class='react-datepicker__month']//div[starts-with(@class,'react-datepicker__day ')]
////div[@class='react-datepicker__month']//div[starts-with(@class,'react-datepicker__day ')]

    }
}

