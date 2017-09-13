package test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		
	}
	
	@Test(dataProvider = "loginData")
		public void Login(String username,String password) throws Exception{
		
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(username);
		WebElement pass = driver.findElement(By.id("pass"));
		pass.clear();
		pass.sendKeys(password);
		driver.findElement(By.id("u_0_u")).click();
		Thread.sleep(3000);
		//assert.
	}
	
	@DataProvider
	public Object[][] loginData(){
		Object[][] data = new Object[3][2];
		
		data[0][0] = "username1";
		data[0][1] = "password1";
		
		data[1][0] = "username2";
		data[1][1] = "password2";
		
		data[2][0] = "username3";
		data[2][1] = "password3";
	
		return data;
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
