package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetExc 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	 FileInputStream fis1= new FileInputStream("");
	 Workbook wb = WorkbookFactory.create(fis1);
	 Sheet sh = wb.getSheet("org");
	 
	 Row row = sh.getRow(1);
	Cell cel = row.getCell(2);
	
	String orgname = cel.toString();
	System.out.println(orgname);
}
}
