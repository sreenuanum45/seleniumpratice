package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebElement_GetText_4 {
    public static void main(String[] args) throws InterruptedException {
        //open browser
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        //Launch site
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
        Thread.sleep(5000);
        //"InvalidElementStateException" because we try to clear a disabled element
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.id("lname"));
       String s= e.getText();
       System.out.println(s);
        String y=(String) driver.executeScript("return(arguments[0].textcontent);",e);
        System.out.println(y);


    }
}