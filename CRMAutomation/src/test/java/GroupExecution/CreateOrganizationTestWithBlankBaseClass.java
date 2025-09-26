package GroupExecution;


import org.testng.annotations.Test;

public class CreateOrganizationTestWithBlankBaseClass extends BlankBaseClass {
	
	
@Test(groups="SmokeTesting")
public void createOrgTest() {
	System.out.println("execute create org and verify ");

}
	
@Test(groups="RegressionTesting")
public void createorgWithIndustry() {
	System.out.println("execute create ORG with industry and verify");

}
	
	
}



