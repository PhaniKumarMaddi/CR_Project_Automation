package Pages;

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

public class CSAT_Settings_OrgMember_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Reports_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Settings_OrgMember_Page() {
		this.driver = DriverManager.getDriver();
	}

	By orgPageHeader = By.xpath("//div[@class='org-members-tab1']/h2");

	// Pagination and export
	By orgExportBtn = By.xpath("//button[@class='download-icon-button']/img");
	By paginationEntries = By.cssSelector("select.items-per-page-select");

	// Org members fields
	By insertMailId = By.xpath("//input[@placeholder='Type email ID']");
	By selectSuggestion = By.xpath("//li[@class='suggestion-item even'][1]/div[2]/span[2]");
	By selectRoleDropdowm = By.xpath("//div[@title='Select Role']");

	By sendInviteBtn = By.cssSelector("button#invite-button11");
	By existingUserError = By
			.xpath("//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft css-1qtl9ks']/div/div");

	By searchOrgMember = By.xpath("//input[@placeholder='Search Org Member']");
	By searchMemeberList = By.xpath("//div[@class='member-list1']/div[1]/div[1]/p[1]");

	// ROLES PAGE HEADER
	public void orgMembers_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(orgPageHeader, 30);
			String verifyHeader = driver.findElement(orgPageHeader).getText();
			if (verifyHeader.equals(dataKeys.orgMemberHeader)) {
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

	// Download file
	public void clickDownloadFileBtn(String fileFormat) throws Exception {
		try {
			By downloadBtn = By.xpath("//div[@class='Project-export-dropdown']/button[text()='" + fileFormat + "']");
			implWait(driver);
			boolean elementexists = !driver.findElements(orgExportBtn).isEmpty();
			if (elementexists) {
				driver.findElement(orgExportBtn).click();
				driver.findElement(downloadBtn).click();
				driver.findElement(orgExportBtn).click();
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

	// insert mail id
	public void insertEmailToInvite(String emailVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(insertMailId).isEmpty();
			if (elementExist) {
				logger.info("Insert Email: " + emailVal);
				grep.infoTest("Insert Email: " + emailVal);
				waitTime(driver);
				WebElement emailId = driver.findElement(insertMailId);
				emailId.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				waitTime(driver);
				emailId.sendKeys(emailVal);
				waitTime(driver);
				driver.findElement(selectSuggestion).click();
			} else {
				grep.failTest(" Email Field not Available");
				logger.error(" Email Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Click Select Role
	public void clickSelectRoleDropDown() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(selectRoleDropdowm).isEmpty();
			if (elementExist) {
				driver.findElement(selectRoleDropdowm).click();
			} else {
				grep.failTest(" Select Role not Available");
				logger.error(" Select Role not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectRoleToInvite(String roleVal) throws Exception {
		try {
			implWait(driver);
			By roleSelection = By.xpath("//li[text()='" + roleVal + "']");

			boolean elementExist = !driver.findElements(roleSelection).isEmpty();
			if (elementExist) {
				driver.findElement(roleSelection).click();
			} else {
				grep.failTest("Role Dropdown not Available");
				logger.error("Role Dropdown Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickSendInvite() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(sendInviteBtn).isEmpty();
			if (elementExist) {
				driver.findElement(sendInviteBtn).click();
			} else {
				grep.failTest("Send Invite Button not Available");
				logger.error("Send Invite Button not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Error Message
	public void existingUserErrorMessage() throws Exception {
		try {
			implWait(driver);
			waitForElement(existingUserError, 60);
			String error = driver.findElement(existingUserError).getText();
			logger.info("Error Message: " + error);
			grep.infoTest("Error Message: " + error);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Search User
	public void insertValueToSearch(String searchVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchOrgMember).isEmpty();
			if (elementExist) {
				WebElement searchField = driver.findElement(searchOrgMember);
				waitTime(driver);
				searchField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				waitTime(driver);
				searchField.sendKeys(searchVal);
				waitTime(driver);
			} else {
				grep.failTest("Search Field not Available");
				logger.error("Search Field not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifySearchRelatedMember(String searchVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchMemeberList).isEmpty();
			if (elementExist) {
				String getVal = driver.findElement(searchMemeberList).getText();
				if (getVal.equalsIgnoreCase(searchVal)) {
					logger.info("Search Related Value: " + getVal);
					grep.passTest("Search Related Value: " + getVal);

				} else {
					grep.failTest(searchVal + " result not available");
					logger.error(searchVal + " result not available");
				}
			} else {
				grep.failTest(searchVal + " result not available");
				logger.error(searchVal + " result not available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Role Update Functionality
	public void beforeUpdateRoleForUser(String userName) throws Exception {
		try {
			By selectRoleForMember = By.xpath("//p[text()='" + userName + "']/parent::div/following-sibling::div/div");
			implWait(driver);
			boolean elementExist = !driver.findElements(selectRoleForMember).isEmpty();
			if (elementExist) {
				String getBeforeVal = driver.findElement(selectRoleForMember).getText();
				waitTime(driver);
				logger.info("Role Before Update: " + getBeforeVal);
				grep.infoTest("Role Before Update: " + getBeforeVal);
				waitTime(driver);

			} else {
				grep.failTest("Role Update for User not available");
				logger.error("Role Update for User not available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void updateRoleForUser(String userName, String roleVal) throws Exception {
		try {
			By selectRoleForMember = By.xpath("//p[text()='" + userName + "']/parent::div/following-sibling::div/div");
			By roleSelection = By.xpath("//li[text()='" + roleVal + "']");
			implWait(driver);
			boolean elementExist = !driver.findElements(selectRoleForMember).isEmpty();
			if (elementExist) {
				driver.findElement(selectRoleForMember).click();
				waitTime(driver);
				driver.findElement(roleSelection).click();
				waitTime2(driver);

			} else {
				grep.failTest("Role Update for User not available");
				logger.error("Role Update for User not available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void afterUpdateRoleForUser(String userName) throws Exception {
		try {
			By selectRoleForMember = By.xpath("//p[text()='" + userName + "']/parent::div/following-sibling::div/div");
			implWait(driver);
			boolean elementExist = !driver.findElements(selectRoleForMember).isEmpty();
			if (elementExist) {
				String getAfterVal = driver.findElement(selectRoleForMember).getText();
				waitTime(driver);
				logger.info("Role After Update: " + getAfterVal);
				grep.infoTest("Role After Update: " + getAfterVal);
				waitTime(driver);

			} else {
				grep.failTest("Role Update for User not available");
				logger.error("Role Update for User not available");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

}
