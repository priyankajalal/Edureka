package org.test.ngtest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FaceBookTest {
	

	WebDriver driver;
	@BeforeClass
	public void init()
	{
		System.out.println("starting");
		System.setProperty("webdriver.gecko.driver", "C:/softwares/geckodriver.exe");
		//driver = new FirefoxDriver();
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("started");
	}
	
	@Test
	public void testMe()
	{
		String baseUrl = "https://www.facebook.com/";
		System.out.println("testing");
		//driver.get(baseUrl);
		assertEquals("sss", "sss");
		
	}
	
	@Test
	public void testMe2()
	{
		String baseUrl = "https://www.facebook.com/";
		System.out.println("testing");
		driver.get(baseUrl);
		assertEquals("", "sss");
		
	}
	
	@AfterClass
	public void close()
	{
		System.out.println("closing");	
	}

}
