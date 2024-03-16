package com.MyProjectStore.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class ExtentListenerClass implements ITestListener {

	// Create object of Listener class
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig read = new ReadConfig();
		String timeSlip = new SimpleDateFormat("yyyy.mm.dd hh.ss").format(new Date());
		String report = "MyProjectStore" + timeSlip + ".html";
		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//ExtendReport//" +report);
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		// Add system information info to reports
		reports.setSystemInfo("Machine", "lenove");
		reports.setSystemInfo("OS", "Window 10 Pro");
		reports.setSystemInfo("browser", read.getBrowser());
		reports.setSystemInfo("UserName", "adminPc");
		
		// Configuration to change look and feel of report
		htmlreporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlreporter.config().setReportName("This is my Report");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	// OnStart method is called when any test starts.
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On Start method invoked............");
	}
	
	// OnFinish method is called after all tests are executed
	public void onFinish(ITestContext Result)
	{
		System.out.println("On Finished method invoked.........");
		reports.flush();
	}
	
	// When test case get failed, this method is called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:" + Result.getName(), ExtentColor.RED));
		String Screenshotpath = System.getProperty("user.dir") + "\\Screenshot\\" + Result.getName() +".png";
		File ScreenshotFile = new File(Screenshotpath);
		if(ScreenshotFile.exists())
		{
			test.fail("Captured Screenshot is below :" + test.addScreenCaptureFromPath(Screenshotpath));
		}
	}
	
	// When test case get skipped, this method is called.
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("name of test method skipped" + Result.getName());
		
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is:" + Result.getName(), ExtentColor.YELLOW));
	}
	
	// When test case get started, this method is called.
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method started:" + Result.getName());
	}
	
	// When test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("name of test method suceddfully executed:" + Result.getName());
		
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is:" + Result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		
	}
	
}
