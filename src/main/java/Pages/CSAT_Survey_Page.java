package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.DriverManager;
import Utility.WaitsManager;

public class CSAT_Survey_Page extends WaitsManager {
	static WebDriver driver;

	public CSAT_Survey_Page() {
		this.driver = DriverManager.getDriver();
	}
	
	By loginHeader=By.cssSelector("button#login-4"); // tagname#id
	
	

}
