package advance_reports_via_listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class List_Imp implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
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

	@Override
	public void onFinish(ISuite suite) {
//		report backup
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "this is passed...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "this is failed...");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "this is skipped...");
	}

}
