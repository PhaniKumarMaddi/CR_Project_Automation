package L_And_D_Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class L_And_D_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(L_And_D_Page.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public L_And_D_Page() {
		this.driver = DriverManager.getDriver();
	}

	By heroContectHeader = By.cssSelector("div.hero-content >h1");
	By heroContectDesc = By.cssSelector("div.hero-content >p");
	By startLearning = By.xpath("//button[text()='Start Learning']");

	// Course Continue Learning
	By continueLearnHeader = By.xpath("//div[@class='continue-learning']/div/h2");
	By continueCourseName = By.xpath("//div[@class='cl-courses']/div[1]/div[2]/h3");
	By progressPercent = By.xpath("//div[@class='cl-courses']/div[1]/div[2]/p[1]");
	By courseCategory = By.xpath("//div[@class='cl-courses']/div[1]/div[2]/p[2]");
	By courseLastAccess = By.xpath("//div[@class='cl-courses']/div[1]/div[2]/p[3]");
	By continueCourseBtn = By.xpath("//a[text()='Continue']");

	// feature Courses
	By featureCoursesList = By.xpath("//div[@class='fc-course-card']/div[2]/h3");
	By featureCourseDepartment = By.xpath("//div[@class='fc-course-grid']/div[1]/div[1]/span");
	By featureCourseLevel = By.xpath("//div[@class='fc-course-grid']/div[1]/div[2]/span");
	By featureCourseName = By.xpath("//div[@class='fc-course-grid']/div[1]/div[2]/h3");
	By featureCourseVideoCount = By.xpath("//div[@class='fc-course-grid']/div[1]/div[2]/p/span[1]");
	By featureCourseDuration = By.xpath("//div[@class='fc-course-grid']/div[1]/div[2]/p/span[2]");
	By featureCourseEnrollBtn = By.cssSelector("button.btn-enroll");

	// Browse Course by department
	By browseDeptHeader = By.cssSelector("div.bbd-header>h2");
	By viewAllDeptLink = By.linkText("View all departments →");
	By deptCard_header = By.cssSelector("div.bbd-card>h3");

	// Criticalriver Academy
	By academyHeader = By.cssSelector("div.why-academy>h2");
	By reasonCards = By.cssSelector("div.wa-reasons>div");
	By exploreAllCourses = By.cssSelector("button.btn-explore");

	// Footer
	By reserveRights = By.cssSelector("div.footer-bottom>p");
	By socialMediaLinks = By.xpath("//div[@class='footer-social']/a[@aria-label='Facebook']");

	// User Profile
	By profileLogo = By.xpath("div.user-profile");
	By profileBtn = By.xpath("//div[@class='user-profile']/div[2]/div[1]");

	// Navigate to Pages For Top
	public void navigateToPage(String pageName) throws Exception {
		try {
			implWait(driver);
			By pageNav = By.xpath("//nav[@class='header-center']/a[@href='" + pageName + "']");

			List<WebElement> element = driver.findElements(pageNav);
			if (element.size() > 0) {
				element.getFirst().click();

				grep.passTest("Navigated to " + pageName);
				logger.info("Navigated to " + pageName);
			} else {
				grep.failTest(pageName + " Not Available");
				logger.error(pageName + " Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Navigation to tabs in admin page
	public void naviagteToAdminTabs(String tabName) throws Exception {
		try {
			implWait(driver);
//			By tabNav = By.linkText(tabName);
			By tabNav = By.xpath("//a[@href='" + tabName + "']");

			List<WebElement> element = driver.findElements(tabNav);
			if (element.size() > 0) {
				element.getFirst().click();

				grep.passTest("Navigated to " + tabName);
				logger.info("Navigated to " + tabName);
			} else {
				grep.failTest(tabName + " Not Available");
				logger.error(tabName + " Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Header Content
	public void validateHomePageHeader() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(heroContectHeader).isEmpty();

			if (elementExist) {
				String header = driver.findElement(heroContectHeader).getText();
				String desc = driver.findElement(heroContectDesc).getText();

				grep.infoTest("Home Page Header Content: " + header);
				logger.info("Home Page Header Content: " + header);
				grep.infoTest("Home Page Description Content: " + desc);
				logger.info("Home Page Description Content: " + desc);
			} else {
				grep.failTest("Element Not Found");
				logger.error("Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickStartLearning() throws Exception {
		try {
			implWait(driver);

			WebElement element = driver.findElement(startLearning);
			if (element.isEnabled()) {
				element.click();

				grep.passTest("Start Learning Button Available");
				logger.info("Start Learning Button Available");
				waitTime(driver);
				String head = driver.findElement(browseDeptHeader).getText();
				grep.passTest("Header: " + head);
				logger.info("Header: " + head);

			} else {
				grep.failTest("Start Learning Button Not Available");
				logger.error("Start Learning Button Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Stat cards 
	public void homePageStatCards(String cardName) throws Exception {
		try {
			implWait(driver);

			By statCard=By.xpath("//p[text()='"+cardName+"']/parent::div/h2");

			boolean elementExists = !driver.findElements(statCard).isEmpty();
			if (elementExists) {
				scrollView(statCard);
				waitTime(driver);
				
				String count= driver.findElement(statCard).getText();
				grep.infoTest(cardName+" Card Count: "+count);
				logger.info(cardName+" Card Count: "+count);

			} else {
				grep.failTest(cardName +" Stat Card not available");
				logger.error(cardName +" Stat Card not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}
	

	// Continue Learning
	public void continueLearningDetails() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(continueLearnHeader).isEmpty();
			if (elementExists) {
				scrollView(continueLearnHeader);
				waitTime(driver);

				String header = driver.findElement(continueLearnHeader).getText();

				if (header.equals("Continue Learning")) {

					grep.passTest("Continue Learning Header is correct: " + header);
					logger.info("Continue Learning Header is correct" + header);
					waitTime(driver);
				} else {
					grep.failTest("Continue Learning Header is not correct: " + header);
					logger.info("Continue Learning Header is not correct" + header);
					waitTime(driver);
				}

				String contCourseName = driver.findElement(continueCourseName).getText();
				String prgPercent = driver.findElement(progressPercent).getText();
				String contCoursCategory = driver.findElement(courseCategory).getText();
				String contCourslastAcc = driver.findElement(courseLastAccess).getText();
				waitTime(driver);

				grep.passTest("Continue Learning Course Name: " + contCourseName);
				logger.info("Continue Learning Course Name" + contCourseName);
				grep.passTest("Continue Learning Progress Percentage: " + prgPercent);
				logger.info("Continue Learning Progress Percentage: " + prgPercent);
				grep.passTest("Continue Learning Course Category: " + contCoursCategory);
				logger.info("Continue Learning Course Category: " + contCoursCategory);
				grep.passTest("Continue Learning Course Last Accessed: " + contCourslastAcc);
				logger.info("Continue Learning Course Last Accessed: " + contCourslastAcc);

			} else {
				grep.failTest("Continue Learning not available");
				logger.error("Continue Learning not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickContinueLearnBtn() throws Exception {
		try {
			implWait(driver);

			List<WebElement> element = driver.findElements(continueCourseBtn);
			if (element.size() > 0) {
				element.getFirst().click();

				grep.passTest("Navigated to Course Video Page");
				logger.info("Navigated to Course Video Page");
			} else {
				grep.failTest("Continue button not available");
				logger.error("Continue button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Feature Courses
	public void getListOfFeatureCourses() throws Exception {
		try {
			implWait(driver);

			List<WebElement> list = driver.findElements(featureCoursesList);
			if (list.size() > 0) {
				scrollView(featureCoursesList);
				waitTime(driver);
				for (WebElement courseList : list) {
					String featureList = courseList.getText();

					grep.infoTest("Feature Course List Contains : " + featureList + " course");
					logger.info("Feature Course List Contains : " + featureList + " course");
					waitTime(driver);
				}

			} else {
				grep.failTest("Feature Course List not Available");
				logger.error("Feature Course List not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void featureCourseDetails() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(featureCoursesList).isEmpty();
			if (elementExists) {
				scrollView(featureCoursesList);
				waitTime(driver);

				String featurCrsDept = driver.findElement(featureCourseDepartment).getText();
				String featurCrsLevel = driver.findElement(featureCourseLevel).getText();
				String featurCrsname = driver.findElement(featureCourseName).getText();
				String featurCrsVidCnt = driver.findElement(featureCourseVideoCount).getText();
				String featurCrsDuration = driver.findElement(featureCourseDuration).getText();

				waitTime(driver);

				grep.passTest("Feature Course Department Name: " + featurCrsDept);
				logger.info("Feature Course Department Name: " + featurCrsDept);
				grep.passTest("Feature Course Course Level: " + featurCrsLevel);
				logger.info("Feature Course Course Level: " + featurCrsLevel);
				grep.passTest("Feature Course Name: " + featurCrsname);
				logger.info("Feature Course Name: " + featurCrsname);
				grep.passTest("Feature Course Video Count: " + featurCrsVidCnt);
				logger.info("Feature Course Video Count: " + featurCrsVidCnt);

				grep.passTest("Feature Course Duration: " + featurCrsDuration);
				logger.info("Feature Course Duration: " + featurCrsDuration);

			} else {
				grep.failTest("Feature Course List not Available");
				logger.error("Feature Course List not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickFeatureCourseEnrollButton() throws Exception {
		try {
			implWait(driver);

			List<WebElement> element = driver.findElements(featureCourseEnrollBtn);
			if (element.size() > 0) {
				scrollView(featureCourseEnrollBtn);
				waitTime(driver);
				
				element.getFirst().click();

			} else {
				grep.failTest("Enroll button not available");
				logger.error("Enroll button not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Browse By Departments
	public void clickViewAllDeptLink() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(viewAllDeptLink).isEmpty();
			if (elementExists) {
				driver.findElement(viewAllDeptLink).click();
			} else {
				grep.failTest("View All Department Link not available");
				logger.error("View All Department Link not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void verifyDepartmentCards() throws Exception {
		try {
			implWait(driver);
			List<WebElement> deptCards = driver.findElements(deptCard_header);
			if (deptCards.size() > 0) {
				scrollView(deptCard_header);
				waitTime(driver);
				for (WebElement deptCardsList : deptCards) {
					String headerList = deptCardsList.getText();
					grep.infoTest(headerList + " department is available");
					logger.info(headerList + " department is available");
					waitTime(driver);
					By deptTotalCourses = By.xpath("//h3[text()='" + headerList + "']/ancestor::a/div/span");

					grep.infoTest("Total Courses count for " + headerList + ": " + deptTotalCourses);
					logger.info("Total Courses count for " + headerList + ": " + deptTotalCourses);
					waitTime(driver);
				}

			} else {
				grep.failTest("Department List not Available");
				logger.error("Department List not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickDeptCard_InBrowseDept(String deptName) throws Exception {
		try {
			implWait(driver);
			By selectDeptCard = By.xpath("//div[@class='bbd-card']/h3[text()='" + deptName + "']");
			WebElement deptpageInfo = driver.findElement(By.cssSelector("div.department-info>h1"));

			boolean elementExists = !driver.findElements(selectDeptCard).isEmpty();
			if (elementExists) {
				scrollView(selectDeptCard);
				waitTime(driver);
				
				driver.findElement(selectDeptCard).click();

				if (deptpageInfo.getText().endsWith(deptName)) {
					grep.passTest("Navigated to " + deptName + " Department");
					logger.info("Navigated to " + deptName + " Department");
				} else {
					grep.failTest("Department Page not available");
					logger.error("Department Page not available");
				}

			} else {
				grep.failTest("Department Card not available");
				logger.error("Department Card not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Footer Urls
	public void footerURLs(String footerName) throws Exception {
		try {
			implWait(driver);
			By footerNav = By.xpath("//div[@class='footer-links-col']/a[text()='" + footerName + "']");

			List<WebElement> element = driver.findElements(footerNav);
			if (element.size() > 0) {
				element.getLast().click();

				grep.passTest("Navigated to " + footerName);
				logger.info("Navigated to " + footerName);
			} else {
				grep.failTest(footerName + " Not Available");
				logger.error(footerName + " Not Available");
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
