package mypractice_utility.AdvanceSeleniumPratice.SeleniumListeners;

import mypraticework.P;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyWebDriverListener implements WebDriverListener {

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Before finding element: " + locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("Element found: " + locator);
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Before clicking on: " + element.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Clicked on: " + element.toString());
    }


    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: " + url);
    }


    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: " + url);
    }

    public void beforeScript(String script, WebDriver driver) {
        System.out.println("Before executing script: " + script);
    }


    public void afterScript(String script, WebDriver driver) {
        System.out.println("Script executed: " + script);
    }


    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Before switching to window: " + windowName);
    }
    public void onError(Object target, Throwable throwable) {
        System.out.println("Exception occurred: " + throwable.getMessage());
    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("After switching to window: " + windowName);
    }
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Value of the:" + element.toString() + " before any changes made");
    }
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page");
    }
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back to previous page");
    }
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page");
    }
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward to next page");
    }
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Refreshing the current page");
    }
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("Refreshed the current page");
    }
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString());
    }
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }
    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception occured: " + error);
    }
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Trying to accept alert");
    }
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("Alert accepted");
    }
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("Alert dismissed");
    }
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("Trying to dismiss alert");
    }
    public void beforeAlertText(WebDriver driver, String text) {
        System.out.println("Trying to send alert text");
    }
    public void afterAlertText(WebDriver driver, String text) {
        System.out.println("Alert text sent");
    }
    public void beforeSwitchToFrame(WebDriver driver, String frameNameOrId) {
        System.out.println("Before switching to frame: " + frameNameOrId);
    }
    public void afterSwitchToFrame(WebDriver driver, String frameNameOrId) {
        System.out.println("After switching to frame: " + frameNameOrId);
    }
    public void beforeSwitchToParentFrame(WebDriver driver) {
        System.out.println("Before switching to parent frame");
    }
    public void afterSwitchToParentFrame(WebDriver driver) {
        System.out.println("After switching to parent frame");
    }
    public void beforeSwitchToWindow(WebDriver driver, String windowName) {
        System.out.println("Before switching to window: " + windowName);
    }
    public void afterSwitchToWindow(WebDriver driver, String windowName) {
        System.out.println("After switching to window: " + windowName);
    }
    public void beforeClose(WebDriver driver) {
        System.out.println("Before closing the browser");
    }
    public void afterClose(WebDriver driver) {
        System.out.println("After closing the browser");
    }
    public void beforeQuit(WebDriver driver) {
        System.out.println("Before quitting the browser");
    }
    public void afterQuit(WebDriver driver) {
        System.out.println("After quitting the browser");
    }
    public  void beforeGetUrl(WebDriver driver, String url) {
        System.out.println("Before getting url: " + url);
    }
    public void afterGetUrl(WebDriver driver, String url) {
        System.out.println("After getting url: " + url);
    }
    public void beforeGetCurrentUrl(WebDriver driver) {
        System.out.println("Before getting current url");
    }
    public void afterGetCurrentUrl(WebDriver driver) {
        System.out.println("After getting current url");
    }
    public void beforeGetTitle(WebDriver driver) {
        System.out.println("Before getting title");
    }
    public void afterGetTitle(WebDriver driver) {
        System.out.println("After getting title");
    }
    public void beforeGetPageSource(WebDriver driver) {
        System.out.println("Before getting page source");
    }
    public void afterGetPageSource(WebDriver driver) {
        System.out.println("After getting page source");
    }
    public void beforeExecuteScript(WebDriver driver, String script) {
        System.out.println("Before executing script: " + script);
    }
    public void afterExecuteScript(WebDriver driver, String script) {
        System.out.println("After executing script: " + script);
    }
    public void beforeExecuteAsyncScript(WebDriver driver, String script) {
        System.out.println("Before executing script: " + script);
    }
    public void afterExecuteAsyncScript(WebDriver driver, String script) {
        System.out.println("After executing script: " + script);
    }
    public void  beforeGetCookies(WebDriver driver) {
        System.out.println("Before getting cookies");
    }
    public void afterGetCookies(WebDriver driver) {
        System.out.println("After getting cookies");
    }
    public void beforeGetAllCookies(WebDriver driver) {
        System.out.println("Before getting all cookies");
    }
    public void afterGetAllCookies(WebDriver driver) {
        System.out.println("After getting all cookies");
    }
    public void beforeAddCookie(WebDriver driver, Cookie cookie) {
        System.out.println("Before adding cookie: " + cookie);
    }
    public void afterAddCookie(WebDriver driver, Cookie cookie) {
        System.out.println("After adding cookie: " + cookie);
    }
    public void beforeDeleteCookieNamed(WebDriver driver, String name) {
        System.out.println("Before deleting cookie with name: " + name);
    }
    public void afterDeleteCookieNamed(WebDriver driver, String name) {
        System.out.println("After deleting cookie with name: " + name);
    }
    public void beforeDeleteAllCookies(WebDriver driver) {
        System.out.println("Before deleting all cookies");
    }
    public void afterDeleteAllCookies(WebDriver driver) {
        System.out.println("After deleting all cookies");
    }






















}
