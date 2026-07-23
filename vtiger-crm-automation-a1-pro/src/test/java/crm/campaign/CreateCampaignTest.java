package crm.campaign;

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
import object_repository.CampaignPage;
import object_repository.HomePage;
import object_repository.LoginPage;

/**
 * Test Script: Create Campaign Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Campaigns module
 *   3. Click Create Campaign
 *   4. Fill in the campaign form (name, type, status, budget, dates)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateCampaignTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		generate a unique campaign name
		String campaignName = "AutoCampaign" + JavaUtility.generateRandomNumber();

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

//		Navigate to Campaigns module via URL (may be under More menu)
		driver.get(url + "index.php?module=Campaigns&action=index");

//		========== POM: CampaignPage ==========
		CampaignPage cp = new CampaignPage(driver);
		cp.getCreateCampaignButton().click();

//		fill the Create Campaign form
		cp.getCampaignName().sendKeys(campaignName);

//		select campaign type
		Select typeSelect = new Select(cp.getCampaignType());
		typeSelect.selectByVisibleText("Email");

//		select campaign status
		Select statusSelect = new Select(cp.getCampaignStatus());
		statusSelect.selectByVisibleText("Active");

//		set start and end dates
		cp.getStartDate().sendKeys("07/01/2026");
		cp.getEndDate().sendKeys("12/31/2026");
		cp.getClosingDate().sendKeys("12/31/2026");

//		fill budget and cost fields
		cp.getBudget().sendKeys("10000");
		cp.getExpectedCost().sendKeys("8000");
		cp.getActualCost().sendKeys("7500");
		cp.getExpectedRevenue().sendKeys("50000");
		cp.getActualRevenue().sendKeys("0");
		cp.getExpectedResponseCount().sendKeys("200");

//		add description
		cp.getDescription().sendKeys("Automated test campaign created by Selenium POM script. "
				+ "This is an email marketing campaign for testing.");

//		save the record
		cp.getSaveButton().click();

//		verification
		String actCampaignName = cp.getDetailViewCampaignName().getText();
		if (actCampaignName.equals(campaignName)) {
			System.out.println("Campaign created successfully! Name: " + actCampaignName);
		} else {
			System.out.println("Campaign creation failed! Expected: " + campaignName + " | Actual: " + actCampaignName);
		}

//		logout
		HomePage hp = new HomePage(driver);
		wdUtil.hover(hp.getProfileIcon());
		hp.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Campaign Test Completed.");
	}
}
