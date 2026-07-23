package crm.cases;

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
import object_repository.CasePage;
import object_repository.HomePage;
import object_repository.LoginPage;

/**
 * Test Script: Create Case (Trouble Ticket) Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Cases (Trouble Tickets / HelpDesk) module
 *   3. Click Create Ticket
 *   4. Fill in the case form (title, status, priority, severity, description)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateCaseTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		generate a unique ticket title
		String ticketTitle = "AutoTicket" + JavaUtility.generateRandomNumber();

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

//		Navigate to HelpDesk/Cases module directly via URL
//		(since 'Cases' might be under 'More' menu)
		driver.get(url + "index.php?module=HelpDesk&action=index");

//		========== POM: CasePage ==========
		CasePage cp = new CasePage(driver);
		cp.getCreateCaseButton().click();

//		fill the Create Ticket form
		cp.getTicketTitle().sendKeys(ticketTitle);

//		select ticket status
		Select statusSelect = new Select(cp.getTicketStatus());
		statusSelect.selectByVisibleText("Open");

//		select ticket priority
		Select prioritySelect = new Select(cp.getTicketPriority());
		prioritySelect.selectByVisibleText("High");

//		select ticket severity
		Select severitySelect = new Select(cp.getTicketSeverity());
		severitySelect.selectByVisibleText("Major");

//		add description
		cp.getDescription().sendKeys("This is an automated test ticket created by Selenium POM script. "
				+ "Testing the create ticket functionality of VTiger CRM.");

//		add solution
		cp.getSolution().sendKeys("Automated resolution - ticket was created for testing purposes.");

//		save the record
		cp.getSaveButton().click();

//		verification
		String actTitle = cp.getDetailViewTitle().getText();
		if (actTitle.equals(ticketTitle)) {
			System.out.println("Case/Ticket created successfully! Title: " + actTitle);
		} else {
			System.out.println("Case/Ticket creation failed! Expected: " + ticketTitle + " | Actual: " + actTitle);
		}

//		logout
		HomePage hp = new HomePage(driver);
		wdUtil.hover(hp.getProfileIcon());
		hp.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Case Test Completed.");
	}
}
