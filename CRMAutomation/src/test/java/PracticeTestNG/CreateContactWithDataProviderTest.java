package PracticeTestNG;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithDataProviderTest {
	@Test (dataProvider ="empDetails")
	public void readDataFromDataProvider(String firstName,String status) {
		System.out.println("First Name:"+firstName +"Status:"+status);
		
	}
	
	@DataProvider(name= "empDetails")
	public Object[][] getdata() {
		Object[] [] objarr= new Object[3] [2];
		objarr[0] [0] ="Ayman" ;
		objarr[0] [1] ="Head" ;
		objarr[1] [0] ="Aayat" ;
		
		objarr[1] [1] ="sr" ;
	    objarr[2] [0] ="Anzal" ;
		objarr[2] [1] ="jr" ;
		return objarr;
		
		}
	

}
