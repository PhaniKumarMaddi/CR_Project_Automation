package CSAT_Survey_Module;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_SurveyPage;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_SurveyModuleUITest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_SurveyModuleUITest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_SurveyPage csat_Survey;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void surveyModule_UI_Test() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csat_Survey = new CSAT_SurveyPage();

		grep.testCreate("CSAT Survey Page UI Test", "CSAT Survey Page UI");
		waitTime1(driver);
		csatPage.navigateToPage(dataKeys.survey_Url);
		waitTime(driver);

		grep.infoTest("Validating the Header");
		logger.info("Validating the Header");
		csat_Survey.headerValidation();

		waitTime(driver);
		grep.infoTest("Validating the Add New Survey Type Popup");
		logger.info("Validating the Add New Survey Type Popup");
		waitTime(driver);
		csat_Survey.clickSurveyTypeDropDown();
		waitTime(driver);
		csat_Survey.clickAddNewSurveyTypeBtn();
		waitTime2(driver);
		csat_Survey.popupHeaderValidation(dataKeys.addSurveyTypeHeader);
		waitTime(driver);
		csat_Survey.verifyButton(dataKeys.cancelBtn);
		csat_Survey.verifyButton(dataKeys.saveBtn);
		grep.captureScreenshot("pass", "Add New Survey Type Popup Test", "addNewSurveyTypePopup");
		csat_Survey.clickCloseSurveyPopups();

		waitTime(driver);
		grep.infoTest("Validating the Add New Survey Popup");
		logger.info("Validating the Add New Survey Popup");
		waitTime(driver);
		csat_Survey.clickAddNewSurveyBtn();
		waitTime(driver);
		csat_Survey.popupHeaderValidation(dataKeys.addNewSurveyHeader);
		waitTime(driver);
		csat_Survey.verifyButton(dataKeys.cancelBtn);
		csat_Survey.verifyButton(dataKeys.saveBtn);
		grep.captureScreenshot("pass", "Add New Survey Popup Test", "addNewSurveyPopup");
		csat_Survey.clickCloseSurveyPopups();

		waitTime(driver);

		// Validating Survey Type Dropdown
		grep.testCreate("Surveys Page Survey Type Dropdown Test", "Survey page Survey Type Dropdown");
		waitTime(driver);
		grep.infoTest("Validating the Survey Type Dropdown");
		logger.info("Validating the Survey Type Dropdown");
		csat_Survey.verifySurveyTypeDropDown(dataKeys.allSurveyTypes);
		waitTime1(driver);
		selectSurveyTypeTest(dataKeys.selectEngageSurveyType);
		waitTime1(driver);
		selectSurveyTypeTest(dataKeys.selectDevelopSurveyType);
		waitTime1(driver);
		selectSurveyTypeTest(dataKeys.selectAMSSurveyType);
		waitTime1(driver);
		csat_Survey.clickSurveyTypeDropDown();
		waitTime(driver);
		csat_Survey.selectAllSurveyTypeOption();

		grep.infoTest("Survey Type Update Popup Test");
		logger.info("Survey Type Update Popup Test");

		csat_Survey.clickSurveyTypeDropDown();
		csat_Survey.selectActionInSurveyType(dataKeys.selectDevelopSurveyType, dataKeys.editProjectBtn);

		waitTime(driver);
		csat_Survey.popupHeaderValidation(dataKeys.updateSurveyTypeHeader);
		waitTime(driver);
		csat_Survey.verifyButton(dataKeys.cancelBtn);
		csat_Survey.verifyButton(dataKeys.updateBtn);
		grep.captureScreenshot("pass", "Update Survey type Popup Test", "updateSurveyTypePopup");
		csat_Survey.clickCloseSurveyPopups();
		waitTime1(driver);
		csat_Survey.clickSurveyTypeDropDown();
		csat_Survey.selectAllSurveyTypeOption();
		waitTime(driver);

		// COLUMN OPTION TEST
		grep.testCreate("Survey Page Columns Options Filters Test", "Survey page Columns Option Filters");
		waitTime(driver);
		csat_Survey.clickColumnOptionsBtn();
		csat_Survey.verifyColumnOptionsHeader(dataKeys.colOptions);
		csat_Survey.verifyButton(dataKeys.cancelBtn);
		csat_Survey.verifyButton(dataKeys.okBtn);
		grep.infoTest("Verifying Start Date Column Option");
		logger.info("Verifying Start Date Column Option");
		verifyColumnOptionFunctionality(dataKeys.startDate_ColOption);
		grep.infoTest("Verifying End Date Column Option");
		logger.info("Verifying End Date Column Option");
		verifyColumnOptionFunctionality(dataKeys.endDate_ColOption);
		grep.infoTest("Verifying Type Column Option");
		logger.info("Verifying Type Column Option");
		verifyColumnOptionFunctionality(dataKeys.type_ColOption);
		csat_Survey.clickCloseColumnOptions();

		// PAGINATION TEST
		grep.testCreate("Pagination for Table Test", "Pagination for table");
		waitTime(driver);
		logger.info("Selecting Pagination 5");
		grep.infoTest("Selecting Pagination 5");
		csat_Survey.selectPagination("5");
		csat_Survey.verifyPaginationSelectedOption("5");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 5", "Survey_Pagination_5");

		logger.info("Selecting Pagination 15");
		grep.infoTest("Selecting Pagination 15");
		csat_Survey.selectPagination("15");
		csat_Survey.verifyPaginationSelectedOption("15");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 15", "Survey_Pagination_15");

		logger.info("Selecting Pagination 10");
		grep.infoTest("Selecting Pagination 10");
		csat_Survey.selectPagination("10");
		csat_Survey.verifyPaginationSelectedOption("10");
		grep.captureScreenshot("pass", "Selecting Pagination 10", "Survey_Pagination_10");
		waitTime(driver);

		// DOWNLOAD FILE TEST
		grep.testCreate("Download File test ", "Download File");
		waitTime(driver);
		logger.info("Download CSV File Format ");
		grep.infoTest("Download CSV File Format ");
		csat_Survey.clickDownloadFileBtn(dataKeys.csvFormat);
		grep.captureScreenshot("pass", "Download CSV", "Survey_CSVFormat");
		waitTime5(driver);
		logger.info("Download PDF File Format ");
		grep.infoTest("Download PDF File Format ");
		csat_Survey.clickDownloadFileBtn(dataKeys.pdfFormat);
		waitTime5(driver);
		grep.captureScreenshot("pass", "Download PDF", "Survey_PDFFormat");

		// SEARCH SURVEY
		grep.testCreate("Search Survey using Search field Test", "Search Survey using Search field");
		waitTime(driver);
		logger.info("Search Survey");
		grep.infoTest("Search Survey");
		csat_Survey.searchSurvey(dataKeys.selectDevelopSurveyType);
		waitTime(driver);
		csat_Survey.verifyTypeColInTable(dataKeys.selectDevelopSurveyType);
		waitTime(driver);
		grep.captureScreenshot("pass", "Search Survey Test", "Survey_Search");
		csat_Survey.clearSearchSurvey();

		waitTime(driver);

		grep.testCreate("Selecting Survey from table Test", "Select Survey from table");
		waitTime(driver);

		grep.infoTest("Clicking Survey from Table");
		logger.info("Clicking Survey from Table");
		waitTime(driver);
		csat_Survey.selectSurveyFromTable(dataKeys.selectDevelopSurveyType);
		waitTime5(driver);
		csat_Survey.surveyDetailHeaderValidation(dataKeys.selectDevelopSurveyType);
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Survey From Table Popup", "Selecting_Survey_from_Table");

		waitTime(driver);
