package IntelliServe_Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.WaitsManager;

public class Ticketing_Approver_Member_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(Ticketing_Page.class);
	GenerateReports grep = new GenerateReports();

	public Ticketing_Approver_Member_Page() {
		this.driver = DriverManager.getDriver();
	}

	// Approver Worklist
	By worklist_header = By.xpath("//h1[@class='text-xl sm:text-2xl font-bold text-gray-900 dark:text-white']");
	By refreshBtn = By.xpath("//button/span[text()='Refresh'][1]");
	By clearFilters = By.xpath("//button[text()='Clear All Filters']");
	By configColumn = By.xpath("//span[text()='Configure Columns']/parent::div");
	By closeColumn = By.xpath("//button[@class='text-white hover:text-blue-200 p-1']");
	By searchFilter = By.xpath("//span[text()='Search']/following-sibling::input");
	By noRecords_Worklist = By.xpath("//div[@class='overflow-x-auto max-w-full min-w-0']/descendant::p[1]");

	By refreshMsg = By.xpath(
			"//div[@class='bg-green-600 text-white px-6 py-4 rounded-lg shadow-lg max-w-md flex items-center space-x-3']/span");

	// MY Tickets
	By norRecords_MyTickets = By.xpath("//div[starts-with(@class,'overflow-x-auto max-w-full ')]/descendant::p[1]");

	// verify header
	public void verifyApproverWorkListHeader() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(worklist_header).isEmpty();
			if (elementExists) {
				String header = driver.findElement(worklist_header).getText().trim();
				if (header.contains("Approver Worklist")) {
					waitTime(driver);
					grep.passTest("Header is valid: " + header);
					logger.info("Header is valid: " + header);
				} else {
					grep.failTest("Header is not valid: " + header);
					logger.error("Header is not valid: " + header);
				}
			} else {
				grep.failTest("Header Not Available");
				logger.error("Header Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickRefreshBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(refreshBtn).isEmpty();
			if (elementExists) {
				driver.findElement(refreshBtn).click();
				waitTime(driver);

			} else {
				grep.failTest("Refresh Button Not Available");
				logger.error("Refresh Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getRefreshMessgae() throws Exception {
		try {

			waitForElement(refreshMsg, 60);

			String message = driver.findElement(refreshMsg).getText();
			grep.passTest("Refresh Successful Messgae" + message);
			logger.info("Refresh Successful Messgae: " + message);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void insertSearchFilter(String value) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(searchFilter).isEmpty();
			if (elementExists) {
				driver.findElement(searchFilter).clear();
				driver.findElement(searchFilter).sendKeys(value);

				waitTime(driver);

			} else {
				grep.failTest("Refresh Button Not Available");
				logger.error("Refresh Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void noRecordsMsg_InWorklist() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(noRecords_Worklist).isEmpty();
			if (elementExists) {
				String msg = driver.findElement(noRecords_Worklist).getText();
				grep.passTest("No records Found :" + msg);
				logger.info("No records Found :" + msg);
			} else {
				grep.failTest("Records available");
				logger.error("Records available");

			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void noRecordsMsg_MyTickets() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(norRecords_MyTickets).isEmpty();
			if (elementExists) {
				String msg = driver.findElement(norRecords_MyTickets).getText();
				grep.passTest("No records Found :" + msg);
				logger.info("No records Found :" + msg);
			} else {
				grep.failTest("Records available");
				logger.error("Records available");

			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickClearFilterBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(clearFilters).isEmpty();
			if (elementExists) {
				driver.findElement(clearFilters).click();
				waitTime(driver);

			} else {
				grep.failTest("Clear All Filter Button Not Available");
				logger.error("Clear All Filter Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickConfigColumnBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(configColumn).isEmpty();
			if (elementExists) {
				driver.findElement(configColumn).click();
				waitTime2(driver);
				String header = driver.findElement(By.cssSelector("h2.text-lg.font-semibold.text-white")).getText();
				if (header.equals("Column Options")) {
					grep.passTest("Header is valid: " + header);
					logger.info("Header is valid: " + header);
				} else {
					grep.failTest("Header is not valid: " + header);
					logger.error("Header is not valid: " + header);
				}

			} else {
				grep.failTest("Configure Column Button Not Available");
				logger.error("Configure Column Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickCloseConfigColumnBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(closeColumn).isEmpty();
			if (elementExists) {
				driver.findElement(closeColumn).click();
				waitTime2(driver);
			} else {
				grep.failTest("Configure Column Button Not Available");
				logger.error("Configure Column Button Not Available");
			}

		} catch (

		Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectColumnOption(String option) throws Exception {
		try {
			implWait(driver);
			By columnOption = By.xpath(
					"//div[@class='space-y-0']/descendant::span[text()='" + option + "']/following-sibling::button");

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

	public void verifyColumnOptionVisibilityHidden(String option) throws Exception {
		try {
			implWait(driver);
			By columnOptionVisibility = By.xpath(
					"//div[@class='space-y-0']/descendant::span[text()='" + option + "']/following-sibling::button");

			boolean elementexists = !driver.findElements(columnOptionVisibility).isEmpty();
			if (elementexists) {
				String colVisisbility = driver.findElement(columnOptionVisibility).getAttribute("title");
				if (colVisisbility.equals("Show column")) {
					grep.passTest("Column Option visibility is Hidden ");
					logger.info("Column Option visibility is Hidden ");
					waitTime(driver);

				} else {
					grep.warnTest("Column Option visibility is View ");
					logger.warn("Column Option visibility is View");
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

	public void verifyColumnOptionVisibilityView(String option) throws Exception {
		try {
			implWait(driver);
			By columnOptionVisibility = By.xpath(
					"//div[@class='space-y-0']/descendant::span[text()='" + option + "']/following-sibling::button");

			boolean elementexists = !driver.findElements(columnOptionVisibility).isEmpty();
			if (elementexists) {
				String colVisisbility = driver.findElement(columnOptionVisibility).getAttribute("title");
				if (colVisisbility.equals("Hide column")) {
					grep.passTest("Column Option visibility is View ");
					logger.info("Column Option visibility is View ");
					waitTime(driver);

				} else {
					grep.warnTest("Column Option visibility is Hidden");
					logger.warn("Column Option visibility is Hidden");
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

	public void selectFilter(String filterName, String optionValue) throws Exception {
		try {
			implWait(driver);
			By filter = By.xpath("//span[text()='" + filterName + "']/following-sibling::select");

			boolean elementExists = !driver.findElements(filter).isEmpty();
			if (elementExists) {
				WebElement filterDropwdown = driver.findElement(filter);
				waitTime(driver);
				Select select = new Select(filterDropwdown);
				select.selectByVisibleText(optionValue);
			} else {
				grep.failTest("Selected Filter not Available");
				logger.error("Selected Filter not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyWorklist_FilterInTable(String verifyValue) throws Exception {
		try {
			implWait(driver);
			By tableSearch = By.xpath(
					"//table[@class='w-full min-w-full divide-y divide-gray-200 dark:divide-gray-700']/tbody/tr");
			implWait(driver);

			List<WebElement> table = driver.findElements(tableSearch);
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
					System.out.println("❌ Search validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					grep.warnTest("❌ Search validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					logger.error("❌ Search validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
				}
			} else {
				grep.failTest("Table not exists");
				logger.error("Table not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyMyTickets_FilterInTable(String verifyValue) throws Exception {
		try {
			implWait(driver);
			By tableSearch = By.xpath(
					"//table[@class='min-w-full divide-y divide-gray-200 dark:divide-gray-700']/tbody/tr");
			implWait(driver);

			List<WebElement> table = driver.findElements(tableSearch);
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
					System.out.println("❌ Search validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					grep.warnTest("❌ Search validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					logger.error("❌ Search validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
				}
			} else {
				grep.failTest("Table not exists");
				logger.error("Table not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

}
