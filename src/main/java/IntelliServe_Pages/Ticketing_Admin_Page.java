package IntelliServe_Pages;

import java.lang.classfile.CodeBuilder.CatchBuilder;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.ValidatingAssertions;
import Utility.WaitsManager;
import lombok.val;

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
	By noRecords_Worklist = By.xpath("//div[@class='flex flex-col items-center justify-center']/descendant::p[1]");

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

	// verify header
	public void verifyAllTicketsHeader(String headerVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(allTickets_Header).isEmpty();
			if (elementExists) {
				String header = driver.findElement(allTickets_Header).getText().trim();
				if (header.contains(headerVal)) {
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

	public void noRecordsMsg_InAllTickets() throws Exception {
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
			By tableSearch = By
					.xpath("//table[@class='min-w-full divide-y divide-gray-200 dark:divide-gray-700']/tbody/tr");
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
			WebElement input = waitVisible(searchSLA);
			input.clear();
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

			boolean elementExists = !driver.findElements(slaPagination).isEmpty();
			if (elementExists) {
				WebElement slaDropdwon = driver.findElement(slaPagination);
				waitTime(driver);
				Select select = new Select(slaDropdwon);
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

	public void clickSlaExportAndChoose(String slaVal, String option) throws Exception {
		try {
			By slaExport = By.xpath("//h2[text()='" + slaVal + "']/following-sibling::div/descendant::button[1]");
			By slaCSV_PDF_Export = By.xpath("//h2[text()='" + slaVal
					+ "']/following-sibling::div/descendant::button[text()='Export as " + option + "']");
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

	public void noRecordsMsg_MyTickets() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(slaNoRecords).isEmpty();
			if (elementExists) {
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

}
