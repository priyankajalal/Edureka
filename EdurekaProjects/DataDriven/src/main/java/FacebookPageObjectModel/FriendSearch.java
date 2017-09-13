package FacebookPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FriendSearch {
	
	WebDriver driver;

	public void search_friend (WebDriver driver){
		this.driver = driver;
		
		WebElement searchInput = driver.findElement(By.xpath("//*[@id='u_7_2']/input[2]"));
		searchInput.clear();
		searchInput.sendKeys("Akansha Agrawal California");
		searchInput.submit();
		//WebElement friendsAccount = driver.findElement(By.xpath("//*[@id='xt_uniq_2']/div/div[1]/a"));
		//friendsAccount.click();
	}
}
