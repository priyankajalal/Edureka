package com.edureka.certification.test;

import utils.ObjectLocator;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.DriverManager;
import common.LoginPage;
import common.Screenshot;
import common.WindowHandle;
import utils.DriverUtil;
import utils.JavascriptUtils;
import utils.ObjectLocator;

public class ExecuteTest {

	public WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		driver = DriverManager.getDriver(browser);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	@Parameters({ "userName", "password", "url", "browser", "postTitle", "postBody", "tags" })
	public void addNewPostTest(String userName, String password, String url, String browser, String postTitle,
			String postBody, String tags) throws InterruptedException, IOException {

		driver.manage().window().maximize();
		driver.get(url);

		LoginPage login = new LoginPage(driver, userName, password, url);

		// Click on Post
		DriverUtil.getWhenVisible(driver, ObjectLocator.getInstance().getElement("addNewPost", "postButton")).click();

		// Click on Add Post
		DriverUtil.getWhenVisible(driver, ObjectLocator.getInstance().getElement("addNewPost", "addPost")).click();

		DriverUtil.getWhenVisible(driver, ObjectLocator.getInstance().getElement("addNewPost", "htmlTab")).click();

		// Write on title field
		WebElement titleElement = DriverUtil.getWhenVisible(driver,
				ObjectLocator.getInstance().getElement("addNewPost", "postTitle"));
		DriverUtil.typeText(titleElement, driver, postTitle);

		// Write on post body
		WebElement postBodyElement = DriverUtil.getWhenVisible(driver,
				ObjectLocator.getInstance().getElement("addNewPost", "postBody"));
		DriverUtil.typeText(postBodyElement, driver, postBody);

		// Asking for parent Window and saving it in a variable parentHandle
		String parentHandle = driver.getWindowHandle();

		// Adding Tag to the post
		DriverUtil.typeText(driver.findElement(ObjectLocator.getInstance().getElement("addNewPost", "tagInput")),
				driver, tags);

		// Click on Add button
		driver.findElement(ObjectLocator.getInstance().getElement("addNewPost", "addTagButton")).click();

		// Screenshot of the Post
		Screenshot.takeScreenshot(driver);

		// Save post as Draft
		WebElement saveDraftElement = driver
				.findElement(ObjectLocator.getInstance().getElement("addNewPost", "savePost"));
		JavascriptUtils.jsClick(driver, saveDraftElement);

		// Preview the Post
		WebElement previewElement = driver
				.findElement(ObjectLocator.getInstance().getElement("addNewPost", "previewPost"));
		JavascriptUtils.jsClick(driver, previewElement);

		// Screenshot of the Preview window
		Screenshot.takeScreenshot(driver);

		Thread.sleep(3000);
		// Closing other window other than parent window
		WindowHandle.getWindowHandle(driver, parentHandle);
	}

	// @Test(priority = 2)
	@Parameters()
	public void checkPostTest() throws IOException {

		// Click on 'All Post'
		driver.findElement(ObjectLocator.getInstance().getElement("checkpost", "allPost")).click();

		// Verifying the Post
		WebElement baseTable = driver.findElement(ObjectLocator.getInstance().getElement("checkpost", "baseTable"));
		List<WebElement> tableRows = baseTable
				.findElements(ObjectLocator.getInstance().getElement("checkpost", "tableRow"));

		WebElement foundPost = null;
		for (WebElement row : tableRows) {
			if (row.getText().contains("Selenium test2")) {
				foundPost = row.findElement(ObjectLocator.getInstance().getElement("checkpost", "foundPost"));
				break;
			}
		}
		if (foundPost != null) {
			// Screenshot of the found post
			Screenshot.takeScreenshot(driver);

			foundPost.click();
		}
	}

