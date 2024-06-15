package mypractice_utility.AdvanceSeleniumPratice;

import mypractice_utility.RangeSliderUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RangeSlidertest_1 {
    @Test
    public void method1(){
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/howto/howto_js_rangeslider.asp");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement ee=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.slider-square")));
        RangeSliderUtility Rs=new RangeSliderUtility();
    //driver.executeScript("arguments[0].value = 0; arguments[0].dispatchEvent(new Event('change'))", ee);
    Rs.setRangeSliderValue(ee,100,driver);
    System.out.println(Rs.getElementState(ee));
    }
}
