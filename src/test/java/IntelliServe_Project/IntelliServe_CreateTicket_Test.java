package IntelliServe_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.IntelliServe_TestDataKeys;
import BaseClasses.IntelliServe_TestInitializer;
import IntelliServe_Pages.Ticketing_Approver_Member_Page;
import IntelliServe_Pages.Ticketing_Create_Ticket_Page;
import IntelliServe_Pages.Ticketing_Page;
import Utility.GenerateReports;

public class IntelliServe_CreateTicket_Test extends IntelliServe_TestInitializer {
	private static final Logger logger = LogManager.getLogger(IntelliServe_CreateTicket_Test.class);
	GenerateReports grep = new GenerateReports();
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();
	Ticketing_Page ticketpage;
	Ticketing_Create_Ticket_Page createTict;
	Ticketing_Approver_Member_Page appr_member_Page;

	@Test(priority = 1)
	public void validatingCreateTicketFieldsTest() throws Exception {
		ticketpage = new Ticketing_Page();
		appr_member_Page = new Ticketing_Approver_Member_Page();
		createTict = new Ticketing_Create_Ticket_Page();

		grep.testCreate("Verify keeping all required fields blank in create ticket page test",
				"Verify keeping all required fields blank in create ticket page test");
		waitTime(driver);
		grep.infoTest("Verify keeping all required fields blank in create ticket page test");
		logger.info("Verify keeping all required fields blank in create ticket page test");
		waitTime(driver);
		ticketpage.navigateToPage(dataKeys.myTicketPage);
		waitTime3(driver);
		createTict.clickCreateTicketLink();
		waitTime3(driver);
		createTict.verifyCreateTicketPageHeader("Create New Ticket");
		String desc = createTict.verifyCreateTicketPageDesc();
		grep.infoTest("Create Ticket Description: " + desc);
		logger.info("Create Ticket Description: " + desc);

		createTict.selectTicketType("Infrastructure");
		waitTime1(driver);

		createTict.selectTicketType("Software");
		waitTime(driver);

		createTict.getRequestorDetails();
		waitTime(driver);
		createTict.clickButton(dataKeys.createTicket);
		grep.infoTest("Verify Error Message");
		logger.info("Verify Error Message");

		createTict.getIncidentTitleError();
		createTict.getIncidentDetailError();
		waitTime(driver);
		grep.captureScreenshot("pass", "Verify Error Message For Incident Titles and Incident Details",
				"IncidentErrorMessages");
		waitTime(driver);

		grep.testCreate("Entering incident details in create new ticket popup Test",
				"Entering incident details in create new ticket popup");
		waitTime(driver);
		grep.infoTest("Entering incident details in create new ticket popup Test");
		logger.info("Entering incident details in create new ticket popup Test");
		waitTime(driver);

		createTict.insertIncidentTitle("Testing Intelliserve");
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");

		waitTime(driver);
		createTict.selectAllIncidentDetail();
		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");

		actionEntered();
		waitTime(driver);
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");
		waitTime(driver);
		grep.captureScreenshot("pass", "Entering Incident Details", "Enter_IncidentDetails");
		waitTime(driver);

		grep.testCreate("Entering more than limit file in create new ticket popup Test",
				"Entering more than limit file in create new ticket popup");
		waitTime(driver);
		grep.infoTest("Entering more than limit file in create new ticket popup Test");
		logger.info("Entering more than limit file in create new ticket popup Test");
		waitTime(driver);

		String[] moreLimit_File = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\50mb.pdf" };

		createTict.chooseFileIn_NewTicket(moreLimit_File);
		waitTime(driver);
		createTict.getCreateTicketpopupErrorMessage(dataKeys.limitExceedMsg);
		grep.captureScreenshot("pass", "Entering more than limit file in create new ticket popup Test",
				"Enter_MoreLimitFile");
		waitTime5(driver);
		createTict.clickButton(dataKeys.cancelTicket);
		waitTime(driver);

		grep.testCreate("Entering invalid file format in create new ticket popup Test",
				"Entering invalid file format in create new ticket popup");
		waitTime(driver);
		grep.infoTest("Entering invalid file format in create new ticket popup Test");
		logger.info("Entering invalid file format in create new ticket popup Test");
		waitTime(driver);
		createTict.clickCreateTicketLink();
		waitTime3(driver);
		createTict.insertIncidentTitle("Testing Intelliserve");
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");

		waitTime(driver);

		String[] invalid_files = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\test.zip" };

		createTict.chooseFileIn_NewTicket(invalid_files);
		waitTime2(driver);
		createTict.getCreateTicketpopupErrorMessage(dataKeys.invalidFileMsg);

		waitTime(driver);
		grep.captureScreenshot("pass", "Entering invalid file format in create new ticket popup Test",
				"Enter_InvalidFile");
		waitTime1(driver);
		createTict.clickButton(dataKeys.cancelTicket);
		waitTime2(driver);

	}

