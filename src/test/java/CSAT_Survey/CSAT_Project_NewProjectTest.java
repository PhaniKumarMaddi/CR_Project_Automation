package CSAT_Survey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Project_Page;
import Pages.CSAT_Survey_AllPages;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_Project_NewProjectTest extends CSAT_TestInitializer {
	private static final Logger logger = LogManager.getLogger(CSAT_Project_NewProjectTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Project_Page csatProject;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void csat_NewProject_Test() throws Exception {
		csatPage = new CSAT_Survey_AllPages();
		csatProject = new CSAT_Project_Page();

		// Verify mandatory Fields

		grep.testCreate("CSAT Project Page Verify mandatory Required fields in New Project Test",
				"CSAT Project Page Add New Project Mandatory Fields Test");
		waitTime(driver);
		csatPage.collapseSideMenu();
		waitTime(driver);
		logger.info("Verify keeping mandatory Fields empty ");
		grep.infoTest("Verify keeping mandatory Fields empty ");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.verifyButtonDisable(dataKeys.saveBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "Mandatory fields required", "Mandatory_Fields_Required");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);

		// Keeping one mandatory field empty

		grep.testCreate("Verify keeping one Mandatory Field empty Test", "Keeping one Mandatory Field empty");
		waitTime(driver);
		logger.info("Verify Keeping One mandatory field Empty in add Project");
		grep.infoTest("Verify Keeping One mandatory field Empty in add Project");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.newProjectName);
		logger.info("Entering Project Name: " + dataKeys.newProjectName);
		grep.infoTest("Entering Project Name:" + dataKeys.newProjectName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime(driver);
		csatProject.selectProjectStatusOption(dataKeys.pipelineStatusOption);
		logger.info("Entering Project Status: " + dataKeys.pipelineStatusOption);
		grep.infoTest("Entering Project Status:" + dataKeys.pipelineStatusOption);
		waitTime(driver);
		csatProject.selectProjectTypeOption(dataKeys.projectType_Development);
		logger.info("Entering Project Type: " + dataKeys.projectType_Development);
		grep.infoTest("Entering Project Type:" + dataKeys.projectType_Development);
		waitTime(driver);
		csatProject.insertProjectDescription(dataKeys.projectDesc);
		logger.info("Entering Project Description: " + dataKeys.projectDesc);
		grep.infoTest("Entering Project Description:" + dataKeys.projectDesc);
		waitTime(driver);

		csatProject.insertCustomerName(dataKeys.customerContactName);
		logger.info("Entering Customer Name: " + dataKeys.customerContactName);
		grep.infoTest("Entering Customer Name:" + dataKeys.customerContactName);
		waitTime(driver);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		logger.info("Entering Customer Email: " + dataKeys.customerContactEmail);
		grep.infoTest("Entering Customer Email:" + dataKeys.customerContactEmail);
		waitTime5(driver);
		csatProject.verifyButtonDisable(dataKeys.saveBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "Keeping one Mandatory field empty", "One_Mandatory_Field_Empty");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Invalid Characters in project name
		grep.testCreate("Verify adding invalid characters in project name Test",
				"Adding invalid chracters in project name ");
		waitTime(driver);
		logger.info("Verify adding invalid characters in project name Test");
		grep.infoTest("Verify adding invalid characters in project name Test");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.invalidName);
		logger.info("Entering Project Name: " + dataKeys.invalidName);
		grep.infoTest("Entering Project Name:" + dataKeys.invalidName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime(driver);

		logger.info("Verify the error message ");
		grep.infoTest("Verify the error message ");
		csatProject.projectNameError();

		grep.captureScreenshot("pass", "Entering Invalid project name", "Invalid_ProjectName");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Entering Only Space Character in project name
		grep.testCreate("Verify adding only Space character in project name Test",
				"Adding only Space character in project name ");
		waitTime(driver);
		logger.info("Verify adding only Space character in project name Test");
		grep.infoTest("Verify adding only Space character in project name Test");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.spacesInName);
		logger.info("Entering Project Name Only Spaces :" + dataKeys.spacesInName);
		grep.infoTest("Entering Project Name Only Spaces :" + dataKeys.spacesInName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime(driver);

		logger.info("Verify the error message ");
		grep.infoTest("Verify the error message ");
		csatProject.projectNameError();

		grep.captureScreenshot("pass", "Entering only Space character project name", "Spaces_ProjectName");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// adding Invalid Characters in customer name
		grep.testCreate("Verify adding invalid customer name in project Creation Test", "Adding invalid customer name");
		waitTime(driver);
		logger.info("Verify Adding Invalid customer name");
		grep.infoTest("Verify Adding Invalid customer name");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.newProjectName);
		logger.info("Entering Project Name: " + dataKeys.newProjectName);
		grep.infoTest("Entering Project Name:" + dataKeys.newProjectName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.invalidName);
		logger.info("Entering Customer Name: " + dataKeys.invalidName);
		grep.infoTest("Entering Customer Name:" + dataKeys.invalidName);
		waitTime(driver);
		csatProject.getCustomerNameError();
		waitTime(driver);
		grep.captureScreenshot("pass", "Invalid Customer Name", "Invalid_Customer_Name");

		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// adding Spaces Characters in customer name
		grep.testCreate("Verify adding space customer name in project Creation Test", "Adding space customer name");
		waitTime(driver);
		logger.info("Verify Adding only spaces in customer name");
		grep.infoTest("Verify Adding only spaces in customer name ");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.newProjectName);
		logger.info("Entering Project Name: " + dataKeys.newProjectName);
		grep.infoTest("Entering Project Name:" + dataKeys.newProjectName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.spacesInName);
		logger.info("Entering Customer Name only spaces: " + dataKeys.spacesInName);
		grep.infoTest("Entering Customer Name only spaces:" + dataKeys.spacesInName);
		waitTime(driver);
		csatProject.getCustomerNameError();
		waitTime(driver);
		grep.captureScreenshot("pass", "Spaces Customer Name", "Space_Customer_Name");

		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// adding Invalid Email in customer email
		grep.testCreate("Verify adding invalid customer email format in project Creation Test",
				"Adding invalid customer email");
		waitTime(driver);
		logger.info("Verify Adding Invalid customer email format");
		grep.infoTest("Verify Adding Invalid customer email format");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.newProjectName);
		logger.info("Entering Project Name: " + dataKeys.newProjectName);
		grep.infoTest("Entering Project Name:" + dataKeys.newProjectName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		logger.info("Entering Customer Name: " + dataKeys.customerContactName);
		grep.infoTest("Entering Customer Name:" + dataKeys.customerContactName);
		waitTime(driver);
		csatProject.insertCustomerEmail(dataKeys.customerContactInvalidEmail);
		logger.info("Entering Customer Email: " + dataKeys.customerContactInvalidEmail);
		grep.infoTest("Entering Customer Email:" + dataKeys.customerContactInvalidEmail);
		waitTime(driver);
		csatProject.getCustomerEmailError();
		waitTime(driver);
		grep.captureScreenshot("pass", "Invalid Customer Email", "Invalid_Customer_Email");

		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// adding existing project name
		grep.testCreate("Verify using existing project name for New Project Creation Test",
				"Add existing project name for New Project Creation");
		waitTime(driver);
		logger.info("Verify Adding existing project name");
		grep.infoTest("Verify Adding existing project name");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.duplicateProjectName);
		logger.info("Entering Project Name: " + dataKeys.newProjectName);
		grep.infoTest("Entering Project Name:" + dataKeys.newProjectName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime(driver);

		logger.info("Verify the error message ");
		grep.infoTest("Verify the error message ");
		csatProject.projectNameError();

		grep.captureScreenshot("pass", "Entering existing project name", "Existing_ProjectName");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Enter an invalid characters in project description field
		grep.testCreate("Verify Entering Invalid Characters in Description Field Test",
				"Entering Invalid Characters in Description Field");
		waitTime(driver);
		logger.info("Verify Entering Invalid Characters in Description Field");
		grep.infoTest("Verify Entering Invalid Characters in Description Field");
		waitTime(driver);
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectDescription(dataKeys.invalidProjectDesc);
		waitTime(driver);
		csatProject.getDescriptionError();
		waitTime(driver);
		grep.captureScreenshot("pass", "Entering existing project name", "Existing_ProjectName");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);
		
		// Enter End Date is less than Start date new project
		grep.testCreate("Verify Entering End date Previous than Start Date Test",
				"Add End Date Previous than Start Date");
		waitTime(driver);
		logger.info("Verify Entering End Date previous than Start date");
		grep.infoTest("Verify Entering End Date previous than Start date");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.newProjectName);
		logger.info("Entering Project Name: " + dataKeys.newProjectName);
		grep.infoTest("Entering Project Name:" + dataKeys.newProjectName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime(driver);
		csatProject.selectProjectStatusOption(dataKeys.pipelineStatusOption);
		logger.info("Entering Project Status: " + dataKeys.pipelineStatusOption);
		grep.infoTest("Entering Project Status:" + dataKeys.pipelineStatusOption);
		waitTime(driver);
		csatProject.selectProjectTypeOption(dataKeys.projectType_Development);
		logger.info("Entering Project Type: " + dataKeys.projectType_Development);
		grep.infoTest("Entering Project Type:" + dataKeys.projectType_Development);
		waitTime2(driver);
		csatProject.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csatProject.insertEndDate(dataKeys.lesser_date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		waitTime(driver);
		csatProject.getEndDateError();
		waitTime(driver);
		grep.captureScreenshot("pass", "Entering End date Previous than Start Date", "EndDate_Error");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// Creating new project
		grep.testCreate("Verify Creating New Project Test", "Add New Project Creation");
		waitTime(driver);
		logger.info("Verify Creating a new Project");
		grep.infoTest("Verify Creating a new Project");
		csatProject.clickNewProject();
		waitTime(driver);
		csatProject.insertProjectName(dataKeys.newProjectName);
		logger.info("Entering Project Name: " + dataKeys.newProjectName);
		grep.infoTest("Entering Project Name:" + dataKeys.newProjectName);
		waitTime(driver);
		csatProject.selectProjectPracticeOption(dataKeys.DSandAIPractice);
		logger.info("Entering Project Practice: " + dataKeys.DSandAIPractice);
		grep.infoTest("Entering Project Practicee:" + dataKeys.DSandAIPractice);
		waitTime(driver);
		csatProject.selectProjectStatusOption(dataKeys.pipelineStatusOption);
		logger.info("Entering Project Status: " + dataKeys.pipelineStatusOption);
		grep.infoTest("Entering Project Status:" + dataKeys.pipelineStatusOption);
		waitTime(driver);
		csatProject.selectProjectTypeOption(dataKeys.projectType_Development);
		logger.info("Entering Project Type: " + dataKeys.projectType_Development);
		grep.infoTest("Entering Project Type:" + dataKeys.projectType_Development);
		waitTime2(driver);
		csatProject.insertStartDate(dataKeys.date_StartDate, dataKeys.month_StartDate, dataKeys.year_StartDate);
		waitTime5(driver);
		csatProject.insertEndDate(dataKeys.date_EndDate, dataKeys.month_EndDate, dataKeys.year_EndDate);
		waitTime1(driver);
		String startDate = csatProject.retrieveStartDate();
		logger.info("Entered Project Start Date: " + startDate);
		grep.infoTest("Entered Project Start Date:" + startDate);
		waitTime(driver);
		String endDate = csatProject.retrieveEndDate();
		logger.info("Entered Project End Date: " + endDate);
		grep.infoTest("Entered Project End Date:" + endDate);
		waitTime(driver);
		csatProject.insertProjectDescription(dataKeys.projectDesc);
		logger.info("Entering Project Description: " + dataKeys.projectDesc);
		grep.infoTest("Entering Project Description:" + dataKeys.projectDesc);
		waitTime1(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		logger.info("Entering Customer Name: " + dataKeys.customerContactName);
		grep.infoTest("Entering Customer Name:" + dataKeys.customerContactName);
		waitTime(driver);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		logger.info("Entering Customer Email: " + dataKeys.customerContactEmail);
		grep.infoTest("Entering Customer Email:" + dataKeys.customerContactEmail);
		waitTime(driver);
		grep.captureScreenshot("pass", "Creating new Project", "New_Project");
		waitTime2(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		logger.info("Save Project");
		grep.infoTest("Save Project");
		waitTime5(driver);
		
		logger.info("Project Created");
		grep.infoTest("Project  Created");
		waitTime2(driver);
		grep.captureScreenshot("pass","Project Created","ProjectCreated");
		
		// update Duplicate customer contact project
		grep.testCreate("Update duplicate customer contact test", "Update duplicate customer contact");

		waitTime(driver);
		logger.info("Update Duplicate customer contact");
		grep.infoTest("update Duplicate customer contact");
		waitTime(driver);
		csatProject.clickProjectBtn(dataKeys.duplicateProjectName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csatProject.addNewCustomerContactBtn();
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.customerContactName);
		csatProject.insertCustomerEmail(dataKeys.customerContactEmail);
		waitTime(driver);
		csatProject.getCustomerEmailErrorInUpdate();
		waitTime(driver);
		grep.captureScreenshot("pass", "Updating the existing customer email", "ExistingEmail");
		waitTime(driver);
		csatProject.clickButton(dataKeys.cancelBtn);
		waitTime(driver);

		// updating existing project

		grep.testCreate("Update customer contact to existing project test",
				"Update customer contact to existing project");

		waitTime(driver);
		logger.info("Update new customer contact to existing project");
		grep.infoTest("Update new customer contact to existing project");

		csatProject.clickProjectBtn(dataKeys.duplicateProjectName, dataKeys.editProjectBtn);
		waitTime2(driver);
		csatProject.addNewCustomerContactBtn();
		waitTime2(driver);
		csatProject.insertCustomerName(dataKeys.updateCustomerName);
		csatProject.insertCustomerEmail(dataKeys.updateCustomerContactEmail);
		//
		grep.captureScreenshot("pass", "Updating the new customer contact", "newCustomerContact");
		waitTime5(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		waitTime(driver);

		// delete customer contact

		grep.testCreate("Delete customer contact from existing project test",
				"Delete customer contact from existing project");

		waitTime(driver);
		logger.info("Delete  customer contact from existing project");
		grep.infoTest("Delete  customer contact from existing project");

		waitTime5(driver);
		csatProject.clickProjectBtn(dataKeys.duplicateProjectName, dataKeys.editProjectBtn);
		waitTime3(driver);
		csatProject.deleteCustomerContact();
		waitTime2(driver);

		grep.captureScreenshot("pass", "Delete the existing customer contact", "deleteCustomerContact");
		waitTime5(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		waitTime(driver);

		// delete existing project
		grep.testCreate("Delete existing project test", "Delete Existing project");

		waitTime(driver);
		logger.info("Delete Existing Project");
		grep.infoTest("Delete existing project");
		waitTime3(driver);
		csatProject.clickProjectBtn(dataKeys.newProjectName, dataKeys.deleteProjectBtn);
		waitTime(driver);
		grep.captureScreenshot("pass", "Deleted the project", "DeleteingProject");
		csatProject.clickButton(dataKeys.buttonYes);
		waitTime(driver);
		grep.captureScreenshot("pass", "Deleted Project not available", "afterDeletion");

		waitTime(driver);
		csatProject.verifyDeletedFromProjectNameList(dataKeys.newProjectName);

		validAssert.assertAllFunction();
	}

}
