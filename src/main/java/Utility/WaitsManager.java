package Utility;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsManager {

	By dtElement;
	LocalTime currentTime;
	public static String dateFormat = "MM-dd-yyyy";
	public static String timeFormat = "HH:mm:ss";

	protected static WebDriver driver;

	/**
	 * Retrieve the WebDriver used from the DriverManager.
	 */
	public WaitsManager() {
		WaitsManager.driver = DriverManager.getDriver();
	}

	public void clickNewTab() {
		WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.chord(Keys.CONTROL, "t")); 
	}
	
	/**
	 * This method will switch the focus from the current window to the new window.
	 */
	public void switchToNewWindow() {
		// Retrieve the instances of windows
		Set<String> windowHandles = driver.getWindowHandles();

		// Switch the focus from the current window to the new window
		String currentWindowHandle = driver.getWindowHandle();
		windowHandles.remove(currentWindowHandle);
		String newWindowHandle = windowHandles.iterator().next();
		driver.switchTo().window(newWindowHandle);
	}

	/**
	 * This method will switch the focus to the main window.
	 * 
	 * @param mainWindowHandle - Main Window
	 */
	public void switchToMainWindow(String mainWindowHandle) {
		// Switch the focus to the main window
		driver.switchTo().window(mainWindowHandle);
	}

	public void isWindowPresent(By locator, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElement(By locator, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementToBeClickable(By locator, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementToBePopulated(By locator, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = driver.findElement(locator);
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(webElement, "value", "")));
	}

	public void waitForWindow(int numberOfWindows, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
	}

	public static boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.isEmpty() || str.length() == 0) {
			// All elements are either null or empty (whitespace)
			return true;
		}
		// All elements are either null or empty (whitespace)
		return false;
	}

	public static boolean isNullOrEmpty(String[] str) {
		if (str == null || str.length == 0) {
			// All elements are either null or empty (whitespace)
			return true;
		}

		for (String element : str) {
			if (element != null && !element.trim().isEmpty()) {
				// Array has a non-empty element
				return false;
			}
		}

		// All elements are either null or empty (whitespace)
		return true;
	}

	public static List<String> getAllIframeTexts() {
		// Find all iframes in the page
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		List<String> iframeTexts = new ArrayList<>();

		for (WebElement iframe : iframes) {
			String iframeId = iframe.getAttribute("id");
			if (iframeId != null && !iframeId.isEmpty()) {
				iframeTexts.add(iframeId);
			}
		}

		return iframeTexts;
	}

	public void populateDateField(LocalDate date, By dateElement) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		String formattedDate = date.format(formatter);
		dtElement = dateElement;
		waitForElement(dtElement, 10);
		driver.findElement(dtElement).sendKeys(formattedDate);
	}

	public String getFormattedTime(LocalTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
		String formattedTime = time.format(formatter);

		return formattedTime;
	}

	public void waitTime(WebDriver driver) throws InterruptedException {
		Thread.sleep(500);
	}

	public void waitTime1(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
	}

	public void waitTime2(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
	}

	public void waitTime3(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
	}

	public void waitTime5(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
	}

	public void waitTime15(WebDriver driver) throws InterruptedException {
		Thread.sleep(15000);
	}

	public void waitTime10(WebDriver driver) throws InterruptedException {
		Thread.sleep(10000);
	}

	public void waitTime30(WebDriver driver) throws InterruptedException {
		Thread.sleep(30000);
	}

	public void waitTime60(WebDriver driver) throws InterruptedException {
		Thread.sleep(30000);
	}

	public void implWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void switchToLastTab() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.getLast());
	}
	public void switchToFirstTab() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.getFirst());
		driver.switchTo().defaultContent();
	}
//	public void switchTab() {
//
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
//	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

}
