import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AmazonTest1 {
	
	public static void main(String[] args){
		
		try{
			
			System.setProperty("webdriver.gecko.driver", "C:/softwares/geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
			
			WebDriver driver= new FirefoxDriver();
			
			driver.get("http://www.amazon.com");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("a[id='nav-link-shopall']")).click();
			driver.findElement(By.cssSelector("a[title='All TV shows, movies, and more'")).click();
			//driver.findElement(By.xpath("//*[@title='All TV shows, movies, and more']/a")).click();
		}
		
		catch (Exception ex){
			System.out.println(ex);
		}
	}

}
