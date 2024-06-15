package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.TableUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Cricbuzz {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.cricbuzz.com/cricket-series/5945/indian-premier-league-2023/points-table");
		Thread.sleep(10000);
		// to find the number of table in a page
		List<WebElement> table = driver.findElements(By.xpath("//table//tbody"));

		TableUtility tu = new TableUtility();
		tu.tableSizeCheck(table);

	}

}
