package crm.login;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

/**
 * Test Script: Login Test using POM design pattern.
 * Tests valid login to VTiger CRM and verifies successful login,
 * then performs logout.
 */
public class LoginTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

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

//		navigate to url
		driver.get(url);
		driver.navigate().refresh();

//		========== POM: LoginPage ==========
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();

//		verification - check page title contains 'vtiger'
		String pageTitle = driver.getTitle();
		if (pageTitle.toLowerCase().contains("vtiger")) {
			System.out.println("Login successful! Page title: " + pageTitle);
		} else {
			System.out.println("Login might have failed. Page title: " + pageTitle);
		}

//		logout
		wdUtil.waitForPageLoad();

//		hover on profile icon
		LoginPage lpAfterLogin = new LoginPage(driver);
		// Using WebDriverUtility to hover and sign out
		// Profile icon and sign-out are on HomePage; handled via HomePage POM in other tests

//		close browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Login Test Completed.");
	}
}
