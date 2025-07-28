package CSAT_Reports_Module;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Reports_Page;
import Pages.CSAT_Survey_AllPages;
import Pages.LoginPage;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_ReportsTest extends CSAT_TestInitializer {

	private static final Logger logger = LogManager.getLogger(CSAT_ReportsTest.class);
	GenerateReports grep = new GenerateReports();
	CSAT_Survey_AllPages csatPage;
	CSAT_Reports_Page csatReports;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void reportsPageTest() throws Exception {

		csatPage = new CSAT_Survey_AllPages();
		csatReports = new CSAT_Reports_Page();

		csatPage.navigateToPage(dataKeys.reports_Url);
		waitTime3(driver);

		// Validating the Development Project Reports
		grep.testCreate("Validating the CSAT Development Project Report Test",
				"Validating the Development Project Report");
		waitTime(driver);

		logger.info("Verify Profile Header");
		grep.infoTest("Verify Profile Header");
		csatReports.reportsHeaderValidation();

		logger.info("Inside CSAT Development Project");
		grep.infoTest("Inside CSAT Development Project");
		csatReports.clickDevelopment_Project();
		waitTime10(driver);
		getAllCardsValue();
		grep.captureScreenshot("pass", "Development Project Report Test", "Development_Project_Report");

		// Validating the TOD Project Reports
		grep.testCreate("Validating the CSAT Resource TOD Report Test", "Validating the Resource TOD Project Report");
		waitTime(driver);

		logger.info("Inside CSAT Resource TOD Project");
		grep.infoTest("Inside CSAT Resource TOD Project");
		waitTime2(driver);
		csatReports.clickResourcesTOD_Project();
		waitTime10(driver);
		waitTime(driver);
		csatReports.getResources_OverAllCSAT_CardValue();
		waitTime(driver);
		csatReports.getResources_Promoters_CardValue();
		waitTime(driver);
		csatReports.getResources_Neutral_CardValue();
		waitTime(driver);
		csatReports.getResources_Detractors_CardValue();
		waitTime(driver);
		csatReports.getResources_ResponseCount_CardValue();
		waitTime(driver);
		grep.captureScreenshot("pass", "Resource TOD Project Report Test", "Resource_TOD_Project_Report");

		// Validating the AMS Project Reports
		grep.testCreate("Validating the CSAT AMS Project Report Test", "Validating the AMS Project Report");
		waitTime(driver);

		logger.info("Inside CSAT AMS Project");
		grep.infoTest("Inside CSAT AMS Project");
		waitTime2(driver);
		csatReports.clickAMS_Project();
		waitTime10(driver);
		getAllCardsValue();
		grep.captureScreenshot("pass", "AMS Project Report Test", "AMS_Project_Report");

		// Validating the Engagement Project Reports
		grep.testCreate("Validating the CSAT Engagement Level Project Report Test",
				"Validating the Engagement Level  Project Report");
		waitTime(driver);

		logger.info("Inside CSAT Engagement Level Project");
		grep.infoTest("Inside CSAT Engagement Level Project");
		waitTime2(driver);
		csatReports.clickEnagement_Project();
		waitTime10(driver);
		getAllCardsValue();
		grep.captureScreenshot("pass", "Engagement Level Project Report Test", "EngagementLevel_Project_Report");

		// DOWNLOADING FILES
		waitTime(driver);
		grep.testCreate("Reports Page Download Functionality Test", "Reports Page Download Functionality");
		waitTime(driver);
		csatReports.clickDevelopment_Project();
		waitTime10(driver);

		logger.info("Click Entire Dashboard Download Button");
		grep.infoTest("Click Entire Dashboard Download Button");
		csatReports.clickDownloadEntireDashboardBtn();
		waitTime(driver);
		grep.captureScreenshot("pass", "Download Entire Dashboard", "downloadEntireDashboard_In_Reports");
		waitTime(driver);
		logger.info("Download CSV File Format ");
		grep.infoTest("Download CSV File Format ");
		csatReports.clickDownloadProject_FileBtn(dataKeys.csvFormat);
		grep.captureScreenshot("pass", "Download CSV", "Reports_CSVFormat");
		waitTime5(driver);
		logger.info("Download PDF File Format ");
		grep.infoTest("Download PDF File Format ");
		csatReports.clickDownloadProject_FileBtn(dataKeys.pdfFormat);
		waitTime5(driver);
		grep.captureScreenshot("pass", "Download PDF", "Report_PDFFormat");

		// SHARE REPORT TEST
		waitTime(driver);
		grep.testCreate("Sharing Report Functionality Test", "Sharing Reports Functionality");
		waitTime(driver);
		logger.info("Sharing Report to Customer");
		grep.infoTest("Sharing report To Customer");
		waitTime(driver);
		csatReports.clickShareBtn();
		waitTime(driver);
		csatReports.selectEmailToSend(dataKeys.ssoUserName);
		waitTime15(driver);
		csat_CustomerReport();
		waitTime(driver);
	}

	public void csat_CustomerReport() throws Exception {
		csatReports = new CSAT_Reports_Page();
		LoginPage login = new LoginPage();

		// Send Survey Report
		waitTime2(driver);
//		grep.testCreate("Login to Customer account Test", "Login to Customer account");
//		waitTime(driver);

		clickNewTab();
		switchToLastTab();
		waitTime2(driver);
		enterURL(dataKeys.url);

		login.clickUseAnotherAccount();
		login.enterUserName(dataKeys.ssoUserName);
		login.clickSignIn();
		waitTime2(driver);
		login.enterPassword(dataKeys.ssoPassword);
		waitTime2(driver);
		login.clickSignIn();
		waitTime10(driver);

		login.clickSignInOnTop();
		waitTime2(driver);
		login.SelectProfileToLogin(dataKeys.myProfileName);

		waitTime(driver);
		grep.infoTest("Inside Customer Mail");
		logger.info("Inside Customer Mail");
		waitTime10(driver);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		waitTime(driver);
		csatReports.clickSkillSyncMail();
		waitTime3(driver);
		csatReports.getMailHeaderText();
		waitTime2(driver);
		csatReports.getMailBodyText();
		waitTime(driver);
		grep.captureScreenshot("pass", "Inside Customer Mail", "customerMail_Reports");
		waitTime(driver);
		csatReports.verifyAttachementFile();
		waitTime3(driver);
		switchToFirstTab();
		waitTime3(driver);

	}

	public void getAllCardsValue() throws Exception {
		waitTime(driver);
		csatReports.getOverAllCSAT_CardValue();
		waitTime(driver);
		csatReports.getPromoters_CardValue();
		waitTime(driver);
		csatReports.getNeutral_CardValue();
		waitTime(driver);
		csatReports.getDetractors_CardValue();
		waitTime(driver);
		csatReports.getResponseCount_CardValue();
	}
}