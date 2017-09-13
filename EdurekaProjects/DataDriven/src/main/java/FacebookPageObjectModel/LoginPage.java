package FacebookPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginPage {
	
	WebDriver driver;

	public void getLoginPage(WebDriver driver){
		this.driver = driver;
		driver.get("http://www.facebook.com");
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("priyankajalaldit@gmail.com");
		
		WebElement pass = driver.findElement(By.id("pass"));
		pass.clear();
		pass.sendKeys("Priyanka123$");
		pass.submit();
		//WebElement loginButton = driver.findElement(By.id("u_0_u"));
		//loginButton.click();
	} 

}
