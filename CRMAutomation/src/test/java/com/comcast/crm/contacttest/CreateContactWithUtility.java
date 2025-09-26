package com.comcast.crm.contacttest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithUtility {

	

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		//create object of fileutility
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		
		String VBROWSER = flib.getDataFrompropertiesFile("Vbrowser");
		String VURL = flib.getDataFrompropertiesFile("Vurl");
		String VUSERNAME = flib.getDataFrompropertiesFile("Vusername");
		String VPASSWORD = flib.getDataFrompropertiesFile("Vpassword");
		 
		WebDriver d = null;
		if ( VBROWSER.equals("chrome")) {
			d=new ChromeDriver();
		}else if (VBROWSER.equals("firefox")) {
			d=new FirefoxDriver();
		}else if (VBROWSER.equals("edge")) {
			d=new EdgeDriver();}
		
		
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

		/*
		 * d.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		 * d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 */
		
		 // generate random number 
		Random random= new Random();
		int randomint= random.nextInt(1000);

		//get data from Excel file
		
		String  lastname = elib.getDataFromExcel("Sheet1",7, 2)  + jlib.getRandomNumber();
		String phone = elib.getDataFromExcel("Sheet1", 7, 3);  
		long phoneNum = (long) Double.parseDouble(phone);
		
		
		
		d.findElement(By.linkText("Contacts")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		d.findElement(By.name("lastname")).sendKeys(lastname);
		d.close();
		//
		
		
		
		//how to fetch the numeric value 
		
		//d.findElement(By.id("mobile")).sendKeys(String.valueOf( phoneNum));
		//d.findElement(By.name("button")).click();
		
		 /*d.findElement(By.id("mobile")).sendKeys( String.valueOf(mobilenu));
		 
		 d.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		 */
		 
		 //verify Header contact  info Expected Result
			/*String headercntctName= d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 
				 
			 if(headercntctName.contains(cntctname)) {
				 System.out.println( " contact is created n pass");
			 } else {
				 System.out.println("Test is fail");
			 }*/
		 
		 //@*******************@@@@@ working fine Alhumdullialah @@@@@***************@//
		 
		 
	}




	}


