package IntelliServe_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.IntelliServe_TestDataKeys;
import BaseClasses.IntelliServe_TestInitializer;
import IntelliServe_Pages.Ticketing_Approver_Member_Page;
import IntelliServe_Pages.Ticketing_Create_Ticket_Page;
import IntelliServe_Pages.Ticketing_Page;
import Utility.ExcelDataProvider;
import Utility.GenerateReports;
import Utility.ValidatingAssertions;
import lombok.val;

public class IntelliServe_CreateTicket_Test extends IntelliServe_TestInitializer {
	private static final Logger logger = LogManager.getLogger(IntelliServe_CreateTicket_Test.class);
	GenerateReports grep = new GenerateReports();
	IntelliServe_TestDataKeys dataKeys = new IntelliServe_TestDataKeys();
	Ticketing_Page ticketpage;
	Ticketing_Create_Ticket_Page createTict;
	Ticketing_Approver_Member_Page appr_member_Page;
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@DataProvider(name = "CreateTicket")
	public Object[][] getData() {
		// Get Excel Test Data passing Excel File Name and Sheet Name
		Object data[][] = ExcelDataProvider.testData("AutomationFile", "Create Ticket");
		return data;
	}

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
//		ticketpage = new Ticketing_Page();
//		appr_member_Page = new Ticketing_Approver_Member_Page();
//		createTict = new Ticketing_Create_Ticket_Page();

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

	@Test(priority = 4, dataProvider = "CreateTicket")
	public void createTicketWithMultipleFilesTest(String incTitle, String incDetail1, String imcImage1,
			String incDetail2, String imcImage2, String incDetail3) throws Exception {
		ticketpage = new Ticketing_Page();
		appr_member_Page = new Ticketing_Approver_Member_Page();
		createTict = new Ticketing_Create_Ticket_Page();
		refreshPage();
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
		waitTime5(driver);
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
//		createTict.insertIncidentTitle("Testing Intelliserve Automation");
//		createTict.insertIncidentDetail("Entering Incident Detail Through Automation");
		createTict.insertIncidentTitle(incTitle);
		createTict.insertIncidentDetail(incDetail1);

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
//		createTict.pasteImageInIncidentDetail("C:\\Users\\PhaniKumarMaddi\\Downloads\\images1.jpg");
		createTict.pasteImageInIncidentDetail(imcImage1);

		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");
		waitTime2(driver);
//		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");
		createTict.insertIncidentDetail(incDetail2);
		waitTime(driver);
//		createTict.pasteImageInIncidentDetail("C:\\Users\\PhaniKumarMaddi\\Downloads\\images.jpg");
		createTict.pasteImageInIncidentDetail(imcImage2);
		waitTime(driver);
//		createTict.insertIncidentDetail("Testing Intelliserve");
		createTict.insertIncidentDetail(incDetail3);

		String[] files = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\Invoice_20251111.png" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Word New.docx" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Total_Assets_2025-11-05.pdf" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Excel File.xlsx" };

		createTict.chooseFileIn_NewTicket(files);

		waitTime(driver);
		grep.captureScreenshot("pass", "Multiple Files in Create Ticket popup Test",
				"ticketCreatedWith_MultiAttachments");
		waitTime(driver);
		createTict.clickButton(dataKeys.cancelTicket);
//		createTict.clickButton(dataKeys.createTicket);
//		createTict.getCreateTicketpopupSucessMessage();

		grep.testCreate("Verify the Ticket details and Audit Details in Ticket Details popup Test",
				"Verify the Ticket details and Audit Details in Ticket Details popup");
		waitTime(driver);
		grep.infoTest("Verify the Ticket details and Audit Details in Ticket Details popup Test");
		logger.info("Verify the Ticket details and Audit Details in Ticket Details popup Test");
		waitTime5(driver);

		String getTicketId = createTict.getTicketIdfromTable();
		grep.infoTest("Ticket ID from Table:" + getTicketId);
		logger.info("Ticket ID from Table:" + getTicketId);

		createTict.clickTicketId(getTicketId);

		String verifyTicketId = createTict.verifyTicketIdFromDetailPopup();
		grep.infoTest("Ticket ID in Ticket Detail Popup: " + verifyTicketId);
		logger.info("Ticket ID in Ticket Detail Popup: " + verifyTicketId);

		String ticketId_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.ticketId_InDetailPopup);
		grep.infoTest("Ticket ID in Ticket Detail Popup : " + ticketId_inDetail);
		logger.info("Ticket ID in Ticket Detail Popup :" + ticketId_inDetail);

		validAssert.equalsAssert(ticketId_inDetail, getTicketId);

