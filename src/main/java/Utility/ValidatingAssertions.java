package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import Pages.CR_ChatBot_Page;
import Pages.CSAT_Project_Page;

public class ValidatingAssertions extends WaitsManager {

	private static final Logger logger = LogManager.getLogger(ValidatingAssertions.class);

	GenerateReports grep = new GenerateReports();
	TestDataKeys testData = new TestDataKeys();
	SoftAssert softAsserts = new SoftAssert();
	CR_ChatBot_Page crPage = new CR_ChatBot_Page();
	CSAT_Project_Page csatProject = new CSAT_Project_Page();

	// Validate equal assert
	public void equalsAssert(String actualResult, String expectedResult) throws Exception {
		// Validating
		softAsserts.assertEquals(actualResult, expectedResult);
		System.out.println("Expected :" + expectedResult + " and Actual :" + actualResult);
		logger.info("Expected :" + expectedResult + " and Actual :" + actualResult);
		assertPassOrFail(actualResult, expectedResult);
	}

	// Validate Not equal assert
	public void notEqualsAssert(String actualResult, String expectedResult) throws Exception {
		// Validating
		softAsserts.assertNotEquals(actualResult, expectedResult);
//		System.out.println("Expected :" + expectedResult + " and Actual :" + actualResult);
//		logger.info("Expected :" + expectedResult + " and Actual :" + actualResult);
		assertNotEqualPassOrFail(actualResult, expectedResult);

	}

	// Validate assertTrue
	public void trueAssert(boolean condition) throws Exception {
		// Validating
		softAsserts.assertTrue(condition);
		System.out.println(condition);
	}

	// Validate assertFalse
	public void falseAssert(boolean condition) throws Exception {
		// Validating
		softAsserts.assertFalse(condition);
		System.out.println(condition);

	}

	// Validate assertFalse
	public void falseAssertion(boolean condition, String message) throws Exception {
		// Validating
		softAsserts.assertFalse(condition, message);
		System.out.println(condition);
		System.out.println(message);

	}

	// PASS OR FAIL
	public void assertPassOrFail(String actualResult, String expectedResult) {
		if (actualResult.equals(expectedResult)) {
			grep.passTest("Expected :" + expectedResult + " and Actual :" + actualResult + " both are same");
			logger.info("Expected :" + expectedResult + " and Actual :" + actualResult + " both are same");
		} else {
			grep.failTest("Expected and Actual are not same Expected [" + expectedResult + " ], but found ["
					+ actualResult + "]");
			logger.error("Expected and Actual are not same Expected [" + expectedResult + " ], but found ["
					+ actualResult + "]");
		}
	}

	public void assertNotEqualPassOrFail(String actualResult, String expectedResult) {
		if (!actualResult.equals(expectedResult)) {
			grep.passTest("Expected :" + expectedResult + " and Actual :" + actualResult + " both are same");
			logger.info("Expected :" + expectedResult + " and Actual :" + actualResult + " both are same");
		} else {
			grep.failTest("Expected and Actual are not same Expected [" + expectedResult + " ], but found ["
					+ actualResult + "]");
			logger.error("Expected and Actual are not same Expected [" + expectedResult + " ], but found ["
					+ actualResult + "]");
		}
	}

	public void assertAllFunction() {
		softAsserts.assertAll();
	}

	// CHATBOT PROMPTS VALIDATION
	public void validatePromptMessage(String result) throws Exception {

		String getMessage = crPage.getUserMessagePrompt();
		softAsserts.assertEquals(getMessage, result);
		System.out.println("Expected :" + result + " and Actual :" + getMessage);
		assertPassOrFail(getMessage, result);
	}

	public void validateLinkPreviewTitle(String result) throws Exception {

		String getTitle = crPage.getLinkTitle();
		softAsserts.assertEquals(getTitle, result);
		System.out.println("Expected :" + result + " and Actual :" + getTitle);
		assertPassOrFail(getTitle, result);
	}

	public void validateLinkDescription(String result) throws Exception {

		String getDesc = crPage.getLinkDescription();
		System.out.println("Validating the Link Description: " + getDesc);
		grep.infoTest("Validating the Link Description: " + getDesc);
		logger.info("Validating the Link Description: " + getDesc);
		softAsserts.assertEquals(getDesc, result);
		System.out.println("Expected :" + result + " and Actual :" + getDesc);
		assertPassOrFail(getDesc, result);
	}

