package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Semantic1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get("https://semantic-ui.com/collections/table.html");
		Thread.sleep(7000);
		// list of table are finding
		List<WebElement> tables = driver.findElements(By.xpath("//table/tbody"));
		Thread.sleep(7000);
		System.out.println("number of tables in page:" + tables.size());
		for (int i = 0; i < tables.size(); i++) {
			// each table how many rows.....
			List<WebElement> rows = tables.get(i).findElements(By.xpath("child::tr"));
			Thread.sleep(7000);
			System.out.println(rows.size() + "rows in table of" + i);
			System.out.println("@@@@@=====@@@@@");
			for (int j = 0; j < rows.size(); j++) {
				// each row how many coloums....
				List<WebElement> cols = rows.get(j).findElements(By.xpath("child::td"));
				Thread.sleep(7000);
				System.out.println(cols.size() + "cols in each row" + j);
				// toget data from each coloum for every table....
				for (int k = 0; k < cols.size(); k++) {
					System.out.print(cols.get(k).getText() + ", ");
				}
				System.out.println();
			}
		}

	}

}
