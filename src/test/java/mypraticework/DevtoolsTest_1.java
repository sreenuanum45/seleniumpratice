package mypraticework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.devtools.v124.network.model.Request;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.Optional;

public class DevtoolsTest_1 {

    @Test
    public void main() {
        RemoteWebDriver driver=new ChromeDriver();
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        System.out.println(devTools.getCdpSession());
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(),request->{
            Request req=request.getRequest();
           System.out.println(req.getUrl());
        });
   devTools.getDomains().disableAll();
   devTools.clearListeners();
   devTools.getDomains().log().enable().getParams().forEach((s, o) -> System.out.println(s + " " + o));
        driver.get("https://www.google.com/");
        devTools.disconnectSession();
    }
}
