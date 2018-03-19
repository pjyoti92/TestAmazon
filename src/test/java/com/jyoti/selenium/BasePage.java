package com.jyoti.selenium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

/**
 * This class provide all the method performing operations
 * 
 * @author Jyoti Pareek
 *
 */
public class BasePage {

	public static WebDriver driver = null;
	public static WebDriverWait waitVar = null;
	public static String baseURL = "https://www.amazon.in/";
	public static Actions action;
	public static JavascriptExecutor jse;

	/**
	 * 
	 * @param browserType
	 *            is taking user's browser name
	 * @param appUrl
	 *            is taking the url of the website to be worked upon
	 * @throws MalformedURLException
	 *             is thrown when URL is not correct
	 * @throws InterruptedException
	 *             is shown when there is any issue with the connection
	 */
	public void createDriver(String browserType, String appUrl) throws MalformedURLException, InterruptedException {

		switch (browserType) {
		// check our browser
		case "Firefox": {
			driver = new FirefoxDriver();
			break;
		}
		case "Chrome": {
			System.setProperty("webdriver.chrome.driver", "J:/TestAmazon/Cucumber-Test/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case "InternetExplorer": {
			System.setProperty("webdriver.ie.driver", "J:/TestAmazon/Cucumber-Test/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		case "Safari": {
			driver = new SafariDriver();
			break;
		}
		// if our browser is not listed, throw an error
		default: {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		// open a new driver instance to our application URL
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		action = new Actions(driver);
		jse = (JavascriptExecutor) driver;
		driver.get(baseURL);
		waitVar = new WebDriverWait(driver, 15);
	}

	/**
	 * Closes the browser instance
	 */
	@After
	public void teardown() {
		driver.quit();
	}

	/**
	 * Validates if the text is displayed on the page
	 */
	public void isTodaysDealDisplayed() {
		WebElement element = new Elements(driver).TodayDealText;
		waitVar.until(ExpectedConditions.visibilityOf(element));
		(element).isDisplayed();
	}

	/**
	 * Performs hovering operation
	 */
	public void hoverCategoryLink() {
		WebElement element = new Elements(driver).Category;
		waitVar.until(ExpectedConditions.visibilityOf(element));
		jse.executeScript("window.scrollTo(0," + element.getLocation().y + ")");
		action.moveToElement(element).clickAndHold().perform();
	}

	/**
	 * Makes driver to sleep for some time
	 * 
	 * @param i
	 *            is taking the amount of wait
	 */
	public void WaitForTime(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Moves control to new tab
	 */
	public void validateNewTab() {
		String current_title = driver.getTitle();
		System.out.println(current_title);
		assertTrue("All Deals are displayed in new page",
				current_title.contains("Amazon.in Today's Deals: Great Savings. Every Day."));
	}

	/**
	 * Switch the control to the new drivre window
	 */
	public void switch_window() {
		Set<String> handles = driver.getWindowHandles();
		String current_window = driver.getWindowHandle();
		handles.remove(current_window);
		String second_handle = handles.iterator().next();
		String winHandle = handles.iterator().next();
		if (winHandle != current_window) {
			second_handle = winHandle;
			driver.switchTo().window(second_handle);
		}
	}

	/**
	 * Take screenshot
	 */
	public void take_screenshots() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File currDir = new File("");
		String path = currDir.getAbsolutePath();
		File DestFile = new File(path + "/src/test/java/screenshot/Screenshot.png");
		try {
			FileUtils.copyFile(src, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To click on Link and button
	 * 
	 * @param linkName
	 *            is the varible taking the input , which link to click
	 */
	public void clickonLink(String linkName) {
		switch (linkName) {
		case "SeeAllDealsLink":
			WebElement element = new Elements(driver).SeeAllDealsLink;
			waitVar.until(ExpectedConditions.visibilityOf(element));
			element.click();
			break;
		case "BabyLink":
			WebElement baby = new Elements(driver).Baby;
			waitVar.until(ExpectedConditions.visibilityOf(baby));
			baby.click();
			break;
		case "BeautyLink":
			WebElement beauty = new Elements(driver).Beauty;
			waitVar.until(ExpectedConditions.visibilityOf(beauty));
			beauty.click();
			break;
		case "SignInLink":
			WebElement signInLink = new Elements(driver).SignIn;
			waitVar.until(ExpectedConditions.visibilityOf(signInLink));
			signInLink.click();
			break;
		case "ContinueButton":
			WebElement button = new Elements(driver).Continue;
			waitVar.until(ExpectedConditions.visibilityOf(button));
			button.click();
			break;
		case "LoginButton":
			WebElement loginbutton = new Elements(driver).Submit;
			waitVar.until(ExpectedConditions.visibilityOf(loginbutton));
			loginbutton.click();
			break;
		default:
			System.out.println("Not a valid link name" + linkName);
		}
	}

	/**
	 * Method is to send keys into text field
	 * 
	 * @param inputFieldName
	 *            is to take the inputfieldname from user
	 * @param text
	 *            is the text value to be input
	 */
	public void inputText(String inputFieldName, String text) {
		switch (inputFieldName) {
		case "UserId":
			WebElement username = new Elements(driver).UserId;
			waitVar.until(ExpectedConditions.visibilityOf(username));
			username.sendKeys(text);
			break;
		case "Password":
			WebElement password = new Elements(driver).Password;
			waitVar.until(ExpectedConditions.visibilityOf(password));
			password.sendKeys(text);
			break;
		default:
			System.out.println("Not a valid inputfield name");
		}
	}

	/**
	 * Validate logged in details
	 */
	public void validate_login() {
		WebElement element = new Elements(driver).UserDetails;
		String text = element.getText();
		waitVar.until(ExpectedConditions.visibilityOf(element));
		assertTrue("Logged in with correct user", text.contains("Hello, Jyoti"));

	}
}
