package IntelliServe_Pages;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.inst2xsd.SalamiSliceStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.ValidatingAssertions;
import Utility.WaitsManager;

public class Ticketing_Admin_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(Ticketing_Admin_Page.class);
	GenerateReports grep = new GenerateReports();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	public Ticketing_Admin_Page() {
		this.driver = DriverManager.getDriver();
	}

	// All Tickets
	By allTickets_Header = By.xpath("//h1[@class='text-2xl font-bold text-gray-900 dark:text-white']");
	By clearFilters = By.xpath("//button[text()='Clear Filters']");
	By configColumn = By.xpath("//span[text()='Configure Columns']/parent::div");
	By savePreference_ColOption = By.xpath("//button[text()='Save Preferences']");
	By closeColumn = By.xpath("//button[@class='text-white hover:text-blue-200 p-1']");
	By searchFilter = By.xpath("//span[text()='Search']/following-sibling::input");
	By noRecords_Message_Admin = By.xpath("//div[@class='flex flex-col items-center justify-center']/descendant::p[1]");
	By tableSearch_AllTickets = By
			.xpath("//table[@class='min-w-full divide-y divide-gray-200 dark:divide-gray-700']/tbody/tr");
	By allTicketsExport = By.xpath("//button[text()='Download']");
	By allTicketsPagination = By.xpath("//div[@class='flex items-center space-x-4']/select");

	// Dashboard

	By dashboardOverview_TktAnalytHeader = By
			.xpath("//div[@class='flex-1 p-2 sm:p-4 md:p-6 w-full max-w-full']/descendant::h2[1]");
	By dashboardOverview_SlaResolutionHeader = By
			.xpath("//div[@class='flex-1 p-2 sm:p-4 md:p-6 w-full max-w-full']/descendant::h2[2]");
	By dashboardOverview_SlaResponseHeader = By
			.xpath("//div[@class='flex-1 p-2 sm:p-4 md:p-6 w-full max-w-full']/descendant::h2[3]");
	By dashboardOverview_MonthlyTrendsAnalytHeader = By
			.xpath("//div[@class='flex-1 p-2 sm:p-4 md:p-6 w-full max-w-full']/descendant::h2[4]");

	By dashboard_overview_Cards = By.xpath("//div[@class='grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6']/div");
	By dashboard_overview_Charts = By.xpath(
			"//div[@class='bg-white dark:bg-gray-800 rounded-xl shadow-sm p-6 border border-gray-100 dark:border-gray-700']/descendant::h3");
	By slaNoRecords = By.xpath("//div[@class='flex flex-col items-center justify-center']/p");
	By noDataExport = By
			.xpath("//div[@class='fixed bottom-4 right-4 bg-gray-800 text-white px-4 py-2 rounded-md shadow-lg']");

	By resolutionComment = By.xpath("//h3[text()='Resolution Comments']/following-sibling::div");
	By slaMetricDetails = By.xpath("//h3[text()='SLA Metrics']/parent::div/following-sibling::div/div");
	By slaStatusDetails = By.xpath("//h3[text()='SLA Metrics']/parent::div/following-sibling::div/div[3]/div[2]");
	By closeDetailPopup = By.xpath("//button[@title='Close']");

	// Card popup
	By cardCountInPopup = By.xpath("//div[@class='mb-4 text-sm text-gray-600 dark:text-gray-400']");
	By popupHeader = By.xpath("//h2[@class='text-xl font-bold text-gray-900 dark:text-white']");
	By departmentInPopup = By.xpath("//div[@class='flex items-center space-x-2']/select");
	By tableInPopup = By.xpath("//table[@class='min-w-full divide-y divide-gray-200 dark:divide-gray-700']/tbody/tr");
	By closePopup = By.xpath("//button[@class='text-gray-400 hover:text-gray-600 dark:hover:text-gray-300 ml-4']");
	By configColumn_InPopup = By.xpath("//button[contains(text(),'Configure Columns')]");
	By closeColumnOption_InPopup = By.xpath("//h3[text()='Column Options']/following-sibling::button");

	// Approver Management
	By approverManagement_Header = By.xpath("//h1[@class='text-2xl font-bold text-gray-900 dark:text-white']");
	By searchFilter_ApprMgmt = By.xpath("//div[@class='col-span-4']/input");
	By selectDept_ApprMgmt = By.xpath("//div[@class='grid grid-cols-12 gap-4']/div[2]/select");
	By selectRoles_ApprMgmt = By.xpath("//div[@class='grid grid-cols-12 gap-4']/div[3]/select");
	By apprMgmtPagination = By.xpath("//div[@class='flex space-x-2']/select");
	By apprMgmtExport = By.xpath("//button[text()='Download']");
	// add new approver
	By addNewApprover = By.xpath("//button[text()='Add Approver or Member']");
	By newApproverPopupHeader = By.xpath("//h2[@class='text-xl font-bold text-white dark:text-white']");

	By tableSearch_ApprMgmt = By.xpath("//table[@class='w-full']/tbody/tr");

	// Roles
	By rolesManagement_Header = By.xpath("//h1[@class='text-2xl font-bold text-gray-900 dark:text-white']");
	By searchFilter_RoleMgmt = By.xpath("//div[@class='relative']/input");

	// verify header
	public void verifyAllTicketsHeader(String headerVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(allTickets_Header).isEmpty();
			if (elementExists) {
				String header = driver.findElement(allTickets_Header).getText().trim();
//				if (header.contains(headerVal)) {
//					waitTime(driver);
//					grep.passTest("Header is valid: " + header);
//					logger.info("Header is valid: " + header);
//				} else {
//					grep.failTest("Header is not valid: " + header);
//					logger.error("Header is not valid: " + header);
//				}
				validAssert.equalsAssert(header, headerVal);
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

	public void insertSearchFilter(String value) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(searchFilter).isEmpty();
			if (elementExists) {
				driver.findElement(searchFilter).clear();
				driver.findElement(searchFilter).sendKeys(value);

				waitTime(driver);

			} else {
				grep.failTest("Search Field Not Available");
				logger.error("Search Field Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void noRecordsMsg_InAdmin() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(noRecords_Message_Admin).isEmpty();
			if (elementExists) {
				String msg = driver.findElement(noRecords_Message_Admin).getText();
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
//				if (header.equals("Column Options")) {
//					grep.passTest("Header is valid: " + header);
//					logger.info("Header is valid: " + header);
//				} else {
//					grep.failTest("Header is not valid: " + header);
//					logger.error("Header is not valid: " + header);
//				}

				validAssert.equalsAssert(header, "Column Options");
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

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickSavePref_ConfigColumnBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(savePreference_ColOption).isEmpty();
			if (elementExists) {
				driver.findElement(savePreference_ColOption).click();
				waitTime2(driver);
			} else {
				grep.failTest("Save Preference Column Button Not Available");
				logger.error("Save Preference Column Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectViewColumnOption(String option) throws Exception {
		try {
			implWait(driver);
			By columnOption = By.xpath(
					"//div[@class='space-y-0']/descendant::span[text()='" + option + "']/following-sibling::button");

			boolean elementexists = !driver.findElements(columnOption).isEmpty();
			if (elementexists) {
				String colVisisbility = driver.findElement(columnOption).getAttribute("title");
				if (colVisisbility.equals("Show column")) {
					grep.passTest("Column Option " + option + " visibility is Hidden ");
					logger.info("Column Option " + option + " visibility is Hidden ");
					waitTime(driver);

					driver.findElement(columnOption).click();
				}
			} else {
				grep.warnTest("Column Options " + option + " Already in view");
				logger.error("Column Options " + option + " Already in view");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void selectHideColumnOption(String option) throws Exception {
		try {
			implWait(driver);
			By columnOption = By.xpath(
					"//div[@class='space-y-0']/descendant::span[text()='" + option + "']/following-sibling::button");

			boolean elementexists = !driver.findElements(columnOption).isEmpty();
			if (elementexists) {
				String colVisisbility = driver.findElement(columnOption).getAttribute("title");
				if (colVisisbility.equals("Show column")) {
					grep.warnTest("Column Option " + option + " visibility is already Hidden ");
					logger.error("Column Option " + option + " visibility is already Hidden ");
					waitTime(driver);
				}
			} else {
				driver.findElement(columnOption).click();
				grep.passTest("Column Options " + option + " visibility in view");
				logger.info("Column Options " + option + " visibility in view");
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
					grep.passTest("Column Option " + option + " visibility is Hidden ");
					logger.info("Column Option " + option + " visibility is Hidden ");
					waitTime(driver);

				} else {
					driver.findElement(columnOptionVisibility).click();
					grep.passTest("Column Option " + option + " visibility is Hidden ");
					logger.info("Column Option " + option + " visibility is Hidden ");
					waitTime(driver);
//					grep.warnTest("Column Option "+ option +" visibility is View ");
//					logger.warn("Column Option "+ option +" visibility is View");
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
					grep.passTest("Column Option " + option + " visibility is View ");
					logger.info("Column Option " + option + " visibility is View ");
					waitTime(driver);

				} else {
					driver.findElement(columnOptionVisibility).click();
					grep.passTest("Column Option " + option + " visibility is View ");
					logger.info("Column Option " + option + " visibility is View ");
					waitTime(driver);
//					grep.warnTest("Column Option visibility is Hidden");
//					logger.warn("Column Option visibility is Hidden");
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

	public void expandStatusFilter() throws Exception {
		try {
			implWait(driver);
			By statusFilter = By.cssSelector(".relative > .border");
			By verifyExpand = By.xpath("//div[@class='relative ']/button[@type='button']//*[name()='svg']");

			boolean elementExists = !driver.findElements(statusFilter).isEmpty();
			if (elementExists) {
				String verifyBtn = driver.findElement(verifyExpand).getAttribute("class");
				if (!verifyBtn.contains("transform rotate-180")) {
					driver.findElement(statusFilter).click();
				} else {
					waitTime(driver);
					logger.info("Already expanded");
				}

			} else {
				grep.failTest("Status Filter not Available");
				logger.error("Status Filter not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void collapseStatusFilter() throws Exception {
		try {
			implWait(driver);
			By statusFilter = By.cssSelector(".relative > .border");
			By verifyCollapse = By.xpath("//div[@class='relative ']/button[@type='button']//*[name()='svg']");

			boolean elementExists = !driver.findElements(statusFilter).isEmpty();
			if (elementExists) {
				String verifyBtn = driver.findElement(verifyCollapse).getAttribute("class");
				if (verifyBtn.contains("transform rotate-180")) {
					driver.findElement(statusFilter).click();
				} else {
					waitTime(driver);
					logger.info("Already Collapsed");
				}

			} else {
				grep.failTest("Status Filter not Available");
				logger.error("Status Filter not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectStatusFilter(String option) throws Exception {
		try {
			implWait(driver);
			By selectOption = By.xpath("//span[text()='" + option + "']/preceding-sibling::input[@type='checkbox']");

			boolean elementExists = !driver.findElements(selectOption).isEmpty();
			if (elementExists) {
				driver.findElement(selectOption).click();

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

	public void verifyAllTickets_FilterInTable(String verifyValue) throws Exception {
		try {
			implWait(driver);

			List<WebElement> table = driver.findElements(tableSearch_AllTickets);
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
					System.out.println("✅ Filter validation passed. All Values match: " + verifyValue);
					grep.passTest("✅ Filter validation passed. All Values match: " + verifyValue);
					logger.info("✅ Filter validation passed. All Values match: " + verifyValue);
				} else {
					System.out.println("❌ Filter validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					grep.warnTest("❌ Filter validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					logger.error("❌ Filter validation failed. Mismatched Value found or no Records Available: "
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

	public void allTicketsExport(String option) throws Exception {
		try {

			By ticketsCSV_PDF_Export = By.xpath("//button[text()='Export as " + option + "']");
			String opt = option == null ? "" : option.trim().toUpperCase();
			if (!opt.contains("CSV") && !opt.contains("PDF")) {
				throw new IllegalArgumentException("option must be 'CSV' or 'PDF'");
			}

			boolean elementExists = !driver.findElements(allTicketsExport).isEmpty();
			if (elementExists) {
				driver.findElement(allTicketsExport).click();
				waitTime(driver);
				driver.findElement(ticketsCSV_PDF_Export).click();
			} else {
				grep.failTest("No " + option + " button available");
				logger.error("No " + option + " button available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectAllTicketsPagination(String optionValue) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(allTicketsPagination).isEmpty();
			if (elementExists) {
				WebElement pageDropdown = driver.findElement(allTicketsPagination);
				waitTime(driver);
				Select select = new Select(pageDropdown);
				select.selectByVisibleText(optionValue);
				grep.infoTest("Selecting " + optionValue + " in pagination");
				logger.info("Selecting " + optionValue + " in pagination");
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

	// dashbaord overview page

	public void selectAdminDashboard(String dashboardVal) throws Exception {
		try {
			implWait(driver);
			By selectDashboard = By
					.xpath("//div[@class='flex items-center gap-4 mb-6']/button[text()='" + dashboardVal + "']");

			boolean elementExists = !driver.findElements(selectDashboard).isEmpty();
			if (elementExists) {
				grep.passTest("Inside " + dashboardVal + " Dashboard");
				logger.info("Inside " + dashboardVal + " Dashboard");
				driver.findElement(selectDashboard).click();
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

	public void validateDashboardOverviewHeaders(String expectedTicketAnalytics, String expectedSlaResolution,
			String expectedSlaResponse, String expectedMonthlyTrends) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(dashboardOverview_TktAnalytHeader).isEmpty();
			if (elementExists) {

				String actualTicketAnalytics = driver.findElement(dashboardOverview_TktAnalytHeader).getText().trim();
				scrollView(dashboardOverview_SlaResolutionHeader);
				String actualSlaResolution = driver.findElement(dashboardOverview_SlaResolutionHeader).getText().trim();
				scrollView(dashboardOverview_SlaResponseHeader);
				String actualSlaResponse = driver.findElement(dashboardOverview_SlaResponseHeader).getText().trim();
				scrollView(dashboardOverview_MonthlyTrendsAnalytHeader);
				String actualMonthlyTrends = driver.findElement(dashboardOverview_MonthlyTrendsAnalytHeader).getText()
						.trim();

				validAssert.equalsAssert(actualTicketAnalytics, expectedTicketAnalytics);

				validAssert.equalsAssert(actualSlaResolution, expectedSlaResolution);

				validAssert.equalsAssert(actualSlaResponse, expectedSlaResponse);

				validAssert.equalsAssert(actualMonthlyTrends, expectedMonthlyTrends);

				System.out.println("✅ All Dashboard Overview Headers validated successfully!");

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

	public void dashboardOverview_Card_Details() throws Exception {
		try {
			implWait(driver);
			List<WebElement> cards = driver.findElements(dashboard_overview_Cards);
			if (cards.size() > 0) {
				for (WebElement dashboard : cards) {
					String cardDetails = dashboard.getText();

					grep.passTest("Card Detail: " + cardDetails);
					logger.info("Card Detail: " + cardDetails);
				}
			} else {
				grep.failTest("Dashboard Cards Not Available");
				logger.error("Dashboard Cards Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void dashboardOverview_Charts_Details() throws Exception {
		try {
			implWait(driver);
			List<WebElement> charts = driver.findElements(dashboard_overview_Charts);
			if (charts.size() > 0) {
				for (WebElement dashboardCharts : charts) {
					String chartsDetails = dashboardCharts.getText();

					grep.passTest("Chart Title in Dashboard: " + chartsDetails);
					logger.info("Chart Title in Dashboard: " + chartsDetails);
				}
			} else {
				grep.failTest("Dashboard Chaarts Not Available");
				logger.error("Dashboard Charts Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void searchSla(String slaVal, String query) throws Exception {
		try {

			By searchSLA = By.xpath("//h2[text()='" + slaVal + "']/following-sibling::div/descendant::input");
			scrollView(searchSLA);

			WebElement input = waitVisible(searchSLA);
			input.clear();
			input.sendKeys(query);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void clearSlaSearch(String slaVal) throws Exception {
		try {
			By searchSLA = By.xpath("//h2[text()='" + slaVal + "']/following-sibling::div/descendant::input");
			scrollView(searchSLA);
			WebElement input = waitVisible(searchSLA);
			waitTime(driver);
			input.sendKeys(Keys.CONTROL + "a");
			input.sendKeys(Keys.DELETE);
			waitTime2(driver);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void selectSLAPagination(String slaVal, String optionValue) throws Exception {
		try {
			implWait(driver);
			By slaPagination = By.xpath("//h2[text()='" + slaVal + "']/following-sibling::div/descendant::select");
			scrollView(slaPagination);

			boolean elementExists = !driver.findElements(slaPagination).isEmpty();
			if (elementExists) {
				WebElement slaDropdown = driver.findElement(slaPagination);
				waitTime(driver);
				Select select = new Select(slaDropdown);
				select.selectByVisibleText(optionValue);
				grep.infoTest("Selecting " + optionValue + " in pagination");
				logger.info("Selecting " + optionValue + " in pagination");
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

	public void clickSlaExportAndChoose(String slaVal, String option) throws Exception {
		try {
			By slaExport = By.xpath("//h2[text()='" + slaVal + "']/following-sibling::div/descendant::button[1]");
			By slaCSV_PDF_Export = By.xpath("//h2[text()='" + slaVal
					+ "']/following-sibling::div/descendant::button[text()='Export as " + option + "']");

			scrollView(slaExport);
			String opt = option == null ? "" : option.trim().toUpperCase();

			if (!opt.contains("CSV") && !opt.contains("PDF")) {
				throw new IllegalArgumentException("option must be 'CSV' or 'PDF'");
			}

			boolean elementExists = !driver.findElements(slaExport).isEmpty();
			if (elementExists) {
				driver.findElement(slaExport).click();
				waitTime(driver);
				driver.findElement(slaCSV_PDF_Export).click();
			} else {
				grep.failTest("No " + option + " button available");
				logger.error("No " + option + " button available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void sla_Prev_Next_Button(String slaVal, String btnVal) throws Exception {
		try {

			By sla_TableButtons = By.xpath("//h2[text()='" + slaVal
					+ "']/following-sibling::div/descendant::button/span[text()='" + btnVal + "']");

			boolean elementExists = !driver.findElements(sla_TableButtons).isEmpty();
			if (elementExists) {
				driver.findElement(sla_TableButtons).click();
				waitTime(driver);
				driver.findElement(sla_TableButtons).click();
			} else {
				grep.failTest("No " + btnVal + " button available");
				logger.error("No " + btnVal + " button available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void noRecordsMsg_SLA() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(slaNoRecords).isEmpty();
			if (elementExists) {
				scrollView(slaNoRecords);

				String msg = driver.findElement(slaNoRecords).getText();
				validAssert.equalsAssert(msg, "No Records Found");

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

	public void getNoDataToExportMsg() throws Exception {
		try {

			waitForElement(noDataExport, 60);

			String message = driver.findElement(noDataExport).getText();
			grep.passTest("Exporting with No Data" + message);
			logger.info("Exporting with No Data: " + message);

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String getTicketIdfromTable(String slaVal) throws Exception {
		String ticketIdVal = null;
		try {
			implWait(driver);
			By selectTicket_In_Table = By
					.xpath("//h2[text()='" + slaVal + "']/following-sibling::div/descendant::table/tbody/tr/td/button");

			List<WebElement> ticketId = driver.findElements(selectTicket_In_Table);
			if (ticketId.size() > 0) {
				ticketIdVal = ticketId.getFirst().getText();
				waitTime(driver);

			} else {
				grep.failTest("Ticket ID Not available");
				logger.error("Ticket ID Not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return ticketIdVal;
	}

	public void getStatusFromTable(String slaVal, String searchVal) throws Exception {
		try {
			implWait(driver);
			By searchValidation = By.xpath("//h2[text()='" + slaVal + "']/parent::div/descendant::tbody/tr");

			List<WebElement> table = driver.findElements(searchValidation);
			if (table.size() > 0) {
				boolean isValid = true;
				for (WebElement rows : table) {
					String rowvalues = rows.getText();
					if (!rowvalues.contains(searchVal)) {
						isValid = false;
						break;
					}
				}
				if (isValid && table.size() > 0) {
					System.out.println("✅ Search validation passed. All Values match: " + searchVal);
					grep.passTest("✅ Search validation passed. All Values match: " + searchVal);
					logger.info("✅ Search validation passed. All Values match: " + searchVal);
				} else {
					System.out.println(
							"❌ Search validation failed. Mismatched Value found or no Records Available: " + searchVal);
					grep.warnTest(
							"❌ Search validation failed. Mismatched Value found or no Records Available: " + searchVal);
					logger.error(
							"❌ Search validation failed. Mismatched Value found or no Records Available: " + searchVal);
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

	public void clickTicketId(String slaVal, String ticketNum) throws Exception {
		try {
			implWait(driver);
			By selectTicket_In_Table = By
					.xpath("//h2[text()='" + slaVal + "']/following-sibling::div/descendant::table/tbody/tr/td/button");

			boolean elementExists = !driver.findElements(selectTicket_In_Table).isEmpty();
			if (elementExists) {
				driver.findElement(selectTicket_In_Table).click();
				waitTime(driver);

			} else {
				grep.failTest("Ticket Not available");
				logger.error("Ticket Not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String verifyTicketDetailsFromDetailPopup(String fieldName) throws Exception {
		String detailVal = null;
		try {
			implWait(driver);
			By ticketDetail_InPopup = By.xpath("//td[normalize-space()='" + fieldName + "']/following-sibling::td");

			boolean elementExists = !driver.findElements(ticketDetail_InPopup).isEmpty();
			if (elementExists) {
				detailVal = driver.findElement(ticketDetail_InPopup).getText();
				waitTime(driver);

			} else {
				grep.failTest(fieldName + " Not available in Ticket Detail Popup");
				logger.error(fieldName + " Not available in Ticket Detail Popup");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return detailVal;
	}

	public void getResolutionCommentsFromTicket() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(resolutionComment).isEmpty();
			if (elementExists) {
				String msg = driver.findElement(resolutionComment).getText();

				grep.passTest("Resolution Comment from Ticket Detail Popup: " + msg);
				logger.info("Resolution Comment from Ticket Detail Popup: " + msg);
			} else {
				grep.failTest("Resolution Not Available");
				logger.error("Resolution Not Available");

			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getSlaMetricFromTicket() throws Exception {
		try {
			implWait(driver);

			List<WebElement> slaMetric = driver.findElements(slaMetricDetails);
			if (slaMetric.size() > 0) {
				for (WebElement sla : slaMetric) {
					String msg = sla.getText();

					grep.passTest("SLA Metric from Ticket Detail Popup: " + msg);
					logger.info("SLA Metric from Ticket Detail Popup: " + msg);

				}
			} else {
				grep.failTest("Sla Metrics Not Available");
				logger.error("Sla Metrics Not Available");

			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifySlaStatusInTicketDetail(String verifyStatus) throws Exception {
		try {
			implWait(driver);

			List<WebElement> slaStatus = driver.findElements(slaStatusDetails);
			if (slaStatus.size() > 0) {
				String msg = slaStatus.getFirst().getText();

				grep.passTest("SLA Status from Ticket Detail Popup: " + msg);
				logger.info("SLA Status from Ticket Detail Popup: " + msg);
				validAssert.equalsAssert(msg, verifyStatus);

			} else {
				grep.failTest("Sla Status Not Available");
				logger.error("Sla Status Not Available");

			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickCloseTicketPopup() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(closeDetailPopup).isEmpty();
			if (elementExists) {
				driver.findElement(closeDetailPopup).click();
			} else {
				grep.failTest("Close Button Not Available");
				logger.error("Close Buttont Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	// clicking cards in dashboard
	public void verifyCardsCountInPopup(String cardNameVal) throws Exception {
		try {
			implWait(driver);
			By cardName = By.xpath("//div/descendant::p[text()='" + cardNameVal + "']/following-sibling::p");

			WebElement clickCard = driver.findElement(cardName);
			if (clickCard.isDisplayed()) {
				String cardCount = clickCard.getText();
				if ("0".equals(cardCount)) {
					grep.infoTest(cardNameVal + " Card count is " + cardCount);
					logger.info(cardNameVal + " Card count is " + cardCount);
				}
				clickCard.click();
				grep.infoTest("Inside " + cardNameVal + " Card Popup");
				logger.info("Inside " + cardNameVal + " Card Popup");

				waitTime(driver);
				waitVisible(cardCountInPopup);

				String countInPopup = driver.findElement(cardCountInPopup).getText();
				if (countInPopup.contains(cardCount)) {
					grep.passTest("Card Count Matched :" + countInPopup);
					logger.info("Card Count Matched :" + countInPopup);

				} else {
					grep.failTest("Card Count Not Matched :" + countInPopup);
					logger.error("Card Count Not Matched :" + countInPopup);
				}
			} else {
				grep.failTest(cardNameVal + " Card Not Available");
				logger.error(cardNameVal + " Card Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyCardPopupHeader(String headerVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(popupHeader).isEmpty();
			if (elementExists) {
				String header = driver.findElement(popupHeader).getText().trim();

				if (header.startsWith(headerVal)) {
					grep.passTest("Card Header Matched :" + header);
					logger.info("Card Header Matched :" + header);

				} else {
					grep.failTest("Card Header Not Matched :" + header);
					logger.error("Card Header Not Matched :" + header);
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

	public void selectDeptInPopup(String deptVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(departmentInPopup).isEmpty();
			if (elementExists) {
				waitVisible(cardCountInPopup);
				WebElement dept = driver.findElement(departmentInPopup);
				Select deptSelect = new Select(dept);
				deptSelect.selectByVisibleText(deptVal);

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

	public void verifyDeptInPopupTable(String deptVal) throws Exception {
		try {
			implWait(driver);

			List<WebElement> table = driver.findElements(tableInPopup);
			if (table.size() > 0) {
				waitVisible(tableInPopup);
				boolean isValid = true;
				for (WebElement rows : table) {
					String rowvalues = rows.getText();
					if (!rowvalues.contains(deptVal)) {
						isValid = false;
						break;
					}
				}
				if (isValid && table.size() > 0) {
					System.out.println("✅ Department Filter validation passed. All Values match: " + deptVal);
					grep.passTest("✅ Department Filter validation passed. All Values match: " + deptVal);
					logger.info("✅ Department Filter validation passed. All Values match: " + deptVal);
				} else {
					System.out.println(
							"❌ Department Filter validation failed. Mismatched Value found or no Records Available: "
									+ deptVal);
					grep.warnTest(
							"❌ Department Filter validation failed. Mismatched Value found or no Records Available: "
									+ deptVal);
					logger.error(
							"❌ Department Filter validation failed. Mismatched Value found or no Records Available: "
									+ deptVal);
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

	public void exportInCardPopup(String option) throws Exception {
		try {
			By ticketsExport = By.xpath("//button[text()='" + option + "']");
			String opt = option == null ? "" : option.trim().toUpperCase();
			if (!opt.contains("CSV") && !opt.contains("PDF")) {
				throw new IllegalArgumentException("option must be 'CSV' or 'PDF'");
			}

			boolean elementExists = !driver.findElements(ticketsExport).isEmpty();
			if (elementExists) {
				waitVisible(cardCountInPopup);
				driver.findElement(ticketsExport).click();
				waitTime(driver);
				grep.passTest("Exporting to " + option);
				logger.info("Exporting to " + option);
			} else {
				grep.failTest("No " + option + " button available");
				logger.error("No " + option + " button available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickCloseCardPopupBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(closePopup).isEmpty();
			if (elementExists) {
				driver.findElement(closePopup).click();
				waitTime2(driver);
			} else {
				grep.failTest("Close Popup Not Available");
				logger.error("Close Popup Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Configure columns in popup

	public void clickConfigColumnBtn_InCardPopup() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(configColumn_InPopup).isEmpty();
			if (elementExists) {
				driver.findElement(configColumn_InPopup).click();
				waitTime2(driver);
				String header = driver.findElement(By.xpath("//h3[@class='text-lg font-semibold']")).getText();
//				if (header.equals("Column Options")) {
//					grep.passTest("Header is valid: " + header);
//					logger.info("Header is valid: " + header);
//				} else {
//					grep.failTest("Header is not valid: " + header);
//					logger.error("Header is not valid: " + header);
//				}

				validAssert.equalsAssert(header, "Column Options");
			} else {
				grep.failTest("Configure Column Button Not Available in Card Popup");
				logger.error("Configure Column Button Not Available in Card Popup");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickCloseConfigColumnBtn_InCardPopup() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(closeColumnOption_InPopup).isEmpty();
			if (elementExists) {
				driver.findElement(closeColumnOption_InPopup).click();
				waitTime2(driver);
			} else {
				grep.failTest("Configure Column Button Not Available in Card Popup");
				logger.error("Configure Column Button Not Available in Card Popup");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectColumnOption_InCardPopups(String option) throws Exception {
		try {
			implWait(driver);
			By columnOption_inpopup = By.xpath("//div[@class='p-4 space-y-3']/descendant::span[text()='" + option
					+ "']/following-sibling::button");

			boolean elementexists = !driver.findElements(columnOption_inpopup).isEmpty();
			if (elementexists) {
				driver.findElement(columnOption_inpopup).click();
				grep.infoTest("Selecting Column Option :" + option);
				logger.info("Selecting Column Option : " + option);
			} else {
				grep.warnTest("Column Options " + option + " Not Working");
				logger.error("Column Options " + option + " Not Working");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// Approver management

	public void verifyApproverManagementHeader(String headerVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(approverManagement_Header).isEmpty();
			if (elementExists) {
				String header = driver.findElement(approverManagement_Header).getText().trim();
				validAssert.equalsAssert(header, headerVal);
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

	public void apprMgmt_SearchFilter(String value) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(searchFilter_ApprMgmt).isEmpty();
			if (elementExists) {
				driver.findElement(searchFilter_ApprMgmt).clear();
				driver.findElement(searchFilter_ApprMgmt).sendKeys(value);

				waitTime(driver);

			} else {
				grep.failTest("Search Filter Not Available");
				logger.error("Search Filter Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}


	public void selectApprMgmtDepartment(String optionValue) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(selectDept_ApprMgmt).isEmpty();
			if (elementExists) {
				WebElement deptDropdown = driver.findElement(selectDept_ApprMgmt);
				waitTime(driver);
				Select select = new Select(deptDropdown);
				select.selectByVisibleText(optionValue);
				grep.infoTest("Selecting " + optionValue + " Department");
				logger.info("Selecting " + optionValue + " Department");
			} else {
				grep.failTest("Selected Department Filter not Available");
				logger.error("Selected Department Filter not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectApprMgmtRoles(String optionValue) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(selectRoles_ApprMgmt).isEmpty();
			if (elementExists) {
				WebElement rolesDropdown = driver.findElement(selectRoles_ApprMgmt);
				waitTime(driver);
				Select select = new Select(rolesDropdown);
				select.selectByVisibleText(optionValue);
				grep.infoTest("Selecting " + optionValue + " Role");
				logger.info("Selecting " + optionValue + " Roles");
			} else {
				grep.failTest("Selected Role Filter not Available");
				logger.error("Selected Role Filter not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectApprMgmtPagination(String optionValue) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(apprMgmtPagination).isEmpty();
			if (elementExists) {
				WebElement pageDropdown = driver.findElement(apprMgmtPagination);
				waitTime(driver);
				Select select = new Select(pageDropdown);
				select.selectByVisibleText(optionValue);
				grep.infoTest("Selecting " + optionValue + " in pagination");
				logger.info("Selecting " + optionValue + " in pagination");
			} else {
				grep.failTest("Selected Pagination not Available");
				logger.error("Selected pagination not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void appr_Mgmt_Export(String option) throws Exception {
		try {

			By apprmgmt_CSV_PDF_Export = By.xpath("//button[text()='Download " + option + "']");
			String opt = option == null ? "" : option.trim().toUpperCase();
			if (!opt.contains("CSV") && !opt.contains("PDF")) {
				throw new IllegalArgumentException("option must be 'CSV' or 'PDF'");
			}

			boolean elementExists = !driver.findElements(apprMgmtExport).isEmpty();
			if (elementExists) {
				driver.findElement(apprMgmtExport).click();
				waitTime(driver);
				driver.findElement(apprmgmt_CSV_PDF_Export).click();
			} else {
				grep.failTest("No " + option + " button available");
				logger.error("No " + option + " button available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickAddNewApproverBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(addNewApprover).isEmpty();
			if (elementExists) {
				driver.findElement(addNewApprover).click();
			} else {
				grep.failTest("Add New Approver Button Not Available");
				logger.error("Add New Approver Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void verifyNewApproverPopupHeader(String headerVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(newApproverPopupHeader).isEmpty();
			if (elementExists) {
				String header = driver.findElement(newApproverPopupHeader).getText().trim();
				validAssert.equalsAssert(header, headerVal);
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

	public void clickApproverPopupBtn(String btnVal) throws Exception {
		try {
			implWait(driver);
			By newApproverPopupButtons = By.xpath("//button[text()='" + btnVal + "']");
			boolean elementExists = !driver.findElements(newApproverPopupButtons).isEmpty();
			if (elementExists) {
				driver.findElement(newApproverPopupButtons).click();
			} else {
				grep.failTest(btnVal + " Button Not Available");
				logger.error(btnVal + " Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void insertValue_inNewApprPopup(String field, String value) throws Exception {
		try {

			By approverPopupInput = By.xpath("//span[text()='" + field + "']/following-sibling::input");

			WebElement input = waitVisible(approverPopupInput);
			input.clear();
			input.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void clearValue_inNewApprPopup(String field, String value) throws Exception {
		try {
			By approverPopupInput = By.xpath("//span[text()='" + field + "']/following-sibling::input");
			WebElement input = waitVisible(approverPopupInput);
			waitTime(driver);
			input.sendKeys(Keys.CONTROL + "a");
			input.sendKeys(Keys.DELETE);
			waitTime2(driver);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public String verifyNewApproverErrorMsg(String field) throws Exception {
		String errorMsg = null;
		try {
			implWait(driver);
			By errorMsgInPopup = By.xpath("//span[text()='" + field + "']/following-sibling::p");

			boolean elementExists = !driver.findElements(errorMsgInPopup).isEmpty();
			if (elementExists) {
				errorMsg = driver.findElement(errorMsgInPopup).getText().trim();

			} else {
				errorMsg = "Error Message Not Available";
				grep.failTest("Error Message Not Available");
				logger.error("Error Message Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return errorMsg;
	}

	public void verifyApprMgmt_FilterInTable(String verifyValue) throws Exception {
		try {
			implWait(driver);

			List<WebElement> table = driver.findElements(tableSearch_ApprMgmt);
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
					System.out.println("✅ Filter validation passed. All Values match: " + verifyValue);
					grep.passTest("✅ Filter validation passed. All Values match: " + verifyValue);
					logger.info("✅ Filter validation passed. All Values match: " + verifyValue);
				} else {
					System.out.println("❌ Filter validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					grep.warnTest("❌ Filter validation failed. Mismatched Value found or no Records Available: "
							+ verifyValue);
					logger.error("❌ Filter validation failed. Mismatched Value found or no Records Available: "
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

	// Roles Management
	public void verifyRolesManagementHeader(String headerVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(rolesManagement_Header).isEmpty();
			if (elementExists) {
				String header = driver.findElement(rolesManagement_Header).getText().trim();
				validAssert.equalsAssert(header, headerVal);
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

	public void roles_SearchFilter(String value) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(searchFilter_RoleMgmt).isEmpty();
			if (elementExists) {
				driver.findElement(searchFilter_RoleMgmt).clear();
				driver.findElement(searchFilter_RoleMgmt).sendKeys(value);

				waitTime(driver);

			} else {
				grep.failTest("Search Filter Not Available");
				logger.error("Search Filter Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clearRolesSearch() throws Exception {
		try {
			WebElement input = waitVisible(searchFilter_RoleMgmt);
			waitTime(driver);
			input.sendKeys(Keys.CONTROL + "a");
			input.sendKeys(Keys.DELETE);
			waitTime2(driver);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

}