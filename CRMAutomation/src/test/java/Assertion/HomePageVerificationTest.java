package Assertion;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
	
	//scenario 1.== verify the Home Page of application
	//scenario 2.== verify the logo of home page
	
	@Test
	public void homePageTest(Method mtd) {
		
		System.out.println(mtd.getName()+ "Test Start");
		String expectedPage= "Home";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(" http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		if(actTitle.trim().equals(expectedPage)) {
			System.out.println(expectedPage  +" page is verified== pass");
			
		}else {
			System.out.println(expectedPage  +" page is not verified== fail");
			
		}
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
		
		if( status) {
			System.out.println("logo is verified==pass");
			
		}else {
			System.out.println("logo is not verified==fail");
			
		}
		System.out.println(mtd.getName()+ "Test End");
}
}