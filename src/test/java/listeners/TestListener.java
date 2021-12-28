package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

import tests.BaseTest;
//import static utils.extentreports.ExtentTestManager.getTest;


public class TestListener extends BaseTest implements ITestListener {

	ExtentReports extentReports =ExtentManager.createExtentReports();
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
public void onTestStart(ITestResult result) {
		test=extentReports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Case is Passed");
	}

	public void onTestFailure(ITestResult result) {
		String base64Screenshot=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
		extentTest.get().log(Status.FAIL,result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP,"Test Case is Skipped");
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		ExtentManager.extentReports.flush();
	}

	
	 
}


