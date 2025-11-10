package IntelliServe_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Utility.DriverManager;
import Utility.GenerateReports;

public class Ticketing_Admin_FilterPage {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(Ticketing_Page.class);
	GenerateReports grep = new GenerateReports();

	public Ticketing_Admin_FilterPage() {
		this.driver = DriverManager.getDriver();
	}
	

}
