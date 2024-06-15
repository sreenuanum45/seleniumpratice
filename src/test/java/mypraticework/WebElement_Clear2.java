package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebElement_Clear2 {
    public static void main(String[] args) throws InterruptedException {
        //open browser
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver();
        //Launch site
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
        Thread.sleep(5000);
        //"InvalidElementStateException" because we try to clear a disabled element
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.name("lname")).clear();
    }
}
