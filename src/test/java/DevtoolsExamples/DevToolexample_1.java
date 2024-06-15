package DevtoolsExamples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.log.Log;
import org.openqa.selenium.devtools.v122.network.Network;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.Optional;

public class DevToolexample_1 {
    @Test
    public void test1() {
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver driver = new ChromeDriver(options);
        DevTools  devTools=((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable network interception
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.getCdpSession();
        // Intercept network requests
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request URL: " + request.getRequest().getUrl());
        });
        // Enable console logging
        devTools.send(Log.enable());

        // Capture console logs
        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("Log: " + logEntry.getText());
        });

        driver.get("https://www.magnitia.com");

    }
}
