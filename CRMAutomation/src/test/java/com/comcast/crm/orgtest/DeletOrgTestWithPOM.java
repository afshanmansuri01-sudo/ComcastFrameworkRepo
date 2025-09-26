package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPgae;

public class DeletOrgTestWithPOM {
	public static void main(String [] args) throws EncryptedDocumentException, IOException {
		// create object 
				FileUtility flib = new FileUtility();
				ExcelUtility elib = new ExcelUtility();
				JavaUtility jlib = new JavaUtility();
				WebDriverUtility wdlib= new WebDriverUtility();
				
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
	             
				 //go back to Organization Page
				 HomePage hp1 = new HomePage(driver);
				 hp1.getOrgLink().click();
				 
				 //search for Organization(for that we have not added the search baar and dropdown.
				 //before proceeding we need to add in ouyr repository first.in Organization page)
				 
				 OrganizationsPgae op = new OrganizationsPgae(driver);
				 op.getSearchEdt().sendKeys(orgname);
				 wdlib.Select(op.getSearchDD(), "Organization Name");
				 op.getSearchnowEdt().click();
				 
				 //step next is to delet the selected table 
				 
				// driver.findElement(By.xpath("//a[text()='Mee Mumbaikar07']/../..//a[text()='del']")).click();
				 //this is the static xpath for the MeeMumbaikar07 , n i hv to make it dynamic so what to do...
				 
				 driver.findElement(By.xpath("//a[text()='"+orgname+"']/../..//a[text()='del']")).click();
				 //here we just concatanate the org variable it is dynamic xpath for delet the specific dynamic element
				 
				 // handle the alert 
				 
				 wdlib.switchtoAlertAndCancle(driver) ;
				 
				 //next step Logout
				 hp.logout();
				  driver.quit();
				  
				 
				// alhumdullilah 
				 
	}

}
