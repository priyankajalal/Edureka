package test.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	public WebDriver driver;

	@BeforeSuite
	public void launchApp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://senchatutorials.in/");
	}

	@Test(dataProvider = "getData")
	public void testSenchaLogin(String Username, String Password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("(//span[text()='Sign In'])[2]")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//font[text()='SenchaExtJSOverview']")).isDisplayed(),
				"Login Failed");
		System.out.println("Login successful");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		
		
		data[0][0] = "username1@gmail.com";
		data[0][1] = "pssword1";
		
		data[1][0] = "username3@gmail.com";
		data[1][1] = "password3";
		
		data[2][0] = "test@gmail.com";
		data[2][1] = "Testing";
		return data;
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}