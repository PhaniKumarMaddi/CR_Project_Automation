package L_And_D_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	By selectDepartment= By.xpath("//div[@class='card-body']/h3[text()='Data Science and AI']/following-sibling::a");
	By searchCourse= By.xpath("//input[@class='search-input']");
	By enrollCOurse= By.xpath("//h3[text()='Airflow Beginner']/following-sibling::div[2]/button");
	
	
}

