package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class CSAT_Roles_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Roles_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Roles_Page() {
		this.driver = DriverManager.getDriver();
	}

	By rolesHeader = By.xpath("//div[@class='role-page-header']/h2");

	By role_Col_Header = By.xpath("//table[@class='role-table']/thead/tr/th[1]");
	By description_Col_Header = By.xpath("//table[@class='role-table']/thead/tr/th[2]");
	By lastModifiedBy_Col_Header = By.xpath("//table[@class='role-table']/thead/tr/th[3]");
	By lastModifiedOn_Col_Header = By.xpath("//table[@class='role-table']/thead/tr/th[4]");

	By admin_Role = By.xpath("//table[@class='role-table']/tbody/tr[1]/td[1]");
	By owner_Role = By.xpath("//table[@class='role-table']/tbody/tr[2]/td[1]");
	By contributor_Role = By.xpath("//table[@class='role-table']/tbody/tr[3]/td[1]");
	By reader_Role = By.xpath("//table[@class='role-table']/tbody/tr[4]/td[1]");

	// ROLES PAGE HEADER
	public void rolesHeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(rolesHeader, 30);
			String verifyHeader = driver.findElement(rolesHeader).getText();
			if (verifyHeader.equals(dataKeys.rolesPage)) {
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

	// ROLES COLUMN HEADER
	public void roles_Column_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(role_Col_Header, 30);
			String verifyHeader = driver.findElement(role_Col_Header).getText();
			if (verifyHeader.equals(dataKeys.roleColHeader)) {
				logger.info("Column Header is Valid: " + verifyHeader);
				grep.passTest("Column Header is Valid: " + verifyHeader);
			} else {
				logger.error("Column Header is not Valid: " + verifyHeader);
				grep.failTest("Column Header is not Valid: " + verifyHeader);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// DESCRIPTION COLUMN HEADER
	public void description_Column_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(description_Col_Header, 30);
			String verifyHeader = driver.findElement(description_Col_Header).getText();
			if (verifyHeader.equals(dataKeys.DescColHeader)) {
				logger.info("Column Header is Valid: " + verifyHeader);
				grep.passTest("Column Header is Valid: " + verifyHeader);
			} else {
				logger.error("Column Header is not Valid: " + verifyHeader);
				grep.failTest("Column Header is not Valid: " + verifyHeader);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// LAST MODIFIED BY COLUMN HEADER
	public void lastModifiedBy_Column_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(lastModifiedBy_Col_Header, 30);
			String verifyHeader = driver.findElement(lastModifiedBy_Col_Header).getText();
			if (verifyHeader.equals(dataKeys.lastModifiedBy_ColHeader)) {
				logger.info("Column Header is Valid: " + verifyHeader);
				grep.passTest("Column Header is Valid: " + verifyHeader);
			} else {
				logger.error("Column Header is not Valid: " + verifyHeader);
				grep.failTest("Column Header is not Valid: " + verifyHeader);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// LAST MODIFIED ON COLUMN HEADER
	public void lastModifiedOn_Column_HeaderValidation() throws Exception {
		try {
			implWait(driver);
			waitForElement(lastModifiedOn_Col_Header, 30);
			String verifyHeader = driver.findElement(lastModifiedOn_Col_Header).getText();
			if (verifyHeader.equals(dataKeys.lastModifiedOn_ColHeader)) {
				logger.info("Column Header is Valid: " + verifyHeader);
				grep.passTest("Column Header is Valid: " + verifyHeader);
			} else {
				logger.error("Column Header is not Valid: " + verifyHeader);
				grep.failTest("Column Header is not Valid: " + verifyHeader);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// ADMINISTRATOR ROLE
	public void admin_Role_Validation() throws Exception {
		try {
			implWait(driver);
			waitForElement(admin_Role, 30);
			String verifyRole = driver.findElement(admin_Role).getText();
			if (verifyRole.equals(dataKeys.adminRole)) {
				logger.info("Roles is Valid: " + verifyRole);
				grep.passTest("Role is Valid: " + verifyRole);
			} else {
				logger.error("Role is not Valid: " + verifyRole);
				grep.failTest("Role is not Valid: " + verifyRole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// OWNER ROLE
	public void owner_Role_Validation() throws Exception {
		try {
			implWait(driver);
			waitForElement(owner_Role, 30);
			String verifyRole = driver.findElement(owner_Role).getText();
			if (verifyRole.equals(dataKeys.ownerRole)) {
				logger.info("Roles is Valid: " + verifyRole);
				grep.passTest("Role is Valid: " + verifyRole);
			} else {
				logger.error("Role is not Valid: " + verifyRole);
				grep.failTest("Role is not Valid: " + verifyRole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// CONTRIBUTOR ROLE
	public void contributor_Role_Validation() throws Exception {
		try {
			implWait(driver);
			waitForElement(contributor_Role, 30);
			String verifyRole = driver.findElement(contributor_Role).getText();
			if (verifyRole.equals(dataKeys.contributorRole)) {
				logger.info("Roles is Valid: " + verifyRole);
				grep.passTest("Role is Valid: " + verifyRole);
			} else {
				logger.error("Role is not Valid: " + verifyRole);
				grep.failTest("Role is not Valid: " + verifyRole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// READER
	public void reader_Role_Validation() throws Exception {
		try {
			implWait(driver);
			waitForElement(reader_Role, 30);
			String verifyRole = driver.findElement(reader_Role).getText();
			if (verifyRole.equals(dataKeys.ReaderRole)) {
				logger.info("Roles is Valid: " + verifyRole);
				grep.passTest("Role is Valid: " + verifyRole);
			} else {
				logger.error("Role is not Valid: " + verifyRole);
				grep.failTest("Role is not Valid: " + verifyRole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// GET ROLE DESCRIPTION

	public void getRoleDescription(String role) throws Exception {
		try {
			By descriptionForRole = By.xpath("//td[text()='" + role + "']/following-sibling::td[1]");
			implWait(driver);

			WebElement verifyRole = driver.findElement(descriptionForRole);
			if (verifyRole.isDisplayed()) {
				String roleDesc = verifyRole.getText();
				logger.info("Role Description : " + roleDesc);
				grep.passTest("Role Desciption : " + roleDesc);
			} else {
				logger.error("Role Desciption is not available");
				grep.failTest("Role Desciption is not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
}
