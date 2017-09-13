package test.selenium;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.DriverManager;
import util.ExcelReader;

public class TestFaceBook {

	// public WebDriver driver;

	@BeforeSuite
	public void launchApp() {
		// driver = new ChromeDriver();

	}

	@Test(dataProvider = "getLoginDataFromExcel")
	public void testWithBrowser(String userName, String password, String browser) {

		WebDriver driver = DriverManager.getDriverByName(browser);
		driver.get("http://facebook.in/");
		WebElement emailElement = driver.findElement(By.id("email"));
		// clear it and set email id
		emailElement.clear();
		emailElement.sendKeys(userName);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("u_0_q")).click();
	}

	// @Test(dataProvider = "getLoginDataFromExcel")
	// public void test(String userName, String password) {
	// driver.get("http://facebook.in/");
	// WebElement emailElement = driver.findElement(By.id("email"));
	// // clear it and set email id
	// emailElement.clear();
	// emailElement.sendKeys(userName);
	// driver.findElement(By.id("pass")).clear();
	// driver.findElement(By.id("pass")).sendKeys(password);
	// driver.findElement(By.id("u_0_q")).click();
	// }

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "abc@gmail.com";
		data[0][1] = "1234";

		data[1][0] = "abc111@gmail.com";
		data[1][1] = "1231114";
		return data;
	}

	@DataProvider
	public Object[][] getLoginDataFromExcel() throws InvalidFormatException, IOException {
		return ExcelReader.getCellData("data/user_data.xlsx", "wrongLogin");

	}

}
