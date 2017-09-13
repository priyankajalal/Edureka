package edureka.selenium_test;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AmazonTest {

	@Test
	public void test(){
		try{
		
	WebDriver driver = new FirefoxDriver();
	driver.get("http:/www.facebook.com");
	driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("fguihjk@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("byhjn23$");
    driver.findElement(By.id("u_0_u")).click();
   Assert.assertEquals("Sign up for an ccount", driver.findElement(By.xpath("//*[@id='js_0']/div/div/div/a"))
    		.getText());
		}
	
	catch (Exception ex){
		System.out.println(ex);
	}
	

	}
}