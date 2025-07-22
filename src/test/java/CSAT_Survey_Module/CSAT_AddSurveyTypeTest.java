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

	}
}