package IntelliServe_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.IntelliServe_TestDataKeys;
import BaseClasses.IntelliServe_TestInitializer;
import IntelliServe_Pages.Ticketing_Page;
import Utility.GenerateReports;

public class IntelliServe_Page_UI_Test extends IntelliServe_TestInitializer {

	private static final Logger logger = LogManager.getLogger(IntelliServe_Page_UI_Test.class);
	GenerateReports grep = new GenerateReports();
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();
	Ticketing_Page ticketpage;

	@Test(priority = 1)
	public void IntelliServe__UI_Test() throws Exception {
		ticketpage = new Ticketing_Page();

		grep.testCreate("Verify the Home and Profile Page test", "Verify the Home and Profile Page");
		grep.infoTest("Verify the Home and Profile Page test");
		logger.info("Verify the Home and Profile Page test");

		waitTime(driver);
		ticketpage.clickProfilePage(dataKeys.userName, dataKeys.ssoUserName);
		waitTime(driver);
		ticketpage.getProfilePageInfo();
		waitTime(driver);
		ticketpage.getFooterInfo();
		grep.captureScreenshot("pass", "Profile Page Test", "ticketing_ProfilePage");

	}

	@Test(priority = 2)
	public void IntelliServe__Signout_Test() throws Exception {
//		ticketpage = new Ticketing_Page();

		grep.testCreate("Verify the Signout functionality test", "Verify the Signout");
		grep.infoTest("Verify the Signout");
		logger.info("Verify the Signout");

		waitTime(driver);
		ticketpage.clickSignOutBtn();
		waitTime10(driver);
		String getUrlVal = getURL();
		if (getUrlVal.endsWith(dataKeys.login_Url)) {
			grep.passTest("Logged out Successfully");
			logger.info("Logged out Successfully");
		} else {
			grep.failTest("Signout Functionality failed");
			logger.info("Signout Functionality failed");
		}
		waitTime5(driver);
		grep.captureScreenshot("pass", "Signout from Application Test", "ticketing_signOut");

	}
}