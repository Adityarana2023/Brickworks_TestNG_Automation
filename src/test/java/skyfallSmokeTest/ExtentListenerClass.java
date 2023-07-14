package skyfallSmokeTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void startReport() {
		htmlReporter = new ExtentSparkReporter("ExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details

		reports.setSystemInfo("Machine", "Aditya-PC");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("QA Team", "Aditya Rana");
		reports.setSystemInfo("Browser", "Chrome V.113");

		// configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Regression Test Suit Report");
		htmlReporter.config().setReportName("Brickworks Site Manager Test Summary Reports");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");


	}
	
	
	public void onStart(ITestContext Result)
	{
		startReport();
		System.out.println("On Start method invoked....");
	}
	public void onFinish(ITestContext Result)
	{
		System.out.println("On Finish method invoked....");
		reports.flush();
	}
	// When Test case get failed, this method is called.
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:" + Result.getName(), ExtentColor.RED));
		test.fail(Result.getThrowable());
	}
	//When Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method skipped:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is:" + Result.getName(), ExtentColor.YELLOW));
	}
	
	// When Test case get Started, this method is called.
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method started:" + Result.getName());
	}
	//When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method successfully executed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is:" + Result.getName(), ExtentColor.GREEN));
	
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
	}
}
