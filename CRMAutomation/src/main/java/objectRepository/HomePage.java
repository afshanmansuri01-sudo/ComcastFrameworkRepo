package objectRepository;
/**
 * 
 * @author Afshan Shaikh Mansuri
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {// this is step no 3 but creating a constructor foe initialization
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath= "//a[@href='index.php?module=Accounts&action=index']") //step 2 object creation 
	private WebElement orgLink;
	
	@FindBy(linkText= "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText= "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText= "More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	 
	@FindBy(linkText="Sign Out")
	private WebElement singoutlink;
	
	//step 3 initialise object or create a constructor
    //step 4 achive encapsulation by getters method 
	
	
	
	
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getSingoutlink() {
		return singoutlink;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	
	
	//step 5 business library is not required because we clicking only on organization link.
	// but here we have added campaign also so for that we need to add business library 
	
	public void navigateToCampaginPage() {// before click on the campaign we need to mousehover // this is a business libraryy
		
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		
		campaignsLink.click();
	}
	
	/**
	 * login to app based on username ans password and url arguments
	 * @paramurl
	 * @param username 
	 *@param password
	 * @author Afshan Shaikh Mansuri
	 */
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singoutlink.click();
	}

	
	

}
