import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment31 {

	static void setup() {
		System.setProperty("webdriver.gecko.driver", "C:/softwares/selenium-drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");
	}

	public static void main(String args[]) {
		setup();
		List<WebDriver> drivers = new ArrayList<WebDriver>();
		WebDriver chromeDriver = new ChromeDriver();
		WebDriver fireFoxDriver = new FirefoxDriver();
		drivers.add(chromeDriver);
		drivers.add(fireFoxDriver);
		for (WebDriver driver : drivers) {
			runTest(driver);
		}
	}

	static void runTest(WebDriver driver) {
		driver.get("http://facebook.com");
	}

}
