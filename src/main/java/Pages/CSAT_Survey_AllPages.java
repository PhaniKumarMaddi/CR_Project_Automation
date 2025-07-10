package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.WaitsManager;

public class CSAT_Survey_AllPages extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(CSAT_Survey_AllPages.class);
	GenerateReports grep = new GenerateReports();

	public CSAT_Survey_AllPages() {
		this.driver = DriverManager.getDriver();
	}

	By homePageLogo = By.xpath("//div[@class='logo-container text-center']/img");
	By profileName = By.xpath("//div[@class='sidebar p-3 ']/center[2]");
	By sideMenu = By.xpath("//button[@class='nav-link11 toggle-sidebar-btn']");
	By logoutBtn = By.xpath("//button[@class='nav-link11']");
	By settingsLink = By.xpath("//a[@class='nav-link settings-link' and @href='/settings/org-members']");

	public void logoInHomePage() throws Exception {
		try {
			waitForElement(homePageLogo, 30);
			String verifyLogo = driver.findElement(homePageLogo).getAttribute("alt");
			if (verifyLogo.equals("CSAT Logo")) {
				logger.info("Logo is Available " + verifyLogo);
				grep.passTest("Logo is Available " + verifyLogo);
			} else {
				logger.error("Logo Not Available " + verifyLogo);
				grep.failTest("Logo Not Available " + verifyLogo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void verifyProfileNameInHomePage(String profileNameValue) throws Exception {
		try {
			waitForElement(profileName, 30);
			String verifyProfile = driver.findElement(profileName).getText();
			if (verifyProfile.equals(profileNameValue)) {
				logger.info("Profile Name is Valid: " + verifyProfile);
				grep.passTest("Profile Name is Valid: " + verifyProfile);
			} else {
				logger.error("Profile Name is not Valid: " + verifyProfile);
				grep.failTest("Profile Name is not Valid: " + verifyProfile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void collapseSideMenu() throws Exception {
		try {

			waitForElement(sideMenu, 30);
			WebElement menu = driver.findElement(sideMenu);
			String menuBtn = menu.getAttribute("title");
			if (menuBtn.equals("Collapse Sidebar")) {
				menu.click();
				grep.infoTest("Menu Collapsed");
				logger.info("Menu Collapsed");
			} else {
				grep.infoTest("Menu Collapsed");
				logger.info("Menu Collapsed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	public void expandSideMenu() throws Exception {
		try {

			waitForElement(sideMenu, 30);
			WebElement menu = driver.findElement(sideMenu);
			String menuBtn = menu.getAttribute("title");
			if (menuBtn.equals("Expand Sidebar")) {
				menu.click();
				grep.infoTest("Menu Expanded");
				logger.info("Menu Expanded");
			} else {
				grep.infoTest("Menu Expanded");
				logger.info("Menu Expanded");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}

	}

	// navigation to different pages
	public void navigateToPage(String pageName) throws Exception {
		try {
//			By pageNavigation = By.xpath("//span[text()='" + pageName + "']");
//			By pageNavigation = By.xpath("//a[@class='nav-link']/span[text()='" + pageName + "']");
			By pageNavigation = By.xpath("//a[@class='nav-link' and @href='" + pageName + "']");
			implWait(driver);
//		boolean elementExists = !driver.findElements(By.xpath("//span[@class='sidebar-text'][text()='"+pageName+"']").isEmpty();
			boolean elementExists = !driver.findElements(pageNavigation).isEmpty();
			if (elementExists) {
				driver.findElement(pageNavigation).click();
			} else {
				logger.error("Page Not Found");
				grep.failTest("Page Not Found");
			}
		} catch (Exception e) {

		}
	}

	public void navigateToSettingsPage(String pageName) throws Exception {
		try {
			implWait(driver);
			String menu = driver.findElement(sideMenu).getAttribute("title");
			WebElement settings = driver.findElement(settingsLink);
			if (menu.equals("Collapse Sidebar")) {
				settings.click();
				waitTime(driver);
				driver.findElement(By.xpath("//div[@class='submenu-below']/a[@href='" + pageName + "']")).click();
				waitTime2(driver);
			} else {
				settings.click();
				System.out.println("clicked settings before");
				driver.findElement(By.xpath("//div[@class='hover-popup']/a[@href='" + pageName + "']")).click();
			}
		} catch (Exception e) {

		}
	}

	public void navigateToSettingsOrgPage() throws Exception {
		try {
			implWait(driver);
			driver.findElement(settingsLink).click();

		} catch (Exception e) {

		}
	}

	public void clickLogout() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(logoutBtn).isEmpty();
			if (elementExists) {
				driver.findElement(logoutBtn).click();
			} else {
				logger.error("Logout button not available");
				grep.failTest("Logout button not available");
			}
		} catch (Exception e) {

		}
	}

	// Validating the header for each page

}
