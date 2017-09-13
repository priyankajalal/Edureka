package PriyankaTestNgDependency;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class OnGroups {
	
	WebDriver driver;
	
	@BeforeSuite
	public void Start(){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			driver.manage().window().maximize();
	}
	
	
	@Test(groups = {"tier-1"})
	@Parameters({"username","password","url"})
	public void test1(String username,String password,String url) throws InterruptedException{
		System.out.println("test1 depends on tier-1 ");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		
		WebElement email = driver.findElement(By.id("email"));
    	email.clear();
    	email.sendKeys(username);
		
    	WebElement pass = driver.findElement(By.id("pass"));
    	pass.clear();
    	pass.sendKeys(password);
    	
    	Thread.sleep(3000);
    	driver.findElement(By.id("u_0_u")).click();
    	
    	//System.out.println("Credentials are : "+" , "+password);
	}

	@Test(groups = {"tier-2"})
	public void test2() throws Exception{
		System.out.println("test2 depends on tier-2 ");
		assert(12==3);
		throw new Exception("Failed Test due to Assert Fail");
	}
	
	@Test(groups = {"tier-1"})
	public void test3(){
		System.out.println("test3 depends on tier-1 ");
	}
	
	@AfterSuite
	public void Closing(){
		driver.close();
	}
}
