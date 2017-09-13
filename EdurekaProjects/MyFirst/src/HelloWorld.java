import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

	public static void main(String[] args){
		
		try {
		System.setProperty("webdriver.gecko.driver", "C:/softwares/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("priyankajalaldit@gmail.com");
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.cssSelector("input#pass")).sendKeys("Priyanka123$");
		
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(9000);
		
		driver.findElement(By.cssSelector(".fbRemindersTitle")).click();
		
		}
		
		
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}

}
