package base_utility;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public ExtentReports report;

	@BeforeSuite
	public void repConfig() {
//		report configuration
//		. means project level
		
		long time = System.currentTimeMillis();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_reports/"+time+".html");
		spark.config().setDocumentTitle("sauce demo login");
		spark.config().setReportName("login report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("ATE", "Manisha");
		report.setSystemInfo("Browser", "edge");
		report.setSystemInfo("Window", "11");

	}

	@BeforeClass
	public void setUp() throws IOException, ParseException {
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");

//		open browser
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

	}

	@BeforeMethod
	public void login() throws IOException, ParseException {
//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		navigate to url & login
		driver.get(url);

//		========== POM: LoginPage ==========
		LoginPage lp = new LoginPage(driver);
//		lp.getUsername().sendKeys(username);
//		lp.getPassword().sendKeys(password);
//		lp.getLoginButton().click();
		lp.login(username, password);
	}

	@AfterMethod
	public void logout() {
//		logout
		HomePage hp = new HomePage(driver);
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(hp.getProfileIcon());
		hp.getSignOutLink().click();
	}

	@AfterClass
	public void tearDown() {
//		close the browser
		driver.quit();
		System.out.println("Create Organization Test Completed.");
	}

	
	@AfterSuite
	public void repBackup() {
//		report backup
		report.flush();
	}

}
