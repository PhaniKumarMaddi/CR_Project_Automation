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
	CSAT_Project_Page csatproject;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_ProjectUI_Test() throws Exception {
		csatPage = new CSAT_Survey_AllPages();
		csatproject = new CSAT_Project_Page();
		grep.testCreate("CSAT Project Page UI Test", "CSAT Project Page UI");
		waitTime(driver);
		csatPage.collapseSideMenu();
		waitTime(driver);

		csatproject.headerValidation();
		waitTime(driver);
		csatproject.clickViewSurveySentStatus();
		validateSurveyPopup(dataKeys.sentSurvey);
		waitTime(driver);
		csatproject.clickViewSurveyAtRiskStatus();
		validateSurveyPopup(dataKeys.atRiskSurvey);
		waitTime(driver);
		csatproject.clickViewSurveyCompletedStatus();
		validateSurveyPopup(dataKeys.completeSurvey);
		waitTime(driver);
		csatproject.clickViewCSATScore();
		validateSurveyPopup(dataKeys.csatScore);

		// Verify New project
		csatproject.clickNewProject();
		waitTime(driver);
		String projectHeader = csatproject.verifynewProjectPopupHeader();
		String head = projectHeader.replaceAll("×", "").trim();
		waitTime(driver);
		System.out.println("popup Header " + head);
		logger.info("popup Header " + head);
		grep.infoTest("popup Header " + head);
		validAssert.equalsAssert(head, dataKeys.newProjectHeader);
		waitTime2(driver);
		grep.captureScreenshot("pass", head + " page test", head + "Popup");
		waitTime(driver);
		csatproject.clickCloseSurveyPopupBtn();
	}

	public void validateSurveyPopup(String popupHeader) throws Exception {

		csatproject = new CSAT_Project_Page();
		String headerVal = csatproject.verifySurveyPopupHeader();
		waitTime1(driver);
		System.out.println("popup Header " + headerVal);
		logger.info("popup Header " + headerVal);
		grep.infoTest("popup Header " + headerVal);
		validAssert.equalsAssert(headerVal, popupHeader);
		waitTime2(driver);
		grep.captureScreenshot("pass", popupHeader + " page test", popupHeader + "Popup");
		csatproject.clickCloseSurveyPopupBtn();
	}

}
