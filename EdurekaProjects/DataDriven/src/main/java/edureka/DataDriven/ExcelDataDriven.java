package edureka.DataDriven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import utils.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataDriven {

	WebDriver driver;

	@BeforeSuite
	public void Start() {
		System.out.println("Let's Go");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void testConfigs() throws InvalidFormatException, IOException {
		String url = ConfigurationManager.getConfigs()[0][1];
		System.err.println(url);
	}

	@Test
	public void test2() throws InvalidFormatException, IOException {
		HashMap<String, String> configs = ExcelReader.getConfigdata("", "");
		System.err.println(configs.get("url"));
	}

	@Test(dataProvider = "Wrong_Data")
	public void testWithWrongExcelData(String username, String password) throws InvalidFormatException, IOException {

		HashMap<String, String> configs = ExcelReader.getConfigdata("", "");

		driver.get(configs.get("url"));

		WebElement email = driver.findElement(By.id(configs.get("username")));
		email.clear();
		email.sendKeys(username);

		driver.findElement(By.id(configs.get("password"))).clear();
		driver.findElement(By.id(configs.get("password"))).sendKeys(password);

		driver.findElement(By.id(configs.get("loginButton"))).click();
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// By.cssSelector("")

		// WebElement recoverElement = wait
		// .until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Recover")));
		// recoverElement.click();

		driver.findElement(By.partialLinkText("Recover")).click();
		
		//Screenshot of the Recover Page of Facebook :
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("Screenshots\\screenShot1"+username+".png"));
		
		//Validation of the page using Assert
		boolean isDisplayed = driver.findElement(By.xpath(".//*[@id='identify_yourself_flow']//h2[@class='uiHeaderTitle']")).isDisplayed();
		assertEquals(isDisplayed, true);
		assertTrue(isDisplayed);
			}

	// @Test(dataProvider = "Correct_Data")
	public void testWithCorrectExcelData(String username, String password) {
		driver.get("http://www.facebook.com");
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(username);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("u_0_q")).click();
		// Thread.sleep(5000);

	}

	@DataProvider(name = "Correct_Data")
	public String[][] getCorrectData() throws InvalidFormatException, IOException {

		String correctData[][] = ExcelReader.getCellData("Data/TestScript.xlsx", "Correct Data");
		return correctData;
	}

	@DataProvider(name = "Wrong_Data")
	public String[][] getWrongData() throws InvalidFormatException, IOException {

		String wrongData[][] = ExcelReader.getCellData("Data/TestScript.xlsx", "Wrong Data");
		return wrongData;
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}
}
