package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WebElement_GetScreenShot_14 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        String s="D:\\batch264\\264pratice\\src\\test\\java\\target\\s";
        driver.get("https://semantic-ui.com/modules/dropdown.html");
        WebElement e=driver.findElement(By.xpath(
                "(//div[@class='ui inline dropdown'])[1]"));
        File f1=e.getScreenshotAs(OutputType.FILE);
        File dest1=new File("target/elescreenshot1.png");
        FileHandler.copy(f1,dest1);
        //Get screenshot of visible area of page on desktop
        File f2=driver.getScreenshotAs(OutputType.FILE);
        File dest2=new File("target\\pagescreenshot.png");
        FileHandler.copy(f2,dest2);
        //Get screenshot of complete page using Ashot
       AShot as=new AShot();
       ShootingStrategy shs=ShootingStrategies.viewportPasting(1000);
       Screenshot ss=as.shootingStrategy(shs).takeScreenshot(driver);
       File dest=new File(s);
       ImageIO.write(ss.getImage(),"PNG",dest);
    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
