package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Dropdown_3_select_deselect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(3000);
		WebElement dd = driver.findElement(By.xpath("(//select[@name='skills'])[1]/parent::div"));
		dd.click();

		List<WebElement> items = dd.findElements(By.xpath("child::div[contains(@class,'menu')]/div"));
		for (WebElement item : items) {
			item.click();
			Thread.sleep(2000);
		}
		// deselecting the selected items
		List<WebElement> deselect = dd.findElements(By.xpath("child::a"));
		for (WebElement selected : deselect) {
			selected.findElement(By.xpath("child::i")).click();
			Thread.sleep(1000);
		}

	}
}
