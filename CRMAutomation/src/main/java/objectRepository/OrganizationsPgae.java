package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPgae {
	WebDriver driver;
	public OrganizationsPgae(WebDriver driver) {// this is step no 3 but creating a constructor foe initialization
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	
	@FindBy(name="submit")
	private WebElement searchnowEdt;
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	public WebElement getSearchnowEdt() {
		return searchnowEdt;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
	//all though we only need to click on create organization btn here so no need any thing else here
	 //but need  to click on search baar n dropdown so adding here(added)
	
	

}
