package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	By newProjectPopup = By.xpath(
			"//h2[@class='MuiTypography-root MuiTypography-h6 MuiDialogTitle-root Project-dialog-title css-1jft0nu']");

	// Filters on Project Page

	By columnOptionsBtn = By.cssSelector("button.Project-column-options-button");
	By columnOptionsHeader = By.xpath("//div[@class='column-options-header']/h3");
	By closeColumn = By.cssSelector("button.close-button");

	By projectExportBtn = By.cssSelector("div.Project-export-container");
	By paginationEntries = By.cssSelector("select.Project-entries-select");

	By statusFilter = By.cssSelector("select#drpStatus");
	By statuscolunInTable = By.xpath("//tr[@class='Project-odd-row']/td[5]/div");

	By surveyResponse = By.xpath("//div[@class='Project-filter-box2']/select");
	By surveyResponseColInTable = By.xpath("//tr[@class='Project-odd-row']/td[7]");

	By surveyRuddrProject = By.xpath("//div[@class='Project-filter-box3']/select");
	By surveyRuddrColInTable = By.xpath("//tr[@class='Project-odd-row']/td[6]");

	By projectEnding = By.xpath("//div[@class='Project-filter-box-days']/select");
	By practicesFilter = By.xpath("//div[@class='Project-filter-practices']/select");
	By practiceColInTable = By.xpath("//tr[@class='Project-odd-row']/td[2]");

	By searchProjects = By.cssSelector("input.Project-search-input");

	// New Project
	By projectName = By.xpath("//label[text()='Project Name']/following-sibling::div/input");
	By projectNameError = By.xpath("//div[@class='project-name-container']/p");

	By projectPractice = By.xpath("//select[@name='practice']");
	By projectStatus = By.xpath("//select[@name='status']");
	By projectType = By.xpath("//select[@name='type']");
	By projectDesc = By.xpath("//textarea[@name='description']");
	By projectDescError=By.xpath("//textarea[@name='description']/parent::div/parent::div/p");

	By startDate = By.xpath("//input[@name='startDate']");
	By endDate = By.xpath("//input[@name='endDate']");
	By endDateError = By.xpath("//div[@class='MuiDialogContent-root Project-dialog-content css-1nbx5hx']/p");

	// customer contact
	By customerFullName = By.xpath("//input[@name='fullName']");
	By customerEmail = By.xpath("//input[@name='email']");
	By customerEmailError = By.xpath("//div[@class='Project-contact-row']/div[2]/p");
	By updateCustomerEmailError = By.xpath("//div[@class='Project-contact-row']/div[2]/p");
	By updateCustomerNameError = By.xpath("//div[@class='Project-contact-row']/div[1]/p");

	By deleteCustomerContactBtn = By
			.xpath("//button[@type='button']/img[@alt='Delete' and @class='Project-action-icon']");
	// img[@alt='Delete Icon']
	By addNewCustomerContact = By.xpath("//button[text()=' Add New']");
	By projectListInTable = By.xpath("//tr[@class='Project-even-row']/td[1]");
	By projectListInTable2 = By.xpath("//tr[@class='Project-odd-row']/td[1]");

	// send Functionality
	By selectContact = By.xpath("//div/span[text()='Select Contact']");
	By selectSurvey = By.xpath("//label[text()='Survey']/parent::div[@class='form-group']/select");
	By getSubject = By.xpath("//label[text()='Subject']/parent::div/input");
	By getBody = By.xpath("//label[text()='Body']/parent::div/textarea");
	By closeSurvey = By.cssSelector("button.close-btn");

	By emailSentmsg = By.xpath("//div[@class='MuiSnackbarContent-message css-1o19295']");

	// Ruddr Project popup
	By ruddrprojectHeader = By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 css-1rl0qlz']");
	By closeRuddrBtn = By.cssSelector("button.Ruddr-close-btn");
	By editPopupWarnMsg = By.xpath("//div[@class='MuiDialogContent-root Project-dialog-content css-1nbx5hx']/p");
	By deleteIconRuddrPrject = By.xpath("//img[@alt='Delete Icon']/parent::button");

	public void headerValidation() throws Exception {
		try {
			implWait(driver);
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
			implWait(driver);
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
			implWait(driver);
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
			implWait(driver);
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
			implWait(driver);
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
			implWait(driver);
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
			implWait(driver);
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
			implWait(driver);
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
			implWait(driver);
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

	public void verifyButton(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + btnValue + "']");

			boolean elementexists = !driver.findElements(button).isEmpty();
			if (elementexists) {
//				driver.findElement(button).click();
				grep.passTest(btnValue + " Button Available");
				logger.info(btnValue + " Button Available");

			} else {
				grep.failTest(btnValue + " Button Not Available");
				logger.error(btnValue + " Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyRuddrButton(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[@title='" + btnValue + "']");

			List<WebElement> element = driver.findElements(button);
			if (element.size() > 0) {
				String btnTitle = element.getFirst().getAttribute("title");
				if (btnTitle.equals(btnValue)) {
					grep.passTest(btnValue + " Button is available");
					logger.info(btnValue + " Button is Available");
				} else {
					grep.failTest(btnValue + " Button Not Available");
					logger.error(btnValue + " Button Not Available");
				}

			} else {
				grep.failTest(btnValue + " Button Not Available");
				logger.error(btnValue + " Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickRuddrButton(String projectVal, String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + projectVal
					+ "']/parent::td/following-sibling::td[@class='Project-action-cell']/div/button[@title='" + btnValue
					+ "']");

			boolean elementexists = !driver.findElements(button).isEmpty();
			if (elementexists) {
				waitForElementToBeClickable(button, 60);
				driver.findElement(button).click();

			} else {
				grep.failTest(btnValue + " Button Not Available");
				logger.error(btnValue + " Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyButtonDisable(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + btnValue + "']");

			boolean elementexists = !driver.findElements(button).isEmpty();
			if (elementexists) {
				WebElement btn = driver.findElement(button);
				if (btn.isEnabled()) {
					grep.failTest(btnValue + " Button is Enabled");
					logger.error(btnValue + " Button is Enabled");
				} else {
					grep.passTest(btnValue + " Button is Disabled");
					logger.info(btnValue + " Button is Disabled");

				}

			} else {
				grep.failTest(btnValue + " Button Not Available");
				logger.error(btnValue + " Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyButtonEnabled(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + btnValue + "']");

			boolean elementexists = !driver.findElements(button).isEmpty();
			if (elementexists) {
				WebElement btn = driver.findElement(button);
				if (btn.isEnabled()) {
					grep.passTest(btnValue + " Button is Enabled");
					logger.info(btnValue + " Button is Enabled");
				} else {
					grep.failTest(btnValue + " Button is Disabled");
					logger.error(btnValue + " Button is Disabled");

				}

			} else {
				grep.failTest(btnValue + " Button Not Available");
				logger.error(btnValue + " Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickButton(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + btnValue + "']");

			boolean elementexists = !driver.findElements(button).isEmpty();
			if (elementexists) {
				waitForElement(button, 60);
				driver.findElement(button).click();

			} else {
				grep.failTest(btnValue + " Button Not Available");
				logger.error(btnValue + " Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyProjectBtns(String btnValue) throws Exception {
		try {
			implWait(driver);
//			By button = By.xpath("//button[text()='" + btnValue + "']");
			By projectEditBtn = By.cssSelector("button.Project-action-button.Project-" + btnValue + "-button");

			List<WebElement> element = driver.findElements(projectEditBtn);
			if (element.size() > 0) {
				String btnTitle = element.getFirst().getAttribute("title").toLowerCase();
				if (btnTitle.equals(btnValue)) {
					grep.passTest(btnValue + " Button is available");
					logger.info(btnValue + " Button is Available");
				} else {
					grep.failTest(btnValue + " Button Not Available");
					logger.error(btnValue + " Button Not Available");
				}

			} else {
				grep.failTest(btnValue + " Button Not Available");
				logger.error(btnValue + " Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// FILTERS ON PROJECT PAGE

	// COLUMN OPTIONS
	public void clickColumnOptionsBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(columnOptionsBtn).isEmpty();
			if (elementexists) {
				driver.findElement(columnOptionsBtn).click();

			} else {
				grep.failTest("Column Options Not Available");
				logger.error("Column Options Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyColumnOptionsHeader(String headerVal) throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(columnOptionsHeader).isEmpty();
			if (elementexists) {
				String col_Opt_Header = driver.findElement(columnOptionsHeader).getText();
				if (col_Opt_Header.equals(headerVal)) {
					grep.passTest(col_Opt_Header + " is valid Header value");
					logger.info(col_Opt_Header + " is valid Header value");
				} else {
					grep.failTest(col_Opt_Header + " is invalid Header value");
					logger.error(col_Opt_Header + " is invalid Header value");
				}

			} else {
				grep.failTest("Column Options Not Available");
				logger.error("Column Options Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickCloseColumnOptions() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(closeColumn).isEmpty();
			if (elementexists) {
				driver.findElement(closeColumn).click();

			} else {
				grep.failTest("Column Options Not Available");
				logger.error("Column Options Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void selectColumnOption(String option) throws Exception {
		try {
			implWait(driver);
			By columnOption = By
					.xpath("//div[@class='column-option']/span[text()='" + option + "']/following-sibling::button");

			boolean elementexists = !driver.findElements(columnOption).isEmpty();
			if (elementexists) {
				driver.findElement(columnOption).click();

			} else {
				grep.failTest("Column Options Not Available");
				logger.error("Column Options Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyColumnOptionVisibilityView(String option) throws Exception {
		try {
			implWait(driver);
			By columnOptionVisibility = By
					.xpath("//div[@class='column-option']/span[text()='" + option + "']/following-sibling::button/img");

			boolean elementexists = !driver.findElements(columnOptionVisibility).isEmpty();
			if (elementexists) {
				String colVisisbility = driver.findElement(columnOptionVisibility).getAttribute("alt");
				if (colVisisbility.equals("View")) {
					grep.passTest("Column Option visibility is View ");
					logger.info("Column Option visibility is View ");
					waitTime(driver);

				} else {
					grep.warnTest("Column Option visibility is Hide ");
					logger.warn("Column Option visibility is Hide ");
				}

			} else {
				grep.failTest("Column Options Not Available");
				logger.error("Column Options Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyColumnOptionVisibilityHide(String option) throws Exception {
		try {
			implWait(driver);
			By columnOptionVisibility = By
					.xpath("//div[@class='column-option']/span[text()='" + option + "']/following-sibling::button/img");

			boolean elementexists = !driver.findElements(columnOptionVisibility).isEmpty();
			if (elementexists) {
				String colVisisbility = driver.findElement(columnOptionVisibility).getAttribute("alt");
				if (colVisisbility.equals("Hide")) {
					grep.passTest("Column Option visibility is Hide ");
					logger.info("Column Option visibility is Hide ");
				} else {
					grep.warnTest("Column Option visibility is View ");
					logger.warn("Column Option visibility is View ");
				}

			} else {
				grep.failTest("Column Options Not Available");
				logger.error("Column Options Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Download file
	public void clickDownloadFileBtn(String fileFormat) throws Exception {
		try {
			By downloadBtn = By.xpath("//div[@class='Project-export-option' and text()='" + fileFormat + "']");
//			By successMsg = By.xpath("//div[@class='MuiSnackbarContent-message css-1o19295']");
			implWait(driver);
			boolean elementexists = !driver.findElements(projectExportBtn).isEmpty();
			if (elementexists) {
				driver.findElement(projectExportBtn).click();
				driver.findElement(downloadBtn).click();
//				String getSuccessMsg = driver.findElement(successMsg).getText();
//				String trimFormat = fileFormat.replaceAll("Download ", "");
//				if (getSuccessMsg.contains(trimFormat)) {
//					logger.info(getSuccessMsg);
//					grep.passTest(getSuccessMsg);
//
//				} else {
//					logger.error("File Not downloaded");
//					grep.failTest("file not downloaded");
//				}

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

	public void selectPagination(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(paginationEntries).isEmpty();
			if (elementExist) {
				WebElement statusOption = driver.findElement(paginationEntries);
				Select statusOpt = new Select(statusOption);
				statusOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Pagination Option not Available");
				logger.error(option + " Pagination Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyPaginationSelectedOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(paginationEntries).isEmpty();
			if (elementExist) {
				WebElement statusOption = driver.findElement(paginationEntries);
				Select statusOpt = new Select(statusOption);

				String getOption = statusOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " pagination Option Selected");
					logger.info(getOption + " pagination Option Selected");
				} else {
					grep.failTest(getOption + " pagination Option not Selected");
					logger.error(getOption + " pagination Option not Selected");
				}
			} else {
				grep.failTest(option + " Pagination Option not Available");
				logger.error(option + " Pagination Option not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// STATUS filter

	public void selectStatusFilterOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(statusFilter).isEmpty();
			if (elementExist) {
				WebElement statusOption = driver.findElement(statusFilter);
				Select statusOpt = new Select(statusOption);
				statusOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Status Option not Available");
				logger.error(option + " Status Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyStatusSelectedOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(statusFilter).isEmpty();
			if (elementExist) {
				WebElement statusOption = driver.findElement(statusFilter);
				Select statusOpt = new Select(statusOption);

				String getOption = statusOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Status Option Selected");
					logger.info(getOption + " Status Option Selected");
				} else {
					grep.failTest(getOption + " Status Option not Selected");
					logger.error(getOption + " Status Option not Selected");
				}
			} else {
				grep.failTest(option + " Status Option not Available");
				logger.error(option + " Status Option not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String verifyStatusColumnInTable() throws Exception {
		String tableColumnVal = null;
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(statuscolunInTable).isEmpty();
			if (elementExist) {
				List<WebElement> statusCol = driver.findElements(statuscolunInTable);
				if (statusCol.size() > 0) {
					tableColumnVal = statusCol.getFirst().getText();
				} else {
					tableColumnVal = "Not Available";
				}
			} else {
				grep.failTest(" Status Filter not Available");
				logger.error(" Status Filter not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return tableColumnVal;
	}

	// SURVEY RESPONSES

	public void selectSurveyResponseFilterOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(surveyResponse).isEmpty();
			if (elementExist) {
				WebElement surveyResponseOption = driver.findElement(surveyResponse);
				Select surveyResp = new Select(surveyResponseOption);
				surveyResp.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Survey Response Option not Available");
				logger.error(option + " Survey Response not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifySurveyResponseSelectedOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(surveyResponse).isEmpty();
			if (elementExist) {
				WebElement responseOption = driver.findElement(surveyResponse);
				Select responseOpt = new Select(responseOption);

				String getOption = responseOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " survey Response Option Selected");
					logger.info(getOption + " survey Response Option Selected");
				} else {
					grep.failTest(getOption + " survey Response Option not Selected");
					logger.error(getOption + " survey Response Option not Selected");
				}
			} else {
				grep.failTest(option + " survey Response Option not Available");
				logger.error(option + " survey Response Option not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String verifySurveyResponseColumnInTable() throws Exception {
		String tableColumnVal = null;
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(surveyResponseColInTable).isEmpty();
			if (elementExist) {
				List<WebElement> statusCol = driver.findElements(surveyResponseColInTable);
				if (statusCol.size() > 0) {
					tableColumnVal = statusCol.getFirst().getText();
				} else {
					tableColumnVal = "Not Available";
				}
			} else {
				grep.failTest(" Survey Response Filter not Available");
				logger.error(" Surevy Respinse Filter not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return tableColumnVal;
	}

	// PROJECTS FILTER

	public void selectProjectFilterOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(surveyRuddrProject).isEmpty();
			if (elementExist) {
				WebElement projectOption = driver.findElement(surveyRuddrProject);
				Select projectOpt = new Select(projectOption);
				projectOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Project Option not Available");
				logger.error(option + " Project Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyProjectSelectedOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(surveyRuddrProject).isEmpty();
			if (elementExist) {
				WebElement projectOption = driver.findElement(surveyRuddrProject);
				Select projectOpt = new Select(projectOption);

				String getOption = projectOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Project Option Selected");
					logger.info(getOption + " Project Option Selected");
				} else {
					grep.failTest(getOption + " Project Option not Selected");
					logger.error(getOption + " Project Option not Selected");
				}
			} else {
				grep.failTest(option + " Project Option not Available");
				logger.error(option + " Project Option not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String verifyProjectColumnInTable() throws Exception {
		String tableColumnVal = null;
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(surveyRuddrColInTable).isEmpty();
			if (elementExist) {
				List<WebElement> surveyRuddrCol = driver.findElements(surveyRuddrColInTable);
				if (surveyRuddrCol.size() > 0) {
					tableColumnVal = surveyRuddrCol.getFirst().getText();
				} else {
					tableColumnVal = "Not Available";
				}
			} else {
				grep.failTest(" Project Filter not Available");
				logger.error(" Project Filter not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return tableColumnVal;
	}

	// PROJECT ENDING IN

	public void selectEndingDaysFilterOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(projectEnding).isEmpty();
			if (elementExist) {
				WebElement endingOption = driver.findElement(projectEnding);
				Select endingOpt = new Select(endingOption);
				endingOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Ending Days Option not Available");
				logger.error(option + " Ending Days Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyEndingDaysSelectedOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(projectEnding).isEmpty();
			if (elementExist) {
				WebElement endingOption = driver.findElement(projectEnding);
				Select endingOpt = new Select(endingOption);

				String getOption = endingOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Ending Days Option Selected");
					logger.info(getOption + " Ending Days Option Selected");
				} else {
					grep.failTest(getOption + " Ending Days Option not Selected");
					logger.error(getOption + " Ending Days Option not Selected");
				}
			} else {
				grep.failTest(option + " Ending Days Option not Available");
				logger.error(option + " Ending Days Option not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

//	public String verifyStatusColumnInTable() throws Exception {
//		String tableColumnVal = null;
//		try {
//			implWait(driver);
//			boolean elementExist = !driver.findElements(statuscolunInTable).isEmpty();
//			if (elementExist) {
//				List<WebElement> statusCol = driver.findElements(statuscolunInTable);
//				if (statusCol.size() > 0) {
//					tableColumnVal = statusCol.getFirst().getText();
//				} else {
//					tableColumnVal = "Not Available";
//				}
//			} else {
//				grep.failTest(" Status Filter not Available");
//				logger.error(" Status Filter not Available");
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			grep.failTest("Test Failed :" + e.getMessage());
//			logger.error("Test Failed :" + e.getMessage());
//
//		}
//		return tableColumnVal;
//	}

	// PRACTICES

	public void selectPracticeFilterOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(practicesFilter).isEmpty();
			if (elementExist) {
				WebElement practiceOption = driver.findElement(practicesFilter);
				Select practiceOpt = new Select(practiceOption);
				practiceOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Practice Option not Available");
				logger.error(option + " Practice Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyPracticeSelectedOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(practicesFilter).isEmpty();
			if (elementExist) {
				WebElement practiceOption = driver.findElement(practicesFilter);
				Select practiceOpt = new Select(practiceOption);

				String getOption = practiceOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Practice Option Selected");
					logger.info(getOption + " Practice Option Selected");
				} else {
					grep.failTest(getOption + " Practice Option not Selected");
					logger.error(getOption + " Practice Option not Selected");
				}
			} else {
				grep.failTest(option + " Practice Option not Available");
				logger.error(option + " Practice Option not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String verifyPracticeColumnInTable() throws Exception {
		String tableColumnVal = null;
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(practiceColInTable).isEmpty();
			if (elementExist) {
				List<WebElement> statusCol = driver.findElements(practiceColInTable);
				if (statusCol.size() > 0) {
					tableColumnVal = statusCol.getFirst().getText();
				} else {
					tableColumnVal = "Not Available";
				}
			} else {
				grep.failTest(" Practice Filter not Available");
				logger.error(" Practice Filter not Available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return tableColumnVal;
	}

	public void searchProject(String projectName) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchProjects).isEmpty();
			if (elementExist) {
				driver.findElement(searchProjects).sendKeys(projectName);
			} else {
				grep.failTest(" Search Field not Available");
				logger.error(" Search Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Creating New Project

	public void insertProjectName(String projectNameValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(projectName).isEmpty();
			if (elementExists) {
				waitForElement(projectName, 60);
				driver.findElement(projectName).sendKeys(projectNameValue);
			} else {
				grep.failTest("Project Name not available");
				logger.error("project Name not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void projectNameError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(projectNameError).isEmpty();
			if (elementExists) {
				waitForElement(projectNameError, 60);

				String error = driver.findElement(projectNameError).getText();
				grep.passTest(error);
				logger.info(error);
			} else {
				grep.failTest("Project Name not available");
				logger.error("project Name not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void selectProjectPracticeOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(projectPractice).isEmpty();
			if (elementExist) {
				WebElement projectPracticeOption = driver.findElement(projectPractice);
				Select projectPracticeOpt = new Select(projectPracticeOption);
				projectPracticeOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Project Practice Option not Available");
				logger.error(option + " Project Practice Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectProjectStatusOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(projectStatus).isEmpty();
			if (elementExist) {
				WebElement projectStatusOption = driver.findElement(projectStatus);
				Select projectStatusOpt = new Select(projectStatusOption);
				projectStatusOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Project Status Option not Available");
				logger.error(option + " Project Status Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectProjectTypeOption(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(projectType).isEmpty();
			if (elementExist) {
				WebElement projectTypeOption = driver.findElement(projectType);
				Select projectTypeOpt = new Select(projectTypeOption);
				projectTypeOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Project Type Option not Available");
				logger.error(option + " Project Type Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void insertProjectDescription(String projectDescValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(projectDesc).isEmpty();
			if (elementExists) {
				waitForElement(projectDesc, 60);
				WebElement desc = driver.findElement(projectDesc);
				desc.clear();
				desc.sendKeys(projectDescValue);
			} else {
				grep.failTest("Project Description not available");
				logger.error("Project Description not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
	
	public void getDescriptionError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(projectDescError).isEmpty();
			if (elementExists) {
				waitForElement(projectDescError, 60);

				String error = driver.findElement(projectDescError).getText();
				grep.passTest("Description Error: "+error);
				logger.info("Description Error: "+error);
			} else {
				grep.failTest("Description Error not available");
				logger.error("Description Error not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void insertCustomerName(String custNameValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(customerFullName).isEmpty();
			if (elementExists) {
				List<WebElement> custName = driver.findElements(customerFullName);
				if (custName.size() > 0) {
					waitForElementToBeClickable(customerFullName, 60);

					custName.getLast().clear();
					waitTime1(driver);
					custName.getLast().sendKeys(custNameValue);
				}
			} else {
				grep.failTest("Customer Name not available");
				logger.error("Customer Name not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clearCustomerName() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(customerFullName).isEmpty();
			if (elementExists) {
				List<WebElement> custName = driver.findElements(customerFullName);
				if (custName.size() > 0) {
					waitForElement(customerFullName, 30);
					WebElement lastElement = custName.get(custName.size() - 1);
					lastElement.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				}
			} else {
				grep.failTest("Customer Name not available");
				logger.error("Customer Name not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void insertCustomerEmail(String customerEmailValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(customerEmail).isEmpty();
			if (elementExists) {
				List<WebElement> custEmail = driver.findElements(customerEmail);
				if (custEmail.size() > 0) {
					waitForElementToBeClickable(customerEmail, 60);
					waitTime(driver);
					custEmail.getLast().clear();
					waitTime(driver);
					custEmail.getLast().sendKeys(customerEmailValue);
				}
			} else {
				grep.failTest("Customer Email not available");
				logger.error("Customer Email not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clearCustomerEmail() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(customerEmail).isEmpty();
			if (elementExists) {
				List<WebElement> custEmail = driver.findElements(customerEmail);
				if (custEmail.size() > 0) {
					waitForElement(customerEmail, 30);
					WebElement lastElement = custEmail.get(custEmail.size() - 1);
					lastElement.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				}
			} else {
				grep.failTest("Customer Name not available");
				logger.error("Customer Name not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void getCustomerEmailError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(customerEmailError).isEmpty();
			if (elementExists) {
				waitForElement(customerEmailError, 60);

				String error = driver.findElement(customerEmailError).getText();
				grep.passTest("Customer Email Error :"+error);
				logger.info("Customer Email Error :"+error);
			} else {
				grep.failTest("Customer Email not available");
				logger.error("Customer Email not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void getCustomerEmailErrorInUpdate() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(updateCustomerEmailError).isEmpty();
			if (elementExists) {
				waitForElement(updateCustomerEmailError, 60);

				String error = driver.findElement(updateCustomerEmailError).getText();
				grep.passTest("Customer Email Error :"+error);
				logger.info("Customer Email Error :"+error);
			} else {
				grep.failTest("Customer Email not available");
				logger.error("Customer Email not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void getCustomerNameError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(updateCustomerNameError).isEmpty();
			if (elementExists) {
				waitForElement(updateCustomerNameError, 60);

				String error = driver.findElement(updateCustomerNameError).getText();
				grep.passTest("Customer Name Error :"+error);
				logger.info("Customer Name Error :"+error);
			} else {
				grep.failTest("Customer Name not available");
				logger.error("Customer Name not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void deleteCustomerContact() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(deleteCustomerContactBtn).isEmpty();
			if (elementExists) {
				List<WebElement> delete = driver.findElements(deleteCustomerContactBtn);
				if (delete.size() > 0) {
					waitForElement(deleteCustomerContactBtn, 60);
					delete.getLast().click();
				}
			} else {
				grep.failTest("Delete Customer Contact button not available");
				logger.error("Delete Customer Contact button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void addNewCustomerContactBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(addNewCustomerContact).isEmpty();
			if (elementExists) {
				waitForElementToBeClickable(addNewCustomerContact, 30);
				driver.findElement(addNewCustomerContact).click();
			} else {
				grep.failTest("Add New Customer Contact button not available");
				logger.error("Add New Customer Contact button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void insertStartDate(String date, String month, String year) throws Exception {
		try {
			implWait(driver);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).build().perform();
			waitTime(driver);
			act.sendKeys(date).build().perform();
			waitTime1(driver);
			act.sendKeys(month).build().perform();
			waitTime1(driver);
			act.sendKeys(year).build().perform();
			waitTime(driver);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void insertEndDate(String date, String month, String year) throws Exception {
		try {
			implWait(driver);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			waitTime(driver);
			act.sendKeys(year).build().perform();
			waitTime1(driver);
			act.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
			waitTime(driver);
			act.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
			waitTime(driver);
			act.sendKeys(date).build().perform();
			waitTime1(driver);
			act.sendKeys(month).build().perform();
			waitTime(driver);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public String retrieveStartDate() throws Exception {
		String dateVal = null;
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(startDate).isEmpty();
			if (elementExists) {
				waitForElement(startDate, 30);
				dateVal = driver.findElement(startDate).getAttribute("value");
			} else {
				dateVal = "Start Date Does Not Exists";
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return dateVal;
	}

	public String retrieveEndDate() throws Exception {
		String dateVal = null;
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(endDate).isEmpty();
			if (elementExists) {
				waitForElement(endDate, 30);
				dateVal = driver.findElement(endDate).getAttribute("value");
			} else {
				dateVal = "End Date Does Not Exists";
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return dateVal;
	}

	public void getEndDateError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(endDateError).isEmpty();
			if (elementExists) {
				waitForElement(endDateError, 60);

				String error = driver.findElement(endDateError).getText();
				grep.passTest("End Date Error: "+error);
				logger.info("End Date Error: "+error);
			} else {
				grep.failTest("End Date not available");
				logger.error("End Date not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickProjectBtn(String projectName, String action) throws Exception {
		try {
			implWait(driver);
			By icon = By.xpath("//td[text()='" + projectName
					+ "']/parent::tr/td[@class='Project-action-cell']/div/button[@title='" + action + "']");

			WebElement editIcon = driver.findElement(icon);
			if (editIcon.isDisplayed()) {
				waitForElementToBeClickable(icon, 30);
				editIcon.click();
			} else {
				logger.info(action + " is not available for " + projectName);
				grep.infoTest(action + " is not available for " + projectName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyDeletedFromProjectNameList(String projectName) throws Exception {
		try {
			implWait(driver);
			int count = 0;
			List<WebElement> projectList = driver.findElements(projectListInTable);
			List<WebElement> projectList2 = driver.findElements(projectListInTable2);
			if (projectList.size() > 0 && projectList2.size() > 0) {
				for (WebElement project : projectList) {
					String validateProject = project.getText().trim();
					if (validateProject.equals(projectName)) {
						count++;
					}
				}
				for (WebElement project2 : projectList2) {
					String validateProjectList = project2.getText().trim();
					if (validateProjectList.equals(projectName)) {
						count++;
					}
				}

				if (count == 0) {
					grep.passTest(projectName + " Project Deleted");
					logger.info(projectName + " Project Deleted");
				} else {
					grep.failTest(projectName + " Project Not Deleted");
					logger.error(projectName + " Project Not Deleted");
				}

			} else {
				logger.info("Project list is not available");
				grep.infoTest("Project list is not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyCreatedProjectNameInList(String projectName) throws Exception {
		try {
			implWait(driver);
			List<WebElement> projectList = driver.findElements(projectListInTable);
			List<WebElement> projectList2 = driver.findElements(projectListInTable2);
			if (projectList.size() > 0 && projectList2.size() > 0) {
				int count = 0;
			for (WebElement project : projectList) {
					String validateProject = project.getText().trim();

					if (validateProject.equals(projectName)) {
					count++;
					System.out.println(validateProject);
				}
			}
			for (WebElement project2 : projectList2) {
					String validateProjectList = project2.getText().trim();

					if (validateProjectList.equals(projectName)) {
						count++;
						System.out.println(validateProjectList);
					}
				}
				if (count == 1) {
					grep.passTest(projectName + " Project Created");
					logger.info(projectName + " Project Created");
				} else {
					grep.failTest(projectName + " Project Not Created");
					logger.error(projectName + " Project Not Created");
				}

			} else {
				logger.info("Project list is not available");
				grep.infoTest("Project list is not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}
	
	
	public void clickSelectContact(String option) throws Exception {
		try {
			By selectContactOption = By.xpath("//div[@class='custom-dropdown-menu']/div[text()='" + option + "']");
			implWait(driver);
			boolean elementExists = !driver.findElements(selectContact).isEmpty();
			if (elementExists) {
				waitForElement(selectContact, 30);
				driver.findElement(selectContact).click();
				waitTime(driver);
				driver.findElement(selectContactOption).click();
				waitTime(driver);
				grep.infoTest("Selected Contact");
				logger.info("Selected Contact");
//				driver.findElement(selectContact).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void selectSurveyOption(String option) throws Exception {
		try {
			driver.findElement(selectSurvey).click();
			implWait(driver);
			boolean elementExists = !driver.findElements(selectSurvey).isEmpty();
			if (elementExists) {

				WebElement surveyOption = driver.findElement(selectSurvey);
				Select surveyOpt = new Select(surveyOption);
				surveyOpt.selectByVisibleText(option);
			} else {
				grep.failTest(option + " Survey Option not Available");
				logger.error(option + " Survey Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void retrieveSubjectBasedOnSurvey() throws Exception {
		try {

			implWait(driver);
			boolean elementExists = !driver.findElements(getSubject).isEmpty();
			if (elementExists) {

				waitForElement(getSubject, 60);
				String subject = driver.findElement(getSubject).getAttribute("value");
				grep.infoTest("Subject Retrieved Based on Survey Type");
				logger.info("Subject Retrieved Based on Survey Type");
				grep.passTest(subject);
				logger.info(subject);
			} else {
				grep.failTest("Failed to retrieve Subject Field Text");
				logger.error("Failed to retrieve Subject Field Text");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void retrieveBodyBasedOnSurvey() throws Exception {
		try {

			implWait(driver);
			boolean elementExists = !driver.findElements(getBody).isEmpty();
			if (elementExists) {

				waitForElement(getBody, 60);
				String body = driver.findElement(getBody).getText();
				grep.infoTest("Body Retrieved Based on Survey Type");
				logger.info("Body Retrieved Based on Survey Type");
				grep.passTest(body);
				logger.info(body);
			} else {
				grep.failTest("Failed to retrieve body Field Text");
				logger.error("Failed to retrieve body Field Text");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickCloseSendSurveyButton() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(closeSurvey).isEmpty();
			if (elementExists) {
				waitForElementToBeClickable(closeSurvey, 30);
				driver.findElement(closeSurvey).click();
			} else {
				logger.error("Close Button Not Available ");
				grep.failTest("Close Button Not Available ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public String getSurveyCount(String surveyType) throws Exception {
		String surveyCountResult = null;
		try {

			By surveyCount = By.xpath("//p[text()='" + surveyType + "']/parent::div/p[2]");
			implWait(driver);
			boolean elementExists = !driver.findElements(surveyCount).isEmpty();
			if (elementExists) {
				waitForElement(surveyCount, 60);
				surveyCountResult = driver.findElement(surveyCount).getText();
				grep.passTest("Count Retrieved");
			} else {
				surveyCountResult = "Failed to retrieve" + surveyType + " Count Text";
				grep.failTest("Count Not Retrieved");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return surveyCountResult;

	}

	public void retrieveFeedBackSentMessage() throws Exception {
		try {

			waitForElementToBePopulated(getBody, 160);
			String emailMsg = driver.findElement(emailSentmsg).getText();
			grep.passTest("Email Send Message: " + emailMsg);
			logger.info("Email Send Message: " + emailMsg);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public String verifyCsatColInTable(String projectName) throws Exception {
		String csatColResult = null;
		try {
			By csatCol = By.xpath("//td[text()='" + projectName + "']/parent::tr/td[7]");

			implWait(driver);
			boolean elementExists = !driver.findElements(csatCol).isEmpty();
			if (elementExists) {
				waitForElement(csatCol, 60);
				csatColResult = driver.findElement(csatCol).getText();
				grep.passTest("Value Retrieved");
			} else {
				csatColResult = "Failed to retrieve" + csatColResult + " Value Text";
				grep.failTest("Count Not Retrieved");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return csatColResult;
	}

	public void verifyProjectBtnsAfterSurvey(String projectName) throws Exception {
		try {
			implWait(driver);
			By projectBtn = By.xpath("//td[text()='" + projectName + "']/parent::tr/td/div/button");

			List<WebElement> element = driver.findElements(projectBtn);
			if (element.size() > 0) {
				for (WebElement buttons : element) {

					String buttonTitle = buttons.getAttribute("title");
					if (buttonTitle.equals(dataKeys.sendProjectBtn) || buttonTitle.equals(dataKeys.deleteProjectBtn)) {

						grep.failTest("FeedBack Not Received");
						logger.error("FeedBack Not Received");
					} else {
						grep.passTest("FeedBack Received");
						logger.info("FeedBack Received");
					}
				}

			} else {
				grep.failTest(projectName + " Not Available");
				logger.error(projectName + " Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void ruddrProjectHeaderValidation(String projectName) throws Exception {
		try {
			implWait(driver);
			waitForElement(ruddrprojectHeader, 30);
			String verifyHeader = driver.findElement(ruddrprojectHeader).getText();
			if (verifyHeader.contains(projectName)) {
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

	public void ruddrProjectColumnValidation(String columnName) throws Exception {
		try {
			implWait(driver);
			By header = By.xpath("//table[@class='Ruddr-project-table']/thead/tr/th[text()='" + columnName + "']");

			WebElement colHeader = driver.findElement(header);
			if (colHeader.isDisplayed()) {
				logger.info(columnName + " Header is Available");
				grep.passTest(columnName + " Header is Available");
			} else {
				logger.error(columnName + " Header is Not Available");
				grep.failTest(columnName + " Header is Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickCloseRuddrPopupBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(closeRuddrBtn).isEmpty();
			if (elementExists) {
				waitForElement(closeRuddrBtn, 60);
				driver.findElement(closeRuddrBtn).click();
			} else {
				grep.failTest("Ruddr Close button not available");
				logger.error("Ruddr Close button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void getEditPopupWarningMessage() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(editPopupWarnMsg).isEmpty();
			if (elementExists) {
				waitForElement(editPopupWarnMsg, 30);
				String verifyMsg = driver.findElement(editPopupWarnMsg).getText();

				logger.info("Warning message: " + verifyMsg);
				grep.passTest("Warning message: " + verifyMsg);
			} else {
				logger.error("Warning message Not Available");
				grep.failTest("Warning message Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyDeleteDisable() throws Exception {

		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(deleteIconRuddrPrject).isEmpty();
			if (elementexists) {
				WebElement btn = driver.findElement(deleteIconRuddrPrject);
				if (btn.isEnabled()) {
					grep.failTest("Delete Button is Enabled");
					logger.error("Delete Button is Enabled");
				} else {
					grep.passTest("Delete Button is Disabled");
					logger.info("Delete Button is Disabled");

				}

			} else {
				grep.failTest(" Delete Button Not Available");
				logger.error("Delete Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void deleteCustomerContactInRuddr() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(deleteIconRuddrPrject).isEmpty();
			if (elementExists) {
				List<WebElement> delete = driver.findElements(deleteIconRuddrPrject);
				if (delete.size() > 0) {
					waitForElement(deleteIconRuddrPrject, 60);
					delete.getLast().click();
				}
			} else {
				grep.failTest("Delete Customer Contact button not available");
				logger.error("Delete Customer Contact button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

}
