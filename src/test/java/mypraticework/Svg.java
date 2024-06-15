package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Svg {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/graphics/tryit.asp?filename=trysvg_circle");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//body[@contenteditable='false']/child::*[1]")).click();

	}

}
