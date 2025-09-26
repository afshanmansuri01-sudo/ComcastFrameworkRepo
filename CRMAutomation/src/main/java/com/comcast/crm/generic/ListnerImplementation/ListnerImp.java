 package com.comcast.crm.generic.ListnerImplementation;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;             //=====****this is for  practice only to understand*****======//
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImp implements ITestListener,ISuiteListener  {
ExtentReports report;
ExtentTest test;
WebDriver driver= null;
	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/vtigerRep.html");
		spark.config().setDocumentTitle("Vtiger");
		spark.config().setReportName("VTiger Report");
		spark.config().setTheme(Theme.DARK);
		
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows10");
		report.setSystemInfo("browser", "Chrome");
		
		
		
		
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
	String TestName = result.getMethod().getMethodName();
	test = report.createTest(TestName);
		test.log(Status.INFO,"Test Case Get Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO,"TestCase Got Pass");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "TestCase Got Fail");
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath,result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
