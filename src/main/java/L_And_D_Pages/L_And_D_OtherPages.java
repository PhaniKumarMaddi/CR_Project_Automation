package L_And_D_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class L_And_D_OtherPages extends WaitsManager {

	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(L_And_D_MyCoursesPage.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public L_And_D_OtherPages() {
		this.driver = DriverManager.getDriver();
	}

	By searchDept = By.xpath("//input[@placeholder='Search departments...']");

	By deptpageInfo = By.cssSelector("div.department-info>h1");
	By searchCourse = By.xpath("//input[@class='search-input']");

	// Admin page
	By adminCards = By.xpath("//h3[text()='Certificates']/following-sibling::p");
	

	// search department
	public void searchDepartment(String deptName) throws Exception {
		try {
			implWait(driver);

			boolean elementExist = !driver.findElements(searchDept).isEmpty();
			if (elementExist) {

				driver.findElement(searchDept).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
				waitTime(driver);
				driver.findElement(searchDept).sendKeys(deptName);
				grep.passTest("Searching " + deptName + " Name");
				logger.info("Searching " + deptName + " Name");
			} else {
				grep.failTest("Seach department Element Not Found");
				logger.error("Seach department Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Explore selected department
	public void selectAndExploreDepartment(String deptName) throws Exception {
		try {
			implWait(driver);
			By selectDepartment = By
					.xpath("//div[@class='card-body']/h3[text()='" + deptName + "']/following-sibling::a");

			boolean elementExist = !driver.findElements(selectDepartment).isEmpty();
			if (elementExist) {

				driver.findElement(selectDepartment).click();

				String exploreDeptHeader = driver.findElement(deptpageInfo).getText();
				if (exploreDeptHeader.equals(deptName)) {
					grep.passTest("Exploring " + deptName + " Name");
					logger.info("Exploring " + deptName + " Name");
				} else {
					grep.failTest(deptName + " Not Available");
					logger.info(deptName + " Not Available");
				}

			} else {
				grep.failTest("Seach department Element Not Found");
				logger.error("Seach department Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// search courses
	public void searchCoursesInDept(String coursename) throws Exception {
		try {
			implWait(driver);

			boolean elementExist = !driver.findElements(searchCourse).isEmpty();

			if (elementExist) {

				driver.findElement(searchCourse).sendKeys(coursename);
				grep.passTest("Searching " + coursename + " Name");
				logger.info("Searching " + coursename + " Name");
			} else {

				grep.failTest("Seach course Element Not Found");
				logger.error("Seach courset Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	// Enroll selected course
	public void enrollCourseInDepartment(String courseName) throws Exception {
		try {
			implWait(driver);
			By enrollCourse = By.xpath("//h3[text()='" + courseName + "']/following-sibling::div[2]/button");

			boolean elementExist = !driver.findElements(enrollCourse).isEmpty();
			if (elementExist) {

				driver.findElement(enrollCourse).click();
				grep.passTest("Enrolling " + courseName + " Name");
				logger.info("Enrolling " + courseName + " Name");
			} else {
				grep.failTest("Seach department Element Not Found");
				logger.error("Seach department Element Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	
	// Verify Cards in Admin Page
//	public void a
}
