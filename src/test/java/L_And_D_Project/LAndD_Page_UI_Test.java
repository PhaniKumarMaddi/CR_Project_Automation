package L_And_D_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.L_And_D_TestDataKeys;
import BaseClasses.L_And_D_TestInitializer;
import L_And_D_Pages.L_And_D_Page;
import Utility.GenerateReports;

public class LAndD_Page_UI_Test extends L_And_D_TestInitializer {

	private static final Logger logger = LogManager.getLogger(LAndD_Page_UI_Test.class);
	GenerateReports grep = new GenerateReports();
	L_And_D_Page lndPage;
	L_And_D_TestDataKeys dataKeys = new L_And_D_TestDataKeys();

	@Test(priority = 1)
	public void l_and_d_PageNavigation_Test() throws Exception {
		lndPage = new L_And_D_Page();

		refreshPage();

		grep.testCreate("Learning and Development Page navigation Test", "Learning and Development  Page navigation");
		waitTime(driver);

		grep.infoTest("Navigating To My Courses Page");
		navigateToAllPages(dataKeys.myCoursesPageUrl);

		grep.infoTest("Navigating To Departments Page");
		navigateToAllPages(dataKeys.depatmentsPageUrl);

		grep.infoTest("Navigating To Certificates Page");
		navigateToAllPages(dataKeys.certificatesPageUrl);

		grep.infoTest("Navigating To Admin Page");
//		navigateToAllPages(dataKeys.adminPageUrl);
		lndPage.navigateToPage(dataKeys.adminPageUrl);
		validateUrl(dataKeys.dashboardTabUrl);

		grep.infoTest("Navigating To Courses tab in Admin Page");
		navigateToAdminTabs(dataKeys.coursesTabUrl);

		grep.infoTest("Navigating To Test tab in Admin Page");
		navigateToAdminTabs(dataKeys.testsTabUrl);

		grep.infoTest("Navigating To Roles tab in Admin Page");
		navigateToAdminTabs(dataKeys.rolesTabUrl);

		grep.infoTest("Navigating To Dashboard tab in Admin Page");
		navigateToAdminTabs(dataKeys.dashboardTabUrl);

		grep.infoTest("Navigating To Home Page");
		navigateToAllPages(dataKeys.homePageUrl);

		waitTime(driver);

	}

	@Test(priority = 2)
	public void homePageTest() throws Exception {
		lndPage = new L_And_D_Page();
		refreshPage();
		waitTime3(driver);

		grep.testCreate("Home Page UI Test", "Home Page UI");
		waitTime(driver);
		grep.infoTest("Home Page Ui test");
		logger.info("Home Page Ui test");
		lndPage.validateHomePageHeader();
		lndPage.clickStartLearning();
		lndPage.homePageStatCards(dataKeys.dept_StatCard);
		lndPage.homePageStatCards(dataKeys.totCours_StatCard);
		lndPage.homePageStatCards(dataKeys.mycertificate_StatCard);
		lndPage.homePageStatCards(dataKeys.popCourse_StatCard);

		grep.captureScreenshot("pass", "Home page ui test", "homePageHeader_lnd");
		waitTime(driver);

		grep.testCreate("Home Page Continue Learning Test", "Home Page Continue Learning");
		grep.infoTest("Home Page Continue Learning test");
		logger.info("Home Page Continue Learning test");

		waitTime(driver);
		lndPage.continueLearningDetails();
		waitTime(driver);
		lndPage.clickContinueLearnBtn();
		waitTime(driver);
		validateUrl(dataKeys.courseVideoUrl);
		waitTime(driver);
		lndPage.navigateToPage(dataKeys.homePageUrl);
		waitTime(driver);

		grep.testCreate("Home Page Feature Courses Test", "Home Page Feature Courses");
		grep.infoTest("Home Page Feature Courses test");
		logger.info("Home Page Feature Courses test");
		waitTime(driver);
		lndPage.getListOfFeatureCourses();
		lndPage.featureCourseDetails();
		grep.captureScreenshot("pass", "Home Page Feature Course test", "FeatureCoursesTest");
		lndPage.clickFeatureCourseEnrollButton();
//		isAlertPresent();
		acceptalert();
		waitTime(driver);

		grep.testCreate("Home Page Browse Course By Department Test", "Browse Course By Department");
		grep.infoTest("Home Page Browse Course By Department test");
		logger.info("Home Page Browse Course By Department test");
		waitTime(driver);
		lndPage.verifyDepartmentCards();
		waitTime(driver);
		grep.infoTest("Click View All Department Link");
		logger.info("Click View All Department Link");
		lndPage.clickViewAllDeptLink();
		waitTime(driver);
		verifyDeptUrl("viewAll_DepartmentLink");
		lndPage.navigateToPage(dataKeys.homePageUrl);
		waitTime(driver);

		grep.infoTest("Verify clicking on department card");
		logger.info("Verify clicking on department card");
		clickDeptCard(dataKeys.dept_DsAndAi);
		waitTime(driver);
		clickDeptCard(dataKeys.dept_Salesforce);
		waitTime(driver);

	}

	public void clickDeptCard(String deptName) throws Exception {
		lndPage = new L_And_D_Page();

		waitTime(driver);
		lndPage.clickDeptCard_InBrowseDept(deptName);
		waitTime5(driver);
		grep.captureScreenshot("pass", "Clicking " + deptName + " Department Card", "click" + deptName + "_Card");
		lndPage.navigateToPage(dataKeys.homePageUrl);
	}

	public void navigateToAllPages(String pageNameValue) throws Exception {
		lndPage = new L_And_D_Page();

		waitTime(driver);
		lndPage.navigateToPage(pageNameValue);
		waitTime5(driver);
		logger.info("Inside " + pageNameValue + " Page ");
		grep.infoTest("Inside " + pageNameValue + " Page ");
		validateUrl(pageNameValue);
		waitTime(driver);

	}

	public void navigateToAdminTabs(String pageNameValue) throws Exception {
		lndPage = new L_And_D_Page();

		waitTime(driver);
		lndPage.naviagteToAdminTabs(pageNameValue);
		waitTime5(driver);
		logger.info("Inside " + pageNameValue + " Tab in Admin Page ");
		grep.infoTest("Inside " + pageNameValue + " Tab in Admin Page ");
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

	public void verifyDeptUrl(String ss_Value) throws Exception {
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(dataKeys.depatmentsPageUrl)) {
			grep.passTest(" Url is Valid :" + getUrl);
			logger.info(" Url is Valid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("pass", "Navigated to department page", ss_Value);
			waitTime(driver);
		} else {
			grep.failTest("Url is not Valid :" + getUrl);
			logger.error("Url is not Valid :" + getUrl);
		}

	}
}
