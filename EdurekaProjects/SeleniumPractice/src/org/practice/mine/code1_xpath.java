package org.practice.mine;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class code1_xpath {

	WebDriver driver;

	@Before

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/softwares/selenium-drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Ignore
	public void testRadioByGroup() {

		driver.get("http:/www.facebook.com");

		List<WebElement> radioButtonsSex = driver.findElements(By.xpath("//*[@name='sex']"));
		if (!radioButtonsSex.get(1).isSelected()) {
			radioButtonsSex.get(1).click();
		}
	}

	@Test
	public void testRadioDirectly() {

		driver.get("http:/www.facebook.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement email = driver.findElement(By.xpath("//*[@id='email']"));

		email.clear();
		email.sendKeys("priyankajalaldit@gmail.com");
		WebElement femaleRadioButton = driver.findElement(By.id("u_0_m"));
		boolean isSelected = femaleRadioButton.isSelected();

		if (!isSelected) {
			email.clear();
			email.sendKeys("not selected");
			femaleRadioButton.click();

		} else {
			email.clear();
			email.sendKeys(" selected");
		}
	}

	@Ignore
	public void test() throws Exception {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http:/www.facebook.com");

		driver.findElement(By.xpath("//*[@id='email']")).clear();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("priyankajalaldit@gmail.com");

		driver.findElement(By.xpath("//*[@id='email']/following::input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='email']/following::input[1]")).sendKeys("Priyanka123$");

		driver.findElement(By.xpath("//*[contains(@type,'submit')]")).click();

		driver.findElement(By.xpath("//div[starts-with(text(),'Account')]")).click();
		// driver.findElement(By.xpath("//*[@class='f_click']")).click();

	}

	@After
	public void afterTest() {
		// driver.quit();

	}

}