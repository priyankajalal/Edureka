package AssignmentPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PimcoreTest {
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		driver = new ChromeDriver();
		driver.get("https://www.pimcore.org/en/resources/try-now");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void MenuActions(){
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.get("http://www.gooogle.com");
		try{
			Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
		}
		catch(Exception ex){
			System.out.println(ex);
		}
//		//Actions action = new Actions(driver);
//		WebElement menu1 = driver.findElement(By.partialLinkText("PRODUCTS"));
//		//action.click(menu1).build().perform();
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
//		driver.get("http://www.google.com");
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
		
//		WebElement subMenu1_1 = driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[1]/div/ul[1]/li[1]/ul/li[1]/a/div"));
//		String subMenus = driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[1]/div/ul[1]/li[1]/ul//a")).getText(); 
//		if (subMenu1_1 != null){
//			System.out.println("First SubMenu is :" + subMenu1_1.getText());
//		}
//	
//		WebElement subMenu1_2 = driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[1]/div/ul[1]/li[1]/ul/li[2]/a/div")); 
//		if (subMenu1_2 != null){
//			System.out.println("Second SubMenu is :" + subMenu1_2.getText());
//		}
		
	}
	
}
