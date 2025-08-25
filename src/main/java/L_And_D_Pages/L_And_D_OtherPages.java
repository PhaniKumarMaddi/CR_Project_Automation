package L_And_D_Pages;

import java.io.Closeable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class L_And_D_OtherPages extends WaitsManager {

	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(L_And_D_MyCoursesPage.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public L_And_D_OtherPages() {
		this.driver = DriverManager.getDriver();
	}

	By searchDept = By.xpath("//input[@placeholder='Search departments...']");
	By noDeptMsg = By.cssSelector("div.no-results>p");
	By clearDeptBtn = By.cssSelector("button.clear-filter-btn");

	By deptpageInfo = By.cssSelector("div.department-info>h1");
	By searchCourse = By.xpath("//input[@class='search-input']");
	By noCourseMsg = By.cssSelector("div.no-courses-message>p");

	By adminHeader = By.xpath("//span[text()='Admin - CriticalRiver Learning & Development']");

	// search department
	public void searchDepartment(String deptName) throws Exception {
		try {
			implWait(driver);

			boolean elementExist = !driver.findElements(searchDept).isEmpty();
			if (elementExist) {

				driver.findElement(searchDept).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				waitTime(driver);
				driver.findElement(searchDept).sendKeys(deptName);
				grep.passTest("Searching " + deptName + " Name");
				logger.info("Searching " + deptName + " Name");
			} else {
				grep.failTest("Seach department Element Not Found");
				logger.error("Seach department Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Explore selected department
	public void selectAndExploreDepartment(String deptName) throws Exception {
		try {
			implWait(driver);
			By selectDepartment = By
					.xpath("//div[@class='card-body']/h3[text()='" + deptName + "']/following-sibling::a");

			boolean elementExist = !driver.findElements(selectDepartment).isEmpty();
			if (elementExist) {

				driver.findElement(selectDepartment).click();

				String exploreDeptHeader = driver.findElement(deptpageInfo).getText();
				if (exploreDeptHeader.equals(deptName)) {
					grep.passTest("Exploring " + deptName + " Name");
					logger.info("Exploring " + deptName + " Name");
				} else {
					grep.failTest(deptName + " Not Available");
					logger.info(deptName + " Not Available");
				}

			} else {
				grep.failTest("Seach department Element Not Found");
				logger.error("Seach department Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getNonExistingDeptMsg() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(noDeptMsg).isEmpty();

			if (elementExist) {

				String msg = driver.findElement(noDeptMsg).getText();
				grep.passTest("No Department Found Message: " + msg);
				logger.info("No Department Found Message: " + msg);
				waitTime(driver);
//				driver.findElement(By.cssSelector("button.clear-filter-btn")).click();
			} else {

				grep.failTest("Seach non existing department failed");
				logger.error("Seach non existing department failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clearSearch() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(clearDeptBtn).isEmpty();

			if (elementExist) {

				driver.findElement(clearDeptBtn).click();
			} else {

				grep.failTest("Seach non existing department failed");
				logger.error("Seach non existing department failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// search courses
	public void searchCoursesInDept(String coursename) throws Exception {
		try {
			implWait(driver);

			boolean elementExist = !driver.findElements(searchCourse).isEmpty();

			if (elementExist) {

				driver.findElement(searchCourse).sendKeys(coursename);
				grep.passTest("Searching " + coursename + " Name");
				logger.info("Searching " + coursename + " Name");
			} else {

				grep.failTest("Seach course Element Not Found");
				logger.error("Seach courset Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Enroll selected course
	public void enrollCourseInDepartment(String courseName) throws Exception {
		try {
			implWait(driver);
			By enrollCourse = By.xpath("//h3[text()='" + courseName + "']/following-sibling::div[2]/button");

			boolean elementExist = !driver.findElements(enrollCourse).isEmpty();
			if (elementExist) {

				driver.findElement(enrollCourse).click();
				grep.passTest("Enrolling " + courseName + " Course");
				logger.info("Enrolling " + courseName + " Course");
			} else {
				grep.failTest("Enroll Course Not Found");
				logger.error("Enroll Course Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getNonExistingCourseMsg() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(noCourseMsg).isEmpty();

			if (elementExist) {

				String msg = driver.findElement(noCourseMsg).getText();
				grep.passTest("No Course Found Message: " + msg);
				logger.info("No Course Found Message: " + msg);
				waitTime(driver);
//				driver.findElement(By.cssSelector("button.clear-filter-btn")).click();
			} else {

				grep.failTest("Seach non existing department failed");
				logger.error("Seach non existing department failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Verify Cards in Admin Page DASHBOARD TAB
	public void adminCardsText(String cardName) throws Exception {
		try {
			implWait(driver);
			By adminCards = By.xpath("//h3[text()='" + cardName + "']/following-sibling::p");
			boolean elementExist = !driver.findElements(adminCards).isEmpty();
			if (elementExist) {

				String getCardValue = driver.findElement(adminCards).getText();
				grep.passTest(cardName + " card Value: " + getCardValue);
				logger.info(cardName + " card Value: " + getCardValue);
			} else {
				grep.failTest(cardName + " Admin card Not Found");
				logger.error(cardName + " Admin card Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void validateCertificateAdminCard(String cardName) throws Exception {
//		String textVal = null;
		try {
			implWait(driver);
			By adminCards = By.xpath("//h3[text()='" + cardName + "']/following-sibling::p");
			By table = By.xpath(
					"//h2[text()='Certificates']/following-sibling::div/descendant::span[@class='pagination-info']");
			boolean elementExist = !driver.findElements(adminCards).isEmpty();
			if (elementExist) {

				String textVal = driver.findElement(adminCards).getText();
				String tableData = driver.findElement(table).getText();
				if (tableData.contains(textVal)) {
					grep.passTest(cardName + " Admin card Values Match " + textVal);
					logger.info(cardName + " Admin card Values Match " + textVal);
				} else {

					grep.failTest(cardName + " Admin card values Not match " + textVal);
					logger.error(cardName + " Admin card Values Not match " + textVal);
				}

			} else {
				grep.failTest(cardName + " Admin card Not Found");
				logger.error(cardName + " Admin card Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickCertificateAdminCards() throws Exception {
		try {
			implWait(driver);
			By adminCardsClick = By.xpath("//h3[text()='Certificates']/parent::div");

			boolean elementExist = !driver.findElements(adminCardsClick).isEmpty();
			if (elementExist) {

				driver.findElement(adminCardsClick).click();

			} else {
				grep.failTest("Certificates Admin card Not Found");
				logger.error("Certificates Admin card Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getCertificateDetails(String tableName) throws Exception {
		try {
			implWait(driver);
			By getTableData = By
					.xpath("//h2[text()='" + tableName + "']/following-sibling::table[@class='course-table']/tbody/tr");
			List<WebElement> table = driver.findElements(getTableData);
			if (table.size() > 0) {
				for (WebElement getDetails : table) {
					String details = getDetails.getText();
					grep.passTest("Certificates Details: " + details);
					logger.info("Certificates Details: " + details);
				}
			} else {
				grep.failTest("Certificates Details Not Avaialable");
				logger.error("Certificates Details Not Avaialable");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

// open certificate
	public void openCertificate(String tableName) throws Exception {
		try {
			implWait(driver);
			By getTableData = By.xpath(
					"//h2[text()='" + tableName + "']/following-sibling::table[@class='course-table']/tbody/tr/td[4]");
			List<WebElement> table = driver.findElements(getTableData);
			if (table.size() > 0) {
				table.getFirst().click();
				grep.passTest("View Certificates");
				logger.info("View Certificates");
			} else {
				grep.failTest("No Certificates Available");
				logger.error("No Certificates Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickCloseCertificate() throws Exception {
		try {
			implWait(driver);
			By closeBtn = By.cssSelector("button.certificate-modal-close");

			boolean elementExist = !driver.findElements(closeBtn).isEmpty();
			if (elementExist) {

				driver.findElement(closeBtn).click();
				grep.passTest("Close Certificate");
				logger.info("Close Certificate");
			} else {
				grep.failTest("Close Certificate not Available");
				logger.error("Close Certificate not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Search filter in table
	public void searchDashboardTable(String tableName, String searchFieldName, String searchValue) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath(
					"//h2[text()='" + tableName + "']/following-sibling::div/input[@name='" + searchFieldName + "']");

			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {
//				scrollView(searchBy);

				driver.findElement(searchBy).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				driver.findElement(searchBy).sendKeys(searchValue);

			} else {
				grep.failTest("Table is not available in dashboard tab");
				logger.error("Table is not available in dashboard tab");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clearDashboardTable(String tableName) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h2[text()='" + tableName + "']/following-sibling::div[1]/button");

			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

				driver.findElement(searchBy).click();

			} else {
				grep.failTest("Table is not available in dashboard tab");
				logger.error("Table is not available in dashboard tab");
			}
			scrollView(adminHeader);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void exportDashboardTable(String tableName, String fileFormat) throws Exception {
		try {
			implWait(driver);

			By export = By.xpath("//h2[text()='" + tableName
					+ "']/following-sibling::div[1]/descendant::button[@class='export-table-download-button']");
			boolean elementExist = !driver.findElements(export).isEmpty();
			if (elementExist) {
				waitTime(driver);

				driver.findElement(export).click();
				waitTime(driver);
				driver.findElement(
						By.xpath("//div[@class='export-table-dropdown']/button[contains(text(),'" + fileFormat + "')]"))
						.click();

				grep.infoTest("Exporting " + fileFormat + " for " + tableName + " Table");
				logger.info("Exporting " + fileFormat + " for " + tableName + " Table");

			} else {
				grep.failTest("Table is not available in dashboard tab " + tableName);
				logger.error("Table is not available in dashboard tab " + tableName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void noRecordsDashboardTable(String tableName) throws Exception {
		try {
			implWait(driver);

			By message = By.xpath("//h2[text()='" + tableName + "']/following-sibling::table/descendant::td");
			boolean elementExist = !driver.findElements(message).isEmpty();
			if (elementExist) {
				waitTime(driver);

				String noDataMsg = driver.findElement(message).getText();

				grep.passTest("Non Existing Search for " + tableName + " : " + noDataMsg);
				logger.info("Non Existing Search for " + tableName + " : " + noDataMsg);

			} else {
				grep.failTest("Table is not available in dashboard tab " + tableName);
				logger.error("Table is not available in dashboard tab " + tableName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyDataInTable(String tableName, String verifyValue) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h2[text()='" + tableName + "']/following-sibling::table/tbody/tr");

			List<WebElement> table = driver.findElements(searchBy);
			if (table.size() > 0) {
				boolean isValid = true;
				for (WebElement rows : table) {
					String rowvalues = rows.getText();
					if (!rowvalues.contains(verifyValue)) {
						isValid = false;
						break;
					}
				}
				if (isValid && table.size() > 0) {
					System.out.println("✅ Search validation passed. All Values match: " + verifyValue);
					grep.passTest("✅ Search validation passed. All Values match: " + verifyValue);
					logger.info("✅ Search validation passed. All Values match: " + verifyValue);
				} else {
					System.out.println("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
					grep.failTest("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
					logger.error("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
				}

			} else {
				grep.failTest("No Data found");
				logger.error("No Data found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// click total users and get user details
	public void clickTotalUsersInDashboard(String tableName) throws Exception {
		try {
			implWait(driver);
			By getTableData = By.xpath("//h2[text()='" + tableName + "']/following-sibling::table/tbody/tr/td[3]");
			List<WebElement> table = driver.findElements(getTableData);
			if (table.size() > 0) {
				table.getFirst().click();
				grep.passTest("Click Total Users");
				logger.info("Click Total Users");
			} else {
				grep.failTest("No Users Enrolled");
				logger.error("No Users Enrolled");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void validateTotalUsersInDashboard(String tableName) throws Exception {
		try {
			implWait(driver);
			By getTableData = By.xpath("//h2[text()='" + tableName + "']/following-sibling::table/tbody/tr/td[3]");
			By certificateTableData = By.xpath(
					"//h2[text()='Certificates']/following-sibling::div/descendant::span[@class='pagination-info']");
			List<WebElement> table = driver.findElements(getTableData);
			if (table.size() > 0) {

				String textVal = table.getFirst().getText();
//				table.getFirst().click();

				String tableData = driver.findElement(certificateTableData).getText();
				if (tableData.contains(textVal)) {
					grep.passTest(tableName + " Data Values Match " + textVal);
					logger.info(tableName + " Data Values Match " + textVal);
				} else {

					grep.failTest(tableName + " Data Values Not match " + textVal);
					logger.error(tableName + " Data Values Not match " + textVal);

				}
			} else {
				grep.failTest("No Users Enrolled");
				logger.error("No Users Enrolled");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// for certificates from course table
	public void validateCertificatesInDashboard(String tableName) throws Exception {
		try {
			implWait(driver);
			By getTableData = By.xpath("//h2[text()='" + tableName + "']/following-sibling::table/tbody/tr/td[5]");
			By certificateTableData = By.xpath(
					"//h2[text()='Certificates']/following-sibling::div/descendant::span[@class='pagination-info']");
			List<WebElement> table = driver.findElements(getTableData);
			if (table.size() > 0) {

				String textVal = table.getFirst().getText();
				table.getFirst().click();
				waitTime2(driver);

				String tableData = driver.findElement(certificateTableData).getText();
				if (tableData.contains(textVal)) {
					grep.passTest(tableName + " Data Values Match " + textVal);
					logger.info(tableName + " Data Values Match " + textVal);
				} else {

					grep.failTest(tableName + " Data Values Not match " + textVal);
					logger.error(tableName + " Data Values Not match " + textVal);

				}
			} else {
				grep.failTest("No Users Enrolled");
				logger.error("No Users Enrolled");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Search filter in table
	public void searchTestsTable(String tableName, String searchFieldName, String searchValue) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h3[text()='" + tableName + "']/following-sibling::div/input[@placeholder='"
					+ searchFieldName + "']");

			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {
				driver.findElement(searchBy).click();
				driver.findElement(searchBy).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				driver.findElement(searchBy).sendKeys(searchValue);

			} else {
				grep.failTest("Table is not available in dashboard tab");
				logger.error("Table is not available in dashboard tab");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clearTestsTable(String tableName) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h3[text()='" + tableName + "']/following-sibling::div[1]/button");
			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

				driver.findElement(searchBy).click();

			} else {
				grep.failTest("Table is not available in dashboard tab");
				logger.error("Table is not available in dashboard tab");
			}
			scrollView(adminHeader);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void exportTestsTable(String tableName, String fileFormat) throws Exception {
		try {
			implWait(driver);
			By export = By.xpath("//h3[text()='" + tableName
					+ "']/following-sibling::div[1]/descendant::button[@class='export-table-download-button']");
			boolean elementExist = !driver.findElements(export).isEmpty();
			if (elementExist) {

				driver.findElement(export).click();
				waitTime(driver);
				driver.findElement(
						By.xpath("//div[@class='export-table-dropdown']/button[contains(text(),'" + fileFormat + "')]"))
						.click();

				grep.infoTest("Exporting " + fileFormat + " for " + tableName + " Table");
				logger.info("Exporting " + fileFormat + " for " + tableName + " Table");

			} else {
				grep.failTest("Table is not available in Tests tab");
				logger.error("Table is not available in Tests tab");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void noRecordsTestsTable(String tableName) throws Exception {
		try {
			implWait(driver);

			By message = By.xpath("//h3[text()='" + tableName + "']/following-sibling::table/descendant::td");
			boolean elementExist = !driver.findElements(message).isEmpty();
			if (elementExist) {
				waitTime(driver);

				String noDataMsg = driver.findElement(message).getText();

				grep.passTest("Non Existing Search for " + tableName + " : " + noDataMsg);
				logger.info("Non Existing Search for " + tableName + " : " + noDataMsg);

			} else {
				grep.failTest("Table is not available in tests tab " + tableName);
				logger.error("Table is not available in tests tab " + tableName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyDataInTestTable(String tableName, String verifyValue) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h3[text()='" + tableName + "']/following-sibling::table/tbody/tr");

			List<WebElement> table = driver.findElements(searchBy);
			if (table.size() > 0) {
				boolean isValid = true;
				for (WebElement rows : table) {
					String rowvalues = rows.getText();
					if (!rowvalues.contains(verifyValue)) {
						isValid = false;
						break;
					}
				}
				if (isValid && table.size() > 0) {
					System.out.println("✅ Search validation passed. All Values match: " + verifyValue);
					grep.passTest("✅ Search validation passed. All Values match: " + verifyValue);
					logger.info("✅ Search validation passed. All Values match: " + verifyValue);
				} else {
					System.out.println("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
					grep.failTest("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
					logger.error("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
				}

			} else {
				grep.failTest("No Data found");
				logger.error("No Data found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// ROLES TAB
	// Search filter in table
	public void searchRolesTable(String tableName, String searchFieldName, String searchValue) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h1[text()='" + tableName + "']/following-sibling::div/input[@placeholder='"
					+ searchFieldName + "']");

			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

				driver.findElement(searchBy).click();
				driver.findElement(searchBy).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				driver.findElement(searchBy).sendKeys(searchValue);

			} else {
				grep.failTest("Table is not available in dashboard tab");
				logger.error("Table is not available in dashboard tab");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clearRolesTable(String tableName) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h1[text()='" + tableName + "']/following-sibling::div[1]/button");
			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

				driver.findElement(searchBy).click();

			} else {
				grep.failTest("Table is not available in dashboard tab");
				logger.error("Table is not available in dashboard tab");
			}
			scrollView(adminHeader);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyDataInRolesTable(String tableName, String verifyValue) throws Exception {
		try {
			implWait(driver);
			By searchBy = By.xpath("//h1[text()='" + tableName + "']/following-sibling::table/tbody/tr");

			List<WebElement> table = driver.findElements(searchBy);
			if (table.size() > 0) {
				boolean isValid = true;
				for (WebElement rows : table) {
					String rowvalues = rows.getText();
					if (!rowvalues.contains(verifyValue)) {
						isValid = false;
						break;
					}
				}
				if (isValid && table.size() > 0) {
					System.out.println("✅ Search validation passed. All Values match: " + verifyValue);
					grep.passTest("✅ Search validation passed. All Values match: " + verifyValue);
					logger.info("✅ Search validation passed. All Values match: " + verifyValue);
				} else {
					System.out.println("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
					grep.failTest("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
					logger.error("❌ Search validation failed. Mismatched Value found or no rows: " + verifyValue);
				}

			} else {
				grep.failTest("No Data found");
				logger.error("No Data found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void exportRolesTable(String tableName, String fileFormat) throws Exception {
		try {
			implWait(driver);
			By export = By.xpath("//h1[text()='" + tableName + "']/following-sibling::div[1]/div[1]/button");
			boolean elementExist = !driver.findElements(export).isEmpty();
			if (elementExist) {

				driver.findElement(export).click();
				waitTime(driver);
				driver.findElement(
						By.xpath("//div[@class='export-table-dropdown']/button[contains(text(),'" + fileFormat + "')]"))
						.click();

				grep.infoTest("Exporting " + fileFormat + " for " + tableName + " Table");
				logger.info("Exporting " + fileFormat + " for " + tableName + " Table");

			} else {
				grep.failTest("Table is not available in Roles tab");
				logger.error("Table is not available in Roles tab");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void noRecordsRolesTable(String tableName) throws Exception {
		try {
			implWait(driver);

			By message = By.xpath("//h1[text()='" + tableName + "']/following-sibling::table/descendant::td");
			boolean elementExist = !driver.findElements(message).isEmpty();
			if (elementExist) {
				waitTime(driver);

				String noDataMsg = driver.findElement(message).getText();

				grep.passTest("Non Existing Search for " + tableName + " : " + noDataMsg);
				logger.info("Non Existing Search for " + tableName + " : " + noDataMsg);

			} else {
				grep.failTest("Table is not available in tests tab " + tableName);
				logger.error("Table is not available in tests tab " + tableName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Create and Generate Assessment

	public void selectCourseInAssessment(String content, String courseValues) throws Exception {
		try {
			implWait(driver);
			By select_course = By.xpath("//h3[text()='" + content + "']/following-sibling::form/select[1]");
			boolean elementExist = !driver.findElements(select_course).isEmpty();
			if (elementExist) {

				WebElement selectCrs = driver.findElement(select_course);
				Select selectValue = new Select(selectCrs);
				selectValue.selectByValue(courseValues);
				waitTime(driver);

				grep.passTest("Selecting Course from dropdown: " + selectValue.getFirstSelectedOption().getText());
				logger.info("Selecting Course from dropdown: " + selectValue.getFirstSelectedOption().getText());
			} else {
				grep.failTest("Selecting Course from dropdown Failed");
				logger.error("Selecting Course from dropdown Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectAssessment_number(String content, String assmtValues) throws Exception {
		try {
			implWait(driver);
			By select_assmntNumber = By.xpath("//h3[text()='" + content + "']/following-sibling::form/select[2]");
			boolean elementExist = !driver.findElements(select_assmntNumber).isEmpty();
			if (elementExist) {

				WebElement selectAssmt = driver.findElement(select_assmntNumber);
				Select selectValue = new Select(selectAssmt);
				selectValue.selectByValue(assmtValues);
				waitTime(driver);

				grep.passTest(
						"Selecting Assessment Number from dropdown: " + selectValue.getFirstSelectedOption().getText());
				logger.info(
						"Selecting Assessment Number from dropdown: " + selectValue.getFirstSelectedOption().getText());
			} else {
				grep.failTest("Selecting Assessment Number from dropdown failed");
				logger.error("Selecting Assessment Number from dropdown failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void enter_Assmt_or_UserId(String content, String userId) throws Exception {
		try {
			implWait(driver);
			By createAssmt_assmntId = By.xpath("//h3[text()='" + content + "']/following-sibling::form/input");
			boolean elementExist = !driver.findElements(createAssmt_assmntId).isEmpty();
			if (elementExist) {

				driver.findElement(createAssmt_assmntId).sendKeys(userId);
				waitTime(driver);

				grep.passTest("Enter Assessment or User Id: " + userId);
				logger.info("Enter Assessment or User Id: " + userId);
			} else {
				grep.failTest("Assessment or User id insertion Failed");
				logger.error("Assessment or User id insertion Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickCreateOrGenerate_Assessment(String content) throws Exception {
		try {
			implWait(driver);
			By createAssmt_btn = By.xpath("//h3[text()='" + content + "']/following-sibling::form/button");
			boolean elementExist = !driver.findElements(createAssmt_btn).isEmpty();
			if (elementExist) {

				driver.findElement(createAssmt_btn).click();

				grep.passTest("Click Generated button for: " + content);
				logger.info("Click Generated button for: " + content);
			} else {
				grep.failTest("Click Submit button failed");
				logger.error("Click Submit button failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void generatedSuccessMessage(String content) throws Exception {
		try {
			implWait(driver);
			By createAssmt_SuccessMsg = By.xpath("//h3[text()='" + content + "']/following-sibling::p");

			waitForElement(createAssmt_SuccessMsg, 90);

			String message = driver.findElement(createAssmt_SuccessMsg).getText();
			grep.passTest("Assessment Generated message: " + message);
			logger.info("Assessment Generated message: " + message);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void certificatesPageTest() throws Exception {
		try {
			implWait(driver);
			By certificateHeader = By.xpath("//section[@class='my-certificates-section']/div[1]");
			By certificateList = By.xpath("//section[@class='my-certificates-section']/div[2]");

			boolean elementExist = !driver.findElements(certificateHeader).isEmpty();
			if (elementExist) {

				String header = driver.findElement(certificateHeader).getText();
				String list = driver.findElement(certificateList).getText();

				grep.passTest("Verify Certificate Header: " + header);
				logger.info("Verify Certificate Header: " + header);

				grep.passTest("Verify Certificate List: " + list);
				logger.info("Verify Certificate List: " + list);
			} else {
				grep.failTest("Certificate page fail");
				logger.error("Certificate page fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Fill and submit feedback form
	public void fillFeedbackForm(String feedbackMsg, String category) throws Exception {
		try {

			implWait(driver);

			boolean elementExist = !driver.findElements(By.id("feedback")).isEmpty();
			if (elementExist) {

				driver.findElement(By.id("feedback")).sendKeys(feedbackMsg);
				waitTime(driver);
				WebElement categoryElement = driver
						.findElement(By.xpath("//label[text()='Category:']/following-sibling::select"));
				Select selectCtg = new Select(categoryElement);
				selectCtg.selectByVisibleText(category);
				waitTime(driver);
				driver.findElement(By.cssSelector("button.submitbutton")).click();
				String getsuccessMessage = driver.findElement(By.cssSelector("div.message")).getText();

				grep.passTest("Feedback Submitted successfully: " + getsuccessMessage);
				logger.info("Feedback Submitted successfully: " + getsuccessMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// for scroll to view
	public void scrollView(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
