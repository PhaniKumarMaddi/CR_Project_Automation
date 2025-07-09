package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.WaitsManager;

public class CR_ChatBot_Page extends WaitsManager {
	static WebDriver driver;
	private static final Logger logger = LogManager.getLogger(CR_ChatBot_Page.class);
	GenerateReports grep = new GenerateReports();

	public CR_ChatBot_Page() {
		this.driver = DriverManager.getDriver();
	}

	By rejectCookies = By.xpath("//button[text()='Reject All']");
	By insertPrompt = By.xpath("//form[@id='banner-search-form']/input[@placeholder='Type your question here...']");
	By searchPromptBtn = By.xpath("//form[@id='banner-search-form']/button[@type='submit']");

	By multiInsertPrompt = By.xpath("//form[@id='popup-search-form']/input[@placeholder='Type your question here...']");
	By multiSearchPromptBtn = By.xpath("//form[@id='popup-search-form']/button[@type='submit']");

	By chatPopupClose = By.xpath("//*[@id='chat-popup-close']");
	// div[@class='chat-section']/button");
	// .id("chat-popup-close");
	By userMessagePrompt = By.xpath("//div[@class='chat-message user-message']");
	By botResponse = By.xpath("//div[@class='chat-message bot-message']/div[1]/div/p");/// div[1]/div/p
	By linkPreviewTitle = By.xpath("//span[@class='link-preview__title']");
	By linkPreviewDescription = By.xpath("//p[@class='link-preview__description']");
	By linkPreviewContainer = By.xpath("//div[@class='link-preview__container']/a");

	By tableHeader = By.xpath("//div[@class='bot-response']/table/thead/tr/th[1]");
	By pageTitle = By.xpath("//div[@class='page-breadcrumbs']");
	// div[@class='page_title_details']");

	By goodResponseBtn = By.xpath("//div[@class='feedback-buttons']/button[1]");
	By badResponseBtn = By.xpath("//div[@class='feedback-buttons']/button[2]");

	By provideFeedbackheader = By.xpath("//div[@class='feedback-form-header']/h3");
	By closeBadResponse = By.xpath("//div[@class='feedback-form-header']/button");
	By submitResponse = By.xpath("//button[@class='submit-button']");
	By inputBadResponse = By.xpath("//textarea[@placeholder='Feel free to add specific details (Optional)']");

	// UI
	By bannerValidation = By.xpath("//div[@class='banner-content']/h1");

