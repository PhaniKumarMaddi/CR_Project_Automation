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

public class CSAT_AddSurveyTypeTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_AddSurveyTypeTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_SurveyPage csat_Survey;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void addSurveyType_Test() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csat_Survey = new CSAT_SurveyPage();

		csatPage.navigateToPage(dataKeys.survey_Url);
		waitTime(driver);

		// Entering invalid characters in type field for add New Survey Type Test
		grep.testCreate("Entering invalid characters in type field for add New Survey Type Test",
				"Entering invalid characters in type field");
		waitTime(driver);
		grep.infoTest("Entering invalid characters in type field");
		logger.info("Entering invalid characters in type field");
		waitTime(driver);
		csat_Survey.clickSurveyTypeDropDown();
		waitTime(driver);
		csat_Survey.clickAddNewSurveyTypeBtn();
		waitTime2(driver);
		csat_Survey.insertType(dataKeys.invalidName);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Enter Invalid Characters in Type field", "invalid_In_TypeField");
		waitTime2(driver);

		// Entering spaces in type field for add New Survey Type Test
		grep.testCreate("Entering spaces in type field for add New Survey Type Test", "Entering spaces in type field");

		waitTime2(driver);
		grep.infoTest("Entering spaces in type field");
		logger.info("Entering spaces in type field");
		waitTime(driver);

		csat_Survey.insertType(dataKeys.spacesInName);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Enter Spaces in Type field", "spaces_In_TypeField");
		waitTime2(driver);

		// Keeping description field blank in add New Survey Type Test
		grep.testCreate("Keeping description field blank in add New Survey Type Test",
				"Keeping Description field blank");
		waitTime2(driver);
		grep.infoTest("Keeping description field blank");
		logger.info("Keeping description field blank");
		waitTime(driver);

		csat_Survey.insertType(dataKeys.surveyTypeName);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Keeping description field blank", "Blank_DescField");
		waitTime2(driver);

		// Entering spaces in description field in add New Survey Type Test
		grep.testCreate("Entering spaces in description field in add New Survey Type Test",
				"Entering spaces in description field");
		waitTime2(driver);
		grep.infoTest("Entering spaces in description field");
		logger.info("Entering spaces in description field");
		waitTime(driver);
		csat_Survey.insertDescription(dataKeys.spacesInName);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Entering spaces in description field", "Spaces_DescField");
		waitTime2(driver);

//		// Entering invalid characters in description field
		grep.testCreate("Entering invalid characters in description field in add New Survey Type Test",
				"Entering invalid characters in description field");
		waitTime2(driver);
		grep.infoTest("Entering invalid characters in description field");
		logger.info("Entering invalid characters in description field");
		waitTime(driver);
		csat_Survey.insertDescription(dataKeys.spacesInName);
//		csat_Survey.clickButton(dataKeys.saveBtn);
//		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Entering invalid characters in description field", "invalid_DescField");
		waitTime2(driver);

		// Creating New Survey Type
		grep.testCreate("Creating New Survey Type Test", "Creating New Survey Type");

		waitTime2(driver);
		grep.infoTest("Creating New Survey Type Test");
		logger.info("Creating New Survey Type Test");
		waitTime(driver);
		csat_Survey.insertType(dataKeys.surveyTypeName);
		waitTime(driver);
		csat_Survey.insertDescription(dataKeys.surveyTypeDesc);
		waitTime(driver);
		grep.captureScreenshot("pass", "Creating New Survey Type Test", "new_SurveyType");
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime10(driver);

		// Creating New Survey Type with Existing Name
		grep.testCreate("Creating survey type with existing Survey Type Test",
				"Creating Survey type with existing name");

		waitTime2(driver);
		grep.infoTest("Creating New Survey with Existing Survey Type Name Test");
		logger.info("Creating New Survey with Existing Survey Type Name Test");
		waitTime(driver);
		csat_Survey.clickSurveyTypeDropDown();
		waitTime(driver);
		csat_Survey.clickAddNewSurveyTypeBtn();
		waitTime2(driver);
		csat_Survey.insertType(dataKeys.surveyTypeName);
		waitTime(driver);
		csat_Survey.insertDescription(dataKeys.surveyTypeDesc);
		waitTime(driver);
		grep.captureScreenshot("pass", "Creating New Survey Type Test", "new_SurveyType");
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime5(driver);
		csat_Survey.clickButton(dataKeys.cancelBtn);

