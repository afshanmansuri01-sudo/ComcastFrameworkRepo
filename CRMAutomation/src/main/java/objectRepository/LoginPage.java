  package objectRepository;
/**
 * contains login page elements and business libary like login. 
 * 
 * @author Afshan
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver= null;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
 
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtnEdt;
	
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtnEdt() {
		return loginbtnEdt;
	}
	
	/**
	 * 
	 * login to app based on username ans password and url arguments
	 * @param url
	 * @author Afshan Shaikh Mansuri
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password) {
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys( password);
		loginbtnEdt.click();
		
	}
	
	
	
	
	
}
