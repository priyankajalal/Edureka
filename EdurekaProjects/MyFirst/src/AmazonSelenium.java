
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AmazonSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:/softwares/geckodriver.exe");
	System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");    
    driver = new FirefoxDriver();
    baseUrl = "https://www.amazon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAmazon() throws Exception 
  {
	  
	try {  	
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys("vinodnaya1981@gmail.com");
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("p0o9i8u7");
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys("vinodnayal1981@gmail.com");
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("Advit123$");
    driver.findElement(By.id("signInSubmit")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("#nav-orders > span.nav-line-2")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("a-autoid-3-announce")).click();
    Thread.sleep(8000);
    driver.findElement(By.cssSelector("#nav-link-accountList > span.nav-line-2 > span.nav-icon.nav-arrow")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("#nav-item-signout > span.nav-text")).click();
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys("vinodnaya1981@gmail.com");
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("p0o9i8u7");
	}
	
	catch (Exception ex){
		System.out.println(ex);
	}
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
