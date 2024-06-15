package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Espncricinfo {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get(
				"https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2022-23-1298134/points-table-standings");
		// all tables saves in tables list
		List<WebElement> Tables = driver.findElements(By.xpath("//table//tbody"));
		System.out.println("tables size in page" + Tables.size());
		for (int i = 0; i < Tables.size(); i++) {
			Thread.sleep(4000);
			List<WebElement> Rows = Tables.get(i).findElements(By.xpath("child::tr"));
			System.out.println(Rows.size() + "rows in table" + i);
			System.out.println("---------------");
			// coloums in the row
			for (int j = 0; j < Rows.size(); j++) {
				Thread.sleep(4000);
				List<WebElement> Cols = Rows.get(j).findElements(By.xpath("child::td"));
				System.out.println(Cols.size() + "cols in row:" + j);
				for (int k = 0; k < Cols.size(); k++) {
					Thread.sleep(4000);
					System.out.print(Cols.get(k).getText() + ", ");
				}
				System.out.println();
			}
		}
	}

}
