package FacebookPageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhotosPage {
	
	WebDriver driver;

	public void getPhotos(WebDriver driver){
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement priyankaElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Priyanka")));
		priyankaElement.click();
		//driver.findElement(By.linkText("Priyanka")).click();
		//driver.findElement(By.linkText("Your Photos"));
		driver.findElement(By.partialLinkText("Photos")).click();
	}

	
}
