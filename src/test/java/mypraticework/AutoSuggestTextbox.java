package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AutoSuggestTextbox {
    @Test
    public void method1() throws InterruptedException {
        String x="kalam";
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(x);
        Thread.sleep(3000);
        List<WebElement>ls=driver.findElements(By.xpath("//ul[@role='listbox'][1]/li"));
        int flag=0;
        for(WebElement e:ls){
            String y=e.getText();
            y=y.toLowerCase();
            y=y.replace(" ",",");
            x=x.toLowerCase();
            x=x.replace(" ",",");
            if(!y.contains(x)){
                flag=1;

            }
            if(flag==0){
                System.out.println("All suggestion are correct");

            }
            else {
                System.out.println("All suggestion are not correct");


            }

        }
       // driver.close();
    }
}
