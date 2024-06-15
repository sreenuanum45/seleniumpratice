package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_6 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://spiceclub.spicejet.com/signup");
		Thread.sleep(3000);
		WebElement e = driver.findElement(By.xpath("(//select[contains(@class,form)])[1]"));

		Select dropdown = new Select(e);
		dropdown.selectByVisibleText("Mrs");
		WebElement e2 = driver.findElement(By.xpath("(//select[contains(@class,form)])[2]"));
		Select dropdown1 = new Select(e2);
		dropdown1.selectByIndex(1);

	}

}
