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

public class CSAT_AddNewSurveyTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_AddNewSurveyTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_SurveyPage csat_Survey;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void addNewSurvey_Test() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csat_Survey = new CSAT_SurveyPage();

		csatPage.navigateToPage(dataKeys.survey_Url);
		waitTime(driver);

		// Entering invalid characters in Survey name field for add New Survey Test
		grep.testCreate("Entering invalid characters in Survey name field for add New Survey Test",
				"Entering invalid characters in Survey name field");
		waitTime(driver);
		grep.infoTest("Entering invalid characters in Survey name field");
		logger.info("Entering invalid characters in Survey name field");
		waitTime(driver);
		csat_Survey.clickAddNewSurveyBtn();
		waitTime2(driver);
		csat_Survey.insertSurveyName(dataKeys.invalidName);
		waitTime(driver);
		grep.infoTest("Entering Survey Name field: " + dataKeys.invalidName);
		logger.info("Entering invalid characters in Survey name field: " + dataKeys.invalidName);
		waitTime(driver);
		csat_Survey.verifySurveyNameErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Enter Invalid Characters in Survey name field", "invalid_SurveyName_Field");
		waitTime2(driver);

		// Enter Spaces Characters in Survey Name
//		grep.testCreate("Entering Only Spaces in Survey name field for add New Survey Test",
//				"Entering Only Spaces in Survey name field");

		// Entering Existing name in Survey name field for add New Survey Test
		grep.testCreate("Entering Existing name in Survey name field for add New Survey Test",
				"Entering Existing name in Survey name field");
		waitTime(driver);
		grep.infoTest("Entering Existing name in Survey field");
		logger.info("Entering Existing name in Survey field");
		waitTime2(driver);
		csat_Survey.insertSurveyName(dataKeys.selectDevelopSurveyType);
		csat_Survey.selectAddSurveyType(dataKeys.selectAMSSurveyType);
		waitTime(driver);
		grep.infoTest("Entering Existing Survey Name: " + dataKeys.selectDevelopSurveyType);
		logger.info("Entering Existing Survey Name : " + dataKeys.selectDevelopSurveyType);
		csat_Survey.verifySurveyNameErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Enter Existing name in Survey name field", "existing_SurveyName_Field");
		waitTime2(driver);

		// Enter End Date is less than Start date new project
		grep.testCreate("Verify Entering End date Previous than Start Date Test in add Survey",
				"Add End Date Previous than Start Date");
		waitTime(driver);
		logger.info("Verify Entering End Date previous than Start date in add survey");
		grep.infoTest("Verify Entering End Date previous than Start date in add survey");
		waitTime2(driver);
		csat_Survey.insertSurveyName(dataKeys.surveyName);
		waitTime(driver);
		csat_Survey.selectAddSurveyType(dataKeys.selectTODSurveyType);
		waitTime2(driver);
		csat_Survey.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csat_Survey.insertEndDate(dataKeys.lesser_date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime(driver);

		grep.captureScreenshot("pass", "Entering End date Previous than Start Date", "EndDate_Error_AddSurvey");
		waitTime2(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime(driver);

		// Saving without adding weightage or section
		grep.testCreate("Verify Saving without adding weightage or Section in add Survey",
				"Saving without adding weightage or Section ");
		waitTime(driver);
		logger.info("Verify Saving without adding weightage or Section in add survey");
		grep.infoTest("Verify Saving without adding weightage or Section in add survey");
		waitTime2(driver);
		csat_Survey.clickAddNewSurveyBtn();
		waitTime(driver);
		csat_Survey.insertSurveyName(dataKeys.surveyName);
		csat_Survey.selectAddSurveyType(dataKeys.selectTODSurveyType);
		waitTime2(driver);
		csat_Survey.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csat_Survey.insertEndDate(dataKeys.date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		waitTime(driver);
		String startDate = csat_Survey.retrieveStartDate();
		logger.info("Entered Project Start Date: " + startDate);
		grep.infoTest("Entered Project Start Date:" + startDate);
		waitTime(driver);
		String endDate = csat_Survey.retrieveEndDate();
		logger.info("Entered Project End Date: " + endDate);
		grep.infoTest("Entered Project End Date:" + endDate);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving without adding section or weightage",
				"withOut_SectionOrWeigth_Error_AddSurvey");
		waitTime2(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime(driver);

		// Saving with adding invalid characters in section name
		grep.testCreate("Verify Saving Section Name Invalid characters in add Survey",
				"Saving with Section Name Invalid characters");
		waitTime(driver);
		logger.info("Verify Saving with Section Name Invalid characters in add survey");
		grep.infoTest("Verify Saving with Section Name Invalid characters in add survey");
		waitTime2(driver);
		csat_Survey.clickAddNewSurveyBtn();
		waitTime(driver);
		csat_Survey.insertSurveyName(dataKeys.surveyName);
		csat_Survey.selectAddSurveyType(dataKeys.selectTODSurveyType);
		waitTime2(driver);
		csat_Survey.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csat_Survey.insertEndDate(dataKeys.date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		waitTime(driver);
		csat_Survey.clickAddNewSection();
		csat_Survey.selectSectionNameOption(dataKeys.customSectionName);
		waitTime(driver);
		csat_Survey.addCustomSectionName(dataKeys.invalidName);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with Section Name Invalid characters",
				"invalid_Sectionname_Error_AddSurvey");
		waitTime2(driver);

		// Saving with adding weightage less than 100
		grep.testCreate("Verify Saving with adding weightage less than 100 in add Survey",
				"Saving with adding weightage less than 100");
		waitTime(driver);
		logger.info("Verify Saving with adding weightage less than 100 in add survey");
		grep.infoTest("Verify Saving with adding weightage less than 100 in add survey");
		waitTime2(driver);
		csat_Survey.addCustomSectionName(dataKeys.testingSectionName);
		waitTime2(driver);
		csat_Survey.addSectionWeightage(dataKeys.weightage_Less_100);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with adding weightage less than 100",
				"lessThan_100_Weight_Error_AddSurvey");
		waitTime2(driver);

		// Saving with adding weightage less than 100
		grep.testCreate("Verify Saving with adding weightage greater than 100 in add Survey",
				"Saving with adding weightage greater than 100");
		waitTime(driver);
		logger.info("Verify Saving with adding weightage greater than 100 in add survey");
		grep.infoTest("Verify Saving with adding weightage greater than 100 in add survey");
		waitTime2(driver);
		csat_Survey.addSectionWeightage(dataKeys.weightage_great_100);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with adding weightage greater than 100",
				"greaterThan_100_Weight_Error_AddSurvey");
		waitTime2(driver);

		// Saving with Measure name invalid characters
		grep.testCreate("Verify Saving Measure Name Invalid characters in add Survey",
				"Saving with Measure Name Invalid characters");
		waitTime(driver);
		logger.info("Verify Saving with Measure Name Invalid characters in add survey");
		grep.infoTest("Verify Saving with Measure Name Invalid characters in add survey");

		waitTime2(driver);
		csat_Survey.addSectionWeightage(dataKeys.weightage_100);
		waitTime(driver);
		csat_Survey.clickAddMeasure();
		waitTime(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.customMeasureName);
		waitTime(driver);
		csat_Survey.addCustomMeasureName(dataKeys.invalidName);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with  Measure Name Invalid characters",
				"invalid_MeasureName_Error_AddSurvey");
		waitTime2(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime(driver);

		// Keeping Blank Options
		grep.testCreate("Keeping Options as Blank in add Survey", "Keeping Options as Blank");
		waitTime(driver);
		logger.info("Keeping Options as Blank in Add Survey");
		grep.infoTest("Keeping Options as Blank in Add Survey");
		waitTime(driver);
		csat_Survey.clickAddNewSurveyBtn();
		waitTime2(driver);
		csat_Survey.insertSurveyName(dataKeys.surveyName);
		csat_Survey.selectAddSurveyType(dataKeys.selectTODSurveyType);
		waitTime2(driver);
		csat_Survey.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csat_Survey.insertEndDate(dataKeys.date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		waitTime(driver);
		csat_Survey.clickAddNewSection();
		csat_Survey.selectSectionNameOption(dataKeys.deliverySectionOption);
		waitTime2(driver);
		csat_Survey.addSectionWeightage(dataKeys.weightage_100);
		waitTime(driver);
		csat_Survey.clickAddMeasure();
		waitTime(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.capabilityMeasureName);
		waitTime(driver);
		csat_Survey.clickAddQuestion();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question1);
		waitTime(driver);
		csat_Survey.enterQuestionOptionWeightage("1");
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Keeping Options as Balnk ", "blankOptions_AddSurvey");
		waitTime2(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime(driver);

		// create single section, measure,question
		grep.testCreate("Creating Single Section, Measure,Question in add Survey",
				"Creating Single Section, Measure,Question");
		waitTime(driver);
		logger.info("Creating Single Section, Measure,Question in Add Survey");
		grep.infoTest("Creating Single Section, Measure,Question in Add Survey");
		waitTime(driver);

		csat_Survey.clickAddNewSurveyBtn();
		waitTime2(driver);
		csat_Survey.insertSurveyName(dataKeys.surveyName);
		grep.infoTest("Entered Survey name: " + dataKeys.surveyName);
		logger.info("Entered Survey name: " + dataKeys.surveyName);
		csat_Survey.selectAddSurveyType(dataKeys.selectTODSurveyType);
		waitTime2(driver);
		grep.infoTest("Entered Survey Type: " + dataKeys.selectTODSurveyType);
		logger.info("Entered Survey Type: " + dataKeys.selectTODSurveyType);

		csat_Survey.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csat_Survey.insertEndDate(dataKeys.date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		waitTime(driver);

		String startDate1 = csat_Survey.retrieveStartDate();
		logger.info("Entered Project Start Date: " + startDate1);
		grep.infoTest("Entered Project Start Date:" + startDate1);
		waitTime(driver);
		String endDate1 = csat_Survey.retrieveEndDate();
		logger.info("Entered Project End Date: " + endDate1);
		grep.infoTest("Entered Project End Date:" + endDate1);
		waitTime(driver);

		csat_Survey.clickAddNewSection();
		csat_Survey.selectSectionNameOption(dataKeys.deliverySectionOption);
		waitTime2(driver);
		grep.infoTest("Entered Section Name: " + dataKeys.deliverySectionOption);
		logger.info("Entered Section Name: " + dataKeys.deliverySectionOption);

		csat_Survey.addSectionWeightage(dataKeys.weightage_100);
		waitTime(driver);
		grep.infoTest("Entered Section Weightage: " + dataKeys.weightage_100);
		logger.info("Entered Section Weightage: " + dataKeys.weightage_100);

		csat_Survey.clickAddMeasure();
		waitTime(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.capabilityMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.capabilityMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.capabilityMeasureName);

		csat_Survey.clickAddQuestion();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question1);
		waitTime(driver);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question1);
		logger.info("Entered Question Name: " + dataKeys.Question1);

		waitTime(driver);
		csat_Survey.enterQuestionOption(dataKeys.testOption1);
		csat_Survey.enterQuestionOptionWeightage("3");
		waitTime(driver);
		grep.infoTest("Entered Option 1");
		logger.info("Entered Options 1");

		waitTime(driver);
		csat_Survey.clickAddOption();
		csat_Survey.enterQuestionOption(dataKeys.testOption2);
		csat_Survey.enterQuestionOptionWeightage("5");
		waitTime(driver);
		grep.infoTest("Entered Option 2");
		logger.info("Entered Options 2");

		waitTime(driver);
		csat_Survey.clickAddOption();
		csat_Survey.enterQuestionOption(dataKeys.testOption3);
		csat_Survey.enterQuestionOptionWeightage("4");
		waitTime(driver);
		grep.infoTest("Entered Option 3");
		logger.info("Entered Options 3");

		waitTime(driver);
		grep.captureScreenshot("pass", "Creating Single Section, Measure,Question ", "create_SingleSurvey_AddSurvey");
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);

		waitTime2(driver);

		// verify created survey
		csat_Survey.verifySurveyCreatedShownInTable(dataKeys.surveyName);
		grep.captureScreenshot("pass", "New Survey Created", "created_SingleSurvey_Table");
		waitTime(driver);

		validAssert.assertAllFunction();

	}

}