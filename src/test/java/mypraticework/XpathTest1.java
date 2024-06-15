package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class XpathTest1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		WebElement e = driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']")).getShadowRoot()
				.findElement(By.id("input"));
		e.sendKeys("msDhoni");

		Thread.sleep(4000);
	}

}
