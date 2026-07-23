package crm.activity;

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
import object_repository.ActivityPage;
import object_repository.HomePage;
import object_repository.LoginPage;

/**
 * Test Script: Create Activity (Event/Meeting) Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Activities (Calendar) module
 *   3. Click Add Event
 *   4. Fill in the event form (subject, type, status, start/end date, location)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateActivityTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		generate a unique activity subject
		String activitySubject = "AutoMeeting" + JavaUtility.generateRandomNumber();

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

//		navigate to Calendar / Add Event via URL
		driver.get(url + "index.php?module=Calendar&action=EditView&activity_mode=Events");

//		========== POM: ActivityPage ==========
		ActivityPage ap = new ActivityPage(driver);

//		fill the Create Event form
		ap.getSubject().sendKeys(activitySubject);

//		select activity type
		Select typeSelect = new Select(ap.getActivityType());
		typeSelect.selectByVisibleText("Meeting");

//		select event status
		Select statusSelect = new Select(ap.getEventStatus());
		statusSelect.selectByVisibleText("Planned");

//		set start date and time
		ap.getStartDate().clear();
		ap.getStartDate().sendKeys("07/25/2026");

//		set end date
		ap.getEndDate().clear();
		ap.getEndDate().sendKeys("07/25/2026");

//		set location
		ap.getLocation().sendKeys("Conference Room A");

//		add description
		ap.getDescription().sendKeys("Automated test meeting created by Selenium POM script.");

//		save the record
		ap.getSaveButton().click();

//		verification - check subject in detail view
		String actSubject = ap.getDetailViewSubject().getText();
		if (actSubject.equals(activitySubject)) {
			System.out.println("Activity/Event created successfully! Subject: " + actSubject);
		} else {
			System.out.println("Activity creation failed! Expected: " + activitySubject + " | Actual: " + actSubject);
		}

//		logout
		HomePage hp = new HomePage(driver);
		wdUtil.hover(hp.getProfileIcon());
		hp.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Activity Test Completed.");
	}
}
