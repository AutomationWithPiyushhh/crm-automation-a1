package crm.lead;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LeadPage;
import object_repository.LoginPage;

/**
 * Test Script: Create Lead Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Leads module
 *   3. Click Create Lead
 *   4. Fill in the lead form (name, company, phone, email, lead source, status)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateLeadTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		generate unique last name using random number
		String lastName = "LeadTest" + JavaUtility.generateRandomNumber();
		String companyName = "TestCompany" + JavaUtility.generateRandomNumber();

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
		hp.getLeadsLink().click();

//		========== POM: LeadPage ==========
		LeadPage leadPage = new LeadPage(driver);
		leadPage.getCreateLeadButton().click();

//		fill the Create Lead form
//		select salutation
		Select salSelect = new Select(leadPage.getSalutation());
		salSelect.selectByVisibleText("Mr.");

		leadPage.getFirstName().sendKeys("AutoLead");
		leadPage.getLastName().sendKeys(lastName);
		leadPage.getCompany().sendKeys(companyName);
		leadPage.getPhone().sendKeys("044-98765432");
		leadPage.getMobile().sendKeys("7890123456");
		leadPage.getEmail().sendKeys("autolead@testcompany.com");
		leadPage.getTitle().sendKeys("Manager");
		leadPage.getWebsite().sendKeys("www.testcompany.com");
		leadPage.getAnnualRevenue().sendKeys("500000");
		leadPage.getNoOfEmployees().sendKeys("50");

//		select lead source
		Select lsSelect = new Select(leadPage.getLeadSource());
		lsSelect.selectByVisibleText("Web Site");

//		select lead status
		Select statusSelect = new Select(leadPage.getLeadStatus());
		statusSelect.selectByVisibleText("New");

//		select industry
		Select indSelect = new Select(leadPage.getIndustry());
		indSelect.selectByVisibleText("Technology");

//		fill address
		leadPage.getStreet().sendKeys("123 Test Street");
		leadPage.getCity().sendKeys("Bangalore");
		leadPage.getState().sendKeys("Karnataka");
		leadPage.getZipCode().sendKeys("560001");
		leadPage.getCountry().sendKeys("India");

//		save the record
		leadPage.getSaveButton().click();

//		verification
		String actLastName = leadPage.getDetailViewLastName().getText();
		if (actLastName.contains(lastName)) {
			System.out.println("Lead created successfully! Last Name: " + actLastName);
		} else {
			System.out.println("Lead creation failed! Expected: " + lastName + " | Actual: " + actLastName);
		}

//		logout
		HomePage hp2 = new HomePage(driver);
		wdUtil.hover(hp2.getProfileIcon());
		hp2.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Lead Test Completed.");
	}
}
