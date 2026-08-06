package listeners_utility;

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
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("It will execute before the @BeforeSuite");

		long time = System.currentTimeMillis();

		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_reports/" + time + ".html");
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
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName + " is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName + " is skipped");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("It will execute after the @AfterSuite");
//		report backup
		report.flush();

	}
}
















