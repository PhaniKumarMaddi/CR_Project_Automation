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

		waitTime3(driver);
		grep.testCreate("Learning and Development Page navigation Test", "Learning and Development  Page navigation");
		waitTime(driver);

		grep.infoTest("Learning and Development Page navigation Test");
		logger.info("Learning and Development Page navigation Test");

		grep.infoTest("Navigating To My Courses Page");
//		navigateToAllPages(dataKeys.myCoursesPageUrl);
		waitTime(driver);
		lndPage.navigateToPage(dataKeys.myCoursesPageLink);
		waitTime5(driver);
		logger.info("Inside " + dataKeys.myCoursesPageLink + " Page ");
		grep.infoTest("Inside " + dataKeys.myCoursesPageLink + " Page ");
		validateUrl(dataKeys.myCoursesPageUrl);
		waitTime(driver);
		
		
		grep.infoTest("Navigating To Departments Page");
		navigateToAllPages(dataKeys.depatmentsPageUrl);

		grep.infoTest("Navigating To Certificates Page");
		navigateToAllPages(dataKeys.certificatesPageUrl);


		grep.infoTest("Navigating To Manage Learning Path Page");
		navigateToAllPages(dataKeys.manageLearningPathUrl);

		
		grep.infoTest("Navigating To Admin Page");
		lndPage.navigateToPage(dataKeys.adminPageUrl);
		waitTime2(driver);
		validateUrl(dataKeys.dashboardTabUrl);

		String url = getURL();
		if (url.contains(dataKeys.dashboardTabUrl)) {
			grep.infoTest("Navigating To Courses tab in Admin Page");
			navigateToAdminTabs(dataKeys.coursesTabUrl);

			grep.infoTest("Navigating To Test tab in Admin Page");
			navigateToAdminTabs(dataKeys.testsTabUrl);

			grep.infoTest("Navigating To Roles tab in Admin Page");
			navigateToAdminTabs(dataKeys.rolesTabUrl);

			grep.infoTest("Navigating To Dashboard tab in Admin Page");
			navigateToAdminTabs(dataKeys.dashboardTabUrl);
		} else {
			grep.infoTest("Not a Admin User");
			logger.info("Not a Admin User");
		}

		grep.infoTest("Navigating To Home Page");
		navigateToAllPages(dataKeys.homePageUrl);

		waitTime(driver);

	}

	@Test(priority = 2)
	public void homePageTest() throws Exception {
		lndPage = new L_And_D_Page();

		grep.testCreate("Home Page UI Test", "Home Page UI");
		waitTime(driver);
		grep.infoTest("Home Page Ui test");
		logger.info("Home Page Ui test");
		lndPage.validateHomePageHeader();
		lndPage.clickStartLearning();
		lndPage.homePageStatCards(dataKeys.totCours_StatCard);
		lndPage.homePageStatCards(dataKeys.dept_StatCard);
		lndPage.homePageStatCards(dataKeys.popCourse_StatCard);
		lndPage.homePageStatCards(dataKeys.mycertificate_StatCard);
		lndPage.homePageStatCards(dataKeys.myCourse_StatCard);
		waitTime(driver);
		grep.captureScreenshot("pass", "Home page UI", "homePage_LandD_");
		waitTime(driver);
		waitTime(driver);
		grep.testCreate("Verifying navigation from Stat Cards in Home Page Test",
				"Navigation from Stat Cards in Home Page");
		waitTime(driver);
		grep.infoTest("Verifying navigation from Stat Cards in Home Page");
		logger.info("Verifying navigation from Stat Cards in Home Page");
		waitTime(driver);
		verifyStatCards(dataKeys.totCours_StatCard, dataKeys.depatmentsPageUrl);
		verifyStatCards(dataKeys.dept_StatCard, dataKeys.depatmentsPageUrl);
		verifyStatCards(dataKeys.popCourse_StatCard, dataKeys.homePageUrl);
		verifyStatCards(dataKeys.mycertificate_StatCard, dataKeys.certificatesPageUrl);
		verifyStatCards(dataKeys.myCourse_StatCard, dataKeys.myCoursesPageUrl);

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
		waitTime2(driver);

		grep.testCreate("Home Page Feature Courses Test", "Home Page Feature Courses");
		grep.infoTest("Home Page Feature Courses test");
		logger.info("Home Page Feature Courses test");
		waitTime(driver);
		lndPage.getListOfFeatureCourses();
		lndPage.featureCourseDetails();
		grep.captureScreenshot("pass", "Home Page Feature Course test", "FeatureCoursesTest");
		waitTime(driver);
		lndPage.clickFeatureCourseEnrollButton();
		lndPage.courseEnrolledMessage();
		waitTime3(driver);

		grep.testCreate("Home Page Browse Course By Department Test", "Browse Course By Department");
		grep.infoTest("Home Page Browse Course By Department test");
		logger.info("Home Page Browse Course By Department test");
		waitTime2(driver);
		String url = getURL();
		if (!url.contains(dataKeys.homePageUrl)) {
			lndPage.navigateToPage(dataKeys.homePageUrl);
		}
		waitTime3(driver);

		lndPage.verifyDepartmentCards();
		waitTime(driver);
		grep.infoTest("Click View All Department Link");
		logger.info("Click View All Department Link");
		lndPage.clickViewAllDeptLink();
		waitTime(driver);
		verifyDeptUrl("viewAll_DepartmentLink");
		lndPage.navigateToPage(dataKeys.homePageUrl);
		waitTime(driver);
		refreshPage();
		waitTime5(driver);

		grep.infoTest("Verify clicking on department card");
		logger.info("Verify clicking on department card");
		waitTime3(driver);
		clickDeptCard(dataKeys.deptCard_DsAndAiLink, dataKeys.dept_DsAndAi);
		clickDeptCard(dataKeys.deptCard_SfdcLink, dataKeys.dept_Salesforce);
		waitTime(driver);

		grep.testCreate("Home Page Why Criticalriver Academy Info test", "Home Page Why Criticalriver Academy Info ");
		waitTime(driver);
		grep.infoTest("Verify Why Criticalriver Academy Info");
		logger.info("Verify Why Criticalriver Academy Info");
		lndPage.whyCR_Academy();
		waitTime(driver);
		grep.captureScreenshot("pass", "Academy and ready to start", "readyToStart_And_Academy");
		waitTime(driver);
		lndPage.homePage_ReadyToStart();
		waitTime(driver);

		grep.testCreate("L&D Profile Page Test", "Profile Page");
		waitTime(driver);
		lndPage.clickProfilePage();
		waitTime3(driver);
		grep.captureScreenshot("pass", "L and D Profile Page", "LAndD_Profile");
		waitTime(driver);
		lndPage.getProfileInfo();

	}

	@Test(priority = 3)
	public void l_and_d_Footer() throws Exception {
		lndPage = new L_And_D_Page();
		grep.testCreate("L&D Footer link Test", "Footer link");
		waitTime(driver);
		lndPage.footerRights();
		waitTime(driver);

		grep.captureScreenshot("pass", "Footer for L and D", "LnD_Footer");
		waitTime(driver);
		lndPage.footerURLs(dataKeys.myCoursesPageLink);
		verifyFooterUrl(dataKeys.myCoursesPageUrl);
		waitTime3(driver);

		lndPage.footerURLs(dataKeys.depatmentsPageUrl);
		verifyFooterUrl(dataKeys.depatmentsPageUrl);
		waitTime3(driver);
		lndPage.footerURLs(dataKeys.helpCenterFooter);
		verifyFooterUrl(dataKeys.helpCenterFooter);
		waitTime3(driver);
		lndPage.footerURLs(dataKeys.feedbackFooter);
		verifyFooterUrl(dataKeys.feedbackFooter);
		waitTime3(driver);
		lndPage.footerURLs(dataKeys.certificatesPageUrl);
		verifyFooterUrl(dataKeys.certificatesPageUrl);
		waitTime3(driver);
		lndPage.footerURLs(dataKeys.profile);
		verifyFooterUrl(dataKeys.profile);
		waitTime3(driver);
		grep.infoTest("Verify Social media links");
		logger.info("Social Media Links");
		verifySocialMediaFooter(dataKeys.facebookFooter);
		waitTime3(driver);
		verifySocialMediaFooter(dataKeys.linkedinFooter);
		waitTime3(driver);
		verifySocialMediaFooter(dataKeys.instaFooter);
		waitTime3(driver);
		lndPage.footerMedia_URLs(dataKeys.twitterFooter);

		switchToLastTab();
		String getUrl = driver.getCurrentUrl();
		if (getUrl.contains("x.com")) {
			grep.passTest(" Url is Valid :" + getUrl);
			logger.info(" Url is Valid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("pass", "Navigated to department page", "Twitter_Media_Footer");
			waitTime(driver);

		} else {
			grep.failTest("Url is not Valid :" + getUrl);
			logger.error("Url is not Valid :" + getUrl);
		}
		closeCurrentTab();
		waitTime(driver);

		switchToFirstTab();
		waitTime(driver);

		waitTime(driver);
		lndPage.navigateToPage(dataKeys.homePageUrl);
	}

	public void clickDeptCard(String deptCardName, String deptName) throws Exception {
		lndPage = new L_And_D_Page();

		waitTime(driver);
		lndPage.clickDeptCard_InBrowseDept(deptCardName, deptName);
		waitTime5(driver);
		grep.captureScreenshot("pass", "Clicking " + deptName + " Department Card", "click" + deptName + "_Card");
		lndPage.navigateToPage(dataKeys.homePageUrl);
	}

	public void verifySocialMediaFooter(String footerVal) throws Exception {
		lndPage = new L_And_D_Page();
		lndPage.footerMedia_URLs(footerVal);

		switchToLastTab();
		String getUrl = driver.getCurrentUrl();
		String value = footerVal.toLowerCase();
		if (getUrl.contains(value)) {
			grep.passTest(" Url is Valid :" + getUrl);
			logger.info(" Url is Valid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("pass", "Navigated to department page", footerVal + "_Media_Footer");
			waitTime(driver);

		} else {
			grep.failTest("Url is not Valid :" + getUrl);
			logger.error("Url is not Valid :" + getUrl);
		}
		closeCurrentTab();
		waitTime(driver);

		switchToFirstTab();
		waitTime(driver);

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
			grep.warnTest(urlValue + " Url is InValid :" + getUrl);
			logger.error(urlValue + " Url is InValid :" + getUrl);
			waitTime(driver);
//			grep.captureScreenshot("warn", urlValue + "URL is Invalid", urlValue + "Page");
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

	public void verifyFooterUrl(String footerVal) throws Exception {
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(footerVal)) {
			grep.passTest(" Url is Valid :" + getUrl);
			logger.info(" Url is Valid :" + getUrl);
			waitTime(driver);
			grep.captureScreenshot("pass", "Navigated to department page", footerVal + "_Footer");
			waitTime(driver);
		} else {
			grep.warnTest(footerVal + " Url is InValid :" + getUrl);
			logger.error("Url is not Valid :" + getUrl);
		}

	}

	public void verifyStatCards(String cardName, String urlName) throws Exception {
		waitTime(driver);
		grep.infoTest("Clicking on " + cardName + " card");
		logger.info("Clicking on " + cardName + " card");

		waitTime(driver);
		lndPage.clickHomePageStatCards(cardName);
		validateUrl(urlName);
		waitTime2(driver);
		lndPage.navigateToPage(dataKeys.homePageUrl);
		waitTime5(driver);
	}
}
