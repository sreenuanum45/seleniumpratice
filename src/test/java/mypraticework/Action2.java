package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Action2 {
    RemoteWebDriver driver;

    @Test(priority = 1)
    public void method1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/CSS/tryit.asp?filename=trycss_before");
        WebElement e=driver.findElement(By.id("runbtn"));
        String x1=e.getCssValue("color");
        String x2=e.getCssValue("background-color");
        System.out.println(x1);
        System.out.println(x2);
        e.click();
        String y1=e.getCssValue("color");
        String y2=e.getCssValue("background-color");
        System.out.println(x1);
        System.out.println(x2);
        if(!x1.equals(x2)&&!y1.equals(y2)){
            System.out.println("test passed colour change");
        }
        else{
            System.out.println("test falied colour not change");
        }
        String x11=e.getCssValue("color");
        String x12=e.getCssValue("background-color");
        System.out.println(x1);
        System.out.println(x2);
        Actions act=new Actions(driver);
        act.moveToElement(e).perform();
        String y11=e.getCssValue("color");
        String y12=e.getCssValue("background-color");
        System.out.println(y1);
        System.out.println(y2);
        if(!x11.equals(x12)&&!y11.equals(y12)){
            System.out.println("test passed colour change");
        }
        else{
            System.out.println("test falied colour not change");
        }
    }

}
