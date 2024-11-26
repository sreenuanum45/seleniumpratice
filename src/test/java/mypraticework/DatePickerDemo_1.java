package mypraticework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePickerDemo_1 {

    @Test
    public void datePickerDemo() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        Faker faker = new Faker();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.ignoring(Exception.class);
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        String month = "July";
        String year = "2020";
        System.out.println(year);
        System.out.println(month);
        String day = String.valueOf(faker.date().birthday().getDay());
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        String ActualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String ActualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
        while (true) {
            if (ActualMonth.equals(month) && ActualYear.equals(year)) {
                break;
            }
            Thread.sleep(1000);

            driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();

                  }

    }
}
