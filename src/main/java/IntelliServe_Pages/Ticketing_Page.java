package IntelliServe_Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.DriverManager;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.WaitsManager;

public class Ticketing_Page extends WaitsManager {
	static WebDriver driver;
	private static Logger logger = LogManager.getLogger(Ticketing_Page.class);
	GenerateReports grep = new GenerateReports();

	public Ticketing_Page() {
		this.driver = DriverManager.getDriver();
	}

	By sideToggle = By.xpath("//button[@aria-label='Toggle Sidebar']");

	By profileLogo = By.xpath("//button[@class='flex items-center text-gray-700 dropdown-toggle dark:text-gray-400']");
	By profileBlockName = By.xpath("//span[@class='block font-medium text-gray-700 text-theme-sm dark:text-gray-400']");
	By profileBlockEmail = By.xpath("//span[@class='mt-0.5 block text-theme-xs text-gray-500 dark:text-gray-400']");

	By myProfile = By.xpath("//button[text()='My Profile']");
	By signOutbtn = By.xpath("//button[text()='Sign out']");

	// profile page
	By profileHeader = By.xpath("//h3[@class='mb-5 text-lg font-semibold text-gray-800 dark:text-white/90 lg:mb-7']");
	By personalInfo = By.xpath("//h4[text()='Personal Information']/following-sibling::div/div");
	By profileName = By.xpath("//div[@class='order-3 xl:order-2']/h4");
	By userRoles = By.xpath("//div[@class='flex flex-wrap gap-2 justify-center xl:justify-start']/span");
	By deptName = By
			.xpath("//div[@class='flex flex-col items-center gap-1 text-center xl:flex-row xl:gap-3 xl:text-left']/p");
	By reserveRights = By.xpath("//div[@class='text-gray-600 dark:text-gray-400 text-sm whitespace-nowrap']");
	By version = By.xpath("//div[@class='text-gray-600 dark:text-gray-400 text-sm mt-2 sm:mt-0 whitespace-nowrap']");

	By selectRole = By.xpath("//span[text()='Role']/following-sibling::select");

