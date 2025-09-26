package PracticeTestNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoWithDataProviderAndDynamicXpathWithExcelTest {
	
	
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
		public Object[][] getdata() throws EncryptedDocumentException, IOException {
			
			ExcelUtility elib= new ExcelUtility();
			int rowcount = elib.getRowCount("Product");
			System.out.println(rowcount);
			
			
			Object[] [] objarr= new Object[rowcount-1] [2];
			
			for(int i=0; i<rowcount-1;i++) {
			objarr[i] [0] =elib.getDataFromExcel("Product", i+1, 0) ;
			objarr[i] [1] = elib.getDataFromExcel("Product", i+1, 1);
			
			
		
			}
			return objarr;
		
		
		
		//limitation 1. of this program is opening the browser is again and again 
			//2. we need to store out test data in excel coz it may be lager in amount n data provider is useful for small amount
			//*************go for excel with new sheet to pass data  into data provider ***************//
		
		
		
		
		
		
		
		

}

}
