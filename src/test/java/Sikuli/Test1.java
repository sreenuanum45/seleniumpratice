package Sikuli;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void test1() throws FindFailed, InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        ImagePath.add(System.getProperty("user.dir"));
        Screen s=new Screen();
        Pattern p=new Pattern("E:\\caputureimages\\block1.png");
        s.wait(p,20);
        Thread.sleep(5000);
        s.click(p);
    }
}
