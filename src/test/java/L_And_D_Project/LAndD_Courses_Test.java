package L_And_D_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.L_And_D_TestDataKeys;
import BaseClasses.L_And_D_TestInitializer;
import L_And_D_Pages.L_And_D_MyCoursesPage;
import L_And_D_Pages.L_And_D_OtherPages;
import L_And_D_Pages.L_And_D_Page;
import Utility.GenerateReports;

public class LAndD_Courses_Test extends L_And_D_TestInitializer {
	private static final Logger logger = LogManager.getLogger(LAndD_Page_UI_Test.class);
	GenerateReports grep = new GenerateReports();
	L_And_D_Page lndPage;
	L_And_D_MyCoursesPage lndCoursePage;
	L_And_D_OtherPages lndOther;
	L_And_D_TestDataKeys dataKeys = new L_And_D_TestDataKeys();

	@Test(priority = 1, enabled = false)
	public void l_and_d_MyCourses() throws Exception {
		lndPage = new L_And_D_Page();
		lndCoursePage = new L_And_D_MyCoursesPage();
		lndOther = new L_And_D_OtherPages();

		refreshPage();
		waitTime2(driver);

		// exploring the department and enrolling the course
		exploreAndEnrollCourse(dataKeys.dept_DsAndAi, dataKeys.airflowAdvanceCourse);
		waitTime(driver);

		grep.testCreate("My Courses Page test", "My Courses Page");
		waitTime(driver);

		waitTime(driver);

		lndCoursePage.myCoursesHeader();

		lndCoursePage.clickTabInMyCourses(dataKeys.inProgressTab);
		grep.captureScreenshot("pass", "My Courses In Progress tab", "myCourses_InProgressTab");
		waitTime(driver);
		lndCoursePage.clickTabInMyCourses(dataKeys.completeTab);
		grep.captureScreenshot("pass", "My Courses Completed tab", "myCourses_CompletedTab");
		waitTime(driver);
		lndCoursePage.clickTabInMyCourses(dataKeys.allCourseTab);
		grep.captureScreenshot("pass", "My Courses All Courses tab", "myCourses_AllCoursesTab");
		waitTime(driver);

		waitTime(driver);
		// Continue and update progress for Course test
		completeAndUpdateVideo(dataKeys.testAutomationBeginnerCourse);

	}

	@Test(priority = 2)
	public void l_and_d_AdminPageTest() throws Exception {
		lndPage = new L_And_D_Page();
		lndOther = new L_And_D_OtherPages();

		lndPage.navigateToPage(dataKeys.adminPageUrl);
		waitTime(driver);
		grep.testCreate("Verify Admin page cards in dashboard tab", "Admin page Cards");

		grep.infoTest("Verify Admin page cards in dashboard tab");
		logger.info("Verify Admin page cards in dashboard tab");
		waitTime3(driver);
		lndOther.adminCardsText(dataKeys.certificate_adminCard);
		lndOther.adminCardsText(dataKeys.department_adminCard);
		lndOther.adminCardsText(dataKeys.activeCourses_adminCard);
		lndOther.adminCardsText(dataKeys.users_adminCard);
		waitTime(driver);
		grep.captureScreenshot("pass", "Admin Card Details", "adminCards_Dashboad");

		// verify certificate details
		grep.testCreate("Verify Admin page certificates details in dashboard tab", "Admin page certificates details");
		lndOther.clickCertificateAdminCards();
		lndOther.getCertificateDetails(dataKeys.userMgmtTable_dashboard);
		grep.captureScreenshot("pass", "Admin Card Certificates Details", "certificateCardDeatils_Dashboad");
		waitTime(driver);
		lndOther.openCertificate(dataKeys.userMgmtTable_dashboard);
		waitTime5(driver);
		grep.captureScreenshot("pass", "Open Certificate", "viewCertificate");
		waitTime(driver);
		lndOther.clickCloseCertificate();
		waitTime(driver);

		lndOther.clickCertificateAdminCards();

		waitTime(driver);

		grep.testCreate("Search Functioanlity for tables in dashboard test", "Search filter Tables in dashboard");

		waitTime(driver);

		// user management table
		grep.infoTest("Search Functionality for " + dataKeys.userMgmtTable_dashboard + " table");
		logger.info("Search Functionality for " + dataKeys.userMgmtTable_dashboard + " table");
		lndOther.searchDashboardTable(dataKeys.userMgmtTable_dashboard, dataKeys.email_column_Dashboard,
				dataKeys.ssoUserName);

		grep.captureScreenshot("pass", "Search in user management table", "searchIn_userMgmtTable_dashboard");

		lndOther.verifyDataInTable(dataKeys.userMgmtTable_dashboard, dataKeys.ssoUserName);
		lndOther.clearDashboardTable(dataKeys.userMgmtTable_dashboard, dataKeys.email_column_Dashboard,
				dataKeys.ssoUserName);

		// course statistic table
		grep.infoTest("Search Functionality for " + dataKeys.courseStctTable_dashboard + " table");
		logger.info("Search Functionality for " + dataKeys.courseStctTable_dashboard + " table");
		lndOther.searchDashboardTable(dataKeys.courseStctTable_dashboard, dataKeys.dept_column_Dashboard,
				dataKeys.dept_EnergyWater);

		grep.captureScreenshot("pass", "Search in Course Statistics table", "searchIn_courseStctsTable_dashboard");

		lndOther.verifyDataInTable(dataKeys.courseStctTable_dashboard, dataKeys.dept_EnergyWater);
		lndOther.clearDashboardTable(dataKeys.courseStctTable_dashboard, dataKeys.dept_column_Dashboard,
				dataKeys.dept_EnergyWater);

		// Feedback overview table
		grep.infoTest("Search Functionality for " + dataKeys.feedbackTable_dashboard + " table");
		logger.info("Search Functionality for " + dataKeys.feedbackTable_dashboard + " table");
		lndOther.searchDashboardTable(dataKeys.feedbackTable_dashboard, dataKeys.userId_column_Dashboard,
				dataKeys.userId_col_Value);

		grep.captureScreenshot("pass", "Search in Feedback Overview table", "searchIn_feedbackTable_dashboard");

		lndOther.verifyDataInTable(dataKeys.feedbackTable_dashboard, dataKeys.dept_EnergyWater);
		lndOther.clearDashboardTable(dataKeys.feedbackTable_dashboard, dataKeys.userId_column_Dashboard,
				dataKeys.userId_col_Value);

		// get users for course  by using course statistics
		grep.testCreate("Get Users for Course by using Course statistics table test", "Get Users for Course by using Course statistics table");
		lndOther.searchDashboardTable(dataKeys.courseStctTable_dashboard, dataKeys.courseName_column_Test,
				dataKeys.airflowBeginnerCourse);
		

	
	}

