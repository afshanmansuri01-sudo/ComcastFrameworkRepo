package automationPractice.framework;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeSuite;

import automationPractice.framework.GenericUtilities.ExcelUtility;
import automationPractice.framework.GenericUtilities.FileUtility;
import automationPractice.framework.GenericUtilities.javaUtility;

public class BaseClass {
	public WebDriver driver = null;
	public FileUtility flib =new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	//public  WebDriverutility wdlib = new WebDriverUtility();
	public javaUtility jlib = new javaUtility();
	//public databaseutility dblib = new databaseutility();
	//public 
	
	@BeforeSuite
	public void configBS() {
		System.out.println("====connect to DataBase=====");
		//dlib.getDBconnection();
		}
	
	
	@BeforeClass
	public void configBC(String Browser) throws IOException {
		System.out.println("Browser is launch ");
		String BROWSER = flib.getDataFromProprtiesFile(Browser);
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			}
		else if(BROWSER.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Safari"))
				{driver=new SafariDriver();
				}}
		//
		//wdlib.maximis().Window(driver);
		//wdlib.waitToLoadPage(driver);
		
		
		@SuppressWarnings("unused")
		@BeforeMethod
		public void configBM() throws IOException {
			System.out.println("===login to the app===");
			String URL = flib.getDataFromProprtiesFile("url");
			String USERNAME = flib.getDataFromProprtiesFile("username");
			String PASSWORD = flib.getDataFromProprtiesFile("password");
			driver.get(URL);;
			//LoginPage lp =new LoginPage(driver);
			//lp.LoginToPage(USERNAME,PASSWORD);
			
		}
		
		@AfterMethod
		public void configAM() {
			System.out.println("===logout ===");
			//HomePage hp = new HomePage();
			//hp.getSignOutFromApp();
			
			
		}
		
		@AfterClass
		public void ConfigAC() {
			System.out.println("Close the browser");
			driver.quit();
		}
		
		@AfterSuite
		public void configAS()
		
		{
			System.out.println("====disconnected from DataBase");
			//dblib.closeConnection();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	



