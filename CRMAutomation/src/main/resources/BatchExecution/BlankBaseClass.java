package BatchExecution;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BlankBaseClass {
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("++++=====connect to DB,Report Config=====+++++");
		
	}
	
	
	
	
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("Launch the browser");}

		
	@BeforeMethod
	public void configBM() throws IOException {
		
		System.out.println("login");
	}

	
	
	@AfterMethod
	public void configAM() {
		
		
		System.out.println("logout");
	}
	
	
	@AfterClass
	public void configAC()
	{
		
		System.out.println("close the browser");
	}
		
	
	@AfterSuite
	public void configAS() throws SQLException
	{ 
		
		System.out.println("close DB, Report BackUp");
	}
	
	






}



