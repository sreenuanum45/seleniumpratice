package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CarouselSliderUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class carouselslidertest_5 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.navigate().to("https://www.shoppersstop.com/");

		WebElement slider = driver.findElement(By.xpath("(//div[@class='slick-list draggable'])[1]"));
			CarouselSliderUtility obj = new CarouselSliderUtility();
			System.out.println(obj.getCountOfSlider(slider));

			System.out.println(obj.getTypeOfSlider(slider));
			if (obj.AreSliderMovingAutomaticallyInSlider(slider)) {
				System.out.println(obj.getMovingDirectionOfSlider(slider));
				System.out.println(obj.getSliderMoveDuration(slider));
			} else {
				System.out.println("slider are not moving");
			}

			System.out.println(obj.getslideMovingStyle(slider));
			System.out.println(obj.getDelayBetweenSlidesMove(slider));
			driver.close();
		}

	}

