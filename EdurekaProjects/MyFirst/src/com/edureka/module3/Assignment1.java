package com.edureka.module3;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import java.util.concurrent.TimeUnit;
//import com.edureka.module3.Assignment1_Firefox;


public class Assignment1{
	
	static void setUp() 
	{
		
		System.setProperty("webdriver.gecko.driver", "C:/softwares/selenium-drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");
			
	}

	public static void main(String args[]) throws Exception{
		
		setUp();
		WebDriver chromeDriver = new ChromeDriver();
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		List<WebDriver> drivers = new ArrayList<WebDriver>();
		drivers.add(fireFoxDriver);
		drivers.add(chromeDriver);
		
		
		for (WebDriver driver : drivers) {
			runTest(driver);
			driver.quit();
		}

     }
	
		static void runTest(WebDriver driver) throws Exception
		  {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.gmail.com");
			driver.findElement(By.linkText("Sign In")).click();
			driver.findElement(By.id("account-chooser-add-account")).click();
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Email")).sendKeys("emailid");
			driver.findElement(By.id("next")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("Passwd")).clear();
			driver.findElement(By.id("Passwd")).sendKeys("password_gmail");
			driver.findElement(By.id("signIn")).click();
		}
		}