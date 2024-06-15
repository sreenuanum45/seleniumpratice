package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.List;

public class Saucedemo_Com {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //Launch site
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.name("user-name")).sendKeys("standard_user", Keys.TAB,"secret_sauce",Keys.TAB,Keys.ENTER);
        WebElement e= driver.findElement(By.xpath("//button[text()='Open Menu']"));

        Thread.sleep(3000);
        driver.executeScript("arguments[0].style.border = '10px dotted pink';", e);

       List<WebElement>ll=driver.findElements(By.xpath("(//div[@class='inventory_item_label'])/a/div"));
       for(WebElement l2:ll)
       {
           driver.executeScript("arguments[0].style.border = '10px dotted blue';", l2);

           /*WebElement ex=driver.findElement(By.xpath("(//div[@class='inventory_item_img'])//img[l2]"));
           Thread.sleep(2000);
           ex.click();
           WebElement ex2=driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
           System.out.println(ex2.getText());*/
           String ss=l2.getText();
           System.out.println(ss);
           String s1=l2.getCssValue("color");
           System.out.println(s1);
           Actions as=new Actions(driver);
           as.moveToElement(l2).perform();
           String s2=l2.getCssValue("color");
           System.out.println(s2);
           if (!s1.equals(s2)) {

               System.out.println("Test passed color change");
           }
           else{
               System.out.println("test falied no change color");
           }
       }


        if(e.isDisplayed())
        {
            if(e.isEnabled())
            {
                if(e.isSelected()){
                    System.out.println("element is display and enable and selected in page");
                }
                else{
                    System.out.println("element is display and enable in page");
                }

            }
            else{
                System.out.println("element is display not enable in page");
            }
        }
        else{
            System.out.println("element is not display in page ");
        }

    }
}
