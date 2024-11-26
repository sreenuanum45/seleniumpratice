package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Asynchronously {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");
        Thread.sleep(5000);
        driver.executeAsyncScript(
                "window.setTimeout(function(){window.alert('hi kalam sir');},1000);"
                        +"window.alert('hi students');"
                        +"window.setTimeout(function(){window.alert('how are you?');},500);"
        );
    }
}
