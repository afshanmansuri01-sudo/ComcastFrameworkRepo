package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

public class VerifyDropDownOptions {

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
		 
		 FileInputStream fis1= new FileInputStream("./testdata/Vorg.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
		 Sheet sh = wb.getSheet("org");
		 
		 Row row = sh.getRow(1);
		Cell cel = row.getCell(2);
		
		String orgname = cel.toString();
		 
		 
		
		 
		 d.findElement(By.name("accountname")).sendKeys(orgname);
		 
		Select s = new Select( d.findElement(By.name("industry")));
		 s.selectByValue("Finance");
		 
		 Select s1 = new Select( d.findElement(By.name("accounttype")));
		 s1.selectByValue("Investor");
		 
		 d.findElement(By.name("button")).click();
		 
			 
		 
		 
		 
			 
		 //verify the industry and investor dropdown options
		
		 String dropdown1   = d.findElement(By.name("industry")).getText(); 
		 if(dropdown1.equals("Finance")) {
			 System.out.println( " option is assingned as finance");
		 } else {
			 System.out.println("assigning is fail");
		 }
		
		 String dropdown2   = d.findElement(By.name("accounttype")).getText(); 
		 if(dropdown2.equals("Investor")) {
			 System.out.println("option is assingned as finance");
		 } else {
			 System.out.println("assigning is fail");
		 }
		
	}




	}

//empty program just to understand


