package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Scanner;

public class RangeSliderUsingJse {
    public static void main(String[] args) {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
        wait.pollingEvery(Duration.ofMillis(500));
        wait.withTimeout(Duration.ofSeconds(20));
        driver.get("http://rangeslider.js.org/");
        Scanner sc=new Scanner(System.in);
       int x= sc.nextInt();
      sc.close();
        WebElement e=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='range'])[1]")));
       // driver.executeScript("$(arguments[0]).val("+x+").change();",e);
        driver.executeScript("$(arguments[0]).val("+x+").change();",e);
        WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#js-output")));
        int y=Integer.parseInt(e1.getText());
        if(x==y){
            System.out.println("pass");
        }
        else{
            System.out.println("fail");
        }
      //  driver.close();





    }
}
