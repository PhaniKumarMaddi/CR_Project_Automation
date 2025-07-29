package CSAT_ReportsAndSettings_Module;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Settings_Teams_Page;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_Settings_TeamsTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_Settings_TeamsTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Settings_Teams_Page csatTeam;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void teamsTest() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csatTeam = new CSAT_Settings_Teams_Page();

		csatPage.navigateToSettingsPage(dataKeys.teams_Url);

		waitTime3(driver);

		// Verify Search Team using search team and user field
		grep.testCreate("Search Team name using search team and user field in Setting Teams Page",
				"Search Team name using search team and user field");
		waitTime(driver);
		logger.info("Search Team name using search team and user field in Setting Teams Page");
		grep.infoTest("Search Team name using search team and user field in Setting Teams Page");

		logger.info("Verify Teams Header");
		grep.infoTest("Verify Teams Header");
		csatTeam.teams_HeaderValidation();
		waitTime(driver);

		logger.info("Search for the Team :" + dataKeys.DSandAIPractice);
		grep.infoTest("Search for the Team :" + dataKeys.DSandAIPractice);
		waitTime(driver);
		csatTeam.insertValForSearchTeamAndUser(dataKeys.DSandAIPractice);
		csatTeam.getTeamName();
		csatTeam.getTeamCount();

		waitTime(driver);
		grep.captureScreenshot("pass", "Search Team name using search team and user field", "Search_DS_AI_Team");
		waitTime(driver);
		csatTeam.clickTeam();
		waitTime3(driver);
		csatTeam.getTeamNameInTeamDetailPage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Search Team name using search team and user field",
				"Search_DS_AI_In_TeamDetailPage");
		waitTime(driver);
		csatTeam.clickBackToTeamPage();
		waitTime(driver);

		logger.info("Search for the Team :" + dataKeys.ERP_Practice);
		grep.infoTest("Search for the Team :" + dataKeys.ERP_Practice);
		waitTime(driver);
		csatTeam.insertValForSearchTeamAndUser(dataKeys.ERP_Practice);
		csatTeam.getTeamName();
		csatTeam.getTeamCount();
		waitTime(driver);
		grep.captureScreenshot("pass", "Search Team name using search team and user field", "Search_ERP_Team");
		waitTime(driver);
		csatTeam.clickTeam();
		waitTime3(driver);
		csatTeam.getTeamNameInTeamDetailPage();
		waitTime(driver);
		grep.captureScreenshot("pass", "Search Team name using search team and user field",
				"Search_ERP_In_TeamDetailPage");
		waitTime(driver);
		csatTeam.clickBackToTeamPage();
		waitTime(driver);

		// Verify Search user using search team and user field
		grep.testCreate("Search User using search team and user field in Setting Teams Page",
				"Search User using search team and user field");
		waitTime(driver);

		logger.info("Search User using search team and user field in Setting Teams Page");
		grep.infoTest("Search User using search team and user field in Setting Teams Page");

		logger.info("Search for the User :" + dataKeys.customerContactEmail);
		grep.infoTest("Search for the User :" + dataKeys.customerContactEmail);
		waitTime(driver);
		csatTeam.insertValForSearchTeamAndUser(dataKeys.customerContactEmail);
		csatTeam.getTeamName();
		csatTeam.getTeamCount();
		waitTime(driver);
		csatTeam.clickTeam();
		waitTime3(driver);
		csatTeam.getTeamNameInTeamDetailPage();
		waitTime(driver);
		csatTeam.verifySearchRelatedMember(dataKeys.myProfileName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Search User using search team and user field", "Search_User_Team");
		waitTime(driver);
		csatTeam.clearSearchUser();
		waitTime(driver);

		// Verify team detail page header and team name and pagination

		grep.testCreate("Validating Team Detail Page Pagination in Setting Teams Page",
				"Validating Team Detail Page Pagination");
		waitTime(driver);

		logger.info("Validating Team Detail Page Pagination in Setting Teams Page");
		grep.infoTest("Validating Team Detail Page Pagination in Setting Teams Page");
		waitTime(driver);

		logger.info("Verify Team Detail Page Header");
		grep.infoTest("Verify Team Detail Page Header");
		csatTeam.teamDetail_HeaderValidation();
		waitTime(driver);

		logger.info("Selecting Pagination 5");
		grep.infoTest("Selecting Pagination 5");
		csatTeam.selectPagination("5");
		csatTeam.verifyPaginationSelectedOption("5");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 5", "Teams_Pagination_5");

		logger.info("Selecting Pagination 15");
		grep.infoTest("Selecting Pagination 15");
		csatTeam.selectPagination("15");
		csatTeam.verifyPaginationSelectedOption("15");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 15", "Teams_Pagination_15");

		logger.info("Selecting Pagination 10");
		grep.infoTest("Selecting Pagination 10");
		csatTeam.selectPagination("10");
		csatTeam.verifyPaginationSelectedOption("10");
		grep.captureScreenshot("pass", "Selecting Pagination 10", "Teams_Pagination_10");
		waitTime(driver);

		// DOWNLOAD FILE TEST
		grep.testCreate("Download File test for Teams Page", "Download File");
		waitTime(driver);
		logger.info("Download CSV File Format ");
		grep.infoTest("Download CSV File Format ");
		csatTeam.clickDownloadFileBtn(dataKeys.csvFormat);
		grep.captureScreenshot("pass", "Download CSV", "Teams_CSVFormat");
		waitTime5(driver);
		logger.info("Download PDF File Format ");
		grep.infoTest("Download PDF File Format ");
		csatTeam.clickDownloadFileBtn(dataKeys.pdfFormat);
		waitTime5(driver);
		grep.captureScreenshot("pass", "Download PDF", "Teams_PDFFormat");
		waitTime(driver);
		csatTeam.clickBackToTeamPage();

		// Verify Send invite without selecting role

		grep.testCreate("Validating the Send invite without selecting role in Teams Test",
				"Validating the Send invite without selecting role in Teams");
		waitTime(driver);
		logger.info("Validating the Send invite without selecting role in Teams Test");
		grep.infoTest("Validating the Send invite without selecting role in Teams Test");
		waitTime(driver);
		csatTeam.clickTeam();
		waitTime(driver);
		csatTeam.insertEmailToInvite(dataKeys.ssoUserName);
		waitTime(driver);
		csatTeam.clickSendInvite();
		csatTeam.existingUserErrorMessage();
		grep.captureScreenshot("pass", "Send invite without selecting role", "Sendinvite_WithoutRole_Team");
		waitTime2(driver);

		// Verify Existing User Entries for Teams Page
		grep.testCreate("Validating the existing user invite in Teams Test",
				"Validating the existing user invite in Teams");
		waitTime(driver);
		logger.info("Validating the existing user invite in Teams Test");
		grep.infoTest("Validating the existing user invite in Teams Test");
		waitTime(driver);
		csatTeam.clickSelectRoleDropDown();
		csatTeam.selectRoleToInvite(dataKeys.contributorRole);
		waitTime(driver);
		csatTeam.clickSendInvite();
		csatTeam.existingUserErrorMessage();
		grep.captureScreenshot("pass", "Inviting Existing User", "invite_ExistingUser_Team");
		waitTime2(driver);

		// Validating the Teams to send invite for user
		grep.testCreate("Validating the user invite in Teams Test", "Validating the user invite in Teams");
		waitTime(driver);
		logger.info("Validating the user invite in Teams Test");
		grep.infoTest("Validating the user invite in Teams Test");
		waitTime(driver);
		csatTeam.insertEmailToInvite(dataKeys.ssoUserNameDev);
		csatTeam.clickSelectRoleDropDown();
		csatTeam.selectRoleToInvite(dataKeys.adminRole);
		waitTime(driver);
		csatTeam.clickSendInvite();
		grep.captureScreenshot("pass", "Inviting User", "invite_User_Team");

		waitTime2(driver);

		// Search the User
		grep.testCreate("Validating the Search user in Teams Test", "Validating the Search User in Teams");

		waitTime(driver);
		logger.info("Validating the Search User in Team Test");
		grep.infoTest("Validating the Search User in Team Test");
		waitTime(driver);
		logger.info("Insert Search Value: " + dataKeys.userNameSearch_InTeam);
		grep.infoTest("Insert Search Value: " + dataKeys.userNameSearch_InTeam);
		csatTeam.insertValueToSearch(dataKeys.userNameSearch_InTeam);
		waitTime(driver);
		csatTeam.verifySearchRelatedMember(dataKeys.userNameSearch_InTeam);
		waitTime(driver);
		grep.captureScreenshot("pass", "Search User in Team", "Search_User_inTeam");
		waitTime2(driver);

		// Updating the role for specific user
		grep.testCreate("Update the role for user in Team Test", "Update the role for existing user");
		waitTime(driver);
		logger.info("Update the role for user in Team Test");
		grep.infoTest("Update the role for user in Team Test");
		waitTime(driver);
		csatTeam.beforeUpdateRoleForUser(dataKeys.userNameSearch_InTeam);
		waitTime(driver);
		grep.captureScreenshot("pass", "Before Updating the role for existing user", "Before_UpdatingRole_ForTeamUser");
		waitTime2(driver);
		logger.info("Updating Role for User: " + dataKeys.contributorRole);
		grep.infoTest("Updating Role for User: " + dataKeys.contributorRole);
		waitTime1(driver);
		csatTeam.updateRoleForUser(dataKeys.userNameSearch_InTeam, dataKeys.contributorRole);
		waitTime(driver);
		csatTeam.afterUpdateRoleForUser(dataKeys.userNameSearch_InTeam);
		waitTime(driver);
		grep.captureScreenshot("pass", "After Updating the role for existing user", "After_UpdatingRole_ForTeamUser");
		waitTime2(driver);
		csatTeam.updateRoleForUser(dataKeys.userNameSearch_InTeam, dataKeys.ReaderRole);

		waitTime1(driver);
		grep.testCreate("Logout from Application Test", "Logout from Application");
		waitTime3(driver);

		csatPage.clickLogout();
		String getUrlVal = getURL();
		if (getUrlVal.endsWith(dataKeys.login_Url)) {
			grep.passTest("Logged out Successfully");
			logger.info("Logged out Successfully");
		} else {
			grep.failTest("Log out Functionality failed");
			logger.info("Log out Functionality failed");
		}
		waitTime5(driver);
		grep.captureScreenshot("pass", "Logged out From Application", "logout_Test");

	}
}