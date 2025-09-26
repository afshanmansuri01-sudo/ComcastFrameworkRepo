package GroupExecution;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BlankBaseClass {
	@BeforeSuite(groups= {"SmokeTesting,RegressionTesting"})
	public void configBS() throws SQLException {
		System.out.println("++++=====connect to DB,Report Config=====+++++");
		
	}
	
	
	
	
	@BeforeClass(groups= {"SmokeTesting,RegressionTesting"})
	public void configBC() throws IOException {
		System.out.println("Launch the browser");}

		
	@BeforeMethod(groups= {"SmokeTesting,RegressionTesting"})
	public void configBM() throws IOException {
		
		System.out.println("login");
	}

	
	
	@AfterMethod(groups= {"SmokeTesting,RegressionTesting"})
	public void configAM() {
		
		
		System.out.println("logout");
	}
	
	
	@AfterClass(groups= {"SmokeTesting,RegressionTesting"})
	public void configAC()
	{
		
		System.out.println("close the browser");
	}
		
	
	@AfterSuite(groups= {"SmokeTesting,RegressionTesting"})
	public void configAS() throws SQLException
	{ 
		
		System.out.println("close DB, Report BackUp");
	}
	
	






}



