package IntelliServe_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.IntelliServe_TestDataKeys;
import BaseClasses.IntelliServe_TestInitializer;
import IntelliServe_Pages.Ticketing_Admin_Page;
import IntelliServe_Pages.Ticketing_Approver_Member_Page;
import IntelliServe_Pages.Ticketing_Page;
import Utility.GenerateReports;

public class IntelliServe_Admin_Test extends IntelliServe_TestInitializer {

	private static final Logger logger = LogManager.getLogger(IntelliServe_Admin_Test.class);
	GenerateReports grep = new GenerateReports();
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();
	Ticketing_Page ticketpage;

	Ticketing_Admin_Page admin_Page;

	@Test(priority = 1)
	public void admin_AllTickets_Test() throws Exception {
		ticketpage = new Ticketing_Page();
		admin_Page = new Ticketing_Admin_Page();

		waitTime5(driver);
		grep.testCreate("Admin All Tickets Page Configure Columns Options Filters Test",
				"Admin All Tickets Page Configure Columns Options Filters");
		boolean role = ticketpage.verifyUserRole(dataKeys.admin_Role);

		if (role) {
			waitTime(driver);
			grep.infoTest("Admin All Tickets Page Configure Columns Options Filters Test");
			logger.info("Admin All Tickets Page Configure Columns Options Filters Test");
			waitTime(driver);
			ticketpage.selectUserRole(dataKeys.admin_Role);
			waitTime5(driver);
			ticketpage.navigateToPage(dataKeys.allTicketsPage);

			admin_Page.verifyAllTicketsHeader(dataKeys.allTicketsTitle);
			waitTime(driver);
			admin_Page.clickConfigColumnBtn();

			grep.infoTest("Verifying Ticket ID Column Option");
			logger.info("Verifying Ticket ID Column Option");
			verifyColumnOptionFunctionality("Ticket ID");
			grep.infoTest("Verifying Status Column Option");
			logger.info("Verifying Status Column Option");
			verifyColumnOptionFunctionality("Status");
			admin_Page.clickCloseConfigColumnBtn();
			waitTime(driver);

			admin_Page.clickConfigColumnBtn();
			admin_Page.selectViewColumnOption("Type");
			admin_Page.selectViewColumnOption("Current Stage");
			admin_Page.selectViewColumnOption("Priority");
			waitTime(driver);
//			appr_member_Page.clickCloseConfigColumnBtn();
			admin_Page.clickSavePref_ConfigColumnBtn();
			waitTime(driver);

			allTickets_FilterTest();
			waitTime(driver);

		} else {
			grep.warnTest("Approver Role Not Available for logged User");
			logger.info("Approver Role Not Available for logged User");
		}

	}

	public void allTickets_FilterTest() throws Exception {

		grep.testCreate("All Tickets Page Status Filter Test", "All Tickets Page Status Filters");
		waitTime(driver);
		grep.infoTest("All Tickets Page Status Filter Test");
		logger.info("All Tickets Page Status Filter Test");
		waitTime(driver);

		verifyAllTicketsStatusFilter(dataKeys.pending_StatusFilter);
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		verifyAllTicketsStatusFilter(dataKeys.rejected_StatusFilter);
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		verifyAllTicketsStatusFilter(dataKeys.resolved_StatusFilter);
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		verifyAllTicketsStatusFilter(dataKeys.closed_StatusFilter);
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("All Ticketst Page Priority Filter Test", "All Tickets Page Priority Filters");
		waitTime(driver);
		grep.infoTest("All Tickets Page Priority Filter Test");
		logger.info("All Tickets Page Priority Filter Test");
		waitTime(driver);

		verifyAllTicketsPriorityFilter(dataKeys.high_PriorityFilter);
		verifyAllTicketsPriorityFilter(dataKeys.low_PriorityFilter);
		verifyAllTicketsPriorityFilter(dataKeys.medium_PriorityFilter);
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("All Tickets Page Department Filter Test", "All Tickets Page Department Filters");
		waitTime(driver);
		grep.infoTest("All Tickets Page Department Filter Test");
		logger.info("All Tickets Page Department Filter Test");
		waitTime(driver);

		verifyAllTicketsDepartmentFilter(dataKeys.btg_DepartmentFilter);
		verifyAllTicketsDepartmentFilter(dataKeys.dsil_DepartmentFilter);
		verifyAllTicketsDepartmentFilter(dataKeys.dsa_DepartmentFilter);
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("All Tickets Search Functionality Test", "All Tickets Search Functionality");
		waitTime(driver);
		grep.infoTest("All Tickets Search Functionality Test");
		logger.info("All Tickets Search Functionality Test");
		waitTime(driver);
		admin_Page.insertSearchFilter(dataKeys.userName);
		waitTime(driver);
		admin_Page.verifyAllTickets_FilterInTable(dataKeys.userName);
		grep.captureScreenshot("pass", " All Tickets Search Filter", "SearchFilter_AllTickets");
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("All Tickets Search Non existing Functionality Test",
				"All Tickets Search Non existing  Functionality");
		waitTime(driver);
		grep.infoTest("All Tickets Search Non existing  Functionality Test");
		logger.info("All Tickets Search Non existing  Functionality Test");
		waitTime(driver);
		admin_Page.insertSearchFilter("W%^&*(");
		waitTime(driver);
		admin_Page.noRecordsMsg_InAllTickets();
		grep.captureScreenshot("pass", " All Tickets Search Non existing  Filter",
				"NonExisting_SearchFilter_AllTickets");
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

	}

