package org.practice.mine;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

public class EdurekaPractice {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		///driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@Test
	public void AssertTest(){
		driver.get("http:/www.google.com");
		WebElement searchElement = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		String elementText = searchElement.getText();
		System.out.println(elementText);
		//Assert.assertEquals("butter1", searchText);		
	}
	
	@Ignore
	//To Validate if the field is Read-Only or not
	public void Readable(){
		
		driver.get("http:/www.facebook.com");
		WebElement monthElement = driver.findElement(By.id("month"));
		monthElement.sendKeys("5");
		
		String monthValue = monthElement.getAttribute("value");
		if (monthValue.equals("5")){
			System.out.println("Field is not Read-Only");
		}
		else {
			System.out.println("Field is Read-Only ");
		}
		
		//To Validate if field is Disabled or Enabled
		boolean disabled = monthElement.isEnabled();
		System.out.println(disabled);
	}
	
//	@Ignore
//	public void DragDrop()
//	{
//		driver.get("file:///C:/projects/EdurekaProjects/SeleniumPractice/src/html/DragDrop.html");
//		WebElement dragElement = driver.findElement(By.id("obj1")); 
//		WebElement dropElement = driver.findElement(By.id("obj2"));
//		
//		Actions builder = new Actions(driver);
//		Action dragAndDrop = builder.clickAndHold(dragElement).moveToElement(dropElement);
//		dragAndDrop.perform();
//	}
	
	
	@Ignore
	public void EduTest(){
		driver.get("http:/www.facebook.com");
		System.out.println("Title is : "+driver.getTitle());
		System.out.println("Current URL is : "+driver.getCurrentUrl());
		
		driver.findElement(By.id("email")).sendKeys("sfasiubnso");
		driver.navigate().refresh();
		driver.navigate().to("http:/www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
	}
	
	@After
	public void After(){
				
	}
}
