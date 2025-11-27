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
	public void createTicketTest() throws Exception {
		ticketpage = new Ticketing_Page();
		appr_member_Page = new Ticketing_Approver_Member_Page();
		createTict = new Ticketing_Create_Ticket_Page();
		grep.testCreate("Create New Ticket Test", "Create New Ticket test");
		waitTime(driver);
		grep.infoTest("Approver Worklist Refresh Button Test");
		logger.info("Approver Worklist Refresh Button Test");
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
		createTict.insertIncidentTitle("Testing Intelliserve");
		createTict.insertIncidentDetail("Testing Intelliserve Incident Detail");

		waitTime(driver);
		createTict.selectAllIncidentDetail();
		waitTime(driver);
		createTict.fontStyles_NewTicket("Bold");
		createTict.fontStyles_NewTicket("Italic");
		createTict.fontStyles_NewTicket("Underline");
		createTict.fontStyles_NewTicket("Strikethrough");

		createTict.chooseFileIn_NewTicket("filepath");
//		createTict.clickButton("Cancel");

		grep.captureScreenshot("pass", "Create Ticket popup Test", "CreateTicket_Popup");

	}
}
