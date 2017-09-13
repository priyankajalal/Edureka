package edureka.selenium_test;
import utils.DriverManager;
import utils.ExcelReader;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTestApp {
	
	private static final Object[][] String = null;


	@BeforeSuite
	public void BeforeNote(){
		System.out.println("Lets Start");
	}
	
	@Test(dataProvider = "getDataFromExcelSheet")
	public void testWithExcelData(String username,String password,String browser ){
		
		System.out.println(username);
		
		WebDriver driver = DriverManager.getDriver(browser);
		driver.get("http:/www.facebook.com");
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
    	email.sendKeys(username);
    	WebElement pass = driver.findElement(By.id("pass"));
    	pass.clear();
    	pass.sendKeys(password);
    	driver.findElement(By.id("u_0_u")).click();
		}
	
	
	@DataProvider
	public String[][] getDataFromExcelSheet() throws InvalidFormatException,IOException{
		
		String data[][]=ExcelReader.getCellData("data/Book1.xlsx", "Facebook");
		
		return data;
		
	}
}
