
package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.DivDropDownUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Dropdown_2 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		List<WebElement> l2 = driver
				.findElements(By.xpath("//div[@class='ui active tab']/div/div[contains(@class,' dropdown')]"));

		DivDropDownUtility dd = new DivDropDownUtility();
		dd.multidropdownHighlight(l2, driver);
		l2.stream().filter(e -> e.isDisplayed()).distinct().collect(Collectors.toList()).forEach(e->System.out.println(e.getText()));



	}

}
