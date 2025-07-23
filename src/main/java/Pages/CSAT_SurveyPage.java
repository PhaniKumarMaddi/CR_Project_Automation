package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class CSAT_SurveyPage extends WaitsManager {

	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_SurveyPage.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_SurveyPage() {
		this.driver = DriverManager.getDriver();
	}

	By surveyPageHeader = By.cssSelector("h1.add-survey-survey-title");

	// Column Options in Survye
	By columnOptionsBtn = By.cssSelector("button.survey-column-options-button");
	By columnOptionsHeader = By.xpath("//div[@class='column-options-header']/h3");
	By closeColumn = By.cssSelector("button.close-button");

	// Pagination and export
	By surveyExportBtn = By.cssSelector("div.survey-export-container");
	By paginationEntries = By.cssSelector("select.survey-items-per-page-select");

	// survey type dropdown
	By surveyTypeDroprdown = By.xpath("//div[@id='survey-8']/div/div");
	By allSurveyType = By.xpath("//ul[@role='listbox']/li[@title='All Survey Types']");

	// add new survey type
	By addNewSurveyType = By.xpath("//span[@title='Add New Survey Type']");
	By closeSurveyPopups = By.cssSelector("img.close-img");

	// Search
	By searchSurveyField = By.cssSelector("input.survey-search");

	// Add new Survey
	By addNewSurvey = By.xpath("//button[@title='Add New Survey']");
	By popupsHeader = By.cssSelector("div.survey-form-modal-header");
	By editPopupHeader = By.xpath("//div[@class='add-survey-modal-header']/h2");
	By closeEditPopup = By.cssSelector("button.add-survey-close-btn");

	// Select Survey from Table
	By surveyDetailsHeader = By.cssSelector("h1.survey-title");
	By surveyTypeColInTable = By.xpath("//tr[@class='survey-table-row']/td[2]");

	// Add new Survey Type Test
	By typeField = By.xpath("//input[@placeholder='Survey Type']");
	By descField = By.xpath("//textarea[@name='description']");
	By surveyTypeError = By.xpath("//div[@class='MuiBox-root css-19kzrtu']/div[3]");

	// Add New Survey Popup
	By startDate = By.xpath("//input[@name='startDate']");
	By endDate = By.xpath("//input[@name='endDate']");

	By addSurveyName = By.xpath("//input[@name='surveyName']");
	By surveyNameError = By.xpath("//input[@name='surveyName']/following-sibling::span");
	By addSurveyType = By.xpath("//select[@name='surveyType']");

	// section
	By addNewSection = By.xpath("//button[text()=' Add New Section']");
	By selectSectionName = By.xpath("//label[text()='Section Name']/following-sibling::select");
	By customSectionName = By.xpath("//input[@placeholder='Custom Section Name']");
	By sectonWeightage = By.cssSelector("input.survey-form-section-weightage");

	// measure
	By addMeasure = By.xpath("//button[text()=' Add Measure']");
	By selectMeasureName = By.xpath("//label[text()='Measure Name']/following-sibling::select");
	By customMeasureName = By.xpath("//input[@placeholder='Custom Measure Name']");

	// question
	By addQuestion = By.xpath("//button[text()=' Add Question']");
	By questionName = By.xpath("//label[text()='Question Name']/following-sibling::input");
	By questionType = By.xpath("//label[text()='Question Type']/following-sibling::select");
	By questionOption = By.cssSelector("input.survey-form-option-input-reduced");
	By optionWeightage = By.cssSelector("input.survey-form-option-input-weightage"); // 1 to 10
	By addOptionBtn = By.xpath("//span[text()='Add option']");
	// linear scale type
	By linearScaleTo = By.xpath("//div[@class='survey-form-linear-scale-range']/select[2]");

	By createdSurveyInTable = By.xpath("//tr[@class='survey-table-row']/td[1]/button");

	// Header for survey
	public void headerValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(surveyPageHeader, 30);
			String verifyHeader = driver.findElement(surveyPageHeader).getText();
			if (verifyHeader.equals(dataKeys.surveyPage)) {
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

	// Survey Type Dropdown
	public void verifySurveyTypeDropDown(String headerVal) throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(surveyTypeDroprdown).isEmpty();
			if (elementexists) {
				String surveyDropdown = driver.findElement(surveyTypeDroprdown).getText();
				if (surveyDropdown.equals(headerVal)) {
					grep.passTest(surveyDropdown + " Dropdown is Available");
					logger.info(surveyDropdown + " Dropdown is Available");
				} else {
					grep.failTest(surveyDropdown + " Dropdown is not Available");
					logger.error(surveyDropdown + " Dropdown is not Available");
				}

			} else {
				grep.failTest("Survey Type Options Not Available");
				logger.error("Survey Type Options  Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Click Survey Type Dropdown
	public void clickSurveyTypeDropDown() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(surveyTypeDroprdown).isEmpty();
			if (elementexists) {
				waitForElementToBeClickable(surveyTypeDroprdown, 30);
				driver.findElement(surveyTypeDroprdown).click();

			} else {
				grep.failTest("Survey Type Options Not Available");
				logger.error("Survey Type Options  Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Select All Survey Type
	public void selectAllSurveyTypeOption() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(allSurveyType).isEmpty();
			if (elementexists) {
				waitForElementToBeClickable(allSurveyType, 30);
				driver.findElement(allSurveyType).click();
			} else {
				grep.failTest("All Survey Type Not Available");
				logger.error("All Survey Type Options  Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Select Survey Type Options
	public void selectSurveyTypeOption(String option) throws Exception {
		try {

			By selectOption = By.xpath("//li/div/span[text()='" + option + "']");

			implWait(driver);
			boolean elementexists = !driver.findElements(selectOption).isEmpty();
			if (elementexists) {
				WebElement element = driver.findElement(selectOption);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
			} else {
				grep.failTest(option + " Survey Type Not Available");
				logger.error(option + " Survey Type Options Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// select actions for survey type

	public void selectActionInSurveyType(String option, String action) throws Exception {
		try {

			By actionsOnSurveyType = By.xpath(
					"//li/div/span[text()='" + option + "']/following-sibling::div/button[@title='" + action + "']");

			implWait(driver);
			boolean elementexists = !driver.findElements(actionsOnSurveyType).isEmpty();
			if (elementexists) {
				WebElement element = driver.findElement(actionsOnSurveyType);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
			} else {
				grep.failTest(action + " for " + option + " Survey Type Not Available");
				logger.error(action + " for " + option + " Survey Type Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// close survey popups
	public void clickCloseSurveyPopups() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(closeSurveyPopups).isEmpty();
			if (elementExists) {
				waitForElementToBeClickable(closeSurveyPopups, 30);
				driver.findElement(closeSurveyPopups).click();
			} else {
				grep.failTest("Survey Close Popup button not available");
				logger.error("Survey Close popup button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// click Add New Survey Type
	public void clickAddNewSurveyTypeBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(addNewSurveyType).isEmpty();
			if (elementexists) {
				driver.findElement(addNewSurveyType).click();

			} else {
				grep.failTest("Add New Survey Type Not Available");
				logger.error("Add New Survey Type Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Verify Popups Header
	public void popupHeaderValidation(String headerVal) throws Exception {
		try {
			implWait(driver);
			waitForElement(popupsHeader, 30);
			String verifyHeader = driver.findElement(popupsHeader).getText();
			if (verifyHeader.equals(headerVal)) {
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

	// Search Survey
	public void searchSurvey(String surveyNameval) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchSurveyField).isEmpty();
			if (elementExist) {
				driver.findElement(searchSurveyField).sendKeys(surveyNameval);
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

	public void clearSearchSurvey() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchSurveyField).isEmpty();
			if (elementExist) {
				driver.findElement(searchSurveyField).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
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

	// SELECT SURVEY FORM TABLE
	public void selectSurveyFromTable(String surveyName) throws Exception {
		try {
			By selectSurvey = By.xpath("//tr[@class='survey-table-row']/td/button[text()='" + surveyName + "']");
			implWait(driver);
			boolean elementexists = !driver.findElements(selectSurvey).isEmpty();
			if (elementexists) {
				waitForElementToBeClickable(selectSurvey, 30);
				driver.findElement(selectSurvey).click();
			} else {
				grep.failTest(surveyName + " Survey Not Available");
				logger.error(surveyName + " Survey Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// survey detail header
	public void surveyDetailHeaderValidation(String header) throws Exception {
		try {
			implWait(driver);
			waitForElement(surveyDetailsHeader, 30);
			String verifyHeader = driver.findElement(surveyDetailsHeader).getText();
			if (verifyHeader.equals(header)) {
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

	public void selectActionFromSurveyTable(String option, String action) throws Exception {
		try {

			By surveyActionsInTable = By.xpath("//button[text()='" + option
					+ "']/parent::td/following-sibling::td/div/button[@title='" + action + "']");

			implWait(driver);
			boolean elementexists = !driver.findElements(surveyActionsInTable).isEmpty();
			if (elementexists) {
				waitForElementToBeClickable(surveyActionsInTable, 30);
				driver.findElement(surveyActionsInTable).click();
			} else {
				grep.failTest(action + " for " + option + " Survey Type Not Available");
				logger.error(action + " for " + option + " Survey Type Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Edit PopupHeader
	public void editPopupHeaderValidation() throws Exception {
		try {
//				implWait(driver);
			waitForElement(editPopupHeader, 60);
			String verifyHeader = driver.findElement(editPopupHeader).getText();
			if (verifyHeader.equals(dataKeys.editSurveyHeader)) {
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

	public void clickCloseEditSurveyPopups() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(closeEditPopup).isEmpty();
			if (elementExists) {
				waitForElementToBeClickable(closeEditPopup, 30);
				driver.findElement(closeEditPopup).click();
			} else {
				grep.failTest("Edit Survey Close Popup button not available");
				logger.error("Edit Survey Close popup button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// VERIFY COLUMN IN TABLE
	public void verifyTypeColInTable(String colvalues) throws Exception {
		try {

			implWait(driver);

			List<WebElement> element = driver.findElements(surveyTypeColInTable);
			if (element.size() > 0) {
				for (WebElement values : element) {

					String valuesTitle = values.getAttribute("title");
					if (valuesTitle.equals(colvalues)) {

						grep.passTest("Type Column in Valid: " + valuesTitle);
						logger.info("Type Column in Valid: " + valuesTitle);
					} else {
						grep.failTest("Type Column in Not Valid: " + valuesTitle);
						logger.error("Type Column in Not Valid: " + valuesTitle);
					}
				}

			} else {
				grep.failTest("Survey Column Not Available");
				logger.error("Survey Column Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	// click Add New Survey Type
	public void clickAddNewSurveyBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementexists = !driver.findElements(addNewSurvey).isEmpty();
			if (elementexists) {
				driver.findElement(addNewSurvey).click();

			} else {
				grep.failTest("Add New Survey Not Available");
				logger.error("Add New Survey Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

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

	// CLOUMN OPTION HEADER
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

	// CLOSE CLOUM OPTION
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

	// SELECT COLUMN OPTION
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

	// VERIFY COLUMN VISISBILITY VIEW
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

	// VERIFY COLUMN VISISBILITY HIDE
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
			By downloadBtn = By.xpath("//div[@class='survey-export-dropdown']/div[text()='" + fileFormat + "']");
			implWait(driver);
			boolean elementexists = !driver.findElements(surveyExportBtn).isEmpty();
			if (elementexists) {
				driver.findElement(surveyExportBtn).click();
				driver.findElement(downloadBtn).click();
				driver.findElement(surveyExportBtn).click();
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

	// SELECT PAGINATION
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

// VERIFY PAGINATION
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

	// VERIFY BUTTON
	public void verifyButton(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + btnValue + "']");

			boolean elementexists = !driver.findElements(button).isEmpty();
			if (elementexists) {
//					driver.findElement(button).click();
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

	// CLICK BUTTON
	public void clickButton(String btnValue) throws Exception {
		try {
			implWait(driver);
			By button = By.xpath("//button[text()='" + btnValue + "']");

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

	// ADD NEW SURVEY TYPE
	public void insertType(String surveyType) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(typeField).isEmpty();
			if (elementExist) {
				WebElement type = driver.findElement(typeField);
				type.click();
				type.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				type.sendKeys(surveyType);

			} else {
				grep.failTest(" Survey Type Field not Available");
				logger.error(" Survey Type Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void insertDescription(String surveyDesc) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(descField).isEmpty();
			if (elementExist) {
				WebElement desc = driver.findElement(descField);
				desc.click();
				desc.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				desc.sendKeys(surveyDesc);
			} else {
				grep.failTest(" Survey Description Field not Available");
				logger.error(" Survey Description Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifySurveyTypeErrorMessage() throws Exception {
		try {
			waitForElement(surveyTypeError, 60);
			String error = driver.findElement(surveyTypeError).getText();
			grep.passTest(" Survey Type Error Messgae :" + error);
			logger.info(" Survey Type Error Messgae :" + error);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ADD SURVEY POPUP ELEMENTS
	// START AND END DATE
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

	// ADD SURVEY NAME
	public void insertSurveyName(String surveyName) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(addSurveyName).isEmpty();
			if (elementExist) {
				WebElement name = driver.findElement(addSurveyName);
				name.click();
				name.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				name.sendKeys(surveyName);

			} else {
				grep.failTest(" Survey Name Field not Available");
				logger.error(" Survey Name Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifySurveyNameErrorMessage() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(surveyNameError).isEmpty();
			if (elementExist) {
				String error = driver.findElement(surveyNameError).getText();
				grep.passTest(" Survey Name Error Messgae :" + error);
				logger.info(" Survey Name Error Messgae :" + error);
			} else {
				grep.failTest(" Survey Name Field Error not Available");
				logger.error(" Survey Name Field Error not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ADD SURVEY TYPE
	public void selectAddSurveyType(String surveyTypeOption) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(addSurveyType).isEmpty();
			if (elementExist) {
				WebElement type = driver.findElement(addSurveyType);
				Select selectType = new Select(type);
				selectType.selectByVisibleText(surveyTypeOption);
				waitTime(driver);
			} else {
				grep.failTest(" Survey Type Option not Available");
				logger.error(" Survey Type Option not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// CLICK ADD NEW SECTION
	public void clickAddNewSection() throws Exception {
		try {
			implWait(driver);
			List<WebElement> newSection = driver.findElements(addNewSection);

			if (newSection.size() > 0) {
				newSection.getLast().click();
			} else {
				grep.failTest("New Section button Not Available");
				logger.error("New Section button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// SELECT SECTION NAME
	public void selectSectionNameOption(String sectionNameOption) throws Exception {
		try {
			implWait(driver);
			List<WebElement> element = driver.findElements(selectSectionName);
			if (element.size() > 0) {
				WebElement name = element.getLast();
				Select selectname = new Select(name);
				selectname.selectByVisibleText(sectionNameOption);
				waitTime(driver);
			} else {
				grep.failTest(" Section name Option not Available");
				logger.error(" Section name Option not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ADD CUSTOM SECTION NAME
	public void addCustomSectionName(String sectionName) throws Exception {
		try {
			implWait(driver);
			List<WebElement> section = driver.findElements(customSectionName);
			if (section.size() > 0) {
				section.getLast().click();
				section.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				section.getLast().sendKeys(sectionName);

			} else {
				grep.failTest("Section Name Field not Available");
				logger.error("Section Name Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ADD SECTION WEIGHTAGE
	public void addSectionWeightage(String sectionWeight) throws Exception {
		try {
			implWait(driver);
			List<WebElement> element = driver.findElements(sectonWeightage);
			if (element.size() > 0) {
				element.getLast().click();
				element.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				element.getLast().sendKeys(sectionWeight);

			} else {
				grep.failTest("Section Weightage Field not Available");
				logger.error("Section Weightage Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// CLICK ADD MEASURE
	public void clickAddMeasure() throws Exception {
		try {
			implWait(driver);
			List<WebElement> measure = driver.findElements(addMeasure);

			if (measure.size() > 0) {
				measure.getLast().click();
			} else {
				grep.failTest("Add Measure button Not Available");
				logger.error("Add Measure button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// SELECT MEASURE NAME
	public void selectMeasureNameOption(String measureNameOption) throws Exception {
		try {
			implWait(driver);
			List<WebElement> measure = driver.findElements(selectMeasureName);

			if (measure.size() > 0) {
				WebElement name = measure.getLast();
				Select selectname = new Select(name);
				selectname.selectByVisibleText(measureNameOption);
				waitTime(driver);
			} else {
				grep.failTest(" Measure Name Option not Available");
				logger.error(" Measure Name Option not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ADD CUSTOM MEASURE NAME
	public void addCustomMeasureName(String measureName) throws Exception {
		try {
			implWait(driver);
			List<WebElement> element = driver.findElements(customMeasureName);
			if (element.size() > 0) {
				element.getLast().click();
				element.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				element.getLast().sendKeys(measureName);

			} else {
				grep.failTest("Measure Name Field not Available");
				logger.error("Measure Name Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// CLICK ADD QUESTION
	public void clickAddQuestion() throws Exception {
		try {
			implWait(driver);
			List<WebElement> question = driver.findElements(addQuestion);

			if (question.size() > 0) {
				question.getLast().click();
			} else {
				grep.failTest("Add Question button Not Available");
				logger.error("Add Question button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// ADD QUESTION NAME
	public void addQuestionName(String questionNameVal) throws Exception {
		try {
			implWait(driver);
			List<WebElement> element = driver.findElements(questionName);
			if (element.size() > 0) {
				element.getLast().click();
				element.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				element.getLast().sendKeys(questionNameVal);

			} else {
				grep.failTest("Question Name Field not Available");
				logger.error("Question Name Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// SELECT QUESTION TYPE
	public void selectQuestionTypeOption(String questionOptionVal) throws Exception {
		try {
			implWait(driver);
			List<WebElement> type = driver.findElements(questionType);
			if (type.size() > 0) {
				WebElement name = type.getLast();
				Select selectname = new Select(name);
				selectname.selectByVisibleText(questionOptionVal);
				waitTime(driver);
			} else {
				grep.failTest(" Question Name Option not Available");
				logger.error(" Question Name Option not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ADD QUESTION OPTION
	public void enterQuestionOption(String questionOptionVal) throws Exception {
		try {
			implWait(driver);
			List<WebElement> element = driver.findElements(questionOption);
			if (element.size() > 0) {
				element.getLast().click();
				element.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				element.getLast().sendKeys(questionOptionVal);

			} else {
				grep.failTest(" Question Option not Available");
				logger.error(" Question  Option not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ADD OPTION WEIGHTAGE
	public void enterQuestionOptionWeightage(String optionWeightageVal) throws Exception {
		try {
			implWait(driver);
			List<WebElement> element = driver.findElements(optionWeightage);
			if (element.size() > 0) {
				element.getLast().click();
				element.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				element.getLast().sendKeys(optionWeightageVal);

			} else {
				grep.failTest(" Question Weightage not Available");
				logger.error(" Question  Weightage not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// CLICK ADD OPTION BUTTON
	public void clickAddOption() throws Exception {
		try {
			implWait(driver);
			List<WebElement> option = driver.findElements(addOptionBtn);

			if (option.size() > 0) {
				option.getLast().click();
			} else {
				grep.failTest("Add Option button Not Available");
				logger.error("Add Option button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
	// SELECT LINEAR SCALE OPTION

	public void selectLinearValue(String linearScaleVal) throws Exception {
		try {
			implWait(driver);
			List<WebElement> element = driver.findElements(linearScaleTo);
			if (element.size() > 0) {
				element.getLast().click();
				element.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				element.getLast().sendKeys(linearScaleVal);

			} else {
				grep.failTest(" Question Option not Available");
				logger.error(" Question  Option not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// BUTTON in Section -- close, Save, Delete, Close
	public void clickButtonsInSurveyPopup(String btnValue) throws Exception {
		try {
			By button = By.xpath("//button/img[@alt='" + btnValue + "']");
			implWait(driver);

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

	public void verifySurveyCreatedShownInTable(String surveyNameVal) throws Exception {
		try {

			implWait(driver);

			List<WebElement> element = driver.findElements(createdSurveyInTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement survey : element) {
					String getSurvey = survey.getText().trim();

					if (getSurvey.equals(surveyNameVal)) {
						count++;
						System.out.println(getSurvey);

					}
				}
				if (count == 1) {
					grep.passTest("Created Survey is shown in table: " + surveyNameVal);
					logger.info("Created Survey is shown in table: " + surveyNameVal);
				} else {
					grep.failTest("Survey Not Created: " + surveyNameVal);
					logger.error("Survey Not Created: " + surveyNameVal);
				}

			} else {
				grep.failTest("Survey Not Created");
				logger.error("Survey Not Created");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void verifySurveyDeletedFromInTable(String surveyNameVal) throws Exception {
		try {

			implWait(driver);

			List<WebElement> element = driver.findElements(createdSurveyInTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement survey : element) {
					String getSurvey = survey.getText().trim();

					if (getSurvey.equals(surveyNameVal)) {
						count++;
						System.out.println(getSurvey);

					}
				}
				if (count == 0) {
					grep.passTest("Survey Deleted: " + surveyNameVal);
					logger.info("Survey Deleted: " + surveyNameVal);
				} else {
					grep.failTest("Survey Not Deleted: " + surveyNameVal);
					logger.error("Survey Not Deleted: " + surveyNameVal);
				}

			} else {
				grep.failTest("Survey Not Deleted");
				logger.error("Survey Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

}
