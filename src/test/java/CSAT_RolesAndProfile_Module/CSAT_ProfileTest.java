package CSAT_RolesAndProfile_Module;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Profile_Page;
import Pages.CSAT_Project_Page;
import Pages.CSAT_Roles_Page;
import Pages.CSAT_SurveyPage;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_ProfileTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_ProfileTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Profile_Page csatProfile;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void profilePageTest() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csatProfile = new CSAT_Profile_Page();

		csatPage.navigateToPage(dataKeys.profile_Url);
		waitTime3(driver);

		// Validating the Roles Page Headers
		grep.testCreate("Validating the Profile Page Test", "Validating the Profile Page");
		waitTime(driver);

		logger.info("Verify Profile Header");
		grep.infoTest("Verify Profile Header");
		csatProfile.profileHeaderValidation();

		logger.info("Verify Full name");
		grep.infoTest("Verify Full name");
		csatProfile.getFullName();

		logger.info("Verify Email");
		grep.infoTest("Verify Email");
		csatProfile.getEmail();

		grep.captureScreenshot("pass", "Profile Page Test", "Profile_Page_Test");

	}
}