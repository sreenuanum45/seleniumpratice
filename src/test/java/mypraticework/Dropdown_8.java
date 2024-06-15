package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Dropdown_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.findElement(By.xpath("//input[@name='gender']/parent::div[1]")).click();
		// driver.findElement(By.xpath("child::/div"))

	}

}
