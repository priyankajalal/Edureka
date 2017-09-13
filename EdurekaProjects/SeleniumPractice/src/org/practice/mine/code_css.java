package org.practice.mine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class code_css {
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testRun()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http:/www.amazon.com");
		
		WebElement dropDownType=  driver.findElement(By.id("searchDropdownBox"));
		
		
		Select select = new Select(dropDownType);
		
		select.selectByVisibleText("Baby");
		//select.selec
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Diapers");
		driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();
		
		
	//	Select myselect= new Select(driver.findElement(By.cssSelector("select#searchDropdownBox")));
		//myselect.selectByVisibleText("Amazon Video");
		//myselect.selectByValue("search-alias=amazonfresh");
		//WebElement option = myselect.getFirstSelectedOption();
		//option.click();
	}
	
	
	@After
	public void After(){
		
	}
}
