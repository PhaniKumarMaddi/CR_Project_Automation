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

	By deptpageInfo = By.cssSelector("div.department-info>h1");
	By searchCourse = By.xpath("//input[@class='search-input']");
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
				grep.failTest("Seach department Element Not Found");
				logger.error("Seach department Element Not Found");
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

	public void clickCertificateAdminCards() throws Exception {
		try {
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

	public void clearDashboardTable(String tableName, String searchFieldName) throws Exception {
		try {
			By searchBy = By.xpath(
					"//h2[text()='" + tableName + "']/following-sibling::div/input[@name='" + searchFieldName + "']");

			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

				driver.findElement(searchBy).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

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

	public void verifyDataInTable(String tableName, String verifyValue) throws Exception {
		try {
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

	public void clearFilterButton() throws Exception {
		try {
			By clearFilter = By.xpath("//button[text()='Clear Course Filter (Show All Users)']");

			boolean elementExist = !driver.findElements(clearFilter).isEmpty();
			if (elementExist) {
				scrollView(adminHeader);
				waitTime(driver);
				driver.findElement(clearFilter).click();
				grep.infoTest("Clear Filter");
				logger.info("Clear Filter");
			} else {
				grep.failTest("Clear filter not Available");
				logger.error("Clear filter not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

// TEST TAB
	// Search filter in table
	public void searchTestsTable(String tableName, String searchFieldName, String searchValue) throws Exception {
		try {
			By searchBy = By.xpath("//h3[text()='" + tableName + "']/following-sibling::div/input[@placeholder='"
					+ searchFieldName + "']");

			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

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

	public void clearTestsTable(String tableName, String searchFieldName) throws Exception {
		try {
			By searchBy = By.xpath("//h3[text()='" + tableName + "']/following-sibling::div/input[@placeholder='"
					+ searchFieldName + "']");
			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

				driver.findElement(searchBy).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

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

	public void verifyDataInTestTable(String tableName, String verifyValue) throws Exception {
		try {
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
			By searchBy = By.xpath("//h1[text()='" + tableName + "']/following-sibling::div/input[@placeholder='"
					+ searchFieldName + "']");

			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

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

	public void clearRolesTable(String tableName, String searchFieldName) throws Exception {
		try {
			By searchBy = By.xpath("//h1[text()='" + tableName + "']/following-sibling::div/input[@placeholder='"
					+ searchFieldName + "']");
			boolean elementExist = !driver.findElements(searchBy).isEmpty();
			if (elementExist) {

				driver.findElement(searchBy).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

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

	// for scroll to view
	public void scrollView(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
