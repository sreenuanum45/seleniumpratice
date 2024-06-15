package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.ImagesCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Collectimages {
	@Test(priority = 1)
	public void images() throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		ImagesCollection im = new ImagesCollection();
		List<WebElement> images = driver.findElements(By.xpath("//img"));
		im.MyCollection(images);

	}
}