	@Test(priority = 2)
	public void validatingCreateTicketByApproverOrMemberFieldsTest() throws Exception {
		ticketpage = new Ticketing_Page();
		appr_member_Page = new Ticketing_Approver_Member_Page();
		createTict = new Ticketing_Create_Ticket_Page();

		waitTime2(driver);

		boolean it_approver = ticketpage.verifyUserRole(dataKeys.itApprover_Role);
		boolean btg_approver = ticketpage.verifyUserRole(dataKeys.btgApprover_Role);
		if (it_approver || btg_approver) {
			if (it_approver) {
				waitTime(driver);
				ticketpage.selectUserRole(dataKeys.itApprover_Role);
				waitTime(driver);
				ticketpage.navigateToPage(dataKeys.approverWorklistPage);

				waitTime(driver);
				appr_member_Page.verifyApproverWorkListHeader("IT Approver Worklist");

			} else {
				waitTime(driver);
				ticketpage.selectUserRole(dataKeys.btgApprover_Role);
				waitTime(driver);
				ticketpage.navigateToPage(dataKeys.approverWorklistPage);

				waitTime(driver);
				appr_member_Page.verifyApproverWorkListHeader("BTG Approver Worklist");
			}
		}

		grep.testCreate("Verify keeping all required fields blank in approver create ticket page test",
				"Verify keeping all required fields blank in approver create ticket page test");
		waitTime(driver);
		grep.infoTest("Verify keeping all required fields blank in approver create ticket page test");
		logger.info("Verify keeping all required fields blank in approver create ticket page test");
		waitTime(driver);

		createTict.clickCreateTicketLink();
		waitTime3(driver);
		createTict.verifyCreateTicketPageHeader("Create New Ticket");
		String desc = createTict.verifyCreateTicketPageDesc();
		grep.infoTest("Create Ticket Description: " + desc);
		logger.info("Create Ticket Description: " + desc);

		createTict.selectTicketType("Infrastructure");
		waitTime1(driver);

		createTict.clickButton(dataKeys.createTicket);
		grep.infoTest("Verify Error Message");
		logger.info("Verify Error Message");
//		waitTime(driver);

		createTict.getIncidentTitleError();
		createTict.getIncidentDetailError();

		createTict.getRequestorNameError();
		createTict.getRequestorEmailError();
		createTict.getDepartmentError();
		waitTime2(driver);
		grep.captureScreenshot("pass", "Verify Error Message For Incident Titles and Incident Details",
				"requiredFields_ErrorMessages");
		waitTime(driver);

		createTict.clickButton(dataKeys.cancelTicket);
		ticketpage.navigateToPage(dataKeys.approverWorklistPage);
		createTict.clickCreateTicketLink();
		waitTime3(driver);

		grep.testCreate("Entering Valid details in create new ticket popup Test",
				"Entering Valid details in create new ticket popup");
		waitTime(driver);
		grep.infoTest("Entering Valid details in create new ticket popup Test");
		logger.info("Entering Valid details in create new ticket popup Test");
		waitTime(driver);

		createTict.insertRequestorName(dataKeys.userName);
		createTict.insertRequestorEmail(dataKeys.ssoUserName);
		createTict.selectDepartment(dataKeys.btg_DepartmentFilter);
		createTict.insertIncidentTitle("Testing Intelliserve");
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");

		waitTime(driver);
		createTict.selectAllIncidentDetail();
		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");

		actionEntered();
		waitTime(driver);
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");
		waitTime(driver);
		grep.captureScreenshot("pass", "Entering Incident Details", "Enter_Approver_TicketDetails");
		waitTime(driver);

		grep.testCreate("Entering more than limit file in approver create new ticket popup Test",
				"Entering more than limit file in approver create new ticket popup");
		waitTime(driver);
		grep.infoTest("Entering more than limit file in approver create new ticket popup Test");
		logger.info("Entering more than limit file in approver create new ticket popup Test");
		waitTime(driver);

		String[] moreLimit_File = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\50mb.pdf" };

		createTict.chooseFileIn_NewTicket(moreLimit_File);
		waitTime(driver);
		createTict.getCreateTicketpopupErrorMessage(dataKeys.limitExceedMsg);
		grep.captureScreenshot("pass", "Entering more than limit file in create new ticket popup Test",
				"Enter_Approver_MoreLimitFile");
		waitTime5(driver);
		createTict.clickButton(dataKeys.cancelTicket);
		waitTime(driver);

		ticketpage.navigateToPage(dataKeys.approverWorklistPage);
		waitTime3(driver);

		grep.testCreate("Entering invalid file format in approver create new ticket popup Test",
				"Entering invalid file format in approver create new ticket popup");
		waitTime(driver);
		grep.infoTest("Entering invalid file format in approver create new ticket popup Test");
		logger.info("Entering invalid file format in approver create new ticket popup Test");
		waitTime(driver);
		createTict.clickCreateTicketLink();
		waitTime3(driver);
		createTict.insertIncidentTitle("Testing Intelliserve");
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");

		waitTime(driver);

		String[] invalid_files = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\test.zip" };

		createTict.chooseFileIn_NewTicket(invalid_files);
		waitTime2(driver);
		createTict.getCreateTicketpopupErrorMessage(dataKeys.invalidFileMsg);

		waitTime(driver);
		grep.captureScreenshot("pass", "Entering invalid file format in create new ticket popup Test",
				"Enter_Approver_InvalidFile");
		waitTime1(driver);
		createTict.clickButton(dataKeys.cancelTicket);
		waitTime2(driver);

	}

