package org.practice.my;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class xpath_code1 {

	WebDriver driver;

	@Before

	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:/softwares/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void test() throws Exception {

		driver.get("http:/www.facebook.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dfsfsdf");
		;
		/// driver.findElement(By.id("email"));
		/*
		 * driver.findElement(By.xpath("//[@id='email']"));
		 * driver.findElement(By.xpath("//[@id='email']")).clear();
		 * driver.findElement(By.xpath("//[@id='email']")).sendKeys(
		 * "priyankajalaldit@gmail.com");
		 * 
		 * driver.findElement(By.xpath("//[@id='email']/following::input[1]]"));
		 * driver.findElement(By.xpath("//[@id='email']/following::input[1]]")).
		 * clear();
		 * driver.findElement(By.xpath("//[@id='email']/following::input[1]]")).
		 * sendKeys("Priyanka123$");
		 * 
		 * driver.findElement(By.xpath("contains(type='submit')")).click();
		 */

	}

	@After
	public void afterTest() {
		// driver.quit();

	}

}