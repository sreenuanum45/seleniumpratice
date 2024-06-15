package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Dropdown_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://spiceclub.spicejet.com/");
		driver.findElement(By.xpath("//div//input[@type='radio'][1]")).click();
		driver.findElement(By.xpath("//div//input[@value='email']")).sendKeys("sreemnu");
	}

}
