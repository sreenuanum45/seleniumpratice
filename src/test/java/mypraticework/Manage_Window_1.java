package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Manage_Window_1 {
    RemoteWebDriver driver;

    @Test
    public void amazonTest() throws AWTException {
        driver.get("https://www.amazon.in");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        int h = driver.manage().window().getSize().getHeight();
        int w = driver.manage().window().getSize().getWidth();
        System.out.println("browser size:" + h + "  " + w);

        // Relocate browser on Desktop
        Dimension d = new Dimension(800, 600);
        // The setSize method is not needed here, remove it
        driver.manage().window().setSize(d);
        System.out.println("Relocate browser on Desktop:" + h + "  " + w);

        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();

        System.out.println("Relocate browser on Desktop:" + x + "  " + y);
        org.openqa.selenium.Point p = new org.openqa.selenium.Point(100, 200);
        driver.manage().window().setPosition(p);
        System.out.println("browser on Desktop:" + x + "  " + y);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Back to normal (core Java)
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @BeforeTest
    public void setup1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
