package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ButtontTest_1 {
	RemoteWebDriver driver;

	@Test(priority = 1)
	public void method1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get("https://semantic-ui.com/elements/button.html");
		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[@class='follow example']/button[@class='ui button']")).click();
		String s = driver.findElement(By.xpath("//div[@class='another example']/button[@class='ui button'][1]"))
				.getTagName();
		System.out.println(s);
		WebElement e = driver.findElement(
				By.xpath("(//div/button[@class='ui primary button'])|(//div/button[@class='ui button'])[4]"));
		e.click();
		System.out.println(e.getText());
	}

	@Test(priority = 2)
	public void method2() {
		driver.close();
	}

}
