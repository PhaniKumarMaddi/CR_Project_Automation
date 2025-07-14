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

public class CSAT_ProjectFiltersTest extends CSAT_TestInitializer {
	private static final Logger logger = LogManager.getLogger(CSAT_ProjectFiltersTest.class);
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

		grep.testCreate("Download File test ", "Download File");
		waitTime(driver);
		logger.info("Download CSV File Format ");
		grep.infoTest("Download CSV File Format ");
		csatProject.clickDownloadFileBtn(dataKeys.csvFormat);
		grep.captureScreenshot("pass", "Download CSV", "CSVFormat");
		waitTime(driver);
		logger.info("Download PDF File Format ");
		grep.infoTest("Download PDF File Format ");
		csatProject.clickDownloadFileBtn(dataKeys.pdfFormat);
		grep.captureScreenshot("pass", "Download PDF", "PDFFormat");

		grep.testCreate("Pagination for Table Test", "Pagination for table");
		waitTime(driver);
		logger.info("Selecting Pagination 5");
		grep.infoTest("Selecting Pagination 5");
		csatProject.selectPagination("5");
		csatProject.verifyPaginationSelectedOption("5");

		logger.info("Selecting Pagination 50");
		grep.infoTest("Selecting Pagination 50");
		csatProject.selectPagination("50");
		csatProject.verifyPaginationSelectedOption("50");

		logger.info("Selecting Pagination 100");
		grep.infoTest("Selecting Pagination 100");
		csatProject.selectPagination("100");
		csatProject.verifyPaginationSelectedOption("100");
		waitTime(driver);

		grep.testCreate("Verify Buttons related to project ", "Verify project buttons");
		waitTime(driver);
		grep.infoTest("Verify Edit button");
		logger.info("Verify Edit button");
		csatProject.verifyProjectBtns(dataKeys.editBtn);
		grep.infoTest("Verify Delete button");
		logger.info("Verify Delete button");
		csatProject.verifyProjectBtns(dataKeys.deleteBtn);
		grep.infoTest("Verify Send button");
		logger.info("Verify Send button");
		csatProject.verifyProjectBtns(dataKeys.sendBtn);

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

		// Status Filter
		waitTime(driver);
		grep.testCreate("Projects Page Status Filters Test", "Projects Page Status Filter");

		csatProject.verifyStatusSelectedOption(dataKeys.allStatusesOption);
		validAssert.verifyStatusFilters(dataKeys.pipelineStatusOption);
		validAssert.verifyStatusFilters(dataKeys.completedStatusOption);
		validAssert.verifyStatusFilters(dataKeys.inProgressStatusOption);
		csatProject.selectStatusFilterOption(dataKeys.allStatusesOption);

		// survey response filter
		waitTime(driver);
		grep.testCreate("Projects Page Survey Response Filters Test", "Projects Page Survey Response Filter");

		csatProject.verifySurveyResponseSelectedOption(dataKeys.allSurveyResponse);
		validAssert.verifySurveyResponseFilters(dataKeys.surveyResponseNo);
		validAssert.verifySurveyResponseFilters(dataKeys.surveyResponseYes);
		csatProject.selectSurveyResponseFilterOption(dataKeys.allSurveyResponse);

		// projects filter
		waitTime(driver);
		grep.testCreate("Projects Page Project Filters Test", "Projects Page Project Filter");

		csatProject.verifyProjectSelectedOption(dataKeys.surveyProject);
		validAssert.verifyProjectFilters(dataKeys.ruddrProject, dataKeys.ruddrOper);
		csatProject.selectProjectFilterOption(dataKeys.surveyProject);

		// Practices filter
		waitTime(driver);
		grep.testCreate("Projects Page Practices Filters Test", "Projects Page Practices Filter");

		csatProject.verifyPracticeSelectedOption(dataKeys.allPractices);
//		validAssert.verifyPracticesFilters(dataKeys.DSandAIPractice);
		waitTime2(driver);
		validAssert.verifyPracticesFilters(dataKeys.ERP_Practice);
		validAssert.verifyPracticesFilters(dataKeys.Product_Engg_Practice);
		csatProject.selectPracticeFilterOption(dataKeys.allPractices);

		// ending days filter
		waitTime(driver);
		grep.testCreate("Projects Page Ending Days Filters Test", "Projects Page Ending Days Filter");

		csatProject.verifyEndingDaysSelectedOption(dataKeys.projectEndingIn);
		validAssert.verifyEndingDayFilters(dataKeys.days_60);
		validAssert.verifyEndingDayFilters(dataKeys.days_7);
		csatProject.selectEndingDaysFilterOption(dataKeys.projectEndingIn);

		grep.testCreate("Selecting Multiple Filter Test", "Multiple Filters ");
		waitTime2(driver);

		validAssert.verifyStatusFilters(dataKeys.inProgressStatusOption);
		waitTime2(driver);
		validAssert.verifySurveyResponseFilters(dataKeys.surveyResponseNo);
		validAssert.verifyPracticesFilters(dataKeys.ERP_Practice);

		grep.captureScreenshot("pass", "Multi filter test ", "MultiFilterTest");
		waitTime(driver);
		csatPage.expandSideMenu();
		waitTime(driver);
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
