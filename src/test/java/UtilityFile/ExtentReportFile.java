package UtilityFile;

import java.io.IOException;

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

import TestCaseFile.TestCaseFile;	
	public class ExtentReportFile extends TestCaseFile implements ITestListener {
		ExtentSparkReporter createreport;
		ExtentReports createtest1;
		ExtentTest createlog;
		void setup()
		{
		createreport=new ExtentSparkReporter("MyExtentReport123.html");
		createtest1=new ExtentReports();
		createtest1.attachReporter(createreport);
		createtest1.setSystemInfo("Os", "Windown");
		createtest1.setSystemInfo("Browser", "Chrome");
		createtest1.setSystemInfo("User", "Nitesh");
		createtest1.setSystemInfo("Environment", "Testing");
		createreport.config().setDocumentTitle("MynewReport");
		createreport.config().setReportName("Testng_Report_Today");
		createreport.config().setTheme(Theme.DARK);
		}
		public void onStart(ITestContext Result)
		{
		setup();
		System.out.println("onStart");
		}
		public void onFinish(ITestContext Result)
		{ createtest1.flush();
		System.out.println("onFinish call");
		}
		public void onTestStart(ITestResult Result)
		{
		System.out.println("OntestStart");
		}
		public void onTestSuccess(ITestResult Result)
		{
		createlog=createtest1.createTest(Result.getName());
		createlog.log(Status.PASS,MarkupHelper.createLabel("Test Case pass",ExtentColor.GREEN));
		}
		public void onTestFailure(ITestResult Result) {
			try {
				Screenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//String path="C:\\Users\\admin\\eclipse-workspace\\TestNGProject002\\ScreenShot\\hello.png";
			createlog=createtest1.createTest(Result.getName());
		createlog.log(Status.FAIL,MarkupHelper.createLabel("Test Case Failed",ExtentColor.RED));
		//createlog.fail("myScreenshot"+ createlog.addScreenCaptureFromPath(path));
		
		}
		public void onTestSkipped(ITestResult Result)
		{
		createlog=createtest1.createTest(Result.getName());
		createlog.log(Status.SKIP,MarkupHelper.createLabel("Test Case Skipped",ExtentColor.YELLOW));
		}

	}

	
	


