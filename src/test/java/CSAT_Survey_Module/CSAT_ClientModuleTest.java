package CSAT_Survey_Module;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Clients_Page;
import Pages.CSAT_SurveyPage;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_ClientModuleTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_ClientModuleTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_SurveyPage csat_Survey;
	CSAT_Clients_Page csat_Clients;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test(priority = 1)
	public void clients_module() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csat_Clients = new CSAT_Clients_Page();
		grep.testCreate("CSAT Clients Page UI Test", "CSAT Clients Page UI");
		waitTime1(driver);
		csatPage.navigateToPage(dataKeys.clientsUrl);
		waitTime(driver);

		grep.infoTest("Validating the Header");
		logger.info("Validating the Header");
		csat_Clients.clientHeaderValidation();

		waitTime(driver);
		logger.info("Selecting Pagination 5");
		grep.infoTest("Selecting Pagination 5");
		csat_Clients.selectPagination("5");
		csat_Clients.verifyPaginationSelectedOption("5");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 5", "Client_Pagination_5");

		logger.info("Selecting Pagination 15");
		grep.infoTest("Selecting Pagination 15");
		csat_Clients.selectPagination("15");
		csat_Clients.verifyPaginationSelectedOption("15");
		waitTime(driver);
		grep.captureScreenshot("pass", "Selecting Pagination 15", "Client_Pagination_15");

		logger.info("Selecting Pagination 10");
		grep.infoTest("Selecting Pagination 10");
		csat_Clients.selectPagination("10");
		csat_Clients.verifyPaginationSelectedOption("10");
		grep.captureScreenshot("pass", "Selecting Pagination 10", "Client_Pagination_10");
		waitTime(driver);

		waitTime(driver);
		grep.infoTest("Validating the Search in Clients Page");
		logger.info("Validating the Client");
		waitTime(driver);

		grep.testCreate("CSAT Clients Page Search Test", "CSAT Clients Page Search");
		waitTime(driver);

		logger.info("Search for existing client");
		grep.infoTest("Search for existing client");
		waitTime(driver);
		csat_Clients.searchClient(dataKeys.aaa_Client);
		csat_Clients.clientTableValidation(dataKeys.aaa_Client);
		grep.captureScreenshot("pass", "Search existing Client", "Client_Search");
		csat_Clients.clearSearchClient();

		logger.info("Search for non existing client");
		grep.infoTest("Search for non existing client");
		waitTime(driver);
		csat_Clients.searchClient(dataKeys.invalidName);
		csat_Clients.clientTableValidation(dataKeys.invalidName);
		grep.captureScreenshot("pass", "Search non existing Client", "Client_NonExisting_Search");
		csat_Clients.clearSearchClient();

		// Entering Only Spaces in Owner name and email field for add Owner Test
		grep.testCreate("Entering Only Spaces in Owner name and email field for add Owner Test",
				"Entering Only Spaces in Owner name and email field");
		waitTime(driver);
		grep.infoTest("Entering Only Spaces characters in Owner name field");
		logger.info("Entering Only Spaces characters in Owner name field");
		waitTime(driver);
		csat_Clients.clickClientActionBtn(dataKeys.aaa_Client, dataKeys.addOwner_btn);
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.spacesInName);
		csat_Clients.insertOwnerEmail(dataKeys.spacesInName);
		waitTime1(driver);
		csat_Clients.clickPopupBtns(dataKeys.saveBtn);
		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Only Spaces in owner name and email field",
				"spaces_in_OwnerFields_AddOwner");
		waitTime2(driver);

		// Entering invalid owner name in add owner
		grep.testCreate("Entering Invalid Characters in Owner name field for add Owner Test",
				"Entering Invalid Characters in Owner name field");
		waitTime(driver);
		grep.infoTest("Entering Invalid Characters in Owner name field");
		logger.info("Entering Invalid Characters in Owner name field");
		waitTime(driver);
		csat_Clients.clearOwnerName();
		csat_Clients.clearOwnerEmail();
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.invalidName);
		csat_Clients.insertOwnerEmail(dataKeys.ownerContactEmail);
		waitTime1(driver);
		csat_Clients.verifyPopupBtnDisable(dataKeys.saveBtn);