	// Click sidebar
	public void verifySidebarFunctionality() throws Exception {

		try {
			implWait(driver);

			By sidebarProfile = By
					.xpath("//div[@class='p-4 border-t border-gray-200 dark:border-gray-800 flex justify-center']");

			logger.info("Verifying Side Bar Collapse Functionality");
			grep.infoTest("Verifying Side Bar Collapse Functionality");

			driver.findElement(sideToggle).click();
			String sidebartext = driver.findElement(sidebarProfile).getText();
			System.out.println(sidebartext);
			if (sidebartext.equalsIgnoreCase("PK")) {
				logger.info("Side Bar collapsed");
				grep.passTest("Side Bar collapsed");
			} else {
				logger.error("Side Toggle not available");
				grep.failTest("Side Toggle not available");
			}
			grep.captureScreenshot("pass", "Side toggle Collpased", "SideToggle_Collapsed");

			waitTime(driver);
			logger.info("Verifying Side Bar Expand Functionality");
			grep.infoTest("Verifying Side Bar Expand Functionality");
			driver.findElement(sideToggle).click();
			String sidebartext2 = driver.findElement(sidebarProfile).getText();
			System.out.println(sidebartext2);
			if (sidebartext2.equalsIgnoreCase("Phani Kumar Maddi")) {
				logger.info("Side Bar expanded");
				grep.passTest("Side Bar expanded");
			} else {
				logger.error("Side Toggle not available");
				grep.failTest("Side Toggle not available");
			}
			grep.captureScreenshot("pass", "Side toggle Expanded", "SideToggle_Expanded");

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());
		}
	}
	// Click Profile

	public void clickProfilePage(String pname, String pemail) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(profileLogo).isEmpty();
			if (elementExists) {
				driver.findElement(profileLogo).click();
				waitTime(driver);
				String name = driver.findElement(profileBlockName).getText();
				String email = driver.findElement(profileBlockEmail).getText();
				waitTime(driver);
				if (name.equalsIgnoreCase(pname) && email.equalsIgnoreCase(pemail)) {
					grep.passTest("Profile Name :" + name);
					logger.info("Profile Name :" + name);
					grep.passTest("Profile Email :" + email);
					logger.info("Profile Email :" + email);
				} else {
					grep.failTest("Profile name or email doesn't match");
					logger.error("Profile name or email doesn't match");
				}
				waitTime(driver);
				grep.captureScreenshot("pass", "Profile Block", "ticketing_profileLogo");
				waitTime2(driver);
				driver.findElement(myProfile).click();
				waitTime(driver);
				grep.infoTest("Navigated to Profile Page");
				logger.info("Navigated to Profile Page");

			} else {
				grep.failTest("Profile Button Not Available");
				logger.error("Profile Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getProfilePageInfo() throws Exception {
		try {
			implWait(driver);
			boolean elementExists = !driver.findElements(profileHeader).isEmpty();
			if (elementExists) {
				String header = driver.findElement(profileHeader).getText();
				if (header.equals("Profile")) {
					grep.passTest("Header valid :" + header);
					logger.info("Header valid :" + header);
				} else {
					grep.failTest("Header not valid :" + header);
					logger.error("Header not valid :" + header);
				}

				waitTime(driver);
				String prof_name = driver.findElement(profileName).getText();
				grep.infoTest("Profile Name: " + prof_name);
				logger.info("Profile Name: " + prof_name);

				waitTime(driver);
				String dept = driver.findElement(deptName).getText();
				grep.infoTest("Department Name: " + dept);
				logger.info("Department Name: " + dept);

				waitTime(driver);
				List<WebElement> roles_inProfilePage = driver.findElements(userRoles);
				List<String> userRolesList = new ArrayList<>();
				if (roles_inProfilePage.size() > 0) {

//					for (WebElement profileRoles : roles_inProfilePage) {

//					String rolesData = profileRoles.getText();
//					grep.infoTest("User Roles: " + rolesData);
//					logger.info("User Roles: " + rolesData);

					for (int i = 0; i < roles_inProfilePage.size(); i++) {

						// loading text of each element in to array all_elements_text
						userRolesList.add(roles_inProfilePage.get(i).getText());

						// to print directly
						System.out.println(roles_inProfilePage.get(i).getText());

						grep.infoTest("User Roles: " + roles_inProfilePage.get(i).getText());
						logger.info("User Roles: " + roles_inProfilePage.get(i).getText());
					}
				}
				waitTime(driver);

				List<WebElement> info = driver.findElements(personalInfo);
				if (info.size() > 0) {
					for (WebElement profileData : info) {
						String data = profileData.getText();

						grep.infoTest("Profile Page Personal Information: " + data);
						logger.info("Profile Page Personal Information: " + data);
						System.out.println();
					}
				} else {
					grep.failTest("Profile Page Information Not available");
					logger.error("Profile Page Information Not available");
				}
			} else {
				grep.failTest("Profile Page Not available");
				logger.error("Profile Page  Not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void getFooterInfo() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(reserveRights).isEmpty();
			if (elementExists) {
				String rights = driver.findElement(reserveRights).getText();
				grep.infoTest("Rights :" + rights);
				logger.info("Rights :" + rights);
				waitTime(driver);
				String getVersion = driver.findElement(version).getText();
				grep.infoTest("Version :" + getVersion);
				logger.info("Version :" + getVersion);

			} else {
				grep.failTest("SignOut Button Not Available");
				logger.error("SignOut Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void clickSignOutBtn() throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(profileLogo).isEmpty();
			if (elementExists) {
				driver.findElement(profileLogo).click();
				waitTime(driver);
				driver.findElement(signOutbtn).click();
				grep.passTest("SignOut From IntelliServe Page");
				logger.info("SignOut From IntelliServe Page");

			} else {
				grep.failTest("SignOut Button Not Available");
				logger.error("SignOut Button Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public void selectUserRole(String roleValue) throws Exception {
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(profileLogo).isEmpty();
			if (elementExists) {
				driver.findElement(profileLogo).click();
				waitTime(driver);
				WebElement role = driver.findElement(selectRole);
				Select select = new Select(role);
				select.selectByVisibleText(roleValue);
			} else {
				grep.failTest("Selected role not Available for user");
				logger.error("Selected role not Available for user");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

	public boolean verifyUserRole(String roleValue) throws Exception {

		boolean optionFound = false;
		try {
			implWait(driver);

			boolean elementExists = !driver.findElements(profileLogo).isEmpty();
			if (elementExists) {
				driver.findElement(profileLogo).click();
				waitTime(driver);
				WebElement role = driver.findElement(selectRole);
				Select select = new Select(role);

				List<WebElement> allOptions = select.getOptions();
				List<String> selectValuesList = new ArrayList<>();

				for (WebElement option : allOptions) {
					selectValuesList.add(option.getText()); // Or option.getAttribute("value") for the 'value' attribute
				}
				String[] selectValuesArray = selectValuesList.toArray(new String[0]);
				for (String value : selectValuesArray) {
					if (value.equals(roleValue)) {
						optionFound = true;
						grep.infoTest(roleValue + " role Available");
						logger.info(roleValue + " role Available");
						break;
					}
				}

				driver.findElement(profileLogo).click();

			} else {
				grep.failTest("Selected role not Available");
				logger.error("Selected role not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
		return optionFound;
	}

	// Navigate to Pages For Top
	public void navigateToPage(String pageName) throws Exception {
		try {
			implWait(driver);
			By pageNav = By.xpath("//ul[@class='flex flex-col gap-4']/li/a[@href='" + pageName + "']");

			List<WebElement> element = driver.findElements(pageNav);
			if (element.size() > 0) {
				element.getFirst().click();

				grep.passTest("Navigated to " + pageName);
				logger.info("Navigated to " + pageName);
			} else {
				grep.warnTest(pageName + " Not Available");
				logger.error(pageName + " Not Available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			grep.failTest("Test Failed :" + e.getMessage());
			logger.error("Test Failed :" + e.getMessage());

		}
	}

}