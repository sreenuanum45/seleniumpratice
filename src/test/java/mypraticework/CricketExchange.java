
package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.TableDataPrint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CricketExchange {
	RemoteWebDriver driver;
@Test(priority = 1)
	public  void method1() throws Throwable {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get("https://crex.live/stats/ipl-2023-orange-cap-list");
		Thread.sleep(10000);
		List<WebElement> tables = driver.findElements(By.xpath("//table//tbody"));
		TableDataPrint tdp = new TableDataPrint();

		tdp.tableSizeCheck(tables);

		tdp.EachColoumTextPrint(tables);

	}

	@Test(priority = 2)
	public  void teardown() {
	driver.close();

	}
}
