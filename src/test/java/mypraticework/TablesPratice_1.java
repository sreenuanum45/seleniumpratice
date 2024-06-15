package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class TablesPratice_1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get("https://semantic-ui.com/collections/table.html");
		Thread.sleep(7000);
		List<WebElement> Table = driver.findElements(By.xpath("(//table/tbody)[6]"));
		System.out.println("TAble size:" + Table.size());
		for (WebElement rows : Table) {
			List<WebElement> row = rows.findElements(By.xpath("(//table/tbody)[6]/tr"));
			System.out.println("row in table:" + row.size());
			for (WebElement cols : row) {
				List<WebElement> col = cols.findElements(By.xpath("(//table/tbody)[6]/tr/td"));
				System.out.println("cols in row:" + col.size());
				for (int i = 0; i < col.size(); i++) {
					if (i < col.size() - 2) {
						System.out.print(col.get(i).getText() + " ,");
					} else {
						System.out.print(col.get(i).getText());
						System.out.println();
					}

				}
			}
		}
	}

}
