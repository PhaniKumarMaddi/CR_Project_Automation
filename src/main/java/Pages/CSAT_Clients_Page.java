package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class CSAT_Clients_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Clients_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Clients_Page() {
		this.driver = DriverManager.getDriver();
	}

	By clientHeader = By.cssSelector("h1.clients-header-h1");
	By searchClients = By.cssSelector("input.survey-search");
	By clientColumn = By.xpath("//table[@class='clients-table']/descendant ::tr/td[1]");

	By ownerFullName = By.xpath("//label[text()='Owner Name:']/following-sibling::input");
	By ownerEmail = By.xpath("//label[text()='Owner Email:']/following-sibling::input");
	By ownerError = By.xpath("//div[@class='MuiSnackbarContent-message css-1o19295']");

	By addOwner = By.cssSelector("div.add-owner-button>button");
	By paginationEntries = By.cssSelector("select.survey-items-per-page-select");
	By deleteOwnerContact = By.xpath("//img[@alt='Delete Owner']");

	// Send survey to client
	By selectClient = By.xpath("//label[text()='Client']/following-sibling::select");
	By selectOwner = By.cssSelector("div.custom-dropdown-toggle");
	By getSubject = By.xpath("//label[text()='Subject']/parent::div/input");
	By getBody = By.xpath("//label[text()='Body']/parent::div/textarea");
	

	public void clientHeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(clientHeader, 30);
			String verifyHeader = driver.findElement(clientHeader).getText();
			if (verifyHeader.equals(dataKeys.clientsPage)) {
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

	public void searchClient(String clientName) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchClients).isEmpty();
			if (elementExist) {
				driver.findElement(searchClients).sendKeys(clientName);
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

	public void clearSearchClient() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchClients).isEmpty();
			if (elementExist) {
				driver.findElement(searchClients).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
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

	public void clientTableValidation(String columnName) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(clientColumn).isEmpty();
			if (elementExist) {
				String colVal = driver.findElement(clientColumn).getText();
				if (colVal.contains(columnName)) {
					logger.info(columnName + " Client is Available");
					grep.passTest(columnName + " Client is Available");
				} else if (colVal.contains("No Clients Found")) {
					logger.info(colVal);
					grep.infoTest(colVal);
				} else {
					logger.error(columnName + " Client is Not Available");
					grep.failTest(columnName + " Client is Not Available");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickClientActionBtn(String projectName, String action) throws Exception {
		try {
			implWait(driver);
			By actionIcon = By.xpath("//td[text()='" + projectName
					+ "']/following-sibling::td[@class='clients-actions']/img[@title='" + action + "']");

			WebElement icon = driver.findElement(actionIcon);
			if (icon.isDisplayed()) {
				waitForElementToBeClickable(actionIcon, 30);
				icon.click();
			} else {
				logger.error(action + " is not available for " + projectName);
				grep.failTest(action + " is not available for " + projectName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void insertOwnerName(String ownerNameValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(ownerFullName).isEmpty();
			if (elementExists) {
				List<WebElement> custName = driver.findElements(ownerFullName);
				if (custName.size() > 0) {
					waitForElementToBeClickable(ownerFullName, 60);

					custName.getLast().clear();
					waitTime1(driver);
					custName.getLast().sendKeys(ownerNameValue);
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

	public void clearOwnerName() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(ownerFullName).isEmpty();
			if (elementExists) {
				List<WebElement> custName = driver.findElements(ownerFullName);
				if (custName.size() > 0) {
					waitForElement(ownerFullName, 30);
//					WebElement lastElement = custName.get(custName.size() - 1);
					custName.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
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

	public void insertOwnerEmail(String customerEmailValue) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(ownerEmail).isEmpty();
			if (elementExists) {
				List<WebElement> custEmail = driver.findElements(ownerEmail);
				if (custEmail.size() > 0) {
					waitForElementToBeClickable(ownerEmail, 60);
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

	public void clearOwnerEmail() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(ownerEmail).isEmpty();
			if (elementExists) {
				List<WebElement> custEmail = driver.findElements(ownerEmail);
				if (custEmail.size() > 0) {
					waitForElement(ownerEmail, 30);
//					WebElement lastElement = custEmail.get(custEmail.size() - 1);
					custEmail.getLast().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
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
			boolean elementExists = !driver.findElements(ownerError).isEmpty();
			if (elementExists) {
				waitForElement(ownerError, 60);

				String error = driver.findElement(ownerError).getText();
				grep.passTest("Owner Email Error :" + error);
				logger.info("Owner Email Error :" + error);
			} else {
				grep.failTest("Owner Email not available");
				logger.error("Owner Email not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void getSuccessMsg() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(ownerError).isEmpty();
			if (elementExists) {
				waitForElement(ownerError, 60);

				String error = driver.findElement(ownerError).getText();
				grep.passTest("Owner Update Message :" + error);
				logger.info("Owner Update Message :" + error);
			} else {
				grep.failTest("Owner details not updated");
				logger.error("Owner details not updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickAddOwnerBtn() throws Exception {
		try {
			implWait(driver);

			WebElement icon = driver.findElement(addOwner);
			if (icon.isDisplayed()) {
				waitForElementToBeClickable(addOwner, 30);
				icon.click();
			} else {
				logger.info("Add Owner button is not available");
				grep.infoTest("Add Owner button is not available ");
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

	public void clickPopupBtns(String btnValue) throws Exception {
		try {
			implWait(driver);
			By btnClick = By.xpath("//button[text()='" + btnValue + "']");

			WebElement icon = driver.findElement(btnClick);
			if (icon.isDisplayed()) {
				waitForElementToBeClickable(btnClick, 30);
				icon.click();
			} else {
				logger.error(btnClick + " is not available");
				grep.failTest(btnClick + " is not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyPopupBtnDisable(String btnValue) throws Exception {
		try {
			implWait(driver);
			By btnClick = By.xpath("//button[text()='" + btnValue + "']");

			WebElement icon = driver.findElement(btnClick);
			if (icon.isEnabled()) {
				logger.error(btnValue + " is Enabled");
				grep.failTest(btnValue + " is Enabled");
			} else {
				logger.info(btnValue + " is Disabled");
				grep.passTest(btnValue + " is Disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void getAccountDetails(String clientName) throws Exception {
		try {

			By ownerName = By.xpath("//td[text()='" + clientName + "']/parent::tr/td[2]");
			By ownerEmail = By.xpath("//td[text()='" + clientName + "']/parent::tr/td[3]");
			implWait(driver);
			boolean elementExist = !driver.findElements(ownerName).isEmpty();
			if (elementExist) {
				String name = driver.findElement(ownerName).getText();
				String email = driver.findElement(ownerEmail).getText();

				logger.info("Client Name: " + name);
				grep.passTest("Client Name: " + name);
				logger.info("Client Email: " + email);
				grep.passTest("Client Email: " + email);
			} else {
				logger.info(clientName + " is not available");
				grep.failTest(clientName + " is not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void deleteOwnerContactBtn() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(deleteOwnerContact).isEmpty();
			if (elementExists) {
				List<WebElement> delete = driver.findElements(deleteOwnerContact);
				if (delete.size() > 0) {
					waitForElement(deleteOwnerContact, 60);
					delete.getLast().click();
				}
			} else {
				grep.failTest("Delete Owner Contact button not available");
				logger.error("Delete Owner Contact button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void deleteOwnerContactBtn_Disabled() throws Exception {
		try {
			implWait(driver);
			WebElement delete = driver.findElement(deleteOwnerContact);
			if (delete.isEnabled()) {
				logger.error("Delete Button is Enabled");
				grep.failTest("Delete Button is Enabled");
			} else {
				logger.info("Delete Button is Disabled");
				grep.passTest("Delete Button is Disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Select Client
	public void selectClientToSendSurvey(String clientName) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(selectClient).isEmpty();
			if (elementExist) {

				WebElement selectCrs = driver.findElement(selectClient);
				Select selectValue = new Select(selectCrs);
				selectValue.selectByValue(clientName);
				waitTime(driver);

				grep.passTest("Selecting Client from dropdown: " + selectValue.getFirstSelectedOption().getText());
				logger.info("Selecting Client from dropdown: " + selectValue.getFirstSelectedOption().getText());
			} else {
				grep.failTest("Selecting Client from dropdown Failed");
				logger.error("Selecting Client from dropdown Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectClientOwnerContact(String clientName) throws Exception {
		try {
			implWait(driver);
			By selectOwnerName = By
					.xpath("//div[@class='custom-dropdown-item' and contains(text(),'" + clientName + "')]");

			boolean elementExist = !driver.findElements(selectOwner).isEmpty();
			if (elementExist) {

				driver.findElement(selectOwner).click();
				waitTime(driver);
				driver.findElement(selectOwnerName).click();
				waitTime(driver);

				grep.passTest("Selecting Client Name from Owners: " + clientName);
				logger.info("Selecting Client Name from Owners: " + clientName);
			} else {
				grep.failTest("Selecting Client from dropdown Failed");
				logger.error("Selecting Client from dropdown Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}
	
	// Retrieve subject and body
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

}
