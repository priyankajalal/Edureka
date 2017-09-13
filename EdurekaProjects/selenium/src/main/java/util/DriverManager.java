package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	public static WebDriver getDriverByName(String browser) {
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("mo")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			driver = new ChromeDriver();
		} else {
			driver = new ChromeDriver();
		}
		return driver;
	}

}