	public void validatePageTitle(String result) throws Exception {

		String pageHeaderVal = crPage.verifyPageTitle();
		System.out.println("Validating the Page Header value for Link Page: " + pageHeaderVal);
		grep.infoTest("Validating the Table Header value for Link Page: " + pageHeaderVal);
		logger.info("Validating the Table Header value for Link Page: " + pageHeaderVal);
		softAsserts.assertEquals(pageHeaderVal.trim(), result);
		System.out.println("Expected :" + result + " and Actual :" + result);
		assertPassOrFail(pageHeaderVal, result);
	}

	// CSAT RELATED

	// status filter
	public void verifyStatusFilters(String statusOption) throws Exception {
		logger.info("Selecting " + statusOption + " Status Option");
		grep.infoTest("Selecting " + statusOption + " Status Option");
		csatProject.selectStatusFilterOption(statusOption);
		csatProject.verifyStatusSelectedOption(statusOption);
		String tableColumn = csatProject.verifyStatusColumnInTable();
		softAsserts.assertEquals(tableColumn, statusOption);
		System.out.println("Expected :" + statusOption + " and Actual :" + tableColumn);
		assertPassOrFail(tableColumn, statusOption);
		grep.captureScreenshot("pass", statusOption + " Status Option", statusOption + "_StatusOption");

	}

	// survey response filter
	public void verifySurveyResponseFilters(String surveyOption,String verifyTableOption) throws Exception {
		logger.info("Selecting " + surveyOption + " Survey response Option");
		grep.infoTest("Selecting " + surveyOption + " Survey response Option");
		waitTime(driver);
		csatProject.selectSurveyResponseFilterOption(surveyOption);
		waitTime2(driver);
		csatProject.verifySurveyResponseSelectedOption(surveyOption);
		waitTime1(driver);
		String tableColumn = csatProject.verifySurveyResponseColumnInTable();
		softAsserts.assertEquals(tableColumn, verifyTableOption);
		System.out.println("Expected :" + verifyTableOption + " and Actual :" + tableColumn);
		assertPassOrFail(tableColumn, verifyTableOption);
		grep.captureScreenshot("pass", verifyTableOption + " Survey response Option",
				surveyOption + "_SurveyResponseOption");

	}

	// projects filter
	public void verifyProjectFilters(String projectOption, String verifyOpt) throws Exception {
		logger.info("Selecting " + projectOption + " Project Option");
		grep.infoTest("Selecting " + projectOption + " Project Option");
		csatProject.selectProjectFilterOption(projectOption);
		waitTime5(driver);
		csatProject.verifyProjectSelectedOption(projectOption);
		String tableColumn = csatProject.verifyProjectColumnInTable();
		softAsserts.assertEquals(tableColumn, verifyOpt);
		System.out.println("Expected :" + verifyOpt + " and Actual :" + tableColumn);
		assertPassOrFail(tableColumn, verifyOpt);
		grep.captureScreenshot("pass", projectOption + " Project Option", verifyOpt + "_ProjectOption");

	}

	// ending days filter
	public void verifyEndingDayFilters(String endingDaysOption) throws Exception {
		logger.info("Selecting " + endingDaysOption + " Ending Days Option");
		grep.infoTest("Selecting " + endingDaysOption + " Ending Days Option");
		csatProject.selectEndingDaysFilterOption(endingDaysOption);
		csatProject.verifyEndingDaysSelectedOption(endingDaysOption);
//			String tableColumn = csatProject.verifyEndingDaysColumnInTable();
//			softAsserts.assertEquals(tableColumn, endingDaysOption);
//			System.out.println("Expected :" + tableColumn + " and Actual :" + endingDaysOption);
//			assertPassOrFail(tableColumn, endingDaysOption);
		grep.captureScreenshot("pass", endingDaysOption + " Ending Days Option",
				endingDaysOption + "_EndingDaysOption");

	}

	// Practices filter
	public void verifyPracticesFilters(String practiceOption) throws Exception {
		logger.info("Selecting " + practiceOption + " Practice Option");
		grep.infoTest("Selecting " + practiceOption + " Practice Option");
		csatProject.selectPracticeFilterOption(practiceOption);
		csatProject.verifyPracticeSelectedOption(practiceOption);
		String tableColumn = csatProject.verifyPracticeColumnInTable();
		String expectedVal = tableColumn.toLowerCase();
		String verifyOpt = practiceOption.toLowerCase();
		softAsserts.assertEquals(expectedVal, verifyOpt);
		System.out.println("Expected :" + practiceOption + " and Actual :" + tableColumn);
		assertPassOrFail(tableColumn, practiceOption);
		grep.captureScreenshot("pass", practiceOption + " Practice Option", practiceOption + "_PracticeOption");

	}

}
