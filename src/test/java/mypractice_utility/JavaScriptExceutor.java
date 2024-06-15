package mypractice_utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptExceutor {
    public static void clickOnElement(RemoteWebDriver driver, WebElement element){

        driver.executeScript("arguments[0].click();", element);
    }
    public static void scrollIntoView(RemoteWebDriver driver, WebElement element){
        driver.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void scrollBy(RemoteWebDriver driver, int x, int y){
        driver.executeScript("window.scrollBy("+x+","+y+")");
    }
    public static void scrollByPixel(RemoteWebDriver driver, int x, int y){
        driver.executeScript("window.scrollBy("+x+","+y+")");
    }
    public static void scrollByPercentage(RemoteWebDriver driver, int x, int y){
        driver.executeScript("window.scrollBy("+x+","+y+")");
    }

    public static void alertWith(RemoteWebDriver driver){
        driver.executeAsyncScript("window.setTimeout(function(){alert('Hello World')},1000)");
    }

}
