package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {
	
	public static void scrollToElement(WebDriver driver, WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
	}
	
	public static void scrollByCoordinatesofPage(WebDriver driver){
		((JavascriptExecutor) driver).executeScript("window.scrollBy(500,0)");
	}

	public static void scrollToElementsYposition(WebDriver driver,WebElement element){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
	}
	
	//Using Javascript to click on an Element 
	public static void jsClick(WebDriver driver, WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
	}
}
