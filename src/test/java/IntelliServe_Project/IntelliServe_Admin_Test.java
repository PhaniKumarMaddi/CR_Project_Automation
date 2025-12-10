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
import Utility.ValidatingAssertions;

public class IntelliServe_Admin_Test extends IntelliServe_TestInitializer {

	private static final Logger logger = LogManager.getLogger(IntelliServe_Admin_Test.class);
	GenerateReports grep = new GenerateReports();
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();
	Ticketing_Page ticketpage;
	ValidatingAssertions validAssert = new ValidatingAssertions();

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
			admin_Page.clickSavePref_ConfigColumnBtn();
			waitTime(driver);

//			allTickets_FilterTest();
//			waitTime(driver);
//			adminDashboarOverviewTest();
//			waitTime2(driver);
//			adminDashboarOverviewSLATest();

			adminApproverManagementTest();
			adminRolesManagementTest();

		} else {
			grep.warnTest("Admin Role Not Available for logged User");
			logger.info("Admin Role Not Available for logged User");
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
		admin_Page.noRecordsMsg_InAdmin();
		grep.captureScreenshot("pass", " All Tickets Search Non existing  Filter",
				"NonExisting_SearchFilter_AllTickets");
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("All Tickets Export and Pagination Functionality Test",
				"All Tickets Export and Pagination Functionality");
		waitTime(driver);
		grep.infoTest("All Tickets Export and Pagination Functionality Test");
		logger.info("All Tickets Export and Pagination Functionality Test");
		waitTime(driver);
		admin_Page.allTicketsExport("CSV");
		admin_Page.allTicketsExport("PDF");
		waitTime(driver);

		admin_Page.selectAllTicketsPagination("20");
		grep.captureScreenshot("pass", " All Tickets Pagination 20", "AllTickets_20Pagination");

		admin_Page.selectAllTicketsPagination("50");
		grep.captureScreenshot("pass", " All Tickets Pagination 50", "AllTickets_50Pagination");
		admin_Page.selectAllTicketsPagination("70");
		grep.captureScreenshot("pass", " All Tickets Pagination 70", "AllTickets_70Pagination");
		admin_Page.selectAllTicketsPagination("10");
		waitTime(driver);
	}

	public void adminDashboarOverviewTest() throws Exception {

		ticketpage.navigateToPage(dataKeys.adminDashboardPage);
		waitTime5(driver);

		grep.testCreate("Admin Dashboard Overview Test", "Admin Dashboard Overview");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Overview Test");
		logger.info("Admin Dashboard Overview Test");
		waitTime(driver);
		admin_Page.selectAdminDashboard(dataKeys.adminDashboardOverview);
		waitTime(driver);
		grep.infoTest("Dashboard Overview Page Cards test");
		logger.info("Dashboard Overview Page Cards test");
		waitTime(driver);
		admin_Page.dashboardOverview_Card_Details();
		waitTime(driver);
		grep.infoTest("Dashboard Overview Page Chart Title test");
		logger.info("Dashboard Overview Page Chart Title test");
		waitTime(driver);
		admin_Page.dashboardOverview_Charts_Details();
		waitTime(driver);

		grep.captureScreenshot("pass", "Admin Dashboard Overview Test", "adminDashboardOverviewPage");

		grep.testCreate("Admin Dashboard Overview Cards Test", "Admin Dashboard Overview Cards");

		waitTime(driver);
		grep.infoTest("Admin Dashboard Overview Cards Test Total Ticket");
		logger.info("Admin Dashboard Overview Cards Test for Total Ticket");
		waitTime(driver);

		admin_Page.verifyCardsCountInPopup(dataKeys.totalTickets_Card);
		waitTime(driver);
		admin_Page.verifyCardPopupHeader(dataKeys.allTicketsTitle);
		waitTime(driver);

		grep.captureScreenshot("pass", "Admin Dashboard Total Tickets Test", "adminDashboardTotalTicketsPopup");
		waitTime(driver);
		admin_Page.selectDeptInPopup(dataKeys.btg_DepartmentFilter);
		waitTime(driver);
		admin_Page.verifyDeptInPopupTable(dataKeys.btg_DepartmentFilter);
		waitTime(driver);
		admin_Page.selectDeptInPopup(dataKeys.allDepartmentsFilter);
		waitTime(driver);
		admin_Page.exportInCardPopup("CSV");
		waitTime(driver);
		admin_Page.exportInCardPopup("PDF");
		waitTime(driver);

		admin_Page.clickConfigColumnBtn_InCardPopup();
		admin_Page.selectColumnOption_InCardPopups(dataKeys.ticketId_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.manager_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.ticketId_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.manager_InDetailPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Dashboard Total Tickets Popup Column Configure Test",
				"TotalTicketsPopup_ColumnOptions");
		waitTime(driver);
		admin_Page.clickCloseConfigColumnBtn_InCardPopup();
		waitTime(driver);
		admin_Page.clickCloseCardPopupBtn();
		waitTime5(driver);

		waitTime(driver);
		grep.infoTest("Admin Dashboard Overview Cards Test Resolved Ticket");
		logger.info("Admin Dashboard Overview Cards Test for Resolved Ticket");
		waitTime(driver);

		admin_Page.verifyCardsCountInPopup(dataKeys.resolved_Card);
		waitTime(driver);
		admin_Page.verifyCardPopupHeader(dataKeys.resolved_Card);
		waitTime(driver);

		grep.captureScreenshot("pass", "Admin Dashboard Resolved Tickets Test", "adminDashboardResolvedTicketsPopup");

		waitTime2(driver);
		admin_Page.exportInCardPopup("CSV");
		waitTime(driver);
		admin_Page.exportInCardPopup("PDF");
		waitTime(driver);

		admin_Page.clickConfigColumnBtn_InCardPopup();
		admin_Page.selectColumnOption_InCardPopups(dataKeys.ticketId_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.manager_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.ticketId_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.manager_InDetailPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Dashboard Resolved Tickets Popup Column Configure Test",
				"ResolvedTicketsPopup_ColumnOptions");
		waitTime(driver);
		admin_Page.clickCloseConfigColumnBtn_InCardPopup();
		waitTime(driver);
		admin_Page.clickCloseCardPopupBtn();
		waitTime5(driver);

		waitTime(driver);
		grep.infoTest("Admin Dashboard Overview Cards Test Sla Breached Ticket");
		logger.info("Admin Dashboard Overview Cards Test for Sla Breached Ticket");
		waitTime(driver);

		admin_Page.verifyCardsCountInPopup(dataKeys.slaBreached_Card);
		waitTime(driver);
		admin_Page.verifyCardPopupHeader(dataKeys.slaBreached_Card);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Dashboard Sla Breached Tickets Test",
				"adminDashboardBreachedTicketsPopup");

		waitTime(driver);
		admin_Page.exportInCardPopup("CSV");
		waitTime(driver);
		admin_Page.exportInCardPopup("PDF");
		waitTime(driver);

		admin_Page.clickConfigColumnBtn_InCardPopup();
		admin_Page.selectColumnOption_InCardPopups(dataKeys.ticketId_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.manager_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.ticketId_InDetailPopup);
		admin_Page.selectColumnOption_InCardPopups(dataKeys.manager_InDetailPopup);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Dashboard Breached Tickets Popup Column Configure Test",
				"BreachedTicketsPopup_ColumnOptions");
		waitTime(driver);
		admin_Page.clickCloseConfigColumnBtn_InCardPopup();
		waitTime5(driver);
		admin_Page.clickCloseCardPopupBtn();
		waitTime5(driver);

	}

	public void adminDashboarOverviewSLATest() throws Exception {

		waitTime(driver);
		grep.testCreate("Admin Dashboard Search for non existing for SLA Resolution Table Test",
				"Admin Dashboard Search SLA Resolution");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Search for non existing for SLA Resolution Table Test");
		logger.info("Admin Dashboard Search for non existing for SLA Resolution Table Test");
		waitTime(driver);

		admin_Page.searchSla(dataKeys.slaResolution, "$%^&");
		admin_Page.noRecordsMsg_SLA();
		waitTime(driver);
		grep.captureScreenshot("pass", "Search for non existing for SLA Resolution Table",
				"SLA_Resolution_NonExistingSearch");

		waitTime(driver);

		grep.testCreate("Admin Dashboard Exporting with no data for SLA Resolution Table Test",
				"Admin Dashboard Exporting with no data SLA Resolution");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Exporting with no data for SLA Resolution Table Test");
		logger.info("Admin Dashboard Exporting with no data for SLA Resolution Table Test");
		waitTime(driver);
		admin_Page.clickSlaExportAndChoose(dataKeys.slaResolution, "CSV");

		admin_Page.getNoDataToExportMsg();
		grep.captureScreenshot("pass", "Exporting with no data for SLA Resolution Table",
				"SLA_Resolution_ExportingWithNoData");
		waitTime(driver);
		admin_Page.clearSlaSearch(dataKeys.slaResolution);
		admin_Page.clearSlaSearch(dataKeys.slaResolution);

		waitTime(driver);

		grep.testCreate("Admin Dashboard Exporting data for SLA Resolution Table Test",
				"Admin Dashboard Exporting data SLA Resolution");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Exporting data for SLA Resolution Table Test");
		logger.info("Admin Dashboard Exporting data for SLA Resolution Table Test");
		waitTime(driver);
		admin_Page.clickSlaExportAndChoose(dataKeys.slaResolution, "CSV");

		grep.infoTest("Admin Dashboard Exporting data to CSV for SLA Resolution Table Test");
		logger.info("Admin Dashboard Exporting data to CSV for SLA Resolution Table Test");

		grep.captureScreenshot("pass", "Exporting CSV data for SLA Resolution Table",
				"SLA_Resolution_ExportingWithCSV");

		waitTime(driver);
		admin_Page.clickSlaExportAndChoose(dataKeys.slaResolution, "PDF");

		grep.infoTest("Admin Dashboard Exporting data to PDF for SLA Resolution Table Test");
		logger.info("Admin Dashboard Exporting data to PDF for SLA Resolution Table Test");

		grep.captureScreenshot("pass", "Exporting PDF data for SLA Resolution Table",
				"SLA_Resolution_ExportingWithPDF");

		grep.testCreate("Admin Dashboard Pagination for SLA Resolution Table Test",
				"Admin Dashboard Pagination for SLA Resolution");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Pagination for SLA Resolution Table Test");
		logger.info("Admin Dashboard Pagination for SLA Resolution Table Test");

		admin_Page.selectSLAPagination(dataKeys.slaResolution, "20");
		grep.captureScreenshot("pass", " SLA Resolution Pagination 20", "SLA_Resolution_20Pagination");
		admin_Page.selectSLAPagination(dataKeys.slaResolution, "50");
		grep.captureScreenshot("pass", "SLA Resolution Pagination 50", "SLA_Resolution_50Pagination");
		admin_Page.selectSLAPagination(dataKeys.slaResolution, "10");
		grep.captureScreenshot("pass", "SLA Resolution Pagination 70", "SLA_Resolution_10Pagination");
		admin_Page.selectSLAPagination(dataKeys.slaResolution, "5");

		waitTime2(driver);
		grep.infoTest("Admin Dashboard Pagination buttons for SLA Resolution Table Test");
		logger.info("Admin Dashboard Pagination buttons for SLA Resolution Table Test");
		admin_Page.sla_Prev_Next_Button(dataKeys.slaResolution, "Next");
		admin_Page.sla_Prev_Next_Button(dataKeys.slaResolution, "Next");
		admin_Page.sla_Prev_Next_Button(dataKeys.slaResolution, "Previous");
		waitTime(driver);

		grep.testCreate("Admin Dashboard Search and verify Breached tickets for SLA Resolution Table Test",
				"Admin Dashboard Search and verify Breached tickets for SLA Resolution");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Search and verify Breached tickets for SLA Resolution Table Test");
		logger.info("Admin Dashboard Search and verify Breached tickets for SLA Resolution Table Test");
		waitTime(driver);
		admin_Page.searchSla(dataKeys.slaResolution, dataKeys.statusBreached);
		waitTime(driver);

		grep.captureScreenshot("pass", "Search Breached tickets for SLA Resolution ", "SearchBreached_SLAResolution");
		waitTime(driver);
		admin_Page.getStatusFromTable(dataKeys.slaResolution, dataKeys.statusBreached);
		waitTime(driver);

		String getTicketId = admin_Page.getTicketIdfromTable(dataKeys.slaResolution);
		grep.infoTest("Ticket ID from Table:" + getTicketId);
		logger.info("Ticket ID from Table:" + getTicketId);

		admin_Page.clickTicketId(dataKeys.slaResolution, getTicketId);

		String ticketId_inDetail = admin_Page.verifyTicketDetailsFromDetailPopup(dataKeys.ticketId_InDetailPopup);
		grep.infoTest("Ticket ID in Ticket Detail Popup : " + ticketId_inDetail);
		logger.info("Ticket ID in Ticket Detail Popup :" + ticketId_inDetail);

		validAssert.equalsAssert(ticketId_inDetail, getTicketId);
		waitTime(driver);
		admin_Page.getResolutionCommentsFromTicket();
		admin_Page.getSlaMetricFromTicket();
		admin_Page.verifySlaStatusInTicketDetail(dataKeys.statusBreached);
		waitTime(driver);
		grep.captureScreenshot("pass", "Breached Ticket Resolution and SLA Metrics for SLA Resolution Table",
				"Breached_SLA_Resolution_In_TicketDetails");
		waitTime(driver);

		admin_Page.clickCloseTicketPopup();
		admin_Page.clearSlaSearch(dataKeys.slaResolution);

		waitTime(driver);
		grep.testCreate("Admin Dashboard Search and verify Met tickets for SLA Resolution Table Test",
				"Admin Dashboard Search and verify Met tickets for SLA Resolution");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Search and verify Met tickets for SLA Resolution Table Test");
		logger.info("Admin Dashboard Search and verify Met tickets for SLA Resolution Table Test");
		waitTime(driver);
		admin_Page.searchSla(dataKeys.slaResolution, dataKeys.statusMet);
		waitTime(driver);
		admin_Page.getStatusFromTable(dataKeys.slaResolution, dataKeys.statusMet);
		waitTime(driver);

		grep.captureScreenshot("pass", "Search Met tickets for SLA Resolution ", "SearchMet_SLAResolution");
		waitTime(driver);

		String getTicketId2 = admin_Page.getTicketIdfromTable(dataKeys.slaResolution);
		grep.infoTest("Ticket ID from Table:" + getTicketId2);
		logger.info("Ticket ID from Table:" + getTicketId2);

		admin_Page.clickTicketId(dataKeys.slaResolution, getTicketId);

		String ticketId_inDetail2 = admin_Page.verifyTicketDetailsFromDetailPopup(dataKeys.ticketId_InDetailPopup);
		grep.infoTest("Ticket ID in Ticket Detail Popup : " + ticketId_inDetail2);
		logger.info("Ticket ID in Ticket Detail Popup :" + ticketId_inDetail2);

		validAssert.equalsAssert(ticketId_inDetail2, getTicketId2);
		waitTime(driver);
		admin_Page.getResolutionCommentsFromTicket();
		admin_Page.getSlaMetricFromTicket();
		admin_Page.verifySlaStatusInTicketDetail(dataKeys.statusMet);
		waitTime(driver);
		grep.captureScreenshot("pass", "Met Ticket Resolution and SLA Metrics for SLA Resolution Table",
				"Met_SLA_Resolution_In_TicketDetails");
		waitTime(driver);

		admin_Page.clickCloseTicketPopup();
		admin_Page.clearSlaSearch(dataKeys.slaResolution);

		// SLA Response

		waitTime(driver);
		grep.testCreate("Admin Dashboard Search for non existing for SLA Response Table Test",
				"Admin Dashboard Search SLA Response");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Search for non existing for SLA Response Table Test");
		logger.info("Admin Dashboard Search for non existing for SLA Response Table Test");
		waitTime(driver);

		admin_Page.searchSla(dataKeys.slaResponse, "$%^&");
		admin_Page.noRecordsMsg_SLA();
		waitTime(driver);
		grep.captureScreenshot("pass", "Search for non existing for SLA Response Table",
				"SLA_ResPonse_NonExistingSearch");

		waitTime(driver);

		grep.testCreate("Admin Dashboard Exporting with no data for SLA Response Table Test",
				"Admin Dashboard Exporting with no data SLA Response");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Exporting with no data for SLA Response Table Test");
		logger.info("Admin Dashboard Exporting with no data for SLA Response Table Test");
		waitTime(driver);
		admin_Page.clickSlaExportAndChoose(dataKeys.slaResponse, "CSV");

		admin_Page.getNoDataToExportMsg();
		grep.captureScreenshot("pass", "Exporting with no data for SLA Response Table",
				"SLA_Response_ExportingWithNoData");
		admin_Page.clearSlaSearch(dataKeys.slaResponse);

		waitTime(driver);

		grep.testCreate("Admin Dashboard Exporting data for SLA Response Table Test",
				"Admin Dashboard Exporting data SLA Response");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Exporting data for SLA Response Table Test");
		logger.info("Admin Dashboard Exporting data for SLA Response Table Test");
		waitTime(driver);
		admin_Page.clickSlaExportAndChoose(dataKeys.slaResponse, "CSV");

		grep.infoTest("Admin Dashboard Exporting data to CSV for SLA Response Table Test");
		logger.info("Admin Dashboard Exporting data to CSV for SLA Response Table Test");

		grep.captureScreenshot("pass", "Exporting CSV data for SLA Response Table", "SLA_Response_ExportingWithCSV");

		waitTime(driver);
		admin_Page.clickSlaExportAndChoose(dataKeys.slaResponse, "PDF");

		grep.infoTest("Admin Dashboard Exporting data to PDF for SLA Response Table Test");
		logger.info("Admin Dashboard Exporting data to PDF for SLA Response Table Test");

		grep.captureScreenshot("pass", "Exporting PDF data for SLA Response Table", "SLA_Response_ExportingWithPDF");

		grep.testCreate("Admin Dashboard Pagination for SLA Response Table Test",
				"Admin Dashboard Pagination for SLA Response");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Pagination for SLA Response Table Test");
		logger.info("Admin Dashboard Pagination for SLA Response Table Test");

		admin_Page.selectSLAPagination(dataKeys.slaResponse, "20");
		grep.captureScreenshot("pass", " SLA Response Pagination 20", "SLA_Response_20Pagination");
		admin_Page.selectSLAPagination(dataKeys.slaResponse, "50");
		grep.captureScreenshot("pass", "SLA Response Pagination 50", "SLA_Response_50Pagination");
		admin_Page.selectSLAPagination(dataKeys.slaResponse, "10");
		grep.captureScreenshot("pass", "SLA Response Pagination 70", "SLA_Response_10Pagination");
		admin_Page.selectSLAPagination(dataKeys.slaResponse, "5");

		waitTime2(driver);
		grep.infoTest("Admin Dashboard Pagination buttons for SLA Response Table Test");
		logger.info("Admin Dashboard Pagination buttons for SLA Response Table Test");
		admin_Page.sla_Prev_Next_Button(dataKeys.slaResponse, "Next");
		admin_Page.sla_Prev_Next_Button(dataKeys.slaResponse, "Next");
		admin_Page.sla_Prev_Next_Button(dataKeys.slaResponse, "Previous");
		waitTime(driver);

		grep.testCreate("Admin Dashboard Search and verify Breached tickets for SLA Response Table Test",
				"Admin Dashboard Search and verify Breached tickets for SLA Response");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Search and verify Breached tickets for SLA Response Table Test");
		logger.info("Admin Dashboard Search and verify Breached tickets for SLA Response Table Test");
		waitTime(driver);
		admin_Page.searchSla(dataKeys.slaResponse, dataKeys.statusBreached);
		waitTime(driver);
		admin_Page.getStatusFromTable(dataKeys.slaResponse, dataKeys.statusBreached);
		waitTime(driver);

		grep.captureScreenshot("pass", "Search Breached tickets for SLA Response ", "SearchBreached_SLAResponse");
		waitTime(driver);

		String getTicketId_response = admin_Page.getTicketIdfromTable(dataKeys.slaResponse);
		grep.infoTest("Ticket ID from Table:" + getTicketId_response);
		logger.info("Ticket ID from Table:" + getTicketId_response);

		admin_Page.clickTicketId(dataKeys.slaResponse, getTicketId_response);

		String ticketId_inDetail_response = admin_Page
				.verifyTicketDetailsFromDetailPopup(dataKeys.ticketId_InDetailPopup);
		grep.infoTest("Ticket ID in Ticket Detail Popup : " + ticketId_inDetail_response);
		logger.info("Ticket ID in Ticket Detail Popup :" + ticketId_inDetail_response);

		validAssert.equalsAssert(ticketId_inDetail_response, getTicketId_response);
		waitTime(driver);
		admin_Page.getResolutionCommentsFromTicket();
		waitTime(driver);
		admin_Page.getSlaMetricFromTicket();
		waitTime(driver);
		grep.captureScreenshot("pass", "Breached Ticket Resolution and SLA Metrics for SLA Response Table",
				"Breached_SLA_Response_In_TicketDetails");
		waitTime(driver);

		admin_Page.clickCloseTicketPopup();
		admin_Page.clearSlaSearch(dataKeys.slaResponse);

		waitTime(driver);
		grep.testCreate("Admin Dashboard Search and verify Met tickets for SLA Response Table Test",
				"Admin Dashboard Search and verify Met tickets for SLA Response");
		waitTime(driver);
		grep.infoTest("Admin Dashboard Search and verify Met tickets for SLA Response Table Test");
		logger.info("Admin Dashboard Search and verify Met tickets for SLA Response Table Test");
		waitTime2(driver);
		admin_Page.searchSla(dataKeys.slaResponse, dataKeys.statusMet);
		waitTime2(driver);
		admin_Page.getStatusFromTable(dataKeys.slaResponse, dataKeys.statusMET);
		waitTime(driver);

		grep.captureScreenshot("pass", "Search Met tickets for SLA Response ", "SearchMet_SLAResponse");
		waitTime(driver);

		String getTicketId_response2 = admin_Page.getTicketIdfromTable(dataKeys.slaResponse);
		grep.infoTest("Ticket ID from Table:" + getTicketId_response2);
		logger.info("Ticket ID from Table:" + getTicketId_response2);

		admin_Page.clickTicketId(dataKeys.slaResponse, getTicketId_response2);

		String ticketId_inDetail_response2 = admin_Page
				.verifyTicketDetailsFromDetailPopup(dataKeys.ticketId_InDetailPopup);
		grep.infoTest("Ticket ID in Ticket Detail Popup : " + ticketId_inDetail_response2);
		logger.info("Ticket ID in Ticket Detail Popup :" + ticketId_inDetail_response2);

		validAssert.equalsAssert(ticketId_inDetail_response2, getTicketId_response2);
		waitTime(driver);
		admin_Page.getResolutionCommentsFromTicket();
		admin_Page.getSlaMetricFromTicket();
		waitTime(driver);
		grep.captureScreenshot("pass", "Met Ticket Resolution and SLA Metrics for SLA Response Table",
				"Met_SLA_Response_In_TicketDetails");
		waitTime(driver);

		admin_Page.clickCloseTicketPopup();
		admin_Page.clearSlaSearch(dataKeys.slaResponse);

	}

	public void adminApproverManagementTest() throws Exception {

		ticketpage.navigateToPage(dataKeys.approverMgmtPage);
		waitTime5(driver);

		grep.testCreate("Admin Approver Management Export, Pagination Test",
				"Admin Approver Management Export, Pagination");
		waitTime(driver);
		grep.infoTest("Admin Approver Management Export, Pagination Test");
		logger.info("Admin Approver Management Export, Pagination Test");
		waitTime5(driver);

		admin_Page.verifyApproverManagementHeader(dataKeys.approverMgmtTitle);
		waitTime(driver);
		admin_Page.selectApprMgmtPagination("15");
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Pagination -15 Test", "admin_ApprMgmt_Pagination_15");

		admin_Page.selectApprMgmtPagination("10");
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Pagination -10 Test", "admin_ApprMgmt_Pagination_10");

		admin_Page.selectApprMgmtPagination("5");

		waitTime(driver);
		admin_Page.appr_Mgmt_Export("CSV");
		admin_Page.appr_Mgmt_Export("PDF");

		grep.testCreate("Admin Approver Management Department Filter Test",
				"Admin Approver Management Department Filter");
		waitTime(driver);
		grep.infoTest("Admin Approver Management Department Filter Test");
		logger.info("Admin Approver Management Department Filter Test");
		waitTime2(driver);
		admin_Page.selectApprMgmtDepartment(dataKeys.btg_DepartmentFilter);
		waitTime(driver);
		admin_Page.verifyAppr_RoleMgmt_FilterInTable(dataKeys.btg_DepartmentFilter);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Department Filter Test",
				"admin_ApprMgmt_Department_Test");
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Admin Approver Management Roles Filter Test", "Admin Approver Management Roles Filter");
		waitTime(driver);
		grep.infoTest("Admin Approver Management Roles Filter Test");
		logger.info("Admin Approver Management Roles Filter Test");
		waitTime2(driver);
		admin_Page.selectApprMgmtRoles(dataKeys.itApprover_Role);
		waitTime(driver);
		admin_Page.verifyAppr_RoleMgmt_FilterInTable(dataKeys.itApprover_Role);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management IT Approver Roles Filter Test",
				"admin_ApprMgmt_ITAppr_Roles_Test");
		waitTime2(driver);
		admin_Page.selectApprMgmtRoles(dataKeys.admin_Role);
		waitTime(driver);
		admin_Page.verifyAppr_RoleMgmt_FilterInTable(dataKeys.admin_Role);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Admin Roles Filter Test",
				"admin_ApprMgmt_Admin_Roles_Test");
		waitTime(driver);

		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Admin Approver Management Search Filter Test", "Admin Approver Management Search Filter");
		waitTime(driver);
		grep.infoTest("Admin Approver Management Search by Email Filter Test");
		logger.info("Admin Approver Management Search by Email Filter Test");
		waitTime2(driver);
		admin_Page.apprMgmt_SearchFilter(dataKeys.ssoUserName);
		waitTime(driver);
		admin_Page.verifyAppr_RoleMgmt_FilterInTable(dataKeys.ssoUserName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Search by Email Filter Test",
				"admin_ApprMgmt_Email_Search_Test");
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);
		grep.infoTest("Admin Approver Management Search by Name Filter Test");
		logger.info("Admin Approver Management Search by Name Filter Test");
		waitTime2(driver);
		admin_Page.apprMgmt_SearchFilter("phani");
		waitTime(driver);
		admin_Page.verifyAppr_RoleMgmt_FilterInTable("phani");
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Search by Name Filter Test",
				"admin_ApprMgmt_Name_Search_Test");
		waitTime(driver);
		admin_Page.clickClearFilterBtn();
		waitTime(driver);

		grep.testCreate("Admin Approver Management Search for Non Existing Test",
				"Admin Approver Management Search for Non Existing");
		waitTime(driver);
		grep.infoTest("Admin Approver Management Search for Non Existing Test");
		logger.info("Admin Approver Management Search for Non Existing Test");
		waitTime2(driver);
		admin_Page.apprMgmt_SearchFilter("$%^&*");
		waitTime(driver);
		admin_Page.noRecordsMsg_InAdmin();
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Search for Non Existing Test",
				"admin_ApprMgmt_NonExisting_Search_Test");
		waitTime(driver);
		admin_Page.clickClearFilterBtn();

		waitTime(driver);
		grep.testCreate("Keeping required fields blank for new approver management popup Test",
				"Keeping required fields blank for new approver management popup");
		waitTime(driver);
		grep.infoTest("Keeping required fields blank for new approver management popup Test");
		logger.info("Keeping required fields blank for new approver management popup Test");
		waitTime2(driver);
		admin_Page.clickAddNewApproverBtn();
		waitTime(driver);
		admin_Page.verifyNewApproverPopupHeader("Add Approver or Member");
		waitTime(driver);
		admin_Page.clickApproverPopupBtn("Add");
		waitTime(driver);
		grep.captureScreenshot("pass", "Keeping required fields blank for new approver management popup Test",
				"admin_ApprMgmtPopup_Blank_Test");
		waitTime(driver);
		String roleError = admin_Page.verifyNewApproverErrorMsg(dataKeys.role_ApprMgmt);
		String nameError = admin_Page.verifyNewApproverErrorMsg(dataKeys.name_ApprMgmt);
		String emailError = admin_Page.verifyNewApproverErrorMsg(dataKeys.email_ApprMgmt);
		String deptError = admin_Page.verifyNewApproverErrorMsg(dataKeys.dept_ApprMgmt);

		validAssert.equalsAssert(roleError, dataKeys.role_ApprMgmt + "is required");
		validAssert.equalsAssert(nameError, dataKeys.name_ApprMgmt + "is required");
		validAssert.equalsAssert(emailError, dataKeys.email_ApprMgmt + "is required");
		validAssert.equalsAssert(deptError, dataKeys.dept_ApprMgmt + "is required");

		waitTime(driver);
