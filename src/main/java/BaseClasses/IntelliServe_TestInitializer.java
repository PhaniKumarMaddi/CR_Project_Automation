package BaseClasses;

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

import IntelliServe_Pages.Ticketing_LoginPage;
import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.PropertiesFile;
import Utility.WaitsManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class IntelliServe_TestInitializer extends WaitsManager {

	private static final Logger logger = LogManager.getLogger(IntelliServe_TestInitializer.class);
	private PropertiesFile configFile;
	public GenerateReports grep;
	protected WebDriver driver;
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();

	@BeforeTest(description = "Setup and Login To Browser")
	@Parameters({ "FileName" })
	public void setup(@Optional("Ticketing_Page.html") String nameForReport) throws Exception {

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

		String url = configFile.getProperty("IntelliServe_DevUrl"); // DEV
//		String url = configFile.getProperty("IntelliServe_UarUrl"); // UAT

		grep.setupExtentReport(nameForReport);
		grep.testCreate("Login Page", "Login test");

		Ticketing_LoginPage login = new Ticketing_LoginPage();

		grep.infoTest("Report Name :" + nameForReport);
		logger.info("Report Name :" + nameForReport);

		driver.get(url);

		System.out.println("Web Page URL: " + url);
		grep.infoTest("Web Page URL: " + url);
		logger.info("Web Page URL: " + url);
		waitTime2(driver);

		login.verifyLoginHeader();
		waitTime2(driver);
		grep.captureScreenshot("pass", "Inside Login Page ", "SSO_Loginpage_Ticketing");
		waitTime2(driver);
		login.clickSSOLoginBtn();
		waitTime(driver);
		login.enterUserName(dataKeys.ssoUserName);
		login.clickSignIn();
		waitTime2(driver);
//		login.enterPassword(dataKeys.ssoPassword);
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

		grep.infoTest("Logged in to Intelli Serve Application");
		logger.info("Logged in to Intelli Serve Application");
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
