package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Pagenation_1 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.get("https://www.amazon.in");
        WebElement e=driver.findElement(By.id("twotabsearchtextbox"));
        e.sendKeys("iphones"+Keys.ENTER);
int p=1;
String s="D:\\batch264\\264pratice\\src\\test\\java\\target\\s";
       while(true) {

            try
            {
                Thread.sleep(5000);
                driver.findElement(By.linkText("Next")).click();
                AShot as=new AShot();
                ShootingStrategy shs= ShootingStrategies.viewportPasting(1000);
                Screenshot ss=as.shootingStrategy(shs).takeScreenshot(driver);
                File dest=new File(s);
                ImageIO.write(ss.getImage(),"PNG",dest);
                Thread.sleep(4000);
            s=s+p;
                p++;
            }
            catch(Exception e1)
            {
                break;
            }
        }
       Thread.sleep(4000);
        System.out.println(p);
       driver.close();

    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
