package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class CSAT_Reports_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Reports_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Reports_Page() {
		this.driver = DriverManager.getDriver();
	}

	By reportHeader = By.xpath("//div[@class='reports-container']/h2");
	By csat_DEV_link = By.xpath("//div[@class='reports-tabs-container']/button[1]");
	By csat_TOD_link = By.xpath("//div[@class='reports-tabs-container']/button[2]");
	By csat_AMS_link = By.xpath("//div[@class='reports-tabs-container']/button[3]");
	By csat_ENGAGE_link = By.xpath("//div[@class='reports-tabs-container']/button[4]");

	By overallCSATVal = By.xpath("//div[@class='ams-card orange']/span[2]");
	By promotersVal = By.xpath("//div[@class='ams-card green']/span[2]");
	By neutralVal = By.xpath("//div[@class='ams-card blue']/span[2]");
	By detractorsVal = By.xpath("//div[@class='ams-card darkblue']/span[2]");
	By responseCountVal = By.xpath("//div[@class='ams-card purple']/span[2]");

	By overallCSATVal_resource = By.xpath("//div[@class='resource-card orange']/span[2]");
	By promotersVal_resource = By.xpath("//div[@class='resource-card green']/span[2]");
	By neutralVal_resource = By.xpath("//div[@class='resource-card blue']/span[2]");
	By detractorsVal_resource = By.xpath("//div[@class='resource-card darkblue']/span[2]");
	By responseCountVal_resource = By.xpath("//div[@class='resource-card purple']/span[2]");

	// export
	By downloadBtnAT_Cards = By.xpath("//button/img[@alt='Download Entire Dashboard']");
	By shareBtn = By.xpath("//button[@id='settings-email-wrapper']");
	By enterEmail = By.xpath("//input[@placeholder='Enter email address']");
	By selectSuggestion = By.xpath("//li[@class='suggestion-item even']/div[1]/span[1]");
	By sendPDF = By.cssSelector("div.dashboard-export-option");
	By downloadAT_ProjectWise = By.xpath("//button/img[@alt='Download']");

	By selectSurveyMail = By.xpath("//span[text()='CriticalRiver Feedback']");
	By getEmailheader = By.xpath("//div[@class='x_email-container']/div[1]/h2");
	By getEmailBody = By.xpath("//div[@class='x_email-container']/div[2]");
	By getPDF = By.xpath("//div[@class='vkChN PQeLQ QEiYT']");
	By downloadPdf = By.xpath("//span[text()='Download']");
	By closePDF = By.xpath("//button/span/i[@data-icon-name='Cancel']");

	// GET REPORTS PAGE HEADER
	public void reportsHeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(reportHeader, 30);
			String verifyHeader = driver.findElement(reportHeader).getText();
			if (verifyHeader.equals(dataKeys.reportsPage)) {
				logger.info("Header is Valid: " + verifyHeader);
				grep.passTest("Header is Valid: " + verifyHeader);
			} else {
				logger.error("Header is not Valid: " + verifyHeader);
				grep.failTest("Header is not Valid: " + verifyHeader);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// CLICK DEVELOPMENT PROJECT
	public void clickDevelopment_Project() throws Exception {

		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(csat_DEV_link).isEmpty();
			if (elementExists) {
				waitForElement(csat_DEV_link, 30);
				driver.findElement(csat_DEV_link).click();

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// CLICK RESOURCES TOD
	public void clickResourcesTOD_Project() throws Exception {

		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(csat_TOD_link).isEmpty();
			if (elementExists) {
				waitForElement(csat_TOD_link, 30);
				driver.findElement(csat_TOD_link).click();

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// CLICK AMS PROJECT
	public void clickAMS_Project() throws Exception {

		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(csat_AMS_link).isEmpty();
			if (elementExists) {
				waitForElement(csat_AMS_link, 30);
				driver.findElement(csat_AMS_link).click();

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// CLICK ENGAGEMENT LEVEL
	public void clickEnagement_Project() throws Exception {

		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(csat_ENGAGE_link).isEmpty();
			if (elementExists) {
				waitForElement(csat_ENGAGE_link, 30);
				driver.findElement(csat_ENGAGE_link).click();

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET OVERALL CSAT
	public void getOverAllCSAT_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(overallCSATVal).isEmpty();
			if (elementExists) {
				waitForElement(overallCSATVal, 30);
				String getresponse = driver.findElement(overallCSATVal).getText();
				logger.info("OverAll CSAT Card Value: " + getresponse);
				grep.passTest("OverAll CSAT Card Value: " + getresponse);
			} else {
				logger.error("OverAll CSAT Card Value Not Available");
				grep.failTest("OverAll CSAT Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET PROMOTERS
	public void getPromoters_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(promotersVal).isEmpty();
			if (elementExists) {
				waitForElement(promotersVal, 30);
				String getresponse = driver.findElement(promotersVal).getText();
				logger.info("Promoter Card Value: " + getresponse);
				grep.passTest("Promoter Card Value: " + getresponse);
			} else {
				logger.error("Promoter Card Value Not Available");
				grep.failTest("Promoter Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET NEUTRAL
	public void getNeutral_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(neutralVal).isEmpty();
			if (elementExists) {
				waitForElement(neutralVal, 30);
				String getresponse = driver.findElement(neutralVal).getText();
				logger.info("Neutral Card Value: " + getresponse);
				grep.passTest("Neutral Card Value: " + getresponse);
			} else {
				logger.error("Neutral Card Value Not Available");
				grep.failTest("Neutral Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET DECTRACTORS
	public void getDetractors_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(detractorsVal).isEmpty();
			if (elementExists) {
				waitForElement(detractorsVal, 30);
				String getresponse = driver.findElement(detractorsVal).getText();
				logger.info("Detractors Card Value: " + getresponse);
				grep.passTest("Detractors Card Value: " + getresponse);
			} else {
				logger.error("Response Count Card Value Not Available");
				grep.failTest("Response Count Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// RESPONSE COUNT
	public void getResponseCount_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(responseCountVal).isEmpty();
			if (elementExists) {
				waitForElement(responseCountVal, 30);
				String getresponse = driver.findElement(responseCountVal).getText();
				logger.info("Response Count Card Value: " + getresponse);
				grep.passTest("Response Count Card Value: " + getresponse);
			} else {
				logger.error("Response Count Card Value Not Available");
				grep.failTest("Response Count Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET OVERALL CSAT FOR RESOURCES
	public void getResources_OverAllCSAT_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(overallCSATVal_resource).isEmpty();
			if (elementExists) {
				waitForElement(overallCSATVal_resource, 30);
				String getresponse = driver.findElement(overallCSATVal_resource).getText();
				logger.info("OverAll CSAT Card Value: " + getresponse);
				grep.passTest("OverAll CSAT Card Value: " + getresponse);
			} else {
				logger.error("OverAll CSAT Card Value Not Available");
				grep.failTest("OverAll CSAT Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET PROMOTERS FOR RESOURCES
	public void getResources_Promoters_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(promotersVal_resource).isEmpty();
			if (elementExists) {
				waitForElement(promotersVal_resource, 30);
				String getresponse = driver.findElement(promotersVal_resource).getText();
				logger.info("Promoter Card Value: " + getresponse);
				grep.passTest("Promoter Card Value: " + getresponse);
			} else {
				logger.error("Promoter Card Value Not Available");
				grep.failTest("Promoter Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET NEUTRAL FOR RESOURCES
	public void getResources_Neutral_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(neutralVal_resource).isEmpty();
			if (elementExists) {
				waitForElement(neutralVal_resource, 30);
				String getresponse = driver.findElement(neutralVal_resource).getText();
				logger.info("Neutral Card Value: " + getresponse);
				grep.passTest("Neutral Card Value: " + getresponse);
			} else {
				logger.error("Neutral Card Value Not Available");
				grep.failTest("Neutral Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET DECTRACTORS FOR RESOURCES
	public void getResources_Detractors_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(detractorsVal_resource).isEmpty();
			if (elementExists) {
				waitForElement(detractorsVal_resource, 30);
				String getresponse = driver.findElement(detractorsVal_resource).getText();
				logger.info("Detractors Card Value: " + getresponse);
				grep.passTest("Detractors Card Value: " + getresponse);
			} else {
				logger.error("Response Count Card Value Not Available");
				grep.failTest("Response Count Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// RESPONSE COUNT FOR RESOURCES
	public void getResources_ResponseCount_CardValue() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(responseCountVal_resource).isEmpty();
			if (elementExists) {
				waitForElement(responseCountVal_resource, 30);
				String getresponse = driver.findElement(responseCountVal_resource).getText();
				logger.info("Response Count Card Value: " + getresponse);
				grep.passTest("Response Count Card Value: " + getresponse);
			} else {
				logger.error("Response Count Card Value Not Available");
				grep.failTest("Response Count Card Value Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// DOWNLOAD AT CARDS
	public void clickDownloadEntireDashboardBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(downloadBtnAT_Cards).isEmpty();
			if (elementexists) {
				driver.findElement(downloadBtnAT_Cards).click();
			} else {
				grep.failTest("Download Options Not Available");
				logger.error("Download Options Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// DOWNLOAD AT PROJECT WISE CSAT
	public void clickDownloadProject_FileBtn(String fileFormat) throws Exception {
		try {
			By downloadBtn = By.xpath("//div[@class='Project-export-dropdown']/button[text()='" + fileFormat + "']");
			implWait(driver);
			boolean elementexists = !driver.findElements(downloadAT_ProjectWise).isEmpty();
			if (elementexists) {
				driver.findElement(downloadAT_ProjectWise).click();
				driver.findElement(downloadBtn).click();
			} else {
				grep.failTest("Download Options Not Available");
				logger.error("Download Options Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// SHARE REPORT
	public void clickShareBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(shareBtn).isEmpty();
			if (elementexists) {
				driver.findElement(shareBtn).click();
			} else {
				grep.failTest("Share Option Not Available");
				logger.error("Share Option Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void selectEmailToSend(String email) throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(enterEmail).isEmpty();
			if (elementexists) {
				logger.info("Entered Email: " + email);
				grep.infoTest("Entered Email: " + email);
				driver.findElement(enterEmail).sendKeys(email);
				waitTime(driver);

				logger.info("Selecting Email");
				grep.infoTest("Selecting Email");
				driver.findElement(selectSuggestion).click();
				waitTime(driver);

				logger.info("Click Send PDF");
				grep.infoTest("Click Send PDF");
				driver.findElement(sendPDF).click();
				waitTime(driver);

			} else {
				grep.failTest("Share Option Not Available");
				logger.error("Share Option Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Skill Sync Mail
	public void clickSkillSyncMail() throws Exception {
		try {
			implWait(driver);
			List<WebElement> selectMail = driver.findElements(selectSurveyMail);
			if (selectMail.size() > 0) {
				waitForElementToBeClickable(selectSurveyMail, 30);
				selectMail.getFirst().click();
			} else {
				logger.error("Survey mail Not Available ");
				grep.failTest("Survey mail button Not Available ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Get Header in Mail
	public void getMailHeaderText() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(getEmailheader).isEmpty();
			if (elementExists) {
				waitForElement(getEmailheader, 30);
				String getresponse = driver.findElement(getEmailheader).getText();
				logger.info("Get Email Header: " + getresponse);
				grep.passTest("Get Email Header: " + getresponse);
			} else {
				logger.error("Email Header Not Available");
				grep.failTest("Email Header Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Get Email Body
	public void getMailBodyText() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(getEmailBody).isEmpty();
			if (elementExists) {
				waitForElement(getEmailBody, 30);
				String getresponse = driver.findElement(getEmailBody).getText();
				logger.info("Get Email Body: " + getresponse);
				grep.passTest("Get Email Body: " + getresponse);
			} else {
				logger.error("Email Body Not Available");
				grep.failTest("Email Body Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Verify Attachment

	public void verifyAttachementFile() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(getPDF).isEmpty();
			if (elementExists) {
				waitForElementToBeClickable(getPDF, 30);
				driver.findElement(getPDF).click();
				waitTime3(driver);
				logger.info("Download PDF from mail");
				grep.infoTest("Download PDF from mail");
				waitTime3(driver);
				driver.findElement(downloadPdf).click();
				waitTime5(driver);
				grep.captureScreenshot("pass", "Attachement in Email","ReportInEmail");
				waitTime3(driver);
				driver.findElement(closePDF).click();
				
			}else {
				logger.error("Email Not Available");
				grep.failTest("Email Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
}
