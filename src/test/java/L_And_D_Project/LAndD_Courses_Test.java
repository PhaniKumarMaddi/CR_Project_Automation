package L_And_D_Project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import BaseClasses.L_And_D_TestDataKeys;
import BaseClasses.L_And_D_TestInitializer;
import L_And_D_Pages.L_And_D_MyCoursesPage;
import L_And_D_Pages.L_And_D_Page;
import Utility.GenerateReports;

public class LAndD_Courses_Test extends L_And_D_TestInitializer {
	private static final Logger logger = LogManager.getLogger(LAndD_Page_UI_Test.class);
	GenerateReports grep = new GenerateReports();
	L_And_D_Page lndPage;
	L_And_D_MyCoursesPage lndCoursePage;
	L_And_D_TestDataKeys dataKeys = new L_And_D_TestDataKeys();

	@Test
	public void l_and_d_MyCourses() throws Exception {
		lndPage = new L_And_D_Page();
		lndCoursePage = new L_And_D_MyCoursesPage();

		grep.testCreate("My Courses Page test", "My Courses Page");
		waitTime(driver);
		lndPage.navigateToPage(dataKeys.myCoursesPageUrl);
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

		grep.testCreate("Course Card Details test", "Course Card Details");
		waitTime(driver);
		grep.infoTest("Course Card Details test");
		logger.info("Course Card Details test");
		lndCoursePage.verifyCourseDetails(dataKeys.pythonBeginnerCourse);
		lndCoursePage.verifyCourseDetails(dataKeys.airflowBeginnerCourse);
		lndCoursePage.verifyCourseDetails(dataKeys.mdmBeginnerCourse);

		grep.captureScreenshot("pass", "Course Details Page", "courseDetails");

		grep.testCreate("Continue Course test", "Continue Course");
		waitTime(driver);
		grep.infoTest("Continue Course test");
		logger.info("Continue Course test");
		lndCoursePage.clickContinueLearning(dataKeys.pythonBeginnerCourse);
		waitTime(driver);
		verifyUrl();
		grep.captureScreenshot("pass", "Inside Continue Learning page", "continueLearningPage");
		waitTime(driver);
		String list = lndCoursePage.getPlayVideoListDetails();

		lndCoursePage.clickPlayVideoList();
		waitTime(driver);
		lndCoursePage.clickPlayButton();
		grep.captureScreenshot("pass", "Play Course video", "playVideo");
		waitTime10(driver);

		
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
