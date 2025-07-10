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

public class CSAT_Project_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Project_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Project_Page() {
		this.driver = DriverManager.getDriver();
	}

	By pageHeader = By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4 Project-titleproject css-lpo7vw']");
	By surveySentStatus = By.xpath("//div[@class='Project-card-container MuiBox-root css-0']/div[1]/button");
	By surveyAtRiskStatus = By.xpath("//div[@class='Project-card-container MuiBox-root css-0']/div[2]/button");
	By surveyCompletedStatus = By.xpath("//div[@class='Project-card-container MuiBox-root css-0']/div[3]/button");
	By csatScoreAnalysis = By.xpath("//div[@class='Project-card-container MuiBox-root css-0']/div[4]/button");
	By surveyCloseBtn = By.cssSelector("button.Project-close-btn");
	By surveyPopupHeader = By.cssSelector("h6.MuiTypography-root.MuiTypography-h6.css-1rl0qlz");

	By addNewProject = By.xpath("//div[@class='MuiBox-root css-1kw3y0a']/p");
	By newProjectPopup = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h6 MuiDialogTitle-root Project-dialog-title css-1jft0nu']");
	
	public void headerValidation() throws Exception {
		try {
			waitForElement(pageHeader, 30);
			String verifyHeader = driver.findElement(pageHeader).getText();
			if (verifyHeader.equals(dataKeys.projectPage)) {
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

	public void clickViewSurveySentStatus() throws Exception {
		try {
			boolean elementExists = !driver.findElements(surveySentStatus).isEmpty();
			if (elementExists) {
				waitForElement(surveySentStatus, 60);
				driver.findElement(surveySentStatus).click();
			} else {
				grep.failTest("View button not available");
				logger.error("View button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickViewSurveyAtRiskStatus() throws Exception {
		try {
			boolean elementExists = !driver.findElements(surveyAtRiskStatus).isEmpty();
			if (elementExists) {
				waitForElement(surveyAtRiskStatus, 60);
				driver.findElement(surveyAtRiskStatus).click();
			} else {
				grep.failTest("View button not available");
				logger.error("View button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickViewSurveyCompletedStatus() throws Exception {
		try {
			boolean elementExists = !driver.findElements(surveyCompletedStatus).isEmpty();
			if (elementExists) {
				waitForElement(surveyCompletedStatus, 60);
				driver.findElement(surveyCompletedStatus).click();
			} else {
				grep.failTest("View button not available");
				logger.error("View button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickViewCSATScore() throws Exception {
		try {
			boolean elementExists = !driver.findElements(csatScoreAnalysis).isEmpty();
			if (elementExists) {
				waitForElement(csatScoreAnalysis, 60);
				driver.findElement(csatScoreAnalysis).click();
			} else {
				grep.failTest("View button not available");
				logger.error("View button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public String verifySurveyPopupHeader() throws Exception {
		String headerVal = null;
		try {
			List<WebElement> header = driver.findElements(surveyPopupHeader);
			if (header.size() > 0) {
				headerVal = header.getFirst().getText();
			} else {
				headerVal = "Header Not Found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

		return headerVal;
	}
	

	public void clickNewProject() throws Exception {
		try {
			boolean elementExists = !driver.findElements(addNewProject).isEmpty();
			if (elementExists) {
				waitForElement(addNewProject, 60);
				driver.findElement(addNewProject).click();
			} else {
				grep.failTest("Add New Project button not available");
				logger.error("Add New Project button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
	public String verifynewProjectPopupHeader() throws Exception {
		String headerVal = null;
		try {
			List<WebElement> header = driver.findElements(newProjectPopup);
			if (header.size() > 0) {
				headerVal = header.getFirst().getText();
			} else {
				headerVal = "Header Not Found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

		return headerVal;
	}

	public void clickCloseSurveyPopupBtn() throws Exception {
		try {
			boolean elementExists = !driver.findElements(surveyCloseBtn).isEmpty();
			if (elementExists) {
				waitForElement(surveyCloseBtn, 60);
				driver.findElement(surveyCloseBtn).click();
			} else {
				grep.failTest("Survey Close button not available");
				logger.error("Survey Close button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

}
