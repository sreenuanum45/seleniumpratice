package mypraticework;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Handle_SSL {
    @Test
    public void handleSSL() {
        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
       /* HtmlUnitDriver driver=new Htmldriver(dc);
        driver.get("https://expired.badssl.com/");*/
    }
}