	public void verifyAllTicketsStatusFilter(String option) throws Exception {
		grep.infoTest("All Tickets Page " + option + " Status Filter Test");
		logger.info("All Tickets Page " + option + " Status Filter Test");
		waitTime(driver);
		admin_Page.expandStatusFilter();
		waitTime(driver);
		admin_Page.selectStatusFilter(option);
		waitTime(driver);
		admin_Page.collapseStatusFilter();
		waitTime(driver);
		admin_Page.verifyAllTickets_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Status Filter", option + "StatusFilter_AllTickets");

	}

//	public void verifyWorklistMultiStatusFilter(String... option) throws Exception {
//		grep.infoTest("All Tickets Page " + option + " Status Filter Test");
//		logger.info("All Tickets Page " + option + " Status Filter Test");
//		waitTime(driver);
//		appr_member_Page.expandStatusFilter();
//		waitTime(driver);
//		appr_member_Page.selectStatusFilter(dataKeys.selectAllSatusFilter);
//		appr_member_Page.selectStatusFilter(dataKeys.selectAllSatusFilter);
//		waitTime(driver);
//		appr_member_Page.selectMultiStatusFilter(option);
//		waitTime(driver);
//		appr_member_Page.collapseStatusFilter();
//		waitTime(driver);
//		appr_member_Page.verifyWorklist_MultiFilterInTable(option);
//		grep.captureScreenshot("pass", option + " Status Filter", option + "StatusFilter_Worklist");
//
//	}

	public void verifyAllTicketsPriorityFilter(String option) throws Exception {
		grep.infoTest("All Tickets Page " + option + " Priority Filter Test");
		logger.info("All Tickets Page " + option + " Priority Filter Test");
		waitTime(driver);
		admin_Page.selectFilter(dataKeys.priorityFilter, option);
		waitTime(driver);
		admin_Page.verifyAllTickets_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Priority Filter", option + "PriorityFilter_AllTickets");

	}

	public void verifyAllTicketsDepartmentFilter(String option) throws Exception {
		grep.infoTest("All Tickets Page " + option + " Department Filter Test");
		logger.info("All Tickets Page " + option + " Department Filter Test");
		waitTime(driver);
		admin_Page.selectFilter(dataKeys.departmentFilter, option);
		waitTime(driver);
		admin_Page.verifyAllTickets_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Department Filter", option + "DepartmentFilter_AllTickets");

	}

	public void verifyColumnOptionFunctionality(String option) throws Exception {

		admin_Page.selectHideColumnOption(option);
		admin_Page.verifyColumnOptionVisibilityHidden(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is Hide ", option + "Hide");
		waitTime(driver);
		admin_Page.selectViewColumnOption(option);
		admin_Page.verifyColumnOptionVisibilityView(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is View ", option + "View");
		waitTime(driver);
	}

}