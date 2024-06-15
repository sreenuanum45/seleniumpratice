package DevtoolsExamples;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.Optional;

public class SetBlockedURLPatterns {
    @Test
    public void test() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        DevTools dt=((ChromeDriver)driver).getDevTools();
        dt.createSession();
        Command cmd= Network.enable(Optional.of(10000000), Optional.empty(), Optional.empty());
        Command cmd2=Network.setBlockedURLs(ImmutableList.of("*.png","*.gif","*.jpg","*.css","*.js","*.ico","*.woff","*.woff2","*.ttf","*.svg"));
        dt.send(cmd);
        dt.send(cmd2);
        driver.get("https://www.redbus.com");
        Thread.sleep(5000);
        //driver.close();
    }
}
