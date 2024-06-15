package mypraticework;

import mypractice_utility.CarouselSliderUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class carouselslidertest_9 {
    @Test
    public void method1() throws Throwable {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://getbootstrap.com/docs/4.0/components/carousel");
        driver.manage().window().maximize();
        CarouselSliderUtility cu = new CarouselSliderUtility();
        WebElement ee = driver.findElement(By.xpath("(//div[@class='carousel-inner'])[1]"));
        int x = cu.getCountOfSlider(ee);
        System.out.println(x);
        String type_of_Slider = cu.getTypeOfSlider(ee);
        System.out.println(type_of_Slider);
boolean b=cu.AreSliderMovingAutomaticallyInSlider(ee);
System.out.println(b);
String s=cu.getMovingDirectionOfSlider(ee);
System.out.println(s);
System.out.println(cu.getSliderMoveDuration(ee));
System.out.println(cu.getslideMovingStyle(ee));
driver.close();

        }
    }

