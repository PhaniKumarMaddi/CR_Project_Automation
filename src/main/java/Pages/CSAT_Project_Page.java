package Pages;

import java.lang.classfile.ClassFile.Option;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;
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

	By columnOptionsBtn = By.cssSelector("button.column-options-button");
	By columnOptionsHeader = By.xpath("//div[@class='column-options-header']/h3");
	By closeColumn = By.cssSelector("button.close-button");

	By statusFilter = By.cssSelector("select#drpStatus");
	By statuscolunInTable = By.xpath("//tr[@class='Project-odd-row']/td[5]/div");

	By surveyResponse = By.xpath("//div[@class='Project-filter-box2']/select");
	By surveyRuddrProject = By.xpath("//div[@class='Project-filter-box3']/select");
	By projectEnding = By.xpath("//div[@class='Project-filter-box-days']/select");
	By practicesFilter = By.xpath(
			"//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiSelect-root css-iz33ar']/select");

	By searchProjects = By.cssSelector("input.Project-search-input");
	By projectExportBtn = By.cssSelector("div.Project-export-container");
	By downloadBtn = By.xpath("//div[@class='Project-export-option' and text()='Download CSV']");
	By paginationEntries = By.cssSelector("select.Project-entries-select");

	By projectEditBtn = By.cssSelector("button.Project-action-button.Project-edit-button");
	By projectDeleteBtn = By.cssSelector("button.Project-action-button.Project-delete-button");
	By projectSendBtn = By.cssSelector("button.Project-action-button.Project-send-button");

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

	public void clickButton(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + btnValue + "']");

			boolean elementexists = !driver.findElements(button).isEmpty();
			if (elementexists) {
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
}