	@Test(priority = 3)
	public void createTicketByApproverOrMemberTest() throws Exception {

		grep.testCreate(
				"Creating an Ticket by approver or member with attaching multiple files in create new ticket popup Test",
				"Creating an Ticket by approver or member with attaching multiple files in create new ticket popup");
		waitTime(driver);
		grep.infoTest(
				"Creating an Ticket by approver or member with attaching multiple files in create new ticket popup Test");
		logger.info(
				"Creating an Ticket by approver or member with attaching multiple files in create new ticket popup Test");
		waitTime(driver);

		ticketpage.navigateToPage(dataKeys.approverWorklistPage);
		waitTime3(driver);

		createTict.clickCreateTicketLink();

		waitTime3(driver);

		createTict.insertRequestorName(dataKeys.userName);
		createTict.insertRequestorEmail(dataKeys.ssoUserName);
		createTict.selectDepartment(dataKeys.btg_DepartmentFilter);
		createTict.selectPriorityLevel("Low");
		waitTime(driver);
		createTict.insertIncidentTitle("Testing Intelliserve Automation");
		createTict.insertIncidentDetail("Entering Incident Detail Through Automation");

		waitTime(driver);
		createTict.selectAllIncidentDetail();
		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");
		// click enter
		actionEntered();
		waitTime(driver);
		createTict.pasteImageInIncidentDetail("C:\\Users\\PhaniKumarMaddi\\Downloads\\images1.jpg");

		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");
		waitTime2(driver);
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");
		waitTime(driver);
		createTict.pasteImageInIncidentDetail("C:\\Users\\PhaniKumarMaddi\\Downloads\\images.jpg");
		waitTime(driver);
		createTict.insertIncidentDetail("Testing Intelliserve");

		String[] files = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\Invoice_20251111.png" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Word New.docx" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Total_Assets_2025-11-05.pdf" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Excel File.xlsx" };

