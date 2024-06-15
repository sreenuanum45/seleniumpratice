package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Cookie_9 {
    RemoteWebDriver driver1;
    RemoteWebDriver driver2;
    List<Cookie>l;
    @Test(priority = 1)
    public void method1() throws InterruptedException {
driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //do login
        driver1.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
        Thread.sleep(5000);
        driver1.findElement(By.name("username")).sendKeys("magnitiait");
        driver1.findElement(By.name("password")).sendKeys("Magnitia@264");
        driver1.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
        Thread.sleep(5000);
        //Collect all cookies from chrome browser
        Set<Cookie> s=driver1.manage().getCookies();
        l=new ArrayList<>(s);
    }
    @Test(priority = 2)
    public void method2() throws InterruptedException {
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebDriverManager.edgedriver().setup();

        driver2 = new EdgeDriver();
        Thread.sleep(3000);
        driver2.manage().window().maximize();
        driver2.get("https://www.fastmail.com");
        Thread.sleep(3000);
//l=new ArrayList<Cookie>();
        for (Cookie cl : l) {
            try {
                driver2.manage().addCookie(cl);
            } catch (Exception e1) {
                e1.getMessage();
            }

        }
        driver2.navigate().refresh();

        try {
            if (driver2.findElement(By.xpath("//div[text()='Settings']")).isDisplayed()) {
                System.out.println("Session cookie test failed");
                System.out.println("HTTPS based sites cannot respond for shared cookies "
                        + "from one type of browser to another type due to different encryptions,"
                        + "but here chrome cookies working for firefox. so security test failed");
            }
        } catch (NoSuchElementException ee){
            System.out.println("Session cookie test passed");
            System.out.println("HTTPS based sites cannot respond for shared cookies " + "from one type of browser to another type due to different encryptions,"
                    + "so security test passed here");
        }

    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        /*ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        RemoteWebDriver driver=new ChromeDriver(options);*/
        driver1 = new ChromeDriver();
        Thread.sleep(3000);
        driver1.manage().window().maximize();
        driver1.get("https://www.fastmail.com");

    }
}


