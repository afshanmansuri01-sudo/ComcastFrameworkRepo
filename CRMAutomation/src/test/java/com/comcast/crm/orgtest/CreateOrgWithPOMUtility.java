package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPgae;

public class CreateOrgWithPOMUtility {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// create object 
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		
//read common data from properties file
		String BROWSER = flib.getDataFrompropertiesFile("Vbrowser");
		String URL = flib.getDataFrompropertiesFile("Vurl");
		String USERNAME = flib.getDataFrompropertiesFile("Vusername");
		String PASSWORD = flib.getDataFrompropertiesFile("Vpassword");
		
		
		
		//read testscript data frm excel file
		String  orgname = elib.getDataFromExcel("Sheet1", 1, 2)+jlib.getRandomNumber();
		
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome") ) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
			}else if (BROWSER.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}else {
				driver = new ChromeDriver();}
		
		// step 1 : login to the app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//erlier this line was thereLoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		//now contructor we are going to create
		LoginPage lp = new LoginPage(driver);
		
		
		/*
		 * // step 2 : object creation LoginPage lp = PageFactory.initElements(driver,
		 * LoginPage.class); lp.getUsernameEdt().sendKeys("admin");//erlier befor
		 * encapsulation lp.UsernameEdt().sendKeys("admin");
		 * lp.getPasswordEdt().sendKeys("admin");//erlier
		 * lp.PasswordEdt().sendKeys("admin"); lp.getLoginbtn().click(); //erlier
		 * lp.Loginbtn().click();
		 * 
		 */
		 
		 //for step nu 5  also known as business method
		// LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		 lp.loginToApp(URL,USERNAME, PASSWORD); //step no1  complete here as log in to app
		 
		 
		 //step 2: navigate to the organization module 
		
		 HomePage hp = new HomePage(driver);
		 
		//why we are creating homePage object here just because organization module is present on home page 
		 
		 hp.getOrgLink().click(); // here only action is required so no need to create any business method 
		 //if u want to navigate to te campaign module the use  method like---
	      //hp.navigateToCampaginPage();
		
		 //step3 click on "create organization" button 
		 // as create organization + sign is present on organization module so create 1 pom page as organiation page 
		 
		 OrganizationsPgae cnp= new OrganizationsPgae(driver);
		 cnp.getCreateNewOrgBtn().click();
		 
		 //step 4 enter all the details & create new Organization
		 
		 CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver );
		 cnop.createOrg(orgname);
		 
		 //verify Header msg Expected result
		 //for this step we need to go to organization info page as pom
		 OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		  String actOrgName= oip.getHeaderMsg().getText();
		 
		 if (actOrgName.contains(orgname)) {
			 System.out.println(orgname +"name is verified == pass");
		 }else {
			 System.out.println(orgname +"name is not verified == fail");
		 }
		 
		 
		 //step5 logout
		 //logout is available on all the pages so we can add it on home page 
		 hp.logout();
		 driver.quit();
		 
	}  

}
