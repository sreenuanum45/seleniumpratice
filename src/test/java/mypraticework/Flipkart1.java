package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Flipkart1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// open site
		driver.get("https://www.flipkart.com/");
		try {
			driver.findElement(By.xpath("//span[text()='Login']/preceding::button[1]")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("no banner show this time");
		}
		driver.findElement(By.xpath("//div[contains(text(),'Beauty')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//a[text()='VIEW ALL'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Top Mirrorless Cameras']")).click();
		Thread.sleep(5000);
		List<WebElement> All = driver
				.findElements(By.xpath("//div[text()='Newest First']/following::a[@class='_1fQZEK']"));
		for (int i = 0; i < All.size(); i++) {
			All.get(i).click();
			Set<String> s = driver.getWindowHandles();
			List<String> l1 = new ArrayList<>(s);
			driver.switchTo().window(l1.get(1));
			String S = driver
					.findElement(By.xpath("//div[@id='price-info-icon']/preceding::div[@class='_30jeq3 _16Jk6d']"))
					.getText();
			S = S.substring(1);
			S = S.replace(",", "");
			System.out.println(S);
			// close the latest one
			driver.close();
			driver.switchTo().window(l1.get(0));
			Thread.sleep(5000);
		}

	}
}
