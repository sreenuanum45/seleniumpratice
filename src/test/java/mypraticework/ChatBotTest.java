
package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.ChatBotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChatBotTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String q = "hello";
		// open browser and Launch site
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chatbot.com/");
		Thread.sleep(5000);
		driver.switchTo().frame("chat-widget");
		driver.findElement(By.className("lazy-img")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(q, Keys.ENTER);
		Thread.sleep(5000);
		String Actualanswer = driver.findElement(By.xpath("(//div[@data-type='BOT_RESPONSE_text'])[2]")).getText();
		System.out.println(Actualanswer);
		String mappedres = ChatBotUtility.getResponse(q);
		System.out.println(mappedres);
		if (Actualanswer.contains(mappedres)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		// close site
		driver.switchTo().defaultContent();
		driver.close();
	}

}

