package L_And_D_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;

public class L_And_D_MyCoursesPage {

	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(L_And_D_MyCoursesPage.class);
	GenerateReports grep = new GenerateReports();
	TestDataKeys dataKeys = new TestDataKeys();

	public L_And_D_MyCoursesPage() {
		this.driver = DriverManager.getDriver();
	}

	By coursesHeader = By.cssSelector("div.my-courses>h1");
	By coursesDesc = By.cssSelector("div.my-courses>p");

	By coursestabs = By.xpath("//div[@class='tabs']/span[text()='All courses']");
	
}
