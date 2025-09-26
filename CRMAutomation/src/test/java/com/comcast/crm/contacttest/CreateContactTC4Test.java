package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactTC4Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		// navigate to the aap
		// create contact
		// save
		// varify the contact name and print
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
			System.out.println(alert.getText()); // Just to check the popup message
			alert.accept(); // Clicks OK
		} catch (Exception e) {
			System.out.println("No alert present after login.");
		}

		d.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		 // generate random number 
		Random random= new Random();
		int randomint= random.nextInt(1000);

		
		  FileInputStream fis1= new
		  FileInputStream("./testdata/Vorg.xlsx");
		  Workbook wb =WorkbookFactory.create(fis1); Sheet sh = wb.getSheet("org");
		  
		  Row row = sh.getRow(1);
		  Cell cel = row.getCell(2);
		 
		  String cntctname = cel.toString()+randomint ;
		  d.findElement(By.name("lastname")).sendKeys(cntctname);
		  
		  Cell cel1 = row.getCell(3);
		  long mobilenu = (long)cel1.getNumericCellValue();
		  
		 System.out.println(cntctname);
		 System.out.println(mobilenu);

		 
		
		 d.findElement(By.id("mobile")).sendKeys( String.valueOf(mobilenu));
		 
		 d.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		 
		 
		 //verify Header contact  info Expected Result
			String headercntctName= d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 
				 
			 if(headercntctName.contains(cntctname)) {
				 System.out.println( " contact is created n pass");
			 } else {
				 System.out.println("Test is fail");
			 }
		 
		 
		 
		 
	}

}
// alhumdullilah all pass