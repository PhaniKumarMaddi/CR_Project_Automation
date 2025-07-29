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

public class CSAT_Settings_Teams_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Settings_Teams_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Settings_Teams_Page() {
		this.driver = DriverManager.getDriver();
	}

	By teamsPageHeader = By.xpath("//div[@class='team-name-bar']/h2");

	// Pagination and export
	By orgExportBtn = By.xpath("//button[@class='download-icon-button']/img");
	By paginationEntries = By.cssSelector("select.items-per-page-select");

	By searchTeamAndUser = By.xpath("//input[@placeholder='Search Team and User']");

	By teamName = By.xpath("//div[@class='teams-grid'][1]/button[1]/h3");
	By teamCount = By.xpath("//div[@class='teams-grid'][1]/button[1]/div/p");

	By getTeamDetailHeader = By.xpath("//div[@class='team-details-container']/h2[1]");
	By teamNameInTeamDetailPage = By.xpath("//h2[text()='Team Name']/following-sibling::div[1]/input");

	By backToTeams = By.xpath("//button[text()='Teams']");

	// Team Details fields
	By insertMailId = By.xpath("//input[@placeholder='Type email ID']");
	By selectSuggestion = By.xpath("//li[@class='suggestion-item even'][1]/div[2]/span[2]");
	By selectRoleDropdowm = By.xpath("//div[@title='Select Role']");

	By sendInviteBtn = By.cssSelector("button#invite-button11");
	By existingUserError = By
			.xpath("//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft css-1qtl9ks']/div/div");

	By searchOrgMember = By.xpath("//input[@placeholder='Search User']");
	By searchMemberList = By.xpath("//div[@class='member-list1']/div[1]/div[1]/p[1]");

	// TEAMS PAGE HEADER
	public void teams_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(teamsPageHeader, 30);
			String verifyHeader = driver.findElement(teamsPageHeader).getText();
			if (verifyHeader.equals(dataKeys.teamsPage)) {
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

	// Search User
	public void insertValForSearchTeamAndUser(String searchVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchTeamAndUser).isEmpty();
			if (elementExist) {
				WebElement searchField = driver.findElement(searchTeamAndUser);
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

	public void clearSearchTeamAndUser(String searchVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(searchTeamAndUser).isEmpty();
			if (elementExist) {
				WebElement searchField = driver.findElement(searchTeamAndUser);
				waitTime(driver);
				searchField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
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

	// get Team Name
	public void getTeamName() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(teamName).isEmpty();
			if (elementExist) {
				String name = driver.findElement(teamName).getText();
				logger.info("Team Name: " + name);
				grep.infoTest("Team Name: " + name);

				waitTime(driver);
			} else {
				grep.failTest("Team name not Available");
				logger.error("Team name not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickTeam() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(teamName).isEmpty();
			if (elementExist) {
				driver.findElement(teamName).click();
				waitTime(driver);
			} else {
				grep.failTest("Team  not Available");
				logger.error("Team not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// get Team Count
	public void getTeamCount() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(teamCount).isEmpty();
			if (elementExist) {
				String count = driver.findElement(teamCount).getText();
				logger.info("Team Count: " + count);
				grep.infoTest("Team Count: " + count);

				waitTime(driver);
			} else {
				grep.failTest("Team Count not Available");
				logger.error("Team count not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// TEAM DETAIL PAGE HEADER
	public void teamDetail_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(getTeamDetailHeader).isEmpty();
			if (elementExists) {
				waitForElement(getTeamDetailHeader, 30);
				String verifyHeader = driver.findElement(getTeamDetailHeader).getText();

				logger.info("Header is Available: " + verifyHeader);
				grep.passTest("Header is Available: " + verifyHeader);
			} else {
				logger.error("Header is not Available");
				grep.failTest("Header is not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET TEAM NAME IN TEAM DETAIL PAGE
	public void getTeamNameInTeamDetailPage() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(teamNameInTeamDetailPage).isEmpty();
			if (elementExist) {
				String name = driver.findElement(teamNameInTeamDetailPage).getAttribute("value");
				logger.info("Team Name in Team Detail Page: " + name);
				grep.infoTest("Team Name in Team Detail Page: " + name);

				waitTime(driver);
			} else {
				grep.failTest("Team name not Available");
				logger.error("Team name not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Navigate back to teams page
	public void clickBackToTeamPage() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(backToTeams).isEmpty();
			if (elementExist) {
				driver.findElement(backToTeams).click();
				waitTime(driver);
			} else {
				grep.failTest("Back to Teams Page not Available");
				logger.error("Back to Teams Page not Available");
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
				grep.failTest("Email Field not Available");
				logger.error("Email Field not Available");
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
				grep.failTest("Select Role not Available");
				logger.error("Select Role not Available");
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
			grep.passTest("Error Message: " + error);
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
		public void clearSearchUser() throws Exception {
			try {
				implWait(driver);
				boolean elementExist = !driver.findElements(searchOrgMember).isEmpty();
				if (elementExist) {
					WebElement searchField = driver.findElement(searchOrgMember);
					waitTime(driver);
					searchField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
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
			boolean elementExist = !driver.findElements(searchMemberList).isEmpty();
			if (elementExist) {
				String getVal = driver.findElement(searchMemberList).getText();
				if (getVal.contains(searchVal)) {
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
