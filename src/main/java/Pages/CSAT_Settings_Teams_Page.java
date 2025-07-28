package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class CSAT_Settings_Teams_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Reports_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Settings_Teams_Page() {
		this.driver = DriverManager.getDriver();
	}

	By teamsPageHeader = By.xpath("//div[@class='team-name-bar']/h2");
	By searchTeamAndUser = By.xpath("//input[@placeholder='Search Team and User']");
	
	By getTeamName= By.xpath("//div[@class='teams-grid'][1]/button[1]/h3");
	By getTeamCount= By.xpath("//div[@class='teams-grid'][1]/button[1]/div/p");
	
	By getTeamDetailHeader=By.xpath("//div[@class='team-details-container']/h2[1]");
	
	// ROLES PAGE HEADER
	public void orgMembers_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(teamsPageHeader, 30);
			String verifyHeader = driver.findElement(teamsPageHeader).getText();
			if (verifyHeader.equals(dataKeys.orgMemberHeader)) {
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



}
