package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgWithPhoneNumber {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./configappData/Vcommondata.properties");
		Properties p = new Properties();
		p.load(fis);
		WebDriver d = new ChromeDriver();
		 String VURL = p.getProperty("Vurl");
		 String VUSERNAME = p.getProperty("Vusername");
		 String VPASSWORD = p.getProperty("Vpassword");
		d.get(VURL);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		 
		 FileInputStream fis1= new FileInputStream("./testdata/Vdata2.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
		 Sheet sh = wb.getSheet("Sheet1");//sheet name is case sensitive be careful always
		 
		 Row row = sh.getRow(7);
		Cell cel = row.getCell(2);
		String orgname = cel.toString();
		
		//String phnno = row.getCell(3).toString();// getstringcellvalue in order to intract with numerical value
		
		
		
		
		 //************* how to read numeric value from Excel sheet important*************//
		long phn = (long) row.getCell(3).getNumericCellValue();
		String phnno = String.valueOf(phn);
		
		if (phnno.equals("9999999990") ) {
			System.out.println(" Enterd phone number is valid");
		}else {
			System.out.println("Entered phone number is not valid");
		}
		
		
		
		
		d.findElement(By.name("accountname")).sendKeys(orgname);
		
		d.findElement(By.id("phone")).sendKeys(phnno);
		
		 
		 
		wb.close();
		fis.close();
		fis1.close();
		 
		
		 
		 
		
}

		
	}