	public String validateBannerOnHomePage() throws Exception {
		String bannerVal = null;
		try {
			implWait(driver);
//			waitForElement(bannerValidation, 30);
			List<WebElement> banner = driver.findElements(bannerValidation);
			System.out.println(banner.size());
			if (banner.size() > 0) {
				bannerVal = banner.get(1).getText();
				System.out.println(bannerVal);
			} else {
				bannerVal = "Bannner is empty";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return bannerVal;
	}

	public String getNoticeLinkPreview(String selectLink) throws Exception {
		String noticePreview = null;
		try {

			By noticeLink = By.xpath("//a[text()='" + selectLink + "']");
//			waitForElement(noticeLink, 60);
			implWait(driver);
			WebElement notice = driver.findElement(noticeLink);
			if (notice.isDisplayed()) {
				noticePreview = notice.getAttribute("href");
			} else {
				noticePreview = "Notice Link Not Available";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return noticePreview;
	}

	public void clickNoticeLink(String selectLink) throws Exception {
		try {
			By noticeLink = By.xpath("//a[text()='" + selectLink + "']");
//			waitForElement(noticeLink, 60);
			implWait(driver);
			WebElement link = driver.findElement(noticeLink);
			if (link.isDisplayed()) {
				link.click();
			} else {
				grep.warnTest(selectLink + " Link is not avaialble");
				logger.warn(selectLink + " Link is not avaialble");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void rejectCookies() throws Exception {
		try {
//			waitForElementToBeClickable(rejectCookies, 10);
			implWait(driver);
			WebElement reject = driver.findElement(rejectCookies);
			if (reject.isDisplayed()) {
				reject.click();
				grep.infoTest("Rejected All Cookies");
				logger.info("Rejected All Cookies");

			} else {
				grep.warnTest("No Cookies Displayed");
				logger.warn("No Cookies Displayed");

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
			grep.infoTest("Test Failed :" + e.getMessage());
		}
	}

	public void insertPromptTest(String enterPrompt) throws Exception {
		try {
			waitForElementToBeClickable(insertPrompt, 60);

			WebElement insertPromptVal = driver.findElement(insertPrompt);
			insertPromptVal.click();
			insertPromptVal.sendKeys(enterPrompt);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void multiInsertPromptTest(String enterPrompt) throws Exception {
		try {
			waitForElementToBeClickable(multiInsertPrompt, 60);

			WebElement insertPromptVal = driver.findElement(multiInsertPrompt);
			insertPromptVal.click();
			insertPromptVal.sendKeys(enterPrompt);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickSearchPrompt() throws Exception {
		try {
			waitForElementToBeClickable(searchPromptBtn, 60);
			driver.findElement(searchPromptBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
			grep.infoTest("Test Failed :" + e.getMessage());
		}
	}

	public void clickMultiSearchPrompt() throws Exception {
		try {
			waitForElementToBeClickable(multiSearchPromptBtn, 60);
			driver.findElement(multiSearchPromptBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
			grep.infoTest("Test Failed :" + e.getMessage());
		}
	}

	public void verifySearchBtnDisabled() throws Exception {
		try {
//			waitForElement(searchPromptBtn, 60);
			implWait(driver);
			WebElement search = driver.findElement(searchPromptBtn);
			if (search.isEnabled()) {
				System.out.println("Search Button is Still Enabled");
				grep.failTest("Search Button is Still Enabled");
				logger.error("Search Button is Still Enabled");
			} else {
				System.out.println("Search Button is Disabled");
				grep.passTest("Search Button is Disabled");
				logger.info("Search Button is Disabled");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clearPrompts() throws Exception {
		try {
			waitForElementToBeClickable(chatPopupClose, 60);
			driver.findElement(chatPopupClose).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
		}

	}

	public String getUserMessagePrompt() throws Exception {
		String promtpVal = null;
		try {
			waitForElementToBeClickable(userMessagePrompt, 60);
			List<WebElement> prompt = driver.findElements(userMessagePrompt);
			if (prompt.size() > 0) {
				promtpVal = prompt.getLast().getText();
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return promtpVal;
	}

	public String getBotMessage() throws Exception {
		String botMessage = null;
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(botResponse).isEmpty();
			if (elementExists) {
				List<WebElement> botText = driver.findElements(botResponse);
				botMessage = botText.getLast().getText();
			} else {
				botMessage = "Bot Response is Not Available";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return botMessage;
	}

	public String getLinkTitle() throws Exception {
		String linkTitle = null;
		try {
//			waitForElement(linkPreviewTitle, 60);
			implWait(driver);
			List<WebElement> linkTitleVal = driver.findElements(linkPreviewTitle);

			linkTitle = linkTitleVal.getLast().getText();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return linkTitle;
	}

	public String getLinkDescription() throws Exception {
		String linkDesc = null;
		try {
			waitForElement(linkPreviewDescription, 60);
			List<WebElement> linkDescription = driver.findElements(linkPreviewDescription);
			if (linkDescription.size() > 0) {
				linkDesc = linkDescription.getLast().getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return linkDesc;
	}

	public String getLinkPreview() throws Exception {
		String linkPreview = null;
		try {
			waitForElement(linkPreviewContainer, 60);
			List<WebElement> linkPreviewVal = driver.findElements(linkPreviewContainer);
			linkPreview = linkPreviewVal.getLast().getAttribute("title");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
		}
		return linkPreview;
	}

	public void clickLink() throws Exception {
		try {
			waitForElement(linkPreviewContainer, 60);
			driver.findElement(linkPreviewContainer).click();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
		}
	}

	public String verifyTableHeader() throws Exception {
		String headerVal = null;
		try {
//			waitForElement(tableHeader, 60);
			implWait(driver);
			WebElement table = driver.findElement(tableHeader);
			if (table.isDisplayed()) {
				System.out.println("Data is Displayed in Table Format");
				grep.passTest("Data is Displayed in Table Format");
				logger.info("Data is Displayed in Table Format");
				headerVal = table.getText();
			} else {
				System.out.println("Data is not Displayed in Table Format");
				grep.failTest("Data is not Displayed in Table Format");
				logger.error("Data is not Displayed in Table Format");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return headerVal;
	}

	public String verifyPageTitle() throws Exception {
		String pageVal = null;
		try {
			waitForElementToBeClickable(pageTitle, 60);
			pageVal = driver.findElement(pageTitle).getText();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return pageVal;
	}

	public void clickGoodResponseBtn() throws Exception {
		try {
			waitForElement(goodResponseBtn, 60);
			driver.findElement(goodResponseBtn).click();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickBadResponseBtn() throws Exception {
		try {
			waitForElement(badResponseBtn, 60);
			driver.findElement(badResponseBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyResponseBtnDisable() throws Exception {
		try {
			waitForElement(goodResponseBtn, 60);
			WebElement goodResponse = driver.findElement(goodResponseBtn);
			WebElement badResponse = driver.findElement(badResponseBtn);
			if (goodResponse.isEnabled() && badResponse.isEnabled()) {
				System.out.println("Good and Bad Responses are Still Enabled");
				grep.failTest("Good and Bad Responses are Still Enabled");
				logger.error("Good and Bad Responses are Still Enabled");
			} else {
				System.out.println("Good and Bad Responses are Disabled");
				grep.passTest("Good and Bad Responses are Disabled");
				logger.info("Good and Bad Responses are Disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifyResponseBtnEnable() throws Exception {
		try {
			waitForElement(goodResponseBtn, 60);
			WebElement goodResponse = driver.findElement(goodResponseBtn);
			WebElement badResponse = driver.findElement(badResponseBtn);
			if (goodResponse.isEnabled() && badResponse.isEnabled()) {
				System.out.println("Good and Bad Responses are Enabled");
				grep.passTest("Good and Bad Responses are Enabled");
				logger.info("Good and Bad Responses are Enabled");
			} else {
				System.out.println("Good and Bad Responses are Still Disabled");
				grep.failTest("Good and Bad Responses are Still Disabled");
				logger.error("Good and Bad Responses are Still Disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickCloseBadResponseBtn() throws Exception {
		try {
			waitForElement(closeBadResponse, 60);
			driver.findElement(closeBadResponse).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void clickSubmitResponseBtn() throws Exception {
		try {
//			waitForElement(submitResponse, 60);
			implWait(driver);
			WebElement submitBtn = driver.findElement(submitResponse);
			if (submitBtn.isEnabled()) {
				submitBtn.click();
			} else {
				System.out.println("Please Select any response reason to submit");
				grep.failTest("Please Select any response reason to submit");
				logger.error("Please Select any response reason to submit");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifySubmitResponseBtnDisable() throws Exception {
		try {
			waitForElement(submitResponse, 60);
			WebElement submitBtn = driver.findElement(submitResponse);
			if (submitBtn.isEnabled()) {
				System.out.println("Submit Button Should not be Enabled");
				grep.failTest("Submit Button Should not be Enabled");
				logger.error("Submit Button Should not be Enabled");
			} else {
				System.out.println("Submit Button is Disabled");
				grep.passTest("Submit Button is Disabled");
				logger.info("Submit Button is Disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void verifySubmitResponseBtnEnable() throws Exception {
		try {
			waitForElement(submitResponse, 60);
			WebElement submitBtn = driver.findElement(submitResponse);
			if (submitBtn.isEnabled()) {
				System.out.println("Submit Button is Enabled");
				grep.passTest("Submit Button is Enabled");
				logger.info("Submit Button is Enabled");
			} else {
				System.out.println("Submit Button Should not be Disabled");
				grep.failTest("Submit Button Should not be Disabled");
				logger.error("Submit Button Should not be Disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void insertResponseReason(String reason) throws Exception {
		try {
			waitForElement(badResponseBtn, 60);
			driver.findElement(inputBadResponse).sendKeys(reason);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void selectBadResponseReason(String reason) throws Exception {
		try {
			By selectReason = By.xpath("//div[@class='feedback-options']/button[text()='" + reason + "']");

			waitForElement(selectReason, 60);
			driver.findElement(selectReason).click();
			waitTime(driver);
			WebElement verifySelected = driver.findElement(selectReason);
			if (verifySelected.getAttribute("class").contains("selected")) {
				System.out.println(reason + " is selected");
				grep.passTest(reason + " is selected");
				logger.info(reason + " is selected");
				waitTime2(driver);
				verifySubmitResponseBtnEnable();
			} else {
				System.out.println(reason + " is not selected");
				grep.failTest(reason + " is not selected");
				logger.error(reason + " is not selected");

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public String getBadResponseHeader() throws Exception {
		String badResponseVal = null;
		try {
			waitForElementToBeClickable(provideFeedbackheader, 60);
			badResponseVal = driver.findElement(provideFeedbackheader).getText();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed :" + e.getMessage());
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return badResponseVal;
	}
}
