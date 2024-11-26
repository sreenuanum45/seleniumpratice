package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTable_1 {
    RemoteWebDriver driver;
    @Test
    public void test(){
       driver=new ChromeDriver();
       driver.get("https://practice.expandtesting.com/dynamic-table");
       driver.manage().window().maximize();
 List<WebElement> webElementList=driver.findElements(By.xpath("//table//tbody//tr"));
 for(int i=1;i<=webElementList.size();i++){
     String text= driver.findElement(By.xpath("//table//tbody//tr["+i+"]/td[1]")).getText();
    if(text.equals("Chrome")){
String cpuload=driver.findElement(By.xpath("//td[text()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
String ActualCPULoad=driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
String ActualCPULoadSplit[]=ActualCPULoad.split(":");
String ActualCPULoad2=ActualCPULoadSplit[1].trim();
if(cpuload.equals(ActualCPULoad2)){
    System.out.println("pass");
}
else{
    System.out.println("fail");
}
    }
 }
    }
}
