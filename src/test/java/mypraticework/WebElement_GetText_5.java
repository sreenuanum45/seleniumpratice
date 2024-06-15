package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class WebElement_GetText_5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        Thread.sleep(3000);
        //Launch site
        driver.get("https://www.flipkart.com/search?q=mobiles&as=on&as-show=on&otracker=AS_Query_HistoryAutoSuggest_1_2_na_na_na&otracker1=AS_Query_HistoryAutoSuggest_1_2_na_na_na&as-pos=1&as-type=HISTORY&suggestionId=mobiles&requestId=49463773-80b2-4abb-a8af-645f22c8e1ff&as-searchtext=mo");
        Thread.sleep(5000);
        WebElement e = driver.findElement(By.xpath("//div[@id='container']//div[@class='_1YokD2 _3Mn1Gg']"));

       /* String x=e.getText();
        System.out.println(x);*/

            String y = (String) driver.executeScript("return arguments[0].childNodes[0].textContent;", e);

        System.out.println(y);
    }
}