		createTict.chooseFileIn_NewTicket(files);

		waitTime(driver);
		grep.captureScreenshot("pass", "Multiple Files in Create Ticket popup Test", "createTicket_Approvertest");
		waitTime(driver);
		createTict.clickButton(dataKeys.cancelTicket);
//		createTict.clickButton(dataKeys.createTicket);
//		createTict.getCreateTicketpopupSucessMessage();

	}

	@Test(priority = 4)
	public void createTicketWithMultipleFilesTest() throws Exception {
		boolean it_approver = ticketpage.verifyUserRole(dataKeys.itApprover_Role);
		boolean btg_approver = ticketpage.verifyUserRole(dataKeys.btgApprover_Role);
		if (it_approver || btg_approver) {
			if (it_approver) {
				waitTime(driver);
				ticketpage.selectUserRole(dataKeys.itApprover_Role);
				waitTime(driver);
				ticketpage.navigateToPage(dataKeys.approverWorklistPage);

				waitTime(driver);
				appr_member_Page.verifyApproverWorkListHeader("IT Approver Worklist");
				ticketpage.navigateToPage(dataKeys.myTicketPage);

			} else {
				waitTime(driver);
				ticketpage.selectUserRole(dataKeys.btgApprover_Role);
				waitTime(driver);
				ticketpage.navigateToPage(dataKeys.approverWorklistPage);

				waitTime(driver);
				appr_member_Page.verifyApproverWorkListHeader("BTG Approver Worklist");
				ticketpage.navigateToPage(dataKeys.myTicketPage);
			}
		}

		grep.testCreate("Creating an Ticket with attaching multiple files in create new ticket popup Test",
				"Creating an Ticket with attaching multiple files in create new ticket popup");
		waitTime(driver);
		grep.infoTest("Creating an Ticket with attaching multiple files in create new ticket popup Test");
		logger.info("Creating an Ticket with attaching multiple files in create new ticket popup Test");
		waitTime(driver);
		createTict.clickCreateTicketLink();
		String selectedRole = ticketpage.getSelectedUserRole();
		if (selectedRole.equals(dataKeys.itApprover_Role)) {
			createTict.selectTicketType("Infrastructure");
		} else if (selectedRole.equals(dataKeys.btgApprover_Role)) {
			createTict.selectTicketType("Software");
		} else {
			createTict.selectTicketType("Software");
		}
		waitTime3(driver);
//		createTict.selectPriorityLevel("Low");
		waitTime(driver);
		createTict.insertIncidentTitle("Testing Intelliserve Automation");
		createTict.insertIncidentDetail("Entering Incident Detail Through Automation");

		waitTime(driver);
		createTict.selectAllIncidentDetail();
		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");
		// click enter
		actionEntered();
		waitTime(driver);
		createTict.pasteImageInIncidentDetail("C:\\Users\\PhaniKumarMaddi\\Downloads\\images1.jpg");

		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");
		waitTime2(driver);
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");
		waitTime(driver);
		createTict.pasteImageInIncidentDetail("C:\\Users\\PhaniKumarMaddi\\Downloads\\images.jpg");
		waitTime(driver);
		createTict.insertIncidentDetail("Testing Intelliserve");

		String[] files = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\Invoice_20251111.png" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Word New.docx" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Total_Assets_2025-11-05.pdf" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Excel File.xlsx" };

		createTict.chooseFileIn_NewTicket(files);

		waitTime(driver);
		grep.captureScreenshot("pass", "Multiple Files in Create Ticket popup Test", "MultipleFilesAttachment");
		waitTime(driver);
		createTict.clickButton(dataKeys.cancelTicket);
//		createTict.clickButton(dataKeys.createTicket);
//		createTict.getCreateTicketpopupSucessMessage();

	}

}
