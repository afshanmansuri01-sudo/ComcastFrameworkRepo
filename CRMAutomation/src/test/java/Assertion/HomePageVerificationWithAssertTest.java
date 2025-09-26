package Assertion;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationWithAssertTest {
	//scenario 1.== verify the Home Page of application
		//scenario 2.== verify the logo of home page
		
		@Test
		public void homePageTest(Method mtd) {
			
			System.out.println(mtd.getName()+ "Test Start");
			String expectedPage= "Home page";//first testcase should fail because expected page is different
			
			//@@@@@@@@@***********	NOTE**********@@@@@@@@@@//
			//
			//
			//With the help of java if else this test will show as pass as flow of program will be pass but actual script was not pass 
			// this is why we are using assert for actual compairtion 
			
			
			
			
			
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(" http://49.249.28.218:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
			
			
			//Hard Assert
			Assert.assertEquals(actTitle, expectedPage);
			
			driver.close();
			
			System.out.println(mtd.getName()+ "Test End");
		

	}
		@Test
		public void verifyLogohomePageTest(Method mtd) {
			System.out.println(mtd.getName()+ "Test Start");
			
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(" http://49.249.28.218:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
			
			
			//Hard Assert,..y
			 Assert.assertTrue(status);//this method will accept only boolen data
			//Assert.assertEquals(true, status);//will work same
			driver.close();
			
			System.out.println(mtd.getName()+ "Test End");
	
	}
}
