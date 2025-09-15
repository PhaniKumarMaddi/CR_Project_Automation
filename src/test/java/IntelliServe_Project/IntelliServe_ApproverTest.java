package IntelliServe_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.IntelliServe_TestDataKeys;
import BaseClasses.IntelliServe_TestInitializer;
import IntelliServe_Pages.Ticketing_Approver_Member_Page;
import IntelliServe_Pages.Ticketing_Page;
import Utility.GenerateReports;

public class IntelliServe_ApproverTest extends IntelliServe_TestInitializer {

	private static final Logger logger = LogManager.getLogger(IntelliServe_ApproverTest.class);
	GenerateReports grep = new GenerateReports();
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();
	Ticketing_Page ticketpage;

	Ticketing_Approver_Member_Page appr_member_Page;

	@Test(priority = 1)
	public void approverWorkList_Test() throws Exception {
		ticketpage = new Ticketing_Page();
		appr_member_Page = new Ticketing_Approver_Member_Page();

		grep.testCreate("Approver Worklist Page Configure Columns Options Filters Test",
				"Approver Worklist Page Configure Columns Options Filters");
		boolean it_approver = ticketpage.verifyUserRole(dataKeys.itApprover_Role);
		if (it_approver) {
			grep.infoTest("Approver Worklist Page Configure Columns Options Filters");
			logger.info("Approver Worklist Page Configure Columns Options Filters");
			waitTime(driver);

			ticketpage.navigateToPage(dataKeys.approverWorklistPage);
			waitTime(driver);
			appr_member_Page.verifyApproverWorkListHeader();
			waitTime5(driver);
			appr_member_Page.clickConfigColumnBtn();

			grep.infoTest("Verifying Ticket ID Column Option");
			logger.info("Verifying Ticket ID Column Option");
			verifyColumnOptionFunctionality("Ticket ID");
			grep.infoTest("Verifying Status Column Option");
			logger.info("Verifying Status Column Option");
			verifyColumnOptionFunctionality("Status");
			appr_member_Page.clickCloseConfigColumnBtn();
			waitTime(driver);

			appr_member_Page.clickConfigColumnBtn();
			appr_member_Page.selectColumnOption("Type");
			appr_member_Page.selectColumnOption("Current Stage");
			waitTime(driver);
			appr_member_Page.clickCloseConfigColumnBtn();
			waitTime(driver);

			grep.testCreate("Approver Worklist Refresh Button Test", "Approver Worklist Refresh Button");
			waitTime(driver);
			grep.infoTest("Approver Worklist Refresh Button Test");
			logger.info("Approver Worklist Refresh Button Test");
			waitTime(driver);

			appr_member_Page.clickRefreshBtn();
			waitTime(driver);
			appr_member_Page.getRefreshMessgae();
			waitTime(driver);
			grep.captureScreenshot("pass", "Refresh button Test", "refresh_WorklistPage");

			approverWorklist_Filter_Test();
			waitTime(driver);
			approveMyTickets_Filter_Test();

		} else {
			grep.warnTest("Approver Role Not Available for logged User");
			logger.info("Approver Role Not Available for logged User");
		}

	}