//		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Invalid Characters in Owner name field", "invalid_in_OwnerName_AddOwner");
		waitTime2(driver);

		// Entering invalid owner Email in add owner
		grep.testCreate("Entering Invalid Characters in Owner email field for add Owner Test",
				"Entering Invalid Characters in Owner email field");
		waitTime(driver);
		grep.infoTest("Entering Invalid Characters in Owner email field");
		logger.info("Entering Invalid Characters in Owner email field");
		waitTime(driver);
		csat_Clients.clearOwnerName();
		csat_Clients.clearOwnerEmail();
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.addOwnerContactName);
		csat_Clients.insertOwnerEmail(dataKeys.invalidName);
		waitTime1(driver);
		csat_Clients.verifyPopupBtnDisable(dataKeys.saveBtn);
//		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Invalid Characters in Owner email field",
				"invalid_in_OwnerEmail_AddOwner");
		waitTime2(driver);

		// Entering Duplicate owner contact in add owner
		grep.testCreate("Entering Duplicate owner contact in add Owner Test", "Entering Duplicate owner contact ");
		waitTime(driver);
		grep.infoTest("Entering Duplicate owner contacts");
		logger.info("Entering Duplicate owner contacts");
		waitTime(driver);
		csat_Clients.clearOwnerName();
		csat_Clients.clearOwnerEmail();
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.addOwnerContactName);
		csat_Clients.insertOwnerEmail(dataKeys.ownerContactEmail);
		waitTime1(driver);
		csat_Clients.clickAddOwnerBtn();
		waitTime2(driver);
		csat_Clients.insertOwnerName(dataKeys.addOwnerContactName);
		csat_Clients.insertOwnerEmail(dataKeys.ownerContactEmail);

		csat_Clients.verifyPopupBtnDisable(dataKeys.saveBtn);
//		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Duplicate Owner details in add popup", "duplicate_OwnenDetails_AddOwner");
		waitTime2(driver);
		csat_Clients.clickPopupBtns(dataKeys.cancelBtn);

		// Add owner contact in add owner
		grep.testCreate("Adding owner contact using add Owner Test", "Adding owner contact using add Owner");
		waitTime(driver);
		grep.infoTest("Before Adding owner contact using add Owner popup");
		logger.info("Before Adding owner contact using add Owner popup");
		waitTime(driver);
		csat_Clients.getAccountDetails(dataKeys.aaa_Client);
		waitTime(driver);
		csat_Clients.clickClientActionBtn(dataKeys.aaa_Client, dataKeys.addOwner_btn);
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.addOwnerContactName);
		csat_Clients.insertOwnerEmail(dataKeys.ownerContactEmail);
		waitTime1(driver);

		grep.captureScreenshot("pass", "Adding owner contact using add Owner popup", "addNew_OwnenDetails_AddOwner");
		waitTime2(driver);
		csat_Clients.clickPopupBtns(dataKeys.saveBtn);
		waitTime5(driver);
		grep.captureScreenshot("pass", "After Adding owner contact using add Owner popup",
				"after_addNew_OwnenDetails_AddOwner");
		grep.infoTest("After Adding owner contact using add Owner popup");
		logger.info("After Adding owner contact using add Owner popup");
		waitTime(driver);

		csat_Clients.getAccountDetails(dataKeys.aaa_Client);
		waitTime2(driver);

		// Verify Delete button Disabled for having single contact
		grep.testCreate(
				"Verify Try to delete owner contact when only one contact is available in edit owner in clients Test",
				"Verify Try to delete owner contact when only one contact is available in edit owner");

		grep.infoTest(
				"Validating Try to delete owner contact when only one contact is available in edit owner in clients");
		logger.info(
				"Validating Try to delete owner contact when only one contact is available in edit owner in clients");

		waitTime(driver);

		csat_Clients.clickClientActionBtn(dataKeys.accenture_Client, dataKeys.editOwner_btn);
		waitTime(driver);
		csat_Clients.deleteOwnerContactBtn_Disabled();
		grep.captureScreenshot("pass", "Delete button is Disabled", "EditCont_CLients_DeleteDisable");
		waitTime(driver);
		csat_Clients.clickPopupBtns(dataKeys.cancelBtn);
		waitTime2(driver);

		// Entering Only Spaces in Owner name and email field for edit Owner Test
		grep.testCreate("Entering Only Spaces in Owner name and email field for edit Owner Test",
				"Entering Only Spaces in Owner name and email field");
		waitTime(driver);
		grep.infoTest("Entering Only Spaces characters in Owner name field");
		logger.info("Entering Only Spaces characters in Owner name field");
		waitTime(driver);
		csat_Clients.clickClientActionBtn(dataKeys.aaa_Client, dataKeys.editOwner_btn);
		waitTime(driver);
		csat_Clients.clearOwnerName();
		csat_Clients.clearOwnerEmail();
		waitTime(driver);

		csat_Clients.insertOwnerName(dataKeys.spacesInName);
		csat_Clients.insertOwnerEmail(dataKeys.spacesInName);
		waitTime1(driver);
		csat_Clients.clickPopupBtns(dataKeys.saveBtn);
		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Only Spaces in owner name and email field",
				"spaces_in_OwnerFields_EditOwner");
		waitTime2(driver);

		// Entering invalid owner name in add owner
		grep.testCreate("Entering Invalid Characters in Owner name field for Edit Owner Test",
				"Entering Invalid Characters in Owner name field");
		waitTime(driver);
		grep.infoTest("Entering Invalid Characters in Owner name field");
		logger.info("Entering Invalid Characters in Owner name field");
		waitTime(driver);
		csat_Clients.clearOwnerName();
		csat_Clients.clearOwnerEmail();
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.invalidName);
		csat_Clients.insertOwnerEmail(dataKeys.ownerContactEmail);
		waitTime1(driver);
		csat_Clients.verifyPopupBtnDisable(dataKeys.saveBtn);
