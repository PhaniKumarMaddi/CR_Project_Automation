package IntelliServe_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.IntelliServe_TestDataKeys;
import BaseClasses.IntelliServe_TestInitializer;
import IntelliServe_Pages.Ticketing_Page;
import L_And_D_Pages.L_And_D_Page;
import Utility.GenerateReports;

public class IntelliServe_Page_UI_Test extends IntelliServe_TestInitializer {

	private static final Logger logger = LogManager.getLogger(IntelliServe_Page_UI_Test.class);
	GenerateReports grep = new GenerateReports();
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();
	Ticketing_Page ticketpage;

	@Test(priority = 1)
	public void IntelliServe__UI_Test() throws Exception {
		ticketpage = new Ticketing_Page();

		grep.testCreate("Verify the Home and Profile Page test", "Verify the Home and Profile Page");
		grep.infoTest("Verify the Home and Profile Page test");
		logger.info("Verify the Home and Profile Page test");

		waitTime(driver);
		ticketpage.clickProfilePage(dataKeys.userName, dataKeys.ssoUserName);
		waitTime(driver);
		ticketpage.getProfilePageInfo();
		waitTime(driver);
		ticketpage.getFooterInfo();
		grep.captureScreenshot("pass", "Profile Page Test", "ticketing_ProfilePage");
		waitTime2(driver);

	}

