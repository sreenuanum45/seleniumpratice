package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Iframetest7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=htmliframes");
		Thread.sleep(5000);
		driver.switchTo().frame("iframewrapper");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("gs_tti51")).click();
		driver.findElement(By.id("gs_tti51")).sendKeys("java");
	}

}
