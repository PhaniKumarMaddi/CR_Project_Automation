package CSAT_Survey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Project_Page;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_RuddrProjectsTest extends CSAT_TestInitializer {
	private static final Logger logger = LogManager.getLogger(CSAT_RuddrProjectsTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Project_Page csatProject;
//	CSAT_Popup_Page csatPopup;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_RuddrProjects_Test() throws Exception {
		csatProject = new CSAT_Project_Page();
//		csatPopup = new CSAT_Popup_Page();
		waitTime(driver);

		refreshPage();

		// Verify the Project Ending in Filter for Ruddr Projects Page Test
		waitTime2(driver);
		grep.testCreate("Verify the Project Ending in Filter for Ruddr Projects Page Test",
				"Project Ending in Filter for ruddr projects");

		waitTime(driver);
		grep.infoTest("Validating Project Ending In Filter for Ruddr Projects");
		logger.info("Validating Project Ending In Filter for Ruddr Projects");
		waitTime(driver);
		logger.info("Selecting " + dataKeys.ruddrProject + " Project Type Option");
		grep.infoTest("Selecting " + dataKeys.ruddrProject + " Project Type Option");
		waitTime(driver);
		csatProject.selectProjectFilterOption(dataKeys.ruddrProject);
		waitTime5(driver);
		csatProject.verifyProjectSelectedOption(dataKeys.ruddrProject);

		waitTime(driver);
		csatProject.verifyEndingDaysSelectedOption(dataKeys.projectEndingIn);
		validAssert.verifyEndingDayFilters(dataKeys.days_60);
		validAssert.verifyEndingDayFilters(dataKeys.days_7);
		csatProject.selectEndingDaysFilterOption(dataKeys.projectEndingIn);

//		Verify the Available Buttons for Ruddr Projects Page Test
		grep.testCreate("Verify the Available Buttons for Ruddr Projects Page Test",
				"Available Buttons for ruddr projects");

		grep.infoTest("Validating Available Button for Ruddr Projects");
		logger.info("Validating Available Button for Ruddr Projects");
		waitTime(driver);

		grep.infoTest("Verify Add Contacts button");
		logger.info("Verify Add Contacts button");
		csatProject.verifyRuddrButton(dataKeys.addContactBtn);
		grep.infoTest("Verify Edit Contacts button");
		logger.info("Verify Edit Contacts button");
		csatProject.verifyRuddrButton(dataKeys.editContactBtn);
		grep.infoTest("Verify Send button");
		logger.info("Verify Send button");
		csatProject.verifyRuddrButton(dataKeys.sendProjectBtn);
		waitTime(driver);

//		Verify the Pagination Functionality for Ruddr Projects Page Test
		grep.testCreate("Verify the Pagination Functionality for Ruddr Projects Page Test",
				"Pagination Functionality for ruddr projects");

		grep.infoTest("Validating Pagination Functionality for Ruddr Projects");
		logger.info("Validating Pagination Functionality for Ruddr Projects");

		waitTime(driver);
		logger.info("Selecting Pagination 5");
		grep.infoTest("Selecting Pagination 5");
		csatProject.selectPagination("5");
		csatProject.verifyPaginationSelectedOption("5");
		waitTime3(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 5", "pagination_5");
		waitTime3(driver);
		logger.info("Selecting Pagination 50");
		grep.infoTest("Selecting Pagination 50");
		csatProject.selectPagination("50");
		csatProject.verifyPaginationSelectedOption("50");
		waitTime3(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 50", "pagination_50");
		waitTime3(driver);

		logger.info("Selecting Pagination 100");
		grep.infoTest("Selecting Pagination 100");
		csatProject.selectPagination("100");
		csatProject.verifyPaginationSelectedOption("100");
		waitTime3(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 100", "pagination_100");
		waitTime3(driver);

		// Verify Projects Popup
		grep.testCreate("Verify Project Popup is displayed with valid header and columns Ruddr Projects Test",
				" Project Popup is displayed with valid header and columnsfor ruddr projects");

		grep.infoTest("Validating Project Popup is displayed with valid header and columns for ruddr projects");
		logger.info("Validating Project Popup is displayed with valid header and columns for ruddr projects");

		waitTime(driver);

		grep.infoTest("Verifying Infineon_Scrum Master_0525_1125 Popup ");
		logger.info("Verifying Infineon_Scrum Master_0525_1125 Popup ");
		waitTime1(driver);
		csatProject.clickButton(dataKeys.Infineon_Scrum_Master_Project);

		waitTime2(driver);
		csatProject.ruddrProjectHeaderValidation(dataKeys.Infineon_Scrum_Master_Project);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_MemberName);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_MemberRole);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_Project_Name);
		waitTime1(driver);
		grep.captureScreenshot("pass", "Verifying Infineon_Scrum Master_0525_1125 Popup ",
				"Infineon_Scrum_Master_Popup");
		waitTime(driver);
		csatProject.clickCloseRuddrPopupBtn();
		waitTime(driver);

		grep.infoTest("Verifying Dayforce - Netsuite Phase 1 Popup ");
		logger.info("Verifying Dayforce - Netsuite Phase 1 Popup ");

		waitTime1(driver);
		csatProject.clickButton(dataKeys.DayforceNetsuitePhase_Project);

		waitTime2(driver);
		csatProject.ruddrProjectHeaderValidation(dataKeys.DayforceNetsuitePhase_Project);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_MemberName);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_MemberRole);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_Project_Name);
		waitTime1(driver);
		grep.captureScreenshot("pass", "Verifying Dayforce - Netsuite Phase Popup ", "Dayforce_Netsuite_Phase_Popup");
		waitTime(driver);
		csatProject.clickCloseRuddrPopupBtn();
		waitTime(driver);

		grep.infoTest("Verifying Notice Period Activities Popup ");
		logger.info("Verifying Notice Period Activities Popup ");

		waitTime1(driver);
		csatProject.clickButton(dataKeys.noticePeriod_Project);

		waitTime2(driver);
		csatProject.ruddrProjectHeaderValidation(dataKeys.noticePeriod_Project);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_MemberName);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_MemberRole);
		csatProject.ruddrProjectColumnValidation(dataKeys.col_Project_Name);
		waitTime1(driver);
		grep.captureScreenshot("pass", "Verifying Notice Period Activities Popup ", "Notice_Period_Activities_Popup");
		waitTime(driver);
		csatProject.clickCloseRuddrPopupBtn();
		waitTime(driver);

		// Enter invalid email format in customer email field in add contact popup
		grep.testCreate("Verify invalid email format in customer email field in add contact popup Ruddr Projects Test",
				" Invalid email format in customer email field in add contact popup for ruddr projects");

		grep.infoTest(
				"Validating Invalid email format in customer email field in add contact popup for ruddr projects");
		logger.info("Validating Invalid email format in customer email field in add contact popup for ruddr projects");

		waitTime(driver);

		grep.infoTest("Entering Invalid Customer Email :" + dataKeys.customerContactInvalidEmail);
		logger.info("Entering Invalid Customer Email :" + dataKeys.customerContactInvalidEmail);
		waitTime(driver);
		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactInvalidEmail);

		waitTime(driver);
		csatProject.verifyButtonDisable(dataKeys.saveBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "Entering Invalid Email Format in add contacts page",
				"AddCont_RuddrProject_InvalidEmailformat");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Enter invalid characters in customer name field in add contact popup
		grep.testCreate("Verify invalid characters in customer name field in add contact popup Ruddr Projects Test",
				" Invalid characters in customer name field in add contact popup for ruddr projects");

		grep.infoTest("Validating Invalid characters in customer name field in add contact popup for ruddr projects");
		logger.info("Validating Invalid characters in customer name field in add contact popup for ruddr projects");

		waitTime(driver);
		grep.infoTest("Entering Invalid characters in customer name :" + dataKeys.invalidName);
		logger.info("Entering Invalid characters in customer name :" + dataKeys.invalidName);
		waitTime(driver);
		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.invalidName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);

		csatProject.verifyButtonDisable(dataKeys.saveBtn);

		grep.captureScreenshot("pass", "Entering Invalid Name in add contacts page",
				"AddCont_RuddrProject_InvalidName");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Enter Only Space characters in customer name field in add contact popup
		grep.testCreate("Verify adding only spaces in customer name field in add contact popup Ruddr Projects Test",
				" Adding only spaces in customer name field in add contact popup for ruddr projects");

		grep.infoTest("Validating adding only spaces in customer name field in add contact popup for ruddr projects");
		logger.info("Validating adding only spaces in customer name field in add contact popup for ruddr projects");

		waitTime(driver);

		grep.infoTest("Entering Only Spaces in customer name :" + dataKeys.spacesInName);
		logger.info("Entering Only Spaces in customer name :" + dataKeys.spacesInName);
		waitTime(driver);
		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.spacesInName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);

		csatProject.verifyButtonDisable(dataKeys.saveBtn);

		grep.captureScreenshot("pass", "Entering Only Spacesin Name for add contacts page",
				"AddCont_RuddrProject_SpacesInName");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Add duplicate customer contact in Add new contact popup
		grep.testCreate("Verify the Add Duplicate Customer Contact for Ruddr Projects Test",
				" Add Duplicate Customer Contact for ruddr projects");

		grep.infoTest("Validating Add Duplicate Customer Contact for Ruddr Projects");
		logger.info("Validating Add Duplicate Customer Contact for Ruddr Projects");

		waitTime(driver);

		grep.infoTest("Entering Duplicate Customer contact");
		logger.info("Entering  Duplicate Customer contact");
		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		waitTime(driver);
		csatProject.addNewCustomerContactBtn();
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		waitTime(driver);
		csatProject.verifyButtonDisable(dataKeys.saveBtn);

		grep.captureScreenshot("pass", "Avoid Entering Duplicate contacts for add contacts page",
				"AddCont_RuddrProject_DuplicateContacts");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Enter invalid email format in customer email field in edit contact popup
		grep.testCreate("Verify invalid email format in customer email field in edit contact popup Ruddr Projects Test",
				" Invalid email format in customer email field in edit contact popup for ruddr projects");

		grep.infoTest(
				"Validating Invalid email format in customer email field in edit contact popup for ruddr projects");
		logger.info("Validating Invalid email format in customer email field in edit contact popup for ruddr projects");

		waitTime(driver);
		grep.infoTest("Updating Invalid Customer Email :" + dataKeys.customerContactInvalidEmail);
		logger.info("Updating Invalid Customer Email :" + dataKeys.customerContactInvalidEmail);
		waitTime(driver);
		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.editContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactInvalidEmail);

		csatProject.verifyButtonDisable(dataKeys.saveBtn);

		grep.captureScreenshot("pass", "Entering Invalid Email Format in edit contacts page",
				"EditCont_RuddrProject_InvalidEmailformat");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Enter invalid characters in customer name field in edit contact popup
		grep.testCreate("Verify invalid characters in customer name field in edit contact popup Ruddr Projects Test",
				" Invalid characters in customer name field in edit contact popup for ruddr projects");

		grep.infoTest("Validating Invalid characters in customer name field in edit contact popup for ruddr projects");
		logger.info("Validating Invalid characters in customer name field in edit contact popup for ruddr projects");

		waitTime(driver);
		grep.infoTest("Updating Invalid Characters in customer name :" + dataKeys.invalidName);
		logger.info("Updating Invalid Characters in customer name :" + dataKeys.invalidName);
		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.editContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.invalidName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);

		csatProject.verifyButtonDisable(dataKeys.saveBtn);

		grep.captureScreenshot("pass", "Entering Invalid Name in edit contacts page",
				"EditCont_RuddrProject_InvalidName");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Enter Only Space characters in customer name field in edit contact popup
		grep.testCreate("Verify adding only spaces in customer name field in edit contact popup Ruddr Projects Test",
				" Adding only spaces in customer name field in edit contact popup for ruddr projects");

		grep.infoTest("Validating adding only spaces in customer name field in edit contact popup for ruddr projects");
		logger.info("Validating adding only spaces in customer name field in edit contact popup for ruddr projects");

		waitTime(driver);
		grep.infoTest("Updating only Spaces in customer name :" + dataKeys.spacesInName);
		logger.info("Updating only Spaces in customer name :" + dataKeys.spacesInName);
		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.spacesInName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);

		csatProject.verifyButtonDisable(dataKeys.saveBtn);

		grep.captureScreenshot("pass", "Entering Only Spaces in Name for add contacts page",
				"AddCont_RuddrProject_SpacesInName");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Verify adding a new contact in edit contact popup

		grep.testCreate("Verify Adding new in edit popups for ruddr projects Test",
				" Adding new contact in edit popup for ruddr projects");

		grep.infoTest("Validating Adding new in edit popups for Ruddr Projects");
		logger.info("Validating Adding new in edit popups for Ruddr Projects");

		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.editContactBtn);
		waitTime2(driver);
		csatProject.getEditPopupWarningMessage();
		waitTime(driver);
		csatProject.insertCustomerName(dataKeys.updateCustomerName);
		csatProject.insertCustomerEmail(dataKeys.updateCustomerContactEmail);
		waitTime(driver);
		grep.infoTest("Entering Customer Name in Edit Contact :" + dataKeys.updateCustomerName);
		logger.info("Entering Customer Name in Edit Contact :" + dataKeys.updateCustomerName);
		waitTime(driver);
		grep.infoTest("Entering Customer Email in Edit Contact :" + dataKeys.updateCustomerContactEmail);
		logger.info("Entering Customer Email in Edit Contact :" + dataKeys.updateCustomerContactEmail);
		waitTime(driver);
		grep.captureScreenshot("pass", "Adding contact for Ruddr Projects",
				"EditCont_RuddrProject_BeforeAddInEditContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		waitTime5(driver);
		csatProject.clickRuddrButton(dataKeys.noticePeriod_Project, dataKeys.editContactBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "Verify Contact Not Added for Ruddr Projects",
				"EditCont_RuddrProject_AfterAddInEditContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Add customer name and email with valid data in add contact popup
		grep.testCreate("Verify the Add Valid Contact Functionality for Ruddr Projects Test",
				" Add Valid Contact Functionality for ruddr projects");

		grep.infoTest("Validating Add Valid Contact Functionality for Ruddr Projects");
		logger.info("Validating Add Valid Contact Functionality for Ruddr Projects");

		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		waitTime(driver);
		grep.infoTest("Entering Valid Customer Name :" + dataKeys.customerContactName);
		logger.info("Entering Valid Customer Name :" + dataKeys.customerContactName);
		waitTime(driver);
		grep.infoTest("Entering Valid Customer Email :" + dataKeys.customerContactEmail);
		logger.info("Entering Valid Customer Email :" + dataKeys.customerContactEmail);
		waitTime(driver);
		grep.captureScreenshot("pass", "Add Valid Contact Functionality for Ruddr Projects",
				"AddCont_RuddrProject_ValidContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		waitTime5(driver);
		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.editContactBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "After adding Valid Contact Verifying in Edit Popup",
				"EditCont_RuddrProject_AfterAddingValidContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Adding an existing contact in Add new contact popup
		grep.testCreate("Verify Adding an existing contact in Add new contact popup for Ruddr Projects Test",
				"Adding an existing contact in Add new contact popup for ruddr projects");

		grep.infoTest("Validating Adding an existing contact in Add new contact popup");
		logger.info("Validating Adding an existing contact in Add new contact popup");

		waitTime(driver);
		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.editContactBtn);
		waitTime3(driver);
		grep.captureScreenshot("pass", "verifying existing Contact in Edit Popup",
				"EditCont_RuddrProject_ExistingContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		waitTime(driver);
		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		waitTime(driver);

		grep.infoTest("Entering Existing Customer Name :" + dataKeys.customerContactName);
		logger.info("Entering Existing Customer Name :" + dataKeys.customerContactName);
		waitTime(driver);
		grep.infoTest("Entering Existing Customer Email :" + dataKeys.customerContactEmail);
		logger.info("Entering Existing Customer Email :" + dataKeys.customerContactEmail);
		waitTime(driver);
		grep.captureScreenshot("pass", "Adding existing contact in add contact popup",
				"AddCont_RuddrProject_AddExistingContact");
		waitTime(driver);
		csatProject.verifyButtonDisable(dataKeys.saveBtn);
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Verify editing (replacing) a existing customer contact in edit popup
		grep.testCreate("Verify editing (replacing) a existing customer contact in edit popups for ruddr projects Test",
				" editing (replacing) a existing customer contact in edit popup for ruddr projects");

		grep.infoTest("Validating Editing (replacing) a existing customer contact in edit popup for Ruddr Projects");
		logger.info("Validating Editing (replacing) a existing customer contact in edit popup for Ruddr Projects");

		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.editContactBtn);
		waitTime2(driver);
		grep.captureScreenshot("pass", "Before Editing Contact", "EditCont_RuddrProject_BeforeEditContact");
		waitTime2(driver);
		csatProject.clearCustomerName();
		waitTime2(driver);
		csatProject.clearCustomerEmail();
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.updateCustomerName);
		csatProject.insertCustomerEmail(dataKeys.updateCustomerContactEmail);
		waitTime(driver);
		grep.infoTest("Replacing Customer Name :" + dataKeys.updateCustomerName);
		logger.info("Replacing Customer Name :" + dataKeys.updateCustomerName);
		waitTime(driver);
		grep.infoTest("Replacing Customer Email :" + dataKeys.updateCustomerContactEmail);
		logger.info("Replacing Customer Email :" + dataKeys.updateCustomerContactEmail);
		waitTime(driver);
		grep.captureScreenshot("pass", "After editing the contact for Ruddr Projects",
				"EditCont_RuddrProject_AfterEditContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		waitTime5(driver);

		// Try to delete customer contact when only one contact is available in edit
		// customer popup
		grep.testCreate(
				"Verify Try to delete customer contact when only one contact is available in edit customer popup for Ruddr Projects Test",
				"Try to delete customer contact when only one contact is available in edit customer popup for ruddr projects");

		grep.infoTest(
				"Validating Try to delete customer contact when only one contact is available in edit customer popup for Ruddr Projects");
		logger.info(
				"Validating Try to delete customer contact when only one contact is available in edit customer popup for Ruddr Projects");

		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.editContactBtn);
		waitTime(driver);
		csatProject.verifyDeleteDisable();
		grep.captureScreenshot("pass", "Delete button is Disabled", "EditCont_RuddrProject_DeleteDisable");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Adding an new contact in Add contact popup
		grep.testCreate("Verify Adding an new contact in Add contact popup Test",
				" Adding an new contact in Add contact popup");

		grep.infoTest("Validating Adding an new contact in Add contact popup");
		logger.info("Validating Adding an new contact in Add contact popup");

		waitTime2(driver);
		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.editContactBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "verifying existing Contact in Edit Popup",
				"EditCont_RuddrProject_verifyExistingContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		waitTime(driver);
		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.addContactBtn);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		waitTime(driver);
		grep.infoTest("Entering Customer Name :" + dataKeys.customerContactName);
		logger.info("Entering Customer Name :" + dataKeys.customerContactName);
		waitTime(driver);
		grep.infoTest("Entering Customer Email :" + dataKeys.customerContactEmail);
		logger.info("Entering Customer Email :" + dataKeys.customerContactEmail);
		waitTime(driver);
		grep.captureScreenshot("pass", "Adding new contact in add contact popup", "AddCont_RuddrProject_AddNewContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		waitTime10(driver);

		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.editContactBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "After adding New Contact Add Popup",
				"EditCont_RuddrProject_AfterAddingNewContact");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Delete customer contact in edit popup
		grep.testCreate("Verify Delete customer contact in edit popup for Ruddr Projects Test",
				" Delete customer contact in edit popup for ruddr projects");

		grep.infoTest("Validating Delete customer contact in edit popup for Ruddr Projects");
		logger.info("Validating Delete customer contact in edit popup for Rudddr Projects");

		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.editContactBtn);
		waitTime(driver);
		csatProject.deleteCustomerContactInRuddr();

		waitTime2(driver);
		grep.captureScreenshot("pass", "Deleting Contact from edit Popup", "EditCont_RuddrProject_DeletingContact");
		waitTime2(driver);
		grep.infoTest("Deleting Customer");
		logger.info("Deleting Customer");
		waitTime(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		waitTime5(driver);

		// Verify the send functions correctly in the Ruddr projects
		grep.testCreate("Verify the send functions correctly in the Ruddr Project Test",
				" Send functions correctly in the Ruddr project");

		grep.infoTest("Validating Send functions correctly in the Ruddr project");
		logger.info("Validating Send functions correctly in the Ruddr project");

		waitTime(driver);

		csatProject.clickRuddrButton(dataKeys.DayforceNetsuitePhase_Project, dataKeys.sendProjectBtn);
		waitTime2(driver);
		csatProject.clickSelectContact(dataKeys.selectAllContact);

		waitTime(driver);
		csatProject.selectSurveyOption(dataKeys.selectEngageSurvey);
		waitTime(driver);
		csatProject.retrieveSubjectBasedOnSurvey();
		csatProject.retrieveBodyBasedOnSurvey();

		waitTime(driver);
		grep.captureScreenshot("pass", "Send FeebBack request Popup", "SendSurveyRuddrPopup");
		csatProject.clickButton(dataKeys.cancelBtn);

		validAssert.assertAllFunction();
	}

}