//		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Invalid Characters in Owner name field",
				"invalid_in_OwnerName_EditOwner");
		waitTime2(driver);

		// Entering invalid owner Email in add owner
		grep.testCreate("Entering Invalid Characters in Owner email field for Edit Owner Test",
				"Entering Invalid Characters in Owner email field");
		waitTime(driver);
		grep.infoTest("Entering Invalid Characters in Owner email field");
		logger.info("Entering Invalid Characters in Owner email field");
		waitTime(driver);
		csat_Clients.clearOwnerName();
		csat_Clients.clearOwnerEmail();
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.updateOwnerContactName);
		csat_Clients.insertOwnerEmail(dataKeys.invalidName);
		waitTime1(driver);
		csat_Clients.verifyPopupBtnDisable(dataKeys.saveBtn);
//		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Invalid Characters in Owner email field",
				"invalid_in_OwnerEmail_EditOwner");
		waitTime2(driver);

		// Entering Duplicate owner contact in edit owner
		grep.testCreate("Entering Duplicate owner contact in edit Owner Test", "Entering Duplicate owner contact ");
		waitTime(driver);
		grep.infoTest("Entering Duplicate owner contacts");
		logger.info("Entering Duplicate owner contacts");
		waitTime(driver);
		csat_Clients.clearOwnerName();
		csat_Clients.clearOwnerEmail();
		waitTime(driver);
		csat_Clients.insertOwnerName(dataKeys.duplicateQwnerContactName);
		csat_Clients.insertOwnerEmail(dataKeys.duplicateOwnerContactEmail);
		waitTime(driver);
		csat_Clients.verifyPopupBtnDisable(dataKeys.saveBtn);
