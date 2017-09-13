package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverManager {

	public static WebDriver getDriver(String name) {
		WebDriver driver = null;
		if (name.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (name.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		return driver;
	}

}