	// @Test(priority = 3)
	public void screenOptionsTest() throws InterruptedException, IOException {

		// driver = DriverManager.getDriver(browser);

		WebElement screenOptionsElement = driver
				.findElement(ObjectLocator.getInstance().getElement("screenOptions", "screenOptions"));
		screenOptionsElement.click();

		WebElement categoriesElement = driver
				.findElement(ObjectLocator.getInstance().getElement("screenOptions", "categories"));

		// Uncheck the Category checkbox
		boolean selected_status = categoriesElement.isSelected();
		if (selected_status != false) {
			categoriesElement.click();

			// Screenshot of the Category checkbox in Select option
			Screenshot.takeScreenshot(driver);

		} else {
			System.out.println("Categories checkbox already checked");
		}

		// Asking for parent Window and saving it in a variable parentHandle
		String parentHandle = driver.getWindowHandle();

		screenOptionsElement.click();

		// Preview the Post
		WebElement previewElement = driver
				.findElement(ObjectLocator.getInstance().getElement("screenOptions", "preview"));
		previewElement.click();

		Thread.sleep(3000);

		// Closing other window other than parent window
		WindowHandle.getWindowHandle(driver, parentHandle);
	}

	// @Test(priority = 4)
	@Parameters("searchInput")
	public void searchPost(String searchInput) throws IOException {

		// Click on Post
		DriverUtil.getWhenVisible(driver, ObjectLocator.getInstance().getElement("searchPost", "post")).click();

		// Enter into search input box
		WebElement searchInputBoxElement = driver
				.findElement(ObjectLocator.getInstance().getElement("screenOptions", "searchInputBox"));
		searchInputBoxElement.sendKeys(searchInput);

		// Screenshot of search result
		Screenshot.takeScreenshot(driver);

		// Click on search post button
		driver.findElement(ObjectLocator.getInstance().getElement("screenOptions", "searchPostButton")).click();

		WebElement baseTable = driver.findElement(ObjectLocator.getInstance().getElement("screenOptions", "baseTable"));
		baseTable.findElement(ObjectLocator.getInstance().getElement("screenOptions", "rowTitlle")).click();

		System.out.println("Search Completed");

		// Delete searched post
		WebElement deletePost = baseTable
				.findElement(ObjectLocator.getInstance().getElement("screenOptions", "deletePost"));
		JavascriptUtils.jsClick(driver, deletePost);
	}

	@Test
	public void trashCheckedPosts() {

		// Click All Posts link
		WebElement allPostsElement = driver
				.findElement(ObjectLocator.getInstance().getElement("trashCheckedPost", "allPostsLink"));
		allPostsElement.click();

		// Select Title checkbox
		WebElement titleCheckboxElement = driver
				.findElement(ObjectLocator.getInstance().getElement("trashCheckedPost", "titleCheckbox"));
		titleCheckboxElement.click();

		// Verify Bulk Actions dropdown is ReadOnly
		WebElement bulkActionElement = driver
				.findElement(ObjectLocator.getInstance().getElement("trashCheckedPost", "bulkAction"));
		bulkActionElement.sendKeys("Delete");

		String bulkActionValue = bulkActionElement.getAttribute("value");
		if (bulkActionValue.equals("Delete")) {
			System.out.println("Bulk Action Field is not Readonly.");
		} else {
			System.out.println("Bulk Action Field is Readonly.");
		}

		bulkActionElement.click();

		// Select 'Move to Trash' and click
		Select select = new Select(bulkActionElement);
		select.selectByVisibleText("Move to Trash");

	}

	// @Test(priority = 5)
	@Parameters("browser")
	public void logOut(String browser) throws IOException {

		WebElement HowdyElement = driver.findElement(ObjectLocator.getInstance().getElement("logout", "Howdy"));
		Actions actions = new Actions(driver);
		actions.moveToElement(HowdyElement);
		// System.out.println("Reached till here");

		WebElement logoutElement = driver.findElement(ObjectLocator.getInstance().getElement("logout", "logout"));

		JavascriptUtils.jsClick(driver, logoutElement);

		// Screenshot of logout window
		Screenshot.takeScreenshot(driver);
	}

}
