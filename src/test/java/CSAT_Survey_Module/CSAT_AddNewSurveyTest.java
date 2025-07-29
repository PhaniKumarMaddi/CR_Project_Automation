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

	@Test(priority = 1)
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
		csat_Survey.selectPagination("20");
		waitTime3(driver);
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
		grep.testCreate("Entering Only Spaces in survey name field for add New Survey Test",
				"Entering Only Spaces in Survey name field");
		waitTime(driver);
		grep.infoTest("Entering Only Spaces in Survey field");
		logger.info("Entering Only Spaces in Survey field");
		waitTime2(driver);
		csat_Survey.insertSurveyName(dataKeys.spacesInName);
		csat_Survey.selectAddSurveyType(dataKeys.selectAMSSurveyType);
		waitTime2(driver);
		csat_Survey.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csat_Survey.insertEndDate(dataKeys.date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Enter Only spaces in Survey name field", "OnlySpaces_SurveyName_Field");
		waitTime2(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime(driver);

		// Entering Existing name in Survey name field for add New Survey Test
		grep.testCreate("Entering Existing name in Survey name field for add New Survey Test",
				"Entering Existing name in Survey name field");
		waitTime(driver);
		grep.infoTest("Entering Existing name in Survey field");
		logger.info("Entering Existing name in Survey field");
		waitTime2(driver);
		csat_Survey.clickAddNewSurveyBtn();
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
		csat_Survey.insertEndDate(dataKeys.lesser_date_EndDate, dataKeys.lesser_month_EndDate, dataKeys.year_EndDate);
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

		// Saving with adding only spaces in section name
		grep.testCreate("Verify Saving Section Name only spaces in add Survey", "Saving with Section Name only spaces");
		waitTime(driver);
		logger.info("Verify Saving with Section Name only spaces in add survey");
		grep.infoTest("Verify Saving with Section Name only spaces in add survey");
		waitTime2(driver);
		csat_Survey.addCustomSectionName(dataKeys.spacesInName);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with Section Name only spaces",
				"onlySpaces_Sectionname_Error_AddSurvey");
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

		// Saving with adding weightage greater than 100
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
		grep.captureScreenshot("pass", "Saving with Measure Name Invalid characters",
				"invalid_MeasureName_Error_AddSurvey");
		waitTime2(driver);

		// Saving Measure name with only spaces
		grep.testCreate("Verify Saving Measure Name only spaces in add Survey", "Saving with Measure Name only spaces");
		waitTime(driver);
		logger.info("Verify Saving with Measure Name only spaces in add survey");
		grep.infoTest("Verify Saving with Measure Name only spaces in add survey");

		waitTime2(driver);
		csat_Survey.addCustomMeasureName(dataKeys.spacesInName);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with Measure Name only spaces",
				" onlySpaces_MeasureName_Error_AddSurvey");
		waitTime2(driver);

		// Saving Question name with only spaces
		grep.testCreate("Verify Saving Question Name only spaces in add Survey",
				"Saving with Question Name only spaces");
		waitTime(driver);
		logger.info("Verify Saving with Question Name only spaces in add survey");
		grep.infoTest("Verify Saving with Question Name only spaces in add survey");

		waitTime2(driver);
		csat_Survey.addCustomMeasureName(dataKeys.testingMeasureName);
		waitTime(driver);
		csat_Survey.clickAddQuestion();
		waitTime(driver);
		csat_Survey.addQuestionName(dataKeys.spacesInName);
		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.checkBoxQuestionType);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with Question Name only spaces",
				" onlySpaces_QuestionName_Error_AddSurvey");
		waitTime3(driver);

		// Keeping Blank Options
		grep.testCreate("Keeping Options as Blank in add Survey", "Keeping Options as Blank");
		waitTime(driver);
		logger.info("Keeping Options as Blank in Add Survey");
		grep.infoTest("Keeping Options as Blank in Add Survey");
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question1);
		waitTime1(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Keeping Options as Blank ", "blankOptions_AddSurvey");
		waitTime2(driver);

		// Keeping Option Weightage as Blank
		grep.testCreate("Keeping Options Weightage as Blank in add Survey", "Keeping Options Weightage as Blank");
		waitTime(driver);
		logger.info("Keeping Options Weightage as Blank in Add Survey");
		grep.infoTest("Keeping Options Weightage as Blank in Add Survey");
		waitTime(driver);
		csat_Survey.enterQuestionOption(dataKeys.testOption1);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Keeping Options Weightage as Blank ", "blankOption_Weightage_AddSurvey");
		waitTime2(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime(driver);

		// Adding only section without measure and question
		grep.testCreate("Adding only Section without adding Measure and Question in add Survey",
				"Adding only Section without adding Measure and Question");
		waitTime(driver);
		logger.info("Adding only Section without adding Measure and Question in Add Survey");
		grep.infoTest("Adding only Section without adding Measure and Question in Add Survey");
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

		csat_Survey.clickAddNewSection();
		csat_Survey.selectSectionNameOption(dataKeys.deliverySectionOption);
		waitTime2(driver);
		grep.infoTest("Entered Section Name: " + dataKeys.deliverySectionOption);
		logger.info("Entered Section Name: " + dataKeys.deliverySectionOption);

		csat_Survey.addSectionWeightage(dataKeys.weightage_100);
		waitTime(driver);
		grep.infoTest("Entered Section Weightage: " + dataKeys.weightage_100);
		logger.info("Entered Section Weightage: " + dataKeys.weightage_100);

		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Adding Only Section without Measure,Question ", "create_OnlySection_AddSurvey");
		waitTime5(driver);

		// Adding section and measure without question
		grep.testCreate("Adding Section and Measure without adding Question in add Survey",
				"Adding Section and Measure without adding Question");
		waitTime(driver);
		logger.info("Adding Section and Measure without adding Question in Add Survey");
		grep.infoTest("Adding Section and Measure without adding Question in Add Survey");
		waitTime2(driver);
		csat_Survey.clickAddMeasure();
		waitTime2(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.capabilityMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.capabilityMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.capabilityMeasureName);
		waitTime3(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Adding Section and Measure without Question ",
				"create_WithoutQuestion_AddSurvey");
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.cancelBtn);
		waitTime2(driver);

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

		String startDateSingle = csat_Survey.retrieveStartDate();
		logger.info("Entered Project Start Date: " + startDateSingle);
		grep.infoTest("Entered Project Start Date:" + startDateSingle);
		waitTime(driver);
		String endDateSingle = csat_Survey.retrieveEndDate();
		logger.info("Entered Project End Date: " + endDateSingle);
		grep.infoTest("Entered Project End Date:" + endDateSingle);
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

		waitTime3(driver);
		grep.captureScreenshot("pass", "Creating Single Section, Measure,Question ", "create_SingleSurvey_AddSurvey");
		waitTime2(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);

		waitTime5(driver);

		// verify created survey
		csat_Survey.verifySurveyCreatedShownInTable(dataKeys.surveyName);
		grep.captureScreenshot("pass", "New Survey Created", "created_SingleSurvey_Table");
		waitTime(driver);

		// create Survey with Multiple sections, measures,questions
		grep.testCreate("Creating Multiple Section, Measure,Question in add Survey",
				"Creating Multiple Section, Measure,Question");
		waitTime(driver);
		logger.info("Creating Multiple Section, Measure,Question in Add Survey");
		grep.infoTest("Creating Multiple Section, Measure,Question in Add Survey");
		waitTime(driver);

		csat_Survey.clickAddNewSurveyBtn();
		waitTime2(driver);
		csat_Survey.insertSurveyName(dataKeys.surveyNameMultiple);
		grep.infoTest("Entered Survey name: " + dataKeys.surveyNameMultiple);
		logger.info("Entered Survey name: " + dataKeys.surveyNameMultiple);

		csat_Survey.selectAddSurveyType(dataKeys.selectDevelopSurveyType);
		waitTime2(driver);
		grep.infoTest("Entered Survey Type: " + dataKeys.selectDevelopSurveyType);
		logger.info("Entered Survey Type: " + dataKeys.selectDevelopSurveyType);

		csat_Survey.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csat_Survey.insertEndDate(dataKeys.date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		waitTime(driver);

		String startDateMultiple = csat_Survey.retrieveStartDate();
		logger.info("Entered Project Start Date: " + startDateMultiple);
		grep.infoTest("Entered Project Start Date:" + startDateMultiple);
		waitTime(driver);
		String endDateMultiple = csat_Survey.retrieveEndDate();
		logger.info("Entered Project End Date: " + endDateMultiple);
		grep.infoTest("Entered Project End Date:" + endDateMultiple);
		waitTime(driver);

		// FIREST SECTION
		grep.infoTest("___Creating First Section___");
		logger.info("___Creating First Section___");

		csat_Survey.clickAddNewSection();
		csat_Survey.selectSectionNameOption(dataKeys.deliverySectionOption);
		waitTime2(driver);
		grep.infoTest("Entered Section Name: " + dataKeys.deliverySectionOption);
		logger.info("Entered Section Name: " + dataKeys.deliverySectionOption);

		csat_Survey.addSectionWeightage(dataKeys.weightage_50);
		waitTime(driver);
		grep.infoTest("Entered Section Weightage: " + dataKeys.weightage_50);
		logger.info("Entered Section Weightage: " + dataKeys.weightage_50);

		csat_Survey.clickAddMeasure();
		waitTime(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.qualityMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.qualityMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.qualityMeasureName);

		csat_Survey.clickAddQuestion();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question1);
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
		grep.captureScreenshot("pass", "Creating First Section, Measure,Question ", "create_FirstSection_AddSurvey");
		waitTime2(driver);

		// SECOND SECTION
		grep.infoTest("___Creating Second Section___");
		logger.info("___Creating Second Section___");

		csat_Survey.clickAddNewSection();
		csat_Survey.selectSectionNameOption(dataKeys.accountabilitySectionName);
		waitTime2(driver);
		grep.infoTest("Entered Section Name: " + dataKeys.accountabilitySectionName);
		logger.info("Entered Section Name: " + dataKeys.accountabilitySectionName);

		csat_Survey.addSectionWeightage(dataKeys.weightage_20);
		waitTime(driver);
		grep.infoTest("Entered Section Weightage: " + dataKeys.weightage_20);
		logger.info("Entered Section Weightage: " + dataKeys.weightage_20);

		csat_Survey.clickAddMeasure();
		waitTime(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.ownershipMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.ownershipMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.ownershipMeasureName);

		// ENTER FIRST QUESTION
		csat_Survey.clickAddQuestion();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question2);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question2);
		logger.info("Entered Question Name: " + dataKeys.Question2);
		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.checkBoxQuestionType);
		waitTime(driver);
		csat_Survey.enterQuestionOption(dataKeys.testOption1);
		csat_Survey.enterQuestionOptionWeightage("2");
		waitTime(driver);
		grep.infoTest("Entered Option 1");
		logger.info("Entered Options 1");

		waitTime(driver);
		csat_Survey.clickAddOption();
		csat_Survey.enterQuestionOption(dataKeys.testOption2);
		csat_Survey.enterQuestionOptionWeightage("1");
		waitTime(driver);
		grep.infoTest("Entered Option 2");
		logger.info("Entered Options 2");

		waitTime(driver);
		csat_Survey.clickAddOption();
		csat_Survey.enterQuestionOption(dataKeys.testOption3);
		csat_Survey.enterQuestionOptionWeightage("2");
		waitTime(driver);
		grep.infoTest("Entered Option 3");
		logger.info("Entered Options 3");
		waitTime(driver);
		grep.captureScreenshot("pass", "Creating CheckBox Question", "create_CheckboxQuestion_AddSurvey");
		waitTime2(driver);

		// ENTER SECOND QUESTION
		csat_Survey.clickAddQuestion();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question3);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question3);
		logger.info("Entered Question Name: " + dataKeys.Question3);
		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.dropdownQuestionType);
		waitTime(driver);
		csat_Survey.enterQuestionOption(dataKeys.testOption1);
		csat_Survey.enterQuestionOptionWeightage("1");
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
		csat_Survey.enterQuestionOptionWeightage("3");
		waitTime(driver);
		grep.infoTest("Entered Option 3");
		logger.info("Entered Options 3");

		waitTime(driver);
		grep.captureScreenshot("pass", "Creating Second Section, Measure,Question ", "create_SecondSection_AddSurvey");
		waitTime2(driver);

		// CUSTOME SECTION
		grep.infoTest("___Creating Custom Section___");
		logger.info("___Creating Custom Section___");

		csat_Survey.clickAddNewSection();
		csat_Survey.selectSectionNameOption(dataKeys.customSectionName);
		waitTime(driver);
		csat_Survey.addCustomSectionName(dataKeys.testingSectionName);
		waitTime2(driver);
		grep.infoTest("Entered Section Name: " + dataKeys.testingSectionName);
		logger.info("Entered Section Name: " + dataKeys.testingSectionName);

		csat_Survey.addSectionWeightage(dataKeys.weightage_30);
		waitTime(driver);
		grep.infoTest("Entered Section Weightage: " + dataKeys.weightage_30);
		logger.info("Entered Section Weightage: " + dataKeys.weightage_30);

		waitTime(driver);
		csat_Survey.clickAddMeasure();
		waitTime(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.customMeasureName);
		waitTime(driver);
		csat_Survey.addCustomMeasureName(dataKeys.testingMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.testingMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.testingMeasureName);

		csat_Survey.clickAddQuestion();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question4);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question4);
		logger.info("Entered Question Name: " + dataKeys.Question4);

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

		grep.captureScreenshot("pass", "Creating Custom Section, Measure,Question ", "create_CustomeSection_AddSurvey");
		waitTime(driver);

		// ANOTHER MEASURE FOR SAME SECTION
		grep.infoTest("Multiple Measure for Same Section");
		logger.info("Multiple Measure for Same Section");

		waitTime(driver);
		csat_Survey.clickAddMeasure();
		waitTime(driver);
		csat_Survey.selectMeasureNameOption(dataKeys.customMeasureName);
		waitTime(driver);
		csat_Survey.addCustomMeasureName(dataKeys.slaMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.slaMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.slaMeasureName);

		csat_Survey.clickAddQuestion();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.QuestionFinance);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.QuestionFinance);
		logger.info("Entered Question Name: " + dataKeys.QuestionFinance);

		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.linearScaleQuestionType);
		waitTime(driver);
		csat_Survey.selectLinearValue("5");
		csat_Survey.enterQuestionOptionWeightage("4");

		waitTime(driver);
		grep.captureScreenshot("pass", "Creating Multi Measure for same Section",
				"create_MultiMeasureForSameSection_AddSurvey");
		waitTime2(driver);

		csat_Survey.clickButton(dataKeys.saveBtn);

		waitTime10(driver);

		// verify created survey
		csat_Survey.verifySurveyCreatedShownInTable(dataKeys.surveyNameMultiple);
		grep.captureScreenshot("pass", "New Survey Created", "created_MultiSurvey_Table");
		waitTime(driver);

		validAssert.assertAllFunction();

	}

	@Test(priority = 2)
	public void updateExistingSurvey_Test() throws Exception {

		// Saving with adding weightage less than 100 in edit survey
		grep.testCreate("Verify Saving with adding weightage less than 100 in edit Survey",
				"Saving with adding weightage less than 100");
		waitTime(driver);
		logger.info("Verify Saving with adding weightage less than 100 in edit survey");
		grep.infoTest("Verify Saving with adding weightage less than 100 in edit survey");
		waitTime5(driver);
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime(driver);
		csat_Survey.weightageInEditPopup(dataKeys.weightage_Less_100);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with adding weightage less than 100 in edit popup",
				"lessThan_100_Weight_Error_EditSurvey");
		waitTime2(driver);

		// Saving with adding weightage greater than 100 in edit survey
		grep.testCreate("Verify Saving with adding weightage greater than 100 in edit Survey",
				"Saving with adding weightage greater than 100");
		waitTime(driver);
		logger.info("Verify Saving with adding weightage greater than 100 in edit survey");
		grep.infoTest("Verify Saving with adding weightage greater than 100 in edit survey");
		waitTime2(driver);
		csat_Survey.weightageInEditPopup(dataKeys.weightage_great_100);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Saving with adding weightage greater than 100",
				"greaterThan_100_Weight_Error_EditSurvey");
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.cancelBtn);
		waitTime5(driver);
		
		
		// Adding only section without measure and question and click save in edit popup
		grep.testCreate("Adding only Section without adding Measure and Question in edit Survey",
				"Adding only Section without adding Measure and Question");
		waitTime(driver);
		logger.info("Adding only Section without adding Measure and Question in Edit Survey");
		grep.infoTest("Adding only Section without adding Measure and Question in Edit Survey");
		waitTime(driver);
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime(driver);
		csat_Survey.weightageInEditPopup(dataKeys.weightage_50);
		waitTime(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickAddSection_InEdit();
		waitTime2(driver);
		csat_Survey.addSectionName_InEdit(dataKeys.ownershipSectionName);

		grep.infoTest("Entered Section Name: " + dataKeys.ownershipSectionName);
		logger.info("Entered Section Name: " + dataKeys.ownershipSectionName);

		csat_Survey.addSectionWeightage_InEdit(dataKeys.weightage_50);
		waitTime(driver);
		grep.infoTest("Entered Section Weightage: " + dataKeys.weightage_50);
		logger.info("Entered Section Weightage: " + dataKeys.weightage_50);

		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Adding Only Section without Measure,Question ", "create_OnlySection_EditSurvey");
		waitTime5(driver);
		
		// Adding section and measure without question and click save in edit popup

		grep.testCreate("Adding Section and Measure without adding Question in edit Survey",
				"Adding Section and Measure without adding Question");
		waitTime(driver);
		logger.info("Adding Section and Measure without adding Question in Edit Survey");
		grep.infoTest("Adding Section and Measure without adding Question in Edit Survey");
		waitTime2(driver);
		csat_Survey.clickAddMeasure_InEdit();
		waitTime(driver);
		csat_Survey.addMeasureName_InEdit(dataKeys.qualityMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.qualityMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.qualityMeasureName);
		waitTime1(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Adding Section and Measure without Question ",
				"create_WithoutQuestion_EditSurvey");
		waitTime2(driver);
		
		// Keeping Weightage for Options  as blank and click save
		grep.testCreate("Keeping Options Weightage as Blank in edit Survey", "Keeping Options Weightage as Blank");
		waitTime(driver);
		logger.info("Keeping Options Weightage as Blank in edit Survey");
		grep.infoTest("Keeping Options Weightage as Blank in edit Survey");
		waitTime3(driver);
		csat_Survey.clickAddQuestion_InEdit();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question2);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question2);
		logger.info("Entered Question Name: " + dataKeys.Question2);
		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.dropdownQuestionType);
		waitTime(driver);
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption1);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		csat_Survey.verifySurveyTypeErrorMessage();
		grep.captureScreenshot("pass", "Keeping Options Weightage as Blank ", "blankOption_Weightage_EditSurvey");
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.cancelBtn);
		waitTime(driver);
		
		
		// Adding New Section,Measure,Question for existing survey Test
		grep.testCreate("Adding New Section,Measure,Question for existing survey Test",
				"Adding New Section,Measure,Question for existing survey");
		waitTime(driver);
		logger.info("Adding New Section,Measure,Question for existing survey Test");
		grep.infoTest("Adding New Section,Measure,Question for existing survey Test");
		waitTime5(driver);
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime(driver);
		csat_Survey.weightageInEditPopup(dataKeys.weightage_50);
		waitTime(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickAddSection_InEdit();
		waitTime2(driver);
		csat_Survey.addSectionName_InEdit(dataKeys.ownershipSectionName);

		grep.infoTest("Entered Section Name: " + dataKeys.ownershipSectionName);
		logger.info("Entered Section Name: " + dataKeys.ownershipSectionName);

		csat_Survey.addSectionWeightage_InEdit(dataKeys.weightage_50);
		waitTime(driver);
		grep.infoTest("Entered Section Weightage: " + dataKeys.weightage_50);
		logger.info("Entered Section Weightage: " + dataKeys.weightage_50);

		csat_Survey.clickAddMeasure_InEdit();
		waitTime(driver);
		csat_Survey.addMeasureName_InEdit(dataKeys.qualityMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.qualityMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.qualityMeasureName);
		waitTime(driver);
		csat_Survey.clickAddQuestion_InEdit();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question2);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question2);
		logger.info("Entered Question Name: " + dataKeys.Question2);
		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.dropdownQuestionType);
		waitTime(driver);
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption1);
		csat_Survey.enterQuestionOptionWeightage_InEdit("3");
		waitTime(driver);
		grep.infoTest("Entered Option 1");
		logger.info("Entered Options 1");

		waitTime(driver);
		csat_Survey.clickAddOption();
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption2);
		csat_Survey.enterQuestionOptionWeightage_InEdit("2");
		waitTime(driver);
		grep.infoTest("Entered Option 2");
		logger.info("Entered Options 2");

		waitTime(driver);
		csat_Survey.clickAddOption();
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption3);
		csat_Survey.enterQuestionOptionWeightage_InEdit("5");
		waitTime(driver);
		grep.infoTest("Entered Option 3");
		logger.info("Entered Options 3");

		waitTime3(driver);
		grep.captureScreenshot("pass", "Adding another Section, Measure, Question in edit popup",
				"addAnother_Section_EditSurvey");
		waitTime2(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);

		waitTime30(driver);
		grep.infoTest("Clicking Survey from Table");
		logger.info("Clicking Survey from Table");
		waitTime5(driver);
		csat_Survey.selectSurveyFromTable(dataKeys.surveyName);
		waitTime5(driver);
		csat_Survey.surveyDetailHeaderValidation(dataKeys.surveyName);
		waitTime(driver);
		csat_Survey.verifyToggleArrow_InSurveyDetail();
		csat_Survey.verifySectionUpdated_InSurveyDetail(dataKeys.ownershipSectionName);
		grep.captureScreenshot("pass", "Added another Section, Measure, Question in edit popup",
				"added_Another_Section_EditSurvey");
		waitTime1(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime(driver);
		
		
		// Adding one measure and question for existing section in edit Survey's details popup
		grep.testCreate("Adding New Measure and Question for existing section Test",
				"Adding New Measure and Question for existing section");
		waitTime(driver);
		logger.info("Adding New Measure and Question for existing section Test");
		grep.infoTest("Adding New Measure and Question for existing section Test");
		waitTime5(driver);
		
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime2(driver);
		csat_Survey.clickAddMeasure_InEdit();
		waitTime(driver);
		csat_Survey.addMeasureName_InEdit(dataKeys.ownershipMeasureName);
		waitTime(driver);
		grep.infoTest("Entered Measure Name: " + dataKeys.ownershipMeasureName);
		logger.info("Entered Measure Name: " + dataKeys.ownershipMeasureName);
		waitTime(driver);
		csat_Survey.clickAddQuestion_InEdit();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question3);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question3);
		logger.info("Entered Question Name: " + dataKeys.Question3);
		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.dropdownQuestionType);
		waitTime(driver);
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption2);
		csat_Survey.enterQuestionOptionWeightage_InEdit("2");
		waitTime(driver);
		grep.infoTest("Entered Option 2");
		logger.info("Entered Options 2");

		waitTime(driver);
		csat_Survey.clickAddOption();
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption3);
		csat_Survey.enterQuestionOptionWeightage_InEdit("5");
		waitTime(driver);
		grep.infoTest("Entered Option 3");
		logger.info("Entered Options 3");

		waitTime3(driver);
		grep.captureScreenshot("pass", "Adding another Measure, Question for existing section in edit popup",
				"addAnother_Measure_EditSurvey");
		waitTime2(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
	
		waitTime10(driver);
		
		// Adding one question for existing section in edit Survey's details popup
	
		grep.testCreate("Adding New Question for existing measure Test",
				"Adding New Question for existing measure");
		waitTime(driver);
		logger.info("Adding New Question for existing measure Test");
		grep.infoTest("Adding New Question for existing measure Test");
		waitTime15(driver);
		
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime2(driver);
		csat_Survey.clickAddQuestion_InEdit();
		waitTime1(driver);
		csat_Survey.addQuestionName(dataKeys.Question5);
		waitTime(driver);
		grep.infoTest("Entered Question Name: " + dataKeys.Question5);
		logger.info("Entered Question Name: " + dataKeys.Question5);
		waitTime(driver);
		csat_Survey.selectQuestionTypeOption(dataKeys.dropdownQuestionType);
		waitTime(driver);
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption4);
		csat_Survey.enterQuestionOptionWeightage_InEdit("2");
		waitTime(driver);
		grep.infoTest("Entered Option 4");
		logger.info("Entered Options 4");

		waitTime3(driver);
		grep.captureScreenshot("pass", "Adding another Question for existing measure in edit popup",
				"addAnother_Question_EditSurvey");
		waitTime2(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime10(driver);
		
		// Adding one option for existing question in edit Survey's details popup
		grep.testCreate("Adding New option for existing Question Test",
				"Adding New option for existing Question");
		waitTime(driver);
		logger.info("Adding New option for existing Question Test");
		grep.infoTest("Adding New option for existing Question Test");
		waitTime15(driver);
		
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime2(driver);
		csat_Survey.clickAddOption();
		waitTime1(driver);
		csat_Survey.enterQuestionOption_InEdit(dataKeys.testOption5);
		csat_Survey.enterQuestionOptionWeightage_InEdit("1");
		waitTime(driver);
		grep.infoTest("Entered Option 5");
		logger.info("Entered Options 5");

		waitTime3(driver);
		grep.captureScreenshot("pass", "Adding another option for existing Question in edit popup",
				"addAnother_Option_EditSurvey");
		waitTime2(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);
		waitTime15(driver);		
	
		// Deleting existing Section in edit Survey's details popup without saving
		grep.testCreate("Deleting existing Section in edit Survey's details popup without saving",
				"Deleting Existing section in edit survey detail popup without saving");
		waitTime(driver);
		logger.info("Deleting Existing section in edit survey detail popup without saving");
		grep.infoTest("Deleting Existing section in edit survey detail popup without saving");
		waitTime15(driver);
		
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime5(driver);
		csat_Survey.clickDeleteSection_InEdit();
		waitTime5(driver);
		grep.captureScreenshot("pass", "Deleting Existing Section In Edit without saving",
				"DeleteSection_WithoutSave_EditSurvey");
		waitTime2(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.cancelBtn);

		waitTime15(driver);
		
		grep.infoTest("Clicking Survey from Table");
		logger.info("Clicking Survey from Table");
		waitTime5(driver);
		csat_Survey.selectSurveyFromTable(dataKeys.surveyName);
		waitTime5(driver);
		csat_Survey.surveyDetailHeaderValidation(dataKeys.surveyName);
		waitTime(driver);
		csat_Survey.verifyToggleArrow_InSurveyDetail();
		waitTime(driver);
		csat_Survey.verifySectionUpdated_InSurveyDetail(dataKeys.ownershipSectionName);
		grep.captureScreenshot("pass", "After Deleting the section in edit popup",
				"DeletingSection_WithoutSave_EditSurvey");
		waitTime1(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime5(driver);
		
		// Deleting existing Section,Measure,Question in edit Survey's details popup
		grep.testCreate("Deleting Existing section in edit survey detail popup Test",
				"Deleting Existing section in edit survey detail popup");
		waitTime(driver);
		logger.info("Deleting Existing section in edit survey detail popup");
		grep.infoTest("Deleting Existing section in edit survey detail popup");
		waitTime15(driver);
		
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csat_Survey.clickButton(dataKeys.questionButton);
		waitTime5(driver);
		csat_Survey.clickDeleteSection_InEdit();
		waitTime5(driver);
		csat_Survey.weightageInEditPopup(dataKeys.weightage_100);
		waitTime2(driver);
		grep.captureScreenshot("pass", "Deleting Existing Section In Edit",
				"DeleteSection_EditSurvey");
		waitTime2(driver);
		csat_Survey.scrollToButton(dataKeys.saveBtn);
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.saveBtn);

		waitTime15(driver);
		waitTime15(driver);
		grep.infoTest("Clicking Survey from Table");
		logger.info("Clicking Survey from Table");
		waitTime5(driver);
		csat_Survey.selectSurveyFromTable(dataKeys.surveyName);
		waitTime5(driver);
		csat_Survey.surveyDetailHeaderValidation(dataKeys.surveyName);
		waitTime(driver);
		csat_Survey.verifyToggleArrow_InSurveyDetail();
		grep.captureScreenshot("pass", "After Deleting the section in edit popup",
				"After_Deleting_Section_EditSurvey");
		waitTime1(driver);
		csat_Survey.clickButtonsInSurveyPopup(dataKeys.buttonClose);
		waitTime5(driver);
	}

	@Test(priority = 3)
	public void deleteExistingSurvey_Test() throws Exception {
		// Delete Existing Survey
		grep.testCreate("Deleting existing Survey Test", "Deleting existing Survey");
		waitTime(driver);
		grep.infoTest("Deleting existing Survey");
		logger.info("Deleting existing Survey");
		waitTime15(driver);
		csat_Survey.selectActionFromSurveyTable(dataKeys.surveyName, dataKeys.deleteProjectBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "Deleting Existing Survey", "delete_Survey");
		waitTime(driver);
		csat_Survey.clickButton(dataKeys.buttonYes);
		waitTime3(driver);
		csat_Survey.verifySurveyDeletedFromInTable(dataKeys.surveyName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Verify Deleted Survey", "survey_Deleted_From_Table");
		waitTime(driver);

		validAssert.assertAllFunction();

	}
}