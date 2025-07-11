package CSAT_Survey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Project_Page;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_ProjectSurveyTest extends CSAT_TestInitializer {
	private static final Logger logger = LogManager.getLogger(CSAT_ProjectSurveyTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Project_Page csatProject;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_ProjectUI_Test() throws Exception {
		csatPage = new CSAT_Survey_AllPages();
		csatProject = new CSAT_Project_Page();
		grep.testCreate("CSAT Project Page UI Test", "CSAT Project Page UI");
		waitTime(driver);
		csatPage.collapseSideMenu();
		waitTime(driver);

		csatProject.headerValidation();
		waitTime(driver);
		csatProject.clickViewSurveySentStatus();
		waitTime(driver);
		validateSurveyPopup(dataKeys.sentSurvey);
		csatProject.verifyButton(dataKeys.cancelBtn);
		csatProject.verifyButton(dataKeys.shareBtn);
		csatProject.clickCloseSurveyPopupBtn();
		waitTime(driver);
		csatProject.clickViewSurveyAtRiskStatus();
		waitTime(driver);
		validateSurveyPopup(dataKeys.atRiskSurvey);
		csatProject.verifyButton(dataKeys.cancelBtn);
		csatProject.verifyButton(dataKeys.exportBtn);
		csatProject.clickCloseSurveyPopupBtn();
		waitTime(driver);
		csatProject.clickViewSurveyCompletedStatus();
		waitTime(driver);
		validateSurveyPopup(dataKeys.completeSurvey);
		csatProject.verifyButton(dataKeys.cancelBtn);
		csatProject.verifyButton(dataKeys.exportBtn);
		csatProject.clickCloseSurveyPopupBtn();
		waitTime(driver);
		csatProject.clickViewCSATScore();
		waitTime(driver);
		validateSurveyPopup(dataKeys.csatScore);
		csatProject.verifyButton(dataKeys.cancelBtn);
		csatProject.verifyButton(dataKeys.exportBtn);
		csatProject.clickCloseSurveyPopupBtn();

		// Verify New project
		csatProject.clickNewProject();
		waitTime(driver);
		String projectHeader = csatProject.verifynewProjectPopupHeader();
		String head = projectHeader.replaceAll("×", "").trim();
		waitTime(driver);
		System.out.println("popup Header " + head);
		logger.info("popup Header " + head);
		grep.infoTest("popup Header " + head);
		validAssert.equalsAssert(head, dataKeys.newProjectHeader);
		waitTime2(driver);
		grep.captureScreenshot("pass", head + " page test", head + "Popup");
		waitTime(driver);
		csatProject.verifyButton(dataKeys.cancelBtn);
		csatProject.verifyButton(dataKeys.saveBtn);
		csatProject.clickCloseSurveyPopupBtn();

		// Filters Test
		grep.testCreate("Projects Page Columns Options Filters Test", "Project page Columns Option Filters");
		waitTime(driver);
		csatProject.clickColumnOptionsBtn();
		csatProject.verifyColumnOptionsHeader(dataKeys.colOptions);
		csatProject.verifyButton(dataKeys.cancelBtn);
		csatProject.verifyButton(dataKeys.okBtn);
		grep.infoTest("Verifying Project Name Column Option");
		logger.info("Verifying Project Name Column Option");
		verifyColumnOptionFunctionality(dataKeys.projectName_ColOption);
		grep.infoTest("Verifying Practice Name Column Option");
		logger.info("Verifying Practice Name Column Option");
		verifyColumnOptionFunctionality(dataKeys.practicename_ColOption);
		grep.infoTest("Verifying CSAT Column Option");
		logger.info("Verifying CSAT Column Option");
		verifyColumnOptionFunctionality(dataKeys.csat_ColOption);
		csatProject.clickCloseColumnOptions();

		waitTime(driver);
		grep.testCreate("Projects Page Status Filters Test", "Projects Page Status Filter");

		csatProject.verifyStatusSelectedOption(dataKeys.allStatusesOption);
		validAssert.verifyStatusFilters(dataKeys.pipelineStatusOption);
		validAssert.verifyStatusFilters(dataKeys.completedStatusOption);
		validAssert.verifyStatusFilters(dataKeys.inProgressStatusOption);

		validAssert.assertAllFunction();
	}

	public void validateSurveyPopup(String popupHeader) throws Exception {

//		csatProject = new CSAT_Project_Page();
		String headerVal = csatProject.verifySurveyPopupHeader();
		waitTime1(driver);
		System.out.println("Popup Header: " + headerVal);
		logger.info("Popup Header: " + headerVal);
		grep.infoTest("Popup Header: " + headerVal);
		waitTime1(driver);
		validAssert.equalsAssert(headerVal, popupHeader);
		waitTime2(driver);
		grep.captureScreenshot("pass", popupHeader + " page test", popupHeader + "Popup");

	}

	public void verifyColumnOptionFunctionality(String option) throws Exception {
//		csatProject = new CSAT_Project_Page();

		csatProject.selectColumnOption(option);
		csatProject.verifyColumnOptionVisibilityHide(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is Hide ", option + "Hide");
		waitTime(driver);
		csatProject.selectColumnOption(option);
		csatProject.verifyColumnOptionVisibilityView(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is View ", option + "View");
		waitTime(driver);
	}

//	public void verifyStatusFilters(String statusOption) throws Exception {
//		waitTime(driver);
//		logger.info("Selecting " + statusOption + " Status Option");
//		grep.infoTest("Selecting " + statusOption + " Status Option");
//		waitTime(driver);
//		csatProject.selectStatusFilterOption(statusOption);
//		csatProject.verifyStatusSelectedOption(statusOption);
//		String tableColumn = csatProject.verifyStatusColumnInTable();
//		validAssert.equalsAssert(tableColumn, statusOption);
//		waitTime(driver);
//		grep.captureScreenshot("pass", statusOption + " Status Option", statusOption + "_StatusOption");
//
//	}

}
