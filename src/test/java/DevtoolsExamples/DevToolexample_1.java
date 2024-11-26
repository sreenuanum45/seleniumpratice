package DevtoolsExamples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.emulation.Emulation;
import org.openqa.selenium.devtools.v122.log.Log;
import org.openqa.selenium.devtools.v122.network.Network;
import org.openqa.selenium.devtools.v122.network.model.ConnectionType;
import org.openqa.selenium.devtools.v122.network.model.Response;
import org.openqa.selenium.devtools.v122.network.model.WebSocketFrame;
import org.openqa.selenium.devtools.v122.performance.Performance;
import org.openqa.selenium.devtools.v122.performance.model.Metric;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.List;
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
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request URL: " + request.getRequest().getUrl());
        });

        devTools.addListener(Network.responseReceived(), response -> {
            System.out.println("Response URL: " + response.getResponse().getUrl());
        });

        devTools.send(Network.emulateNetworkConditions(false, 100, 2000, 1000, Optional.of(ConnectionType.CELLULAR4G)));
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metrics = devTools.send(Performance.getMetrics());
        for (Metric metric : metrics) {
            System.out.println(metric.getName() + ": " + metric.getValue());
        }
        devTools.createSession();

        // Simulate geolocation
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(37.7749), // Latitude
                Optional.of(-122.4194), // Longitude
                Optional.of(1) // Accuracy
        ));
        // Block URLs
        devTools.send(Network.setBlockedURLs(List.of("*.css", "*.png")));

        // Enable network monitoring
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Add listener for blocked requests
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println("Blocked URL: " + loadingFailed.getErrorText());
            devTools.addListener(Network.responseReceived(), response -> {
                Response res = response.getResponse();
                System.out.println("URL: " + res.getUrl());
                System.out.println("Status: " + res.getStatus());
                System.out.println("MIME Type: " + res.getMimeType());
            });
            // Enable console logging
            devTools.send(Log.enable());

            // Capture console logs
            devTools.addListener(Log.entryAdded(), logEntry -> {
                System.out.println("Log: " + logEntry.getText());
            });

            // Enable network monitoring
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture WebSocket messages
            devTools.addListener(Network.webSocketFrameReceived(), webSocketFrame -> {
                WebSocketFrame frame = webSocketFrame.getResponse();
                System.out.println(frame.getPayloadData());
                System.out.println(frame.getOpcode());
                System.out.println(frame.getMask());
                System.out.println("WebSocket Message: " + frame);
            });
            driver.get("https://www.magnitia.com");

        });
    }
}
