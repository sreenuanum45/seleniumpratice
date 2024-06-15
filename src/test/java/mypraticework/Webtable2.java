package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.WebTableUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Webtable2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get(
				"https://www.espncricinfo.com/series/india-in-west-indies-2023-1381201/west-indies-vs-india-1st-test-1381212/full-scorecard");
		Thread.sleep(5000);
		WebElement wt = driver.findElement(By.xpath("(//table[contains(@class,'ci-scorecard-table')])[2]"));
//create an object to utility class
		WebTableUtility obj = new WebTableUtility();
		int rows = obj.getRowsCount(wt);
		System.out.println(rows);
		for (int i = 1; i <= rows - 4; i++) {
			try {
				List<WebElement> batter = obj.getCellChilds(wt, i, 1, By.xpath("child::a"));
				String name = (String) driver.executeScript("return(arguments[0].textContent);", batter.get(0));

				String desc = obj.getCellValue(driver, wt, i, 2);
				String a = obj.getCellValue(driver, wt, i, 3);
				String b = obj.getCellValue(driver, wt, i, 4);
				String c = obj.getCellValue(driver, wt, i, 5);
				String d = obj.getCellValue(driver, wt, i, 6);
				String e = obj.getCellValue(driver, wt, i, 7);
				String f = obj.getCellValue(driver, wt, i, 8);
				System.out.println(
						name + "   " + desc + "   " + a + "   " + b + "   " + c + "   " + d + "   " + e + "   " + f);

			} catch (Exception e) {

			}

		}
		// driver.close();

	}

}
