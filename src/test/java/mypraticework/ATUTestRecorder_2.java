package mypraticework;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ATUTestRecorder_2 {
    ATUTestRecorder atu;
    Date d;
    RemoteWebDriver driver;
    SimpleDateFormat sf;
    @Test(priority = 2)
    public void launchbrowser() throws ATUTestRecorderException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.myntra.com/");
        Actions ac=new Actions(driver);
        WebElement e1= driver.findElement(By.linkText("Men"));
        ac.moveToElement(e1);

    }
    @Test(priority = 1)
    public void startRecording() throws ATUTestRecorderException {
sf=new SimpleDateFormat("dd-MMM-YYY-hh-ss");
d=new Date();
String vp="target//"+sf.format(d);
atu=new ATUTestRecorder(vp,true);
atu.start();
    }
    @Test(priority = 3)
    public void StopRecording( ) throws ATUTestRecorderException {
        atu.stop();
    }
}
