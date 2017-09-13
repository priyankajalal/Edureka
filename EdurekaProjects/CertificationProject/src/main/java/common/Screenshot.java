package common;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
// org.openqa.selenium.firefox.FirefoxDriver;


public class Screenshot {
				
		public static void takeScreenshot(WebDriver driver) throws IOException {		
		//driver.get(url);
		String fileName = new SimpleDateFormat("mmddyyyy_hhmmss").format(Calendar.getInstance().getTime());
		fileName = fileName + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("Screenshots\\" + fileName));
		System.out.println("Screenshot Taken");
	}
}


