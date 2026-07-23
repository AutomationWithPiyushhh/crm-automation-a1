package crm.opportunity;

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
import object_repository.LoginPage;
import object_repository.OpportunityPage;

/**
 * Test Script: Create Opportunity Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Opportunities module
 *   3. Click Create Opportunity
 *   4. Fill in the opportunity form (name, closing date, amount, sales stage)
 *   5. Select related organization via popup window
 *   6. Save and verify
 *   7. Logout
 */
public class CreateOpportunityPOMTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		get the data from Excel file
		String oppName = fUtil.getDataFromExcelFile("opp", 2, 0) + JavaUtility.generateRandomNumber();

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
		hp.getOpportunitiesLink().click();

//		========== POM: OpportunityPage ==========
		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOpportunityButton().click();

//		fill the Create Opportunity form
		op.getOpportunityName().sendKeys(oppName);
		op.getAmount().sendKeys("75000");
		op.getClosingDate().sendKeys("12/31/2026");

//		select sales stage
		Select stageSelect = new Select(op.getSalesStage());
		stageSelect.selectByVisibleText("Prospecting");

//		select opportunity type
		Select typeSelect = new Select(op.getOpportunityType());
		typeSelect.selectByVisibleText("Existing Business");

//		select lead source
		Select lsSelect = new Select(op.getLeadSource());
		lsSelect.selectByVisibleText("Web Site");

//		select related organization via popup
//		step 1: store the parent window handle
		String parentWindowHandle = driver.getWindowHandle();

//		step 2: click the Related To picker icon
		op.getRelatedToPickerIcon().click();

//		step 3: switch to popup window
		wdUtil.switchToWindowByUrl("Accounts");

//		step 4: select an organization (click any partial link to vtiger)
		driver.findElement(org.openqa.selenium.By.partialLinkText("vtiger")).click();

//		step 5: switch back to parent window
		driver.switchTo().window(parentWindowHandle);

//		save the record
		op.getSaveButton().click();

//		verification
		String actOppName = op.getDetailViewOpportunityName().getText();
		if (actOppName.equals(oppName)) {
			System.out.println("Opportunity created successfully! Name: " + actOppName);
		} else {
			System.out.println("Opportunity creation failed! Expected: " + oppName + " | Actual: " + actOppName);
		}

//		logout
		HomePage hp2 = new HomePage(driver);
		wdUtil.hover(hp2.getProfileIcon());
		hp2.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Opportunity Test Completed.");
	}
}
