package org.test.facebook;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");

		driver = new ChromeDriver();

	}

	@Test
	public void testFbLogin()
	{
		driver.get("http://facebook.com");
	}

}
