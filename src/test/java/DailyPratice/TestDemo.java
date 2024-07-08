package DailyPratice;

import com.github.javafaker.Faker;

import mypractice_utility.AdvanceSeleniumPratice.SeleniumListeners.MyWebDriverListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestDemo {
   public RemoteWebDriver driver;
   public  FluentWait<RemoteWebDriver> wait;
   public Faker faker ;
  @Test(priority = 1,alwaysRun = true,invocationCount = 4)

    public void method1() throws InterruptedException {
      ChromeOptions options = new ChromeOptions();
      System.out.println();
      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
      options.setExperimentalOption("useAutomationExtension", true);
      options.addArguments("--disable-notifications");
      options.addArguments("--remote-allow-origins=*");
      options.addArguments("--disable-blink-features=AutomationControlled");
      faker = new Faker();
      driver = new ChromeDriver(options);
    MyWebDriverListener listener = new MyWebDriverListener();
    WebDriver decorated = new EventFiringDecorator<>(listener).decorate(driver);
    decorated.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    decorated.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    decorated.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
    decorated.manage().window().maximize();
    decorated.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname"))).sendKeys(faker.name().firstName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-lastname"))).sendKeys(faker.name().lastName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(faker.internet().emailAddress());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-telephone"))).sendKeys(faker.phoneNumber().phoneNumber());
        String password=faker.internet().password(6,10,true,true,true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password"))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-confirm"))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='checkbox']"))).click();
        Thread.sleep(2000);
        driver.executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[2]"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit']"))).click();
       Assert.assertEquals(driver.getTitle(),"Your Account Has Been Created!");
    decorated.close();



    }

   }

