package PracticeTestNG;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class GetProductInfoWithDataProviderTest {
	@Test
	public void  getProductInfoTest() {
		
		WebDriver driver = new  ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get("http://www.flipkart.com");
		
		
		
		
		//search product program
		driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
		
		
		//driver.findElement(By.id("nav-search-submit-button")).click();
		
		//capture product info
		//String x= "(//span[text()='Apple iPhone 15 (128 GB) - Blue'])[1]/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span/span[2]/span[2]";
		
		String x="//div[text()='Apple iPhone 16 (Black, 128 GB)']/../../div[2]/div[1]/div[1]/div[1]";
		String Price=driver.findElement(By.xpath(x)).getText();
		System.out.println(Price);
		
		
		
		
		
		
		
		
	}

}