//		if (ticketId_inDetail.equals(getTicketId)) {
//			grep.passTest("Ticket ID in Ticket Detail Popup is Valid:" + ticketId_inDetail);
//			logger.info("Ticket ID in Ticket Detail Popup is Valid:" + ticketId_inDetail);
//
//		} else {
//			grep.failTest("Ticket ID in Ticket Detail Popup is inValid:" + ticketId_inDetail);
//			logger.info("Ticket ID in Ticket Detail Popup is inValid:" + ticketId_inDetail);
//
//		}

		String ticketType_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.ticketType_InDetailPopup);
		grep.infoTest("Ticket Type in Ticket Detail Popup: " + ticketType_inDetail);
		logger.info("Ticket Type in Ticket Detail Popup: " + ticketType_inDetail);

		String status_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.status_InDetailPopup);
		grep.infoTest("Status in Ticket Detail Popup: " + status_inDetail);
		logger.info("Status in Ticket Detail Popup: " + status_inDetail);
		validAssert.equalsAssert(status_inDetail, "Pending");

		String stage_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.stage_InDetailPopup);
		grep.infoTest("Stage in Ticket Detail Popup: " + stage_inDetail);
		logger.info("Stage in Ticket Detail Popup: " + stage_inDetail);

		String priority_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.priority_InDetailPopup);
		grep.infoTest("Priority in Ticket Detail Popup: " + priority_inDetail);
		logger.info("Priority in Ticket Detail Popup: " + priority_inDetail);

		String req_name_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.requestor_InDetailPopup);
		grep.infoTest("Requestor Name in Ticket Detail Popup: " + req_name_inDetail);
		logger.info("Requestor Name in Ticket Detail Popup: " + req_name_inDetail);

		String req_email_inDetail = createTict
				.verifyTicketDetailsFromDetailPopup(dataKeys.requestorEmail_InDetailPopup);
		grep.infoTest("Requestor Email in Ticket Detail Popup: " + req_email_inDetail);
		logger.info("Requestor Email in Ticket Detail Popup: " + req_email_inDetail);

		String req_mobile_inDetail = createTict
				.verifyTicketDetailsFromDetailPopup(dataKeys.requestorMobile_InDetailPopup);
		grep.infoTest("Requestor Mobile in Ticket Detail Popup: " + req_mobile_inDetail);
		logger.info("Requestor Mobile in Ticket Detail Popup: " + req_mobile_inDetail);

		String dept_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.department_InDetailPopup);
		grep.infoTest("Department in Ticket Detail Popup: " + dept_inDetail);
		logger.info("Department in Ticket Detail Popup: " + dept_inDetail);

		String manager_name_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.manager_InDetailPopup);
		grep.infoTest("Manager Name ID in Ticket Detail Popup: " + manager_name_inDetail);
		logger.info("Manager Name in Ticket Detail Popup: " + manager_name_inDetail);

		String manager_email_inDetail = createTict
				.verifyTicketDetailsFromDetailPopup(dataKeys.managerEmail_InDetailPopup);
		grep.infoTest("Manager Email in Ticket Detail Popup: " + manager_email_inDetail);
		logger.info("Manager Email in Ticket Detail Popup: " + manager_email_inDetail);

		String created_inDetail = createTict.verifyTicketDetailsFromDetailPopup(dataKeys.created_InDetailPopup);
		grep.infoTest("Created Date in Ticket Detail Popup: " + created_inDetail);
		logger.info("Created Date in Ticket Detail Popup: " + created_inDetail);

		createTict.getIncidentDetailsFromDetailPopup(incTitle);
		waitTime(driver);
		grep.captureScreenshot("pass", "Tickets and Incident Details in Ticket Detail Popup",
				"Ticket_And_IncidentDetails_inDetailPopup");
		waitTime(driver);

		String stage_InAudit = createTict.getStageFromAuditTable();
		grep.infoTest("Stage from Audit table in Ticket Detail Popup: " + stage_InAudit);
		logger.info("Stage from Audit table in Ticket Detail Popup: " + stage_InAudit);
		validAssert.equalsAssert(stage_InAudit, "New");

		String status_InAudit = createTict.getStatusFromAuditTable();
		grep.infoTest("Status from Audit table in Ticket Detail Popup: " + status_InAudit);
		logger.info("Status from Audit table in Ticket Detail Popup: " + status_InAudit);
		validAssert.equalsAssert(status_InAudit, "Ticket Created");

		String next_Stage_InAudit = createTict.getNextStageFromAuditTable();
		grep.infoTest("Next Stage from Audit table in Ticket Detail Popup: " + next_Stage_InAudit);
		logger.info("Next Stage from Audit table in Ticket Detail Popup: " + next_Stage_InAudit);

		String action_InAudit = createTict.getActionDateFromAuditTable();
		grep.infoTest("Action from Audit table in Ticket Detail Popup: " + action_InAudit);
		logger.info("Action from Audit table in Ticket Detail Popup: " + action_InAudit);

		String comments_InAudit = createTict.getCommentsFromAuditTable();
		grep.infoTest("Comments from Audit table in Ticket Detail Popup: " + comments_InAudit);
		logger.info("Comments from Audit table in Ticket Detail Popup: " + comments_InAudit);
		validAssert.equalsAssert(comments_InAudit, "Ticket Created Successfully");

		waitTime(driver);
		grep.captureScreenshot("pass", "Audit Details in Ticket Detail Popup", "AuditDetails_inDetailPopup");
		waitTime(driver);

		createTict.clickCloseDetailPopup();

	}

}
