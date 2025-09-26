package GroupExecution;


import org.testng.annotations.Test;


public class CreateContactTestWithBlankBaseClass extends BlankBaseClass {
	
@Test(groups="SmokeTesting")
public void createContact() {
	System.out.println("execute create contact and verify");

}
	
@Test(groups= "RegressionTesting")
public void createContactWithDate() {
	System.out.println("execute create contact with date and verify");

}
	
	
	
	

}
