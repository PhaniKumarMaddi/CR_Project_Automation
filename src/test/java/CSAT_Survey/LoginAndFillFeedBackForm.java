package CSAT_Survey;

import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Popup_Page;
import Pages.CSAT_Project_Page;
import Pages.LoginPage;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class LoginAndFillFeedBackForm extends CSAT_TestInitializer {
	private static final Logger logger = LogManager.getLogger(LoginAndFillFeedBackForm.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Popup_Page csatPopup;
	CSAT_Project_Page csatPage;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_FillSurvey_Test() throws Exception {
		csatPage=new CSAT_Project_Page();
		csatPopup = new CSAT_Popup_Page();
		LoginPage login = new LoginPage();
		// Verify mandatory Fields

		// Send Survey Report
		grep.testCreate("Login to Customer account Test", "Login to Customer account");
		waitTime(driver);

		grep.infoTest("Fill Feedback Form");
		logger.info("Fill Feedback Form");

		clickNewTab();
		switchToLastTab();
		waitTime2(driver);
		enterURL(dataKeys.url);

		login.clickUseAnotherAccount();
		login.enterUserName(dataKeys.ssoUserName);
		login.clickSignIn();
		waitTime2(driver);
		login.enterPassword(dataKeys.ssoPassword);
		login.clickSignIn();
		waitTime10(driver);

		login.clickSignInOnTop();
		waitTime2(driver);
		login.SelectProfileToLogin(dataKeys.myProfileName);

		waitTime(driver);
		grep.infoTest("Inside Customer Mail");
		logger.info("Inside Customer Mail");
		waitTime10(driver);
		csatPopup.clickSkillSyncMail();
		waitTime(driver);
		csatPopup.clickTakeSurveyButton();
		waitTime2(driver);
		switchToLastTab();

		waitTime30(driver);
//		csatPopup.formHeaderValidation();
//		waitTime(driver);
//		grep.infoTest("Inside Feed back Form");
//		logger.info("Inside Feed back Form");
//		waitTime(driver);
//		grep.captureScreenshot("pass", "FeedBack Form Opened", "FeedBack Form");
//		waitTime(driver);
//		csatPopup.select_5_Rating(dataKeys.accountabilityRate);
//		csatPopup.clickSection(dataKeys.deliverySectionInForm);
//		waitTime(driver);
//
//		waitTime(driver);
//		csatPopup.select_3_Rating(dataKeys.feedbackAndSuggestionRate);
//		csatPopup.select_4_Rating(dataKeys.actionPlanRate);
//		csatPopup.select_5_Rating(dataKeys.clientRelationRate);
//		csatPopup.clickSection(dataKeys.responseSectionInForm);
//		waitTime(driver);
//
//		waitTime(driver);
//		csatPopup.select_1_Rating(dataKeys.pricingRate);
//		csatPopup.select_2_Rating(dataKeys.costOptimizeRate);
//		csatPopup.clickSection(dataKeys.financialSectionInForm);
//		waitTime(driver);
//
//		waitTime(driver);
//		csatPopup.select_2_Rating(dataKeys.leadershipRateRate);
//		csatPopup.getLast_Rating(dataKeys.leadershipRateRate);
//		csatPopup.clickSection(dataKeys.valueAddsSectionInForm);
//		waitTime(driver);
//
//		waitTime(driver);
//		csatPopup.insertFeedback(dataKeys.inputGeneralFeedback);
//		csatPopup.clickSection(dataKeys.overAllFeedbackSectionInForm);
//
//		waitTime2(driver);
//
//		csatPopup.clickPreviewButton();
//		waitTime(driver);
//		csatPopup.getAverageRating();
//		waitTime(driver);
//		csatPopup.clickSendButton();
//		waitTime5(driver);
//		csatPopup.getFeedbackMsgg();

		switchToFirstTab();
		
		waitTime(driver);
		csatPage.clickViewSurveySentStatus();
		waitTime(driver);
		validAssert.assertAllFunction();
	}
}
