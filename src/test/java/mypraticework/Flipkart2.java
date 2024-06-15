package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Flipkart2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// open site
		driver.get("https://www.flipkart.com");
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
		driver.findElement(By.xpath("//div[text()='Printers']/following-sibling::div[text()='HP']")).click();
		Thread.sleep(5000);
		List<WebElement> al2 = driver
				.findElements(By.xpath("//div[text()='Newest First']/following::div[@class='CXW8mj']"));
		for (int i = 0; i < al2.size(); i++) {
			al2.get(i).click();
			Thread.sleep(5000);
			Set<String> s = driver.getWindowHandles();
			List<String> Ls = new ArrayList<>(s);
			driver.switchTo().window(Ls.get(1));
			String sreenu = driver
					.findElement(By.xpath("//div[@id='price-info-icon']/preceding::div[@class='_30jeq3 _16Jk6d']"))
					.getText();
			Thread.sleep(5000);
			sreenu = sreenu.substring(1);
			sreenu = sreenu.replace(",", "");
			System.out.println(sreenu);
			driver.close();
			driver.switchTo().window(Ls.get(0));
			Thread.sleep(5000);

		}
	}
}
