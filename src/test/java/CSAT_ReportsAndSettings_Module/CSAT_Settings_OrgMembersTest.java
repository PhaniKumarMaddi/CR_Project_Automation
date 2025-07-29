package CSAT_ReportsAndSettings_Module;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Settings_OrgMember_Page;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_Settings_OrgMembersTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_Settings_OrgMembersTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Settings_OrgMember_Page csatOrgMem;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void orgMemebersTest() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csatOrgMem = new CSAT_Settings_OrgMember_Page();

		csatPage.navigateToSettingsPage(dataKeys.orgMembers_Url);
		waitTime3(driver);

		// PAGINATION TEST
		grep.testCreate("Pagination for Table Test in Setting Org Page", "Pagination for table");
		waitTime(driver);
		logger.info("Verify ORG Members Header");
		grep.infoTest("Verify ORG Members Header");
		csatOrgMem.orgMembers_HeaderValidation();
		waitTime(driver);
		logger.info("Selecting Pagination 5");
		grep.infoTest("Selecting Pagination 5");
		csatOrgMem.selectPagination("5");
		csatOrgMem.verifyPaginationSelectedOption("5");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 5", "OrgMember_Pagination_5");

		logger.info("Selecting Pagination 15");
		grep.infoTest("Selecting Pagination 15");
		csatOrgMem.selectPagination("15");
		csatOrgMem.verifyPaginationSelectedOption("15");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 15", "OrgMember_Pagination_15");

		logger.info("Selecting Pagination 10");
		grep.infoTest("Selecting Pagination 10");
		csatOrgMem.selectPagination("10");
		csatOrgMem.verifyPaginationSelectedOption("10");
		grep.captureScreenshot("pass", "Selecting Pagination 10", "OrgMember_Pagination_10");
		waitTime(driver);

		// DOWNLOAD FILE TEST
		grep.testCreate("Download File test for ORG member page ", "Download File");
		waitTime(driver);
		logger.info("Download CSV File Format ");
		grep.infoTest("Download CSV File Format ");
		csatOrgMem.clickDownloadFileBtn(dataKeys.csvFormat);
		grep.captureScreenshot("pass", "Download CSV", "OrgMember_CSVFormat");
		waitTime5(driver);
		logger.info("Download PDF File Format ");
		grep.infoTest("Download PDF File Format ");
		csatOrgMem.clickDownloadFileBtn(dataKeys.pdfFormat);
		waitTime5(driver);
		grep.captureScreenshot("pass", "Download PDF", "OrgMember_PDFFormat");

		// Verify Send invite without selecting role

		grep.testCreate("Validating the Send invite without selecting role in Org Member Test",
				"Validating the Send invite without selecting role in Org Member");
		waitTime(driver);
		logger.info("Validating the Send invite without selecting role in Org Member Test");
		grep.infoTest("Validating the Send invite without selecting role in Org Member Test");
		waitTime(driver);
		csatOrgMem.insertEmailToInvite(dataKeys.ssoUserNameDev);
		waitTime(driver);
		csatOrgMem.clickSendInvite();
		csatOrgMem.existingUserErrorMessage();
		grep.captureScreenshot("pass", "Send invite without selecting role", "Sendinvite_WithoutRole_OrgMember");
		waitTime2(driver);

		// Validating the Org Member send invite for existing user
		grep.testCreate("Validating the existing user invite in ORG Members Test",
				"Validating the existing user invite in ORG Members ");
		waitTime(driver);
		logger.info("Validating the existing user invite in ORG Members Test");
		grep.infoTest("Validating the existing user invite in ORG Members Test");
		waitTime(driver);
		csatOrgMem.insertEmailToInvite(dataKeys.ssoUserNameDev);
		csatOrgMem.clickSelectRoleDropDown();
		csatOrgMem.selectRoleToInvite(dataKeys.contributorRole);
		waitTime(driver);
		csatOrgMem.clickSendInvite();
		csatOrgMem.existingUserErrorMessage();
		grep.captureScreenshot("pass", "Inviting Existing User", "invite_ExistingUser_OrgMember");

		waitTime2(driver);

		// Validating the Org Member send invite for user
		grep.testCreate("Validating the user invite in ORG Members Test", "Validating the user invite in ORG Members ");
		waitTime(driver);
		logger.info("Validating the user invite in ORG Members Test");
		grep.infoTest("Validating the user invite in ORG Members Test");
		waitTime(driver);
		csatOrgMem.insertEmailToInvite(dataKeys.ssoUserName);
		csatOrgMem.clickSelectRoleDropDown();
		csatOrgMem.selectRoleToInvite(dataKeys.contributorRole);
		waitTime(driver);
		csatOrgMem.clickSendInvite();
		grep.captureScreenshot("pass", "Inviting User", "invite_User_OrgMember");

		waitTime2(driver);

		// Search the User
		grep.testCreate("Validating the Search Org Member Test", "Validating the Search Org Member");

		waitTime(driver);
		logger.info("Validating the Search Org Member Test");
		grep.infoTest("Validating the Search Org Member Test");
		waitTime(driver);
		logger.info("Insert Search Value: " + dataKeys.userNameSearch);
		grep.infoTest("Insert Search Value: " + dataKeys.userNameSearch);
		csatOrgMem.insertValueToSearch(dataKeys.userNameSearch);
		waitTime(driver);
		csatOrgMem.verifySearchRelatedMember(dataKeys.userNameSearch);
		waitTime(driver);
		grep.captureScreenshot("pass", "Search Organization Memeber", "Search_OrgMember");
		waitTime2(driver);

		// Updating the role for specific user
		grep.testCreate("Update the role for user in org member Test", "Update the role for existing user");
		waitTime(driver);
		logger.info("Update the role for user Test");
		grep.infoTest("Update the role for user Test");
		waitTime(driver);
		csatOrgMem.beforeUpdateRoleForUser(dataKeys.userNameSearch);
		waitTime(driver);
		grep.captureScreenshot("pass", "Before Updating the role for existing user",
				"Before_UpdatingRole_ForOrgMember");
		waitTime2(driver);
		logger.info("Updating Role for User: " + dataKeys.contributorRole);
		grep.infoTest("Updating Role for User: " + dataKeys.contributorRole);
		waitTime1(driver);
		csatOrgMem.updateRoleForUser(dataKeys.userNameSearch, dataKeys.contributorRole);
		waitTime(driver);
		csatOrgMem.afterUpdateRoleForUser(dataKeys.userNameSearch);
		waitTime(driver);
		grep.captureScreenshot("pass", "After Updating the role for existing user", "After_UpdatingRole_ForOrgMember");
		waitTime2(driver);
		csatOrgMem.updateRoleForUser(dataKeys.userNameSearch, dataKeys.adminRole);
		waitTime(driver);
		csatPage.navigateToSettingsPage(dataKeys.orgMembers_Url);

	}
}