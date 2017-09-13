package common;

import java.io.IOException;

//import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.Test;

import utils.ObjectLocator;

public class LoginPage {

	public LoginPage(WebDriver driver, String username, String password, String url) throws InterruptedException, IOException {

		// Validate if username input field is present
		WebElement usernameElement = driver.findElement(ObjectLocator.getInstance().getElement("login","email"));
		Assert.assertTrue(usernameElement.isDisplayed());
		
		// Validate if password input field is present
		WebElement passwordElement = driver.findElement(ObjectLocator.getInstance().getElement("login","password"));
		Assert.assertTrue(passwordElement.isDisplayed());

		usernameElement.clear();
		usernameElement.sendKeys(username);
		
		// Validating entered value is same or not in username field
		Assert.assertEquals(usernameElement.getAttribute("value"), username);
		
		passwordElement.clear();
		passwordElement.sendKeys(password);
		Thread.sleep(2000);
		
		// Validating entered value is same or not in username field
		Assert.assertEquals(passwordElement.getAttribute("value"), password);

		// Validate if login button is present and Enabled
		WebElement submit = driver.findElement(ObjectLocator.getInstance().getElement("login","submit"));
		Assert.assertTrue(submit.isDisplayed());
		Assert.assertTrue(submit.isEnabled());
		submit.click();
		
		//Validate if Home page is reached
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Dashboard ‹ WordPress Demo Install — WordPress");
	
		//Taking screenshot of the home page
		common.Screenshot.takeScreenshot(driver);
	}

}
