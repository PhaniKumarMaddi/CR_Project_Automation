package L_And_D_Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class L_And_D_MyCoursesPage extends WaitsManager {

	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(L_And_D_MyCoursesPage.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public L_And_D_MyCoursesPage() {
		this.driver = DriverManager.getDriver();
	}

	By coursesHeader = By.cssSelector("div.my-courses>h1");
	By coursesDesc = By.cssSelector("div.my-courses>p");

	By playIn_VideoList = By.xpath("//div[@class='coursevideos-video-item  ']");
	By playBtn = By.xpath("//button[@title='Play']");

	public void myCoursesHeader() throws Exception {
		try {
			implWait(driver);
			boolean elementExist = !driver.findElements(coursesHeader).isEmpty();

			if (elementExist) {
				String header = driver.findElement(coursesHeader).getText();
				String desc = driver.findElement(coursesDesc).getText();

				grep.infoTest("Header : " + header);
				logger.info("Header : " + header);
				grep.infoTest("Description for My courses: " + desc);
				logger.info("Description for My courses: " + desc);
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

	// My Courses Tabs
	public void clickTabInMyCourses(String tabName) throws Exception {
		try {
			implWait(driver);
			By coursestabs = By.xpath("//div[@class='tabs']/span[text()='" + tabName + "']");

			boolean elementExist = !driver.findElements(coursestabs).isEmpty();
			if (elementExist) {

				driver.findElement(coursestabs).click();
				grep.passTest("Inside " + tabName + " Tab");
				logger.info("Inside " + tabName + " Tab");
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

	// My Courses- Course Card Details
	public void verifyCourseDetails(String courseName) throws Exception {
		try {
			implWait(driver);
			By course = By.xpath("//h3[text()='" + courseName + "']");

			boolean elementExist = !driver.findElements(course).isEmpty();
			if (elementExist) {

				String courseCategory = driver
						.findElement(By.xpath("//h3[text()='" + courseName + "']/parent::div/div[1]/span[1]"))
						.getText();
				String courseLevel = driver
						.findElement(By.xpath("//h3[text()='" + courseName + "']/parent::div/div[1]/span[2]"))
						.getText();
				String videoCount = driver.findElement(By.xpath("//h3[text()='" + courseName + "']/parent::div/p[1]"))
						.getText();
				String courseDuration = driver
						.findElement(By.xpath("//h3[text()='" + courseName + "']/parent::div/p[2]")).getText();
				String progressPercent = driver
						.findElement(By.xpath("//h3[text()='" + courseName + "']/parent::div/div[2]/span")).getText();

				grep.infoTest("Course Category for " + courseName + ": " + courseCategory);
				logger.info("Course Category for " + courseName + ": " + courseCategory);

				grep.infoTest("Course Level for " + courseName + ": " + courseLevel);
				logger.info("Course Level for " + courseName + ": " + courseLevel);

				grep.infoTest("Course Video Count for " + courseName + ": " + videoCount);
				logger.info("Course Video Count for " + courseName + ": " + videoCount);

				grep.infoTest("Course Duration for " + courseName + ": " + courseDuration);
				logger.info("Course Duration for " + courseName + ": " + courseDuration);

				grep.infoTest("Course Progress percent for " + courseName + ": " + progressPercent);
				logger.info("Course Progress percent for " + courseName + ": " + progressPercent);

			} else {
				grep.failTest("Course Not Found");
				logger.error("Course Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickContinueLearning(String courseName) throws Exception {
		try {
			implWait(driver);
			By continueLearning = By.xpath("//h3[text()='" + courseName + "']/parent::div/div[2]/a");

			boolean elementExist = !driver.findElements(continueLearning).isEmpty();
			if (elementExist) {

				driver.findElement(continueLearning).click();

			} else {
				grep.failTest("Course Not Found");
				logger.error("Course Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public String getPlayVideoListDetails() throws Exception {
		String playText = null;
		try {
			implWait(driver);

//			By playIn_VideoListValue = By.xpath("//div[@class='coursevideos-video-item  ']/span");
			List<WebElement> play = driver.findElements(playIn_VideoList);
			if (play.size() > 0) {

				String fullText = play.getFirst().getText();

				String[] parts = fullText.split(" ");
				playText = parts[0];
				grep.infoTest("Video Available in the list:" + playText);
				logger.info("Video Available in the list:" + playText);

			} else {
				grep.failTest("Course Not Found");
				logger.error("Course Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return playText;
	}

	public void clickPlayVideoList() throws Exception {
		try {
			implWait(driver);

			List<WebElement> play = driver.findElements(playIn_VideoList);
			if (play.size() > 0) {

				play.getFirst().click();
				grep.infoTest("Select Video from video list");
				logger.info("Select Video from video list");

			} else {
				grep.failTest("Course Not Found");
				logger.error("Course Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickPlayButton() throws Exception {
		try {
			implWait(driver);

			boolean elementExist = !driver.findElements(playBtn).isEmpty();
			if (elementExist) {
				driver.findElement(playBtn).click();
				grep.infoTest("Click Play Video");
				logger.info("Click Play Video");

			} else {
				grep.failTest("Course Not Found");
				logger.error("Course Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}
}
