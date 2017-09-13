package common;

import org.openqa.selenium.WebDriver;

public class WindowHandle {
	
	public static void getWindowHandle(WebDriver driver,String parentHandle) throws InterruptedException{
		for (String winHandle : driver.getWindowHandles()){
			if (!winHandle.equals(parentHandle)){
				driver.switchTo().window(winHandle);
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(parentHandle);
			}
		}
		
	}

}
