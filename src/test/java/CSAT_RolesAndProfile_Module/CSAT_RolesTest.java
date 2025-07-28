package CSAT_RolesAndProfile_Module;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Roles_Page;
import Pages.CSAT_SurveyPage;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_RolesTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_RolesTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Roles_Page csatRole;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void rolesPageTest() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csatRole = new CSAT_Roles_Page();

		csatPage.navigateToPage(dataKeys.roles_Url);
		waitTime3(driver);

		// Validating the Roles Page Headers
		grep.testCreate("Validating the Roles Page Header Test", "Validating the Roles Page Header");
		waitTime(driver);

		logger.info("Verify Roles Header");
		grep.infoTest("Verify Roles Header");
		csatRole.rolesHeaderValidation();

		logger.info("Verify Role Column Header");
		grep.infoTest("Verify Role Column Header");
		csatRole.roles_Column_HeaderValidation();

		logger.info("Verify Description Column Header");
		grep.infoTest("Verify Description Column Header");
		csatRole.description_Column_HeaderValidation();

		logger.info("Verify Last Modified By Column Header");
		grep.infoTest("Verify Last Modified By Column Header");
		csatRole.lastModifiedBy_Column_HeaderValidation();

		logger.info("Verify Last Modified On Column Header");
		grep.infoTest("Verify Last Modified On Column Header");
		csatRole.lastModifiedOn_Column_HeaderValidation();

		// Validating the Roles Page
		grep.testCreate("Validating the Roles Page Rows Test", "Validating the Roles Page Rows");
		waitTime(driver);

		logger.info("Verify Administrator Role and Description");
		grep.infoTest("Verify Administrator Role and Description");
		csatRole.admin_Role_Validation();
		csatRole.getRoleDescription(dataKeys.adminRole);

		logger.info("Verify Contributor Role and Description");
		grep.infoTest("Verify Contributor Role and Description");
		csatRole.contributor_Role_Validation();
		csatRole.getRoleDescription(dataKeys.contributorRole);

		logger.info("Verify Owner Role and Description");
		grep.infoTest("Verify Owner Role and Description");
		csatRole.owner_Role_Validation();
		csatRole.getRoleDescription(dataKeys.ownerRole);

		logger.info("Verify Reader Role and Description");
		grep.infoTest("Verify Reader Role and Description");
		csatRole.reader_Role_Validation();
		csatRole.getRoleDescription(dataKeys.ReaderRole);

		grep.captureScreenshot("pass", "Roles Page Test", "Roles_Page_Test");

	}
}