package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Espncricinfo_1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get(
				"https://www.espncricinfo.com/series/india-in-west-indies-2023-1381201/west-indies-vs-india-1st-odi-1381214/live-cricket-score");
		Thread.sleep(10000);
		List<WebElement> tables = driver.findElements(By.xpath("//table//tbody"));
		System.out.println("total tablein page:" + tables.size());
		for (WebElement table : tables) {
			List<WebElement> rows = table.findElements(By.xpath("child::tr"));
			System.out.println("total rows in table:" + rows.size());
			System.out.println("-----------");

			for (WebElement row : rows) {
				List<WebElement> cols = row.findElements(By.xpath("child::td"));
				System.out.println("total coloum in table:" + cols.size());

			}
		}

		// TableDataPrint tdp=new TableDataPrint();
		// tdp.EachColoumTextPrint(tables);
	}
}