	@Test(priority = 2)
	public void verifyRoleBasedPages() throws Exception {
		waitTime2(driver);
		grep.testCreate("Verify the Admin Role Pages test", "Verify the Admin Role Pages");
		boolean role = ticketpage.verifyUserRole(dataKeys.admin_Role);

		if (role) {
			grep.infoTest("Verify the Admin Role Pages");
			logger.info("Verify the Admin Role Pages");
			waitTime(driver);
			ticketpage.selectUserRole(dataKeys.admin_Role);
			waitTime(driver);

			grep.infoTest("Navigating To Admin Dashboard Page");
			navigateToAllPages(dataKeys.adminDashboardPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Admin Dashboard Page for Admin role", "admin_dashboard_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To All Tickets Page");
			navigateToAllPages(dataKeys.allTicketsPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside All Tickets Page for Admin role", "admin_allTickets_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To Approver Management Page");
			navigateToAllPages(dataKeys.approverMgmtPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Approver Management Page for Admin role", "admin_approverMgmt_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To Roles Page");
			navigateToAllPages(dataKeys.rolesPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Roles Page for Admin role", "admin_roles_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To My Tickets Page");
			navigateToAllPages(dataKeys.myTicketPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside My Tickets Page for Admin role", "admin_myTickets_Page");
			waitTime3(driver);

		} else {
			grep.warnTest("Admin Role Not Available for logged User");
			logger.info("Admin Role Not Available for logged User");
		}
		waitTime5(driver);

		grep.testCreate("Verify the IT Approver Role Pages test", "Verify the Approver Role Pages");
		boolean it_approver = ticketpage.verifyUserRole(dataKeys.itApprover_Role);

		if (it_approver) {
			grep.infoTest("Verify the IT Approver Role Pages");
			logger.info("Verify the IT Approver Role Pages");
			waitTime(driver);
			ticketpage.selectUserRole(dataKeys.itApprover_Role);
			waitTime(driver);

			grep.infoTest("Navigating To Approver Dashboard Page");
			navigateToAllPages(dataKeys.approverDashboardPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Approver Dashboard Page for Approver role",
					"it_approver_DashboardPage");
			waitTime3(driver);

			grep.infoTest("Navigating To Approver Worklist Page");
			navigateToAllPages(dataKeys.approverWorklistPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Approver Worklist Page for Approver role",
					"it_Approver_Worklist_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To My Tickets Page");
			navigateToAllPages(dataKeys.myTicketPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside My Tickets Page for Approver role", "it_Approver_myTickets_Page");
			waitTime3(driver);

		} else {
			grep.warnTest("IT Approver Role Not Available for logged User");
			logger.info("IT Approver Role Not Available for logged User");
		}
		waitTime5(driver);

		grep.testCreate("Verify the IT Member Role Pages test", "Verify the Member Role Pages");
		boolean it_member = ticketpage.verifyUserRole(dataKeys.itMember_Role);

		if (it_member) {
			grep.infoTest("Verify the IT Member Role Pages");
			logger.info("Verify the IT Member Role Pages");
			waitTime(driver);
			ticketpage.selectUserRole(dataKeys.itMember_Role);
			waitTime(driver);

			grep.infoTest("Navigating To Implementation Queue Page");
			navigateToAllPages(dataKeys.implementationQueuePage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Implementation Queue Page for Member role",
					"it_member_ImplementationQueue_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To My Tickets Page");
			navigateToAllPages(dataKeys.myTicketPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside My Tickets Page for Member role", "it_Member_myTickets_Page");
			waitTime3(driver);

		} else {
			grep.warnTest("IT Member Role Not Available for logged User");
			logger.info("IT Approver Role Not Available for logged User");
		}
		waitTime5(driver);

		grep.testCreate("Verify the BTG Approver Role Pages test", "Verify the Approver Role Pages");
		boolean btg_approver = ticketpage.verifyUserRole(dataKeys.btgApprover_Role);

		if (btg_approver) {
			grep.infoTest("Verify the BTG Approver Role Pages");
			logger.info("Verify the BTG Approver Role Pages");
			waitTime(driver);
			ticketpage.selectUserRole(dataKeys.btgApprover_Role);
			waitTime(driver);

			grep.infoTest("Navigating To Approver Dashboard Page");
			navigateToAllPages(dataKeys.approverDashboardPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Approver Dashboard Page for Approver role",
					"btg_approver_DashboardPage");
			waitTime3(driver);

			grep.infoTest("Navigating To Approver Worklist Page");
			navigateToAllPages(dataKeys.approverWorklistPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Approver Worklist Page for Approver role",
					"btg_Approver_Worklist_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To My Tickets Page");
			navigateToAllPages(dataKeys.myTicketPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside My Tickets Page for Approver role", "btg_Approver_myTickets_Page");
			waitTime3(driver);

		} else {
			grep.warnTest("BTG Approver Role Not Available for logged User");
			logger.info("BTG Approver Role Not Available for logged User");
		}
		waitTime5(driver);

		grep.testCreate("Verify the BTG Member Role Pages test", "Verify the Member Role Pages");
		boolean btg_member = ticketpage.verifyUserRole(dataKeys.btgMember_Role);

		if (btg_member) {
			grep.infoTest("Verify the BTG Member Role Pages");
			logger.info("Verify the BTG Member Role Pages");
			waitTime(driver);
			ticketpage.selectUserRole(dataKeys.btgMember_Role);
			waitTime(driver);

			grep.infoTest("Navigating To Implementation Queue Page");
			navigateToAllPages(dataKeys.implementationQueuePage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside Implementation Queue Page for Member role",
					"btg_member_ImplementationQueue_Page");
			waitTime3(driver);

			grep.infoTest("Navigating To My Tickets Page");
			navigateToAllPages(dataKeys.myTicketPage);
			waitTime3(driver);
			grep.captureScreenshot("pass", "Inside My Tickets Page for Member role", "btg_Member_myTickets_Page");
			waitTime3(driver);

		} else {
			grep.warnTest("BTG Member Role Not Available for logged User");
			logger.info("BTG Member Role Not Available for logged User");
		}
		waitTime5(driver);
	}

	@Test(priority = 3)
	public void IntelliServe__Signout_Test() throws Exception {
//		ticketpage = new Ticketing_Page();

		grep.testCreate("Verify the Signout functionality test", "Verify the Signout");
		grep.infoTest("Verify the Signout");
		logger.info("Verify the Signout");

		waitTime(driver);
		ticketpage.clickSignOutBtn();
		waitTime10(driver);
		String getUrlVal = getURL();
		if (getUrlVal.endsWith(dataKeys.login_Url)) {
			grep.passTest("Logged out Successfully");
			logger.info("Logged out Successfully");
		} else {
			grep.failTest("Signout Functionality failed");
			logger.info("Signout Functionality failed");
		}
		waitTime5(driver);
		grep.captureScreenshot("pass", "Signout from Application Test", "ticketing_signOut");

	}

	public void navigateToAllPages(String pageNameValue) throws Exception {

		waitTime(driver);
		ticketpage.navigateToPage(pageNameValue);
		waitTime5(driver);
		logger.info("Inside " + pageNameValue + " Page ");
		grep.infoTest("Inside " + pageNameValue + " Page ");
		validateUrl(pageNameValue);
		waitTime(driver);

	}

	public void validateUrl(String urlValue) throws Exception {
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(urlValue)) {
			grep.passTest(urlValue + " Url is Valid :" + getUrl);
			logger.info(urlValue + " Url is Valid :" + getUrl);
			waitTime(driver);
			waitTime(driver);
		} else {
			grep.warnTest(urlValue + " Url is InValid :" + getUrl);
			logger.error(urlValue + " Url is InValid :" + getUrl);
			waitTime(driver);
		}

	}

}