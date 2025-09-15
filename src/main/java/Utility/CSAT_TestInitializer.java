package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class CSAT_TestInitializer extends WaitsManager {

	private static final Logger logger = LogManager.getLogger(CSAT_TestInitializer.class);
	private PropertiesFile configFile;
	public GenerateReports grep;
	protected WebDriver driver;
	TestDataKeys dataKeys = new TestDataKeys();

	@BeforeTest(description = "Setup and Login To Browser")
	@Parameters({ "FileName" })
	public void setup(@Optional("CsatPage.html") String nameForReport) throws Exception {

		grep = new GenerateReports(); // report class

		configFile = new PropertiesFile(System.getProperty("user.dir") + "//config//config.properties");
		String browserType = configFile.getProperty("Browser");

		if (browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver();
			System.out.println("Launching Chrome Browser");
			logger.info("Launching Chrome Browser");

		}
		if (browserType.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Launching Firefox Browser");
			logger.info("Launching Firefox Browser");
		}
		if (browserType.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Launching Edge Browser");
			logger.info("Launching Edge Browser");
		}
		DriverManager.setDriver(driver);
		driver.manage().window().maximize();

		String url = configFile.getProperty("CSAT_Uat_Url"); // UAT
//		String url = configFile.getProperty("CSAT_Dev_Url"); // DEV


		grep.setupExtentReport(nameForReport);
		grep.testCreate("Login Page", "Login test");

		LoginPage login = new LoginPage();

		grep.infoTest("Report Name :" + nameForReport);
		logger.info("Report Name :" + nameForReport);

		driver.get(url);

		System.out.println("Web Page URL: " + url);
		grep.infoTest("Web Page URL: " + url);
		logger.info("Web Page URL: " + url);

		login.logoInLoginPage();
		login.verifyLoginHeader();
		waitTime(driver);
		grep.captureScreenshot("pass", "Inside Login Page ", "SSO_Loginpage");
		waitTime(driver);
		login.clickSSOLoginBtn();
		waitTime(driver);
		login.enterUserName(dataKeys.ssoUserName);
//		login.enterUserName(dataKeys.ssoUserNameDev);
		login.clickSignIn();
		waitTime2(driver);
//		login.enterPassword(dataKeys.ssoPassword);
//		login.enterPassword(dataKeys.ssoPasswordDev);
//		login.clickSignIn();
		waitTime5(driver);
		// yes or no
		login.clickSignIn();

		waitTime10(driver);

		for (int i = 0; i <= 4; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
		}

		grep.infoTest("Logged in to CSAT Application");
		logger.info("Logged in to CSAT Application");
	}

	@AfterTest(description = "Quit Browser")
	public void tearDown() {
		grep = new GenerateReports(); // report class
		grep.flushReport(); // flush report

//		driver.quit();
		System.out.println("Testing Ended");
		System.out.println("******");

		grep.infoTest("Testing Ended");
		grep.infoTest("***********");

		logger.info("Testing Ended");
		logger.info("***********");

	}
}
