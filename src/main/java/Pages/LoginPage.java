package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.DriverManager;

public class LoginPage {
	static WebDriver driver;

	public LoginPage() {
		this.driver = DriverManager.getDriver();
	}

	By userName=By.xpath("");
	By password = By.xpath("");

}

