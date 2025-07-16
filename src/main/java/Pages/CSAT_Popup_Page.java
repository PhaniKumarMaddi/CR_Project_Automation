package Pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class CSAT_Popup_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Popup_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public CSAT_Popup_Page() {
		this.driver = DriverManager.getDriver();
	}

	// CSAT Summary Test
	By csatPagination = By.xpath("//div[@class='Project-entries-box MuiBox-root css-0']/select");
	By csatDropdown = By.xpath("//div[@class='MuiBox-root css-1omrszi']/select");
	By csatScoreInPopup = By.xpath("//span[@class='Project-csat-value']");
	By scoreInTable = By.xpath("//table[@class='Project-project-table']/tbody/tr/td[4]");

	// Survey Sent
	By responseStatus_SurveySent = By.xpath("//select[@class='Project-filter-box-status Project-filter-select']");
	By project_Popup = By
			.xpath("//select[@class='Project-form-control Project-filter-select Project-filter-box-project']");
	By accountExecutive_Popup = By
			.xpath("//select[@class='Project-form-control Project-filter-select Project-filter-box-account']");
	By survey_SurveySent = By
			.xpath("//select[@class='Project-form-control Project-filter-select Project-filter-box-surveyname']");
	By pagination_Popup = By.xpath("//div[@class='Project-pagination-info-container']/div/select");

	By response_InSurveySentTable = By.xpath(
			"//div[@class='MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-filledDefault css-1vt5ddm']/span");
	By project_InSurveySentTable = By.xpath("//table[@class='Project-project-table']/tbody/tr/td[2]");
	By accountExe_InSurveySentTable = By.xpath("//table[@class='Project-project-table']/tbody/tr/td[3]");
	By surveyName_InSurveySentTable = By.xpath("//table[@class='Project-project-table']/tbody/tr/td[1]");

	// AT Risk
	By riskFactor_inAtRisk = By
			.xpath("//select[@class='Project-form-control Project-filter-select Project-filter-box-status']");
	By project_InAtRiskTable = By.xpath("//table[@class='Project-project-table']/tbody/tr/td[1]");
	By accountExe_InAtRiskTable = By.xpath("//table[@class='Project-project-table']/tbody/tr/td[2]");
	By riskFactor_InAtRiskTable = By.xpath("//table[@class='Project-project-table']/tbody/tr/td[4]");

	// Surveys Completed
	// All are same as per survey sent


	public void verifyProjectBtnsAfterSurvey(String projectName) throws Exception {
		try {
			implWait(driver);
			By projectBtn = By.xpath("//td[text()='" + projectName + "']/parent::tr/td/div/button");

			List<WebElement> element = driver.findElements(projectBtn);
			if (element.size() > 0) {
				for (WebElement buttons : element) {

					String buttonTitle = buttons.getAttribute("title");
					if (buttonTitle.equals(dataKeys.sendProjectBtn) || buttonTitle.equals(dataKeys.deleteProjectBtn)) {

						grep.failTest("FeedBack Not Received");
						logger.error("FeedBack Not Received");
					} else {
						grep.passTest("FeedBack Received");
						logger.info("FeedBack Received");
					}
				}

			} else {
				grep.failTest(projectName + " Not Available");
				logger.error(projectName + " Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}

	// SURVEY SENT AND SURVEY COMPLETED

	public void selectPaginationIn_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(pagination_Popup).isEmpty();
			if (elementExist) {
				WebElement paginationOpt = driver.findElement(pagination_Popup);
				Select opt = new Select(paginationOpt);
				opt.selectByVisibleText(option);
				waitTime2(driver);
				String getOption = opt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					
					grep.passTest(getOption + " pagination Option Selected");
					logger.info(getOption + " pagination Option Selected");
				} else {
					grep.failTest(getOption + " pagination Option not Selected");
					logger.error(getOption + " pagination Option not Selected");
				}
			} else {
				grep.failTest(option + " Pagination Option not Available");
				logger.error(option + " Pagination Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectResponseStatusFilterIn_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(responseStatus_SurveySent).isEmpty();
			if (elementExist) {
				WebElement responseOption = driver.findElement(responseStatus_SurveySent);
				Select opt = new Select(responseOption);
				opt.selectByVisibleText(option);
				waitTime(driver);
				String getOption = opt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Response Status Option Selected");
					logger.info(getOption + " Response Status Option Selected");
				} else {
					grep.failTest(getOption + " Response Status Option not Selected");
					logger.error(getOption + " Response Status Option not Selected");
				}
			} else {
				grep.failTest(option + " Response Status Option not Available");
				logger.error(option + " Response Status Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectProjectFilterIn_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(project_Popup).isEmpty();
			if (elementExist) {
				WebElement projectOption = driver.findElement(project_Popup);
				Select projectOpt = new Select(projectOption);
				projectOpt.selectByVisibleText(option);
				waitTime(driver);
				String getOption = projectOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Project Option Selected");
					logger.info(getOption + " Project Option Selected");
				} else {
					grep.failTest(getOption + " Project Option not Selected");
					logger.error(getOption + " Project Option not Selected");
				}
			} else {
				grep.failTest(option + " Project Option not Available");
				logger.error(option + " Project Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectAcc_ExecFilterIn_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(accountExecutive_Popup).isEmpty();
			if (elementExist) {
				WebElement acc_ExeOption = driver.findElement(accountExecutive_Popup);
				Select acc_ExeOpt = new Select(acc_ExeOption);
				acc_ExeOpt.selectByVisibleText(option);
				waitTime(driver);
				String getOption = acc_ExeOpt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Account executive Option Selected");
					logger.info(getOption + " Account executive Option Selected");
				} else {
					grep.failTest(getOption + " Account executive Option not Selected");
					logger.error(getOption + " Account executive Option not Selected");
				}
			} else {
				grep.failTest(option + " Account executive Option not Available");
				logger.error(option + " Account executive Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectSurveyFilterIn_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(survey_SurveySent).isEmpty();
			if (elementExist) {
				WebElement surveyOption = driver.findElement(survey_SurveySent);
				Select opt = new Select(surveyOption);
				opt.selectByVisibleText(option);
				waitTime(driver);
				String getOption = opt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Survey Option Selected");
					logger.info(getOption + " Survey Option Selected");
				} else {
					grep.failTest(getOption + " Survey Option not Selected");
					logger.error(getOption + " Survey Option not Selected");
				}
			} else {
				grep.failTest(option + " Survey Option not Available");
				logger.error(option + " Survey Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getResponseStatus_ValueFromTable(String responseValue) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(response_InSurveySentTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement responseElement : element) {

					String response = responseElement.getText();
					if (!(response.equals(responseValue))) {
						count++;
						System.out.println(response);
						grep.infoTest(response);
						logger.info(response);
					}
				}
				if (count == 0) {
					grep.passTest("Response Status is Valid");
					logger.info("Response Status is Valid");
				} else {
					grep.failTest("Response Status is invalid");
					logger.error("Response Status is invalid");
				}

			} else {
				grep.failTest(" Response Status Column in table not Available");
				logger.error(" Response Status Column in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void getProject_ValueFromTable(String projectValue) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(project_InSurveySentTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement projectElement : element) {

					String project = projectElement.getText();
					if (!(project.equals(projectValue))) {
						count++;
						System.out.println(project);
						grep.infoTest(project);
						logger.info(project);
					}
				}
				if (count == 0) {
					grep.passTest("Project is Valid");
					logger.info("Project is Valid");
				} else {
					grep.failTest("Project is invalid");
					logger.error("Project is invalid");
				}

			} else {
				grep.failTest(" Project Column in table not Available");
				logger.error(" Project Column in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void getAcc_Exe_ValueFromTable(String accExeValue) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(accountExe_InSurveySentTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement accExeElement : element) {

					String accExe = accExeElement.getText();
					if (!(accExe.equals(accExeValue))) {
						count++;
						System.out.println(accExe);
						grep.infoTest(accExe);
						logger.info(accExe);
					}
				}
				if (count == 0) {
					grep.passTest("Account Executive is Valid");
					logger.info("Account Executive is Valid");
				} else {
					grep.failTest("Account Executive is invalid");
					logger.error("Account Executive is invalid");
				}

			} else {
				grep.failTest(" Account Executive Column in table not Available");
				logger.error(" Account Executive Column in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void getSurvey_ValueFromTable(String surveyValue) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(surveyName_InSurveySentTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement scoreElement : element) {

					String survey = scoreElement.getText();
					if (!(survey.equals(surveyValue))) {
						count++;
						System.out.println(survey);
						grep.infoTest(survey);
						logger.info(survey);
					}
				}
				if (count == 0) {
					grep.passTest("Survey Name is Valid");
					logger.info("Survey Name is Valid");
				} else {
					grep.failTest("Survey Name is invalid");
					logger.error("Survey Name is invalid");
				}

			} else {
				grep.failTest(" Survey Name Field in table not Available");
				logger.error(" Survey Name Field in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	// AT RISK

	public void selectRiskFactorFilterIn_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(riskFactor_inAtRisk).isEmpty();
			if (elementExist) {
				WebElement riskFactorOption = driver.findElement(riskFactor_inAtRisk);
				Select opt = new Select(riskFactorOption);
				opt.selectByVisibleText(option);
				waitTime(driver);
				String getOption = opt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " Risk Factor Option Selected");
					logger.info(getOption + " Risk Factor Option Selected");
				} else {
					grep.failTest(getOption + " Risk Factor Option not Selected");
					logger.error(getOption + " Risk Factor Option not Selected");
				}
			} else {
				grep.failTest(option + " Risk Factor Option not Available");
				logger.error(option + " Risk Factor Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getProject_AtRisk_ValueFromTable(String projectValue) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(project_InAtRiskTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement projectElement : element) {

					String project = projectElement.getText();
					if (!(project.equals(projectValue))) {
						count++;
						System.out.println(project);
						grep.infoTest(project);
						logger.info(project);
					}
				}
				if (count == 0) {
					grep.passTest("Project Option is Valid");
					logger.info("Project Option is Valid");
				} else {
					grep.failTest("Project Option is invalid");
					logger.error("Project Option is invalid");
				}

			} else {
				grep.failTest(" Project Field in table not Available");
				logger.error(" Project Column in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void getAccExe_AtRisk_ValueFromTable(String accExe_Value) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(accountExe_InAtRiskTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement accExeElement : element) {

					String accExe = accExeElement.getText();
					if (!(accExe.equals(accExe_Value))) {
						count++;
						System.out.println(accExe);
						grep.infoTest(accExe);
						logger.info(accExe);
					}
				}
				if (count == 0) {
					grep.passTest("Account Executive is Valid");
					logger.info("Account Executive Score is Valid");
				} else {
					grep.failTest("Account Executive is invalid");
					logger.error("Account Executive is invalid");
				}

			} else {
				grep.failTest(" Account Executive Column in table not Available");
				logger.error(" Account Executive Column in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void getRiskFactor_ValueFromTable(String riskValue) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(riskFactor_InAtRiskTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement riskElement : element) {

					String risk = riskElement.getText();
					if (!(risk.equals(riskValue))) {
						count++;
						System.out.println(risk);
						grep.infoTest(risk);
						logger.info(risk);
					}
				}
				if (count == 0) {
					grep.passTest("Risk Factor is Valid");
					logger.info("Risk Factor is Valid");
				} else {
					grep.failTest("Risk Factor is invalid");
					logger.error("Risk Factor is invalid");
				}

			} else {
				grep.failTest(" Risk Column in table not Available");
				logger.error(" Risk Column in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	// CSAT POPUP FILTERS

	public void selectPaginationInCSAT_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(csatPagination).isEmpty();
			if (elementExist) {
				WebElement paginationOpt = driver.findElement(csatPagination);
				Select opt = new Select(paginationOpt);
				opt.selectByVisibleText(option);
				waitTime(driver);
				String getOption = opt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " pagination Option Selected");
					logger.info(getOption + " pagination Option Selected");
				} else {
					grep.failTest(getOption + " pagination Option not Selected");
					logger.error(getOption + " pagination Option not Selected");
				}
			} else {
				grep.failTest(option + " Pagination Option not Available");
				logger.error(option + " Pagination Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectFilterInCSAT_Popup(String option) throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(csatDropdown).isEmpty();
			if (elementExist) {
				WebElement reviewOption = driver.findElement(csatDropdown);
				Select opt = new Select(reviewOption);
				opt.selectByVisibleText(option);
				waitTime(driver);
				String getOption = opt.getFirstSelectedOption().getText();
				if (getOption.equals(option)) {
					grep.passTest(getOption + " CSAT Option Selected");
					logger.info(getOption + " CSAT Option Selected");
				} else {
					grep.failTest(getOption + " CSAT Option not Selected");
					logger.error(getOption + " CSAT Option not Selected");
				}
			} else {
				grep.failTest(option + " CSAT Option not Available");
				logger.error(option + " CSAT Option not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String getCSAT_ScoreInPopup() throws Exception {
		String csatScore = null;
		try {

			implWait(driver);
			boolean elementExists = !driver.findElements(csatScoreInPopup).isEmpty();
			if (elementExists) {
				waitForElement(csatScoreInPopup, 60);
				csatScore = driver.findElement(csatScoreInPopup).getText();
				grep.passTest("CSAT Score Retrieved");
			} else {
				csatScore = "Failed to retrieve" + csatScoreInPopup;
				grep.failTest("CSAT Score Not Retrieved");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
		return csatScore;

	}

	public void getCSAT_ValueFromTable(String csatValue) throws Exception {
		try {

			implWait(driver);
			List<WebElement> element = driver.findElements(scoreInTable);
			if (element.size() > 0) {
				int count = 0;
				for (WebElement scoreElement : element) {

					String score = scoreElement.getText();
					if (!(score.startsWith(csatValue))) {
						count++;
						System.out.println(score);
						grep.infoTest(score);
						logger.info(score);
					}
				}
				if (count == 0) {
					grep.passTest("Csat Score is Valid");
					logger.info("Csat Score is Valid");
				} else {
					grep.failTest("Csat Score is invalid");
					logger.error("Csat Score is invalid");
				}

			} else {
				grep.failTest(" CSAT Column in table not Available");
				logger.error(" CSAT Column in table not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

}
