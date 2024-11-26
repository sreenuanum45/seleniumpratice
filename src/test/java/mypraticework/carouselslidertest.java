package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CarouselSliderUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class carouselslidertest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://mdbootstrap.com/docs/b4/jquery/plugins/carousel-3d/");
		driver.findElement(By.xpath("//button[@id='accept_cookies_btn']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='carousel-item active'])"));//<div class="carousel-item">
		for (int i = 1; i <= elements.size(); i++) {
			WebElement slider = driver.findElement(By.xpath("(//div[@class='carousel-item active'])["+i+"]"));
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
