package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Flipkart3 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// open site
		driver.get("https://www.flipkart.com");
		try {
			driver.findElement(By.xpath("//span[text()='Login']/preceding::button[1]")).click();
		} catch (Exception e) {

			System.out.println("no banner show this time");
		}
		driver.findElement(By.xpath("//div[@class='CXW8mj']/img[@alt='Mobiles']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@alt='szx'][2]")).click();
		Thread.sleep(5000);
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='CXW8mj']"));
		for (int i = 0; i < ls.size(); i++) {
			ls.get(i).click();
			Thread.sleep(5000);
			Set<String> ss = driver.getWindowHandles();
			List<String> lt = new ArrayList<>(ss);
			driver.switchTo().window(lt.get(i + 1));
			String Sr = driver
					.findElement(By.xpath("//div[@id='price-info-icon']/preceding::div[@class='_25b18c']/div[1]"))
					.getText();
			Sr = Sr.substring(1);
			Sr = Sr.replace(",", "");
			System.out.println(Sr);
			driver.switchTo().window(lt.get(0));
			Thread.sleep(5000);

		}

	}

}
