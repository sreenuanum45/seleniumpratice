package mypraticework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SetBrowserWindowSize {

    @Test
    public void setBrowserWindowSize() {
        String PROXY = "199.201.125.147:8080";
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY)
                .setFtpProxy(PROXY)
                .setSslProxy(PROXY);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        cap.setCapability(CapabilityType.PROXY, proxy);
        RemoteWebDriver driver = new ChromeDriver();
        //driver.get("https://expired.badssl.com/");
        driver.get("https://www.google.com");
        driver.manage().window().setSize(new Dimension(1000,1000));
        driver.executeScript("document.getElementByName('q').value = selenium;");
    }
}
