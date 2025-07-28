package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class CSAT_Profile_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Profile_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Profile_Page() {
		this.driver = DriverManager.getDriver();
	}

	By profileHeader = By.xpath("//div[@class='settings-container MuiBox-root css-0']/h2");
	By fullname = By.xpath("//div[@class='profile-details']/p[1]");
	By email = By.xpath("//div[@class='profile-details']/p[2]");

	// GET FULL NAME
	public void profileHeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(profileHeader, 30);
			String verifyHeader = driver.findElement(profileHeader).getText();
			if (verifyHeader.equals(dataKeys.profilePage)) {
				logger.info("Header is Valid: " + verifyHeader);
				grep.passTest("Header is Valid: " + verifyHeader);
			} else {
				logger.error("Header is not Valid: " + verifyHeader);
				grep.failTest("Header is not Valid: " + verifyHeader);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET FULL NAME
	public void getFullName() throws Exception {
		try {
			implWait(driver);

			WebElement verifyName = driver.findElement(fullname);
			if (verifyName.isDisplayed()) {
				String name = verifyName.getText();
				logger.info("Full Name: " + name);
				grep.passTest("Full Name: " + name);
			} else {
				logger.error("Full Name not available");
				grep.failTest("Full Name not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
	
	// GET EMAIL
	public void getEmail() throws Exception {
		try {
			implWait(driver);
			WebElement verifyEmail = driver.findElement(email);
			if (verifyEmail.isDisplayed()) {
				String emailVal = verifyEmail.getText();
				logger.info("Email: " + emailVal);
				grep.passTest("Email: " + emailVal);
			} else {
				logger.error("Email not available");
				grep.failTest("Email not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
}
