package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CarouselSliderUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class carouselslidertest_6 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.navigate().to("https://www.toyota.com.br/");
		WebElement slider = driver.findElement(By.xpath("(//div[@class='slick-track'])[1]"));
		CarouselSliderUtility obj = new CarouselSliderUtility();
		System.out.println(obj.getCountOfSlider(slider));
		System.out.println(obj.getTypeOfSlider(slider));
		// are they moving
		WebElement currentsliderelement1 = slider.findElement(By.xpath("(//div[contains(@class,'slick-current')])[1]"));

		String currentSlideIndexAttribute1 = currentsliderelement1.findElement(By.xpath("descendant::img"))
				.getAttribute("src");
		Thread.sleep(3000);
		WebElement currentsliderelement2 = slider.findElement(By.xpath("(//div[contains(@class,'slick-current')])[1]"));

		String currentSlideIndexAttribute2 = currentsliderelement2.findElement(By.xpath("descendant::img"))
				.getAttribute("src");
		if (!currentSlideIndexAttribute1.equals(currentSlideIndexAttribute2)) {
			System.out.println("slider are moving");
			String parentLeftValue = (String) driver.executeScript(
					"return(window.getComputedStyle(arguments[0].parentNode).getPropertyValue('left'));",
					currentsliderelement1);
			System.out.println("Parent Left value: " + parentLeftValue);
			String direction;
			if (parentLeftValue.contains("-")) {
				direction = "Right to Left";
			} else {
				direction = "Right to Left";
			}
			System.out.println("Slide direction:" + direction);
		} else {
			System.out.println("slider are not moving");
		}
		System.out.println("Each slide moving duration is " + obj.getSliderMoveDuration(slider));
		System.out.println(obj.getslideMovingStyle(slider));
		System.out.println("Delay between slides is " + obj.getDelayBetweenSlidesMove(slider));
	}

}
