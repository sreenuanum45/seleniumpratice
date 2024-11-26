package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PseudoElement_PropertiesValue {
    public static void main(String[] args) throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rangeslider.js.org/");
        Thread.sleep(5000);
        //1. get details of general element
        String value1=driver.findElement(By.className("rangeslider__fill"))
                .getCssValue("background-color");
        System.out.println(value1);
        String x = (String) driver.executeScript("var x = document.querySelector('.rangeslider__handle'); " +
                "var r = window.getComputedStyle(x, '::after'); " +
                "var y = r.getPropertyValue('color'); " +
                "return y;");

        System.out.println(x);
        String y = (String) driver.executeScript("var x = document.querySelector('.rangeslider__handle'); " +
                "var r = window.getComputedStyle(x, '::after'); " +
                "var y = r.getPropertyValue('background'); " +
                "return y;");
        System.out.println(y);
        String z = (String) driver.executeScript("var x = document.querySelector('.rangeslider__handle'); " +
                "var r = window.getComputedStyle(x, '::after'); " +
                "var y = r.getPropertyValue('border'); " +
                "return z;");
        System.out.println(z);

        //    border






    }
}