//		csat_Clients.getCustomerEmailError();
		grep.captureScreenshot("pass", "Enter Duplicate Owner details in add popup",
				"duplicate_OwnenDetails_EditOwner");
		waitTime2(driver);
		csat_Clients.clickPopupBtns(dataKeys.cancelBtn);

		// Update owner contact in add owner
		grep.testCreate("Update owner contact using edit Owner Test", "Update owner contact using edit Owner");
		waitTime(driver);
		grep.infoTest("Before Updating owner contact using Edit Owner popup");
		logger.info("Before Updating owner contact using Edit Owner popup");
		waitTime(driver);
		csat_Clients.getAccountDetails(dataKeys.aaa_Client);
		waitTime(driver);
		csat_Clients.clickClientActionBtn(dataKeys.aaa_Client, dataKeys.editOwner_btn);
		waitTime2(driver);
		grep.captureScreenshot("pass", "Before Updating owner contact using edit Owner popup",
				"Before_update_OwnerDetails_EditOwner_popup");
		csat_Clients.insertOwnerName(dataKeys.updateOwnerContactName);
		csat_Clients.insertOwnerEmail(dataKeys.ownerContactEmail);
		waitTime1(driver);

		grep.captureScreenshot("pass", "After Updating owner contact using edit Owner popup",
				"after_update_OwnenDetails_EditOwner_Popup");
		waitTime2(driver);
		csat_Clients.clickPopupBtns(dataKeys.saveBtn);
		waitTime5(driver);
		grep.captureScreenshot("pass", "After Updating owner contact using Edit Owner popup",
				"after_Updating_OwnerDetails_EditOwner");
		grep.infoTest("After Updating owner contact using Edit Owner popup");
		logger.info("After Updating owner contact using Edit Owner popup");
		waitTime(driver);

		csat_Clients.getAccountDetails(dataKeys.aaa_Client);
		waitTime2(driver);
	}

	@Test(priority = 2)
	public void sendSurveyTo_Client() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csat_Survey = new CSAT_SurveyPage();

		waitTime(driver);
		csatPage.navigateToPage(dataKeys.survey_Url);
		waitTime(driver);
		// send survey to customer
		grep.testCreate("Send Survey to client using send survey Send Test", "Send Survey to client using send survey");
		waitTime(driver);
		grep.infoTest("Send Survey to client using send survey Send");
		logger.info("Send Survey to client using send survey Send");
		waitTime(driver);

		csat_Survey.selectActionFromSurveyTable(dataKeys.selectEngageSurvey, dataKeys.sendProjectBtn);
		waitTime(driver);
		csat_Clients.selectClientToSendSurvey(dataKeys.aaa_Client);
		csat_Clients.selectClientOwnerContact(dataKeys.updateOwnerContactName);
		waitTime(driver);
		csat_Clients.retrieveSubjectBasedOnSurvey();
		csat_Clients.retrieveBodyBasedOnSurvey();
		waitTime(driver);

		csat_Clients.clickPopupBtns(dataKeys.sendProjectBtn);
		waitTime15(driver);

		waitTime(driver);
		csatPage.navigateToPage(dataKeys.clientsUrl);
		waitTime(driver);
		// delete customer contact
		grep.testCreate("Delete owner contact in edit Owner Test", "Delete owner contact in edit Owner");
		waitTime(driver);
		grep.infoTest("Before Deleting owner contact using Edit Owner popup");
		logger.info("Before Deleting owner contact using Edit Owner popup");
		waitTime(driver);
		csat_Clients.getAccountDetails(dataKeys.aaa_Client);
		waitTime(driver);
		csat_Clients.clickClientActionBtn(dataKeys.aaa_Client, dataKeys.editOwner_btn);
		waitTime2(driver);
		grep.captureScreenshot("pass", "Before Deleting owner contact using edit Owner popup",
				"Before_delete_OwnerDetails_EditOwner_popup");
		csat_Clients.deleteOwnerContactBtn();
		waitTime1(driver);

		grep.captureScreenshot("pass", "After Deleting owner contact using edit Owner popup",
				"after_delete_OwnenDetails_EditOwner_Popup");
		waitTime2(driver);
		csat_Clients.clickPopupBtns(dataKeys.saveBtn);
		csat_Clients.getSuccessMsg();
		waitTime5(driver);
		grep.captureScreenshot("pass", "After Deleting owner contact using Edit Owner popup",
				"after_Deleting_OwnerDetails_EditOwner");
		grep.infoTest("After Deleting owner contact using Edit Owner popup");
		logger.info("After Deleting owner contact using Edit Owner popup");
		waitTime(driver);

		csat_Clients.getAccountDetails(dataKeys.aaa_Client);
		waitTime2(driver);

	}

}
