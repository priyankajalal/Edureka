package FacebookPageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RunPage {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void RunMethod() throws InterruptedException{
		LoginPage login = new LoginPage();
		PhotosPage photos = new PhotosPage();
		FriendSearch search = new FriendSearch();
		
		login.getLoginPage(driver);
		//Thread.sleep(2000);
		photos.getPhotos(driver);
		search.search_friend(driver);		
		
	}
	
	@AfterSuite
	public void close(){
		driver.close();
	}

}