	public void completeAndUpdateVideo(String courseName) throws Exception {

		grep.testCreate("Continue and update progress for Course test", "Continue and update progress for Course");
		waitTime(driver);
		grep.infoTest("Continue and update progress for Course test");
		logger.info("Continue and update progress for Course test");
		waitTime(driver);

		waitTime(driver);
		lndCoursePage.getProgressPercent(courseName);
		waitTime(driver);
		lndCoursePage.clickContinueLearning(courseName);
		waitTime(driver);
		verifyUrl();
		grep.captureScreenshot("pass", "Inside Continue Learning page", "continueLearningPage");
		waitTime(driver);
		lndCoursePage.getPlayVideoListDetails();
		waitTime(driver);

		lndCoursePage.clickPlayVideoList();

		waitTime1(driver);
		grep.captureScreenshot("pass", "Select Course video", "selectVideo_ForCourse");
		waitTime(driver);
		switchToFrame("youtube-player");
		waitTime(driver);
		lndCoursePage.clickPlayButton();
		waitTime3(driver);
		grep.captureScreenshot("pass", "Play Course video", "playVideo_ForCourse");
		waitTime10(driver);
		lndCoursePage.completeVideo();
		switchToMainFrame();
		waitTime(driver);
		grep.captureScreenshot("pass", "Complete Course video", "completeVideo_ForCourse");
		lndCoursePage.verifyCompleteVideoMessage();
		waitTime(driver);

		lndPage.navigateToPage(dataKeys.myCoursesPageUrl);
		waitTime(driver);
		lndCoursePage.getProgressPercent(courseName);
		waitTime(driver);

	}

	public void exploreAndEnrollCourse(String deptName, String courseName) throws Exception {
		grep.testCreate("Explore Department and Enroll Course test", "Explore Department and Enroll Course");
		waitTime(driver);
		grep.infoTest("Explore Department and Enroll Course test");
		logger.info("Explore Department and Enroll Course test");

		lndPage.navigateToPage(dataKeys.depatmentsPageUrl);
		waitTime(driver);
		lndOther.searchDepartment(deptName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Search Department", "searchDepartment_inDept");
		waitTime(driver);
		lndOther.selectAndExploreDepartment(deptName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Explore Department", "exploreDepartment_inDept");
		lndOther.searchCoursesInDept(courseName);
		waitTime(driver);
		grep.captureScreenshot("pass", "Search and Enrolling Course", "Search_EnrollCourse_inDept");
		waitTime(driver);
		lndOther.enrollCourseInDepartment(courseName);
		waitTime(driver);
		if (isAlertPresent()) {
			acceptalert();
		}

		waitTime(driver);

		lndPage.navigateToPage(dataKeys.myCoursesPageUrl);
		grep.testCreate("Verify enrolled course Card Details test", "Verify Enrolled Course Card Details");
		waitTime(driver);
		grep.infoTest("Enrolled Course Card Details test");
		logger.info("Enrolled Course Card Details test");
		lndCoursePage.verifyCourseDetails(courseName);

		grep.captureScreenshot("pass", "Course Details Page", "courseDetails");

		waitTime(driver);
	}

	public void verifyUrl() throws Exception {
		String getUrl = driver.getCurrentUrl();
		if (getUrl.endsWith(dataKeys.courseVideoUrl)) {
			grep.passTest(" Url is Valid :" + getUrl);
			logger.info(" Url is Valid :" + getUrl);
			waitTime(driver);
		} else {
			grep.failTest("Url is not Valid :" + getUrl);
			logger.error("Url is not Valid :" + getUrl);
		}

	}
}
