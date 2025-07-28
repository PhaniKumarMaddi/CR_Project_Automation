package CSAT_Reports_Module;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Reports_Page;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_ReportsTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_ReportsTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Reports_Page csatReports;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void reportsPageTest() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csatReports = new CSAT_Reports_Page();

		csatPage.navigateToPage(dataKeys.reports_Url);
		waitTime3(driver);

		// Validating the Reports Page
		grep.testCreate("Validating the Reports Page Test", "Validating the Reports Page");
		waitTime(driver);

		logger.info("Verify Profile Header");
		grep.infoTest("Verify Profile Header");
		csatReports.reportsHeaderValidation();

		grep.captureScreenshot("pass", "Profile Page Test", "Profile_Page_Test");

	}
}