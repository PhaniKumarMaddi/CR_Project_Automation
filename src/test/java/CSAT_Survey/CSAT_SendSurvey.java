package CSAT_Survey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Popup_Page;
import Pages.CSAT_Project_Page;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_SendSurvey extends CSAT_TestInitializer {
	private static final Logger logger = LogManager.getLogger(CSAT_Project_NewProjectTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Project_Page csatProject;
	CSAT_Popup_Page csatPopup;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_SendSurvey_Test() throws Exception {
		csatProject = new CSAT_Project_Page();
		csatPopup = new CSAT_Popup_Page();

		// Verify mandatory Fields

		csatProject = new CSAT_Project_Page();

		// Send Survey Report
		grep.testCreate("Send FeedBack Request To Customer Test", "Send Feedback Request");
		waitTime(driver);

		grep.infoTest("Send FeedBack Request To customer");
		logger.info("Send FeedBack Request To customer");

		// Validating Survey results before sending

		String sentSurveyCountBefore = csatProject.getSurveyCount(dataKeys.sentSurvey);
		logger.info("Survey Sent Count Before :" + sentSurveyCountBefore);
		grep.infoTest("Survey Sent Count Before :" + sentSurveyCountBefore);

		String atRiskSurveyCountBefore = csatProject.getSurveyCount(dataKeys.atRiskSurvey);
		logger.info("Survey At Risk Count Before :" + atRiskSurveyCountBefore);
		grep.infoTest("Survey At Risk Count Before :" + atRiskSurveyCountBefore);

		String completeSurveyCountBefore = csatProject.getSurveyCount(dataKeys.completeSurvey);
		logger.info("Completed Survey Count Before:" + completeSurveyCountBefore);
		grep.infoTest("Completed Survey Count Before :" + completeSurveyCountBefore);

		String csatSurveyCountBefore = csatProject.getSurveyCount(dataKeys.csatScore);
		logger.info("CSAT Score Count Before :" + csatSurveyCountBefore);
		grep.infoTest("CSAT Score Count Before :" + csatSurveyCountBefore);

		String csatValueBefore = csatProject.verifyCsatColInTable(dataKeys.projectNameForSend);
		logger.info("CSAT Column Value Before :" + csatValueBefore);
		grep.infoTest("CSAT Column Value Before :" + csatValueBefore);

		waitTime(driver);
		csatProject.clickProjectBtn(dataKeys.projectNameForSend, dataKeys.sendProjectBtn);
		waitTime(driver);
		csatProject.clickSelectContact(dataKeys.selectOneContact);

		waitTime(driver);
		csatProject.selectSurvey(dataKeys.selectDevelopSurvey);
		waitTime(driver);
		csatProject.retrieveSubjectBasedOnSurvey();
		csatProject.retrieveBodyBasedOnSurvey();

		grep.captureScreenshot("pass", "Send FeebBack request Popup", "SendSurveyPopup");
		csatProject.clickButton(dataKeys.cancelBtn);
//			csatProject.clickButton(dataKeys.sendBtn);

//		waitTime30(driver);
//		csatProject.retrieveFeedBackSentMessage();

		refreshPage();
		waitTime(driver);
//		
//		clickNewTab();
//		waitTime(driver);
//		switchToLastTab();
//		waitTime(driver);
//		switchToFirstTab();
//		waitTime(driver);

		String sentSurveyCountAfter = csatProject.getSurveyCount(dataKeys.sentSurvey);
		logger.info("Survey Sent Count After:" + sentSurveyCountAfter);
		grep.infoTest("Survey Sent Count After:" + sentSurveyCountAfter);

		String atRiskSurveyCountAfter = csatProject.getSurveyCount(dataKeys.atRiskSurvey);
		logger.info("Survey At Risk Count After:" + atRiskSurveyCountAfter);
		grep.infoTest("Survey At Risk Count After:" + atRiskSurveyCountAfter);

		String completeSurveyCountAfter = csatProject.getSurveyCount(dataKeys.completeSurvey);
		logger.info("Completed Survey Count After:" + completeSurveyCountAfter);
		grep.infoTest("Completed Survey Count After:" + completeSurveyCountAfter);

		String csatSurveyCountAfter = csatProject.getSurveyCount(dataKeys.csatScore);
		logger.info("CSAT Score Count After:" + csatSurveyCountAfter);
		grep.infoTest("CSAT Score Count After :" + csatSurveyCountAfter);

		String csatValueAfter = csatProject.verifyCsatColInTable(dataKeys.projectNameForSend);
		logger.info("CSAT Column Value After:" + csatValueAfter);
		grep.infoTest("CSAT Column Value After:" + csatValueAfter);

		csatProject.verifyProjectBtnsAfterSurvey(dataKeys.projectNameForSend);

		// SURVEY SENT POPUP VALIDATIONS
		grep.testCreate("Verify SURVEY Sent Test", "Verify SURVEY sent");

		grep.infoTest("Validating SURVEY Sent Popup");
		logger.info("Validating SURVEY Sent Popup");

		waitTime(driver);
		csatProject.clickViewSurveySentStatus();

		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("50");
		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("25");
		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("10");
		waitTime2(driver);
		grep.infoTest("Validating Response Status Filter in Survey Sent Popup ");
		logger.info("Validating Response Status Filter in Survey Sent Popup ");
		waitTime(driver);
		csatPopup.selectResponseStatusFilterIn_Popup(dataKeys.respondedResponseStatus_InPopup);
		csatPopup.getResponseStatus_ValueFromTable(dataKeys.respondedResponseStatus_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Responded Status in Survey Sent Popup", "responsedStatus_InSurveySent");
		waitTime(driver);
		csatPopup.selectResponseStatusFilterIn_Popup(dataKeys.notResponsedResponseStatus_InPopup);
		csatPopup.getResponseStatus_ValueFromTable(dataKeys.notResponsedResponseStatus_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Not Responded Status in Survey Sent Popup", "notResponsedStatus_InSurveySent");
		waitTime(driver);
		csatPopup.selectResponseStatusFilterIn_Popup(dataKeys.expiredResponseStatus_InPopup);
		csatPopup.getResponseStatus_ValueFromTable(dataKeys.expiredResponseStatus_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Expired Status in Survey Sent Popup", "ExpiredStatus_InSurveySent");
		waitTime(driver);
		csatPopup.selectResponseStatusFilterIn_Popup(dataKeys.responseStatus_InPopup);

		waitTime(driver);
		grep.infoTest("Validating Project Filter in Survey Sent Popup ");
		logger.info("Validating Project Filter in Survey Sent Popup ");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.testAutomation_Project_InPopup);
		csatPopup.getProject_ValueFromTable(dataKeys.testAutomation_Project_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Test Automation Project in Survey Sent Popup",
				"TestAutomationProject_InSurveySent");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.projectx_Project_InPopup);
		csatPopup.getProject_ValueFromTable(dataKeys.projectx_Project_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "ProjectX in Project in Survey Sent Popup", "ProjectX_InSurveySent");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.apollo_Project_InPopup);
		csatPopup.getProject_ValueFromTable(dataKeys.apollo_Project_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Apollo Testing Project in Survey Sent Popup", "Apollo_testing_InSurveySent");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.project_InPopup);

		waitTime(driver);
		grep.infoTest("Validating Account Executive Filter in Survey Sent Popup ");
		logger.info("Validating Account Executive Filter in Survey Sent Popup ");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.phani_AccExe_InPopup);
		csatPopup.getAcc_Exe_ValueFromTable(dataKeys.phani_AccExe_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Phani Account Executive in Survey Sent Popup", "Phani_AccEXE_InSurveySent");
		waitTime(driver);
//		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.raj_AccExe_InPopup);
//		csatPopup.getAcc_Exe_ValueFromTable(dataKeys.raj_AccExe_InPopup);
//		waitTime(driver);
//		grep.captureScreenshot("pass", " Raj Account Executive in Survey Sent Popup", "Raj_AccEXE_InSurveySent");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.anwar_AccExe_InPopup);
		csatPopup.getAcc_Exe_ValueFromTable(dataKeys.anwar_AccExe_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Anwar Account Executive in Survey Sent Popup", "Anwar_AccEXE_InSurveySent");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.accountExecutive_InPopup);

		waitTime(driver);
		grep.infoTest("Validating Survey Name Filter in Survey Sent Popup ");
		logger.info("Validating Survey Name Filter in Survey Sent Popup ");
		waitTime(driver);

		csatPopup.selectSurveyFilterIn_Popup(dataKeys.csatDev_Survey_InPopup);
		csatPopup.getSurvey_ValueFromTable(dataKeys.csatDev_Survey_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "CSAT DEV survey Name in Survey Sent Popup", "CsatDev_InSurveySent");
		waitTime(driver);
		csatPopup.selectSurveyFilterIn_Popup(dataKeys.csatEngage_Survey_InPopup);
		csatPopup.getSurvey_ValueFromTable(dataKeys.csatEngage_Survey_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "CSAT Engagement survey Name in Survey Sent Popup", "CsatEngage_InSurveySent");
		waitTime(driver);
		csatPopup.selectSurveyFilterIn_Popup(dataKeys.surveyName_InPopup);
		waitTime(driver);
		csatProject.clickCloseSurveyPopupBtn();
		waitTime(driver);

		// AT RISK POPUP VALIDATIONS
		grep.testCreate("Verify AT RISK Test", "Verify AT RISK sent");

		grep.infoTest("Validating AT RISK  Sent Popup");
		logger.info("Validating AT RISK  Sent Popup");

		waitTime(driver);
		csatProject.clickViewSurveyAtRiskStatus();

		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("50");
		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("25");
		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("10");
		waitTime2(driver);
		grep.infoTest("Validating Risk Factor Filter in At Risk Popup ");
		logger.info("Validating Risk Factor Filter in At Risk Popup ");
		waitTime(driver);
		csatPopup.selectRiskFactorFilterIn_Popup(dataKeys.low_RiskFactory_InPopup);
		csatPopup.getRiskFactor_ValueFromTable(dataKeys.low_RiskFactory_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Low Risk Factor in At Risk Popup", "lowRiskFactor_InAtRisk");
		waitTime(driver);
		csatPopup.selectRiskFactorFilterIn_Popup(dataKeys.poor_RiskFactory_InPopup);
		csatPopup.getRiskFactor_ValueFromTable(dataKeys.poor_RiskFactory_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Poor Risk Factor in At Risk Popup", "poorRiskFactor_InAtRisk");
		waitTime(driver);
		csatPopup.selectRiskFactorFilterIn_Popup(dataKeys.riskFactory_InPopup);

		grep.infoTest("Validating Project Filter in At Risk Popup ");
		logger.info("Validating Project Filter in At Risk Popup ");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.apollo_Project_InPopup);
		csatPopup.getProject_AtRisk_ValueFromTable(dataKeys.apollo_Project_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Apollo Project in At Risk Popup", "apolloProject_InAtRisk");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.projectx_Project_InPopup);
		csatPopup.getProject_AtRisk_ValueFromTable(dataKeys.projectx_Project_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Project X in At Risk Popup", "projectX_inAtRisk");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.project_InPopup);

		waitTime(driver);
		grep.infoTest("Validating Account Executive Filter in At Risk  Popup ");
		logger.info("Validating Account Executive Filter in At Risk Popup ");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.anwar_AccExe_InPopup);
		csatPopup.getAccExe_AtRisk_ValueFromTable(dataKeys.anwar_AccExe_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Anwar Account Executive in At Risk Popup", "anwarAccExe_InAtRisk");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.arun_AccExe_InPopup);
		csatPopup.getAccExe_AtRisk_ValueFromTable(dataKeys.arun_AccExe_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Arun Account Executive in At Risk Popup", "arunAccExe_inAtRisk");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.accountExecutive_InPopup);
		waitTime(driver);
		csatProject.clickCloseSurveyPopupBtn();
		waitTime(driver);

		// SURVEY COMPLETED POPUP

		grep.testCreate("Verify SURVEY Complete Test", "Verify SURVEY Complete");

		grep.infoTest("Validating SURVEY Complete Popup");
		logger.info("Validating SURVEY Complete Popup");

		waitTime(driver);
		csatProject.clickViewSurveyCompletedStatus();

		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("50");
		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("25");
		waitTime2(driver);
		csatPopup.selectPaginationIn_Popup("10");
		waitTime(driver);

		waitTime(driver);
		grep.infoTest("Validating Project Filter in Survey Complete Popup ");
		logger.info("Validating Project Filter in Survey Complete Popup ");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.apollo_Project_InPopup);
		csatPopup.getProject_ValueFromTable(dataKeys.apollo_Project_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Apollo Project in Survey Complete Popup", "appoloProject_InSurveyComplete");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.sfdc_Project_InPopup);
		csatPopup.getProject_ValueFromTable(dataKeys.sfdc_Project_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Salesforce in Project in Survey Complete Popup", "sfdc_InSurveyComplete");
		waitTime(driver);
		csatPopup.selectProjectFilterIn_Popup(dataKeys.project_InPopup);

		waitTime(driver);
		grep.infoTest("Validating Account Executive Filter in Survey Complete Popup ");
		logger.info("Validating Account Executive Filter in Survey Complete Popup ");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.phani_AccExe_InPopup);
		csatPopup.getAcc_Exe_ValueFromTable(dataKeys.phani_AccExe_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Phani Account Executive in Survey Complete Popup",
				"Phani_AccEXE_InSurveyComplete");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.arun_AccExe_InPopup);
		csatPopup.getAcc_Exe_ValueFromTable(dataKeys.arun_AccExe_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", " Arun Account Executive in Survey Complete Popup",
				"Arun_AccEXE_InSurveyComplete");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.anwar_AccExe_InPopup);
		csatPopup.getAcc_Exe_ValueFromTable(dataKeys.anwar_AccExe_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Anwar Account Executive in Survey Complete Popup",
				"Anwar_AccEXE_InSurveyComplete");
		waitTime(driver);
		csatPopup.selectAcc_ExecFilterIn_Popup(dataKeys.accountExecutive_InPopup);

		waitTime(driver);
		grep.infoTest("Validating Survey Name Filter in Survey Complete Popup ");
		logger.info("Validating Survey Name Filter in Survey Complete Popup ");
		waitTime(driver);

		csatPopup.selectSurveyFilterIn_Popup(dataKeys.csatDev_Survey_InPopup);
		csatPopup.getSurvey_ValueFromTable(dataKeys.csatDev_Survey_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "CSAT DEV survey Name in Survey Complete Popup", "CsatDev_InSurveyComplete");
		waitTime(driver);
		csatPopup.selectSurveyFilterIn_Popup(dataKeys.csatAms_Survey_InPopup);
		csatPopup.getSurvey_ValueFromTable(dataKeys.csatAms_Survey_InPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "CSAT AMS survey Name in Survey Complete Popup", "CsatAMS_InSurveyComplete");
		waitTime(driver);
		csatPopup.selectSurveyFilterIn_Popup(dataKeys.surveyName_InPopup);

		waitTime(driver);
		csatProject.clickCloseSurveyPopupBtn();
		waitTime(driver);

		// CSAT SUMMARY POPUP VALIDATION
		grep.testCreate("Verify CSAT Summary Test", "Verify CSAT Summary");

		grep.infoTest("Validating CSAT Summary Popup");
		logger.info("Validating CSAT Summary Popup");

		waitTime(driver);
		csatProject.clickViewCSATScore();
		waitTime2(driver);
		String csatScoreInPopup = csatPopup.getCSAT_ScoreInPopup();
		System.out.println("CSAT Score In popup " + csatScoreInPopup);
		grep.infoTest("CSAT Score In popup " + csatScoreInPopup);
		logger.info("CSAT Score In popup " + csatScoreInPopup);
		waitTime(driver);
		if (csatScoreInPopup.equals(csatSurveyCountAfter)) {
			grep.passTest("Csat Score is correct");
			logger.info("Csat Score is correct");
		} else {
			grep.failTest("Csat Score is not correct");
			logger.error("Csat Score is not correct");
		}
		waitTime(driver);
		csatPopup.selectPaginationInCSAT_Popup("50");
		waitTime2(driver);
		csatPopup.selectPaginationInCSAT_Popup("25");
		waitTime2(driver);
		csatPopup.selectPaginationInCSAT_Popup("10");
		waitTime2(driver);


		grep.infoTest("Validating CSAT Filter Popup");
		logger.info("Validating CSAT Filter Popup");
		
		csatPopup.selectFilterInCSAT_Popup(dataKeys.excellentOption_InPopup);
		csatPopup.getCSAT_ValueFromTable("4");
		waitTime(driver);
		grep.captureScreenshot("pass", "CSAT Excellent Filter Option", "csatExcellentOptionInPopup");
		waitTime(driver);
		csatPopup.selectFilterInCSAT_Popup(dataKeys.goodOption_InPopup);
		csatPopup.getCSAT_ValueFromTable("3");
		waitTime(driver);
		grep.captureScreenshot("pass", "CSAT Good Filter Option", "csatGoodOptionInPopup");
		waitTime(driver);
		csatPopup.selectFilterInCSAT_Popup(dataKeys.dissatisfiedOption_InPopup);
		csatPopup.getCSAT_ValueFromTable("2");
		waitTime(driver);
		grep.captureScreenshot("pass", "CSAT Dissatisfied Filter Option", "csatDissatisfiedOptionInPopup");
//		waitTime(driver);
//		csatProject.clickButton(dataKeys.exportBtn);
//		waitTime(driver);
//		clickEscapeBtn();
		waitTime(driver);
		csatProject.clickCloseSurveyPopupBtn();

		waitTime(driver);

		validAssert.assertAllFunction();
	}
}
