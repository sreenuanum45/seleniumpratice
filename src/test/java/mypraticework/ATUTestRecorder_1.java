package mypraticework;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATUTestRecorder_1 {
    Date date;
    RemoteWebDriver driver;
    ATUTestRecorder recorder;
    SimpleDateFormat sf;

    @Test(priority = 3)
    public void driverclose(){
        driver.close();
    }
    @Test(priority = 2)
    public void paginationTesting(){
        driver.get("https://www.amazon.in");
        WebElement e=driver.findElement(By.id("twotabsearchtextbox"));
        e.sendKeys("iphones"+ Keys.ENTER);
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

        System.out.println(p);
    }
    @Test(priority = 4)
    public void Recorderstop() throws ATUTestRecorderException {
        recorder.stop();
    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
    @Test(priority = 1)
    public void StartRecording() throws  ATUTestRecorderException {
        sf=new SimpleDateFormat("dd-MMM-yyy-hh-mm-ss");
        date=new Date();
        String vp="target\\"+sf.format(date);
        recorder=new ATUTestRecorder(vp,true);
        recorder.start();

    }
}
