package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CarouselSliderUtility;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class carouselslidertest_1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Url u=new Url("https://www.snapdeal.com/");
		driver.navigate().to(u.getUrl());
		WebElement slider = driver.findElement(By.xpath("//div[@id='top-banner']"));
		CarouselSliderUtility obj = new CarouselSliderUtility();
		int i = obj.getCountOfSlider(slider);
		System.out.println(i);
		System.out.println(obj.getTypeOfSlider(slider));
		boolean b = obj.AreSliderMovingAutomaticallyInSlider(slider);
		System.out.println(b);
		System.out.println(obj.getMovingDirectionOfSlider(slider));
		System.out.println(obj.getSliderMoveDuration(slider));

	}

}
