package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Birthday {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBirthday() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("priyankajalaldit@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("Priyanka123$");
    driver.findElement(By.cssSelector("#u_0_r > #pass")).clear();
    driver.findElement(By.cssSelector("#u_0_r > #pass")).sendKeys("Priyanka123$");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=_e_0EbQ | ]]
    driver.findElement(By.id("u_0_u")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=_e_0EbQ | ]]
    driver.findElement(By.cssSelector("strong")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=_e_0EbQ | ]]
    driver.findElement(By.id("u_a_5")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=_e_0EbQ | ]]
    driver.findElement(By.id("u_a_5")).clear();
    driver.findElement(By.id("u_a_5")).sendKeys("Happy");
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
