
//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class FaceBookTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/softwares/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.facebook.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAceBook() throws Exception {
		try {
			driver.get(baseUrl + "/");
			// find email element
			WebElement emailElement = driver.findElement(By.id("email"));
			// clear it and set email id
			emailElement.clear();
			emailElement.sendKeys("priyankajalaldit@gmail.com");

			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys("Priyanka123$");

			driver.findElement(By.id("u_0_q")).click();
			Thread.sleep(5000);
			// Meaning of Assert   assertEquals(100,100);
			String title = driver.findElement(By.cssSelector("div.linkWrap.noCount")).getText();
		    assertEquals("Priyanka Jalal Nayal",title);

		    
			driver.findElement(By.cssSelector("a._2s25 > span")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Photos")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("logoutMenu")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Log Out")).click();
			Thread.sleep(5000);
			// for (int second = 0;; second++) {
			// if (second >= 60)
			// fail("timeout");
			//
			// if ("(1) Priyanka Jalal Nayal".equals(driver.getTitle()))
			// break;
			//
			// Thread.sleep(1000);
			// }
		} catch (Exception ex) {
			System.out.println(ex);

		}

	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
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
