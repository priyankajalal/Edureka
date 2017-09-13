package com.edureka.module3;
//import java.util.regex.Pattern;
///import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;


public class Assignment2 {
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "C:/softwares/selenium-drivers/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		
		//Google Text Presence:
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		
		if (expectedTitle.equals(actualTitle)){
			System.out.println("Correct title is dislayed on the webpage.");
		}
		else{
			System.out.println("Web page title is incorrect");
		}
		
		// Google Search Button Presence:
		boolean googlesearchbuttonPresence = driver.findElement(By.xpath("//*[@class='jsb']/center/input[1]")).isDisplayed();	
		// Verify if Google Search Button is Enabled :
		boolean googlesearchbuttonEnabled = driver.findElement(By.xpath("//*[@class='jsb']/center/input[1]")).isEnabled();
		System.out.println(googlesearchbuttonPresence);		
		System.out.println(googlesearchbuttonEnabled);
	}

} 
