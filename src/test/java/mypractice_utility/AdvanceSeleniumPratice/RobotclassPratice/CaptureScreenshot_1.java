package mypractice_utility.AdvanceSeleniumPratice.RobotclassPratice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CaptureScreenshot_1 {
    @Test
    public void method1() throws InterruptedException, AWTException, IOException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/slider/");
        Robot robot=new Robot();
        Rectangle rect=new Rectangle(100,100);
        BufferedImage srcimage=robot.createScreenCapture(rect);
        ImageIO.write(srcimage,"png",new File("D:\\batch264\\264pratice\\target\\robot1.png"));
        ///fullscreenshot
      Dimension d=  Toolkit.getDefaultToolkit().getScreenSize();
      Rectangle rect1=new Rectangle(d);
      BufferedImage srcimage1=robot.createScreenCapture(rect1);
      ImageIO.write(srcimage1,"png",new File("D:\\batch264\\264pratice\\target\\robot2.png"));


    }
}
