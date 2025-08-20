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

	@Test(priority = 1 ,enabled = false)
	public void l_and_d_MyCourses() throws Exception {
		lndPage = new L_And_D_Page();
		lndCoursePage = new L_And_D_MyCoursesPage();
		lndOther = new L_And_D_OtherPages();

		refreshPage();
		waitTime2(driver);

		// exploring the department and enrolling the course
		exploreAndEnrollCourse(dataKeys.dept_DsAndAi, dataKeys.azureBeginnerCourse);
		waitTime(driver);

		grep.testCreate("My Courses Page test", "My Courses Page");
		waitTime3(driver);

		lndCoursePage.myCoursesHeader();

		lndCoursePage.clickTabInMyCourses(dataKeys.inProgressTab);
		grep.captureScreenshot("pass", "My Courses In Progress tab", "myCourses_InProgressTab");
		waitTime(driver);
		lndCoursePage.clickTabInMyCourses(dataKeys.completeTab);
		grep.captureScreenshot("pass", "My Courses Completed tab", "myCourses_CompletedTab");
		waitTime(driver);
		lndCoursePage.clickTabInMyCourses(dataKeys.allCourseTab);
		grep.captureScreenshot("pass", "My Courses All Courses tab", "myCourses_AllCoursesTab");
		waitTime5(driver);

		// Continue and update progress for Course test

		completeAndUpdateVideo(dataKeys.pythonBeginnerCourse);

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

//		grep.testCreate("Search Functionality for tables in dashboard test", "Search filter Tables in dashboard");
//
//		waitTime(driver);
//
//		// user management table
//		grep.infoTest("Search Functionality for " + dataKeys.userMgmtTable_dashboard + " table");
//		logger.info("Search Functionality for " + dataKeys.userMgmtTable_dashboard + " table");
//		lndOther.searchDashboardTable(dataKeys.userMgmtTable_dashboard, dataKeys.email_column_Dashboard,
//				dataKeys.ssoUserName);
//
//		grep.captureScreenshot("pass", "Search in user management table", "searchIn_userMgmtTable_dashboard");
//
//		lndOther.verifyDataInTable(dataKeys.userMgmtTable_dashboard, dataKeys.ssoUserName);
//		lndOther.clearDashboardTable(dataKeys.userMgmtTable_dashboard, dataKeys.email_column_Dashboard);
//
//		// course statistic table
//		grep.infoTest("Search Functionality for " + dataKeys.courseStctTable_dashboard + " table");
//		logger.info("Search Functionality for " + dataKeys.courseStctTable_dashboard + " table");
//		lndOther.searchDashboardTable(dataKeys.courseStctTable_dashboard, dataKeys.dept_column_Dashboard,
//				dataKeys.dept_EnergyWater);
//
//		grep.captureScreenshot("pass", "Search in Course Statistics table", "searchIn_courseStctsTable_dashboard");
//
//		lndOther.verifyDataInTable(dataKeys.courseStctTable_dashboard, dataKeys.dept_EnergyWater);
//		lndOther.clearDashboardTable(dataKeys.courseStctTable_dashboard, dataKeys.dept_column_Dashboard);
//
//		waitTime2(driver);
//
//		// Feedback overview table
//		grep.infoTest("Search Functionality for " + dataKeys.feedbackTable_dashboard + " table");
//		logger.info("Search Functionality for " + dataKeys.feedbackTable_dashboard + " table");
//		lndOther.searchDashboardTable(dataKeys.feedbackTable_dashboard, dataKeys.userId_column_Dashboard,
//				dataKeys.userId_col_Value);
//
//		grep.captureScreenshot("pass", "Search in Feedback Overview table", "searchIn_feedbackTable_dashboard");
//
//		lndOther.verifyDataInTable(dataKeys.feedbackTable_dashboard, dataKeys.userId_col_Value);
//		lndOther.clearDashboardTable(dataKeys.feedbackTable_dashboard, dataKeys.userId_column_Dashboard);
//
//		waitTime3(driver);
//
//		// get users for course by using course statistics
//		grep.testCreate("Get Users for Course by using Course statistics table test",
//				"Get Users for Course by using Course statistics table");
//		grep.infoTest("Get Users for Course by using Course statistics table test");
//		logger.info("Get Users for Course by using Course statistics table test");
//
//		lndOther.searchDashboardTable(dataKeys.courseStctTable_dashboard, dataKeys.courseName_column_Dashboard,
//				dataKeys.airflowBeginnerCourse);
//		lndOther.clickTotalUsersInDashboard(dataKeys.courseStctTable_dashboard);
//		waitTime(driver);
//		grep.captureScreenshot("pass", "Verify Total Users in course statistics table ",
//				"totalUsers_CourseStst_Dashboad");
//		waitTime(driver);
//		lndOther.verifyDataInTable(dataKeys.userMgmtTable_dashboard, dataKeys.airflowBeginnerCourse);
//		waitTime(driver);
//		grep.captureScreenshot("pass", "Verify Users for course table", "usersForCourseTable");
//		waitTime(driver);
//		lndOther.clearDashboardTable(dataKeys.courseStctTable_dashboard, dataKeys.courseName_column_Dashboard);
//		waitTime2(driver);
//		lndOther.clearFilterButton();

		// Test Tab in admin
		grep.testCreate("Search Functionality for tables in Tests Tab test", "Search filter Tables in tests");

		waitTime(driver);
		lndPage.naviagteToAdminTabs(dataKeys.testsTabUrl);
		waitTime5(driver);

		// Assessment request Notification table
		grep.infoTest("Search Functionality for " + dataKeys.ass_request_notify_table_Test + " table");
		logger.info("Search Functionality for " + dataKeys.ass_request_notify_table_Test + " table");
		lndOther.searchTestsTable(dataKeys.ass_request_notify_table_Test, dataKeys.userId_column_Test,
				dataKeys.userId_col_Value);

		grep.captureScreenshot("pass", "Search in Assessment Request table", "searchIn_AssmntRqstTable_Test");

		waitTime3(driver);
		lndOther.verifyDataInTestTable(dataKeys.ass_request_notify_table_Test, dataKeys.userId_col_Value);

		waitTime(driver);
		grep.infoTest("Search Functionality for " + dataKeys.course_Ass_table_Test + " table");
		logger.info("Search Functionality for " + dataKeys.course_Ass_table_Test + " table");
		lndOther.searchTestsTable(dataKeys.course_Ass_table_Test, dataKeys.courseName_column_Test,
				dataKeys.mdmBeginnerCourse);

		grep.captureScreenshot("pass", "Search in Assessment Request table", "searchIn_CourseAssmtTable_Test");

		lndOther.verifyDataInTestTable(dataKeys.course_Ass_table_Test, dataKeys.mdmBeginnerCourse);
		lndOther.clearTestsTable(dataKeys.course_Ass_table_Test);
		

		waitTime2(driver);

		// Roles Tab in admin
		grep.testCreate("Search Functionality for tables in Roles Tab test", "Search filter Tables in roles");

		waitTime5(driver);
		lndPage.naviagteToAdminTabs(dataKeys.rolesTabUrl);

		waitTime(driver);
		// User management table
		grep.infoTest("Search Functionality for " + dataKeys.userMgmtTable_dashboard + " table");
		logger.info("Search Functionality for " + dataKeys.userMgmtTable_dashboard + " table");
		lndOther.searchRolesTable(dataKeys.userMgmtTable_dashboard, dataKeys.email_column_Test, dataKeys.ssoUserName);

		grep.captureScreenshot("pass", "Search in User Management table", "searchIn_UsrMgmtTable_Role");

		lndOther.verifyDataInRolesTable(dataKeys.userMgmtTable_dashboard, dataKeys.ssoUserName);
		lndOther.clearRolesTable(dataKeys.userMgmtTable_dashboard);

		waitTime(driver);
	}

	@Test(priority = 3)
	public void l_and_d_CreateAssessment_Test() throws Exception {
		lndPage = new L_And_D_Page();
		lndOther = new L_And_D_OtherPages();

		lndPage.naviagteToAdminTabs(dataKeys.testsTabUrl);
		waitTime3(driver);
		grep.testCreate("Create New Assessment Test", "Create New Assessment");
		waitTime(driver);
		lndOther.selectCourseInAssessment(dataKeys.create_Assmt, dataKeys.course_id);
		waitTime(driver);
		lndOther.selectAssessment_number(dataKeys.create_Assmt, dataKeys.assmt_Number);
		lndOther.enter_Assmt_or_UserId(dataKeys.create_Assmt, dataKeys.assmt_id);
		waitTime(driver);
		grep.captureScreenshot("pass", "Create New Assessment Test", "createNewAssessment");
		waitTime(driver);
		lndOther.clickCreateOrGenerate_Assessment(dataKeys.create_Assmt);
		waitTime(driver);
		lndOther.generatedSuccessMessage(dataKeys.create_Assmt);
		waitTime5(driver);

		grep.testCreate("Generate Assessment Test", "Generate Assessment");
		waitTime(driver);
		lndOther.selectCourseInAssessment(dataKeys.generate_Assmt, dataKeys.course_id);
		waitTime(driver);
		lndOther.enter_Assmt_or_UserId(dataKeys.generate_Assmt, dataKeys.user_id);
		lndOther.selectAssessment_number(dataKeys.generate_Assmt, dataKeys.assmt_Number);

		waitTime(driver);
		grep.captureScreenshot("pass", "Generate Assessment Test", "generateAssessment");
		waitTime(driver);
		lndOther.clickCreateOrGenerate_Assessment(dataKeys.generate_Assmt);
		waitTime(driver);
		lndOther.generatedSuccessMessage(dataKeys.generate_Assmt);

		waitTime(driver);
		grep.testCreate("Certificates Page Test", "Certificates page");
		waitTime(driver);
		lndPage.navigateToPage(dataKeys.certificatesPageUrl);
		waitTime(driver);
		lndOther.certificatesPageTest();
		grep.captureScreenshot("pass", "Certificates Page Test", "certificate_Page_Test");
	}

	public void completeAndUpdateVideo(String courseName) throws Exception {

		grep.testCreate("Continue and update progress for Course test", "Continue and update progress for Course");
		waitTime3(driver);
		grep.infoTest("Continue and update progress for Course test");
		logger.info("Continue and update progress for Course test");
		waitTime(driver);

		waitTime(driver);
		lndCoursePage.getProgressPercent(courseName);
		waitTime3(driver);
		lndCoursePage.clickContinueLearning(courseName);
		waitTime5(driver);
		verifyUrl();
		waitTime3(driver);
		grep.captureScreenshot("pass", "Inside Continue Learning page", "continueLearningPage");
		waitTime(driver);
		lndCoursePage.getVideoListCount();
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
		waitTime3(driver);
		refreshPage();
		waitTime3(driver);
		lndCoursePage.getVideoListCount();
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
		lndPage.courseEnrolledMessage();
		waitTime5(driver);

		lndPage.navigateToPage(dataKeys.myCoursesPageUrl);
		waitTime3(driver);
		lndCoursePage.myCoursePagination("30");
		waitTime(driver);
		grep.testCreate("Verify enrolled course Card Details test", "Verify Enrolled Course Card Details");
		waitTime(driver);
		grep.infoTest("Enrolled Course Card Details test");
		logger.info("Enrolled Course Card Details test");
		lndCoursePage.verifyCourseDetails(courseName);

		grep.captureScreenshot("pass", "Course Details Page", "courseDetails");

		waitTime(driver);
	}

	public void verifyUrl() throws Exception {
		String getUrlVal = getURL();
		if (getUrlVal.endsWith(dataKeys.courseVideoUrl)) {
			grep.passTest(" Url is Valid :" + getUrlVal);
			logger.info(" Url is Valid :" + getUrlVal);
			waitTime(driver);
		} else {
			grep.failTest("Url is not Valid :" + getUrlVal);
			logger.error("Url is not Valid :" + getUrlVal);
		}

	}
}