	public void approverWorklist_Filter_Test() throws Exception {

		grep.testCreate("Approver Worklist Page Status Filter Test", "Approver Worklist Page Status Filters");
		waitTime(driver);
		grep.infoTest("Approver Worklist Page Status Filter Test");
		logger.info("Approver Worklist Page Status Filter Test");
		waitTime(driver);

		verifyWorklistStatusFilter(dataKeys.pending_StatusFilter);
		verifyWorklistStatusFilter(dataKeys.rejected_StatusFilter);
		verifyWorklistStatusFilter(dataKeys.resolved_StatusFilter);
		verifyWorklistStatusFilter(dataKeys.closed_StatusFilter);
		waitTime(driver);
		appr_member_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Approver Worklist Page Priority Filter Test", "Approver Worklist Page Priority Filters");
		waitTime(driver);
		grep.infoTest("Approver Worklist Page Priority Filter Test");
		logger.info("Approver Worklist Page Priority Filter Test");
		waitTime(driver);

		verifyWorklistPriorityFilter(dataKeys.high_PriorityFilter);
		verifyWorklistPriorityFilter(dataKeys.low_PriorityFilter);
		verifyWorklistPriorityFilter(dataKeys.medium_PriorityFilter);
		waitTime(driver);
		appr_member_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Approver Worklist Page Department Filter Test", "Approver Worklist Page Department Filters");
		waitTime(driver);
		grep.infoTest("Approver Worklist Page Department Filter Test");
		logger.info("Approver Worklist Page Department Filter Test");
		waitTime(driver);

		verifyWorklistDepartmentFilter(dataKeys.btg_DepartmentFilter);
		verifyWorklistDepartmentFilter(dataKeys.dsil_DepartmentFilter);
		verifyWorklistDepartmentFilter(dataKeys.dsa_DepartmentFilter);
		waitTime(driver);
		appr_member_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Approver Worklist Page Stages Filter Test", "Approver Worklist Page Stages Filters");
		waitTime(driver);
		grep.infoTest("Approver Worklist Page Stages Filter Test");
		logger.info("Approver Worklist Page Stages Filter Test");
		waitTime(driver);

		verifyWorklistStagesFilter(dataKeys.dept_Approver_Role);
		verifyWorklistStagesFilter(dataKeys.btgApprover_Role);
		verifyWorklistStagesFilter(dataKeys.itApprover_Role);
		waitTime(driver);
		appr_member_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Approver Worklist Search Functionality Test", "Approver Worklist Search Functionality");
		waitTime(driver);
		grep.infoTest("Approver Worklist Search Functionality Test");
		logger.info("Approver Worklist Search Functionality Test");
		waitTime(driver);
		appr_member_Page.insertSearchFilter(dataKeys.userName);
		waitTime(driver);
		appr_member_Page.verifyWorklist_FilterInTable(dataKeys.userName);
		grep.captureScreenshot("pass", " Worklist Search Filter", "SearchFilter_Worklist");
		waitTime(driver);
		appr_member_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Approver Worklist Search Non existing Functionality Test",
				"Approver Worklist Search Non existing  Functionality");
		waitTime(driver);
		grep.infoTest("Approver Worklist Search Non existing  Functionality Test");
		logger.info("Approver Worklist Search Non existing  Functionality Test");
		waitTime(driver);
		appr_member_Page.insertSearchFilter(dataKeys.ssoUserName);
		waitTime(driver);
		appr_member_Page.noRecordsMsg_InWorklist();
		grep.captureScreenshot("pass", " Worklist Search Non existing  Filter", "NonExisting_SearchFilter_Worklist");
		waitTime(driver);
		appr_member_Page.clickClearFilterBtn();
		waitTime(driver);

	}

	public void approveMyTickets_Filter_Test() throws Exception {
		ticketpage.navigateToPage(dataKeys.myTicketPage);
		waitTime5(driver);
		appr_member_Page.clickConfigColumnBtn();
		appr_member_Page.selectColumnOption("Department");
		appr_member_Page.selectColumnOption("Manager");
		appr_member_Page.selectColumnOption("Priority");
		waitTime(driver);
		appr_member_Page.clickCloseConfigColumnBtn();
		waitTime(driver);

		grep.testCreate("My Tickets Page Priority Filter Test", "My Tickets Page Priority Filters");
		waitTime(driver);
		grep.infoTest("My Tickets Page Priority Filter Test");
		logger.info("My Tickets Page Priority Filter Test");
		waitTime(driver);

		verifyMyTicketsPriorityFilter(dataKeys.high_PriorityFilter);
		verifyMyTicketsPriorityFilter(dataKeys.low_PriorityFilter);
		verifyMyTicketsPriorityFilter(dataKeys.medium_PriorityFilter);
		appr_member_Page.selectFilter(dataKeys.priorityFilter, "All Priority");
		waitTime3(driver);

		grep.testCreate("My Tickets Page Current Stages Filter Test", "My Tickets Page Stages Filters");
		waitTime(driver);
		grep.infoTest("My Tickets Page Current Stages Filter Test");
		logger.info("My Tickets Page Current Stages Filter Test");
		waitTime(driver);

		verifyMyTicketsStageFilter(dataKeys.dept_Approver_Role);
		verifyMyTicketsStageFilter(dataKeys.btgApprover_Role);
		verifyMyTicketsStageFilter(dataKeys.itApprover_Role);
		appr_member_Page.selectFilter(dataKeys.currentStage, "All Stages");
		waitTime2(driver);

		grep.testCreate("My Tickets Search Functionality Test", "My Tickets Search Functionality");
		waitTime(driver);
		grep.infoTest("My Tickets Search Functionality Test");
		logger.info("My Tickets Search Functionality Test");
		waitTime(driver);
		appr_member_Page.insertSearchFilter(dataKeys.itApprover_Role);
		waitTime(driver);
		appr_member_Page.verifyMyTickets_FilterInTable(dataKeys.userName);
		grep.captureScreenshot("pass", " My Tickets Search Filter", "SearchFilter_MyTickets");
		waitTime(driver);

		grep.testCreate("My Tickets Search Non existing Functionality Test",
				"My Tickets Search Non existing  Functionality");
		waitTime(driver);
		grep.infoTest("My Tickets Search Non existing  Functionality Test");
		logger.info("My Tickets Search Non existing  Functionality Test");
		waitTime(driver);
		appr_member_Page.insertSearchFilter("$%^&");
		waitTime(driver);
		appr_member_Page.noRecordsMsg_MyTickets();
		grep.captureScreenshot("pass", " My Tickets Search Non existing  Filter", "NonExisting_SearchFilter_MyTickets");
		waitTime3(driver);

	}

	public void verifyWorklistStatusFilter(String option) throws Exception {
		grep.infoTest("Approver Worklist Page " + option + " Status Filter Test");
		logger.info("Approver Worklist Page " + option + " Status Filter Test");
		waitTime(driver);
		appr_member_Page.selectFilter(dataKeys.statusFilter, option);
		waitTime(driver);
		appr_member_Page.verifyWorklist_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Status Filter", option + "StatusFilter_Worklist");

	}

	public void verifyWorklistPriorityFilter(String option) throws Exception {
		grep.infoTest("Approver Worklist Page " + option + " Priority Filter Test");
		logger.info("Approver Worklist Page " + option + " Priority Filter Test");
		waitTime(driver);
		appr_member_Page.selectFilter(dataKeys.priorityFilter, option);
		waitTime(driver);
		appr_member_Page.verifyWorklist_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Priority Filter", option + "PriorityFilter_Worklist");

	}

	public void verifyWorklistDepartmentFilter(String option) throws Exception {
		grep.infoTest("Approver Worklist Page " + option + " Department Filter Test");
		logger.info("Approver Worklist Page " + option + " Department Filter Test");
		waitTime(driver);
		appr_member_Page.selectFilter(dataKeys.departmentFilter, option);
		waitTime(driver);
		appr_member_Page.verifyWorklist_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Department Filter", option + "DepartmentFilter_Worklist");

	}

	public void verifyWorklistStagesFilter(String option) throws Exception {
		grep.infoTest("Approver Worklist Page " + option + " Stages Filter Test");
		logger.info("Approver Worklist Page " + option + " Stages Filter Test");
		waitTime(driver);
		appr_member_Page.selectFilter(dataKeys.stageFilter, option);
		waitTime(driver);
		appr_member_Page.verifyWorklist_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Stages Filter", option + "StagesFilter_Worklist");

	}

	public void verifyMyTicketsPriorityFilter(String option) throws Exception {
		grep.infoTest("My Tickets Page " + option + " Priority Filter Test");
		logger.info("My Tickets Page " + option + " Priority Filter Test");
		waitTime(driver);
		appr_member_Page.selectFilter(dataKeys.priorityFilter, option);
		waitTime(driver);
		appr_member_Page.verifyMyTickets_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Priority Filter", option + "PriorityFilter_MyTickets");

	}

	public void verifyMyTicketsStageFilter(String option) throws Exception {
		grep.infoTest("My Tickets Page " + option + " Stages Filter Test");
		logger.info("My Tickets Page " + option + " Stages Filter Test");
		waitTime(driver);
		appr_member_Page.selectFilter(dataKeys.currentStage, option);
		waitTime(driver);
		appr_member_Page.verifyMyTickets_FilterInTable(option);
		grep.captureScreenshot("pass", option + " Stages Filter", option + "StagesFilter_MyTickets");

	}

	public void verifyColumnOptionFunctionality(String option) throws Exception {

		appr_member_Page.selectColumnOption(option);
		appr_member_Page.verifyColumnOptionVisibilityHidden(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is Hide ", option + "Hide");
		waitTime(driver);
		appr_member_Page.selectColumnOption(option);
		appr_member_Page.verifyColumnOptionVisibilityView(option);
		waitTime(driver);
		grep.captureScreenshot("pass", option + " visibility is View ", option + "View");
		waitTime(driver);
	}
}