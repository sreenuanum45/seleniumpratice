package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iframe2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//input[@type='file'][1]"))
				.sendKeys("C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshot 2023-05-25 094258.png");
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		driver.quit();
	}

}
