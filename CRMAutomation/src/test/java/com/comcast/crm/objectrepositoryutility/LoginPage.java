package com.comcast.crm.objectrepositoryutility;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility



{   //rule nu 1 create a  separate java class
	
	
	//ruleno. 1  create a class with same name as page name like wise create 4 more class  as home page
	//ruleno. 2  object creation
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {  //rule nu 3object inialization 
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//here we r creating private webelement inorder to restrict direct access n also we shold keep in mind that not to disturb these  
	@FindBy(name="user_name")                                  //rule nu 2 object creation 
	private //erlier it was public 
	WebElement usernameEdt;
	
	@FindBy(name="user_password")
	 private //erlier it was public
	WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private //erlier it was public
	WebElement loginbtn;
	
	
	
	
	//rule no 3 object initialization
	// initialization is taking place in testscript only why because,
	//in automation we will create the constructor it will handle the initialization.
	
	//LoginPage lp = pagefactory.initElements(driver,LoginPage.class); this line is responsible for initialization 
	
	//so in stead of that line we will create on e constructor here in script 
		// rule no 4 object encapsulation 
	
	
	

	public WebElement getUsernameEdt() { //rule nu 4 encapsulation 
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	// rule no5  provide action 
	public void loginToApp(String url, String username, String password) { // rule nu 5 utilization of object
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		
		// instead of wriiting code for implicitly wait we can extend the webdriverutility and directly we call the method
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.get(url);
			usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginbtn.click();
	
}}
