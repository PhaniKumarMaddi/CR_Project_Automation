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

		// Creating new project
		grep.testCreate("Verify create New Project Creation Test", "Add New Project Creation");
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
		waitTime10(driver);
		csatProject.insertStartDate(dataKeys.startDate);
		logger.info("Entering Project Start Date: " + dataKeys.startDate);
		grep.infoTest("Entering Project Start Date:" + dataKeys.startDate);
		waitTime5(driver);
		csatProject.clickButton(dataKeys.saveBtn);
		logger.info("Save Project");
		grep.infoTest("Save Project");
		waitTime(driver);

		validAssert.assertAllFunction();
	}

}
