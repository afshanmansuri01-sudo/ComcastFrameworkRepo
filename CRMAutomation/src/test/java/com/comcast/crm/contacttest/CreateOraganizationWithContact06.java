package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOraganizationWithContact06 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		// whenever we are performing integrated testing preconditions aremuch more important.
		//here pre condition is Atleast one Oraganization should be created
		//chances are there on which date u r  performing automation so it may not reflect on testing environment.....so
		//always fulfill preconditions so that full integration should be there in test env also
		
		// here we can also use JDBC (here we r not using JDBC)
		
		FileInputStream fis = new FileInputStream("./configappData/Vcommondata.properties");
		Properties p = new Properties();
		p.load(fis);
		WebDriver d = new ChromeDriver();
		 String VURL = p.getProperty("Vurl");
		 String VUSERNAME = p.getProperty("Vusername");
		 String VPASSWORD = p.getProperty("Vpassword");
		d.get(VURL);
		 d.findElement(By.name("user_name")).sendKeys(VUSERNAME);
		
		 d.findElement(By.name("user_password")).sendKeys(VPASSWORD);
		 d.findElement(By.id("submitButton")).click();
		
		// Switch to Alert
		 try {
		     org.openqa.selenium.Alert alert = d.switchTo().alert();
		     System.out.println(alert.getText());  // Just to check the popup message
		     alert.accept(); // Clicks OK
		 } catch (Exception e) {
		     System.out.println("No alert present after login.");
		 }
		 
		 d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		 d.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		 Random random = new Random();
		int randomint = random.nextInt();
		 
		 FileInputStream fis1= new FileInputStream("./testdata/Vorg.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
		 Sheet sh = wb.getSheet("org");
		 
		 Row row = sh.getRow(3);
		Cell cel = row.getCell(1);
		
		String orgname = cel.toString()+randomint;
		 
		 
		
		 
		 d.findElement(By.name("accountname")).sendKeys(orgname);
		 d.findElement(By.name("button")).click();
		 
		 
		 
		 // verify header msg expected result
		String  HeaderInfo = d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText(); 
		 if(HeaderInfo.contains(orgname)) {
			 System.out.println(orgname+ "is created pass");
		 } else {
			 System.out.println("Test is fail");
		 }
			 
		
			 //verify Header orgname info Expected Result
		String actualorgName= d.findElement(By.id("dtlview_Organization")).getText();
			 System.out.println(actualorgName + "is actual org name.");
		 if(actualorgName.contains(orgname)) 
		 {
			 System.out.println(orgname+ "is created pass");
		 } else {
			 System.out.println("Test is fail");
		 }
			 
		
		
		
	}

}
