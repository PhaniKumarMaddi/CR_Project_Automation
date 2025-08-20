package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public void clearSearchClient(String clientName) throws Exception {
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
				logger.info(action + " is not available for " + projectName);
				grep.infoTest(action + " is not available for " + projectName);
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

	public void clearCustomerName() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(ownerFullName).isEmpty();
			if (elementExists) {
				List<WebElement> custName = driver.findElements(ownerFullName);
				if (custName.size() > 0) {
					waitForElement(ownerFullName, 30);
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

	public void clearCustomerEmail() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(ownerEmail).isEmpty();
			if (elementExists) {
				List<WebElement> custEmail = driver.findElements(ownerEmail);
				if (custEmail.size() > 0) {
					waitForElement(ownerEmail, 30);
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

}