//		// Editing existing Survey Type
	// Verify by entering invalid characters in type field for Edit Survey Type
	 grep.testCreate("Editing invalid characters in type field for Edit Survey Type Test", "Editing invalid characters in type");
		waitTime2(driver);
		grep.infoTest("Editing invalid characters in type field for Edit Survey Type Test");
		logger.info("Editing invalid characters in type field for Edit Survey Type Test");
		waitTime(driver);
		csat_Survey.clickSurveyTypeDropDown();
		waitTime(driver);
		csat_Survey.selectActionInSurveyType(dataKeys.surveyTypeName, dataKeys.editProjectBtn);
		waitTime(driver);
		csat_Survey.insertType(dataKeys.invalidName);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Editing invalid characters in type field for Edit Survey Type Test", "invalid_In_TypeField_Edit");
		waitTime5(driver);
		
		// Verify by entering spaces in type field for Edit Survey Type
		 grep.testCreate("Editing  entering spaces in type field for Edit Survey Type Test", "Editing entering spaces in type field");
		 waitTime2(driver);
			grep.infoTest("Editing  entering spaces in type field for Edit Survey Type Test");
			logger.info("Editing  entering spaces in type field for Edit Survey Type Test");
			waitTime(driver);
			csat_Survey.insertType(dataKeys.spacesInName);
			csat_Survey.clickButton(dataKeys.saveBtn);
			csat_Survey.verifySurveyTypeErrorMessage();
			waitTime(driver);
			grep.captureScreenshot("pass", "Editing  entering spaces in type field for Edit Survey Type Test", "spaces_In_TypeFieldEdit");
			waitTime5(driver);
			
		// Verify by entering spaces in description field in Edit Survey Type
		 grep.testCreate("Entering spaces in description field in Edit Survey Type Test", "Entering spaces in description field");
		 waitTime2(driver);
			grep.infoTest("Entering spaces in description field in Edit Survey Type Test");
			logger.info("Entering spaces in description field in Edit Survey Type Test");
			waitTime(driver);
			csat_Survey.insertType(dataKeys.surveyTypeName);
			csat_Survey.insertDescription(dataKeys.spacesInName);
			waitTime(driver);
			csat_Survey.clickButton(dataKeys.saveBtn);
			
			csat_Survey.verifySurveyTypeErrorMessage();
			waitTime(driver);
			grep.captureScreenshot("pass", "Entering spaces in description field in Edit Survey Type Test", "Spaces_DescFieldEdit");
			waitTime5(driver);
			
			
		// Verify by entering invalid characters in description field in Edit Survey Type
		 grep.testCreate("Entering invalid chracters in description field in Edit Survey Type Test", "Entering invalid chracters in description field");
		 waitTime2(driver);
			grep.infoTest("Entering invalid chracters in description field in Edit Survey Type Test");
			logger.info("Entering invalid chracters in description field in Edit Survey Type Test");
			waitTime(driver);
			csat_Survey.insertDescription(dataKeys.invalidProjectDesc);
			csat_Survey.clickButton(dataKeys.saveBtn);
			csat_Survey.verifySurveyTypeErrorMessage();
			waitTime(driver);
			grep.captureScreenshot("pass", "Entering invalid chracters in description field in Edit Survey Type Test", "invalid_DescFieldEdit");
			waitTime5(driver);
			
		// Verify updating the type and description in Edit Survey type
		 grep.testCreate("Updating the type and description in Edit Survey type Test", "Updating the type and description");
		 waitTime2(driver);
			grep.infoTest("Updating the type and description in Edit Survey type Test");
			logger.info("Updating the type and description in Edit Survey type Test");
			waitTime(driver);
			csat_Survey.insertType(dataKeys.updatedSurveyTypeName);
			csat_Survey.insertDescription(dataKeys.surveyTypeDesc);
			waitTime(driver);
			grep.captureScreenshot("pass", "Updating the type and description in Edit Survey type Test", "update_SurveyType");
			waitTime(driver);
			csat_Survey.clickButton(dataKeys.saveBtn);
			waitTime5(driver);
			
			
		// Deleting Existing Survey Type
		grep.testCreate("Deleting Existing Survey Type Test", "Deleting Existing Survey Type");

		waitTime2(driver);
		grep.infoTest("Deleting Existing Survey Type Test");
		logger.info("Deleting Existing Survey Type Test");
		waitTime(driver);
		csat_Survey.clickSurveyTypeDropDown();
		csat_Survey.selectActionInSurveyType(dataKeys.surveyTypeName, dataKeys.deleteProjectBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "Deleteing Existing Survey Type", "delete_SurveyType");
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.buttonYes);
		waitTime(driver);
		refreshPage();
		
		validAssert.assertAllFunction();

	}

}