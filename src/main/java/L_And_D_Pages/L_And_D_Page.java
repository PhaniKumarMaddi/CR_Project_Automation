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
	// ready to start
	By readyToStrt = By.xpath("//div[@class='ready-to-start']");
	By exploreAllCourses = By.cssSelector("button.btn-explore");

	// User Profile
	By profileLogo = By.cssSelector("div.user-profile");
	By profileBtn = By.xpath("//div[@class='user-profile']/div[2]/div[1]");
	By profileInfo = By.cssSelector("div.profile-info-block>div");
	By logoutBtn =  By.xpath("//div[@class='user-profile']/div[2]/div[2]");
	
	// Footer
	By reserveRights = By.cssSelector("div.footer-bottom>p");

//	By enrollMessage = By.xpath("//div[@id='monica-content-root']/following-sibling::div");
	// body/div[3]
	By enrollMessage = By
			.xpath("//div[starts-with(@style,'position: fixed; top: 20px; left: 50%; transform: translateX(-50%); ')]");

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
				scrollView(By.xpath("//span[text()='Admin - CriticalRiver Learning & Development']"));
				waitTime(driver);
				
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
			scrollView(startLearning);
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Click Profile
	public void clickProfilePage() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(profileLogo).isEmpty();
			if (elementExists) {
				driver.findElement(profileLogo).click();
				waitTime(driver);
				driver.findElement(profileBtn).click();
				grep.passTest("Navigate to Profile Page");
				logger.info("Navigate to Profile Page");

			} else {
				grep.failTest("Profile Button Not Available");
				logger.error("Profile Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}
	
	public void clickLogoutBtn() throws Exception {
		try {
			implWait(driver);


			boolean elementExists = !driver.findElements(profileLogo).isEmpty();
			if (elementExists) {
				driver.findElement(profileLogo).click();
				waitTime(driver);
				driver.findElement(logoutBtn).click();
				grep.passTest("Logout From L and D");
				logger.info("Logout From L and D");

			} else {
				grep.failTest("Logout Button Not Available");
				logger.error("Logout Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getProfileInfo() throws Exception {
		try {
			implWait(driver);

			List<WebElement> profile = driver.findElements(profileInfo);
			if (profile.size() > 0) {
				for (WebElement profileData : profile) {
					String info = profileData.getText();

					grep.infoTest("Profile Page Information: " + info);
					logger.info("Profile Page Information: " + info);

				}
			} else {
				grep.failTest("Profile Page Information Not available");
				logger.error("Profile Page Information Not available");
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

			By statCard = By.xpath("//p[text()='" + cardName + "']/parent::div/h2");

			boolean elementExists = !driver.findElements(statCard).isEmpty();
			if (elementExists) {

				String count = driver.findElement(statCard).getText();
				grep.infoTest(cardName + " Card Count: " + count);
				logger.info(cardName + " Card Count: " + count);

			} else {
				grep.failTest(cardName + " Stat Card not available");
				logger.error(cardName + " Stat Card not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickHomePageStatCards(String cardName) throws Exception {
		try {
			implWait(driver);

			By statCard = By.xpath("//p[text()='" + cardName + "']/parent::div/h2");

			boolean elementExists = !driver.findElements(statCard).isEmpty();
			if (elementExists) {
				scrollView(startLearning);
				waitTime(driver);

				driver.findElement(statCard).click();
				grep.infoTest("Clicking on " + cardName + " Card");
				logger.info("Clicking on " + cardName + " Card");

			} else {
				grep.failTest(cardName + " Stat Card not available");
				logger.error(cardName + " Stat Card not available");
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
					logger.info("Continue Learning Header is correct: " + header);
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

				grep.passTest("Feature Courses contains Department Name: " + featurCrsDept);
				logger.info("Feature Courses contains Department Name: " + featurCrsDept);
				grep.passTest("Feature Courses contains Course Level: " + featurCrsLevel);
				logger.info("Feature Courses contains Course Level: " + featurCrsLevel);
				grep.passTest("Feature Courses contains Name: " + featurCrsname);
				logger.info("Feature Courses contains Name: " + featurCrsname);
				grep.passTest("Feature Courses contains Video Count: " + featurCrsVidCnt);
				logger.info("Feature Courses contains Video Count: " + featurCrsVidCnt);

				grep.passTest("Feature Courses contains Duration: " + featurCrsDuration);
				logger.info("Feature Courses contains Duration: " + featurCrsDuration);

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
				scrollView(continueLearnHeader);
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
				scrollView(featureCourseDepartment);
				waitTime(driver);
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
					String deptTotalCourses = driver
							.findElement(By.xpath("//h3[text()='" + headerList + "']/ancestor::a/div/span")).getText();

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

	public void clickDeptCard_InBrowseDept(String deptCardName, String deptName) throws Exception {
		try {
			implWait(driver);
			scrollView(browseDeptHeader);
			waitTime(driver);
//			By selectDeptCard = By.xpath("//a[@href='" + deptCardName + "']");
			By selectDeptCard = By.xpath("//div[@class='bbd-grid']/a[@href='" + deptCardName + "']/div");

			boolean elementExists = !driver.findElements(selectDeptCard).isEmpty();
			if (elementExists) {
				driver.findElement(selectDeptCard).click();
				waitTime(driver);
				WebElement deptpageInfo = driver.findElement(By.cssSelector("div.department-info>h1"));
				if (deptpageInfo.getText().equals(deptName)) {
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

	// CriticalRiver Academy
	public void whyCR_Academy() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(academyHeader).isEmpty();
			if (elementExists) {
				String academyHeadVal = driver.findElement(academyHeader).getText();
				String reason1 = driver.findElement(By.xpath("//div[@class='wa-reasons']/div[1]")).getText();
				String reason2 = driver.findElement(By.xpath("//div[@class='wa-reasons']/div[2]")).getText();
				String reason3 = driver.findElement(By.xpath("//div[@class='wa-reasons']/div[3]")).getText();

				grep.infoTest("Academy Header :" + academyHeadVal);
				logger.info("Academy Header :" + academyHeadVal);

				grep.infoTest("Academy Reason youtube :" + reason1);
				logger.info("Academy Reason youtube :" + reason1);

				grep.infoTest("Academy Reason Certificates :" + reason2);
				logger.info("Academy Reason Certificates :" + reason2);

				grep.infoTest("Academy Reason Learning paths :" + reason3);
				logger.info("Academy Reason Learning paths :" + reason3);

			} else {
				grep.failTest("Academy Info Not Available");
				logger.error("Academy Info Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Ready to start
	public void homePage_ReadyToStart() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(readyToStrt).isEmpty();
			if (elementExists) {
				String readyVal = driver.findElement(readyToStrt).getText();

				grep.infoTest("Ready To Start:" + readyVal);
				logger.info("Ready To Start" + readyVal);

				grep.infoTest("Explore all courses");
				logger.info("Explore all courses");

				driver.findElement(exploreAllCourses).click();

			} else {
				grep.failTest("Ready to start Info Not Available");
				logger.error("Ready to start Info Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Footer Urls

	public void footerRights() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(reserveRights).isEmpty();
			if (elementExists) {
				scrollView(reserveRights);

				String rights = driver.findElement(reserveRights).getText();
				grep.infoTest("Reserve Rigths: " + rights);
				logger.info("Reserve Rigths: " + rights);
			} else {
				grep.failTest("Reserve Rigths not available");
				logger.error("Reserve Rigths not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void footerURLs(String footerName) throws Exception {
		try {
			implWait(driver);
			By footerNav = By.xpath("//div[@class='footer-links-col']/a[@href='" + footerName + "']");

			List<WebElement> element = driver.findElements(footerNav);
			if (element.size() > 0) {
				scrollView(reserveRights);
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

	public void footerMedia_URLs(String footerName) throws Exception {
		try {
			implWait(driver);
			By socialMediaLinks = By.xpath("//div[@class='footer-social']/a[@aria-label='" + footerName + "']");

			List<WebElement> element = driver.findElements(socialMediaLinks);
			if (element.size() > 0) {
				scrollView(reserveRights);
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

	public void courseEnrolledMessage() throws Exception {
		try {
			waitForElement(enrollMessage, 90);

			String message = driver.findElement(enrollMessage).getText();
			grep.passTest("Course Enrollment message: " + message);
			logger.info("Course Enrollment message: " + message);

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
