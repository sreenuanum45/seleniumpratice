package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CarouselSliderUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class carouselslidertest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub


		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://mdbootstrap.com/docs/b4/jquery/plugins/carousel-3d/");
		for (int i = 1; i <= 4; i++) {
			WebElement slider = driver.findElement(By.xpath("(//div[@class='carousel-3d-inner'])[" + i + "]"));
			driver.executeScript("arguments[0].style.border='3px solid red';", slider);
			CarouselSliderUtility obj = new CarouselSliderUtility();

			int s = obj.getCountOfSlider(slider);
			System.out.println(s);
			String s1 = obj.getTypeOfSlider(slider);
			System.out.println(s1);
			boolean b = obj.AreSliderMovingAutomaticallyInSlider(slider);
			System.out.println(b);
			String s2 = obj.getMovingDirectionOfSlider(slider);
			System.out.println(s2);
			System.out.println(obj.getSliderMoveDuration(slider));
			System.out.println(obj.getslideMovingStyle(slider));

		}

	}
}
