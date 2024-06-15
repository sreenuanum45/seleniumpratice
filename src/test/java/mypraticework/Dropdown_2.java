
package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Dropdown_2 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		List<WebElement> l2 = driver
				.findElements(By.xpath("//div[@class='ui active tab']/div/div[contains(@class,' dropdown')]"));


	}

}
