package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.WebTableUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Webtable1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get(
				"https://www.espncricinfo.com/series/india-in-west-indies-2023-1381201/west-indies-vs-india-1st-test-1381212/full-scorecard");
		Thread.sleep(5000);
		// work with a table
		WebElement wt = driver.findElement(By.xpath("(//table[contains(@class,'ci-scorecard-table')])[2]"));

		WebTableUtility obj = new WebTableUtility();
		// get table headers
		List<WebElement> headers = obj.getHeaders(wt);
		for (WebElement header : headers) {
			System.out.print((String) driver.executeScript("return(arguments[0].textContent);", header) + "      ");
		}
		System.out.println();
		// get whole table content
		int nor = obj.getRowsCount(wt); // get rows count in table
		for (int i = 1; i <= nor; i++) {
			int noc = obj.getColumnsCountInRow(wt, i); // get columns count in each row
			for (int j = 1; j <= noc; j++) {
				System.out.print(obj.getCellValue(driver, wt, i, j) + "  ");
			}
			System.out.println();
		}
		// Close site
		driver.close();

	}

}
