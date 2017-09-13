package org.practice.mine;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAndAction {
	
	WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		///driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@Test
	public void testHeader() throws Exception {
		driver.get("http://www.w3schools.com/jsref/dom_obj_checkbox.asp");

		Actions action = new Actions(driver);

		//Click somewhere on Screen -- Overview link in leftside Menu
		WebElement webElement = driver.findElement(By.xpath("//a[contains(text(),'Overview')]"));
		webElement.click();

		// SCROLL DOWN
		for(int i = 0; i < 20; i++){
			action.sendKeys(Keys.DOWN).perform();
			Thread.sleep(500);
		}
		Thread.sleep(5000);

		// Move to TOP
		action.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(3000);

		// Press CTRL+A to select page data
		driver.get("http://www.opensourcecms.com//demo/1/319/InterPhoto+Image+Gallery");
		driver.switchTo().frame("mainFrame");
		webElement = driver.findElement(By.name("loginusername"));
		webElement.sendKeys("Edureka");
		webElement.click();
		
		System.out.println("VALUE : " + webElement.getAttribute("value"));
		Thread.sleep(3000);

	}

	@After
	public void tearDown() throws Exception {}
	

}



