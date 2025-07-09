package ChatBotTest;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Pages.CR_ChatBot_Page;
import Utility.ChatBot_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class ChatBotPageTest extends ChatBot_TestInitializer {
	private static final Logger logger = LogManager.getLogger(ChatBotPageTest.class);
	GenerateReports grep;
	CR_ChatBot_Page crPage;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();

	@Test
	public void chatBotTest() throws Exception {
		try {

			System.out.println("Inside Test class ");
			logger.info("Inside Test class ");
			crPage = new CR_ChatBot_Page();
			grep = new GenerateReports();

			grep.testCreate("CR Chat Bot Page UI Validation Test", "CR Chat Bot Page UI");
			waitTime(driver);
			crPage.rejectCookies();
			waitTime2(driver);
			String baner = crPage.validateBannerOnHomePage();
			System.out.println("Banner Value: " + baner);
			logger.info("Banner Value: " + baner);
			grep.infoTest("Banner Value: " + baner);
			validAssert.equalsAssert(baner, dataKeys.banner);
			waitTime(driver);
			System.out.println("Verify the Terms Link from banner notice");
			logger.info("Verify the Terms Link from banner notice");
			grep.infoTest("Verify the Terms Link from banner notice");
			validateNoticeURL("Terms");
			waitTime2(driver);

			System.out.println("Verify the Privacy Policy Link from banner notice");
			logger.info("Verify the Privacy Policy Link from banner notice");
			grep.infoTest("Verify the Privacy Policy Link from banner notice");
			validateNoticeURL("Privacy Policy");
			waitTime2(driver);

			System.out.println("Verify the Cookie Preferences Link from banner notice");
			logger.info("Verify the Cookie Preferences Link from banner notice");
			grep.infoTest("Verify the Cookie Preferences Link from banner notice");
			validateNoticeURL("Cookie Preferences");
			waitTime2(driver);

			System.out.println("Verify the Learn more Link from banner notice");
			logger.info("Verify the Learn more Link from banner notice");
			grep.infoTest("Verify the Learn more Link from banner notice");
			validateNoticeURL("Learn more");
			waitTime2(driver);

			grep.testCreate("Verify the data is returing in Table format in CR Chat Bot Page Prompt Test",
					"CR Chat Bot Page prompt returning in Table format");

			waitTime(driver);
			crPage.insertPromptTest(dataKeys.chatBotPrompt_1);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);
			// Verify Search Button Disabled
			crPage.verifySearchBtnDisabled();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_1);
			waitTime10(driver);

			botResponse();
			waitTime2(driver);
			String headerVal = crPage.verifyTableHeader();
			System.out.println("Validating the Table Header value for first Column: " + headerVal);
			logger.info("Validating the Table Header value for first Column: " + headerVal);
			grep.infoTest("Validating the Table Header value for first Column: " + headerVal);
//			validAssert.equalsAssert(headerVal, "Event Name");

			System.out.println("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			logger.info("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			grep.infoTest("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			validAssert.validateLinkPreviewTitle(dataKeys.chatBotPrompt_1);

			// validate link description
			validAssert.validateLinkDescription(dataKeys.linkPreviewDescription);

			validatePromptUrl("Event");

			// validate header
			validAssert.validatePageTitle("Home / Events");

			driver.close();
			switchToFirstTab();
			waitTime2(driver);
			refreshPage();

			System.out.println("Prompts Cleared");
			grep.infoTest("Prompts Cleared");
			logger.info("Prompts Cleared");

			// For leaders Prompt
			grep.testCreate("CR ChatBot Page Prompt returns in points Test",
					"CR Chat Bot Page Prompt returns in points");

			crPage.insertPromptTest(dataKeys.chatBotPrompt_2);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_2);
			waitTime10(driver);

			// verify bot response
			botResponse();

			System.out.println("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			logger.info("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			grep.infoTest("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			validAssert.validateLinkPreviewTitle(dataKeys.chatBotPrompt_2);

			// validate link description
			validAssert.validateLinkDescription(dataKeys.linkPreviewDescription);

			validatePromptUrl("LeaderShip");
			// validate header
			validAssert.validatePageTitle("Home / About – Leadership");

			driver.close();
			switchToFirstTab();
			waitTime2(driver);
			refreshPage();

			System.out.println("Prompts Cleared");
			grep.infoTest("Prompts Cleared");
			logger.info("Prompts Cleared");

			// For jobs Prompt
			grep.testCreate("CR Chat BotPage Suggesting URL in results- Prompt Test",
					"CR Chat Bot Page  Suggesting URL in results- Prompt");

			crPage.insertPromptTest(dataKeys.chatBotPrompt_3);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_3);
			waitTime10(driver);

			// verify bot response
			botResponse();

			System.out.println("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			logger.info("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			grep.infoTest("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			validAssert.validateLinkPreviewTitle(dataKeys.chatBotPrompt_3);

			// validate link description
			validAssert.validateLinkDescription(dataKeys.linkPreviewDescription);

			validatePromptUrl("Jobs");
			// validate header
			validAssert.validatePageTitle("Home / Explore Job Opportunities in Americas");

			driver.close();
			switchToFirstTab();
			waitTime2(driver);
			refreshPage();

			System.out.println("Prompts Cleared");
			grep.infoTest("Prompts Cleared");
			logger.info("Prompts Cleared");

			// for Failed Prompt
			grep.testCreate("CR Chat BotPage Failed Prompt Test", "CR Chat Bot Page Failed Prompt");

			crPage.insertPromptTest(dataKeys.chatBotPrompt_9);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_9);
			waitTime10(driver);

			// verify bot response
			botResponseForNegative();

			grep.captureScreenshot("pass", "Failed prompt Test", "FailedPrompt");

			refreshPage();

			// for Invalid Prompt
			grep.testCreate("CR Chat BotPage Invalid Prompt Test", "CR Chat Bot Page Invalid Prompt");

			crPage.insertPromptTest(dataKeys.invalid_ChatBotPrompt);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.invalid_ChatBotPrompt);
			waitTime10(driver);

			// verify bot response
			botResponse();
			String botResponse = crPage.getBotMessage();

			validAssert.notEqualsAssert(botResponse, "4");

			grep.captureScreenshot("pass", "Invalid prompt Test", "InvalidPrompt");

			refreshPage();

			// for Invalid Special Character Prompt
			grep.testCreate("CR Chat BotPage Special Character Invalid Prompt Test",
					"CR Chat Bot Page Special Char Invalid Prompt");

			crPage.insertPromptTest(dataKeys.invalid_SplChar_Prompt);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.invalid_SplChar_Prompt);
			waitTime10(driver);

			// verify bot response
			botResponse();

			grep.captureScreenshot("pass", "Invalid Special Character prompt Test", "InvalidSpecialCharPrompt");

			refreshPage();

			// for Personal Information Prompt
			grep.testCreate("CR Chat BotPage Personal or Private Information Prompt Test",
					"CR Chat Bot Page Personal or private Information Prompt");

			crPage.insertPromptTest(dataKeys.personalInformationPrompt);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.personalInformationPrompt);
			waitTime10(driver);

			// verify bot response
			botResponseForNegative();

			grep.captureScreenshot("pass", "Personal Information Prompt Test", "PersonalInformation_Prompt");

			refreshPage();

			// verify good responses
			grep.testCreate("CR Chat Bot Good Response Test", "CR Chat Bot Good Response");

			crPage.insertPromptTest(dataKeys.chatBotPrompt_6);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_6);

			System.out.println("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			logger.info("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			grep.infoTest("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			validAssert.validateLinkPreviewTitle(dataKeys.chatBotPrompt_6);

			// validate link description
			validAssert.validateLinkDescription(dataKeys.linkPreviewDescription);

			waitTime2(driver);
			validatePromptUrl("AI");

			driver.close();
			switchToFirstTab();
			waitTime2(driver);
			crPage.verifyResponseBtnEnable();
			waitTime(driver);
			// click good response
			crPage.clickGoodResponseBtn();
			waitTime2(driver);
			grep.captureScreenshot("pass", "Good Response test", "GoodResponseTest");
			crPage.verifyResponseBtnDisable();
			waitTime3(driver);
			refreshPage();

			System.out.println("Prompts Cleared");
			grep.infoTest("Prompts Cleared");
			logger.info("Prompts Cleared");

			// verify Bad response UI
			grep.testCreate("CR Chat Bot Bad Response UI Test", "CR Chat Bot Bad Response UI");

			crPage.insertPromptTest(dataKeys.chatBotPrompt_11);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_11);

			System.out.println("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			grep.infoTest("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			logger.info("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			validAssert.validateLinkPreviewTitle(dataKeys.chatBotPrompt_11);

			// validate link description
			validAssert.validateLinkDescription(dataKeys.linkPreviewDescription);

			validatePromptUrl("BadResponseUI");

			driver.close();
			switchToFirstTab();
			waitTime2(driver);

			crPage.verifyResponseBtnEnable();
			waitTime2(driver);
			// click Bad response
			crPage.clickBadResponseBtn();
			waitTime2(driver);

			String getResponseHeader = crPage.getBadResponseHeader();
			System.out.println("Bad Response Header : " + getResponseHeader);
			grep.infoTest("Bad Response Header : " + getResponseHeader);
			logger.info("Bad Response Header : " + getResponseHeader);

			validAssert.equalsAssert(getResponseHeader, dataKeys.badResponseHeader);
			waitTime(driver);
			crPage.verifySubmitResponseBtnDisable();
			waitTime(driver);
			crPage.selectBadResponseReason(dataKeys.generic_BadResponseReason);
			waitTime(driver);
			grep.captureScreenshot("pass", "Bad Response Ui test", "BadResponseUITest");
			waitTime(driver);
			crPage.clickCloseBadResponseBtn();
			waitTime(driver);
			crPage.verifyResponseBtnEnable();

			waitTime2(driver);
			refreshPage();

			System.out.println("Prompts Cleared");
			grep.infoTest("Prompts Cleared");
			logger.info("Prompts Cleared");

			// verify Bad responses
			grep.testCreate("CR Chat Bot Bad Response Test", "CR Chat Bot Bad Response");

			crPage.insertPromptTest(dataKeys.chatBotPrompt_11);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			logger.info("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_11);

			System.out.println("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			logger.info("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			grep.infoTest("Validating the Prompt in Link Preview: " + crPage.getLinkTitle());
			validAssert.validateLinkPreviewTitle(dataKeys.chatBotPrompt_11);

			// validate link description
			validAssert.validateLinkDescription(dataKeys.linkPreviewDescription);
			waitTime2(driver);
			crPage.verifyResponseBtnEnable();
			waitTime2(driver);
			// click Bad response
			crPage.clickBadResponseBtn();
			waitTime2(driver);

			waitTime(driver);
			crPage.verifySubmitResponseBtnDisable();
			waitTime(driver);
			crPage.selectBadResponseReason(dataKeys.incorrect_BadResponseReason);
			waitTime(driver);
			crPage.insertResponseReason("Testing Bad Response");
			waitTime(driver);
			grep.captureScreenshot("pass", "Bad Response popup", "BadResponsePopupTest");
			waitTime(driver);
			crPage.clickSubmitResponseBtn();
			waitTime2(driver);
			crPage.verifyResponseBtnDisable();

			grep.captureScreenshot("pass", "Submit Bad Response test", "SubmitBadResponseTest");

			waitTime2(driver);
			refreshPage();

			// Cancel Prompts
			waitTime3(driver);
			grep.testCreate("CR chatBot Cancel prompt while executing Test", "CR chatBot cancel prompt");
			waitTime(driver);
			crPage.insertPromptTest(dataKeys.chatBotPrompt_1);
			crPage.clickSearchPrompt();

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_1);
			crPage.clearPrompts();
			System.out.println("Cancelling the prompt while executing");
			grep.infoTest("Cancelling the prompt while executing");
			logger.info("Cancelling the prompt while executing");
			waitTime2(driver);

			grep.captureScreenshot("pass", "Cancelling executed prompt Test", "cancelExecutedPrompt");

			// Multiple Prompts
			waitTime5(driver);
			grep.testCreate("CR chatBot Multiple prompt Test", "CR chatBot Multiple prompt");
			waitTime(driver);
			crPage.insertPromptTest(dataKeys.chatBotPrompt_1);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_1);
			waitTime10(driver);

			crPage.multiInsertPromptTest(dataKeys.chatBotPrompt_2);
			waitTime(driver);
			crPage.clickMultiSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_2);
			waitTime10(driver);
//			botResponse();

			grep.captureScreenshot("pass", "Multi Prompt test", "MultiPromptTest");
			waitTime(driver);
			crPage.multiInsertPromptTest(dataKeys.chatBotPrompt_4);
			waitTime(driver);
			crPage.clickMultiSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_4);
			waitTime10(driver);
//			botResponse();

			grep.captureScreenshot("pass", "Multi Prompt test", "MultiPromptTest2");
			refreshPage();
			waitTime2(driver);

//			// Same prompt multiple times
			grep.testCreate("CR chatBot Same prompt Multi Test", "CR chatBot Same prompt Multiple times");
			waitTime(driver);
			crPage.insertPromptTest(dataKeys.chatBotPrompt_3);
			waitTime(driver);
			crPage.clickSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_3);
			waitTime10(driver);
			botResponse();
			waitTime2(driver);

			crPage.multiInsertPromptTest(dataKeys.chatBotPrompt_3);
			waitTime(driver);
			crPage.clickMultiSearchPrompt();
			waitTime(driver);

			System.out.println("Validating executed prompt: " + crPage.getUserMessagePrompt());
			grep.infoTest("Validating executed prompt: " + crPage.getUserMessagePrompt());
			validAssert.validatePromptMessage(dataKeys.chatBotPrompt_3);
			waitTime10(driver);
			botResponse();

			grep.captureScreenshot("pass", "Same Prompt Multiple Times test", "SamePromptMultipleTest");

			validAssert.assertAllFunction();

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	public void botResponse() throws Exception {
		waitTime2(driver);
		crPage = new CR_ChatBot_Page();
		implWait(driver);
		String botResponse = crPage.getBotMessage();
		if (botResponse.equals(null) || botResponse.equals("Bot Response is Not Available")) {
			System.out.println("Bot Response not retrieved or Invalid :" + botResponse);
			grep.failTest("Bot Response not retrieved or Invalid :" + botResponse);
			logger.error("Bot Response not retrieved or Invalid :" + botResponse);
		} else {
			System.out.println("Bot Response :" + botResponse);
			grep.infoTest("Bot Response :" + botResponse);
			logger.info("Bot Response :" + botResponse);
		}
	}

	public void botResponseForNegative() throws Exception {
		waitTime2(driver);
		crPage = new CR_ChatBot_Page();
		implWait(driver);
		String botResponse = crPage.getBotMessage();
		if (botResponse.equals(null) || botResponse.equals("Bot Response is Not Available")) {
			System.out.println("Bot Response not retrieved or Invalid :" + botResponse);
			grep.failTest("Bot Response not retrieved or Invalid :" + botResponse);
			logger.error("Bot Response not retrieved or Invalid :" + botResponse);
		} else {
			System.out.println("Bot Response :" + botResponse);
			grep.infoTest("Bot Response :" + botResponse);
			logger.info("Bot Response :" + botResponse);
			validAssert.trueAssert(botResponse.toLowerCase().contains("sorry"));
		}
	}

	public void validateNoticeURL(String noticeValue) throws Exception {
		crPage = new CR_ChatBot_Page();
		waitTime3(driver);
		String noticeUrl = crPage.getNoticeLinkPreview(noticeValue);
		if (noticeUrl.equals(null) || noticeUrl.equals("Notice Link Not Available")) {
			System.out.println("URL not retrieved :" + noticeUrl);
			grep.failTest("URL not retrieved :" + noticeUrl);
			logger.error("URL not retrieved :" + noticeUrl);
		} else {
			System.out.println("URL : " + noticeUrl);
			grep.infoTest("URL : " + noticeUrl);
			logger.info("URL : " + noticeUrl);

			crPage.clickNoticeLink(noticeValue);
			switchToLastTab();
			waitTime3(driver);
			grep.captureScreenshot("pass", "Navigated to " + noticeValue + " Tab", noticeValue + "Tab");
			waitTime3(driver);
			String newTabURL = driver.getCurrentUrl();
			System.out.println("Validating URL: " + newTabURL);
			grep.infoTest("Validating URL: " + newTabURL);
			logger.info("Validating URL: " + newTabURL);
			validAssert.equalsAssert(newTabURL, noticeUrl);

			driver.close();
			switchToFirstTab();
			waitTime2(driver);
		}
	}

	public void validatePromptUrl(String promptVal) throws Exception {
		crPage = new CR_ChatBot_Page();
		String getLink = crPage.getLinkPreview();
		if (getLink == null) {
			System.out.println("Link not retrieved :" + getLink);
			grep.failTest("Link not retrieved :" + getLink);
			logger.error("Link not retrieved :" + getLink);
		} else {

			System.out.println("Get Link Value: " + getLink);
			grep.infoTest("Get Link Value: " + getLink);
			logger.info("Get Link Value: " + getLink);

			grep.captureScreenshot("pass", "Result For" + promptVal + " executed Prompt", promptVal + "Prompt_Result");
			crPage.clickLink();
			switchToLastTab();
			grep.captureScreenshot("pass", "Navigated to " + promptVal + " Window", promptVal + "_WindowURL");

			String getUrl = driver.getCurrentUrl();
			System.out.println("Validating URL after clicking the link: " + getUrl);
			grep.infoTest("Validating URL after clicking the link: " + getUrl);
			logger.info("Validating URL after clicking the link: " + getUrl);
			validAssert.trueAssert(getUrl.contains(getLink));
		}

	}
}
