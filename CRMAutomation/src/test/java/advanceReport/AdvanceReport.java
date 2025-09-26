package advanceReport;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdvanceReport {
	ExtentReports report;
	@BeforeSuite //this is kept in base class in real time execution
	
	public void configBS() {//spark report config
		
		 
			ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReport.html");
			spark.config().setDocumentTitle("CRM Test Suite Result");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add env information and create test
			 report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("os", "windows10");
			report.setSystemInfo("BROWSER","CHROME-100");
		
	}
	@AfterSuite
	public void configAS() {
		report.flush();//logs will n reports will not be saved
		
	}
	@Test
	public void  createContactTest() {
	
	
		ExtentTest test =report.createTest("createContactTest");
		
		
		
		test.log(Status.INFO,"login to aap");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "login to app");
			}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		
		
		report.flush();//logs will n reports will not be saved 
		}
	@Test
	
	public void  createContactTestwithORG() {
		
		
		ExtentTest test =report.createTest("createContactTestwithORG");
		
		
		
		test.log(Status.INFO,"login to aap");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "login to app");
			}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		
		
		//report.flush();//logs will n reports will not be saved but it is not required in every test case
		}
@Test
	
	public void  createContactTestwithPhoneNumber() {
		
		
		ExtentTest test =report.createTest("createContactTestwithPhoneNumber");
		
		
		
		test.log(Status.INFO,"login to aap");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "login to app");
			}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		
		
		//report.flush();//logs will n reports will not be saved 
		}


}
