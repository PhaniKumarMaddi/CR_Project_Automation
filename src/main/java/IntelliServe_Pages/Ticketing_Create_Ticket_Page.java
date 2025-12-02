package IntelliServe_Pages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	By req_Dept = By.xpath("//*[@id='DepartmentTeam']");
	By select_Dept = By.xpath("//select[@id='DepartmentTeam']");
	By req_Mobile = By.xpath("//input[@id='MobilePhone']");
	By req_MgrName = By.xpath("//input[@id='ManagerName']");
	By req_MgrEmail = By.xpath("//input[@id='ManagerEmail']");
	By priorityLevel = By.xpath("//select[@id='PriorityLevel']");

	By req_Name_Error = By.xpath("//p[normalize-space()='Name is required']");
	By req_Email_Error = By.xpath("//p[normalize-space()='Email is required']");
	By req_Dept_Error = By.xpath("//p[normalize-space()='Department is required']");

	By incidentTitle = By.xpath("//input[@id='incidentTitle']");
	By incidentDetail = By.xpath(
			"//div[@class='rich-text-editor min-h-[6rem] p-3 bg-white dark:bg-gray-700 text-gray-900 dark:text-white rounded-b-md focus:outline-none relative']");

	By incidentTitleError = By.xpath("//input[@id='incidentTitle']/following-sibling::p");
	By incidentDetailerror = By.xpath("//label[@for='incidentDetails']/following-sibling::p");

	By choosefile = By.xpath("//label[normalize-space()='Choose files (Up to 30MB)']");
	By inputFile = By.xpath("//input[@type='file']");

	By createTicketErrorMsg = By.xpath(
			"//div[@class='bg-red-600 text-white px-6 py-4 rounded-lg shadow-lg max-w-md flex items-center space-x-3']/span");
	By createTicketSucessMsg = By.xpath(
			"//div[@class='bg-green-600 text-white px-6 py-4 rounded-lg shadow-lg max-w-md flex items-center space-x-3']/span");

	
	// Ticket Details 
	By ticketID_InTable = By.xpath("//tbody/tr/td/button");
	By ticketId_InPopup = By.xpath("//h2[@class='text-xl font-bold text-white']");
	By ticketDetail_InPopup = By.xpath("//td[normalize-space()='Ticket ID']/following-sibling::td");
	
	By incidentTitle_InPopup= By.xpath("//h4[text()='Heading']/following-sibling::div");
	By incidentDetail_InPopup= By.xpath("//h4[text()='Detail']/following-sibling::div");
	
	
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
				String requestorName = driver.findElement(req_Name).getAttribute("value");
				String requestorEmail = driver.findElement(req_Email).getAttribute("value");
				String requestorDept = driver.findElement(req_Dept).getAttribute("value");
				String requestorMobile = driver.findElement(req_Mobile).getAttribute("value");
				String requestor_MgrName = driver.findElement(req_MgrName).getAttribute("value");
				String requestor_MgrEmail = driver.findElement(req_MgrEmail).getAttribute("value");

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

	public void insertRequestorName(String reqNameVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(req_Name).isEmpty();
			scrollView(req_Name);
			if (elementExists) {
				grep.infoTest("Entering Requestor Name: " + reqNameVal);
				logger.info("Entering Requestor Name: " + reqNameVal);
				waitTime(driver);

				driver.findElement(req_Name).click();
				driver.findElement(req_Name).sendKeys(reqNameVal);

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void insertRequestorEmail(String reqEmailVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(req_Email).isEmpty();
			if (elementExists) {
				grep.infoTest("Entering Requestor Email: " + reqEmailVal);
				logger.info("Entering Requestor Email: " + reqEmailVal);
				waitTime(driver);
				driver.findElement(req_Email).click();
				driver.findElement(req_Email).sendKeys(reqEmailVal);

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void selectPriorityLevel(String priorityVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(priorityLevel).isEmpty();
			if (elementExist) {
				WebElement selectPrior = driver.findElement(priorityLevel);
				Select selectValue = new Select(selectPrior);
				selectValue.selectByValue(priorityVal);
				waitTime(driver);

				grep.passTest("Selecting Priority from dropdown: " + selectValue.getFirstSelectedOption().getText());
				logger.info("Selecting Priority from dropdown: " + selectValue.getFirstSelectedOption().getText());
			} else {
				grep.failTest("Selecting Priority from dropdown Failed");
				logger.error("Selecting Priority from dropdown Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectDepartment(String deptVal) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(select_Dept).isEmpty();
			if (elementExist) {
				WebElement selectDept = driver.findElement(select_Dept);
				Select selectValue = new Select(selectDept);
				selectValue.selectByValue(deptVal);
				waitTime(driver);

				grep.passTest("Selecting Department from dropdown: " + selectValue.getFirstSelectedOption().getText());
				logger.info("Selecting Department from dropdown: " + selectValue.getFirstSelectedOption().getText());
			} else {
				grep.failTest("Selecting Department from dropdown Failed");
				logger.error("Selecting Department from dropdown Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getRequestorNameError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(req_Name_Error).isEmpty();
			if (elementExists) {
				scrollView(req_Name_Error);
				String errorMsg = driver.findElement(req_Name_Error).getText();
				if (errorMsg.equals("Name is required")) {
					grep.passTest("Requestor Name Error Message :" + errorMsg);
					logger.info("Requestor Name Error Message :" + errorMsg);
					waitTime(driver);
				} else {
					grep.failTest("Requestor Name Error Message is not correct");
					logger.error("Requestor Name Error Message is not correct");
				}
			} else {
				grep.failTest("Requestor Name Error Message Not found");
				logger.error("Requestor Name Error Message Not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void getRequestorEmailError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(req_Email_Error).isEmpty();
			if (elementExists) {
				String errorMsg = driver.findElement(req_Email_Error).getText();
				if (errorMsg.equals("Email is required")) {
					grep.passTest("Requestor Email Error Message :" + errorMsg);
					logger.info("Requestor Email Error Message :" + errorMsg);
					waitTime(driver);
				} else {
					grep.failTest("Requestor Email Error Message is not correct");
					logger.error("Requestor Email Error Message is not correct");
				}
			} else {
				grep.failTest("Requestor Email Error Message Not found");
				logger.error("Requestor Email Error Message Not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void getDepartmentError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(req_Dept_Error).isEmpty();
			if (elementExists) {
				String errorMsg = driver.findElement(req_Dept_Error).getText();
				if (errorMsg.equals("Department is required")) {
					grep.passTest("Department Error Message :" + errorMsg);
					logger.info("Department Error Message :" + errorMsg);
					waitTime(driver);
				} else {
					grep.failTest("Department Error Message is not correct");
					logger.error("Department Error Message is not correct");
				}
			} else {
				grep.failTest("Department Error Message Not found");
				logger.error("Department Error Message Not found");
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

	public void getIncidentTitleError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(incidentTitleError).isEmpty();
			if (elementExists) {
				String errorMsg = driver.findElement(incidentTitleError).getText();
				if (errorMsg.equals("Incident title is required")) {
					grep.passTest("Incident Title Error Message :" + errorMsg);
					logger.info("Incident Title Error Message :" + errorMsg);
					waitTime(driver);
				} else {
					grep.failTest("Incident Title Error Message is not correct");
					logger.error("Incident Title Error Message is not correct");
				}
			} else {
				grep.failTest("Incident Title Error Message Not found");
				logger.error("Incident Title Error Message Not found");
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

	public void pasteImageInIncidentDetail(String files) throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(incidentDetail).isEmpty();
			if (elementExists) {
				BufferedImage img = ImageIO.read(new File(files));
				TransferableImage trans = new TransferableImage(img);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);

				WebElement image = driver.findElement(incidentDetail);
				image.click();
				image.sendKeys(Keys.CONTROL, "v");

			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void getIncidentDetailError() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(incidentDetailerror).isEmpty();
			if (elementExists) {
				String errorMsg = driver.findElement(incidentDetailerror).getText();
				if (errorMsg.equals("Incident details cannot be empty or only spaces")) {
					grep.passTest("Incident Detail Error Message :" + errorMsg);
					logger.info("Incident Detail Error Message :" + errorMsg);
					waitTime(driver);
				} else {
					grep.failTest("Incident Detail Error Message is not correct");
					logger.error("Incident Detail Error Message is not correct");
				}
			} else {
				grep.failTest("Incident Detail Error Message Not found");
				logger.error("Incident Detail Error Message Not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void selectAllIncidentDetail() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(incidentDetail).isEmpty();
			if (elementExists) {
				driver.findElement(incidentDetail).sendKeys(Keys.CONTROL + "a");
				waitTime(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void chooseFileIn_NewTicket(String[] files) throws Exception {
		try {
			implWait(driver);

//			boolean elementExists = !driver.findElements(choosefile).isEmpty();
			boolean elementExists = !driver.findElements(inputFile).isEmpty();
			if (elementExists) {
				scrollView(choosefile);
				waitTime(driver);
				WebElement upload = driver.findElement(inputFile);

				for (String f : files) {
					upload.sendKeys(f);
					waitTime(driver);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void fontStyles_NewTicket(String fontType) throws Exception {
		try {
			implWait(driver);
			By boldText = By.cssSelector("button[title='" + fontType + "']");
			boolean elementExists = !driver.findElements(boldText).isEmpty();
			if (elementExists) {
				driver.findElement(boldText).click();
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
			By createTicketPopupBtn = By.xpath("//button[text()='" + btnVal + "']");

			boolean elementExists = !driver.findElements(createTicketPopupBtn).isEmpty();
			if (elementExists) {
				driver.findElement(createTicketPopupBtn).click();
			} else {
				grep.failTest(btnVal + " button Not Available");
				logger.error(btnVal + " button Ticket Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void getCreateTicketpopupErrorMessage(String messageVal) throws Exception {
		try {
//			implWait(driver);
			waitForElement(createTicketErrorMsg, 90);
			boolean elementExists = !driver.findElements(createTicketErrorMsg).isEmpty();
			if (elementExists) {
				String message = driver.findElement(createTicketErrorMsg).getText();
				if (message.contains(messageVal)) {
					grep.passTest("Message :" + message);
					logger.info("Message :" + message);
					waitTime(driver);
				} else {
					grep.failTest("Invalid error message in create ticket popup: " + message);
					logger.error("Invalid error message in create ticket popup: " + message);
				}
			} else {
				grep.failTest("Snackbar message is not available in create ticket popup");
				logger.error("Snackbar message is not available in create ticket popup");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

	public void getCreateTicketpopupSucessMessage() throws Exception {
		try {
//			implWait(driver);
			waitForElement(createTicketSucessMsg, 90);
			boolean elementExists = !driver.findElements(createTicketSucessMsg).isEmpty();
			if (elementExists) {
				String message = driver.findElement(createTicketSucessMsg).getText();
				if (message.equals("Ticket created successfully!")) {

					grep.passTest("Message :" + message);
					logger.info("Message :" + message);
					waitTime(driver);
				} else {
					grep.failTest("Invalid Message :" + message);
					logger.error("Invalid Message :" + message);
					waitTime(driver);
				}
			} else {
				grep.failTest("Snackbar message is not available in create ticket popup");
				logger.error("Snackbar message is not available in create ticket popup");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}

	}

}
