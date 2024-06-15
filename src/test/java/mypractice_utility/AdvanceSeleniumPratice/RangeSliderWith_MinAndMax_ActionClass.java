package mypractice_utility.AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Scanner;

public class RangeSliderWith_MinAndMax_ActionClass {
    public static void main(String[] args) {
        //Range slider with min and max both will be changed from left to right
        //Take value from keyboard
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter min value as >75");
        int min = sc.nextInt(); //99
        System.out.println("Enter max value as >300");
        int max = sc.nextInt(); //349
        sc.close();
        //Open browser and launch site
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
        wait.pollingEvery(Duration.ofMillis(500));
        wait.withTimeout(Duration.ofSeconds(20));
        driver.get("https://jqueryui.com/slider/#range");
        driver.switchTo().frame(0);
        WebElement minSlider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='slider-range']/span[1]")));
        Actions ac = new Actions(driver);
        ac.clickAndHold(minSlider).perform();
        while (true) {
            WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p>#amount")));
            String s = e1.getAttribute("value");
            System.out.println(s);
            if (s.contains("$" + min)) {
                ac.release(minSlider).perform();
                break;
            } else {
                ac.sendKeys(Keys.LEFT).perform();
            }
        }
        WebElement maxslider=wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='slider-range']/span[2]")));

        while (true){
            WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p>#amount")));
            String s1=e1.getAttribute("value");
            System.out.println(s1);
            if(s1.contains("-$"+max)){

                break;
            }
            else {
                ac.dragAndDropBy(maxslider, -1, 0).perform();
            }
        }

    }
}
