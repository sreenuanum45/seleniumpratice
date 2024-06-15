package Sikuli;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class PopUp_1 {
    @Test
    public void test1() throws InterruptedException, FindFailed {
        //Open browser and launch site
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Thread.sleep(5000);
        ImagePath.add(System.getProperty("user.dir"));
        Screen s=new Screen();
        s.type("E:\\caputureimages\\Screenshot 2024-01-17 191020.png","admin");
        Thread.sleep(5000);
        s.type("E:\\caputureimages\\Screenshot 2024-01-17 191054.png","admin");
        Thread.sleep(5000);

        s.click("E:\\caputureimages\\signin.png");
    }
}
