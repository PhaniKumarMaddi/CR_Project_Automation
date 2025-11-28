package IntelliServe_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
	public void createTicketTest() throws Exception {
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
		createTict.clickButton("Create Ticket");
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

//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
//		act.sendKeys(Keys.ENTER).build().perform();
		actionEntered();
		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");
		waitTime2(driver);
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
		createTict.getCreateTicketpopupMessage();
		grep.captureScreenshot("pass", "Entering more than limit file in create new ticket popup Test",
				"Enter_MoreLimitFile");
		waitTime5(driver);
		createTict.clickButton("Cancel");
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
		createTict.getCreateTicketpopupMessage();

		waitTime(driver);
		grep.captureScreenshot("pass", "Entering invalid file format in create new ticket popup Test",
				"Enter_InvalidFile");
		waitTime1(driver);
		createTict.clickButton("Cancel");
		waitTime2(driver);

		grep.testCreate("Attaching Multiple Files in create new ticket popup Test",
				"Attaching Multiple Files in create new ticket popup");
		waitTime(driver);
		grep.infoTest("Attaching Multiple Files in create new ticket popup Test");
		logger.info("Attaching Multiple Files in create new ticket popup Test");
		waitTime(driver);
		createTict.clickCreateTicketLink();
		waitTime3(driver);
		createTict.insertIncidentTitle("Testing Intelliserve");
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");

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
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");
		waitTime2(driver);
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");
		waitTime(driver);

		String[] files = { "C:\\Users\\PhaniKumarMaddi\\Downloads\\Invoice_20251111.png" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Word New.docx" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Total_Assets_2025-11-05.pdf" + "\n"
				+ "C:\\Users\\PhaniKumarMaddi\\Downloads\\Tickets Excel File.xlsx" };

		createTict.chooseFileIn_NewTicket(files);

		waitTime(driver);
		grep.captureScreenshot("pass", "Multiple Files in Create Ticket popup Test", "MultipleFilesAttachment");
		waitTime(driver);
//		createTict.clickButton("Cancel");

	}
}
