package scanario02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepositoryForScanario2.Homepage;



public class Blogspot_02 {
	WebDriver driver;
	
	@Test
	public void hpmepagescanario()
	
	 {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		
	Homepage hp = new Homepage(driver);
	
	hp.clickLaptop();
	
	
	
	}
	
	

}
