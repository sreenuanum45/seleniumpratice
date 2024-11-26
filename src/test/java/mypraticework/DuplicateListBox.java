package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateListBox {
    RemoteWebDriver driver;
    @Test
    public void duplicateList() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement e=driver.findElement(By.xpath("//select[@id='colors']"));
       // WebElement e=driver.findElement(By.xpath("//select[@id='animals']"));
        Select s=new Select(e);
        List<WebElement> options = s.getOptions();
        Set<String> set = new HashSet<>();
        boolean flag=false;
        for (WebElement e1 : options) {
           String s1 = e1.getText();
           if(!set.add(s1)){
               System.out.println("duplicate option:"+s1);
               flag=true;
           }
        }
        if(!flag){
            System.out.println("no duplicate option");
        }
        System.out.println(set);
    }
}
