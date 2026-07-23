package crm.vendor;

import java.io.IOException;

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
import object_repository.VendorPage;

/**
 * Test Script: Create Vendor Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Vendors module
 *   3. Click Create Vendor
 *   4. Fill in the vendor form (name, phone, email, website, address)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateVendorTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		generate a unique vendor name
		String vendorName = "AutoVendor" + JavaUtility.generateRandomNumber();

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

//		Navigate to Vendors module via URL (may be under More menu)
		driver.get(url + "index.php?module=Vendors&action=index");

//		========== POM: VendorPage ==========
		VendorPage vp = new VendorPage(driver);
		vp.getCreateVendorButton().click();

//		fill the Create Vendor form
		vp.getVendorName().sendKeys(vendorName);
		vp.getPhone().sendKeys("040-88776655");
		vp.getEmail().sendKeys("autovendor@vendortest.com");
		vp.getWebsite().sendKeys("www.autovendor.com");
		vp.getFax().sendKeys("040-88776600");
		vp.getGlAccount().sendKeys("GL-001");

//		fill address
		vp.getStreet().sendKeys("456 Vendor Street");
		vp.getCity().sendKeys("Hyderabad");
		vp.getState().sendKeys("Telangana");
		vp.getPostalCode().sendKeys("500001");
		vp.getCountry().sendKeys("India");

//		add description
		vp.getDescription().sendKeys("Automated test vendor created by Selenium POM script.");

//		save the record
		vp.getSaveButton().click();

//		verification
		String actVendorName = vp.getDetailViewVendorName().getText();
		if (actVendorName.equals(vendorName)) {
			System.out.println("Vendor created successfully! Name: " + actVendorName);
		} else {
			System.out.println("Vendor creation failed! Expected: " + vendorName + " | Actual: " + actVendorName);
		}

//		logout
		HomePage hp = new HomePage(driver);
		wdUtil.hover(hp.getProfileIcon());
		hp.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Vendor Test Completed.");
	}
}
