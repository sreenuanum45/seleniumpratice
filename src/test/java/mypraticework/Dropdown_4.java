package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Dropdown_4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(3000);
		String x = "tcs";

		driver.findElement(By.name("q")).sendKeys(x);
		Thread.sleep(2000);
		List<WebElement> suggestions = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]/li"));
		int flag = 0;
		for (WebElement suggestion : suggestions) {
			String y = suggestion.getText();
			y = y.toLowerCase();
			y = y.replace(" ", "");
			x = x.toLowerCase();
			x = x.replace(" ", "");
			if (!y.contains(x)) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("all suggestion are correct");
		} else {
			System.out.println("all suggestion are not correct");
		}
		// driver.close();

	}
}
