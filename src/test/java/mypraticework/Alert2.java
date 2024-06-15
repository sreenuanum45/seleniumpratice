package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Alert2 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert2");
		driver.switchTo().frame("iframewrapper");
		WebElement e=driver.findElement(By.xpath("//input[@type='button']/parent::form"));
		e.click();
	
		System.out.println(	driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}

}
