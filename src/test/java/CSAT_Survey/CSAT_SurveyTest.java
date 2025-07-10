package CSAT_Survey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Survey_Page;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_SurveyTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_SurveyTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_Page csatPage;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_Ui_Test() throws Exception {

		System.out.println("Inside Test class ");
		logger.info("Inside Test class ");
		csatPage = new CSAT_Survey_Page();
//				grep = new GenerateReports();

		grep.testCreate("CR Chat Bot Page UI Validation Test", "CR Chat Bot Page UI");
		waitTime(driver);
		csatPage.logoInHomePage();
		csatPage.verifyProfileNameInHomePage(dataKeys.profileName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Inside CSAT Page", "insideCSATPage");
		waitTime(driver);
//		csatPage.collapseSideMenu();
//		waitTime(driver);
//		grep.captureScreenshot("pass", "Menu Collapsed", "collapsemenu");

//		grep.infoTest("Navigating To Survey Page");
//		navigateToAllPagesTest(dataKeys.survey_Url);
//
//		grep.infoTest("Navigating To Roles Page");
//		navigateToAllPagesTest(dataKeys.roles_Url);
//
//		grep.infoTest("Navigating To Reports Page");
//		navigateToAllPagesTest(dataKeys.reports_Url);

		grep.infoTest("Navigating To Org Members Page");
		navigateToSettingsPagesTest(dataKeys.orgMembers_Url);

		grep.infoTest("Navigating To Teams Page");
		navigateToSettingsPagesTest(dataKeys.teams_Url);

//		grep.infoTest("Navigating To Profile Page");
//		navigateToAllPagesTest(dataKeys.profile_Url);
//
//		grep.infoTest("Navigating To Projects Page");
//		navigateToAllPagesTest(dataKeys.project_Url);

		waitTime(driver);
		csatPage.expandSideMenu();
		waitTime(driver);
		grep.captureScreenshot("pass", "Meu Expanded", "expandMenu");

		csatPage.clickLogout();
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(dataKeys.login_Url)) {
			grep.passTest("Logged out Successfully");
			logger.info("Logged out Successfully");
		} else {
			grep.failTest("Log out Functionality failed");
			logger.info("Log out Functionality failed");
		}

		validAssert.assertAllFunction();

	}

	public void navigateToAllPagesTest(String pageNameValue) throws Exception {
		csatPage = new CSAT_Survey_Page();

		waitTime(driver);
		csatPage.navigateToPage(pageNameValue);
		waitTime5(driver);
		logger.info("Inside " + pageNameValue + " Page ");
		grep.infoTest("Inside " + pageNameValue + " Page ");
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(pageNameValue)) {
			grep.passTest(pageNameValue + " Url is Valid :" + getUrl);
			logger.info(pageNameValue + " Url is Valid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("pass", pageNameValue + "URL is valid", pageNameValue + "Page");
			waitTime(driver);
		} else {
			grep.failTest(pageNameValue + " Url is InValid :" + getUrl);
			logger.error(pageNameValue + " Url is InValid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("fail", pageNameValue + "URL is Invalid", pageNameValue + "Page");
			waitTime(driver);
		}
		waitTime(driver);

	}

	public void navigateToSettingsPagesTest(String pageNameValue) throws Exception {
		csatPage = new CSAT_Survey_Page();

		waitTime(driver);
		csatPage.navigateToSettingsPage(pageNameValue);
		waitTime5(driver);
		logger.info("Inside " + pageNameValue + " Page ");
		grep.infoTest("Inside " + pageNameValue + " Page ");
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(pageNameValue)) {
			grep.passTest(pageNameValue + " Url is Valid :" + getUrl);
			logger.info(pageNameValue + " Url is Valid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("pass", pageNameValue + "URL is valid", pageNameValue + "Page");
			waitTime(driver);
		} else {
			grep.failTest(pageNameValue + " Url is InValid :" + getUrl);
			logger.error(pageNameValue + " Url is InValid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("fail", pageNameValue + "URL is Invalid", pageNameValue + "Page");
			waitTime(driver);
		}
		waitTime(driver);

	}
}
