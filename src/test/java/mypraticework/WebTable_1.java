package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WebTable_1 {
    @Test
    public void webTable() {
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().window().maximize();
        List<String>counrtys=new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        List<WebElement> list=driver.findElements(By.xpath("//table//tbody//tr"));
        System.out.println(list.size());
        for(int i=1;i<list.size();i++)
        {
          if(list.get(i).findElement(By.xpath("td["+5+"]")).getText().contains("English"))
          {
              counrtys.add(list.get(i).findElement(By.xpath("td["+2+"]")).getText());
          }
        }
        hs.addAll(counrtys);
       if(hs.size()==counrtys.size()){
           System.out.println("Yes all country are English");
           System.out.println(hs.size());
       }else{
           System.out.println("Not all country are English");
       }

    }
}
