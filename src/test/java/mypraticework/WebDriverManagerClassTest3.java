package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerClassTest3 {

	public static void main(String[] args) {
		// driver version()
		WebDriverManager.chromedriver().driverVersion("112.0.5615.138").setup();
		// browser version()
		WebDriverManager.chromedriver().browserVersion("112").setup();
		// arch64()
		WebDriverManager.chromedriver().driverVersion("112.0.5615.138").arch64().setup();
		WebDriverManager.chromedriver().browserVersion("112").arch64().setup();
	}

}
