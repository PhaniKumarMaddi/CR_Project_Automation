package IntelliServe_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.WaitsManager;

public class Ticketing_LoginPage extends WaitsManager {
	static WebDriver driver;
	private static final Logger logger = LogManager.getLogger(Ticketing_LoginPage.class);
	GenerateReports grep = new GenerateReports();

	public Ticketing_LoginPage() {
		this.driver = DriverManager.getDriver();
	}

	By loginHeader = By.xpath("//p[@class='text-sm text-gray-500 dark:text-gray-400 mb-2']");
	By loginButton = By.xpath("//button[text()='SSO - Single Sign On']");
	By userName = By.xpath("//input[@id='i0116']");
	By password = By.xpath("//input[@id='i0118']");
	By signin = By.cssSelector("input#idSIButton9"); // for next , signin, yes buttons

	
	public void verifyLoginHeader() throws Exception {
		try {
			waitForElement(loginHeader, 60);
			String verifyLogin = driver.findElement(loginHeader).getText().trim();
			if (verifyLogin.toLowerCase().contains("ticketing system")) {
				logger.info("Inside Login Page: " + verifyLogin);
				grep.passTest("Inside Login Page: " + verifyLogin);
			} else {
				logger.error("Login Header is not Available: " + verifyLogin);
				grep.failTest("Login Header is not Available: " + verifyLogin);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void clickSSOLoginBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(loginButton).isEmpty();
			if (elementExists) {
				driver.findElement(loginButton).click();
			} else {
				logger.error("SSO Login Not Available ");
				grep.failTest("SSO Login Not Available ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickSignIn() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(signin).isEmpty();
			if (elementExists) {
				waitForElementToBeClickable(signin, 30);
				driver.findElement(signin).click();
			} else {
				logger.error("Sign in button Not Available ");
				grep.failTest("Sign in button Not Available ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void enterUserName(String usernameValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(userName).isEmpty();
			if (elementExists) {
				driver.findElement(userName).sendKeys(usernameValue);
			} else {
				logger.error("Username Not Available ");
				grep.failTest("Username Not Available ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void enterPassword(String passwordValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(password).isEmpty();
			if (elementExists) {
				driver.findElement(password).sendKeys(passwordValue);
			} else {
				logger.error("Password Not Available ");
				grep.failTest("Password Not Available ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

}
