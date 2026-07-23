package crm.organization;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrganizationPage;

/**
 * Test Script: Create Organization Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Organizations module
 *   3. Click Create Organization
 *   4. Fill in the organization form (name, phone, email, website)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateOrganizationPOMTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		get the data from Excel file
		String orgName = fUtil.getDataFromExcelFile("org", 2, 0) + JavaUtility.generateRandomNumber();

//		open browser
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.maximizeWindow();
		wdUtil.waitForPageLoad();

//		navigate to url & login
		driver.get(url);
		driver.navigate().refresh();

//		========== POM: LoginPage ==========
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();

//		========== POM: HomePage ==========
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

//		========== POM: OrganizationPage ==========
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationButton().click();

//		fill the Create Organization form
		op.getOrganizationName().sendKeys(orgName);
		op.getPhone().sendKeys("9876543210");
		op.getEmail().sendKeys("testorg@vtiger.com");
		op.getWebsite().sendKeys("www.testorg.com");

//		save the record
		op.getSaveButton().click();

//		verification
		String actOrgName = op.getDetailViewOrganizationName().getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully! Name: " + actOrgName);
		} else {
			System.out.println("Organization creation failed! Expected: " + orgName + " | Actual: " + actOrgName);
		}

//		logout
		wdUtil.hover(hp.getProfileIcon());
		hp.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Organization Test Completed.");
	}
}
