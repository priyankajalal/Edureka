package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {	
	private static final WebDriver NULL = null;

	public static WebDriver getDriver(String browser){
		WebDriver driver = NULL;
		if (browser.equals("Chrome")){
			driver = new ChromeDriver();
		}
		else if (browser.equals("Firefox")){
			driver = new FirefoxDriver();
		}
		else if (browser.equals("IE")){
			driver = new InternetExplorerDriver();
		}
		else{
			driver = new ChromeDriver();
	} 
		
		return driver;
}
}
