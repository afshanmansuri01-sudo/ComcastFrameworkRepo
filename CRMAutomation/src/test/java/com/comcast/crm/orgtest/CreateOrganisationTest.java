package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganisationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//first we need to know about the common data nad testdata.
		// same etime we need to know the testdata also 
		
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
		 
		 Row row = sh.getRow(3);
		Cell cel = row.getCell(1);
		
		String orgname = cel.toString();
		 String lname = row.getCell(2).toString();
		 
		 double mobnu = row.getCell(3).getNumericCellValue();
		 
		
		 d.findElement(By.name("accountname")).sendKeys(orgname);
		 
		d.findElement(By.name("button")).click();
		 
			 d.findElement(By.linkText("More Information")).click();
		 d.findElement(By.xpath("//input[@value='Add Contact']")).click();
		 
		  WebElement  lastname1 = d.findElement(By.name("lastname"));
		  lastname1.sendKeys(lname);
			 
		  String mobStr = String.valueOf((long) mobnu);          // convert double → long → String
		  WebElement mobilenu = d.findElement(By.id("mobile"));  // locate input field
		  mobilenu.sendKeys(mobStr);                             // type mobile number
		 
	}

}
