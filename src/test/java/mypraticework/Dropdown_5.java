package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Dropdown_5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(3000);
		WebElement d = driver.findElement(By.xpath("(//div[@class='text'])[2]"));
		List<WebElement> e = d.findElements(By.xpath("following::div[1]/child::*"));
		System.out.println(e.size());
		driver.executeScript("arguments[0].click()", e.get(1));

	}

}
