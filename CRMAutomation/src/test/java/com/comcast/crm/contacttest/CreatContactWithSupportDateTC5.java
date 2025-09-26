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

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreatContactWithSupportDateTC5 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Create Contact With Support Date
		//lilbit a tricky program coz every time current system date is need to fetch
		//know some java code to 
        // one condition is there in requirement that support date should be 30 days from the current date
		
		
		
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

		
		 // generate random number 
		Random random= new Random();
		int randomint= random.nextInt(1000);

		
		  FileInputStream fis1= new
		  FileInputStream("./testdata/Vorg.xlsx");
		  Workbook wb =WorkbookFactory.create(fis1); Sheet sh = wb.getSheet("org");
		  
		  Row row = sh.getRow(1);
		  Cell cel = row.getCell(2);
		 
		  String cntctname = cel.toString()+randomint ;
		  JavaUtility jlib = new JavaUtility();
		 String startdate= jlib.getSystemDateYYYYDDMM();
		 String enddaterequied = jlib.getRequiredDateYYYYDDMM(30);
		 
		 
			/*
			 * //get the current date and required date first Date dateobj =new Date();
			 * SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd") ; String startdate
			 * = sim.format(dateobj); System.out.println(startdate );
			 * 
			 * Calendar cal = sim.getCalendar(); cal.add(Calendar . DAY_OF_MONTH,30); String
			 * enddaterequied = sim.format(cal.getTime());
			 * System.out.println(enddaterequied);
			 */
		  //go to contact  module 
		  //click on +sign
		  //fill the last name
		  
		  
		  d.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
		  d.findElement(By.name("lastname")).sendKeys(cntctname);
		  
		   //locate for the support start date
		  d.findElement(By.name("support_start_date")).clear();
		  d.findElement(By.name("support_start_date")).sendKeys(startdate);
		  
		  //locate for support end date
		  d.findElement(By.name("support_end_date")).clear();
		  d.findElement(By.name("support_end_date")).sendKeys(enddaterequied);
		  
		  d.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			 
			 
			 //verify Header contact  info Expected Result
				String headercntctName= d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					 
					 
				 if(headercntctName.contains(cntctname)) {
					 System.out.println( " contact is created n pass");
				 } else {
					 System.out.println("Test is fail");
				 }
				 
				 // varify actual startdate n start date same actual end date and end date
		   String showindStartdate = d.findElement(By.id("dtlview_Support Start Date")).getText();
		   if(showindStartdate.equals(startdate)) {
		   System.out.println(showindStartdate + "is showing a valid date");}
		   else {
			   System.out.println("Showing startdate is not a valid date ");
		   }
		   
		   String showingenddate = d.findElement(By.id("dtlview_Support End Date")).getText();
		  if (showingenddate.equals(enddaterequied)) 
		  {
			  System.out.println(showingenddate +  "showing end date is a valid date");
		  } else {System.out.println("Showing enddate is not a valid date ");
			  
		  }
		  d.close();
	}

}// alhumdullilah all pass
