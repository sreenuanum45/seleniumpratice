package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Twsr11 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
		Thread.sleep(1000);
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.xpath("//input[@id='myfile']"));
		e.sendKeys("C:\\\\Users\\\\sreenu\\\\OneDrive\\\\Pictures\\\\Screenshot 2023-05-25 094258.png");
		driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
		driver.switchTo().defaultContent();

	}

}
