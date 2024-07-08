package DevtoolsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AccessingExistingBrowser {

   @Test
   public void test() {
//connect to existing browser

       ChromeOptions o=new ChromeOptions();

       o.setExperimentalOption("debuggerAddress", "localhost:57494");

       ChromeDriver driver=new ChromeDriver(o);

       driver.get("http://www.google.co.in");
       driver.findElement(By.name("q")).sendKeys("selenium");
       //driver.close();
    }
}