//		csat_Survey.clickCloseSurveyPopups();
		csat_Survey.clickCloseSurveyDetailsPopup();

		waitTime(driver);
		grep.infoTest("Validating Edit Survey from Table");
		logger.info("Validating Edit Survey from Table");
		waitTime(driver);

		csat_Survey.selectActionFromSurveyTable(dataKeys.selectDevelopSurveyType, dataKeys.editProjectBtn);
		waitTime(driver);
		csat_Survey.editPopupHeaderValidation();
		waitTime(driver);
		csat_Survey.verifyButton(dataKeys.cancelBtn);
		csat_Survey.verifyButton(dataKeys.saveBtn);
		grep.captureScreenshot("pass", "Edit Survey Popup Test", "EditSurvey_PopupTest");
		csat_Survey.clickCloseEditSurveyPopups();

		waitTime(driver);
		validAssert.assertAllFunction();
	}

	public void verifyColumnOptionFunctionality(String option) throws Exception {

		csat_Survey.selectColumnOption(option);
		csat_Survey.verifyColumnOptionVisibilityHide(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is Hide ", option + "Hide");
		waitTime(driver);
		csat_Survey.selectColumnOption(option);
		csat_Survey.verifyColumnOptionVisibilityView(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is View ", option + "View");
		waitTime(driver);
	}

	public void selectSurveyTypeTest(String option) throws Exception {

		grep.infoTest("Selecting " + option + " Survey Type");
		logger.info("Selecting " + option + " Survey Type");
		csat_Survey.clickSurveyTypeDropDown();
		waitTime1(driver);
		csat_Survey.selectSurveyTypeOption(option);
		waitTime1(driver);
		csat_Survey.verifyTypeColInTable(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + "survey type option ", option + "SurveyType");
		waitTime(driver);
	}

}
