package PracticeTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoWithDataProviderAndDynamicXpathTest {
	@Test(dataProvider="productDetails")
	public void  getProductInfoTest(String brandName, String productName) {
		
		WebDriver driver = new  ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get("http://www.flipkart.com");
		
		
		
		//search product program
		driver.findElement(By.name("q")).sendKeys(brandName,Keys.ENTER);
		
		
		//driver.findElement(By.id("nav-search-submit-button")).click();
		
		//capture product info
		
		
		String x= "//div[text()='"+productName+"']/../../div[2]/div[1]/div[1]/div[1]";
		String Price=driver.findElement(By.xpath(x)).getText();
		System.out.println(Price);
		
		driver.close();
		
		}
	      
	
		
		@DataProvider(name= "productDetails")
		public Object[][] getdata() {
			Object[] [] objarr= new Object[3] [2];
			objarr[0] [0] ="iphone" ;
			objarr[0] [1] ="Apple iPhone 16 (Black, 128 GB)" ;
			
			objarr[1] [0] ="iphone" ;
			objarr[1] [1] ="Apple iPhone 13 (Midnight, 128 GB)" ;
			
		    objarr[2] [0] ="iphone" ;
			objarr[2] [1] ="Apple iPhone 14 (Starlight, 128 GB)" ;
			return objarr;
		
		
		
		
		//limitation 1. of this program is openong the browser is againg and again 
			//2. we need to store out test data in excel coz it may be laegr in amount n data provider is usefull for small amount
			//*************go for excel with new sheet ***************//
		
		
		
		
		
		
		
		

}}
