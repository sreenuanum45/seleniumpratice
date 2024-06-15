package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GetTextOfChildElements {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in");
        WebElement e=driver.findElement(By.id("SIvCob"));
        String x=e.getText();
        System.out.println(x);
        String y=(String) driver.executeScript(
                "return(arguments[0].childNodes[2].textContent);",e);
        System.out.println(y);

    }
}
