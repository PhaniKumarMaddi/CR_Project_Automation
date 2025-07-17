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

public class CSAT_RuddrProjectsTest extends CSAT_TestInitializer {
	private static final Logger logger = LogManager.getLogger(CSAT_RuddrProjectsTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Project_Page csatProject;
//	CSAT_Popup_Page csatPopup;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_SendSurvey_Test() throws Exception {
		csatProject = new CSAT_Project_Page();
//		csatPopup = new CSAT_Popup_Page();

		waitTime(driver);
		grep.testCreate("Verify the Project Ending in Filter  for Ruddr Projects Page Test",
				"Project Ending in Filter  for ruddr projects");

		waitTime(driver);
		grep.infoTest("Validating Project Ending In Filter for Ruddr Projects");
		logger.info("Validating Project Ending In Filter for Ruddr Projects");
		waitTime(driver);
		csatProject.selectProjectTypeOption(dataKeys.ruddrProject);

		grep.testCreate("Verify the Available Buttons for Ruddr Projects Page Test",
				"Available Buttons for ruddr projects");

		grep.infoTest("Validating Available Button for Ruddr Projects");
		logger.info("Validating Available Button for Ruddr Projects");

		waitTime(driver);
		grep.testCreate("Verify the Pagination Functionality for Ruddr Projects Page Test",
				"Pagination Functionality for ruddr projects");

		grep.infoTest("Validating Pagination Functionality for Ruddr Projects");
		logger.info("Validating Pagination Functionality for Ruddr Projects");

		waitTime(driver);

		validAssert.assertAllFunction();
	}

}
