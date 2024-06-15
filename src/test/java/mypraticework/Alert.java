package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Alert {
	RemoteWebDriver driver;

	@Test(priority = 1)
	public void alert() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert1");
		driver.switchTo().frame("iframewrapper");
		driver.findElement(By.xpath("//input[@value='Click me']")).click();
		Thread.sleep(5000);
		String s = driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();

	}

	@Test(priority = 2)
	public void method2() {
		driver = new ChromeDriver();
		driver.quit();

	}

}
