package crm.contact;

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
import object_repository.ContactPage;
import object_repository.HomePage;
import object_repository.LoginPage;

/**
 * Test Script: Create Contact Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Contacts module
 *   3. Click Create Contact
 *   4. Fill in the contact form (first/last name, phone, mobile, email, title)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		generate unique last name using random number
		String lastName = "TestContact" + JavaUtility.generateRandomNumber();
		String firstName = "Auto";

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
		hp.getContactsLink().click();

//		========== POM: ContactPage ==========
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactButton().click();

//		fill the Create Contact form
//		select salutation from dropdown
		Select salSelect = new Select(cp.getSalutation());
		salSelect.selectByVisibleText("Mr.");

		cp.getFirstName().sendKeys(firstName);
		cp.getLastName().sendKeys(lastName);
		cp.getOfficePhone().sendKeys("080-12345678");
		cp.getMobile().sendKeys("9988776655");
		cp.getEmail().sendKeys("autocontact@test.com");
		cp.getTitle().sendKeys("QA Engineer");
		cp.getDepartment().sendKeys("Quality Assurance");

//		select lead source
		Select lsSelect = new Select(cp.getLeadSource());
		lsSelect.selectByVisibleText("Web Site");

//		save the record
		cp.getSaveButton().click();

//		verification
		String actLastName = cp.getDetailViewLastName().getText();
		if (actLastName.contains(lastName)) {
			System.out.println("Contact created successfully! Last Name: " + actLastName);
		} else {
			System.out.println("Contact creation failed! Expected: " + lastName + " | Actual: " + actLastName);
		}

//		logout
		HomePage hp2 = new HomePage(driver);
		wdUtil.hover(hp2.getProfileIcon());
		hp2.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Contact Test Completed.");
	}
}
