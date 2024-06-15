package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Ipl_t20 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get("https://www.iplt20.com/points-table/men/2023");
		Thread.sleep(10000);
		// to find the number of table in page
		List<WebElement> table = driver.findElements(By.xpath("(//table/tbody)"));
		Thread.sleep(10000);
		System.out.println("tables size:" + table.size());
		// to finding the number of rows in table
		for (int i = 1; i <= table.size(); i++) {
			List<WebElement> rows = driver.findElements(By.xpath("(//table/tbody)[" + i + "]/tr"));
			Thread.sleep(10000);
			System.out.println(rows.size());
			System.out.println("---------------");
			for (int j = 1; j <= rows.size(); j++) {
				List<WebElement> cols = driver.findElements(By.xpath("(//table/tbody)[" + i + "]/tr[" + j + "]/td"));
				Thread.sleep(10000);
				System.out.println(cols.size());

				for (int k = 0; k < cols.size(); k++) {
					Thread.sleep(10000);
					System.out.print(cols.get(k).getText() + ", ");
				}

			}
		}

	}

}
