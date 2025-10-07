package ObjectRepositoryForScanario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	private WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver= driver;
		
		PageFactory.initElements( driver, this);
	}
	 
	@FindBy(xpath="//h4[text()='Laptop Links']")
	 private WebElement laptopLink;

	public void clickLaptop() { }

	
	 
	 
	 
}
