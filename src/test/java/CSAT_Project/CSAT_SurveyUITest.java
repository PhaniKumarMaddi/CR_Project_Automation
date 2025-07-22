package CSAT_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_SurveyUITest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_SurveyUITest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_Ui_Test() throws Exception {

		System.out.println("Inside Test class ");
		logger.info("Inside Test class ");
		csatPage = new CSAT_Survey_AllPages();
//				grep = new GenerateReports();

		grep.testCreate("CSAT Page navigation Test", "CSAT Page navigation");
		waitTime(driver);
		csatPage.logoInHomePage();
		csatPage.verifyProfileNameInHomePage(dataKeys.profileName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Inside CSAT Page", "insideCSATPage");
		waitTime(driver);
		csatPage.collapseSideMenu();
		waitTime(driver);
		grep.captureScreenshot("pass", "Menu Collapsed", "collapsemenu");

		grep.infoTest("Navigating To Survey Page");
		navigateToAllPagesTest(dataKeys.survey_Url);

		grep.infoTest("Navigating To Roles Page");
		navigateToAllPagesTest(dataKeys.roles_Url);

		grep.infoTest("Navigating To Reports Page");
		navigateToAllPagesTest(dataKeys.reports_Url);

		grep.infoTest("Navigating To Org Members Page");
		navigateToSettingsPagesTest(dataKeys.orgMembers_Url);

		grep.infoTest("Navigating To Profile Page");
		navigateToAllPagesTest(dataKeys.profile_Url);

		grep.infoTest("Navigating To Teams Page");
		navigateToSettingsPagesTest(dataKeys.teams_Url);
		waitTime(driver);
		grep.infoTest("Navigating To Projects Page");
		waitTime(driver);
		refreshPage();
		waitTime(driver);
		navigateToAllPagesTest(dataKeys.project_Url);

		waitTime(driver);
		csatPage.expandSideMenu();
		waitTime(driver);
		grep.captureScreenshot("pass", "Menu Expanded", "expandMenu");

//		csatPage.clickLogout();
//		String getUrl = driver.getCurrentUrl();
//		if (getUrl.endsWith(dataKeys.login_Url)) {
//			grep.passTest("Logged out Successfully");
//			logger.info("Logged out Successfully");
//		} else {
//			grep.failTest("Log out Functionality failed");
//			logger.info("Log out Functionality failed");
//		}

		validAssert.assertAllFunction();

	}

	public void navigateToAllPagesTest(String pageNameValue) throws Exception {
		csatPage = new CSAT_Survey_AllPages();

		waitTime(driver);
		csatPage.navigateToPage(pageNameValue);
		waitTime5(driver);
		logger.info("Inside " + pageNameValue + " Page ");
		grep.infoTest("Inside " + pageNameValue + " Page ");
		validateUrl(pageNameValue);
		waitTime(driver);

	}

	public void navigateToSettingsPagesTest(String pageNameValue) throws Exception {
		csatPage = new CSAT_Survey_AllPages();

		waitTime(driver);
		csatPage.navigateToSettingsPage(pageNameValue);
		waitTime5(driver);
		logger.info("Inside " + pageNameValue + " Page ");
		grep.infoTest("Inside " + pageNameValue + " Page ");
		validateUrl(pageNameValue);
		waitTime(driver);
	}

	public void validateUrl(String urlValue) throws Exception {
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(urlValue)) {
			grep.passTest(urlValue + " Url is Valid :" + getUrl);
			logger.info(urlValue + " Url is Valid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("pass", urlValue + " URL is valid", urlValue + "Page");
			waitTime(driver);
		} else {
			grep.failTest(urlValue + " Url is InValid :" + getUrl);
			logger.error(urlValue + " Url is InValid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("fail", urlValue + "URL is Invalid", urlValue + "Page");
			waitTime(driver);
		}

	}
}
