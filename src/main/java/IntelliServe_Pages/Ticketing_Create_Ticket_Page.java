package IntelliServe_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.WaitsManager;

public class Ticketing_Create_Ticket_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(Ticketing_Create_Ticket_Page.class);
	GenerateReports grep = new GenerateReports();

	public Ticketing_Create_Ticket_Page() {
		this.driver = DriverManager.getDriver();
	}

	// Create Ticket
	By createTicketHeader = By.xpath("//div[@class='mb-6']/h2");
	By createTicketDesc = By.xpath("//div[@class='mb-6']/p");

	By createTicketLink = By.xpath("//a[text()='Create Ticket']");

	By req_Name = By.xpath("//input[@id='RequestorName']");
	By req_Email = By.xpath("//input[@id='RequestorEmail']");
	By req_Dept = By.xpath("//input[@id='DepartmentTeam']");
	By req_Mobile = By.xpath("//input[@id='MobilePhone']");
	By req_MgrName = By.xpath("//input[@id='ManagerName']");
	By req_MgrEmail = By.xpath("//input[@id='ManagerEmail']");
	By priorityLevel = By.xpath("//select[@id='PriorityLevel']");

	By incidentTitle = By.xpath("//input[@id='incidentTitle']");
	By incidentDetail = By.xpath(
			"//div[@class='rich-text-editor min-h-[6rem] p-3 bg-white dark:bg-gray-700 text-gray-900 dark:text-white rounded-b-md focus:outline-none relative']");

	By choosefile = By.xpath("//label[normalize-space()='Choose files (Up to 30MB)']");
	By inputFile = By.xpath("//input[@type='file']");

	By boldText = By.cssSelector("button[title='Bold']");
	By italicText = By.cssSelector("button[title='Italic']");
	By underlineText = By.cssSelector("button[title='Underline']");
	By strikeText = By.cssSelector("button[title='Strikethrough']");

	
//	By cancelTicket = By.xpath("//button[text()='Cancel']");

	// verify header
	public void verifyCreateTicketPageHeader(String headerVal) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(createTicketHeader).isEmpty();
			if (elementExists) {
				String header = driver.findElement(createTicketHeader).getText().trim();
				if (header.contains(headerVal)) {
					waitTime(driver);
					grep.passTest("Header is valid: " + header);
					logger.info("Header is valid: " + header);
					grep.passTest("Inside Create Ticket Page");
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

	public String verifyCreateTicketPageDesc() throws Exception {
		String ticketTypeVal = null;
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(createTicketDesc).isEmpty();
			if (elementExists) {
				ticketTypeVal = driver.findElement(createTicketDesc).getText();
				waitTime(driver);

			} else {
				grep.failTest("Description Not Available");
				logger.error("Description Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return ticketTypeVal;
	}

	public void clickCreateTicketLink() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(createTicketLink).isEmpty();
			if (elementExists) {
				driver.findElement(createTicketLink).click();
			} else {
				grep.failTest("Create Ticket Not Available");
				logger.error("Create Ticket Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void selectTicketType(String type) throws Exception {
		try {
			implWait(driver);
			By ticketType = By.xpath("//div[text()='" + type + "']");
			boolean elementExists = !driver.findElements(ticketType).isEmpty();
			if (elementExists) {
				driver.findElement(ticketType).click();
				grep.infoTest("Selected " + type + " Ticket Type");
				logger.info("Selected " + type + " Ticket Type");

			} else {
				grep.failTest("Ticket Type Not Available");
				logger.error("Ticket Type Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void getRequestorDetails() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(req_Name).isEmpty();
			if (elementExists) {
				String requestorName = driver.findElement(req_Name).getText();
				String requestorEmail = driver.findElement(req_Email).getText();
				String requestorDept = driver.findElement(req_Dept).getText();
				String requestorMobile = driver.findElement(req_Mobile).getText();
				String requestor_MgrName = driver.findElement(req_MgrName).getText();
				String requestor_MgrEmail = driver.findElement(req_MgrEmail).getText();
				String priority = driver.findElement(priorityLevel).getText();

				grep.infoTest("Requestor Name in Create ticket Popup: " + requestorName);
				logger.info("Requestor Name in Create ticket Popup: " + requestorName);

				grep.infoTest("Requestor Email in Create ticket Popup: " + requestorEmail);
				logger.info("Requestor Email in Create ticket Popup: " + requestorEmail);

				grep.infoTest("Requestor Department in Create ticket Popup: " + requestorDept);
				logger.info("Requestor Department in Create ticket Popup: " + requestorDept);

				grep.infoTest("Requestor Mobile in Create ticket Popup: " + requestorMobile);
				logger.info("Requestor Mobile in Create ticket Popup: " + requestorMobile);

				grep.infoTest("Requestor Manager Name in Create ticket Popup: " + requestor_MgrName);
				logger.info("Requestor Manager Name in Create ticket Popup: " + requestor_MgrName);

				grep.infoTest("Requestor Manager Email in Create ticket Popup: " + requestor_MgrEmail);
				logger.info("Requestor Manager Email in Create ticket Popup: " + requestor_MgrEmail);

//				grep.infoTest("Seleted Priority in Create ticket Popup: " + priority);
//				logger.info("Seleted Priority in Create ticket Popup: " + priority);

			} else {
				grep.failTest("Ticket Type Not Available");
				logger.error("Ticket Type Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void insertIncidentTitle(String incidentTitleVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(incidentTitle).isEmpty();
			if (elementExists) {
				grep.infoTest("Entering incident title: " + incidentTitleVal);
				logger.info("Entering incident title: " + incidentTitleVal);
				waitTime(driver);
				driver.findElement(incidentTitle).sendKeys(incidentTitleVal);

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}
	
	public void insertIncidentDetail(String incidentDescVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(incidentDetail).isEmpty();
			if (elementExists) {
				grep.infoTest("Entering incident Detail: " + incidentDescVal);
				logger.info("Entering incident Detail: " + incidentDescVal);
				waitTime(driver);
				driver.findElement(incidentDetail).sendKeys(incidentDescVal);

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}
	
	public void clickButton(String btnVal) throws Exception {
		try {
			implWait(driver);
			By createTicketPopupBtn = By.xpath("//button[text()='"+btnVal+"']");

			boolean elementExists = !driver.findElements(createTicketPopupBtn).isEmpty();
			if (elementExists) {
				driver.findElement(createTicketPopupBtn).click();
			} else {
				grep.failTest(btnVal+" button Not Available");
				logger.error(btnVal+" button Ticket Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}


}
