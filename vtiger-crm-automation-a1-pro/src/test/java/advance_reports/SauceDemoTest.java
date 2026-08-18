package advance_reports;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SauceDemoTest {
	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
//		report configuration
//		. means project level
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_reports/rep1.html");
		spark.config().setDocumentTitle("sauce demo login");
		spark.config().setReportName("login report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("ATE", "Manisha");
		report.setSystemInfo("Browser", "edge");
		report.setSystemInfo("Window", "11");
	}

	@Test
	public void login() throws InterruptedException {
		ExtentTest test = report.createTest("login");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.quit();

		test.log(Status.PASS, "this is passed...");
		test.log(Status.INFO, "this is info...");
	}

	@Test
	public void logout() throws InterruptedException {
		ExtentTest test = report.createTest("logout");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.quit();

		boolean status = true;

		Assert.assertTrue(status);

		test.log(Status.FAIL, "this is failed...");
		test.log(Status.INFO, "this is info...");
	}

	@AfterSuite
	public void repBackup() {
//		report backup
		report.flush();
	}

}
