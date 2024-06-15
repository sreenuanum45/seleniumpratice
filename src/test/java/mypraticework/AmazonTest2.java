package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AmazonTest2 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// launch a site
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Laptops")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//img[contains(@alt,'seg')])[1]")).click();
		Thread.sleep(5000);
		List<WebElement> lt = driver.findElements(By.xpath("//img[@class='s-image']"));
		for (int i = 0; i < lt.size(); i++) {
			lt.get(i).click();

			Set<String> st = driver.getWindowHandles();
			List<String> rs = new ArrayList<>(st);
			driver.switchTo().window(rs.get(1));
			String pr = driver.findElement(By.xpath("(//span//span[@class='a-price-whole'])[5]")).getText();
			Thread.sleep(5000);

			pr = pr.replace(",", "");
			Thread.sleep(5000);
			System.out.println(pr);
			driver.close();
			driver.switchTo().window(rs.get(0));
			Thread.sleep(5000);
		}

		driver.quit();

	}

}
