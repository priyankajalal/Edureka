package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookWithAssert {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.chartlabpro.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFaceBookWithAssert() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("LoginForm_username")).clear();
    driver.findElement(By.id("email")).sendKeys("golden2424");
    driver.findElement(By.id("LoginForm_password")).clear();
    driver.findElement(By.id("pass")).sendKeys("riley");
    driver.findElement(By.cssSelector(".btn-blue1")).click();
    assertEquals("Welcome golden2424 !", driver.findElement(By.cssSelector(".SignUpButtonShow>em")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

}

