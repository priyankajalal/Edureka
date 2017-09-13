package edureka.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class KeyboardAndMouseInteraction {
	
	@BeforeClass
	public void testStart(){
		
	}

	@Test
	public void keyBoardActions(){
		WebDriver driver = new ChromeDriver();
		
		driver.get("http:/www.facebook.com");
		WebElement email = driver.findElement(By.id("email"));
		
		Actions loginAction = new Actions(driver);
		Action performLogin = loginAction.moveToElement(email).click().sendKeys("test").sendKeys(Keys.TAB);
		
		
	}
	
	@AfterClass
	public void closing(){
		
	}
}

