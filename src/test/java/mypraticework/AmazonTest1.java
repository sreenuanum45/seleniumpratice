package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AmazonTest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//div//img[@alt='Refrigerators']")).click();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		// for finding elements
		List<WebElement> All = driver.findElements(By.xpath(
				"//div[@class='a-section a-spacing-mini a-spacing-top-micro acs-product-block__product-image']"));

		for (int i = 0; i < All.size(); i++) {

			All.get(i).click();
			Thread.sleep(15000); // to get all windows
			Set<String> s = driver.getWindowHandles();
			List<String> Ls = new ArrayList<>(s);
			Thread.sleep(1000);
			driver.switchTo().window(Ls.get(1));
			String st = driver.findElement(By.xpath("(//span/span[@class='a-price-whole'])[5]")).getText();
			System.out.println(st);
			st = st.replace(";", "");
			System.out.println(st);

			driver.switchTo().window(Ls.get(0));

		}
	}

}
