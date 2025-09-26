package com.comcast.crm.Baseclass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClassTest {
	
	
	 public DataBaseUtility dlib = new DataBaseUtility();
	
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver = null;
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("++++=====connect to DB,Report Config=====+++++");
		dlib.getDbconnection();
	}
	
	
	
	//takr data from properies file in order to launch browser
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("Launch the browser");
		String BROWSER = flib.getDataFrompropertiesFile("Vbrowser");
		
		
		if ( BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();}
		}
	
	
	
	
	
	@BeforeMethod
	public void configBM() throws IOException {
		 String URL=flib.getDataFrompropertiesFile("Vurl");
		
		 String USERNAME=flib.getDataFrompropertiesFile("Vusername");
		 String PASSWORD=flib.getDataFrompropertiesFile("Vpassword");
		 
		 
		 
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
		System.out.println("login");
	}
	

	
	
	
	@AfterMethod
	public void configAM() {
		
		HomePage hp= new HomePage(driver);
		hp.logout();
		System.out.println("logout");
	}
	
	
	@AfterClass
	public void configAC()
	{
		
		System.out.println("close the browser");
		driver.close();
	}	
	
	@AfterSuite
	public void configAS() throws SQLException
	{ 
		dlib.closeDbconnection();
		System.out.println("close DB, Report BackUp");
	}
	
	
}




