package coadingStandard;
/**
 *test class for contact module
 * 
 * @author Afshan
 * 
 */

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import objectRepository.LoginPage;


public class SearchContactTest  {
	/**
	 * scanario login()==. navigate contact
	 * 
	 */
@Test
public void searchContact() {
WebDriver driver = null;

/*step 1 login*/
LoginPage lp = new LoginPage(driver);
lp.loginToApp(null, null);

}

}