//		admin_Page.clickApproverPopupBtn("Cancel");
		waitTime(driver);

		grep.testCreate("Entering invalid email format in new approver management popup Test",
				"Entering invalid email format in new approver management popup");
		waitTime(driver);
		grep.infoTest("Entering invalid email format in new approver management popup Test");
		logger.info("Entering invalid email format in new approver management popup Test");
		waitTime2(driver);
//		admin_Page.clickAddNewApproverBtn();
		waitTime(driver);
		admin_Page.selectFilter(dataKeys.role_ApprMgmt, dataKeys.itApprover_Role);
		admin_Page.selectFilter(dataKeys.dept_ApprMgmt, dataKeys.btg_DepartmentFilter);
		admin_Page.insertValue_inNewApprPopup(dataKeys.name_ApprMgmt, dataKeys.userName);
		waitTime(driver);
		admin_Page.insertValue_inNewApprPopup(dataKeys.email_ApprMgmt, dataKeys.userName);
		waitTime(driver);
		String invalidEmailError = admin_Page.verifyNewApproverErrorMsg(dataKeys.email_ApprMgmt);

		validAssert.equalsAssert(invalidEmailError, "Invalid email format");
		waitTime(driver);
		grep.captureScreenshot("pass", "Entering invalid email format in new approver management popup Test",
				"admin_ApprMgmtPopup_InvalidEmail_Test");
		waitTime(driver);
		admin_Page.clickApproverPopupBtn("Cancel");

	}

	public void adminRolesManagementTest() throws Exception {
		ticketpage.navigateToPage(dataKeys.rolesPage);
		waitTime5(driver);

		grep.testCreate("Admin Roles Management Pagination Test", "Admin Roles Management Pagination");
		waitTime(driver);
		grep.infoTest("Admin Roles Management Pagination Test");
		logger.info("Admin Roles Management Pagination Test");
		waitTime5(driver);

		admin_Page.verifyRolesManagementHeader(dataKeys.rolesTitle);
		waitTime(driver);
		waitTime(driver);
		admin_Page.selectAllTicketsPagination("20");
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Roles Management Pagination -20 Test", "admin_Roles_Pagination_15");

		admin_Page.selectAllTicketsPagination("30");
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Roles Management Pagination -30 Test", "admin_Roles_Pagination_10");

		admin_Page.selectAllTicketsPagination("10");
		waitTime(driver);

		grep.testCreate("Admin Roles Management Search Filter Test", "Admin Roles Management Search Filter");
		waitTime(driver);
		grep.infoTest("Admin Roles Management Search by Email Filter Test");
		logger.info("Admin Roles Management Search by Email Filter Test");
		waitTime2(driver);
		admin_Page.roles_SearchFilter(dataKeys.ssoUserName);
		waitTime(driver);
		admin_Page.verifyAppr_RoleMgmt_FilterInTable(dataKeys.ssoUserName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Roles Management Search by Email Filter Test",
				"admin_Roles_Email_Search_Test");
		waitTime(driver);
		admin_Page.clearRolesSearch();
		waitTime(driver);
		grep.infoTest("Admin Roles Management Search by Name Filter Test");
		logger.info("Admin Roles Management Search by Name Filter Test");
		waitTime2(driver);
		admin_Page.roles_SearchFilter("phani");
		waitTime(driver);
		admin_Page.verifyAppr_RoleMgmt_FilterInTable("phani");
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Roles Management Search by Name Filter Test",
				"admin_Roles_Name_Search_Test");
		waitTime(driver);
		admin_Page.clearRolesSearch();
		waitTime(driver);

		grep.testCreate("Admin Roles Management Search for Non Existing Test",
				"Admin Roles Management Search for Non Existing");
		waitTime(driver);
		grep.infoTest("Admin Roles Management Search for Non Existing Test");
		logger.info("Admin Roles Management Search for Non Existing Test");
		waitTime2(driver);
		admin_Page.roles_SearchFilter("$%^&*");
		waitTime(driver);
		admin_Page.noRecordsMsg_InAdmin();
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Approver Management Search for Non Existing Test",
				"admin_Roles_NonExisting_Search_Test");
		waitTime(driver);
		admin_Page.clearRolesSearch();

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